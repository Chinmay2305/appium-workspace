package com.bai.bai;

import org.testng.TestNG;

import io.appium.java_client.android.options.context.SupportsChromedriverUseSystemExecutableOption;

public class check_testng
{
	public static void main(String[] args)
	{
		System.out.println(TestNG.class.getPackage().getImplementationVersion());
	}
}