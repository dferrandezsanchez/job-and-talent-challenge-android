package dev.ferrandezdaniel.jobandtalentchallenge.ui.test

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@CucumberOptions(
    features = ["features"],
    glue = ["dev.ferrandezdaniel.jobandtalentchallenge.ui.features"]
)
@RunWith(Cucumber::class)
class CucumberTestRunner : CucumberAndroidJUnitRunner()
