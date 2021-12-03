

/**
 * * This class defines the Combination object
 * 
 * @author Patton Robertson
 * @Project 5 CPSC 220
 */
public class Combination
{
    // Instance variables
    private long N;
    private long K;
    
    //Non default constructor
    public Combination(long n, long k)
    {
        //Initialise instance variables
        this.N = n;
        this.K = k;
    }

    
    //Get values
    public long getNValue(){
        return this.N;
    }
    
    public long getKValue(){
        return this.K;
    }
    
    
}
