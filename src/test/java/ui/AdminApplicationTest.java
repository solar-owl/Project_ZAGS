package ui;

import elements.ApplicationRow;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.AdminDetails;
import org.testng.annotations.Test;
import utils.AdminRandomizer;

@Feature("Администрирование заявок")
@Story("Управление заявками")
public class AdminApplicationTest extends BaseTestUI {

    @Test(description = "этот тест проверяет управление заявками от имени администратора")
    @Description("Проверка подтверждения и отклонения заявок администратором")
    public void adminTest() {
        AdminDetails data = AdminRandomizer.random();
        logger.info("НАЧАЛО ТЕСТА: adminTest");

        logger.info("Авторизация администратора");
        loginPage.loginAsAdmin();

        // Первая форма: данные регистрации
        logger.info("Шаг 1: заполнение данных регистрации администратора");
        adminDetailsPage.fillAllFieldsInDetailForm(data);
        stepPage.checkNextButtonEnabled()
                .clickNextButton();

        // Вторая форма: администрирование заявок
        // Подтверждение заявки
        logger.info("Шаг 2: переход по страницам таблицы");
        adminApplicationPage.goToNextPage()
                .goToPage(3)
                .goToPreviousPage()
                .goToPage(1);

        // можно добавить пререквизит с созданием конкретной заявки и потом с ней работать
        logger.info("Шаг 3: подтверждение первой заявки со статусом '{}'", STATUS_PENDING);
        // ApplicationRow rowToApprove = adminApplicationPage.getRows().get(2);
        ApplicationRow rowToApprove = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String approvedApplicationNumber = rowToApprove.getNumber();
        logger.info("Найдена заявка для подтверждения: {}", approvedApplicationNumber);
        adminApplicationPage.checkRowStatus(rowToApprove, STATUS_PENDING);

        rowToApprove.approve();
        logger.info("Заявка {} подтверждена, ожидание статуса '{}'", approvedApplicationNumber, STATUS_APPROVED);
        adminApplicationPage.waitForStatus(approvedApplicationNumber, STATUS_APPROVED);

        ApplicationRow approvedRow = adminApplicationPage.getRowByNumber(approvedApplicationNumber);
        adminApplicationPage.checkRowStatus(approvedRow, STATUS_APPROVED);
        logger.info("Статус заявки {} успешно проверен: '{}'", approvedApplicationNumber, STATUS_APPROVED);

        // Отклонение заявки
        logger.info("Шаг 4: отклонение первой заявки со статусом '{}'", STATUS_PENDING);
        // ApplicationRow rowToReject = adminApplicationPage.getRows().get(4);
        ApplicationRow rowToReject = adminApplicationPage.getFirstRowWithStatus(STATUS_PENDING);
        String rejectedApplicationNumber = rowToReject.getNumber();
        logger.info("Найдена заявка для отклонения: {}", rejectedApplicationNumber);
        adminApplicationPage.checkRowStatus(rowToReject, STATUS_PENDING);

        rowToReject.reject();
        logger.info("Заявка {} отклонена, ожидание статуса '{}'", rejectedApplicationNumber, STATUS_REJECTED);
        adminApplicationPage.waitForStatus(rejectedApplicationNumber, STATUS_REJECTED);

        ApplicationRow rejectedRow = adminApplicationPage.getRowByNumber(rejectedApplicationNumber);
        adminApplicationPage.checkRowStatus(rejectedRow, STATUS_REJECTED);
        logger.info("Статус заявки {} успешно проверен: '{}'", rejectedApplicationNumber, STATUS_REJECTED);

        logger.info("ТЕСТ adminTest ЗАВЕРШЁН УСПЕШНО");
    }
}