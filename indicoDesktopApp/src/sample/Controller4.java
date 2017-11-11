package sample;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;


public class Controller4 implements Initializable{

// api key 18cfe2137533995d874996339ba37b53
    @FXML
    ComboBox comboBox;

    @FXML
    ImageView img;

    @FXML
    BarChart<String, Number> barChart;

    @FXML
    NumberAxis yAxis;

    @FXML
    CategoryAxis xAxis;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> nameList = new ArrayList<String>();

        for(String i:Main.fileList)
            nameList.add(i);
        ObservableList<String> list = FXCollections.observableList(nameList);
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(0);

        File file = new File(Main.pathList[comboBox.getSelectionModel().getSelectedIndex()]);
        Image image = new Image(file.toURI().toString());
        this.img.setImage(image);

        horizontalBarChart(Main.results.get(0));

    }

    public void horizontalBarChart(Map<String, Double> map){
        barChart.getData().clear();
        xAxis.getCategories().clear();

        this.barChart.setTitle("Image Classify");
        xAxis.setLabel("Category");
        xAxis.autosize();
        yAxis.setLabel("Value");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Value");

        for (Map.Entry<String, Double> k :map.entrySet()){
            series1.getData().add(new XYChart.Data<String, Number>(k.getKey(),k.getValue()));
        }
        this.barChart.getData().addAll(series1);



    }

    @FXML
    public void comboBoxHandle(MouseEvent event){
        this.comboBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
//                    System.out.println("This is newValue " + newValue);
                    Main.selectedIndex = comboBox.getItems().indexOf(newValue);
                    for(Map.Entry<String, Double> entry : (Main.results.get(Main.selectedIndex).entrySet())){
                        System.out.println("=============================");
                        System.out.println(newValue);
                        System.out.println(comboBox.getItems().indexOf(newValue));
                        System.out.println(entry.getKey() +" = "+entry.getValue());
                    }

                    System.out.println(Main.selectedIndex);
                    File file = new File(Main.pathList[Main.selectedIndex]);
                    Image image = new Image(file.toURI().toString());
                    this.img.setImage(image);
                    horizontalBarChart(Main.results.get(Main.selectedIndex));
                }
        );

    }


}
