package com.color.infra.hotel;

import com.color.common.constants.Constants;

public class HotelVo {
	
	private Integer shtelDelNy;
	private Integer shtelUseNy;
	private Integer shOption;
	private String shValue;
	private String shDateStart;
	private String shDateEnd;
	private Integer shOptionDate;
	private Integer shStars;
	private Integer shSwimmingPoolNy;
	private Integer shFitnessCenterNy;
	private Integer shRoomServiceNy;
	private Integer shSpaNy;
	private Integer shWifiNy;
	private Integer shParkingNy;
	private Integer shHvacNy;
	private Integer shSmokingAreaNy;
	
	private int thisPage = 1;									// 현재 페이지
	private int rowNumToShow = Constants.ROW_NUM_TO_SHOW;		// 화면에 보여줄 데이터 줄 갯수
	private int pageNumToShow = Constants.PAGE_NUM_TO_SHOW;		// 화면에 보여줄 페이징 번호 갯수

	private int totalRows;										// 전체 데이터 갯수
	private int totalPages;										// 전체 페이지 번호
	private int startPage;										// 시작 페이지 번호
	private int endPage;										// 마지막 페이지 번호

	private int startRnumForMysql = 0;							// 쿼리 시작 row

	// ----- getter/setter -----
	public Integer getShtelDelNy() {
		return shtelDelNy;
	}

	public void setShtelDelNy(Integer shtelDelNy) {
		this.shtelDelNy = shtelDelNy;
	}

	public Integer getShtelUseNy() {
		return shtelUseNy;
	}

	public void setShtelUseNy(Integer shtelUseNy) {
		this.shtelUseNy = shtelUseNy;
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
	public Integer getShStars() {
			return shStars;
	}
	public void setShStars(Integer shStars) {
			this.shStars = shStars;
	}
	public Integer getShSwimmingPoolNy() {
		return shSwimmingPoolNy;
	}

	public void setShSwimmingPoolNy(Integer shSwimmingPoolNy) {
		this.shSwimmingPoolNy = shSwimmingPoolNy;
	}

	public Integer getShFitnessCenterNy() {
		return shFitnessCenterNy;
	}

	public void setShFitnessCenterNy(Integer shFitnessCenterNy) {
		this.shFitnessCenterNy = shFitnessCenterNy;
	}

	public Integer getShRoomServiceNy() {
		return shRoomServiceNy;
	}

	public void setShRoomServiceNy(Integer shRoomServiceNy) {
		this.shRoomServiceNy = shRoomServiceNy;
	}

	public Integer getShSpaNy() {
		return shSpaNy;
	}

	public void setShSpaNy(Integer shSpaNy) {
		this.shSpaNy = shSpaNy;
	}

	public Integer getShWifiNy() {
		return shWifiNy;
	}

	public void setShWifiNy(Integer shWifiNy) {
		this.shWifiNy = shWifiNy;
	}

	public Integer getShParkingNy() {
		return shParkingNy;
	}

	public void setShParkingNy(Integer shParkingNy) {
		this.shParkingNy = shParkingNy;
	}

	public Integer getShHvacNy() {
		return shHvacNy;
	}

	public void setShHvacNy(Integer shHvacNy) {
		this.shHvacNy = shHvacNy;
	}

	public Integer getShSmokingAreaNy() {
		return shSmokingAreaNy;
	}

	public void setShSmokingAreaNy(Integer shSmokingAreaNy) {
		this.shSmokingAreaNy = shSmokingAreaNy;
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
