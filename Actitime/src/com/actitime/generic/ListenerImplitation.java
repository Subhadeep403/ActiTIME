package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplitation extends BaseClass implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String res=result.getName();
		//Type casting to use the getScreenshotAs() method
				TakesScreenshot t=(TakesScreenshot)driver;
				//Pressing the Print screen(prt_sc) button
				File src = t.getScreenshotAs(OutputType.FILE);
		//created or open a file with the bellow path
		File dest= new File("./Screenshort/"+res+".png");
		try {
			//copy and paste the screen short from src to dest
			FileUtils.copyFile(src,dest);
		} 
		catch (IOException e) {
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	

}
