package com.amex.service.cucumbertest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/guid.features",
plugin = {"pretty","json:target/cucumber-reports/gccs_micro_services.json"})
@ActiveProfiles(value = "test")
public class AmexControllerCucmberTest {

}
