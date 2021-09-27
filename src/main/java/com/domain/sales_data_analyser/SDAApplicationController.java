package com.domain.sales_data_analyser;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SDAApplicationController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}