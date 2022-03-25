package com.pudi.tutorial.model;

/**
 * The type Response Suburbs is value object
 *
 * @author Madhu Pudi
 */

public class ResponseSuburbs {

	private String suburbName;

	/**
	 * @return the suburbName
	 */
	public String getSuburbName() {
		return suburbName;
	}

	/**
	 * @param suburbName
	 *            the suburbName to set
	 */
	public void setSuburbName(String suburbName) {
		this.suburbName = suburbName;
	}

	@Override
	public String toString() {
		return "Suburb{" + "suburbName=" + suburbName + '}';

	}

}
