package com.actitime.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
@Listeners(com.actitime.generic.ListenerImplitation.class)
public class CustomerModule extends BaseClass {
	
	@Test
	public void createCustomer( ) {
		Reporter.log("createCustomer3",true);
		Assert.fail();
	}
}
