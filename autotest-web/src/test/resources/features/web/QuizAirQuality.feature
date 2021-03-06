#language:ru
@mosecom
Функционал: Пройти опрос о качестве воздуха в Москве

  Сценарий: Открытие страницы mosecom.mos.ru, пройти опрос "Пройти опрос о качестве воздуха в Москве"

    * шаг № "1"
    * открыть url "https://mosecom.mos.ru/"
    * инициализация страницы "МОСЭКОМОНИТОРИНГ"

    * шаг № "2"
    * инициализация страницы "Вопрос 1/5"
    * ввести в поле "поле Улица, дом" значение "Нагатинская"
    * кликнуть на элемент "Выберите вариант или продолжите ввод" с текстом "город Москва, Нагатинская улица, дом 16А, строение 31"
    * кликнуть на элемент "кнопка Ответить"

    * шаг № "3"
    * инициализация страницы "Вопрос 2/5"
    * кликнуть на элемент "характер запаха из списка" с текстом "Другое"
    * ввести в поле "поле Введите ваш вариант" значение "Отходы"
    * кликнуть на элемент "кнопка Ответить"

    * шаг № "4"
    * инициализация страницы "Вопрос 3/5"
    * кликнуть на элемент "Выберите дату"

    * инициализация страницы "Виджет Календарь"
    * установить месяц и год "02.2022"
    * кликнуть на элемент "выбрать день месяца" с текстом "7"

    * инициализация страницы "Вопрос 3/5"
    * кликнуть на элемент "Выберите временные отрезки"
    * кликнуть на элемент "временные отрезки" с текстом "12:00 - 18:00"
    * кликнуть на элемент "временные отрезки" с текстом "18:00 - 00:00"
    * кликнуть на элемент "кнопка Ответить"

    * шаг № "5"
    * инициализация страницы "Вопрос 4/5"
    * кликнуть на элемент "периодичность появления запахов" с текстом "Несколько раз в неделю"
    * кликнуть на элемент "кнопка Ответить"

    * шаг № "6"
    * инициализация страницы "Вопрос 5/5"
    * на странице имеется элемент "поле Комментарий"