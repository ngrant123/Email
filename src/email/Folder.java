
package email;

import java.io.Serializable;
import java.util.*;
import java.util.Collections;

/**
 * The code creates a Folder that stores all of the Email objects into an ArrayList
 * The user can also set the name of the Folder and also use a sorting method on
 * it
 * 
 * @author nathangrant
 * 
 * email:nathan.grant@stonybrook.edu
 * Stony Brook Id:109816757
 * 
 */

public class Folder extends Email{

    private ArrayList<Email> emails= new ArrayList<Email>();
    private String name;
    private String currentSortingMethod;
    
    
    /**
     * 
     * Default constructor for Folder
     */
    public Folder(){
        
    }
    
    /**
     * Creates a Folder object that contains an email arraylist
     * The arraylist in the parameters is initialized to the folder's own arraylist
     * 
     * @param emails 
     */
    public Folder(ArrayList<Email> emails){
        
        this.emails=emails;
    }

    /**
     * Method that returns the email arraylist in this folder
     * 
     * @return 
     */
    public ArrayList<Email> getEmail(){
        return this.emails;
    }
    
    /**
     * Method that allows the user to set the email arraylist in this folder
     * 
     * @param email 
     */
    public void setEmails(ArrayList<Email> email){
        this.emails=email;
        
    }
    
    /**
     * Method that returns the email arraylist in this folder
     * 
     * @return 
     */
    
    public ArrayList getEmails(){
        
        return this.emails;
    }
    
    /**
     * Method that returns the name of this Folder
     * 
     * @return 
     */
    public String getName(){
        
        return this.name;
    }
    
    /**
     * Methods that returns the current sorting method for this folder
     * 
     * @return 
     */
    public String getCurrentS(){
        
        return this.currentSortingMethod;
    }
    
    /**
     * Sets the name of this Folder
     * 
     * @param name 
     * Name of the folder that the user wants to set it to
     */
    public void setName(String name){
        
        this.name=name;
    }
    
    /**
     * Sets the name of the current sorting method
     * 
     * 
     * @param currentSortingMethod 
     */
    public void setCurrentS(String currentSortingMethod){
        
        this.currentSortingMethod=currentSortingMethod;
    }
    
    /**
     * Adds an Email object onto the emails arrayList in this folder
     * 
     * @param email
     * contains the email that is going to be added
     * 
     *precondition:
     * The object that is passed into the addEmail method has to be an Email
     * object
     * 
     * postcondition:
     * The Email object has been added to the arrayList
     */
    public void addEmail(Email email){
        
        
        emails.add(email);
        
    }
    
    /**
     * Method that remove the Email object from the arrayList with the corresponding
     * index
     * @param index
     * precondition:
     * The index has to be within the bounds of the arrayList
     * 
     * postcondition:
     * The Email object is removed and the arrayList compensates for the remove
     * object
     * @return 
     */
    public Email removeEmail(int index){
        
        Email email= emails.remove(index);
        emails.remove(index);
        return email;
    }
    
    /**
     * This method sorts the subjects by ascending order in the arrayList
     * It uses the class SubjectCompare and inherits its method to complete the 
     * job
     */
    public void sortBySubjectAscending(){
                         
     //  int size=emails.size();
       Collections.sort(emails, new SubjectCompare());
      
    }
    
    /**
     * This method sorts the subject by descending order
     * 
     * First it uses the Collections sort method to sort the subjects then
     * it sorts it by using the sort method in SubjectCompare2, which sorts it
     * in descending fashion
     * 
     */
    
    public void sortBySubjectDescending(){
        
        int size= emails.size();
        Collections.sort(emails, new SubjectCompare());
       // Collections.reverseOrder();
         Collections.sort(emails, new SubjectCompare2()); 
       
        
    }
     /**
     * This method sorts the dates by ascending order in the arrayList
     * It uses the class NumberCompartor and inherits its method to complete the 
     * job
     */
    public void sortByDateAscending(){
        
        Collections.sort(emails,new NumberCompartor());
        
        
        
    }
    
    /**
     * This method sorts the date by descending order
     * 
     * First it uses the Collections sort method to sort the dates then
     * it sorts it by using the sort method in NumberCompartor2, which sorts it
     * in descending fashion
     * 
     */
    
    public void sortByDateDescending(){
        
        int size= emails.size();
       // Collections.sort(emails, new SubjectCompare());
        //Arrays.sort(emails, Collections.reverseOrder());
         Collections.sort(emails,new NumberCompartor());
        Collections.sort(emails, new NumberCompartor2());
        
       
    }
    /**
     * Method that prints all of Email objects in the emails arrayList and formats 
     * it by its time and its subject
     * 
     */
    public void printEmail(){
        
        int size= emails.size();
        int j=1;
        for(int i=0;i<size;i++){
            
            
            System.out.println(j + " "+emails.get(i).getTime()+" "+emails.get(i).getSub());
            j++;
        }
    }

    
}
