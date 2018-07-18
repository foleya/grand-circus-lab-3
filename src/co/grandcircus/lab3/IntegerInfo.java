package co.grandcircus.lab3;

import java.util.Scanner;

public class IntegerInfo {

    public static void main(String[] args) {
	programLoop();
    }
    
    private static void programLoop() {
	Scanner scnr = new Scanner(System.in);
	String userName;
	String userNum;
	boolean validInput = false;
	String output;
	String endOfficially;
	
	// Enter the main logic loop.
	do {
	    // Prompt for the user's Name.
	    System.out.print("Hello there. What is your name? ");
	    userName = scnr.nextLine();

	    // Prompt for an integer.
	    System.out.printf("%nGeneral %s! Enter an integer (1-100): ", userName);
	    
	    // Enter the user-input validation loop.
	    do {
		userNum = scnr.nextLine();
		validInput = validator(userNum);
	    } while (!validInput);
	    

	    /* Convert the user's number (String) to an integer,
	     * then retrieve the appropriate output and print it.
	     */
	    output = integerInfoRetriever(Integer.parseInt(userNum));
	    System.out.printf("%nFool! I have been trained in your Jedi Arts, "
		    + "General %s!%nThe number you chose (%s) is %s!!!%n",
		    userName,
		    userNum,
		    output);
	    
	    // Prompt the user to officially end the program (exit the loop).
	    System.out.printf("%nGeneral %s! Would you like to execute an order " +
		    	      "that causes this program to end officially?%nIf so, " +
		    	      "enter 'Order 66'. Otherwise...%n"
		    	      , userName);
	    endOfficially = scnr.nextLine().toLowerCase().trim();
	} while (!endOfficially.equals("order 66"));
	scnr.close();
    } 
    
    /**
     * This method uses regex to validate that a user entered a String
     * that can be parsed to an integer between 1 and 100.
     */
    private static boolean validator(String userNum) {
	if (userNum.matches("^[1-9][0-9]?$|^100$")) {
	    return true;
	} else {
	    System.out.printf("%n--Fool! You must enter a positive integer between 1 and 100--" +
		    	      "%nPlease try again: ");
	    return false;
	}
    }

    /**
     * This method takes an integer, then returns a string with the
     * appropriate output based on the lab's parameters.
     */
    private static String integerInfoRetriever(int userNum) {
	
	if (userNum % 2 == 0) {
	    // number is even
	    if (userNum < 25) {
		// number is even and less than 25
		return "even and less than 25";
	    } else {
		// number is even but not less than 25
		return "even";
	    }
	} else {
	    // number is odd
	    if (userNum > 60) {
		// number is odd and over 60
		return "odd and over 60";
	    } else {
		// number is odd but not over 60
		return "odd";
	    }
	}
	
    }
    
}
