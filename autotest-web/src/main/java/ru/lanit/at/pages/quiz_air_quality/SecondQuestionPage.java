package ru.lanit.at.pages.quiz_air_quality;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name(value = "Вопрос 2/5")
public class SecondQuestionPage extends WebPage {

    @Name("Пройти опрос о качестве воздуха в Москве")
    private SelenideElement quizAirQuality = $("[class='quiz-main']").shouldHave(visible,
            text("Пройти опрос о качестве воздуха в Москве"));

    @Name("Вопрос 2/5")
    private SelenideElement question = $("[id='quiz-page-id-1'] [class='question-number']").shouldBe(visible,
            text("Вопрос 2/5"));

    @Name("Выберите характер запаха из списка")
    private SelenideElement title = $("[id='quiz-page-id-1'] [class='question-content-title']").shouldBe(visible,
            text("Выберите характер запаха из списка"));

    @Name("характер запаха из списка")
    private ElementsCollection radioInput = $$("[id='quiz-page-id-1'] [class='question-radio-input'] label");

    @Name("поле Введите ваш вариант")
    private SelenideElement placeholder = $("[id='quiz-page-id-1'] input[placeholder='Введите ваш вариант']");

    @Name("кнопка Ответить")
    private SelenideElement button = $("[id='quiz-page-id-1'] button[onclick='quiz.nextPage()']").shouldBe(text("Ответить"));
}
