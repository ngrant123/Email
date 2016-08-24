# Email
Code for the Simulation of an Email


Email simulation 

This code manages an email system (like a stripped down version of Outlook) except that you can’t 
send and receive emails. This program will have all of the usual email features like deleting emails, 
creating new emails, moving emails to different folders, adding and removing emails. Additionally, 
the user can also sort the emails in either descending or ascending order based on its date and subject
title. It also contains a compareTo method the compares two Email objects with each other 

The Email class constructs and contains all of the necessary for an Email here. For example it 
allows the user to set the subject, the body, the correspondents, and many more. It also sets the 
time and date when the email was created. I

The Folder class represents an Email folder and handles all the logic for adding and removing emails.
The user is able to set the name of the folder, adds and removes emails. Additionally there are four
different sorting methods available. One allows the user to sort the subject in ascending order while 
the order allows the user to sort it in descending order. The last two sorting methods sorts the dates
in either ascending or descending order. 

The NumberComparator class is used to compare two Email objects together. It returns which one is greater
and is used in the Folder class to sort the Dates in ascending order. The NumberComparator2 class is just 
like the NumberComparator class but it sorts the Dates in descending order. 

The SubjectCompare class is used to compare two Email objects together. It returns which one is greater
and is used in the Folder class to sort the Subjects in ascending order. The SubjectCompare2 class is just 
like the SubjectCompare class but it sorts the subjects in descending order. 

The Mailbox class represents an email box and contains all of the folders and necessary methods. Additionally
it contains the inbox, trash, an arrayList of folders, and the main Mailbox. The user can add a Folder to the 
inbox, move an email to a designated target, clear the trash, and some other methods. Most importantly, there is 
a method that composes the email and places them into the inbox or a folder. The method asks the user necessary
information like the subject or who the email is supposed to be sent to. 

The Menu class contains the main method and a menu for this simulation. It asks the user to either add a folder, 
remove a folder, view folder, view trash, and empty trash. Additionally you can compose an email that gets sent
straight to the users inbox. If the user wants to to view inside a folder a submenu will appear and gave the 
user more options. 

