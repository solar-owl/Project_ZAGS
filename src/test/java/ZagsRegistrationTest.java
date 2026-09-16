import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ZagsRegistrationTest {
    public static void main(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        String username = "user";
        String password = "senlatest";
        String url = "https://" + username + ":" + password + "@regoffice.senla.eu";

        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(., 'Войти как пользователь')]")).click();
        //Первая форма Данные заявителя
        driver.findElement(By.xpath("//div[contains(., 'Фамилия')]/following-sibling::input")).sendKeys("Холланд");
        driver.findElement(By.xpath("//div[contains(., 'Имя')]/following-sibling::input")).sendKeys("Том");
        driver.findElement(By.xpath("//div[contains(., 'Отчество')]/following-sibling::input")).sendKeys("Иванович");
        driver.findElement(By.xpath("//div[contains(., 'Телефон')]/following-sibling::input")).sendKeys("85553535");
        driver.findElement(By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input")).sendKeys("85553535");
        driver.findElement(By.xpath("//div[contains(., 'Адрес прописки')]/following-sibling::input")).sendKeys("Москва");
        By nextButton = By.xpath("//button[text()='Далее']");
        Assert.assertTrue(driver.findElement(nextButton).isEnabled(),   "Кнопка disabled");
        driver.findElement(nextButton).click();
        //Выбор услуги
        driver.findElement(By.xpath("//button[text()='Регистрация брака']")).click();
        //Вторая форма Данные гражданина
        driver.findElement(By.xpath("//div[contains(., 'Фамилия')]/following-sibling::input")).sendKeys("Холланд");
        driver.findElement(By.xpath("//div[contains(., 'Имя')]/following-sibling::input")).sendKeys("Том");
        driver.findElement(By.xpath("//div[contains(., 'Отчество')]/following-sibling::input")).sendKeys("Иванович");
        driver.findElement(By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input")).sendKeys("01.06.1996");
        driver.findElement(By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input")).sendKeys("85553535");
        driver.findElement(By.xpath("//div[contains(., 'Пол')]/following-sibling::input")).sendKeys("Муж");
        driver.findElement(By.xpath("//div[contains(., 'Адрес прописки')]/following-sibling::input")).sendKeys("Москва");
        Assert.assertTrue(driver.findElement(nextButton).isEnabled(),   "Кнопка disabled");
        driver.findElement(nextButton).click();
        //Третья форма Данные услуги
        driver.findElement(By.xpath("//div[contains(., 'Дата регистрации')]/following-sibling::input")).sendKeys("05.08.2026");
        driver.findElement(By.xpath("//div[contains(., 'Новая фамилия')]/following-sibling::input")).sendKeys("Холланд");
        driver.findElement(By.xpath("//div[contains(., 'Фамилия супруга')]/following-sibling::input")).sendKeys("Холланд");
        driver.findElement(By.xpath("//div[contains(., 'Имя супруга')]/following-sibling::input")).sendKeys("Зендея");
        driver.findElement(By.xpath("//div[contains(., 'Отчество супруга')]/following-sibling::input")).sendKeys("Ивановна");
        driver.findElement(By.xpath("//div[contains(., 'Дата рождения')]/following-sibling::input")).sendKeys("01.09.1996");
        driver.findElement(By.xpath("//div[contains(., 'Номер паспорта')]/following-sibling::input")).sendKeys("85553535");
        By buttonComplete = By.xpath("//button[text()='Завершить']");
        Assert.assertTrue(driver.findElement(buttonComplete).isEnabled(),   "Кнопка disabled");
        driver.findElement(buttonComplete).click();
        //Статус заявки
        String thanks = driver.findElement(By.xpath("//span[contains(text(),'Спасибо')]")).getText();
        Assert.assertEquals(thanks, "Спасибо за обращение!");
        String status = driver.findElement(By.xpath("//span[contains(.,'Статус заявки:')]")).getText();
        Assert.assertEquals(status, "Статус заявки: На рассмотрении.");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM d yyyy", Locale.ENGLISH);
        String formattedDate = today.format(formatter);
        String date = driver.findElement(By.xpath("//span[contains(.,'Дата')]")).getText();
        Assert.assertEquals(date, "Дата регистрации заявки " + formattedDate);
        driver.quit();
    }
}
