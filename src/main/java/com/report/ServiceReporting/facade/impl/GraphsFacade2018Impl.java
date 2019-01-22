package com.report.ServiceReporting.facade.impl;

import com.report.ServiceReporting.dto.Graphs2018DTO;

import com.report.ServiceReporting.facade.GraphsFacade2018;
import com.report.ServiceReporting.service.interfaces.GraphsService2018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GraphsFacade2018Impl implements GraphsFacade2018 {
	private static final Logger logger = LoggerFactory.getLogger(GraphsFacade2018Impl.class);
	
	 @Value("${VALUE.DEMANDBOUNDARY}")
	   private String demandBoundary;
	 
	ArrayList oListJan18 = new ArrayList();
	ArrayList oListFeb18 = new ArrayList();
	ArrayList oListMar18 = new ArrayList();
	ArrayList oListApr18 = new ArrayList();
	ArrayList oListMay18 = new ArrayList();
	ArrayList oListJun18 = new ArrayList();
	ArrayList oListJul18 = new ArrayList();
	ArrayList oListAug18 = new ArrayList();
	ArrayList oListSep18 = new ArrayList();
	ArrayList oListOct18 = new ArrayList();
	ArrayList oListNov18 = new ArrayList();
	ArrayList oListDec18 = new ArrayList();
//ArrayList oListTot18 = new ArrayList();
	List oDataToJson = new ArrayList();
	
	@Autowired
	GraphsService2018 graphservice;

    @Autowired
    public GraphsFacade2018Impl() {
     
    }

    /**
     *     
     */
    @Override
    public List<Graphs2018DTO> getAllSchedullerData(String reportMonth) {
    	
    	oDataToJson = new ArrayList();
    	List<Graphs2018DTO> oListGraphs = new ArrayList<Graphs2018DTO>();
    	
    	try {
			
    	oListGraphs = graphservice.getAllSchedullerData(reportMonth);
    	
    	oListJan18 = new ArrayList();
    	oListFeb18 = new ArrayList();
    	oListMar18 = new ArrayList();
    	oListApr18 = new ArrayList();
    	oListMay18 = new ArrayList();
    	oListJun18 = new ArrayList();
    	oListJul18 = new ArrayList();
    	oListAug18 = new ArrayList();
    	oListSep18 = new ArrayList();
    	oListOct18 = new ArrayList();
    	oListNov18 = new ArrayList();
    	oListDec18 = new ArrayList();
    	//oListTot18 = new ArrayList();
    	
    	populateMonths();
    	getBAList(oListGraphs);
    	getAppDevList(oListGraphs);
    	getAppTestList(oListGraphs);
    	getInfraBuild(oListGraphs);
    	getInfraSupport(oListGraphs);
    	getProjMgmt(oListGraphs);
    	populateList();
    	

		
		}catch(Exception ex) {
			logger.error("Error in getAllSchedullerData-->"+ex.getMessage());
			
		}
    	
		return oDataToJson;
    }
    
    /**
     *     
     */
    @Override
    public List<Graphs2018DTO> getDemandCommitedData(String reportMonth){
    	List<Graphs2018DTO> oListGraphs = new ArrayList<Graphs2018DTO>();
    	oDataToJson = new ArrayList();
    	
    	try {
			
        	oListGraphs = graphservice.getAllSchedullerData(reportMonth);
        	oDataToJson = getDemandList(oListGraphs);
        	
    	}catch(Exception ex) {
			logger.error("Error in getDemandCommitedData-->"+ex.getMessage());
			
		}
    	
    	return oDataToJson;
    }
    
    /**
     *     
     */
    @Override
    public List<Graphs2018DTO> getGadgetCategory(String reportMonth){
    	List<Graphs2018DTO> oListGraphs = new ArrayList<Graphs2018DTO>();
    	List<String> oListGadgetCategories  = new ArrayList<String>();
    	
    	oDataToJson = new ArrayList();
    	
    	 List oListAux = new ArrayList();
    	 
    	 int appEnhancement = 0;
    	
    	try {
    		
    		oListGadgetCategories = graphservice.getGadgetCategories();
    	
    		oListAux.add("Gadget Category");
        	oListAux.add("Hours");
        	oDataToJson.add(oListAux);
        	
    		for(String sGadgCategory : oListGadgetCategories) {
    			
    			oListGraphs = graphservice.getSchedullerDataByGadgetCategory(sGadgCategory,reportMonth);
    			
    			if(oListGraphs.size()>0) {
    			
    			oListAux = new ArrayList();
    			oListAux.add(sGadgCategory);
            	oListAux.add(oListGraphs.stream().mapToInt(o -> o.getTOTAL()).sum());
            	oDataToJson.add(oListAux);
    			}
    			
    			}
    		
    	}catch(Exception ex) {
			logger.error("Error in getDemandCommitedData-->"+ex.getMessage());
			
		}    	
        	
    	logger.debug("oDataToJson-->"+oDataToJson.toString());
    	
    	return oDataToJson;
    }
    
    /**
     *     
     */
    @Override
    public List<Graphs2018DTO> getDemandType(String reportMonth){
    	List<Graphs2018DTO> oListGraphs = new ArrayList<Graphs2018DTO>();
    	List<String> oListDemandTypes  = new ArrayList<String>();
    	
    	oDataToJson = new ArrayList();
    	
    	 List oListAux = new ArrayList();
    	 
    	 int appEnhancement = 0;
    	
    	try {
    		
    		oListDemandTypes = graphservice.getDemandTypes();
    	
    		oListAux.add("Gadget Category");
        	oListAux.add("Hours");
        	oDataToJson.add(oListAux);
        	
    		for(String sDemandType : oListDemandTypes) {
    			
    			oListGraphs = graphservice.getSchedullerDataByDemandType(sDemandType,reportMonth);
    			
    			if(oListGraphs.size()>0) {
    			
    			oListAux = new ArrayList();
    			oListAux.add(sDemandType);
            	oListAux.add(oListGraphs.stream().mapToInt(o -> o.getTOTAL()).sum());
            	oDataToJson.add(oListAux);
    			}
    			
    			}
    		
    	}catch(Exception ex) {
			logger.error("Error in getDemandCommitedData-->"+ex.getMessage());
			
		}    	
        	
    	logger.debug("oDataToJson-->"+oDataToJson.toString());
    	
    	return oDataToJson;
    }
    
    
    /**
     *     
     */
    @Override
    public List<Graphs2018DTO> getDeliveryModelData(String reportMonth){
    	List<Graphs2018DTO> oListGraphs = new ArrayList<Graphs2018DTO>();
    	List<Graphs2018DTO> oListProject  = new ArrayList<Graphs2018DTO>();
    	List<Graphs2018DTO> oListResourceAllocation  = new ArrayList<Graphs2018DTO>();
    	List<Graphs2018DTO> oListTBC  = new ArrayList<Graphs2018DTO>();
    	oDataToJson = new ArrayList();
    	
    	 List oListAux = new ArrayList();
    	
    	try {
			
    		oListProject = graphservice.getSchedullerDataByDeliveryModel("Project",reportMonth);
    		oListResourceAllocation = graphservice.getSchedullerDataByDeliveryModel("Resource Allocation",reportMonth);
    		oListTBC  = graphservice.getSchedullerDataByDeliveryModel("TBC",reportMonth);
    		
    	}catch(Exception ex) {
			logger.error("Error in getDemandCommitedData-->"+ex.getMessage());
			
		}    	
    	
        	
        	int iProject = oListProject.stream().mapToInt(o -> o.getTOTAL()).sum();
        	int iResourceAllocation = oListResourceAllocation.stream().mapToInt(o -> o.getTOTAL()).sum();
        	
        	oListAux.add("Delivery Model");
        	oListAux.add("Hours");
        	oDataToJson.add(oListAux);
        	
        	oListAux = new ArrayList();
        	oListAux.add("Project");
        	oListAux.add(iProject);
        	oDataToJson.add(oListAux);
        	
        	oListAux = new ArrayList();
        	oListAux.add("Resource Allocation");
        	oListAux.add(iResourceAllocation);
        	oDataToJson.add(oListAux);
        	
        	oListAux = new ArrayList();
        	oListAux.add("TBC");
        	oListAux.add(oListTBC);
        	oDataToJson.add(oListAux);
        	
    	
    	
    	return oDataToJson;
    }
    
    /**
     * 
     */
    public void populateList() {
    	//we build the JSON to return to the view
    			oDataToJson.add(getListRequestType());
    			oDataToJson.add(oListJan18);
    			oDataToJson.add(oListFeb18);
    			oDataToJson.add(oListMar18);
    			oDataToJson.add(oListApr18);
    			oDataToJson.add(oListMay18);
    			oDataToJson.add(oListJun18);
    			oDataToJson.add(oListJul18);
    			oDataToJson.add(oListAug18);
    			oDataToJson.add(oListSep18);
    			oDataToJson.add(oListOct18);
    			oDataToJson.add(oListNov18);
    			oDataToJson.add(oListDec18);
    		//	oDataToJson.add(oListTot18);
    }
    
    /**
     * 
     */
    public void populateMonths() {
    	oListJan18.add("JANUARY 18");
		oListFeb18.add("FEBRUARY 18");
		oListMar18.add("MARCH 18");
		oListApr18.add("APRIL 18");
		oListMay18.add("MAY 18");
		oListJun18.add("JUNE 18");
		oListJul18.add("JULY 18");
		oListAug18.add("AUGUST 18");
		oListSep18.add("SEPTIEMBRE 18");
		oListOct18.add("OCTOBER 18");
		oListNov18.add("NOVEMBER 18");
		oListDec18.add("DECEMBER 18");
	//	oListTot18.add("TOTAL");
    }
    
    /**
     * 
     * @return
     */
    public List<String> getListRequestType() {
    	
    	List<String> oListRequestType = new ArrayList();
		oListRequestType.add("Month");
		oListRequestType.add("Business Analysis");
		oListRequestType.add("Application Development");
		oListRequestType.add("Application Test & Support");
		oListRequestType.add("Infra Build");
		oListRequestType.add("Infra Support");
		oListRequestType.add("Project Management");
		return oListRequestType;
    }
    
   /**
    * 
    * @param oListGraphs
    */
     public List getDemandList(List<Graphs2018DTO> oListGraphs) {
    	
    	 int iDemandBoundary = Integer.parseInt(demandBoundary);
    	 
    	 List oListAux = new ArrayList();
    	 List oListJAN_18 = new ArrayList();
    	 List oListFEB_18 = new ArrayList();
    	 List oListMAR_18 = new ArrayList();
    	 List oListAPR_18 = new ArrayList();
    	 List oListMAY_18 = new ArrayList();
    	 List oListJUN_18 = new ArrayList();
    	 List oListJUL_18 = new ArrayList();
    	 List oListAUG_18 = new ArrayList();
    	 List oListSEP_18 = new ArrayList();
    	 List oListOCT_18 = new ArrayList();
    	 List oListNOV_18 = new ArrayList();
    	 List oListDEC_18 = new ArrayList();
    	 List oListHeader = new ArrayList();
    	 
    	 oListHeader.add("MONTH");
    	 oListHeader.add("DEMAND COMMITED %");
    	 
		int JAN_18 = oListGraphs.stream().mapToInt(o -> o.getJAN_18()).sum();
		
		oListJAN_18.add("JANUARY 18");
		oListJAN_18.add((((double)JAN_18/(double)iDemandBoundary))*100);
		
		int FEB_18 = oListGraphs.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFEB_18.add("FEBRUARY 18");
		oListFEB_18.add(((double)FEB_18/(double)iDemandBoundary)*100);
		
		int MAR_18 = oListGraphs.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMAR_18.add("MARCH 18");
		oListMAR_18.add(((double)MAR_18/(double)iDemandBoundary)*100);
		
		int APR_18 = oListGraphs.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListAPR_18.add("APRIL 18");
		oListAPR_18.add(((double)APR_18/(double)iDemandBoundary)*100);
		
		int MAY_18 = oListGraphs.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMAY_18.add("MAY 18");
		oListMAY_18.add(((double)MAY_18/(double)iDemandBoundary)*100);
		
		int JUN_18 = oListGraphs.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJUN_18.add("JUN 18");
		oListJUN_18.add(((double)JUN_18/(double)iDemandBoundary)*100);
		
		int JUL_18 = oListGraphs.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJUL_18.add("JUL 18");
		oListJUL_18.add(((double)JUL_18/(double)iDemandBoundary)*100);
		
		int AUG_18 = oListGraphs.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAUG_18.add("AUG 18");
		oListAUG_18.add(((double)AUG_18/(double)iDemandBoundary)*100);
		
		int SEP_18 = oListGraphs.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSEP_18.add("SEP 18");
		oListSEP_18.add(((double)SEP_18/(double)iDemandBoundary)*100);
		
		int OCT_18 = oListGraphs.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOCT_18.add("OCT 18");
		oListOCT_18.add(((double)OCT_18/(double)iDemandBoundary)*100);
		
		int NOV_18 = oListGraphs.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNOV_18.add("NOV 18");
		oListNOV_18.add(((double)NOV_18/(double)iDemandBoundary)*100);
		
		int DEC_18 = oListGraphs.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDEC_18.add("DEC 18");
		oListDEC_18.add(((double)DEC_18/(double)iDemandBoundary)*100);
		
		oListAux.add(oListHeader);
		oListAux.add(oListJAN_18);
		oListAux.add(oListFEB_18);
		oListAux.add(oListMAR_18);
		oListAux.add(oListAPR_18);
		oListAux.add(oListMAY_18);
		oListAux.add(oListJUN_18);
		oListAux.add(oListJUL_18);
		oListAux.add(oListAUG_18);
		oListAux.add(oListSEP_18);
		oListAux.add(oListOCT_18);
		oListAux.add(oListNOV_18);
		oListAux.add(oListDEC_18);
		
		return oListAux;
		
    }
    
  /**
   * 
   * @param oListGraphs
   */
    public void getBAList(List<Graphs2018DTO> oListGraphs) {
    
    	List<Graphs2018DTO> oListBA = oListGraphs.stream()
				  .filter((GraphsDTO) -> GraphsDTO.getREQUEST_TYPE().equals("Business Analysis")).collect(Collectors.toList());
	
	
	int BAJAN_18 = oListBA.stream().mapToInt(o -> o.getJAN_18()).sum();
	oListJan18.add(BAJAN_18);
	int BAFEB_18 = oListBA.stream().mapToInt(o -> o.getFEB_18()).sum();
	oListFeb18.add(BAFEB_18);
	int BAMAR_18 = oListBA.stream().mapToInt(o -> o.getMAR_18()).sum();
	oListMar18.add(BAMAR_18);
	int BAAPR_18 = oListBA.stream().mapToInt(o -> o.getAPR_18()).sum();
	oListApr18.add(BAAPR_18);
	int BAMAY_18 = oListBA.stream().mapToInt(o -> o.getMAY_18()).sum();
	oListMay18.add(BAMAY_18);
	int BAJUN_18 = oListBA.stream().mapToInt(o -> o.getJUN_18()).sum();
	oListJun18.add(BAJUN_18);
	int BAJUL_18 = oListBA.stream().mapToInt(o -> o.getJUL_18()).sum();
	oListJul18.add(BAJUL_18);
	int BAAUG_18 = oListBA.stream().mapToInt(o -> o.getAUG_18()).sum();
	oListAug18.add(BAAUG_18);
	int BASEP_18 = oListBA.stream().mapToInt(o -> o.getSEP_18()).sum();
	oListSep18.add(BASEP_18);
	int BAOCT_18 = oListBA.stream().mapToInt(o -> o.getOCT_18()).sum();
	oListOct18.add(BAOCT_18);
	int BANOV_18 = oListBA.stream().mapToInt(o -> o.getNOV_18()).sum();
	oListNov18.add(BANOV_18);
	int BADEC_18 = oListBA.stream().mapToInt(o -> o.getDEC_18()).sum();		
	oListDec18.add(BADEC_18);
	//int BATOT_18 = oListBA.stream().mapToInt(o -> o.getTOTAL()).sum();		
	//oListTot18.add(BATOT_18);
    }
    
  
    /**
     * 
     * @param oListGraphs
     */
    public void getAppDevList(List<Graphs2018DTO> oListGraphs) {
        
    	List<Graphs2018DTO> oListAppDev =  oListGraphs.stream()
				  .filter(element -> element.getREQUEST_TYPE().equals("Application Development")).collect(Collectors.toList());
		
		int AppDevJAN_18 = oListAppDev.stream().mapToInt(o -> o.getJAN_18()).sum();
		oListJan18.add(AppDevJAN_18);
		
		int AppDevFEB_18 = oListAppDev.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFeb18.add(AppDevFEB_18);
		int AppDevMAR_18 = oListAppDev.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMar18.add(AppDevMAR_18);
		int AppDevAPR_18 = oListAppDev.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListApr18.add(AppDevAPR_18);
		int AppDevMAY_18 = oListAppDev.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMay18.add(AppDevMAY_18);
		int AppDevJUN_18 = oListAppDev.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJun18.add(AppDevJUN_18);
		int AppDevJUL_18 = oListAppDev.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJul18.add(AppDevJUL_18);
		int AppDevAUG_18 = oListAppDev.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAug18.add(AppDevAUG_18);
		int AppDevSEP_18 = oListAppDev.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSep18.add(AppDevSEP_18);
		int AppDevOCT_18 = oListAppDev.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOct18.add(AppDevOCT_18);
		int AppDevNOV_18 = oListAppDev.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNov18.add(AppDevNOV_18);
		int AppDevDEC_18 = oListAppDev.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDec18.add(AppDevDEC_18);
		//int AppDevTOT_18 = oListAppDev.stream().mapToInt(o -> o.getTOTAL()).sum();		
		//oListTot18.add(AppDevTOT_18);
		
    }
    
/**
 * 
 * @param oListGraphs
 */
    public void getAppTestList(List<Graphs2018DTO> oListGraphs) {
    	List<Graphs2018DTO> oListAppTest = oListGraphs.stream()
				  .filter(element -> element.getREQUEST_TYPE().equals("Application Test & Support")).collect(Collectors.toList());
		int TestJAN_18 = oListAppTest.stream().mapToInt(o -> o.getJAN_18()).sum();
		oListJan18.add(TestJAN_18);
		int TestFEB_18 = oListAppTest.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFeb18.add(TestFEB_18);
		int TestMAR_18 = oListAppTest.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMar18.add(TestMAR_18);
		int TestAPR_18 = oListAppTest.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListApr18.add(TestAPR_18);
		int TestMAY_18 = oListAppTest.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMay18.add(TestMAY_18);
		int TestJUN_18 = oListAppTest.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJun18.add(TestJUN_18);
		int TestJUL_18 = oListAppTest.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJul18.add(TestJUL_18);
		int TestAUG_18 = oListAppTest.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAug18.add(TestAUG_18);
		int TestSEP_18 = oListAppTest.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSep18.add(TestSEP_18);
		int TestOCT_18 = oListAppTest.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOct18.add(TestOCT_18);
		int TestNOV_18 = oListAppTest.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNov18.add(TestNOV_18);
		int TestDEC_18 = oListAppTest.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDec18.add(TestDEC_18);
		//int TestTOT_18 = oListAppTest.stream().mapToInt(o -> o.getTOTAL()).sum();		
		//oListTot18.add(TestTOT_18);
    }
    
	/**
	 * 
	 * @param oListGraphs
	 */
    public void getInfraBuild(List<Graphs2018DTO> oListGraphs) {
    	List<Graphs2018DTO> oListInfraBuild = oListGraphs.stream()
				  .filter(element -> element.getREQUEST_TYPE().equals("Infra Build")).collect(Collectors.toList());
		int InfraBuildJAN_18 = oListInfraBuild.stream().mapToInt(o -> o.getJAN_18()).sum();
		oListJan18.add(InfraBuildJAN_18);
		int InfraBuildFEB_18 = oListInfraBuild.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFeb18.add(InfraBuildFEB_18);
		int InfraBuildMAR_18 = oListInfraBuild.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMar18.add(InfraBuildMAR_18);
		int InfraBuildAPR_18 = oListInfraBuild.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListApr18.add(InfraBuildAPR_18);
		int InfraBuildMAY_18 = oListInfraBuild.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMay18.add(InfraBuildMAY_18);
		int InfraBuildJUN_18 = oListInfraBuild.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJun18.add(InfraBuildJUN_18);
		int InfraBuildJUL_18 = oListInfraBuild.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJul18.add(InfraBuildJUL_18);
		int InfraBuildAUG_18 = oListInfraBuild.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAug18.add(InfraBuildAUG_18);
		int InfraBuildSEP_18 = oListInfraBuild.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSep18.add(InfraBuildSEP_18);
		int InfraBuildOCT_18 = oListInfraBuild.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOct18.add(InfraBuildOCT_18);
		int InfraBuildNOV_18 = oListInfraBuild.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNov18.add(InfraBuildNOV_18);
		int InfraBuildDEC_18 = oListInfraBuild.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDec18.add(InfraBuildDEC_18);
		//int InfraBuildTOT_18 = oListInfraBuild.stream().mapToInt(o -> o.getTOTAL()).sum();		
		//oListTot18.add(InfraBuildTOT_18);
    }

    /**
     * 
     * @param oListGraphs
     */
    public void getInfraSupport(List<Graphs2018DTO> oListGraphs) {
    	List<Graphs2018DTO> oListInfraSupport =  oListGraphs.stream()
				  .filter(element -> element.getREQUEST_TYPE().equals("Infra Support")).collect(Collectors.toList());
		int InfraSupJAN_18 = oListInfraSupport.stream().mapToInt(o -> o.getJAN_18()).sum();
		oListJan18.add(InfraSupJAN_18);
		int InfraSupFEB_18 = oListInfraSupport.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFeb18.add(InfraSupFEB_18);
		int InfraSupMAR_18 = oListInfraSupport.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMar18.add(InfraSupMAR_18);
		int InfraSupAPR_18 = oListInfraSupport.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListApr18.add(InfraSupAPR_18);
		int InfraSupMAY_18 = oListInfraSupport.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMay18.add(InfraSupMAY_18);
		int InfraSupJUN_18 = oListInfraSupport.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJun18.add(InfraSupJUN_18);
		int InfraSupJUL_18 = oListInfraSupport.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJul18.add(InfraSupJUL_18);
		int InfraSupAUG_18 = oListInfraSupport.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAug18.add(InfraSupAUG_18);
		int InfraSupSEP_18 = oListInfraSupport.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSep18.add(InfraSupSEP_18);
		int InfraSupOCT_18 = oListInfraSupport.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOct18.add(InfraSupOCT_18);
		int InfraSupNOV_18 = oListInfraSupport.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNov18.add(InfraSupNOV_18);
		int InfraSupDEC_18 = oListInfraSupport.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDec18.add(InfraSupDEC_18);
		//int InfraSupTOT_18 = oListInfraSupport.stream().mapToInt(o -> o.getTOTAL()).sum();		
		//oListTot18.add(InfraSupTOT_18);
    }
    
    /**
     * 
     * @param oListGraphs
     */
    public void getProjMgmt(List<Graphs2018DTO> oListGraphs) {
    	
    	List<Graphs2018DTO> oListProjectMgmt = oListGraphs.stream()
				  .filter(element -> element.getREQUEST_TYPE().equals("Project Management")).collect(Collectors.toList());
		int ProjManagerJAN_18 = oListProjectMgmt.stream().mapToInt(o -> o.getJAN_18()).sum();
		oListJan18.add(ProjManagerJAN_18);
		
		int ProjManagerFEB_18 = oListProjectMgmt.stream().mapToInt(o -> o.getFEB_18()).sum();
		oListFeb18.add(ProjManagerFEB_18);
		int ProjManagerMAR_18 = oListProjectMgmt.stream().mapToInt(o -> o.getMAR_18()).sum();
		oListMar18.add(ProjManagerMAR_18);
		int ProjManagerAPR_18 = oListProjectMgmt.stream().mapToInt(o -> o.getAPR_18()).sum();
		oListApr18.add(ProjManagerAPR_18);
		int ProjManagerMAY_18 = oListProjectMgmt.stream().mapToInt(o -> o.getMAY_18()).sum();
		oListMay18.add(ProjManagerMAY_18);
		int ProjManagerJUN_18 = oListProjectMgmt.stream().mapToInt(o -> o.getJUN_18()).sum();
		oListJun18.add(ProjManagerJUN_18);
		int ProjManagerJUL_18 = oListProjectMgmt.stream().mapToInt(o -> o.getJUL_18()).sum();
		oListJul18.add(ProjManagerJUL_18);
		int ProjManagerAUG_18 = oListProjectMgmt.stream().mapToInt(o -> o.getAUG_18()).sum();
		oListAug18.add(ProjManagerAUG_18);
		int ProjManagerSEP_18 = oListProjectMgmt.stream().mapToInt(o -> o.getSEP_18()).sum();
		oListSep18.add(ProjManagerSEP_18);
		int ProjManagerOCT_18 = oListProjectMgmt.stream().mapToInt(o -> o.getOCT_18()).sum();
		oListOct18.add(ProjManagerOCT_18);
		int ProjManagerNOV_18 = oListProjectMgmt.stream().mapToInt(o -> o.getNOV_18()).sum();
		oListNov18.add(ProjManagerNOV_18);
		int ProjManagerDEC_18 = oListProjectMgmt.stream().mapToInt(o -> o.getDEC_18()).sum();
		oListDec18.add(ProjManagerDEC_18);
		//int ProjManagerTOT_18 = oListProjectMgmt.stream().mapToInt(o -> o.getTOTAL()).sum();		
		//oListTot18.add(ProjManagerTOT_18);
    }
   
}
