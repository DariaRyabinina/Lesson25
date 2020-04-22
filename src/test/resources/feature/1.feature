# language: ru
@allTest
@less25
Функционал: Работа на bspb

  Сценарий: Вход на bspb
    Дано Пользователь авторизуется в bspb
    И Входит на поле очищает и вставляет Логин "demo"
    И Входит на поле очищает и вставляет Пароль "demo"
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


