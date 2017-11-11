package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URI;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Button btn1 ;
    @FXML
    private Label label1;
    @FXML
    protected void initialize(URI url, ResourceBundle rsc){
        label1.setText("other");
        Main.stage.show();
    }


    @FXML
    protected  void handleSubmitButtonAction(ActionEvent event)throws Exception{
        initialize(null,null);
        Parent root = FXMLLoader.load(getClass().getResource("sample_2.fxml"));
        Scene scene = new Scene(root,500,275);
        Stage stage = (Stage)btn1.getScene().getWindow();

        //Main.stage.setScene(scene);
        //Main.stage.show();
       // Main.root.getChildren().remove(this.label1);

        Platform.runLater(()->{
            while(true){
            System.out.println("siemka");
        }});



    }

}
