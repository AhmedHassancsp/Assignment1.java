import java.util.Scanner;

public class PetDatabase {
	
	static Pet[] pets = new Pet[5]; // creating an pet array.
	
	static int petCount = 0;
	
	static Scanner s = new Scanner(System.in);
	
	private static int getUserChoice() {
		
		//TAKING USER INPUT FOR WHAT THEY WANT TO DO.
		
		Scanner input = new Scanner(System.in);
		System.out.println("What Would you like to do?\n");
		System.out.println("1) View all pets");
		System.out.println("2) Add  more pets");
		System.out.println("3) Update an  existing pets");
		System.out.println("4) Remove an existing pet");
		System.out.println("5) Search pets by name");
		System.out.println("6) Search pets by age");
		System.out.println("7) Exit program");
		int playerChoice = input.nextInt();
		
		return  playerChoice; // RETURNING THEIR CHOICE
		
	}


    // CREATING A METHOD THAT ADD NAME AND AGE
    private static void addPets() {
        //Let the user add how ever many pet they want
        //Accept the user input of name and age.
        //Create an Pet object and add that object to Pets array
        //Keep track of how many pets the user enters.
        //Create a While loop where name does not equal "done".
        String name = "";
        int age = 0;
        
        // LOOPING WHILE THE NAME DOES NOT EQUAL DONE
        while (name != "done") {
            System.out.println("add pet (name, age): ");
            name = s.next();
            
            if (name.equals("done")) {
                break;
            }
            age = s.nextInt();
            pets[petCount] = new Pet(name, age);
            petCount += 1;
            //System.out.println(petCount);
        }
        
    }

    // CREATING A METHOD THAT PRINTS THE TABLE HEADER
    private static void printTableHeader() {
        System.out.printf("+-------------------------+%n");
        System.out.printf("|%-3s | %-10s |%4s |%n", "ID", "NAME", "AGE");
        System.out.printf("+-------------------------+\n");
    }

    private static void printTableRow(int id, String name, int age ){
		
			System.out.printf("|%-3d | %-10s |%4d |%n" , id, name, age);
		}

    // CREATING A METHOD THAT PRINTS THE TABLE FOOTER
	public static void printTableFooter() {
		System.out.print("+-------------------------+ \n");
		System.out.println(petCount + " rows in set.");
	}

}
