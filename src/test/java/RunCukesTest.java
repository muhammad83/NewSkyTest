import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options
        (
                tags = {"@run"},
                format = {"pretty","html:target/surefire-reports"},
                glue = {"stepDef"}
        )
public class RunCukesTest {
}