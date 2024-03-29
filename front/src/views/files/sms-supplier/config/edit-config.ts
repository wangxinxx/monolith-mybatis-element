import { FormSchema } from '@begcode/components';
import { useI18n } from '@/hooks/web/useI18n';
import apiService from '@/api/index';

const smsSupplierService = apiService.files.smsSupplierService;
const relationshipApis: any = {};

// begcode-please-regenerate-this-file 如果您不希望重新生成代码时被覆盖，将please修改为don't ！！！

const fields = (): FormSchema[] => {
  const { getEnumDict } = useI18n();
  const relationshipApiData: any = {};
  return [
    {
      label: 'ID',
      field: 'id',
      hidden: values => {
        return !values || !values.id;
      },
      component: 'InputNumber',
      componentProps: { placeholder: '请输入ID', controls: false, readonly: true, style: 'width: 100%' },
    },
    {
      label: '提供商',
      field: 'provider',
      component: 'Select',
      componentProps: () => {
        const { getEnumDict } = useI18n();
        return { placeholder: '请选择提供商', options: getEnumDict('SmsProvider'), style: 'width: 100%' };
      },
    },
    {
      label: '配置数据',
      field: 'configData',
      component: 'CodeEditor',
    },
    {
      label: '短信签名',
      field: 'signName',
      component: 'Input',
      componentProps: { type: 'text', clearable: true, placeholder: '请输入短信签名', style: 'width: 100%' },
    },
    {
      label: '备注',
      field: 'remark',
      component: 'Input',
      componentProps: { placeholder: '请输入备注', type: 'textarea', style: 'width: 100%' },
    },
    {
      label: '启用',
      field: 'enabled',
      component: 'Switch',
      componentProps: { placeholder: '请选择启用' },
    },
  ];
};
const rules = (): any => ({});
export default {
  fields,
  rules,
};
