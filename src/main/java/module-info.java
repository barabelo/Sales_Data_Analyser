module com.domain.sales_data_analyser {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.domain.sales_data_analyser to javafx.fxml;
    exports com.domain.sales_data_analyser;
}