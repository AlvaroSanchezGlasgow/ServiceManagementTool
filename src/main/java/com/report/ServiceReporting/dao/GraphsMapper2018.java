package com.report.ServiceReporting.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;

import com.report.ServiceReporting.dto.Graphs2018DTO;

import java.util.Date;
import java.util.List;


/**
 * User DAO with mybatis object mapper.
 * T-SQL Queries [SQL SERVER].
 * @author asanchga
 * @version 1.0.0
 */
@Mapper
public interface GraphsMapper2018 {

	@Results({
        @Result(property = "reportMonth", column = "REPORTING_MONTH")
       // @Result(property = "", column = "name"),
       // @Result(property = "district", column = "district")
      })
 
  //  @Select("select * FROM SCHEDULLER_DATA_2018 where REPORTING_MONTH='${reportMonth}'")
    //List<GraphsDTO> getDataForDemandByType(@Param ("reportMonth") String reportMonth);
    
	  @Select("select * FROM SCHEDULLER_DATA_2018 where REPORTING_MONTH='${reportMonth}'")
    List<Graphs2018DTO> getAllSchedullerData(@Param ("reportMonth") String reportMonth);
	
    @Select("select distinct REQUEST_TYPE FROM SCHEDULLER_DATA_2018")
    List<String> getRequestsTypes();

    @Select("select * FROM SCHEDULLER_DATA_2018 where REPORTING_MONTH='${reportMonth}' and DELIVERY_MODEL='${delModel}'")
	List<Graphs2018DTO> getSchedullerDataByDeliveryModel(String delModel, String reportMonth);

    @Select("select * FROM SCHEDULLER_DATA_2018 where REPORTING_MONTH='${reportMonth}' and GADGET_CATEGORY='${sGadgCategory}'")
	List<Graphs2018DTO> getSchedullerDataByGadgetCategory(String sGadgCategory, String reportMonth);

    @Select("select distinct GADGET_CATEGORY FROM SCHEDULLER_DATA_2018")
	List<String> getGadgetCategories();

    @Select("select distinct DEMAND_TYPE FROM SCHEDULLER_DATA_2018")
	List<String> getDemandTypes();

    @Select("select * FROM SCHEDULLER_DATA_2018 where REPORTING_MONTH='${reportMonth}' and DEMAND_TYPE='${sDemandType}'")
	List<Graphs2018DTO> getSchedullerDataByDemandType(String sDemandType, String reportMonth);
   
    @Insert("INSERT into SCHEDULLER_DATA_2018 VALUES(#{businessUnit},#{reportMonth},#{clarity},#{gadgetId},#{requestType},#{application},#{gadgetCategory},#{sEverisDelGadgetOwner}, #{sDeliveryModel},#{demandType},#{description},#{status},#{gadgetType},#{capacityType},#{skills}, #{name},#{hoursType},#{startDate},#{endDate},#{registDate},#{JAN-18},#{FEB-18},#{MAR-18},#{APR-18},#{MAY-18},#{JUN-18},#{JUL-18},#{AUG-18},#{SEP-18},#{OCT-18},#{NOV-18},#{DEC-18},#{TOTAL} )")
	void insertSchedullerData(String businessUnit, String reportMonth, String clarity, String gadgetId, String requestType, String application, String gadgetCategory, String sEverisDelGadgetOwner, String sDeliveryModel, String demandType, String description,String status, String gadgetType, String capacityType, String skills, String name, String hoursType, Date startDate, Date endDate, Date registDate, int JAN_18,int FEB_18,int MAR_18,int APR_18,int MAY_18,int JUN_18,int JUL_18,int AUG_18,int SEP_18,int OCT_18,int NOV_18,int DEC_18,int TOTAL);
    
    @Delete("DELETE FROM SCHEDULLER_DATA_2018 WHERE REPORTING_MONTH='${reportMonth}'")
	void deleteSchedullerData(String reportMonth);
}
