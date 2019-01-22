package com.report.ServiceReporting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.report.ServiceReporting.dto.Graphs2018DTO;
import com.report.ServiceReporting.facade.GraphsFacade2018;
import com.report.ServiceReporting.service.interfaces.GraphsService2018;
import com.report.ServiceReporting.utils.ReadExcelToObject;

/**
 * Controller used to redirect the http call to the initial index view
 * @author asanchga
 *
 */
@Controller
public class GraphController2018 {
	
	private static final Logger logger = LoggerFactory.getLogger(GraphController2018.class);
	
	@Autowired
	Gson gson;
	
	@Autowired
	GraphsService2018 graphservice;
	
	@Autowired
	private GraphsFacade2018 graphFacade;

	@RequestMapping(value = "/GraphManagement2018")
	public @ResponseBody String index2018(@RequestParam ("action") String idReport, @RequestParam("reportMonth") String reportMonth ) {
		
		logger.info("Entrando por el endpoint graph management-->"+idReport+"  "+reportMonth);
		String sJson = "";
		List oDataToJson = new ArrayList();
		
		try {
			
			//First Report, monthly work by type of request
			if ("01".equals(idReport)) {
				//We retrieve the data
				oDataToJson = graphFacade.getAllSchedullerData(reportMonth);
				
			}
			
			//Second Report - Demand Commited
			else if ("02".equals(idReport)) {
				oDataToJson = graphFacade.getDemandCommitedData(reportMonth);
			}
			
			//Third Report - By Delivery Model
			else if ("03".equals(idReport)) {
				oDataToJson = graphFacade.getDeliveryModelData(reportMonth);
			}
			//Forth Report - Table
			else if ("04".equals(idReport)) {
				oDataToJson = graphservice.getAllSchedullerData(reportMonth);
			}
			
			//Five Report - Gadget Category
			else if ("05".equals(idReport)) {
				oDataToJson = graphFacade.getGadgetCategory(reportMonth);
				
			}
			
			//Six Report - DemandType
			else if ("06".equals(idReport)) {
				oDataToJson = graphFacade.getDemandType(reportMonth);
				
			}
		}catch(Exception ex) {
			logger.info("Exception -->"+ex.getMessage());
		}
		
		//We convert the list into a JSON Object
		gson = new Gson();
		sJson = gson.toJson(oDataToJson);
		
		logger.info("Json String to return by ajax -->"+sJson);
		return sJson;
	}
	
	@Secured("ROLE_ADMIN")
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/uploadFile")
	public ModelAndView updatePolicy(@RequestParam("report_month") String reportingMonth,
			@RequestParam("file_edit") MultipartFile excelFile)
			throws Exception {

		ReadExcelToObject oExcel = new ReadExcelToObject();
		ArrayList<Graphs2018DTO> objScheduler = new ArrayList<Graphs2018DTO>();
		
		objScheduler = oExcel.readExcelFileToObject(excelFile);
		
		for(int i=0;i<objScheduler.size();i++) {
		
			graphservice.insertSchedullerData(objScheduler.get(i).getBUSINESS_UNITS(),
					reportingMonth, objScheduler.get(i).getCLARITY(), objScheduler.get(i).getGADGET_ID(), objScheduler.get(i).getREQUEST_TYPE(), objScheduler.get(i).getAPPLICATION(), objScheduler.get(i).getGADGET_CATEGORY(), objScheduler.get(i).getEVERIS_DELIVERY_GADGET_OWNER(), objScheduler.get(i).getDELIVERY_MODEL(), objScheduler.get(i).getDEMAND_TYPE(), objScheduler.get(i).getDESCRIPTION(), objScheduler.get(i).getSTATUS(), objScheduler.get(i).getGADGET_TYPE(), objScheduler.get(i).getCAPACITY_TYPE(), objScheduler.get(i).getSKILLS(), objScheduler.get(i).getNAME(), objScheduler.get(i).getHOURS_TYPE(), objScheduler.get(i).getSTART_DATE(), objScheduler.get(i).getEND_DATE(), objScheduler.get(i).getREGISTRATION_DATE(), objScheduler.get(i).getJAN_18(), objScheduler.get(i).getFEB_18(), objScheduler.get(i).getMAR_18(), objScheduler.get(i).getAPR_18(), objScheduler.get(i).getMAY_18(), objScheduler.get(i).getJUN_18(), objScheduler.get(i).getJUL_18(), objScheduler.get(i).getAUG_18(), objScheduler.get(i).getSEP_18(), objScheduler.get(i).getOCT_18(), objScheduler.get(i).getNOV_18(), objScheduler.get(i).getDEC_18(), objScheduler.get(i).getTOTAL());
		}
		
		return new ModelAndView("admin");
	}
	
	
	
	
}
