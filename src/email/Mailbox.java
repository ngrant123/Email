
package email;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The code construct a Mailbox that contains different folders in it 
 * It contains the inbox, trash, an arrayList of folders, and the main 
 * Mailbox
 * 
 * @author nathangrant
 * 
 * email:nathan.grant@stonybrook.edu
 * Stony Brook Id:109816757
 */
public class Mailbox {

    private Folder inbox=new Folder();
    private Folder trash = new Folder();
    
    private ArrayList<Folder> folders= new ArrayList<Folder> ();
    public static Mailbox mailbox= new Mailbox();
    
   
    /**
     * Default constructor for Mailbox
     * 
     */
   public Mailbox(){
       
       
       
   }
   
   /**
    * Method that returns the Inbox to the user 
    * 
    * @return 
    */
   public Folder getInbox(){
       
       return this.inbox;
   }
   
   /**
    * Method that returns the Trash to the user
    * 
    * @return 
    */
   
   public Folder getTrash(){
       
       return this.trash;
   }
   
    /**
     * Adds an Folder object onto the folders arrayList 
     * 
     * @param folder
     * contains the folder that is going to be added
     * 
     *precondition:
     * The object that is passed into the addFolder method has to be an Folder
     * object
     * 
     * postcondition:
     * The Folder object has been added to the arrayList
     */
   public void addFolder(Folder folder){
       
        folders.add(folder);
       
   }
   
   /**
    * The method removes the folder from the folders arrayList
    * It checks to see if the name matches any of the folder's names and if it 
    * does it removes it
    * 
    * @param name 
    * 
    * postcondition: 
    * The indicated folder is removed from the arraylist 
    */
   
   public void deleteFolder(String name){
       
       int size=folders.size();
       
       for(int i=0;i<size;i++){
           
           if(folders.get(i).getName().compareTo(name)==0){
               folders.remove(i);
               break;
           }
       }
   }
   
      /**
     * Adds the Email object to the trash arrayList 
     * 
     * @param email
     * contains the Email object  that is going to be added to the trash
     * 
     *precondition:
     * The object that is passed into the deleteEmail method has to be an Email
     * object
     * 
     * postcondition:
     * The Email object has been added to the trash
     */
   
   public void deleteEmail(Email email){
       
       trash.addEmail(email);
      
   }
   
   /**
    * Method that clears all of the object in the trash arrayList
    * 
    */
  public void clearTrash(){
     
      trash.getEmails().clear();
  }
  
  /**
   * Moves the email to the designated target
   * 
   * @param email
   * @param target 
   * 
   * precondition:
   * Each of the parameters has to correspond to its data type. 
   * 
   * postcondition:
   * The indicated Email object has been added to the arraylist
   * in the target folder
   * 
   */
  public void moveEmail(Email email,Folder target){
      
      int size= folders.size();
      
      boolean choice=false;
      for(int i=0;i<size;i++){
          
          if(folders.get(i).getName().compareTo(target.getName())==0){
              choice=true;
              break;
          }
      }
      if(choice==true){
          
          target.addEmail(email);
      }
      else if(choice==false){
          inbox.addEmail(email);
      }
      
      
  }
  
  /**
   * This method composes an Email object and adds it to the indicated folder
   * It asks the user information like the subject and the recipients and etc
   * 
   * @param new1 
   * 
   * postcondition:
   * An email object is created from the question that are asked and is then added
   * to the folders object
   * 
   */
  public void composeEmail(Folder new1){
      
      Scanner input= new Scanner(System.in);
      Email new3= new Email();
      
      System.out.println("Enter recipient (To): ");
      String decision2= input.next();
      
      new3.setT(decision2);
      
      System.out.println("Enter carbon copy recipients (CC): ");
      String decisoin3= input.next();
      
      new3.setC(decisoin3);
     
      
      System.out.println("Enter blind carbon copy recipients (BCC): ");
      String decision4= input.next();
      
      new3.setBC(decision4);
      
      System.out.println("Enter subject line:");
      String decision5=input.next();
      
      new3.setSubject(decision5);
      
      System.out.println("Enter body: ");
      String decision6=input.next();
      
      new3.setB(decision6);
      
      Folder new6= new Folder();
      new6.addEmail(new3);
      
      new1.addEmail(new3);
      
  }
  
    /**
   * This method composes an Email object and adds it to the Inbox
   * It asks the user information like the subject and the recipients and etc
   * 
   * @param new1 
   * 
   * postcondition:
   * An email object is created from the question that are asked and is then added
   * to the Inbox
   * 
   */
  public void composeEmail(){
      
      Scanner input= new Scanner(System.in);
      Email new3= new Email();
      
      System.out.println("Enter recipient (To): ");
      String decision2= input.next();
      
      new3.setT(decision2);
      
      System.out.println("Enter carbon copy recipients (CC): ");
      String decisoin3= input.next();
      
      new3.setC(decisoin3);
     
      
      System.out.println("Enter blind carbon copy recipients (BCC): ");
      String decision4= input.next();
      
      new3.setBC(decision4);
      
      System.out.println("Enter subject line:");
      String decision5=input.next();
      
      new3.setSubject(decision5);
      
      System.out.println("Enter body: ");
      String decision6=input.next();
      
      new3.setB(decision6);
      
      Folder new6= new Folder();
      new6.addEmail(new3);
      
      inbox.addEmail(new3);
      
      
  }
 
  
  /**
   * Method that returns the folder that matches the name given in the parameters
   * 
   * @param name
   * @return 
   */
  public Folder getFolder(String name){
      
      int size= folders.size();
      
      for(int i=0;i<size;i++){
          
          if(folders.get(i).getName().compareTo(name)==0){
              return folders.get(i);
          }
      }
      return null;
  }
    
}
