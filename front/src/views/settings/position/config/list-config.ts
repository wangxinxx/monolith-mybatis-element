import type { VxeGridPropTypes, VxeGridProps } from 'vxe-table/types/grid';
import apiService from '@/api/index';

// begcode-please-regenerate-this-file 如果您不希望重新生成代码时被覆盖，将please修改为don't ！！！-->

const positionService = apiService.settings.positionService;
const relationshipApis: any = {
  users: apiService.system.userService.retrieve,
};

const searchForm = (): any[] => [
  {
    title: 'ID',
    field: 'id',
    componentType: 'Text',
    value: '',
    type: 'Long',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '岗位代码',
    field: 'code',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '名称',
    field: 'name',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '排序',
    field: 'sortNo',
    componentType: 'Text',
    value: '',
    type: 'Integer',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '描述',
    field: 'description',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '员工列表',
    field: 'users',
    componentType: 'ESelect',
    value: '',
    operator: '',
    span: 8,
    componentProps: { api: null, style: 'width: 100%', valueField: 'id', labelField: 'firstName' },
  },
];

const columns = (): VxeGridPropTypes.Columns => [
  {
    fixed: 'left',
    type: 'checkbox',
    width: 60,
  },
  {
    title: 'ID',
    field: 'id',
    minWidth: 80,
    visible: true,
    treeNode: false,
    params: { type: 'LONG' },
    editRender: { name: 'EInputNumber', enabled: false, props: { controls: false } },
  },
  {
    title: '岗位代码',
    field: 'code',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '名称',
    field: 'name',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '排序',
    field: 'sortNo',
    minWidth: 80,
    visible: true,
    treeNode: false,
    params: { type: 'INTEGER' },
    titlePrefix: { icon: 'vxe-icon-sort', content: '排序操作列' },
    editRender: { name: 'EDragSort', enabled: false, props: { remoteApi: positionService.updateSortValue } },
  },
  {
    title: '描述',
    field: 'description',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '员工列表',
    field: 'users',
    minWidth: 120,
    editRender: {
      name: 'ESelectModal',
      enabled: false,
      props: {
        showComponentName: 'Avatar',
        container: 'modal',
        componentName: 'UserList',
        multiple: true,
        style: { width: '100%' },
        gridCustomConfig: { hideColumns: ['department', 'position', 'authorities'] },
        queryNames: ['positionId'],
        avatarSlotName: 'default',
        avatarSlotField: 'firstName',
        avatarTipField: 'firstName',
        rowIdField: 'row.id',
        source: 'Position',
      },
    },
  },
  {
    title: '操作',
    field: 'operation',
    fixed: 'right',
    width: 160,
    slots: { default: 'recordAction' },
  },
];

const baseGridOptions = (): VxeGridProps => {
  return {
    rowConfig: {
      keyField: 'id',
      isHover: true,
    },
    border: true,
    showHeaderOverflow: true,
    showOverflow: true,
    keepSource: true,
    id: 'full_edit_1',
    height: 600,
    printConfig: {
      columns: [
        // { field: 'name' },
      ],
    },
    filterConfig: {
      remote: true,
    },
    columnConfig: {
      resizable: true,
    },
    sortConfig: {
      trigger: 'cell',
      remote: true,
      orders: ['asc', 'desc', null],
      multiple: true,
      defaultSort: {
        field: 'id',
        order: 'desc',
      },
    },
    pagerConfig: {
      layouts: ['Sizes', 'PrevJump', 'PrevPage', 'Number', 'NextPage', 'NextJump', 'FullJump', 'Total'],
      pageSize: 15,
      pageSizes: [5, 10, 15, 20, 30, 50],
      total: 0,
      pagerCount: 5,
      currentPage: 1,
    },
    importConfig: {},
    exportConfig: {},
    checkboxConfig: {
      // labelField: 'id',
      reserve: true,
      highlight: true,
    },
    editRules: {},
    editConfig: {
      enabled: true,
      trigger: 'click',
      mode: 'cell',
      showStatus: true,
    },
  };
};

export default {
  searchForm,
  columns,
  baseGridOptions,
};
