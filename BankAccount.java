package programingAssignment1;
/*********************************

*********************************/
import java.text.NumberFormat;
import java.util.Scanner;


public class BankAccount 
{ 
	public static final int EMPTY = 1;


	private static String fullName(Scanner ui) 
	{
		System.out.print("Enter Full name: ");
		String fullName = ui.nextLine().toUpperCase();
    	int length = String.valueOf(fullName).length();
    	while (length < EMPTY) {
    		System.out.println("Input was Invalid!");
    		System.out.print("Enter Full Name again: ");
    		fullName = ui.nextLine();
    	    length = String.valueOf(fullName).length();
    	}
		return fullName;
		
	}
	private static String streetAddress(Scanner ui)

	{
		System.out.print("Enter Street Address: ");
		String streetAddress = ui.nextLine();
		int length = String.valueOf(streetAddress).length();
		while (length < EMPTY){
			System.out.println("Input was Invalid!");
			System.out.print("Enter Street Address again: ");
			streetAddress = ui.nextLine();
			length = String.valueOf(streetAddress).length();
		}
		return streetAddress;	
		
	}
	private static String city(Scanner ui) {
		System.out.print("Enter City: ");
		String city = ui.nextLine();
		int length = String.valueOf(city).length();
		while (length < EMPTY) {
			System.out.println("Input was Invalid!");
			System.out.print("Enter City again: ");
			city = ui.nextLine();
			length = String.valueOf(city).length();
		}
		return city;
	}
	private static String state(Scanner ui) 
	{
		System.out.print("Enter State Initials: ");
		String state = ui.nextLine().toUpperCase();
		int length = String.valueOf(state).length();
		while (length <= 1 || length >= 3) {
			System.out.println("Input was Invalid!");
			System.out.print("Enter State Initials again: ");
			state = ui.next().toUpperCase();
			length = String.valueOf(state).length();
		}
		return state;
	}
	private static int zipCode(Scanner ui) 
	{
		System.out.print("Zipcode (must be 5 digits): ");
		int zipCode = ui.nextInt();
		int length = String.valueOf(zipCode).length();
		while (length != 5) {
			System.out.println("Input was Invalid!");
			System.out.print("Enter Zip Code again: ");
			zipCode = ui.nextInt();
			length = String.valueOf(zipCode).length();
		}
		return zipCode;
		
	}
	private static String socialSecurity(Scanner ui)
	{
		System.out.print("SSN (e.g. 123-45-6789): ");
		String socialSecurity = ui.next();
		while (ssnVerify(socialSecurity) == false) {
				System.out.println("Input was Invalid!");
				System.out.print("Enter Social Secuirty Number again: ");
				socialSecurity = ui.next();
		}
		return socialSecurity;
	}
	public static boolean isDigit(char a)
	{
		return Character.isDigit(a);
	}
	public static boolean isDash(char b)
	{
		return (b == '-');
	}
	public static boolean ssnVerify(String ssn)
	{ 
	      if (ssn.length() != 11) return false; 
	      for (int i = 0; i < ssn.length(); i++)
	      {
	        if (i <= 2)
	        {
	          if (!isDigit(ssn.charAt(i)))
	          {
	            return false;
	          }
	        }
	        else if (i == 3 || i == 6)
	        {
	          if (!isDash(ssn.charAt(i)))
	          {
	            return false; 
	          }
	        }
	        else if (i > 6)
	        {
	          if (!isDigit(ssn.charAt(i)))
	          {
	            return false;
	          }
	        }
	      }
	      return true;
	    }
	private static void calculateBalance(double total) 
	{
		int Hundreds, Twenties, Tens, Fives, Ones;
		Hundreds = (int) (total / 100);	total -= Hundreds * 100;
		Twenties = (int) (total / 20);		total -= Twenties * 20;
		Tens = (int) (total / 10);			total -= Tens * 10;
		Fives = (int) (total / 5);			total -= Fives * 5;
		Ones = (int) total;		
		System.out.println("Bills count");
		System.out.printf("%20s %-15s%n","$100 Bills: "	, Hundreds );
		System.out.printf("%20s %-15s%n","$20 Bills: "	, Twenties );
		System.out.printf("%20s %-15s%n","$10 Bills: "	, Tens );
		System.out.printf("%20s %-15s%n","$5 Bills: "	, Fives );
		System.out.printf("%20s %-15s%n","$1 Bills: "	, Ones);	
	}
	private static double accountBalance(Scanner ui) 
	{
		System.out.print("How much money you want to add to your account? $");
		double accountBalance = ui.nextDouble();
		while (accountBalance < 0 ){
			System.out.println("Error Entering Account balance.");
			System.out.print("How much money you want to add to your account? $");
			accountBalance = ui.nextDouble();
		}
		return accountBalance;
	}
	private static double deposit(Scanner ui)
	{
		System.out.print("Amount to deposit? $");
		double deposit = ui.nextDouble();
		while (deposit < 0){
			System.out.println("Error Entering Deposit.");
			System.out.print("Amount to deposit? $");
			deposit = ui.nextDouble();
		}
		return deposit;
	}
	private static double fWithdraw(Scanner ui,Double CurrentBalance) 
	{
		System.out.print("First amount to withdraw? $");
		double fWithdraw = ui.nextDouble();
		while (fWithdraw <= -1){
			
			System.out.println("Insufficient balance.");
			System.out.print("First amount to withdraw? $");
			fWithdraw = ui.nextDouble();
		}
		while (fWithdraw >= CurrentBalance){
			if (fWithdraw >= CurrentBalance){
				System.out.println("Insufficient balance.");
				System.out.print("First amount to withdraw? $");
				fWithdraw = ui.nextDouble();
			}
		}
		return fWithdraw;
	}	
	private static double sWithdraw(Scanner ui,Double CurrentBalance) 
	{
		System.out.print("Second amount to withdraw? $");
		double sWithdraw = ui.nextDouble();
		while (sWithdraw <= -1){
			
			System.out.println("Insufficient balance.");
			System.out.print("Second amount to withdraw? $");
			sWithdraw = ui.nextDouble();
		}
		while (sWithdraw >= CurrentBalance){
			if (sWithdraw >= CurrentBalance){
				System.out.println("Insufficient balance.");
				System.out.print("Second amount to withdraw? $");
				sWithdraw = ui.nextDouble();
			}
		}
		return sWithdraw;
	}
	private static void personalInformation(String fullName,String streetAddress,String city,String state,int zipCode,String socialSecurity)
	{ 
		String A = "Full Name";
		String B ="| Address";
		String C ="| City";
		String D ="| State";
		String E ="| Zipcode";
		String F ="| SSN";
		
		System.out.println("***********************************");
		System.out.println("\tAccount Information");
		System.out.println("***********************************");
		System.out.println("Profile:");
		System.out.print("-------------------- ------------------------- --------------- ------- --------- -------------\n");
		System.out.printf("%-19s %-25s %-15s %-7s %-7s %s%n", A, B, C, D, E, F);
		System.out.print("-------------------- ------------------------- --------------- ------- --------- -------------\n");
		System.out.printf("%-19s %-25s %-15s %-7s %-9s %s%n",fullName, "| " + streetAddress, "| " + city, "| " 
															+ state, "| " + zipCode, "| " + socialSecurity);
		System.out.print("-------------------- ------------------------- --------------- ------- --------- -------------\n");
		
	}	
	private static void accountInformation(double accountBalance,double fWithdraw,double sWithdraw,double deposit,double currentBalance) 
	{
		NumberFormat US = NumberFormat.getCurrencyInstance();
		System.out.println("***********************************");
		System.out.println("Account Summary:");
		System.out.printf("%20s %-15s%n","Initial Balance: " ,  US.format(accountBalance));
		System.out.printf("%20s %-15s%n","First Withdrawl: " ,  US.format(fWithdraw));
		System.out.printf("%20s %-15s%n","Second Withdrawl: ",  US.format(sWithdraw));
		System.out.printf("%20s %-15s%n","Deposit: "		 ,  US.format(deposit));
		System.out.printf("%20s %-15s%n","Current balance: " ,  US.format(currentBalance));
		System.out.println("***********************************");
	}
	public static void main(String[] args) 
    { 
		Scanner ui = new Scanner(System.in);
		
		String intro = "  EnterYourDetailsBelow  ";
		int dashLength = String.valueOf(intro).length();
		System.out.println(String.format("%"+ dashLength +"s", "  ").replace(' ', '-'));
		System.out.println(intro);
		System.out.println(String.format("%"+ dashLength +"s", "  ").replace(' ', '-'));
		
		//User Inputs
		String fullName = fullName(ui);	
		String streetAddress = streetAddress(ui);
		String city = city(ui);
		String state = state(ui);
		int zipCode = zipCode(ui);
		String socialSecurity =socialSecurity(ui);
		
		//Account Creation.1
		String congrats = "  Congratulations! Your account is now ready!  ";
		dashLength = String.valueOf(congrats).length();
		System.out.println(String.format("%"+ dashLength +"s", "  ").replace(' ', '-'));
    	System.out.println(congrats);
    	System.out.println(String.format("%"+ dashLength +"s", "  ").replace(' ', '-'));
    	//Account Creation.2
    	double accountBalance = accountBalance(ui);
    	double deposit = deposit(ui);
    	double currentBalance = accountBalance + deposit;
		double fWithdraw = fWithdraw(ui,currentBalance);
		currentBalance -= fWithdraw;
		double sWithdraw = sWithdraw(ui,currentBalance);

		ui.close();
		//outputs
		currentBalance = accountBalance + deposit - fWithdraw - sWithdraw;
		personalInformation(fullName,streetAddress,city,state,zipCode,socialSecurity);
		accountInformation(accountBalance,fWithdraw,sWithdraw,deposit,currentBalance);
		calculateBalance(currentBalance); 
    }
}