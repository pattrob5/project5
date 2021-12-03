
import java.util.Scanner;

/**
 * This program calculates permutations and combinations on Pascal's Triangle for discrete math. The program caps at 18 rows - sufficient for any calculation needed in a discrete
 * math course.
 * 
 * @return The finished calculation, or a NumberTooBigException
 * 
 * @author Patton Robertson
 * @Project 5 CPSC 220
 */

public class main
{
    public static void main(String[] args)
    {
        /**
         * The main method asks the user whether they want to calculate a permutation or combination, as well as the two numbers they would like to use for the calculation. 
         * It also calls upon the other methods in the program to perform the calculation and create the output. There is a try / catch block to throw an exception just 
         * in case the number is too large.
         */
        
        //Ask the user if they want to calculate a combination or a permutation
        System.out.println("Would you like to calculate a combination or permutation? Enter 'C' for combination or 'P' for permutation");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        
        //booleans to see if input was correct
        boolean pbool = choice.equals("P");
        boolean cbool = choice.equals("C");
        
        //Error if P or C was not input
        if((pbool == false) && (cbool == false)){
            System.out.println("Error: Your input is not recognized. Please try again.");
            return;
        }
        
        //Ask the user for N
        System.out.println("Please enter an integer value for N - Total objects: ");
        int N = input.nextInt();
        
        //Ask the user for K
        System.out.println("Please enter an integer value for K - The number of ways you would like to select or arrange N objects: ");
        int K = input.nextInt();
        
        
        
            //Calculate based on input
            //Permutation
        try {
            if(choice.equals("P")){
                Permutation p = new Permutation();
                p.setNValue(N);
                p.setKValue(K);
                long p_output = calcPerm(p);
                System.out.println(p_output);
            }
        
            //Combination
            if(choice.equals("C")){
                Combination c = new Combination(N, K);
                long c_output = calcComb(c);
                System.out.println(c_output);
            }
        
        } catch(NumberTooBigException e){
            System.err.println("NumberTooBigException: " + e.getMessage());
        }
        
    }
    
    //method to calculate permutation
    /**
     * This method executes the permuation calculation. It will also throw a NumberTooBigException if the variables needed for calculation show that the proper 
     * output will be too large.
     * 
     * @param   p  The Permutation object to calculate with
     * @return     The result of the permutation calculation
     */  
    public static long calcPerm(Permutation p) throws NumberTooBigException
    {
        //Get values
        long N = p.getNValue();
        long K = p.getKValue();
        
        //Factorial N
        long Nfact = factorial(N);
        
        //Difference of N and K
        long difference = N - K;
        
        //Factorial of difference
        long DiffFact = factorial(difference);
        
        //N / Difference
        
        
        if(Nfact <= 0 || DiffFact <= 0){
            throw new NumberTooBigException("Your values have produced a number too big for the program!");
        } else {
            long perm = Nfact / DiffFact;
            return perm; 
        }
        
    }
    
    //method to calculate combination
    /**
     * This method executes the combination calculation. It will also throw a NumberTooBig Exception if the variables needed for calculation show that the proper output
     * will be too large.
     * 
     * @param  c  The Combination object to calculate with
     * @return    The result of the combination calculation
     */
    public static long calcComb(Combination c) throws NumberTooBigException
    {
        //Get values
        long N = c.getNValue();
        long K = c.getKValue();
        
        //Factorial N
        long Nfact = factorial(N);
        
        //Difference of N and K
        long difference = N - K;
        
        //Factorial of difference
        long DiffFact = factorial(difference);
        
        //Factorial of K
        long Kfact = factorial(K);
        
        //Difference * KFact
        long product = DiffFact * Kfact;
        
        //N! / (N-K!)K!
       
        
        if(Nfact <= 0 || Kfact <= 0){
            throw new NumberTooBigException("Your values have produced a number too big for the program!");
        } else {
            long comb = Nfact / product;
            return comb; 
        }
    }
    
    
    
    
    //method to calculate factorial
    /**
     * This method calculates the factorial of an integer which is required for the formulas for both permutations and combinations
     * 
     * @param  x  The number to find the factorial of
     * @return    The factorial of the input paramater
     */
    public static long factorial(long x)
    {   
        long f = 1;
        
        for(long i = x; i>=1; i--){
            f *= i;
        }
        
        return f;        
    }
}
