import qs from 'qs';
import { get } from 'lodash-es';
import request from '@/axios';
import buildPaginationQueryOpts from '@/utils/jhipster/sorts';
import { PageRecord } from '@/models/baseModel';
import { useMethods } from '@/hooks/web/useMethods';
import { ICommonFieldData } from '@/models/settings/common-field-data.model';

const apiUrl = '/api/common-field-data';

export default {
  // begcode-please-regenerate-this-file 如果您不希望重新生成代码时被覆盖，将please修改为don't ！！！

  find(id: number): Promise<ICommonFieldData> {
    return request.get({ url: `${apiUrl}/${id}` });
  },

  retrieve(paginationQuery?: any): Promise<PageRecord<ICommonFieldData>> {
    const options = buildPaginationQueryOpts(paginationQuery);
    return request.get({ url: apiUrl + `?${qs.stringify(options, { arrayFormat: 'repeat' })}` });
  },

  retrieveNoPage(paginationQuery?: any): Promise<ICommonFieldData[]> {
    return new Promise((resolve, reject) => {
      const options = buildPaginationQueryOpts(paginationQuery);
      request
        .get({ url: apiUrl + `?${qs.stringify(options, { arrayFormat: 'repeat' })}` })
        .then(res => {
          resolve(res && res.records ? res.records : []);
        })
        .catch(err => reject(err));
    });
  },

  stats(queryParams?: any): Promise<any> {
    const options = buildPaginationQueryOpts(queryParams);
    return request.get({ url: `${apiUrl}/stats?${qs.stringify(options, { arrayFormat: 'repeat' })}` });
  },

  exist(queryParams?: any): Promise<Boolean> {
    if (!queryParams.hasOwnProperty('id.aggregate.count') && get(queryParams, 'id.aggregate.count')) {
      queryParams['id.aggregate.count'] = true;
    }
    const options = buildPaginationQueryOpts(queryParams);
    return new Promise((resolve, reject) => {
      request
        .get({ url: `${apiUrl}/stats?${qs.stringify(options, { arrayFormat: 'repeat' })}` })
        .then(res => {
          resolve(res && res[0] && res[0]['id_count'] > 0);
        })
        .catch(err => reject(err));
    });
  },

  delete(id: number): Promise<any> {
    return request.delete({ url: `${apiUrl}/${id}` });
  },

  deleteByIds(ids: number[]): Promise<any> {
    return request.delete({ url: `${apiUrl}` + `?${qs.stringify({ ids }, { arrayFormat: 'repeat' })}` });
  },

  updateSortValue(
    id: number,
    type: 'DROP' | 'STEP' | 'VALUE',
    newSortValue: number,
    beforeId: number,
    afterId: number,
    commonFieldDataCriteria: any,
  ): Promise<Boolean> {
    return request.put({
      url: `${apiUrl}/sort-value/${id}/${type}?newSortValue=${newSortValue || ''}&beforeId=${beforeId || ''}&afterId=${afterId || ''}`,
      params: commonFieldDataCriteria,
    });
  },

  create(commonFieldData: ICommonFieldData): Promise<ICommonFieldData> {
    return request.post({ url: `${apiUrl}`, data: commonFieldData });
  },
  update(commonFieldData: ICommonFieldData, batchIds?: number[], batchFields?: String[]): Promise<ICommonFieldData> {
    let queryParams = '';
    if (batchIds && batchFields) {
      queryParams = qs.stringify({ batchIds, batchFields }, { arrayFormat: 'repeat' });
    }
    return request.put({ url: `${apiUrl}/${commonFieldData.id}?${queryParams}`, data: commonFieldData });
  },

  updateRelations(otherEntityIds: String[], relationshipName: String, relatedIds: number[], operateType: String): Promise<Boolean> {
    const queryParams = qs.stringify({ otherEntityIds, relatedIds, relationshipName }, { arrayFormat: 'repeat' });
    return request.put({ url: `${apiUrl}/relations/${operateType}?${queryParams}` });
  },

  /**
   * 导出xls
   * @param fileName 文件名
   * @param paginationQuery 分页参数
   * @param isXlsx 是否导出xlsx
   */
  exportExcel(fileName, paginationQuery?: any, isXlsx = false) {
    const { handleExportXls, handleExportXlsx } = useMethods();
    const options = buildPaginationQueryOpts(paginationQuery);
    if (isXlsx) {
      return handleExportXlsx(fileName, `${apiUrl}/export`, options);
    } else {
      return handleExportXls(fileName, `${apiUrl}/export`, options);
    }
  },

  /**
   * 导入xls
   * @param file 导入的文件
   * @param success 成功回调
   */
  importExcel(file, success) {
    const { handleImportXls } = useMethods();
    return handleImportXls(file, `${apiUrl}/import`, success);
  },
  // jhipster-needle-service-add-method - JHipster will add getters and setters here, do not remove
};
