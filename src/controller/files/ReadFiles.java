package controller.files;
import helper.NumberValidator;
import helper.Print;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFiles {
    private Map<String, double[]> mapFileDefault;
    private static String contains;
    private Matcher verfiCaptureLineText;
    private String textPath;
    private  boolean isNotDF;
   public ReadFiles(){
        this.textPath= "TazaDeNatalidaMoratlid.txt";
    }
    public ReadFiles(String nameText){
        this.textPath=nameText;
    }

    public  void readSaveInformation(){
        mapFileDefault= new HashMap<>();
        contains="";
        readFileDefault();
    }

    private void readFileDefault() {
        try {
            processReadFile();
        } catch (FileNotFoundException e) {
            Print.printException(textPath);
            NumberValidator nv= new NumberValidator();
            nv.captarExepciones();
        }
    }
    private void processReadFile() throws FileNotFoundException{
        Scanner inFile = new Scanner(new FileReader(textPath));
        while (inFile.hasNext()) {
            String lineText = inFile.nextLine().trim();
            addTextLine(lineText);
            verfiCaptureLineText = Pattern.compile("([0-9])").matcher(lineText);
            if (verfiCaptureLineText.find()&& !isNotDF) saveDefaultInformation(lineText);
        }
        inFile.close();
    }

    private void saveDefaultInformation(String lineText) {
        String[] s = (lineText.replaceFirst("\\|", "")).split("\\|");
        double tnatalidad = Double.parseDouble((s[1].trim()));
        double tmortalidad = Double.parseDouble((s[2].trim()));
        mapFileDefault.put(s[0].trim(), new double[]{tnatalidad, tmortalidad});
    }

    public Map<String, double[]> getMapDatesFD() {
        return mapFileDefault;
    }

    public String getContenido(boolean isNotReadDF){
       this.isNotDF =isNotReadDF;
        if(isNotDF)readSaveInformation();
       return contains;
    }
    private void addTextLine(String text){
        contains+=text+"\n";
    }
}