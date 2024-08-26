package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TablesPage {
    WebDriver driver;
    List<List<String>> extractedData;
    public TablesPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://the-internet.herokuapp.com/tables");
        this.extractedData = new ArrayList<>();

    }


    public List<List<String>> extractData() {
        try {
            WebElement table = driver.findElement(By.id("table1"));

            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.tagName("td"));

                List<String> rowData = new ArrayList<>();

                for (WebElement column : columns) {
                    rowData.add(column.getText());
                }

                extractedData.add(rowData);
            }
        } catch (Exception e) {
            System.out.println("Error extracting data from table: " + e.getMessage());
        }
        return extractedData;
    }

    public void displayExtractedData() {
        try {
            if (extractedData.isEmpty()) {
                System.out.println("No data extracted.");
            } else {
                System.out.println("Last Name | First Name | Email | Due | Web Site | Action");
                System.out.println("--------------------------------------------------------");

                for (List<String> row : extractedData) {
                    System.out.println(String.join(" | ", row));
                }
            }
        } catch (Exception e) {
            System.out.println("Error displaying extracted data: " + e.getMessage());
        }
    }
}
