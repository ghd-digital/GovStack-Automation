package org.govstack.TestRunner;



import io.cucumber.testng.*;
import org.testng.annotations.*;


@CucumberOptions(
        features = "src/main/resources/TestCases",
        glue = "org.govstack.stepdefinition",
        tags = "${cucumber.filter.tags}",
        plugin = {"pretty","html:target/CucumberReport/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios();
//    }
}
