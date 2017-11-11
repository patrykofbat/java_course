package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Main extends Application {
    public static Pane root;
    public static String[] pathList;
    public static String[] fileList;
    public static String chosenDirPath;
    public static String apiKey;
    public static List<Map<String, Double>> results;
    public static int selectedIndex;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        this.root = root;
        primaryStage.setTitle("Indico");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
