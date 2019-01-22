package com.report.ServiceReporting.facade;

import com.report.ServiceReporting.dto.Graphs2018DTO;

import java.util.List;

public interface GraphsFacade2018 {

	 public List<Graphs2018DTO> getAllSchedullerData(String reportMonth);

	public List<Graphs2018DTO> getDemandCommitedData(String reportMonth);
	
	public List<Graphs2018DTO> getDeliveryModelData(String reportMonth);

	List<Graphs2018DTO> getGadgetCategory(String reportMonth);

	List<Graphs2018DTO> getDemandType(String reportMonth);


}
