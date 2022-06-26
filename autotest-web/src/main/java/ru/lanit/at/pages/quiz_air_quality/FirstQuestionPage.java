package ru.lanit.at.pages.quiz_air_quality;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name(value = "Вопрос 1/5")
public class FirstQuestionPage extends WebPage {

    @Name("Пройти опрос о качестве воздуха в Москве")
    private SelenideElement quizAirQuality = $("[class='quiz-main']").shouldHave(visible,
            text("Пройти опрос о качестве воздуха в Москве"));

    @Name("Вопрос 1/5")
    private SelenideElement question = $("[id='quiz-page-id-0'] [class='question-number']").shouldBe(visible,
            text("Вопрос 1/5"));

    @Name("Укажите адрес появления запаха")
    private SelenideElement title = $("[id='quiz-page-id-0'] [class='question-content-title']").shouldBe(visible,
            text("Укажите адрес появления запаха"));

    @Name("поле Улица, дом")
    private SelenideElement address = $("[id='quiz-page-id-0'] input[id='address-autocomplete']");

    @Name("Выберите вариант или продолжите ввод")
    private ElementsCollection addressAutocompleteOptions = $$("[id='address-autocomplete-options'] [class='ui-menu-item']");

    @Name("кнопка Ответить")
    private SelenideElement button = $("[id='quiz-page-id-0'] button[onclick='quiz.nextPage()']").shouldBe(text("Ответить"));

}
