package com.cydeo.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.cydeo.step_definitions")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@rerun")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:build/cucumber-rerun-report.html")
public class JUnit5RerunTestRunner {
}
