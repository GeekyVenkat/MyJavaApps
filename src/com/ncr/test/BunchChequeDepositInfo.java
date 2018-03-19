package com.ncr.test;

import java.util.List;

public class BunchChequeDepositInfo {

	private int totalChequesReturned;
	private List<ChequeDetailsDTO> list ;
	
	
	/**
	 * @return the totalChequesReturned
	 */
	public int getTotalChequesReturned() {
		return totalChequesReturned;
	}

	/**
	 * @param totalChequesReturned the totalChequesReturned to set
	 */
	public void setTotalChequesReturned(int totalChequesReturned) {
		this.totalChequesReturned = totalChequesReturned;
	}

	/**
	 * @return the list
	 */
	public List<ChequeDetailsDTO> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<ChequeDetailsDTO> list) {
		this.list = list;
	}
	
}
