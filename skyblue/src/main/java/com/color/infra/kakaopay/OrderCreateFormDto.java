package com.color.infra.kakaopay;

public class OrderCreateFormDto {
	
	private String name;       // 상품명
    private int totalPrice;    // 총 결제 금액
    
    
    // ------ getter/setter ------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    

}
