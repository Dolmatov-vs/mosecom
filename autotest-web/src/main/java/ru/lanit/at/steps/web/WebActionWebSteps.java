package ru.lanit.at.steps.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import ru.lanit.at.actions.WebActions;
import ru.lanit.at.utils.Sleep;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static ru.lanit.at.utils.VariableUtil.replaceVars;


public class WebActionWebSteps extends AbstractWebSteps {

    public WebActionWebSteps(PageManager pageManager) {
        super(pageManager);
    }


    /**
     * нажимает на элемент по тексту
     *
     * @param text текст элемента
     */
    @Когда("кликнуть на элемент по тексту {string}")
    public void clickElementWithText(String text) {
        $(Selectors.byText(text))
                .shouldBe(Condition.visible)
                .click();
        LOGGER.info("клик на элемент по тексту '{}'", text);
    }

    @Если("кликнуть на элемент {string}")
    public void clickOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        LOGGER.info("клик на элемент '{}'", elementName);
    }

    @Если("кликнуть на элемент {string} с текстом {string}")
    public void clickOnElementWithText(String elementName, String text) {
        ElementsCollection elements = pageManager
                .getCurrentPage()
                .getElementsCollection(elementName);
        elements
                .find(Condition.text(text))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();
        LOGGER.info("клик на элемент '{}' с текстом {}", elementName, text);
    }

    @Если("установить месяц и год {string}")
    public void setMonthAndYear(String newDateInString) {
        Date newDate = dateFormatter(newDateInString, "MM.yyyy");
        Date currentDate;

        do {
            String month = pageManager
                    .getCurrentPage()
                    .getElement("месяц").getText();

            String year = pageManager
                    .getCurrentPage()
                    .getElement("год").getText();

            currentDate = dateFormatter(month + "." + year, "MMMM.yyyy");

            if (newDate.before(currentDate)) {
                pageManager
                        .getCurrentPage()
                        .getElement("предыдущий месяц")
                        .shouldBe(Condition.visible, Duration.ofSeconds(10))
                        .click();
            } else if (newDate.after(currentDate)) {
                pageManager
                        .getCurrentPage()
                        .getElement("следующий месяц")
                        .shouldBe(Condition.visible, Duration.ofSeconds(10))
                        .click();
            }
        } while (!newDate.equals(currentDate));
        LOGGER.info("Месяц и год календаря выставлены в значение '{}'", newDate);
    }

    @Если("установить чекбокс на элементе {string}")
    public void selectCheckboxOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.enabled, Duration.ofSeconds(60));
        WebActions.setCheckBox(element, true);
        LOGGER.info("чекбокс  установлен на элементе '{}'", elementName);
    }

    @Если("убрать чекбокс на элементе {string}")
    public void unselectCheckboxOnElement(String elementName) {
        SelenideElement element = pageManager
                .getCurrentPage()
                .getElement(elementName);
        element
                .shouldBe(Condition.enabled, Duration.ofSeconds(60));
        WebActions.setCheckBox(element, false);
        LOGGER.info("чекбокс снят на элементе '{}'", elementName);
    }


    /**
     * скролл до элемента
     *
     * @param elementName наименование элемента
     */
    @Когда("проскроллить страницу до элемента {string}")
    public void scrollToElement(String elementName) {
        SelenideElement element = pageManager.getCurrentPage().getElement(elementName);
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до элемента '{}'", elementName);
    }

    /**
     * скролл до текста
     *
     * @param text текст
     */
    @Когда("проскроллить страницу до текста {string}")
    public void scrollToText(String text) {
        SelenideElement element = $(Selectors.byText(text));
        element.shouldBe(Condition.visible)
                .scrollIntoView("{block: 'center'}");
        LOGGER.info("скролл страницы до текста '{}'", text);
    }

    @И("подождать {int} сек")
    public void waitSeconds(int timeout) {
        Sleep.pauseSec(timeout);
    }

    /**
     * Ввод значения в элемент
     *
     * @param field - наименование элемента
     * @param value - значение
     */
    @Когда("ввести в поле {string} значение {string}")
    public void fillTheField(String field, String value) {
        value = replaceVars(value, getStorage());
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        fieldElement
                .shouldBe(Condition.visible, Duration.ofSeconds(60))
                .setValue(value);
        LOGGER.info("в поле '{}' введено значение '{}'", field, value);
    }

    /**
     * Сохранить  значения из элемент
     *
     * @param field - наименование элемента
     * @param key   - значение
     */
    @Когда("сохранить значение из поля {string} под именем {string}")
    public void saveTextField(String field, String key) {
        SelenideElement fieldElement = pageManager
                .getCurrentPage()
                .getElement(field);
        String elementValue = fieldElement
                .shouldBe(Condition.visible, Duration.ofSeconds(60))
                .getValue();
        saveValueInStorage(key, elementValue);
        LOGGER.info("значение '{}' сохранено под именем '{}'", elementValue, key);
    }

    /**
     * Очистка поля
     *
     * @param elementName наименование элемента
     */
    @Если("очистить поле {string}")
    public void clearFiled(String elementName) {
        pageManager
                .getCurrentPage()
                .getElement(elementName)
                .shouldBe(Condition.visible)
                .clear();
    }

    private Date dateFormatter(String stringDate, String format) {
        SimpleDateFormat ft = new SimpleDateFormat(format, new Locale("ru"));
        try {
            return ft.parse(stringDate);
        } catch (ParseException e) {
            LOGGER.error("Ошибка парсинга даты '{}'", stringDate);
        }
        return null;
    }
}
