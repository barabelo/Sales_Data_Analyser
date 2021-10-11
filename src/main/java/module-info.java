module com.domain.sales_data_analyser {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires lombok;


    opens com.domain.sales_data_analyser to javafx.fxml;
    exports com.domain.sales_data_analyser;
    exports com.domain.sales_data_analyser.utils;
    opens com.domain.sales_data_analyser.utils to javafx.fxml;
    exports com.domain.sales_data_analyser.model;
    opens com.domain.sales_data_analyser.model to javafx.fxml;
}