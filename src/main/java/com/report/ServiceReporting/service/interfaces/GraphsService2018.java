package com.report.ServiceReporting.service.interfaces;

import java.util.Date;
import java.util.List;

import com.report.ServiceReporting.dto.Graphs2018DTO;

/**
 * User Service Contract
 * Look at documentation in: xxx.txt
 * @author asanchga
 * @since 1.0.0
 */
public interface GraphsService2018 {

    public List<Graphs2018DTO> getAllSchedullerData(String reportMonth);
    
    public List<String> getRequestsTypes();

	List<Graphs2018DTO> getSchedullerDataByDeliveryModel(String delModel, String reportMonth);

	List<Graphs2018DTO> getSchedullerDataByGadgetCategory(String sGadgCategory, String reportMonth);

	public List<String> getGadgetCategories();

	public List<String> getDemandTypes();

	public List<Graphs2018DTO> getSchedullerDataByDemandType(String sDemandType, String reportMonth);

	void insertSchedullerData(String businessUnit, String reportMonth, String clarity, String gadgetId,
			String requestType, String application, String gadgetCategory, String sEverisDelGadgetOwner,
			String sDeliveryModel, String demandType, String description, String status, String gadgetType,
			String capacityType, String skills, String name, String hoursType, Date startDate, Date endDate,
			Date registDate, int JAN_18, int FEB_18, int MAR_18, int APR_18, int MAY_18, int JUN_18, int JUL_18,
			int AUG_18, int SEP_18, int OCT_18, int NOV_18, int DEC_18, int TOTAL);

}
