package com.selenium.pom.testscripts;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginTest.class, LogoutTest.class})

public class TestRunner {}
