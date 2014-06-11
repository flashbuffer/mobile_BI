package com.example.mobile_bi.result;

import java.util.ArrayList;
import java.util.List;

public class MobileResult extends BaseResult{
	private List<Integer> moduleIds = new ArrayList<Integer>();
	private List<String> reportNames = new ArrayList<String>();

	public List<Integer> getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(List<Integer> moduleIds) {
		this.moduleIds = moduleIds;
	}

	public List<String> getReportNames() {
		return reportNames;
	}

	public void setReportNames(List<String> reportNames) {
		this.reportNames = reportNames;
	}

}
