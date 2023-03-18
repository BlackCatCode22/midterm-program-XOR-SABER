/*
 * Midterm Zoo: Alexander Betancourt 
 * Seaside, Ca
 * 3/18/2023
 * 
 * Midterm Program: not my choice but a program none of the less.. 
 */

public class midterm {
    public static void main(String[] args) {
        // I want everyone to know, I programmed this while drinking a pint of blue moon.
        // This may not be efficent like I would make a c++ program, but DAMIT we are making 
        // the best zoo imaginable.. 

        // Ever heard the term that main should be a small as possible? 
        Zoo current_zoo = new Zoo("arrivingAnimals.txt");
        current_zoo.print_zoo(); 
        current_zoo.print_report("javaOutputfileAlex.txt");
    }
}