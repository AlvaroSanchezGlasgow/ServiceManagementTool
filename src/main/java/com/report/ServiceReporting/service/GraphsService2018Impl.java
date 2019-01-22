package com.report.ServiceReporting.service;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.ServiceReporting.dao.GraphsMapper2018;
import com.report.ServiceReporting.dto.Graphs2018DTO;
import com.report.ServiceReporting.service.interfaces.GraphsService2018;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User Service Interface Implementation
 * Map Models 2 DTOS
 * @see GraphsService2018
 * @author asanchga
 * @version 1.0.0
 */
@Service
public class GraphsService2018Impl implements GraphsService2018 {

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
    @Autowired
   GraphsMapper2018 graphsMapper;

    private final ModelMapper modelMapper = new ModelMapper();


	@Override
	public List<Graphs2018DTO> getAllSchedullerData(String reportMonth) {
		
		
		List<Graphs2018DTO> oListData = new ArrayList<Graphs2018DTO>();
		
		oListData = graphsMapper.getAllSchedullerData(reportMonth);
		return oListData;
	}
	
	@Override
	public List<Graphs2018DTO> getSchedullerDataByDeliveryModel(String delModel, String reportMonth) {
		
		
		List<Graphs2018DTO> oListData = new ArrayList<Graphs2018DTO>();
		
		oListData = graphsMapper.getSchedullerDataByDeliveryModel(delModel,reportMonth);
		return oListData;
	}
	
	@Override
	public List<Graphs2018DTO> getSchedullerDataByGadgetCategory(String sGadgCategory,String reportMonth) {
		
		
		List<Graphs2018DTO> oListData = new ArrayList<Graphs2018DTO>();
		
		oListData = graphsMapper.getSchedullerDataByGadgetCategory(sGadgCategory,reportMonth);
		return oListData;
	}
	
	@Override
	public List<String> getRequestsTypes() {
		
		List<String> oListRequestType = new ArrayList<String>();
		
		oListRequestType = graphsMapper.getRequestsTypes();
		return oListRequestType;
	}
	
	@Override
	public List<String> getGadgetCategories() {
		
		List<String> oListGadgetCategories = new ArrayList<String>();
		
		oListGadgetCategories = graphsMapper.getGadgetCategories();
		return oListGadgetCategories;
	}

	@Override
	public List<String> getDemandTypes() {
List<String> oListDemandTypes = new ArrayList<String>();
		
oListDemandTypes = graphsMapper.getDemandTypes();
		return oListDemandTypes;
	
	}

	@Override
	public List<Graphs2018DTO> getSchedullerDataByDemandType(String sDemandType, String reportMonth) {
List<Graphs2018DTO> oListData = new ArrayList<Graphs2018DTO>();
		
		oListData = graphsMapper.getSchedullerDataByDemandType(sDemandType,reportMonth);
		return oListData;
	}
	
	@Override
	public void insertSchedullerData(String businessUnit, String reportMonth, String clarity, String gadgetId, String requestType, String application, String gadgetCategory, String sEverisDelGadgetOwner, String sDeliveryModel, String demandType, String description,String status, String gadgetType, String capacityType, String skills, String name, String hoursType, Date startDate, Date endDate, Date registDate, int JAN_18,int FEB_18,int MAR_18,int APR_18,int MAY_18,int JUN_18,int JUL_18,int AUG_18,int SEP_18,int OCT_18,int NOV_18,int DEC_18,int TOTAL) {
				
		graphsMapper.insertSchedullerData(businessUnit, reportMonth, clarity, gadgetId, requestType, application, gadgetCategory, sEverisDelGadgetOwner, sDeliveryModel, demandType, description, status, gadgetType, capacityType, skills, name, hoursType, startDate, endDate, registDate, JAN_18, FEB_18, MAR_18, APR_18, MAY_18, JUN_18, JUL_18, AUG_18, SEP_18, OCT_18, NOV_18, DEC_18, TOTAL);
	}
}
