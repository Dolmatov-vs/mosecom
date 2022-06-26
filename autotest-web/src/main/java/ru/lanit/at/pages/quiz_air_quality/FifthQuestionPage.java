package ru.lanit.at.pages.quiz_air_quality;

import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Name(value = "Вопрос 5/5")
public class FifthQuestionPage extends WebPage {

    @Name("Пройти опрос о качестве воздуха в Москве")
    private SelenideElement quizAirQuality = $("[class='quiz-main']").shouldHave(visible,
            text("Пройти опрос о качестве воздуха в Москве"));

    @Name("Вопрос 5/5")
    private SelenideElement question = $("[id='quiz-page-id-4'] [class='question-number']").shouldBe(visible,
            text("Вопрос 5/5"));

    @Name("Оставьте комментарий")
    private SelenideElement title = $("[id='quiz-page-id-4'] [class='question-content-title']").shouldBe(visible,
            text("Оставьте комментарий"));

    @Name("поле Комментарий")
    private SelenideElement comment = $("[id='quiz-page-id-4'] textarea[id='comment']");

    @Name("кнопка Ответить")
    private SelenideElement button = $("[id='quiz-page-id-4'] button[onclick='quiz.nextPage()']").shouldBe(text("Ответить"));
}
