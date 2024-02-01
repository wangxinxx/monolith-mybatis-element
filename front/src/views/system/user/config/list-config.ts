import type { VxeGridPropTypes, VxeGridProps } from 'vxe-table/types/grid';
import dayjs from 'dayjs';
import apiService from '@/api/index';

// begcode-please-regenerate-this-file 如果您不希望重新生成代码时被覆盖，将please修改为don't ！！！-->

const userService = apiService.system.userService;
const relationshipApis: any = {
  department: apiService.settings.departmentService.tree,
  position: apiService.settings.positionService.retrieve,
  authorities: apiService.system.authorityService.tree,
};

const searchForm = (): any[] => [
  {
    title: '用户ID',
    field: 'id',
    componentType: 'Text',
    value: '',
    type: 'Long',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '账户名',
    field: 'login',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '名字',
    field: 'firstName',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '姓氏',
    field: 'lastName',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '电子邮箱',
    field: 'email',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '手机号码',
    field: 'mobile',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '出生日期',
    field: 'birthday',
    componentType: 'DateTime',
    operator: '',
    span: 8,
    type: 'ZonedDateTime',
    componentProps: { type: 'date', format: 'YYYY-MM-DD hh:mm:ss', style: 'width: 100%' },
  },
  {
    title: '激活状态',
    field: 'activated',
    componentType: 'Switch',
    value: '',
    operator: '',
    span: 8,
    type: 'Boolean',
    componentProps: {},
  },
  {
    title: '语言Key',
    field: 'langKey',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '头像地址',
    field: 'imageUrl',
    componentType: 'Text',
    value: '',
    type: 'String',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '创建者Id',
    field: 'createdBy',
    componentType: 'Text',
    value: '',
    type: 'Long',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '修改者Id',
    field: 'lastModifiedBy',
    componentType: 'Text',
    value: '',
    type: 'Long',
    operator: '',
    span: 8,
    componentProps: {},
  },
  {
    title: '部门',
    field: 'department',
    componentType: 'ESelect',
    value: '',
    operator: '',
    span: 8,
    componentProps: { api: null, style: 'width: 100%', valueField: 'id', labelField: 'name' },
  },
  {
    title: '岗位',
    field: 'position',
    componentType: 'ESelect',
    value: '',
    operator: '',
    span: 8,
    componentProps: { api: null, style: 'width: 100%', valueField: 'id', labelField: 'name' },
  },
  {
    title: '角色列表',
    field: 'authorities',
    componentType: 'ESelect',
    value: '',
    operator: '',
    span: 8,
    componentProps: { api: null, style: 'width: 100%', valueField: 'id', labelField: 'name' },
  },
];

const columns = (): VxeGridPropTypes.Columns => [
  {
    fixed: 'left',
    type: 'checkbox',
    width: 60,
  },
  {
    title: '用户ID',
    field: 'id',
    minWidth: 80,
    visible: true,
    treeNode: false,
    params: { type: 'LONG' },
    editRender: { name: 'EInputNumber', enabled: false, props: { controls: false } },
  },
  {
    title: '账户名',
    field: 'login',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '名字',
    field: 'firstName',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '姓氏',
    field: 'lastName',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '电子邮箱',
    field: 'email',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '手机号码',
    field: 'mobile',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '出生日期',
    field: 'birthday',
    minWidth: 140,
    visible: true,
    treeNode: false,
    params: { type: 'ZONED_DATE_TIME' },
    formatter: ({ cellValue }) => (cellValue ? dayjs(cellValue).format('YYYY-MM-DD hh:mm:ss') : ''),
  },
  {
    title: '激活状态',
    field: 'activated',
    minWidth: 70,
    visible: true,
    treeNode: false,
    params: { type: 'BOOLEAN' },
    cellRender: { name: 'ESwitch', props: { disabled: false } },
  },
  {
    title: '语言Key',
    field: 'langKey',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    editRender: { name: 'EInput', enabled: false },
  },
  {
    title: '头像地址',
    field: 'imageUrl',
    minWidth: 160,
    visible: true,
    treeNode: false,
    params: { type: 'STRING' },
    cellRender: { name: 'EAvatar' },
  },
  {
    title: '创建者Id',
    field: 'createdBy',
    minWidth: 80,
    visible: true,
    treeNode: false,
    params: { type: 'LONG' },
    editRender: { name: 'EInputNumber', enabled: false, props: { controls: false } },
  },
  {
    title: '修改者Id',
    field: 'lastModifiedBy',
    minWidth: 80,
    visible: true,
    treeNode: false,
    params: { type: 'LONG' },
    editRender: { name: 'EInputNumber', enabled: false, props: { controls: false } },
  },
  {
    title: '部门',
    field: 'department',
    minWidth: 120,
    editRender: {
      name: 'ESelectModal',
      enabled: false,
      props: {
        showComponentName: 'TreeSelect',
        container: 'modal',
        componentName: 'DepartmentDetail',
        multiple: false,
        style: { width: '100%' },
        queryNames: ['id'],
        avatarSlotName: 'default',
        avatarSlotField: 'name',
        avatarTipField: 'name',
        rowIdField: 'value.id',
        source: 'User',
      },
    },
  },
  {
    title: '岗位',
    field: 'position',
    minWidth: 120,
    editRender: {
      name: 'ESelectModal',
      enabled: false,
      props: {
        showComponentName: 'Avatar',
        container: 'modal',
        componentName: 'PositionDetail',
        multiple: false,
        style: { width: '100%' },
        queryNames: ['id'],
        avatarSlotName: 'default',
        avatarSlotField: 'name',
        avatarTipField: 'name',
        rowIdField: 'value.id',
        source: 'User',
      },
    },
  },
  {
    title: '角色列表',
    field: 'authorities',
    minWidth: 120,
    editRender: {
      name: 'ESelectModal',
      enabled: false,
      props: {
        showComponentName: 'TreeSelect',
        container: 'modal',
        componentName: 'AuthorityRelation',
        multiple: true,
        style: { width: '100%' },
        queryNames: ['id.in'],
        avatarSlotName: 'default',
        avatarSlotField: 'name',
        avatarTipField: 'name',
        rowIdField: 'value.id',
        source: 'User',
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
