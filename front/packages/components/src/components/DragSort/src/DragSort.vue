<template>
  <div class="j-vxe-drag-box" style="display: flex; align-items: center; justify-content: space-between">
    <span class="drag-btn" style="cursor: move"> <Icon icon="ant-design:holder-outlined" /></span>
    <ElPopover placement="top-start" trigger="click" :visible="open" title="编辑排序值">
      <template #reference>
        <ElInput :value="inputValue" :bordered="false" :readonly="true" style="text-align: center">
          <template #addonAfter v-if="!disabled">
            <Icon icon="ant-design:edit-outlined" @click="openPopover" />
          </template>
        </ElInput>
      </template>
      <ElRow justify="space-around" align="middle">
        <ElCol :span="14"><ElInputNumber v-model:value="inputValue" style="display: inline-block" /></ElCol>
        <ElCol :span="10">
          <ElButton type="primary" size="small" style="display: inline-block; margin-left: 10px" @click="closePopover(true)">确定</ElButton>
          <ElButton size="small" style="display: inline-block; margin-left: 10px" @click="closePopover(false)">取消</ElButton>
        </ElCol>
      </ElRow>
    </ElPopover>
    <span>
      <ElDropdown trigger="click" @command="handleCommand">
        <span><Icon icon="mi:drag" /></span>
        <template #dropdown>
          <ElDropdownMenu>
            <ElDropdownItem command="up" :disabled="disabledMoveUp">向上移</ElDropdownItem>
            <ElDropdownItem command="down" :disabled="disabledMoveDown">向下移</ElDropdownItem>
            <ElDropdownItem :divided="true" v-if="!disabled" />
            <ElDropdownItem command="insert" v-if="!disabled">插入一行</ElDropdownItem>
          </ElDropdownMenu>
        </template>
      </ElDropdown>
    </span>
  </div>
</template>

<script lang="ts" setup>
import { computed, nextTick, onMounted, onUnmounted, ref } from 'vue';
import { ElDropdown, ElDropdownMenu, ElDropdownItem, ElInput, ElPopover, ElButton, ElRow, ElCol, ElInputNumber } from 'element-plus';
import { Icon } from '@/components/Icon';
import Sortable from 'sortablejs';

defineOptions({
  name: 'DragSort',
  inheritAttrs: false,
});

const props = defineProps({
  type: {
    type: String,
    default: 'default',
  },
  params: {
    type: Object,
    default: () => ({}),
  },
  value: {
    type: Number,
    default: 0,
  },
  disabled: {
    type: Boolean,
    default: false,
  },
  remoteApi: {
    type: Function,
    default: null,
  },
});

const emit = defineEmits(['update:value']);

const inputValue = computed(() => {
  return props.value;
});

const open = ref(false);

let sortable2: Sortable;
let initTime: any;

const rowIndex = computed(() => props.params._rowIndex);
const fullDataLength = computed(() => props.params.$table.internalData.tableFullData.length);
const disabledMoveUp = computed(() => rowIndex.value === 0);
const disabledMoveDown = computed(() => rowIndex.value === fullDataLength.value - 1);

const openPopover = () => {
  open.value = true;
};
const closePopover = (update: boolean) => {
  if (update && inputValue.value !== props.value) {
    emit('update:value', props.value);
    if (props.remoteApi) {
      const row = props.params.row;
      const id = row.id;
      props.remoteApi(id, 'VALUE', inputValue.value).then(res => {
        console.log('更新完成', res);
      });
    } else {
      recalcSortNumber().then(res => {});
    }
  }
  open.value = false;
};

const trigger = (method, params) => {
  console.log('trigger', method, params);
};

/** 重新计算排序字段的数值 */
async function recalcSortNumber() {
  let xTable = props.params.$table;
  let sortKey = props.params.column.field;
  let sortBegin = 1;
  xTable.internalData.tableFullData.forEach((data: any) => (data[sortKey] = sortBegin++));
  await xTable.cacheRowMap();
  return await xTable.updateData();
}

/**
 * 排序表格
 * @param oldIndex
 * @param newIndex
 * @param force 强制排序
 */
async function doSort(oldIndex: number, newIndex: number, force = false) {
  let xTable = props.params.$table;
  let sort = array => {
    // 存储old数据，并删除该项
    let row = array.splice(oldIndex, 1)[0];
    // 向newIndex处添加old数据
    array.splice(newIndex, 0, row);
  };
  sort(xTable.internalData.tableFullData);
  if (xTable.keepSource) {
    sort(xTable.internalData.tableSourceData);
  }
  if (props.remoteApi) {
    let xTable = props.params.$table;
    let xGrid = props.params.$grid;
    const oldRow = xTable.getData(oldIndex);
    const newRow = xTable.getData(newIndex);
    const type = 'STEP';
    const id = oldRow.id;
    const beforeId = newRow.id;
    const result = await props.remoteApi(id, type, null, beforeId);
    await xGrid.commitProxy('reload');
    return result;
  } else {
    return await recalcSortNumber();
  }
}

/** 行重新排序 */
function rowResort(oldIndex: number, newIndex: number) {
  return doSort(oldIndex, newIndex, true);
}

/** 向上移 */
function handleRowMoveUp() {
  if (!disabledMoveUp.value) {
    rowResort(rowIndex.value, rowIndex.value - 1);
  }
}

/** 向下移 */
function handleRowMoveDown() {
  if (!disabledMoveDown.value) {
    rowResort(rowIndex.value, rowIndex.value + 1);
  }
}

/** 插入一行 */
function handleRowInsertDown() {
  trigger('rowInsertDown', rowIndex.value);
}

function createSortable() {
  let xTable = props.params.$table;
  let xGrid = props.params.$grid;
  let dom = props.params.$grid.getRefMaps().refTable.value.$el.querySelector('.body--wrapper>.vxe-table--body tbody');
  let startChildren = [];
  sortable2 = Sortable.create(dom as HTMLElement, {
    handle: '.drag-btn',
    direction: 'vertical',
    animation: 300,
    onStart(e) {
      let from = e.from;
      // @ts-ignore
      startChildren = [...from.children];
    },
    onEnd(e) {
      let oldIndex = e.oldIndex as number;
      let newIndex = e.newIndex as number;
      if (oldIndex === newIndex) {
        return;
      }
      let rowNode = xTable.getRowNode(e.item);
      if (!rowNode) {
        return;
      }
      let from = e.from;
      let element = startChildren[oldIndex];
      let target = null;
      if (oldIndex > newIndex) {
        // 向上移动
        if (oldIndex + 1 < startChildren.length) {
          target = startChildren[oldIndex + 1];
        }
      } else {
        // 向下移动
        target = startChildren[oldIndex + 1];
      }
      from.removeChild(element);
      from.insertBefore(element, target);
      nextTick(async () => {
        const diffIndex = rowNode!.index - oldIndex;
        if (diffIndex > 0) {
          oldIndex = oldIndex + diffIndex;
          newIndex = newIndex + diffIndex;
        }
        if (props.remoteApi) {
          const selfRow = xTable.getData(oldIndex);
          const targetRow = xTable.getData(newIndex);
          let type = 'DROP';
          const id = selfRow.id;
          let afterId = null;
          let beforeId = null;
          const { visibleData } = xTable.getTableData();
          if (newIndex === 0) {
            // 表示插入到第一个。
            // 如果第一个，只有afterId,
            afterId = targetRow.id;
          } else if (newIndex === visibleData.length - 1) {
            // 如果最后一个，只有beforeId,
            beforeId = targetRow.id;
          } else {
            beforeId = targetRow.id;
            const afterRow = xTable.getData(newIndex + 1);
            afterId = afterRow.id;
          }
          const addIndex = newIndex - oldIndex;

          if (Math.abs(addIndex) === 1) {
            if (addIndex < 0) {
              // 向上移动
              // 只传afterId
              beforeId = null;
            } else if (addIndex === 0) {
              // 未移动
            } else {
              // 向下移动
              // 只传beforeId
              afterId = null;
            }
            type = 'STEP';
            // 采用上下移动的方向调整
            await props.remoteApi(id, type, null, beforeId, afterId, null);
            await xGrid.commitProxy('reload');
          } else {
            // 获得涉及的其他id列表
            const ids: any[] = [];
            for (let i = newIndex; i < oldIndex; i = i + addIndex / addIndex) {
              const addRow = xTable.getData(i);
              ids.push(addRow.id);
            }
            await props.remoteApi(id, type, null, beforeId, afterId, { 'id.in': ids });
            await xGrid.commitProxy('reload');
          }
        } else {
          await recalcSortNumber();
        }
      });
    },
  });
}

const handleCommand = command => {
  switch (command) {
    case 'up':
      handleRowMoveUp();
      break;
    case 'down':
      handleRowMoveDown();
      break;
    case 'insert':
      handleRowInsertDown();
      break;
    default:
      console.log('未设定');
  }
};
onMounted(() => {
  // 加载完成之后再绑定拖动事件
  initTime = setTimeout(createSortable, 300);
});

onUnmounted(() => {
  clearTimeout(initTime);
  if (sortable2) {
    sortable2.destroy();
  }
});
</script>
