package com.molo.Utils.TestListener;

import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.molo.Utils.TestAnnotation.KeepRun;

public class MyTestListener implements IInvokedMethodListener2 {
	
	private static Logger logger = Logger.getLogger(MyTestListener.class);
	
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult,
			ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult,
			ITestContext context) {
		KeepRun kRun = method.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(KeepRun.class);
		if(kRun != null){
			Boolean isRun = kRun.value();
			if(isRun){
				//testResult.setStatus(testResult.getAttributeNames());
			}
		}
	}

}
