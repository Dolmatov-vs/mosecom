package ru.lanit.at.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Name(value = "Виджет Календарь")
public class DatePickerPage extends WebPage {

    @Name("Календарь")
    private SelenideElement datePicker = $("[id='ui-datepicker-div']");

    @Name("месяц")
    private SelenideElement month = $("[id='ui-datepicker-div'] [class='ui-datepicker-month']");

    @Name("год")
    private SelenideElement year = $("[id='ui-datepicker-div'] [class='ui-datepicker-year']");

    @Name("предыдущий месяц")
    private SelenideElement prevMonth = $("[class^='ui-datepicker-prev']");

    @Name("следующий месяц")
    private SelenideElement nextMonth = $("[class^='ui-datepicker-next']");

    @Name("выбрать день месяца")
    private ElementsCollection selectDay = $$("[id='ui-datepicker-div'] [data-handler='selectDay'] a");
}
