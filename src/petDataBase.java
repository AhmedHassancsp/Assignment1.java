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

    // CREATING A METHOD THAT SHOWS PETS NAME AND AGE
	public static void showAllPets() {
		
		printTableHeader(); //CALLING THE TABLE HEADER METHOD.
		
		for (int i = 0; i < petCount; i++) {
			printTableRow(i, pets[i].getName(), pets[i].getAge());
			
			// CALLING THE printTableRow EMTHOD WHICH GETS THE NAME AND AGE.
		}
		
		printTableFooter(); // CALLING THE TABLE FOOTER METHOD.
		
	}

    public static void updatePet() {
		showAllPets(); // CALLING THE SHOW PET METHOD
		//printTableHeader();
		System.out.print("Enter the pet ID you can to update: "); //PROMPTING THE USER ID OF THE PET
		int newID = s.nextInt();
		
		// CALLING printTableRow METHOD TO WITH THE NEW ID TO GET ME NAME AND AGE OF THE PET.
		printTableRow(newID, pets[newID].getName(), pets[newID].getAge()); 
		System.out.print("Enter new name and new age: ");
		String newName = s.next();
		int newAge = s.nextInt();
		pets[newID].setName(newName); // SETTING THE NEW NAME OF THE PET
		pets[newID].setAge(newAge); // SETTING THE NEW AGE OF THE PET
		printTableRow(newID, pets[newID].getName(), pets[newID].getAge()); // CALLING THE printTableRow WITH THE UPDATED NAME AND AGE
		
		printTableFooter(); // PRINTING THE FOORTER.
		
	}

    public static void removePet() {
		showAllPets();
		Pet[] newPetArray = new Pet[pets.length - 1];
		System.out.print("Enter the pet ID you can to remove: ");
		int ID = s.nextInt();
	
		
		for (int i = 0, j = 0; i < pets.length; i++) {
			//newPetArray[i].setName() = pets[i].get;
			if (i < ID) {
				
			newPetArray[i] = pets[i];

			} else {

				newPetArray[i] = pets[i+1];
			}

		}
		System.out.println(newPetArray + " is removed");
		
		
		
	}

    // CREATING A METHOD THAT SERACHERS THE PET BY NAME 
	private static void searchPetsByName() {
		
		System.out.print("Enter a name to search: ");
		String name = s.next();
		
		for (int i = 0; i < petCount; i++) {
			//pets[i].getName();
			//pets[i].getAge();
			if (pets[i].getName().equals(name)) {
				System.out.printf("|%-3d | %-10s |%4d |%n" , i, pets[i].getName(), pets[i].getAge());
			} 
			
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
