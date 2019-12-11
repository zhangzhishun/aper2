package com.springboot.service.reportform;

import com.springboot.domain.ReportForm;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormDeleteService {

    /**
     * 根据REPORTFORM_ID删除ReportForm中的一条数据
     * @return int
     * */
    int reportFormDelete(Integer REPORTFORM_ID);

}
