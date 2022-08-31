package ExaminationTasks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/MyStore-TestLab.CodersLab.pl/create-new-address.feature",
        plugin = {"pretty", "html:target/cucumber-reports"})

public class Task1Tester {

}
