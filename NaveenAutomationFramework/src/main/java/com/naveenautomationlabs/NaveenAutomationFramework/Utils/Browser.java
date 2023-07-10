package com.naveenautomationlabs.NaveenAutomationFramework.Utils;

public enum Browser {
	CHROME("Chrome"), 
	FIREFOX("Firefox"), 
	SAFARI("Safari"), 
	EDGE("Edge");

	String value;

	private Browser(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
