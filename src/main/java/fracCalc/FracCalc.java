
/*** @author Mr. Rasmussen;
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
    	String operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
    	String operand2 = input.substring(space + 3);
    	
            
    	 
    	String w = findWhole(operand1);
    	String n= findNum(operand1);
    	String d = findDenom(operand1);
    	String w2 = findWhole(operand2);
		String n2= findNum(operand2);
		String d2 = findDenom(operand2);
		int whole = Integer.valueOf(w);
		int num = Integer.valueOf(n);
		int denom = Integer.valueOf(d);
		int whole2 = Integer.valueOf(w2);
		int num2 = Integer.valueOf(n2);
		int denom2 = Integer.valueOf(d2); 
		String answer = "temp";
		
		 if (operator.equals("+")) {
			answer = addition(whole, num, denom, whole2, num2, denom2, operand1, operand2);	
    	 }
		 else if(operator.equals("-")) {
			  answer = subtract(whole, num, denom, whole2, num2, denom2);
			
		 }
		 else if(operator.equals("*")) {
			  answer = multiply(whole,num,denom,whole2,num2,denom2,operand1,operand2);
			 
		 }
		 else if (operator.contentEquals("/")) {
			 answer = divide(whole,num,denom,whole2,num2,denom2,operand1,operand2);
			 
    }
		 return answer;
    }
		
		 
    	 
        // TODO: Implement this function to produce the solution to the input
		
		
    
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
    public static String findDenom(String str) {
    	if(str.indexOf("/") != 0) {
    		return str.substring(str.indexOf("/") + 1);	
    	}		
		else {
			return "1";
		}
		}
    
    public static String addition(int w1, int n1, int d1, int w2, int n2, int d2, String first, String second) {	 
    	int numerator1 = n1 * d2;
        int numerator2 = n2 * d1;
        int denominator = d1 * d2;
        int whole = w1 + w2;
        
        if (first.indexOf("-") != -1 && second.indexOf("-") != -1) {
                numerator1 *= -1;
                numerator2 *= -1;
        } else if (second.indexOf("-") != -1 && first.indexOf("-") == -1) {
                numerator2 *= -1;
        } else if (second.indexOf("-") == -1 && first.indexOf("-") != -1) {
                numerator1 *= -1;
        }
     
        int numerator = numerator1 + numerator2;
        
        if (numerator / denominator >= 1) {
                int addWhole = numerator / denominator;
                numerator = Math.abs((addWhole * denominator) - numerator);
                whole += addWhole;
        }
       
        String total = whole + "_" + Math.abs(numerator) + "/" + denominator;
 
        double testNum = numerator;
        double testDem = denominator;
        if ((testNum / testDem) == 0.0) {
                total = whole + "";
               
        } else if (whole == 0) {
                total = numerator + "/" + denominator;
        }
       
        return total;
 }

    	public static String subtract(int whole1, int nom1, int denom1, int whole2, int nom2, int denom2) {
            
            int denominator = denom1 * denom2;
            
            int numerator1 = nom1 * denom2;
            int numerator2 = nom2 * denom1;
            int numerator = numerator1 - numerator2;
            
            int whole = whole1 - whole2;
           
            if (numerator / denominator >= 1) {
                    int addWhole = numerator / denominator;
                    numerator = Math.abs((addWhole * denominator) - numerator);
                    whole += addWhole;
            }
           
            String total = whole + "_" + Math.abs(numerator) + "/" + denominator;
           
            double testNum = numerator;
            double testDem = denominator;
            if ((testNum / testDem) == 0.0) {
                    total = whole + "";
                    
            } else if (whole == 0) {
                    total = numerator + "/" + denominator;
            }
       
            return total;
     }
        public static String multiply(int whole1, int nom1, int denom1, int whole2, int nom2, int denom2, String first, String second) {
        	 int numerator1 = whole1 * denom1;
             int numerator2 = whole2 * denom2;
            int denominator = denom1 * denom2;
            
           
            if (first.indexOf("-") != -1 && second.indexOf("-") != -1) {
                    nom1 *= -1;
                    nom2 *= -1;
            } else if (second.indexOf("-") != -1 && first.indexOf("-") == -1) {
                    nom2 *= -1;
            }
            numerator1 += nom1; 
            numerator2 += nom2;
            int numerator = numerator1 * numerator2;
            int whole = 0;
            if (numerator / denominator >= 1) {
                    int addWhole = numerator / denominator; 
                    numerator = Math.abs((addWhole * denominator) - numerator); 
                    whole += addWhole; 
            }
            String total = whole + "_" + numerator + "/" + denominator;
            double testNum = numerator;
            double testDem = denominator;
            if ((testNum / testDem) == 0.0) {
                    total = whole + "";
                   
            } else if (whole == 0) {
                    total = numerator + "/" + denominator;
            }
            
            return total;
     }

        public static String divide(int whole1, int nom1, int denom1, int whole2, int nom2, int denom2, String first, String second) {
            
            int denominator = denom1;
           
            int numerator1 = whole1 * denom1;
            int numerator2 = whole2 * denom2;
            if (first.indexOf("-") != -1 && second.indexOf("-") != -1) {
                    nom1 *= -1;
                    nom2 *= -1;
            } else if (second.indexOf("-") != -1 && first.indexOf("-") == -1 && second.indexOf("_") != -1) {
                    nom2 *= -1;
            }
           
            numerator1 += nom1;
            numerator2 += nom2;
            int numerator = numerator1 * denom2;
            denominator *= numerator2;
            int whole = 0;
            if (numerator / denominator >= 1) {
                    int addWhole = numerator / denominator; 
                    numerator = Math.abs((addWhole * denominator) - numerator);
                    whole += addWhole; 
                    denominator = Math.abs(denominator);
            }
           
            String total = whole + "_" + numerator + "/" + denominator;
            double testNum = numerator;
            double testDem = denominator;
            if ((testNum / testDem) == 0.0) {
                    total = whole + "";
                    
            } else if (whole == 0) {
                    total = numerator + "/" + denominator;
            }
          
            return total;

        }
}
    // TODO: Fill in the space below with any helper methods that you think you will need


