module antunes.com.marcelo.crudcommarcelo {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.sql;

    opens antunes.com.marcelo.crudcommarcelo to javafx.fxml;

    opens antunes.com.marcelo.crudcommarcelo.controller to javafx.fxml;

    opens antunes.com.marcelo.crudcommarcelo.model to javafx.base;

    exports antunes.com.marcelo.crudcommarcelo to javafx.graphics;

}