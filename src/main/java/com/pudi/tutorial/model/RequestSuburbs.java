package com.pudi.tutorial.model;

/**
 * The type Request Suburb is value object
 *
 * @author Madhu Pudi
 */

public class RequestSuburbs  {
	
	 private String suburbName;
	 private String postalCode;

	
	public RequestSuburbs() {
	  }
	  public RequestSuburbs(String suburbName, String postalCode) {
	    this.suburbName = suburbName;
	    this.postalCode = postalCode;
	   }

/**
 * @return the suburbName
 */
public String getSuburbName() {
	return suburbName;
}
/**
 * @param suburbName the suburbName to set
 */
public void setSuburbName(String suburbName) {
	this.suburbName = suburbName;
}
/**
 * @return the postalCode
 */
public String getPostalCode() {
	return postalCode;
}
/**
 * @param postalCode the postalCode to set
 */
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}

@Override
public String toString() {
    return "Suburb{" +
            "suburbName=" + suburbName +
           ", postalCode='" + postalCode + '\'' +
             '}';
  
}	

}