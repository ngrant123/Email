
package email;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.Serializable;

/**
 * This code constructs and contains all of the necessary information for an Email here
 * It also contains a compareTo method the compares two Email objects with each other 
 * 
 * The body,subject, bcc, cc, and the to field are all available
 * 
 * @author nathangrant
 * email:nathan.grant@stonybrook.edu
 * Stony Brook Id:109816757
 * 
 */
public class Email implements Serializable{
    
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    
    private GregorianCalendar timestamp;
    private int day;
    private int month;
    private int year;
    
    /**
     * Default constructor for Email
     * 
     */
    
    public Email(){
        
    }
    /**
     * Constructor that creates an Email object and also initializes the subject
     *
     * @param subject 
     */
    
    public Email(String subject){
        this.subject=subject;
       
        
        
    }
    
    /**
     * This method creates the time when the current object was created by using
     * the get() method available in the Java API
     * 
     * @return 
     */
    public GregorianCalendar time(){
        
        Calendar date= new GregorianCalendar();
       // Calendar date3= new Calendar();
       
       this.day=date.get(Calendar.DAY_OF_MONTH);
       this.month=date.get(Calendar.MONTH);
       this.year=date.get(Calendar.YEAR);
               
       this.timestamp=(GregorianCalendar) date;
       
       return timestamp;
    }
    
    /**
     * This method is using to format the date into an easier/ user friendly way
     * to read it
     * 
     * @return 
     */
    public String getTime(){
        
        Date date= new Date();
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        String date2=dateFormat.format(date);
        //this.timestamp=dateFormat.format(date);
     //   System.out.println(dateFormat.format(date));
        
        return date2;
    }
    /**
     * Method that allows the user to set the "to" for the Email
     * object
     * 
     * @param to 
     */
    public void setT(String to){
        this.to=to;
    }
    /**
     * Method that allows the user to set the "cc" for the Email 
     * object
     * @param cc 
     */
    
    public void setC(String cc){
        this.cc=cc;
    }
    
    /**
     * Method that allows the user to set the "bcc" for the Email
     * object
     * @param bcc 
     */
    public void setBC(String bcc){
        
        this.bcc=bcc;
      
    }
    /**
     * Method that allows the user to set the "subject" for the Email
     * object
     * 
     * @param subject 
     */
    public void setSubject(String subject){
        this.subject=subject;
    }
    
    /**
     * Method that allows the user to set the "body" for the Email
     * object
     * 
     * @param body 
     */
    public void setB(String body){
        
        this.body=body;
    }
    /**
     * Allows the user to get the "to" variable from the current object
     * @return 
     */
    
    public String getT(){
        return this.to;
    }
    /**
     * Allows the user to get the "cc" variable from the current object
     * @return 
     */
    
     public String getC(){
        return this.cc;
    }
    /**
     * Allows the user to get the "bcc" variable from the current object
     * @return 
     */
      public String getBC(){
        return this.bcc;
    }
    /**
     * Allows the user to get the "subject" variable from the current object
     * @return 
     */
       public String getSub(){
        return this.subject;
    }
    
    /**
     * Allows the user to get the "body" variable from the current object
     * 
     * @return 
     */
       
       public String getB(){
        return this.body;
    }
       /**
        * Returns the day that the current Email object was created
        * 
        * @return 
        */
       public int getDay(){
           return this.day;
       }
       /**
        * Returns the month that the current Email object was created
        * 
        * @return 
        */
       public int getMonth(){
           
           return this.month;
       }
       /**
        * Returns the year that the current Email object was created
        * 
        * @return 
        */
       
       public int getYear(){
           
           return this.year;
       }
       
       /**
        * A compareTo method that compares the current Email object with
        * the Email object that is supplied in the parameters
        * 
        * @param o
        * @return 
        */
    
    public int compareTo(Email o) {
        
        if(this.subject.compareTo(o.subject)==-1){
            return -1;
        }
        
        else if(this.subject.compareTo(o.subject)==1){
            return 1;
        }
        
        else if(this.subject.compareTo(o.subject)==0){
            return 0;
        }
        
        return 0;
        
    } 
    
    
}
