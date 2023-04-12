
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Example: write and read lines of text to file
 * @author Jose
 */
public class LineFile {

    private final String filename;

    public LineFile(String filename) {
        this.filename = filename;
    }
    
    public static void main(String[] args) {
        String filename = "lines.txt";
        LineFile ap = new LineFile(filename);
        ap.run();
    }

    private void run() {
        //create lines
        List<String> lines = createLines();
        //display lines
        System.out.println("Initial data:");
        displayList(lines);
        //save lines to file
        saveLinesToFile(lines, filename);
        //read lines from file
        List<String> lines2 = readLinesFromFile(filename);
        //display read lines
        System.out.println("Read data:");
        displayList(lines2);
    }
    
    private List<String> createLines() {
        List<String> data = new ArrayList<>();
        data.add("Dabale arroz a la zorra el abad");
        data.add("En un lugar de la Mancha");
        data.add("de cuyo nombre no quiero acordarme");
        data.add("No dejes para mañana lo que puedas hacer hoy");
        return data;
    }
    
    private <T> void displayList(List<T> data) {
        data.forEach(System.out::println);
    }
    
    private void saveLinesToFile(List<String> data, String filename) {
        try (PrintStream out = new PrintStream(filename)) {
            for (String elem : data) {
                out.println(elem);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private List<String> readLinesFromFile(String filename) {
        List<String> data = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String elem;
            while ( (elem = in.readLine())!= null ) {
                data.add(elem);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }        
        return data;
    }
}
