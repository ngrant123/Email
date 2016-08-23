
package email;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.*;
//import java.util.Stack;

public class Menu {
    
    public static void main(String []args) throws ClassNotFoundException{
  
         Mailbox new3= new Mailbox();
        //EmyObj= new Email();
        try {
            //If file is found, open it
             FileInputStream file = new FileInputStream("mySaveFile.obj");
            ObjectInputStream fin = new ObjectInputStream(file);
            new3 = (Mailbox) fin.readObject();
            file.close();
            
                } catch (IOException a) {
                    
                   
        Scanner input=new Scanner(System.in);
        boolean choice=true;
        boolean choice2= true;
        
        ArrayList new4= new ArrayList();
       // Queue menu= (Queue) new Stack();
      //  Mailbox new3= new Mailbox();
        
        new4.add("Mailbox");
        new4.add("------");
        new4.add("Inbox");
        new4.add("Trash");
        
        String c=null;
        
        while(choice!=false){
            
          int size= new4.size();
          
          for(int i=0;i<size;i++){
              
              System.out.println(new4.get(i).toString());              
          }
           
            System.out.println("A - Add folder");
            System.out.println("R - Remove folder");
            System.out.println("C - Compose Email");
            System.out.println("F - Open folder");
            System.out.println("I - Open Inbox");
            System.out.println("T - Open Trash");
            System.out.println("E - Empty Trash");
            System.out.println("Q- Quit");
                    
            System.out.println("Enter a user option: ");
            String decision= input.next();
                    
            switch(decision){
                    
                case "A":
                    
                    System.out.println("Enter folder name: ");
                    decision= input.next();
                    
                    Folder new5= new Folder();
                    
                    new5.setName(decision);
                    new3.addFolder(new5);
                    new4.add(decision);
                    choice=true;
                    break;
                    
                case "C":
                    
                    new3.composeEmail();
                    choice=true;
                    break;
                    
                case "R":
                    
                    System.out.println("Enter the name of the folder");
                    decision=input.next();
                    
                    new3.deleteFolder(decision);
                    int size2=new4.size();
                    for(int i=0;i<size2;i++){
                        
                        if(new4.get(i).toString().compareTo(decision)==0){
                            new4.remove(i);
                        }
                    }
                    choice=true;
                    break;
                    
                case "F":
                    System.out.println("Enter the folder name:");
                    decision=input.next();
                    
                    
                    if(new3.getFolder(decision)!=null){
                      choice2=true;  
                        
                   while( choice2!=false)  {
                        
                       new3.getFolder(decision).printEmail();
                        choice2=true;
                        
                        System.out.println("C - Compose Email");
                        System.out.println("M - Move email");
                        System.out.println("D - Delete email");
                        System.out.println("V - View email contents");
                        System.out.println("SA - Sort by subject line in ascending order");
                        System.out.println("SD - Sort by subject line in descending order");
                        System.out.println("DA - Sort by date in ascending order");
                        System.out.println("DD - Sort by date in descending order");
                        System.out.println("R - Return to mailbox");
                        
                        String decision2=input.next();
                        
                        switch( decision2){
                            
                            case "C":
                                
                                new3.composeEmail(new3.getFolder(decision));
                                break;
                                
                            case "M":
                                System.out.println("Enter the index of the email to move");
                                int index= input.nextInt();
                                index=index-1;
                                
                                new3.getFolder(decision).getEmail().get(index);
                                
                                size = new4.size();

                                for (int i = 0; i < size; i++) {

                                    System.out.println(new4.get(i).toString());
                                }
                                
                                System.out.println("Select folder to move "+new3.getFolder(decision).getEmail().get(index).getSub()+ "to");
                                 decision2= input.next();
                                
                                 if(decision2.compareTo("Inbox")==0){
                                      new3.getInbox().addEmail(new3.getFolder(decision).getEmail().get(index));
                                     
                                 }
                                 else if(decision2.compareTo("Trash")==0){
                                     
                                      new3.getTrash().addEmail(new3.getFolder(decision).getEmail().get(index));
                                 }
                                 else{
                                new3.getFolder(decision2).addEmail(new3.getFolder(decision).getEmail().get(index));
                                 }
                                 
                             //   new3.getFolder(decision).removeEmail(index);
                              //  new3.deleteEmail(new3.getFolder(decision2).getEmail().get(index));
                                new3.getFolder(decision).getEmail().remove(index);
                                choice2=true;
                                break;
                                
                            case "D":
                                
                                System.out.println("Enter email index");
                                index= input.nextInt();
                                index=index-1;
                                
                                
                                new3.deleteEmail(new3.getFolder(decision).getEmail().get(index));
                                new3.getFolder(decision).getEmail().remove(index);
                                choice2=true;
                                break;
                            case "V":
                                System.out.println("Enter the email index");
                                index=input.nextInt();
                                index=index-1;
                                
                                System.out.println(new3.getFolder(decision).getEmail().get(index).getT());
                                System.out.println(new3.getFolder(decision).getEmail().get(index).getC());
                                System.out.println(new3.getFolder(decision).getEmail().get(index).getBC());
                                System.out.println(new3.getFolder(decision).getEmail().get(index).getSub());
                                choice2=true;
                                break;
                                
                            case "SA":
                                new3.getFolder(decision).sortBySubjectAscending();
                                
                                new3.getFolder(decision).printEmail();
                                choice2=true;
                                break;

                            case "SD":
                                new3.getFolder(decision).sortBySubjectDescending();

                                new3.getFolder(decision).printEmail();
                                choice2=true;
                                break;

                            case "DA":
                                new3.getFolder(decision).sortByDateAscending();

                                new3.getFolder(decision).printEmail();
                                choice2=true;
                                break;

                            case "DD":
                                new3.getFolder(decision).sortByDateDescending();

                                new3.getFolder(decision).printEmail();
                                choice2=true;
                                break;
                                
                            case "R":
                                
                                choice2=false;
                                break;

                        }
                       } 
                    }
                    choice=true;
                    break;
                    
                case "I":
                    
                    System.out.println("Inbox");
                    choice2=true;
                   
                    while( choice2!=false)  {
                         new3.getInbox().printEmail();
                         choice2=true;
                    
                        System.out.println("M - Move email");
                        System.out.println("D - Delete email");
                        System.out.println("V - View email contents");
                        System.out.println("SA - Sort by subject line in ascending order");
                        System.out.println("SD - Sort by subject line in descending order");
                        System.out.println("DA - Sort by date in ascending order");
                        System.out.println("DD - Sort by date in descending order");
                        System.out.println("R - Return to mailbox");
                        
                        String decision2=input.next();
                        
                        switch( decision2){
                            
                            case "M":
                                System.out.println("Enter the index of the email to move");
                                int index= input.nextInt();
                                index=index-1;
                                new3.getInbox().getEmail().get(index);
                                
                                size = new4.size();

                                for (int i = 0; i < size; i++) {
                                    System.out.println(new4.get(i).toString());
                                }
                                
                                System.out.println("Select folder to move "+new3.getInbox().getEmail().get(index).getSub()+ "to");
                                 decision2= input.next();
                                 
                                 
                                if(decision2.compareTo("Trash")==0){
                                    new3.getTrash().addEmail(new3.getInbox().getEmail().get(index));
                                    
                                }
                                else{
                                new3.getFolder(decision2).addEmail(new3.getInbox().getEmail().get(index));
                                }
                                 //new3.deleteEmail(new3.getInbox().getEmail().get(index));
                                 new3.getInbox().getEmail().remove(index);
                                //new3.getInbox().removeEmail(index);
                                choice2=true;
                                break;
                                
                            case "D":
                                
                                System.out.println("Enter email index");
                                index= input.nextInt();
                                index=index-1;
                                
                                new3.deleteEmail(new3.getInbox().getEmail().get(index));
                                new3.getInbox().getEmail().remove(index);
                                choice2=true;
                                break;
                            case "V":
                                System.out.println("Enter the email index");
                                index=input.nextInt();
                                index=index-1;
                                
                                System.out.println(new3.getInbox().getEmail().get(index).getT());
                                System.out.println(new3.getInbox().getEmail().get(index).getC());
                                System.out.println(new3.getInbox().getEmail().get(index).getBC());
                                System.out.println(new3.getInbox().getEmail().get(index).getSub());
                                choice2=true;
                                break;
                                
                                
                            case "SA":
                                new3.getInbox().sortBySubjectAscending();
                                
                                new3.getInbox().printEmail();
                                choice2=true;
                                break;

                            case "SD":
                                new3.getInbox().sortBySubjectDescending();

                                new3.getInbox().printEmail();
                                choice2=true;
                                break;

                            case "DA":
                                new3.getInbox().sortByDateAscending();

                                new3.getInbox().printEmail();
                                choice2=true;
                                break;

                            case "DD":
                                new3.getInbox().sortByDateDescending();

                                new3.getInbox().printEmail();
                                choice2=true;
                                break;
                                
                            case "R":
                                choice2=false;
                                break;
                             }

                        }
                    choice=true;
                    break;
                
               
                    case "T":
                    
                         System.out.println("Trash");
                         choice2=true;
                    
                    while( choice2!=false)  {
                        new3.getTrash().printEmail();
                        choice2=true;
                        System.out.println("M - Move email");
                        System.out.println("D - Delete email");
                        System.out.println("V - View email contents");
                        System.out.println("SA - Sort by subject line in ascending order");
                        System.out.println("SD - Sort by subject line in descending order");
                        System.out.println("DA - Sort by date in ascending order");
                        System.out.println("DD - Sort by date in descending order");
                        System.out.println("R - Return to mailbox");
                        
                        String decision2=input.next();
                        
                        switch( decision2){
                            
                            case "M":
                                System.out.println("Enter the index of the email to move");
                                int index= input.nextInt();
                                index=index-1;
                                
                                new3.getTrash().getEmail().get(index);
                                
                                size = new4.size();

                                for (int i = 0; i < size; i++) {

                                    System.out.println(new4.get(i).toString());
                                }
                                
                                System.out.println("Select folder to move "+new3.getTrash().getEmail().get(index).getSub()+ "to");
                                 decision2= input.next();
                                
                                  if(decision2.compareTo("Inbox")==0){
                                      new3.getInbox().addEmail(new3.getTrash().getEmail().get(index));
                                     
                                 }
                                  else{ 
                                  new3.getFolder(decision2).addEmail(new3.getTrash().getEmail().get(index));
                                  }
                                  
                               // new3.deleteEmail(new3.getFolder(decision2).getEmail().get(index));
                                new3.getTrash().getEmail().remove(index);
                                choice2=true;
                                break;
                                
                            case "D":
                                
                                System.out.println("Enter email index");
                                index= input.nextInt();
                                index=index-1;
                                
                                new3.deleteEmail(new3.getTrash().getEmail().get(index));
                                new3.getTrash().getEmail().remove(index);
                                 choice2=true;
                                break;
                            case "V":
                                System.out.println("Enter the email index");
                                index=input.nextInt();
                                index=index-1;
                                
                                System.out.println(new3.getTrash().getEmail().get(index).getT());
                                System.out.println(new3.getTrash().getEmail().get(index).getC());
                                System.out.println(new3.getTrash().getEmail().get(index).getBC());
                                System.out.println(new3.getTrash().getEmail().get(index).getSub());
                                choice2=true;
                                break;
                                
                            case "SA":
                                new3.getTrash().sortBySubjectAscending();
                                
                                new3.getTrash().printEmail();
                                choice2=true;
                                break;

                            case "SD":
                                new3.getTrash().sortBySubjectDescending();

                                new3.getTrash().printEmail();
                                choice2=true;
                                break;

                            case "DA":
                                new3.getInbox().sortByDateAscending();

                                new3.getInbox().printEmail();
                                choice2=true;
                                break;

                            case "DD":
                                new3.getInbox().sortByDateDescending();

                                new3.getInbox().printEmail();
                                choice2=true;
                                break;
                                
                            case "R":
                                choice2=false;
                                break;

                                }
                          }
                        choice=true;
                        break;
                        
                    case "E":
                        new3.getTrash().getEmails().clear();
                        choice=true;
                        break;
                        
                    case "Q":
                        
                        try {
                            FileOutputStream file = new FileOutputStream("mySaveFile.obj");
                            ObjectOutputStream fout = new ObjectOutputStream(file);
                            fout.writeObject(new3);
                            fout.close();
                        } catch (IOException b) { /*Error*/ }
                        
                        choice=false;
                        break;
                        
                    default:
                        System.out.println("This is not one of the choices");
                         choice=true;
                         break;
                        
            }

        }

    } 
  }  
}
               
       