package com.ncr.test;

import java.util.ArrayList;
import java.util.List;

public class ChequeParser {

	public static final byte GROUP_SEPARATOR = 29;
	public static final String GROUP_SEPARATOR_STR = Character.toString((char) GROUP_SEPARATOR);
	
	public static final byte RECORD_SEPARATOR = 30;
	public static final String RECORD_SEPARATOR_STR = Character.toString((char) RECORD_SEPARATOR);
	
	public static void main(String[] args) {
		
		
		
		String additionalBuffer ="g0000020NZD+020000005060000000000000000000001000000006000000000000000030<177886 <312840: 0441094=00 <.002000000500000000000000000030<177886 <312840: 0441094=00 <.";
		
		
		if ('g' == additionalBuffer.charAt(0)) {
			
			BunchChequeDepositInfo bcd = new BunchChequeDepositInfo();
			
			int totalChequesToReturn = Integer.valueOf(additionalBuffer.substring(1, 4));
			bcd.setTotalChequesReturned(totalChequesToReturn);
			
			additionalBuffer = additionalBuffer.substring(8);
			
			// split with GROUP SEPERATOR 
			String[] chequeGroupByCurrency = additionalBuffer.split(GROUP_SEPARATOR_STR);
			List<ChequeDetailsDTO>  chequeDetails  = new ArrayList<ChequeDetailsDTO>();
			
			if( null != chequeGroupByCurrency ){
				
				for(String cgc: chequeGroupByCurrency){
					
				ChequeDetailsDTO chequeDetailsDTO = new ChequeDetailsDTO();
				
				// get Currency By ISO code.
				Currency currency = new Currency();
				currency.setISOCode(cgc.substring(0,3));
				currency.setDecimal(Integer.parseInt(cgc.substring(3,6)));
				
				chequeDetailsDTO.setTotalCustomerAmount(cgc.substring(6,18));
				chequeDetailsDTO.setTotalDerivedAmount(cgc.substring(18,30));
				chequeDetailsDTO.setCurrency(currency);
				
				// Skip 4 Characters.
				cgc = cgc.substring(34);
				
				// Split with RECORD SEPERATOR.
				String[] cheques = cgc.split(RECORD_SEPARATOR_STR);
				
				List<Cheque> chequeList = new ArrayList<Cheque>();
				for (String cheque: cheques) {
					Cheque c = new Cheque();
					c.setChequeIdentifier(cheque.substring(0,3));
					c.setCustomerChequeAmount(cheque.substring(3,15));
					c.setDerivedChequeAmount(cheque.substring(15,27));
					
					int codeLength = Integer.valueOf(cheque.substring(27,30));
					c.setmICRCode(cheque.substring(30, 30+codeLength));
					chequeList.add(c);
				}
				
				chequeDetailsDTO.setCheques(chequeList);
				chequeDetails.add(chequeDetailsDTO);
					
				}
			}
			
			bcd.setList(chequeDetails);
			
			
			
			
		}
	}

}
