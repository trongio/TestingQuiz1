import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class WebElementsTest {

    /*
    - Open the chrome browser
    - Navigate to the http://the-internet.herokuapp.com/add_remove_elements/
    - Click to 'Add element' three times
    - Print out the last 'Delete' button element's text with findElement()
    - Print out the last 'Delete' button elements's text with findElements(). Use cssSelector as locator of element with class name , that starts with 'added' word
   */

    @Test
    public void add_remove_elements() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        String Url = "http://the-internet.herokuapp.com/add_remove_elements/";
        driver.get(Url);

        for (int k = 0; k < 3; k++) {
            driver.findElement(By.xpath("//button")).click();
        }

        List<WebElement> all_buttons = driver.findElements(By.xpath("//button"));
        int btn_size = all_buttons.size();

        System.out.println(all_buttons.get(btn_size - 1).getText());
        List<WebElement> all_elements = driver.findElements(By.cssSelector("button[class^='added']"));

        int size = all_elements.size();

        System.out.println(all_elements.get(size - 1).getText());

        driver.close();
    }


    /*
    - Navigate to the http://the-internet.herokuapp.com/challenging_dom
    - Using relative XPath, Print out the Lorem value of element, that has 'Apeirian9' as Ipsum value
    - Using relative XPath, Print out the next element of element with Ipsum value 'Apeirian9'
    */
    @Test
    public void challenging_dom() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        String Url = "http://the-internet.herokuapp.com/challenging_dom";
        driver.get(Url);

        WebElement element = driver.findElement(By.xpath("//table//*[contains(text(), 'Apeirian9')]"));

        WebElement lorem_value = element.findElement(By.xpath("preceding-sibling::*"));
        System.out.println(lorem_value.getText());

        WebElement next_value = element.findElement(By.xpath("following-sibling::*"));
        System.out.println(next_value.getText());

        driver.close();

    }
}
