package sample;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IndicoImageClassification {

    public String[] nameFiles;
    public static double getMaxValue(Collection<Double> doubleSet) {
        double max = Double.NEGATIVE_INFINITY;
        for (double i : doubleSet) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public boolean classify(String pathToDir, String apiKey) throws IndicoException, WrongPathException, IOException {
        //validation if api key does not fit
        Indico indico = new Indico(apiKey);

        File dirWithImg = new File(pathToDir);
        //validate path
        if(!dirWithImg.isDirectory())
            throw new WrongPathException("You pass wrong path");

        String[] fileNames = dirWithImg.list();
        this.nameFiles = fileNames;
        String[] arrayWithImg = new String[dirWithImg.listFiles().length];
        Main.fileList = new String[dirWithImg.listFiles().length];

        //counter for looping through array
        int counterForFiles = 0;

        //saving Paths of images to array
        for (File img : dirWithImg.listFiles()) {
            arrayWithImg[counterForFiles] = img.getAbsolutePath();
            Main.fileList[counterForFiles] = img.getName();
            counterForFiles++;
        }

        //saving pathList for image displaying
        Main.pathList = arrayWithImg;

        // using api for image recognition and saving the result in list of map<category,probability(value)>
        BatchIndicoResult multiple = indico.imageRecognition.predict(arrayWithImg);
        List<Map<String, Double>> result = multiple.getImageRecognition();
        List<Map<String, Double>> listResultSorted = new ArrayList<Map<String, Double>>();

        for(Map<String, Double> k : result) {
            Map<String, Double> sortedResult = new HashMap<>();
            for(Map.Entry<String, Double> entry: k.entrySet()){
                if(entry.getValue() > 0.005){
                    sortedResult.put(entry.getKey(), entry.getValue());
                    listResultSorted.add(sortedResult);
                }
            }
        }

        Main.results = listResultSorted;
        return true;

    }



}
