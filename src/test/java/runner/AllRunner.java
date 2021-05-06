package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/java/FeatureFiles",
        glue = "stepFiles", plugin = {"pretty", "json:target/cucumber.json"})
public class AllRunner extends AbstractTestNGCucumberParallelTests{
}
