import java.util.Scanner;
import java.io.PrintWriter;

public class HomeInventory {
	
	public static void main(String[] args) {
		
		char userInput = '0';
		Scanner scnr = new Scanner(System.in);
		
		//Constructs empty Home object
		Home myHome = new Home(0, "Unknown", "Unknown", "Unknown", 0, "Unknown", "Unknown");
		
		System.out.println("Welcome to the Home Inventory System");
		
		//Menu loop
		while(userInput != '6') {
			//Prints selection Menu
			System.out.println("Enter an option:");
			System.out.print(
					"1 - Display Home\r\n"
					+ "2 - Remove Home\r\n"
					+ "3 - Add Home\r\n"
					+ "4 - Update Market Status\r\n"
					+ "5 - Print to File\r\n"
					+ "6 - Exit\n");
			userInput = scnr.next().charAt(0);
		    scnr.nextLine(); // clear leftover newline from menu input
			switch(userInput) {
			case '1': 
				myHome.listHome();
				pause(scnr);
				break;
			case '2': 
				System.out.println(myHome.removeHome());
				pause(scnr);
				break;
			case '3': 
				getUserHome(myHome, scnr);
				break;
			case '4': 
			    System.out.println("Enter new market status:");
			    String newStatus = scnr.nextLine(); // actually wait for user input
			    System.out.print(myHome.updateHome(newStatus));
			    pause(scnr);
			    break;
			case '5':
				System.out.println("Do you want to print home information to a file? (Y/N)");
				userInput = scnr.next().charAt(0);
				if (userInput == 'y' || userInput == 'Y') {
					try {
						PrintWriter out = new PrintWriter("C:\\Temp\\Home.txt");
						out.println(myHome.printInfo());
						out.close();
						System.out.println("Saved to file!");
					}
					catch (Exception e) {
						System.out.println("Something went wrong " + e.getMessage());
					}
				}
				else if (userInput == 'n' || userInput == 'N') {
					System.out.println("File will not be saved");
				}
				else {
					System.out.println("Invalid input");
				}
				
				break;
			}
			
			
		}
		System.out.println("GoodBye");
		scnr.close();
	}
	
	//Populates variables with user input to create Home object
	public static void getUserHome(Home myHome, Scanner scnr) {

		System.out.println("Enter square footage:");
		int userSquareFeet = scnr.nextInt();
		scnr.nextLine(); // consume newline
		System.out.println("Enter address:");
		String userAddress = scnr.nextLine();
		
		System.out.println("Enter city:");
		String userCity = scnr.nextLine();
		
		System.out.println("Enter state:");
		String userState = scnr.nextLine();
		
		System.out.println("Enter zip code");
		int userZipCode = scnr.nextInt();
		scnr.nextLine(); // consume newline
		System.out.println("Enter model type");
		String userModel = scnr.nextLine();
		
		System.out.println("Enter market status");
		String userMarketStatus = scnr.nextLine();
		
		myHome.addHome(userSquareFeet, userAddress, userCity, userState, userZipCode, userModel, userMarketStatus);
	}
	// pause so user can see result before printing the menu again
	public static void pause(Scanner scnr) {
	    System.out.println("\nPress Enter to continue...");
	    scnr.nextLine();
	}
}
