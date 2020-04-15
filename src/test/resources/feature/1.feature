# language: ru

Функционал: Работа на bspb

  Сценарий: Вход на bspb
    Дано Пользователь авторизуется в bspb
    И входит на поле Логин очищает и вставляет Логин
    И входит на поле Пароль очищает и вставляет Пароль
    Когда нажимает кнопку Войти
    Тогда впереход на ЭФ Ввод кода

  Сценарий: Введение кода
    Дано Введение кода
    Когда Нажать на кнопку Войти
    Тогда Переход на ЭФ Welcome

  Сценарий: Выбор Меню
    Когда Нажать на кнопку Oбзор
    Тогда Переход на ЭФ Обзор

  Сценарий: Проверка названия страницы
    Тогда Название соответствует Обзор

  Сценарий: Проверка блока Финансовая свобода
    Тогда  Название блока Финансовая свобода
    К тому же Проверка, сумма соответствует формату

  Сценарий: Проверка Появления надписи Моих средств
    Когда Перейти мышкой на поле Суммы
    Тогда Проверка, наличия поля Моих средств
    К тому же Проверка, сумма моих средств соответствует формату


