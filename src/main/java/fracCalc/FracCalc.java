
/*** @author Mr. Rasmussen;
 */

package fracCalc;
import java.util.*;
public class FracCalc {
public static String finalresult = "";
public static String operator = "";
    //Operand 1
	public static int operand1Wh = 0;
	public static int operand1Num = 0;
	public static int op1Denom = 0;
	public static int operand1ImproperNum = 0;

	// Operand 2
	public static int operand2Wholenumber = 0;
	public static int operand2Numerator = 0;
	public static int operand2Denom = 0;
	public static int operand2ImproperNumerator = 0;

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
    // produces the answer
    public static String produceAnswer(String input) {
		String[] arrayinput = input.split(" ");
		if (arrayinput.length < 3) {
			return "ERROR: Input is in an invalid format.";
		} else {
			CalculateExpression(arrayinput[1], arrayinput[0], arrayinput[2]);
			for (int i = 3; i < arrayinput.length; i += 2) {
				CalculateExpression(arrayinput[i], finalresult, arrayinput[i + 1]);
			}
			return finalresult;
		}
	}
		// Decides which method to use
		public static void CalculateExpression(String operator, String operand1, String operand2) {
			parseFraction(operand1, true);
			parseFraction(operand2, false);
			FracCalc.operator = operator;
			if (op1Denom == 0 || operand2Denom == 0) {
				finalresult = "ERROR: Cannot divide by 0";
			} else {
				if (operator.equalsIgnoreCase("+")) {
					addition();
				} else if (operator.equalsIgnoreCase("*")) {
					Multiply();
				} else if (operator.equalsIgnoreCase("-")) {
					Subract();
				} else if (operator.equalsIgnoreCase("/")) {
					finalresult = Divide();
				} else if (operator.length() > 1) {
					finalresult = "ERROR";
				}
			}
		}
		
		 
    	 
        // TODO: Implement this function to produce the solution to the input
 
		// Parses the fraction
    public static void parseFraction(String operand, Boolean operand1) {
		String fraction = operand;
		String wholenumber = "0";
		String numerator = "0";
		String denominator = "0";
		String[] splitwholenumber = fraction.split("_");
		if (splitwholenumber.length == 2) {
			// Mixed Fraction Condition
			wholenumber = fraction.split("_")[0];
			numerator = fraction.split("_")[1].split("/")[0];
			denominator = fraction.split("_")[1].split("/")[1];
		} else {
	 		// Check if it is whole number only
			String[] splitnumeratoranddenominator = fraction.split("/");
			// If there are 2 values in array, this means it's a fraction else it's only a
			// whole number
			if (splitnumeratoranddenominator.length == 2) {
				numerator = splitnumeratoranddenominator[0];
				denominator = splitnumeratoranddenominator[1];
			} else {
				wholenumber = operand;
				denominator = "1";
			}
		}
		// Set Static Variables
		SetStaticFieldValues(operand1, Integer.parseInt(wholenumber), Integer.parseInt(numerator),
				Integer.parseInt(denominator));
	}
    //sets field values
    public static void SetStaticFieldValues(Boolean operand1, int wholenumber, int numerator, int denominator) {
		if (operand1) {
			operand1Wh = wholenumber;
			operand1Num = numerator;
			op1Denom = denominator;
			if (wholenumber != 0) {
				// Check if it's negative then do absolute value and add the negative value back
				if (Integer.toString(wholenumber).contains("-")) {
					wholenumber = Integer.parseInt(Integer.toString(wholenumber).split("-")[1]);
					// Convert back to negative
					operand1ImproperNum = ((wholenumber * denominator) + numerator) * (-1);
				} else {
					operand1ImproperNum = (wholenumber * denominator) + numerator;
				}
			} else {
				operand1ImproperNum = numerator;
			}

		} else {
			operand2Wholenumber = wholenumber;
			operand2Numerator = numerator;
			operand2Denom = denominator;
			if (wholenumber != 0) {
				// Check if it's negative then do absolute value and add the negative value back
				if (Integer.toString(wholenumber).contains("-")) {
					wholenumber = Integer.parseInt(Integer.toString(wholenumber).split("-")[1]);
					// Convert back to negative
					operand2ImproperNumerator = ((wholenumber * denominator) + numerator) * (-1);
				} else {
					operand2ImproperNumerator = (wholenumber * denominator) + numerator;
				}
			} else {
				operand2ImproperNumerator = numerator;
			}
		}
	}
    //Finds the whole number
    public static String findWhole(String str) {
    	if(str.indexOf("_") == 1) {
    		return str.substring(0, str.indexOf('_'));
    	}
    	else if(str.indexOf("/") == 1) {
    		return "0";
    	}
    	else if (str.indexOf("-") != -1) {
    		return str;
    	}
    	else {
    		return str;
    	}
    }
    //Finds the Numerator
    public static String findNum(String str) {
    	if(str.indexOf("_") == 1) {
    		return str.substring( str.indexOf('_') + 1, str.indexOf('/'));
    	}
    	else if(str.indexOf("/") == 1) {
    		return str.substring(0, str.indexOf('/'));
    	}
    	else {
    		return "0";
    	}
    }
    // Finds the Denominator
    public static String findDenom(String str) {
    	if(str.indexOf("/") != 0) {
    		return str.substring(str.indexOf("/") + 1);	
    	}		
		else {
			return "1";
		}
		}
    // Simplifies Fractions, and converts to Mixed From
    public static void SetResult(int numerator, int denominator) {
		if (numerator % denominator == 0) {
			finalresult = Integer.toString(numerator / denominator);
		} else {
			// Simplify Fractions
			int gcd = findGcd(numerator, denominator);
			// Remove negative number on gcd (Get Absolute value)
			if (Integer.toString(gcd).contains("-")) {
				gcd = Integer.parseInt(Integer.toString(gcd).split("-")[1]);
			}
			int simplifiednumerator = numerator / gcd;
			int simplifieddenominator = denominator / gcd;
			// Convert back to Mixed Form
			finalresult = turnImproperFractionToMixedFraction(simplifiednumerator, simplifieddenominator);
		}
	}
//Finds the Greatest Common Denominator
	public static int findGcd(int number1, int number2) {
		if (number2 == 0) {
			return number1;
		}
		return findGcd(number2, number1 % number2);
	}
	//converts an improper fraction into a mixed fraction
	public static String turnImproperFractionToMixedFraction(int numerator, int denominator) {
		Integer wholenumber = numerator / denominator;
		Integer remainder = numerator % denominator;
		// Check to see if the result is a negative result and remove the "-" char from
		// the fraction and only show it in the whole number
		if (wholenumber < 0)
		// if (Integer.toString(remainder).contains("-"))
		{
			// Again Check to see if the remainder is negative
			if (Integer.toString(remainder).contains("-")) {
				remainder = Integer.parseInt(Integer.toString(remainder).split("-")[1]);
			}
		}
		return wholenumber != 0 ? (wholenumber + "_" + remainder + "/" + denominator) : (remainder + "/" + denominator);
	}

    //addition method
	public static String addition() {
		int tempnum = 0;
		int commondenominator = 0;
		if (op1Denom == operand2Denom) {
			// Call Calculate Numerator based on operator
			tempnum = operand1ImproperNum + operand2ImproperNumerator;
			// Since the denominator are the same let's just use Operand1 denom
			SetResult(tempnum, op1Denom);
		} else {
			commondenominator = op1Denom * operand2Denom;
			operand1ImproperNum = operand1ImproperNum
					* (commondenominator / op1Denom);
			operand2ImproperNumerator = operand2ImproperNumerator
					* (commondenominator / operand2Denom);
			tempnum = operand1ImproperNum + operand2ImproperNumerator;
			SetResult(tempnum, commondenominator);
		}
		return finalresult;
	}
    	// Method for subtraction
	public static String Subract() {
		int tempnum = 0;
		int commondenominator = 0;
		if (op1Denom == operand2Denom) {
			// Call Calculate Numerator based on operator
			tempnum = operand1ImproperNum - operand2ImproperNumerator;
			// Since the denominator are the same, use Operand1 denominator
			SetResult(tempnum, op1Denom);
		} else {
			commondenominator = op1Denom * operand2Denom;
			operand1ImproperNum = operand1ImproperNum
					* (commondenominator / op1Denom);
			operand2ImproperNumerator = operand2ImproperNumerator
					* (commondenominator / operand2Denom);
			tempnum = operand1ImproperNum - operand2ImproperNumerator;
			SetResult(tempnum, commondenominator);
		}
		return finalresult;
	}
	
	//Multiply function
	public static String Multiply() {
		int tempnum = 0;
		int tempdenom = 0;
		tempnum = operand1ImproperNum * operand2ImproperNumerator;
		tempdenom = op1Denom * operand2Denom;
		SetResult(tempnum, tempdenom);
		return finalresult;
	}        
    //divide method
	public static String Divide() {
		int tempnum = 0;
		int tempdenom = 0;
		// Invert reciprocal of Operand 2
		// Again Check to see if the remainder is negative
		if (operand2ImproperNumerator < 0) {
			operand2ImproperNumerator = Integer
					.parseInt(Integer.toString(operand2ImproperNumerator).split("-")[1]);
			int tempvalue = operand2Denom;
			operand2Denom = operand2ImproperNumerator;
			operand2ImproperNumerator = tempvalue;
			tempnum = (operand1ImproperNum * -1) * operand2ImproperNumerator;
			tempdenom = op1Denom * operand2Denom;
		} else {
			int tempvalue = operand2Denom;
			operand2Denom = operand2ImproperNumerator;
			operand2ImproperNumerator = tempvalue;
			tempnum = operand1ImproperNum * operand2ImproperNumerator;
			tempdenom = op1Denom * operand2Denom;
		}
		SetResult(tempnum, tempdenom);
		return finalresult;
	}
}
    // TODO: Fill in the space below with any helper methods that you think you will need


