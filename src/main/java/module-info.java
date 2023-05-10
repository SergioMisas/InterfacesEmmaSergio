module com.example.interfacesemmasergio {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlin.result.jvm;
    requires io.github.microutils.kotlinlogging;
    requires org.slf4j;


    opens com.example.interfacesemmasergio to javafx.fxml;
    exports com.example.interfacesemmasergio;

    opens com.example.interfacesemmasergio.controllers to javafx.fxml;
    exports com.example.interfacesemmasergio.controllers;
}
