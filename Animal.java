import java.time.LocalDate;

// I feel like alot of your problems can be solved by object oriented programming.. 

public class Animal {
    public int ID; 
    public int age;
    public int weight; 
    public String UID; 
    public String name;
    public String birthday;
    public String color; 
    public String species;
    public String orgin; 
    public String country;
    public String sex; 
    public String arrival; 
    
    //We gonna do the line processing here.. 
    public Animal(String line) {
        // I found a bug with your old code and fixed it.. 
        // almost like this program is a hotfix for your code.
        String[] comma_split = line.split(", ", 0);
        for(String s : comma_split) {
            System.out.println(s);
        }

        String[] space_split = comma_split[0].split(" ", 0);
        age = Integer.parseInt(space_split[0]);
        sex = space_split[3];
        species = space_split[4];

        // The rest of the comma splits.. 
        birthday = calc_birthdate(comma_split[1]);
        color = comma_split[2];

        space_split = comma_split[3].split(" ", 0);
        weight = Integer.parseInt(space_split[0]);
        orgin = comma_split[4];
        country = comma_split[5];
        LocalDate curDate = LocalDate.now();
        arrival = curDate.toString();
        //Done!
    }

    private String calc_birthdate(String birth_season) {
        // I kept most of your code intact, just got rid of unnecessary variables
        String month_day;

        switch (birth_season) {
            // That's a bug there's somthing wrong with your comma delimiting..
            case "born in spring":
                month_day = "03-21";
                break;
            case "born in summer":
                month_day = "06-21";
                break;
            case "born in fall":
                month_day = "09-21";
                break;
            case "born in winter":
                month_day = "12-21";
                break;
            default:
                month_day = "01-01";
                break;
        }
        return (Integer.toString(2023 - age) + "-" + month_day);
    }

    public String gen_uniqueID() {
        // I shortened your function by using classes.. 
        switch (species) {
            case "hyena":
                return "Hy0" + Integer.toString(ID);
            case "lion":
                return "Li0" + Integer.toString(ID);
            case "tiger":
                return "Ti0" + Integer.toString(ID);
            case "bear":
                return "Be0" + Integer.toString(ID);
            default:
                return "ERROR";
        }
    }

    
    public String formatted_string() {
        String format = "";
        format += (UID + "; " + name + "; ");
        format += Integer.toString(age) + " years old; ";
        format += "birth date " + birthday + "; ";
        format += (color + "; " + sex + "; ");
        format += Integer.toString(weight) + " pounds; ";
        format += orgin + ", " + country + "; ";
        format += "arrvied " + arrival;
        return format;
    }

    public void print() {
        System.out.println(formatted_string());
    }
}
