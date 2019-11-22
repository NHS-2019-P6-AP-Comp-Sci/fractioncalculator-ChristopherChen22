
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
        while(userResponse.equals("quit")!= true) {
        String answer = produceAnswer(userResponse);
        System.out.println(answer);
        userResponse = s.nextLine();
        }
       
        
		
	
        
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
    	
		
	
		String w = findWhole(operand2);
		String n = findNum(operand2);
		String d = findDenom(operand2);
		
		String finalAnswer = "whole:" + w + " numerator:" + n + " denominator:" + d;
		return finalAnswer;
	
		
		
    
        // TODO: Implement this function to produce the solution to the input
 
    }
    public static String findWhole(String str) {
    	if(str.indexOf("_") == 1) {
    		return str.substring(0,str.indexOf('_'));
    	}
    	else if(str.indexOf("/") == 1) {
    		return "0";
    	}
    	else return str;
    }
    public static String findNum(String str) {
    	if(str.indexOf("_") != 1) {
    		return str.substring( str.indexOf('_') + 1, str.indexOf('/'));
    	}
    	else if(str.indexOf("/") != 1) {
    		return str.substring(0, str.indexOf('/'));
    	}
    	else {
    		return "0";
    	}
    }
    public static String findDenom(String str) {
    	if(str.indexOf("/") == 1) {
    		return str.substring(str.indexOf("/") + 1);
    		
    	}
		
		else {
			return "1";
		}
    	
		
	
    	
		
    }
   
		
    }
    // TODO: Fill in the space below with any helper methods that you think you will need


