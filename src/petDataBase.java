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
}
