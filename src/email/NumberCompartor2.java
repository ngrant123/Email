
package email;

import java.util.Comparator;

/**
 * The code implements the Comparator method and is used to sort the date in 
 * Email objects in descending order
 * 
 * @author nathangrant
 * 
 * email:nathan.grant@stonybrook.edu
 * Stony Brook Id:109816757
 * 
 */
public class NumberCompartor2 implements Comparator<Email>{

    
   
    /**
     * Compares the two Emails objects and determines which one is less than 
     * the other
     * 
     * First is tells which year is less and if the two years are the same
     * then it compares the months and the days. It is  very similar to the 
     * NumberCompartor class except the inequality signs are flipped
     * 
     * @param o1
     * @param o2
     * @return 
     */
    @Override
    public int compare(Email o1, Email o2) {
        
        if(o1.getYear()<o2.getYear()){
            
            return 1;
        }
        
        else if(o1.getYear()==o2.getYear()){
            
            if(o1.getMonth()==o2.getMonth()){
                if(o1.getDay()<o2.getDay()){
                    return 1;
                }
                
                else if(o1.getDay()>o2.getDay()){
                    return -1;
                }
                else 
                    return 0;
            }
            else if(o1.getMonth()<o2.getMonth()){
                return 1;
            }
            
            else if (o1.getDay()>o2.getMonth()){
                return -1;
            }
        }
        else if(o1.getYear()>o2.getYear()){
            return -1;
        }
                
                
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
