package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage=new Stage();
    public static Pane root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        Scene scene = new Scene(root, 500, 275);
//      scene.getStylesheets().add("sample/style.css");
        this.root = root;
        stage.setScene(scene);
        stage.show();
//        GridPane txt = new GridPane();
//        txt.getColumnConstraints().add(new ColumnConstraints(50));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
