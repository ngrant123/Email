
package email;

import java.util.Comparator;



/**
 * The code implements the Comparator method and is used to sort the subject in 
 * Email objects in ascending order
 * 
 * @author nathangrant
 * 
 * email:nathan.grant@stonybrook.edu
 * Stony Brook Id:109816757
 * 
 */
public class SubjectCompare implements Comparator<Email>{

    
    
    /**
     * A compareTo method that compares two Emails objects with each other and 
     * tells which one is greater than the other
     * 
     * It uses the CompareTo method that was defined in the Email class
     * 
     * @param o
     * @return
     */
    @Override
    public int compare(Email o1, Email o2) {

        return o1.getSub().compareTo(o2.getSub());
        
    }

    
}
