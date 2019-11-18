
/*** @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your command:");
        String userResponse= s.nextLine(); 
        String answer = produceAnswer(userResponse);
        System.out.println(answer);
        
		
	
        
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    public static String produceAnswer(String input) {
    	int space = input.indexOf(" ");
    	String operand1 = input.substring(0, space); 
    	String operator = input.substring(space-1);
    	String operand2 = input.substring(space + 3);
    	
		return operand2;
		
    
        // TODO: Implement this function to produce the solution to the input
 
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
