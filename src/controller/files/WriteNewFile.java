package controller.files;
import helper.NumberValidator;
import helper.Print;

import java.io.*;
public class WriteNewFile {
    protected void createWriteFile(String text) {
        try {
            FileWriter write = new FileWriter("registerCountries.txt");
            write.write(text);
            write.close();
        } catch (IOException e) {
            Print.printException("registerCountries.txt");
            NumberValidator nv= new NumberValidator();
            nv.captarExepciones();
        }
    }
}
