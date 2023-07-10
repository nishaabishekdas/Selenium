package com.naveenautomationlabs.NaveenAutomationFramework.Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TransformerForFailedTestCase implements IAnnotationTransformer{
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
		      Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryFailedTestCases.class);
	}
}
