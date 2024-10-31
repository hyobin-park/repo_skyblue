package com.color.infra.customer;

import com.color.common.constants.Constants;

public class CustomerVo {
	
	private Integer shcustomer_delNy;
	private Integer shcustomer_useNy;
	private Integer shregisterAgreeContentNy;
	private Integer shgender;
	private Integer shOption;
	private String shValue;
	private String shDateStart;
	private String shDateEnd;
	private Integer shOptionDate;
	
	//paging
	private int thisPage = 1;
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;

	private int totalRows;
	private int totalPages;
	private int startPage;
	private int endPage;

	private int startRnumForMysql = 0;
	
	// ----- getter/setter -----
	public Integer getShcustomer_delNy() {
		return shcustomer_delNy;
	}
	public void setShcustomer_delNy(Integer shcustomer_delNy) {
		this.shcustomer_delNy = shcustomer_delNy;
	}
	public Integer getShcustomer_useNy() {
		return shcustomer_useNy;
	}
	public void setShcustomer_useNy(Integer shcustomer_useNy) {
		this.shcustomer_useNy = shcustomer_useNy;
	}
	public Integer getShregisterAgreeContentNy() {
		return shregisterAgreeContentNy;
	}
	public void setShregisterAgreeContentNy(Integer shregisterAgreeContentNy) {
		this.shregisterAgreeContentNy = shregisterAgreeContentNy;
	}
	public Integer getShgender() {
		return shgender;
	}
	public void setShgender(Integer shgender) {
		this.shgender = shgender;
	}
	public Integer getShOption() {
		return shOption;
	}
	public void setShOption(Integer shOption) {
		this.shOption = shOption;
	}
	public String getShValue() {
		return shValue;
	}
	public void setShValue(String shValue) {
		this.shValue = shValue;
	}
	public String getShDateStart() {
		return shDateStart;
	}
	public void setShDateStart(String shDateStart) {
		this.shDateStart = shDateStart;
	}
	public String getShDateEnd() {
		return shDateEnd;
	}
	public void setShDateEnd(String shDateEnd) {
		this.shDateEnd = shDateEnd;
	}
	public Integer getShOptionDate() {
		return shOptionDate;
	}
	public void setShOptionDate(Integer shOptionDate) {
		this.shOptionDate = shOptionDate;
	}
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getRowNumToShow() {
		return rowNumToShow;
	}
	public void setRowNumToShow(int rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}
	public int getPageNumToShow() {
		return pageNumToShow;
	}
	public void setPageNumToShow(int pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartRnumForMysql() {
		return startRnumForMysql;
	}
	public void setStartRnumForMysql(int startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}
	
	public void setParamsPaging(int totalRows) {
		
		setTotalRows(totalRows);
		
		if(getTotalRows() == 0) {
			setTotalPages(1);
		} else {
			setTotalPages(getTotalRows() / getRowNumToShow());
		}
		
		if(getTotalRows() % getRowNumToShow() > 0) {
			setTotalPages(getTotalPages() + 1);
		}
		
		if(getTotalPages() < getThisPage()) {
			setThisPage(getTotalPages());
		}
		
		setStartPage(((getThisPage() - 1) / getPageNumToShow()) * getPageNumToShow() + 1);

		setEndPage(getStartPage() + getPageNumToShow() - 1);

		if (getEndPage() > getTotalPages()) {
			setEndPage(getTotalPages());
		}
		
		if (thisPage == 1) {
			setStartRnumForMysql(0);
		} else {
			setStartRnumForMysql((getRowNumToShow() * (getThisPage()-1)));
		}
	}
	
}
