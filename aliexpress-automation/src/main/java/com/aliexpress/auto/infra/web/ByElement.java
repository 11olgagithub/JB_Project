package com.aliexpress.auto.infra.web;

import org.openqa.selenium.By;

public class ByElement {
	
	public By by;
	public String description;
	
	public ByElement(String description, By by) {
		
	this.description = description;
	this.by = by;

	}
}
