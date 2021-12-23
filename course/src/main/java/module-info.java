module ru.artem.phonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires tornadofx;
    requires java.json;
    requires java.sql;
    requires kotlin.stdlib.jdk7;
    requires kotlin.reflect;


    opens ru.artem.phonebook to javafx.fxml;
    exports ru.artem.phonebook;
    exports ru.artem.phonebook.controller;
    exports ru.artem.phonebook.view;
}
