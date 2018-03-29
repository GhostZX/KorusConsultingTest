Используя: Java, Maven/Gradle, TestNG, нативный Selenium или Selenide На странице поисковика
google проверить на UI:
1) Поиск по: Названию, ФИО. (за валидный поиск берётся текущий вывод вашего поискового
запроса).
2) При наведении мыши на поле ввода выводится соответствующая всплывающая подсказка(в
google это слово «Поиск»).
3) После нажатия на лого в верхней левой части отображается пустая область результатов.

На API (используя RestAssured):
1) Проверить работоспособность запроса поиска
http://lkk.esphere.ru/informator/api/v2/task/search?innOgrn= (по параметрам: ИНН: 7703228474,
ОГРН: 1037739437966)
2) Проверить корректность возвращаемой модели по схеме (json-schema)
В проекте настройте отчет Allure по результатам прогона тестов.
Проект можете выложить на github, либо прислать нам архивом.


Getting started:
mvn clean test - run your tests
You can generate a report using one of the following command:

mvn allure:report
Report will be generated tо directory: target/site/allure-maven/index.html