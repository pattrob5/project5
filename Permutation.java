/**
 * This class defines the Permutation object
 * 
 * @author Patton Robertson
 * @Project 5 CPSC 220
 */
public class Permutation
{
    // Instance variables
    private long N;
    private long K;
    
    //Default constructor
    /**
     * Default constructor for objects of the Permutation class
     */
    public Permutation()
    {
        //Initialise instance variables
        this.N = -1;
        this.K = -1;
    }
    
    //Set values 
    public void setNValue(long n){
        this.N = n;
    }
        
    public void setKValue(long k){
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
