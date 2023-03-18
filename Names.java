import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Names {
    private Stack<String> hyena_names = new Stack<>(); 
    private Stack<String> lion_names = new Stack<>(); 
    private Stack<String> tiger_names = new Stack<>(); 
    private Stack<String> bear_names = new Stack<>(); 
    
    Names(String filename) {
        if(filename.isEmpty()) {
            System.out.println("No file given");
            System.exit(1);
        }
        try {
            // Doing the name file/IO
            File myAnimalsFile = new File(filename);
            System.out.println("The animal_names.txt file... at " + filename);
            Scanner scanner = new Scanner(myAnimalsFile);
            while (scanner.hasNextLine()) {
                String current_line = scanner.nextLine();
                String[] colon_split = current_line.split(": ", 0);
                switch (colon_split[0]) {
                    case "Hyena Names":
                        hyena_names.addAll(Arrays.asList(process_line(colon_split[1])));
                        break;
                    case "Lion Names":
                        lion_names.addAll(Arrays.asList(process_line(colon_split[1])));
                        break;
                    case "Bear Names":
                        bear_names.addAll(Arrays.asList(process_line(colon_split[1])));
                        break;
                    case "Tiger Names":
                        tiger_names.addAll(Arrays.asList(process_line(colon_split[1])));
                        break;
                    default:
                        break;
                }
                
            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("A file error occured...");
            error.printStackTrace();

            // No file exit the program.. 
            System.exit(1);
        }
    }
    private String[] process_line(String line) {
        // a function to process out a name
        return line.split(", ", 0);
    }

    //All these get a name from the top of the stack at 0(1) time.. 
    public String get_hyena_name() {
        return hyena_names.pop();
    }
    public String get_lion_name() {
        return lion_names.pop();
    }
    public String get_bear_name() {
        return bear_names.pop();
    }
    public String get_tiger_name() {
        return tiger_names.pop();
    }
}
