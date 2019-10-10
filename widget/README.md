1. В ветке master - находится основной проект (с реализацией бд в RAM) с пагинацией. В ветке Database - прибавляется реализация с базой данных h2.

2. Для работы с базой данных h2, необходимо в классе Util (package wid.widget.bl;) указать свое значение URL в поле - "DB_URL";

3. Запуск приложения осуществляется посредством класса WidgetApplication (package wid.widget;);

4. Работа с базой данных h2 осуществляется через контроллер WidgetControllerH2 (package wid.widget.controller;);

5. Работа с RAM бд необходимо работать через контроллер WidgetController (package wid.widget.controller;).