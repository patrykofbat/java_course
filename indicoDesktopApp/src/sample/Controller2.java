package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller2 {

    @FXML
    Button btn1;


    @FXML
    protected void handleSubmit(ActionEvent event) throws Exception{
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("JavaFX Projects");
        File defaultDirectory = new File("C:\\Users\\Patryk\\Documents\\Obrazki");
        chooser.setInitialDirectory(defaultDirectory);
        Stage stage = (Stage)this.btn1.getScene().getWindow();
        File selectedDirectory = chooser.showDialog(stage);
        Main.chosenDirPath = selectedDirectory.getAbsolutePath();
    }

    @FXML
    protected void handleSubmit2(ActionEvent event) throws Exception{
        Stage stage = (Stage)this.btn1.getScene().getWindow();
        Pane root = FXMLLoader.load(getClass().getResource("sample_3.fxml"));
        Scene scene = new Scene(root,900, 500);
        stage.setScene(scene);
        Platform.runLater(()->{
            try{
                Thread.sleep(10000);
                IndicoImageClassification classificator = new IndicoImageClassification();
                if(classificator.classify(Main.chosenDirPath, Main.apiKey)){
                    Pane root_2 = FXMLLoader.load(getClass().getResource("sample_4.fxml"));
                    stage.setScene(new Scene(root_2, 900, 500));
                }

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        });

    }



}
