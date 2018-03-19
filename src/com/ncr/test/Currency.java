/*
 * This Program forms part of a Software Product. All and any copyright,
 * trademark or other intellectual property rights used or embodied in or
 * in connection with this Program and the Software Product and including
 * all documentation relating thereto is and shall remain the exclusive
 * property of NCR Limited. Except as may be expressly permitted
 * under the UK Copyright, Designs and Patents Act 1988 as amended by the
 * UK Copyright (Computer Programs) Regulations 1992 or any other 
 * relevant national law or as may be expressly permitted in a properly
 * executed licence agreement between NCR Limited and you, you
 * shall have no rights to (and shall not attempt to nor allow any third
 * party to or attempt to) adapt, alter, amend, modify, reverse engineer,
 * decompile, disassemble or decode the whole or any part of the Program
 * or Software Product or translate the whole or any part of the Program
 * or Software Product into another language nor shall you create
 * derivative works of the Program or Software Product.
 */
package com.ncr.test;

import java.util.ArrayList;

/**
 * Insert the type's description here.
 * Creation date: (28/02/00 14:49:12)
 * @author: Chris Shaw
 * @version %I%, %G%
 * 16-Jul-03 JPT 03195-1-RMG Extended toString so it doesn't display null if the description is null
 */
public class Currency  {

	private static final long serialVersionUID = 529683920810624606L;

	private short id;
	private String isoCode;
	private String desc;
	private int decimalPlace;
	private String symbol;
	
	  private static ArrayList<Currency> initialItems = null;
	  private static ArrayList<Currency> finalItems = null;
	
/**
 * Currency constructor comment.
 */
public Currency() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:56:52)
 * @param i int
 * @param code java.lang.String
 */
public Currency(short i, String ISOcode, String description, int decimalPlace, String symbol) {
	
	this.id = i;
	this.isoCode = ISOcode;
	this.desc = description;
	this.decimalPlace = decimalPlace;
	this.symbol = symbol;
	
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:52:55)
 * @return java.lang.String
 */
public int getDecimalPlace() {
	return this.decimalPlace;
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:52:55)
 * @return java.lang.String
 */
public String getDescription() {
	return this.desc;
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:52:01)
 * @return int
 */
public short getId() {
	return this.id;
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:52:34)
 * @return java.lang.String
 */
public String getISOCode() {
	return this.isoCode;
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:54:08)
 * @return java.lang.String
 */
public String getSymbol() {
	return this.symbol;
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:55:08)
 * @param dec int
 */
public void setDecimal(int dec) {
	decimalPlace = dec;
	}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:55:54)
 * @param des java.lang.String
 */
public void setDescription(String des) {
	desc = des;}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:54:51)
 * @param code java.lang.String
 */
public void setISOCode(String code) {
isoCode = code;	
}
/**
 * Insert the method's description here.
 * Creation date: (28/02/00 14:55:31)
 * @param sym java.lang.String
 */
public void setSymbol(String sym) {
	symbol = sym;
	}
/**
 * Insert the method's description here.
 * Creation date: (29/02/00 09:45:13)
 * @return java.lang.String
 */
public String toString() {
	if (desc != null){
		return desc + "[" + isoCode + "]";
	}else{
		return isoCode;
	}
}

}