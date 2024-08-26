package Steps;

import Pages.LoginPage;
import Pages.SecurePage;
import Pages.TablesPage;
import org.testng.annotations.Test;

public class TC2_ValidateTablesPage extends BaseTest {
    @Test
    void VerifyTablesPage(){
        TablesPage tablesPage = new TablesPage(this.driver);
        tablesPage.extractData();
        tablesPage.displayExtractedData();
    }
}
