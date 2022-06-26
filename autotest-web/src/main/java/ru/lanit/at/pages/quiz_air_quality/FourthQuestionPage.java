package ru.lanit.at.pages.quiz_air_quality;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name(value = "Вопрос 4/5")
public class FourthQuestionPage extends WebPage {

    @Name("Пройти опрос о качестве воздуха в Москве")
    private SelenideElement quizAirQuality = $("[class='quiz-main']").shouldHave(visible,
            text("Пройти опрос о качестве воздуха в Москве"));

    @Name("Вопрос 4/5")
    private SelenideElement question = $("[id='quiz-page-id-3'] [class='question-number']").shouldBe(visible,
            text("Вопрос 4/5"));

    @Name("Выберите периодичность появления запахов")
    private SelenideElement title = $("[id='quiz-page-id-3'] [class='question-content-title']").shouldBe(visible,
            text("Выберите периодичность появления запахов"));

    @Name("периодичность появления запахов")
    private ElementsCollection questionRadioInput = $$("[id='quiz-page-id-3'] [class='question-radio-input']");

    @Name("кнопка Ответить")
    private SelenideElement button = $("[id='quiz-page-id-3'] button[onclick='quiz.nextPage()']").shouldBe(text("Ответить"));
}
