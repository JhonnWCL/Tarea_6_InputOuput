package controller.files;
import model.Country;
import java.util.ArrayList;

public class FileHandler {
    private WriteNewFile writeNewFile;
    private ReadFiles readFile;
    private ProcessEnteredData processEnteredData;

    public FileHandler(ArrayList<Country> countriesList) {
        readFile = new ReadFiles();
        processEnteredData = new ProcessEnteredData(countriesList);
        writeNewFile =new WriteNewFile();
    }

    public void run() {
        readFile.readSaveInformation();
        processEnteredData.setDataCompare(readFile.getMapDatesFD());
        writeNewFile.createWriteFile(processEnteredData.getTextWriter());
    }
}
