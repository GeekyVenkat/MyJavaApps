package com.ncr.test;

import java.io.Serializable;
import java.util.List;

public class ChequeDetailsDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3024901275287984391L;
	
	private Currency currency;
	private String totalCustomerAmount;
	private String totalDerivedAmount;
	private List<Cheque> cheques;
		
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * @return the totalCustomerAmount
	 */
	public String getTotalCustomerAmount() {
		return totalCustomerAmount;
	}
	/**
	 * @param totalCustomerAmount the totalCustomerAmount to set
	 */
	public void setTotalCustomerAmount(String totalCustomerAmount) {
		this.totalCustomerAmount = totalCustomerAmount;
	}
	/**
	 * @return the totalDerivedAmount
	 */
	public String getTotalDerivedAmount() {
		return totalDerivedAmount;
	}
	/**
	 * @param totalDerivedAmount the totalDerivedAmount to set
	 */
	public void setTotalDerivedAmount(String totalDerivedAmount) {
		this.totalDerivedAmount = totalDerivedAmount;
	}
	/**
	 * @return the cheques
	 */
	public List<Cheque> getCheques() {
		return cheques;
	}
	/**
	 * @param cheques the cheques to set
	 */
	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}
	

	
	

}
