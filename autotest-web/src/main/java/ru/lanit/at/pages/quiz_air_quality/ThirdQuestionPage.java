package ru.lanit.at.pages.quiz_air_quality;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name(value = "Вопрос 3/5")
public class ThirdQuestionPage extends WebPage {

    @Name("Пройти опрос о качестве воздуха в Москве")
    private SelenideElement quizAirQuality = $("[class='quiz-main']").shouldHave(visible,
            text("Пройти опрос о качестве воздуха в Москве"));

    @Name("Вопрос 3/5")
    private SelenideElement question = $("[id='quiz-page-id-2'] [class='question-number']").shouldBe(visible,
            text("Вопрос 3/5"));

    @Name("Выберите характер запаха из списка")
    private SelenideElement title = $("[id='quiz-page-id-2'] [class='question-content-title']").shouldBe(visible,
            text("Выберите дату и временные отрезки появления запаха"));

    @Name("Выберите дату")
    private SelenideElement placeholderDate = $("[id='quiz-page-id-2'] input[placeholder='Выберите дату']");

    @Name("Выберите временные отрезки")
    private SelenideElement placeholderTime = $("[id='quiz-page-id-2'] [placeholder='Выберите временные отрезки']");

    @Name("временные отрезки")
    private ElementsCollection checkbox = $$("[id='quiz-page-id-2'] [class='custom-checkbox-input']");

    @Name("кнопка Ответить")
    private SelenideElement button = $("[id='quiz-page-id-2'] button[onclick='quiz.nextPage()']").shouldBe(text("Ответить"));
}
