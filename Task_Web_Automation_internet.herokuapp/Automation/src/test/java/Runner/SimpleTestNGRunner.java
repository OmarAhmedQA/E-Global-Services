package Runner;

import Steps.TC1_ValidateLogin;
import Steps.TC2_ValidateTablesPage;
import org.testng.annotations.Factory;

public class SimpleTestNGRunner {

    @Factory
    public Object[] createTests() {
        return new Object[] {
                new TC1_ValidateLogin(),
                new TC2_ValidateTablesPage(),

        };
    }


}