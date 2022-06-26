#language:ru
@test

Функционал: Образец GET запроса

  Сценарий: Запрос в bookstore к книге Just Spring Integration

#    Когда создать контекстные переменные
#      | book | Just Spring Integration |

    И создать запрос
      | method | path                                         |
      | GET    |  |
    Тогда отправить запрос
    И статус код 200

    Когда извлечь данные
      | title    | $.books[?(@.title=='${book}')].title    |
      | subtitle | $.books[?(@.title=='${book}')].subtitle |
      | price    | $.books[?(@.title=='${book}')].price    |

    И сравнить значения
      | ${title}    | ==       | Just Spring Integration                          |
      | ${subtitle} | ==       | A Lightweight Introduction to Spring Integration |
      | ${price}    | содержит | 16.99                                            |