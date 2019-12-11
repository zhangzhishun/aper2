package com.springboot.service.reportform;

import com.springboot.domain.ReportForm;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormUpdateService {

    /**
     * 更新ReportForm中的一条数据
     * @return int
     **/
    int updateReportForm(ReportForm reportForm);

    /**
     * 更新ReportForm中的一条数据
     * @return int
     **/
    int updateReportFormState(Integer REPORTFORM_ID,Integer newState);

}
