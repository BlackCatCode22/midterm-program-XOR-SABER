import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {
    // Just use an array list.. why not 
    public ArrayList<Animal> hyena_enclosure = new ArrayList<>();
    public ArrayList<Animal> lion_enclosure = new ArrayList<>();
    public ArrayList<Animal> bear_enclosure = new ArrayList<>();
    public ArrayList<Animal> tiger_enclosure = new ArrayList<>();

    Zoo(String filename) {
        if(filename.isEmpty()) {
            System.out.println("No file given");
            System.exit(1);
        }
        Names name_service = new Names("animalNames.txt");
        try {
            File myAnimalsFile = new File(filename);
            System.out.println("The arrivingAnimals.txt file... at " + filename);
            Scanner scanner = new Scanner(myAnimalsFile);
            while (scanner.hasNextLine()) {
                String current_line = scanner.nextLine();
                if(!current_line.isEmpty()) {
                    Animal temp = new Animal(current_line);

                    switch(temp.species) {
                        case "hyena":
                            temp.ID = hyena_enclosure.size()+1;
                            temp.UID = temp.gen_uniqueID();
                            temp.name = name_service.get_hyena_name();
                            hyena_enclosure.add(temp);
                            break;
                        case "lion":
                            temp.ID = lion_enclosure.size()+1;
                            temp.UID = temp.gen_uniqueID();
                            temp.name = name_service.get_lion_name();
                            lion_enclosure.add(temp);
                            break;
                        case "tiger":
                            temp.ID = tiger_enclosure.size()+1;
                            temp.UID = temp.gen_uniqueID();
                            temp.name = name_service.get_tiger_name();
                            tiger_enclosure.add(temp);
                            break;
                        case "bear":
                            temp.ID = bear_enclosure.size()+1;
                            temp.UID = temp.gen_uniqueID();
                            temp.name = name_service.get_bear_name();
                            bear_enclosure.add(temp);
                            break;
                        default:
                            System.out.println("Unknown Species: " + temp.species + "!");
                            System.out.println("Dropping it..");
                    }
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

    public void print_zoo() {
        System.out.println("Hyena Habitat:\n");
        for (Animal animal : hyena_enclosure) {
            animal.print();
        }
        System.out.println("\nLion Habitat:\n");
        for (Animal animal : lion_enclosure) {
            animal.print();
        }
        System.out.println("\nTiger Habitat:\n");
        for (Animal animal : tiger_enclosure) {
            animal.print();
        }
        System.out.println("\nBear Habitat:\n");
        for (Animal animal : bear_enclosure) {
            animal.print();
        }
    }

    public void print_report(String filename) {
        if(filename.isEmpty()) {
            System.out.println("No file given");
            System.exit(1);
        }
        try {
            // Create a FileWriter
            FileWriter file = new FileWriter(filename);
            BufferedWriter output = new BufferedWriter(file);
            output.write("Midterm Program Output; by Alexander Betancourt, Spring 2023, Seaside, CA\n");
            output.write("\nHyena Habitat:\n");
            for (Animal animal : hyena_enclosure) {
                output.write("\t" + animal.formatted_string() + "\n");
            }
            output.write("\nLion Habitat:\n");
            for (Animal animal : lion_enclosure) {
                output.write("\t" + animal.formatted_string() + "\n");
            }
            output.write("\nTiger Habitat:\n");
            for (Animal animal : tiger_enclosure) {
                output.write("\t" + animal.formatted_string() + "\n");
            }
            output.write("\nBear Habitat:\n");
            for (Animal animal : bear_enclosure) {
                output.write("\t" + animal.formatted_string() + "\n");
            }
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
  
    }

}
