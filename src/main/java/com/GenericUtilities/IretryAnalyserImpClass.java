package com.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IretryAnalyserImpClass implements IRetryAnalyzer {

	
	int count=0;
	int limitcount=3;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<limitcount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
