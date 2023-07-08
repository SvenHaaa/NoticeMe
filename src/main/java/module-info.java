module com.noticeme {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires java.xml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.noticeme to javafx.fxml;
    opens com.noticeme.controller to javafx.fxml;
    opens com.noticeme.model to javafx.base;

    exports com.noticeme;
    exports com.noticeme.controller;
    opens com.noticeme.common to javafx.base;
}