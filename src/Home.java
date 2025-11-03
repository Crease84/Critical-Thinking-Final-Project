/* Christopher Cabrera
* November 2, 2025
* CSUGlobal CSC320-1 Programming I
* Home class with constructor and methods to update, store, remove, and export all home information
*/
public class Home {
	private int squareFeet;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private String ModelName;
	private String marketStatus;
	
	//Default constructor
	public Home(int squareFeet, String address, String city, String state, int zipCode, String modelName, String marketStatus) {
		this.squareFeet = squareFeet;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.ModelName = modelName;
		this.marketStatus = marketStatus;
	}
	//Populates home with user data
	public String addHome(int squareFeet, String address, String city, String state, int zipCode, String modelName, String marketStatus) {
		
		try {
			this.squareFeet = squareFeet;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.ModelName = modelName;
			this.marketStatus = marketStatus;
		
			return("Successfully added home!");
		}
		catch (Exception e) {
			return("Failed to add home");
		}
		
	}
	//updates market status in home object
	public String updateHome(String saleStatus) {
		if (this.marketStatus.equals("Unknown")) {
			return("No home Found");
		}
		else {
			try {
				this.marketStatus = saleStatus;
			
				return("Successfully updated home's status!");
			}
			catch (Exception e) {
				return("Failed to change status");
			}
		}
	}
	
	//prints home object's contents to the console
	public void listHome() {
		
		if (this.squareFeet == 0 && this.zipCode == 0) {
			System.out.println("Model: " + this.ModelName);
	    	System.out.println("Address: " + this.address);
	    	System.out.println("City: " + this.city);
	    	System.out.println("State: " + this.state);
	    	System.out.println("Zip code: " + this.zipCode);
	    	System.out.println(this.squareFeet + " sq. ft");
	   	 	System.out.println("Market status: " + this.marketStatus);
		}
		else {
	    	System.out.println("Model: " + this.ModelName);
	    	System.out.println("Address: " + this.address + " " + this.city + ", " + this.state + " " + this.zipCode);
	    	System.out.println(this.squareFeet + " sq. ft");
	   	 	System.out.println("Market status: " + this.marketStatus);
		}
		
	}
	
	//Clears home object variables
	public String removeHome() {
		
		try {
			squareFeet = 0;
			address = "Unknown";
			city = "Unknown";
			state = "Unknown";
			zipCode = 0;
			ModelName = "Unknown";
			marketStatus = "Unknown";
			
			return("Successfully removed home!");
		}
		catch(Exception e) {
			return("Failed to remove home");
		}
	}
	
	public String printInfo() {
		
		
		return("Model: " + this.ModelName + "\n"
				+ "Address: " + this.address + " " + this.city + ", " + this.state + " " + this.zipCode + "\n"
				+ this.squareFeet + " sq. ft\n"
				+ "Market status: " + this.marketStatus + "\n");
	}

}


