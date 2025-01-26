package com.npacs.testCases.WorklistTC;
import com.npacs.assertions.LoginAssertions;
import com.npacs.pageObjects.LoginPageElements;
import com.npacs.testCases.BaseClass;
import org.testng.annotations.Test;

public class RadWorklistStudies extends BaseClass {


@Test
    public void openRadWorklist() throws InterruptedException {
        LoginPageElements lp=new LoginPageElements(driver);
        lp.radVijayLogin();



    }














}




