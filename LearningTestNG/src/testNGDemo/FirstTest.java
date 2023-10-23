package testNGDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTest {
	@Test
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(invocationCount = 4)
	public void test2() {
		System.out.println("Test 2");
	}

	@Test(enabled = false)
	public void test3() {
		System.out.println("Test 3");
	}

	@Test
	@Ignore
	public void test4() {
		System.out.println("Test 4");
	}

	@Test(dependsOnMethods = "test6")
	public void test5() {
		System.out.println("Test 5");
	}

	@Test
	public void test6() {
		System.out.println("Test 6");
	}

	@Test
	public void test7() {
		System.out.println("Test 7");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("Running Browser");
	}

	@AfterTest
	public void afterTestMethod() {
		System.out.println("After Test");
	}

}
