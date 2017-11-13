package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Controller {
    @FXML
    TextField txtFld;

    @FXML
    Button btn1;

    @FXML
    Label label1;

    public void initialize() {
        txtFld.setText("18cfe2137533995d874996339ba37b53");
    }

    @FXML
    protected void handleSubmit(ActionEvent event) throws Exception {
        Main.apiKey = this.txtFld.getText();
        Stage stage = (Stage) this.btn1.getScene().getWindow();

//        TranslateTransition tt1 = new TranslateTransition(Duration.millis(1500), this.btn1);
//        tt1.setByX(-795);
//        TranslateTransition tt2 = new TranslateTransition(Duration.millis(1500), this.txtFld);
//        tt2.setByX(-650);
//        TranslateTransition tt3 = new TranslateTransition(Duration.millis(1300), this.label1);
//        tt3.setByX(-500);
//
//        tt3.play();
//        tt2.play();
//        tt1.play();

        Pane root = FXMLLoader.load(getClass().getResource("sample_2.fxml"));
        Scene scene = new Scene(root, 900, 500);
        stage.setScene(scene);


    }


}
