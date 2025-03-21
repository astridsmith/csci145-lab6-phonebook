import java.util.LinkedList;
import java.util.ListIterator;

public class PhonebookManager {
        private LinkedList<Contact> phoneBook = new LinkedList<>(); // initialize linked list

        // add
        public void addContact(String firstName, String lastName, String phoneNumber, String streetAdress){
            // TODO: needs input args for the new contact data and to call the linked list add method! 
            phoneBook.add(new Contact(firstName, lastName, phoneNumber, streetAdress)); // creates new contact object with specified values
        }

        public boolean removeContact(Contact contactToErase){
            // Future: Impliment a uuid system to allow for larger datasets with duplicated names (ie don't delete by name)? Would need to reffer back to defaults in polymorphism 

            phoneBook.remove(contactToErase);
            return true; // TODO: actually do error checking

            // Search phone book using search method. so this is also a stretch goal ig 😭

            //return false; // remove, prevents compilation errors. false should be a failure case in the future.
        }

        public void viewPhonebook(){
            // TODO: Check if phone book is empty (if so print error) otherwise for-each print all contacts 
            if (phoneBook.isEmpty()) {
                System.out.println("Specified phonebook is empty!");
            } else {
                for (Contact contact : phoneBook) { // TODO: double check formatting
                    System.out.println(contact);
                }
            }
        }
        
        public Contact searchPhonebook(String firstName){
            // simple search by first name 
            /*
            for now this is just reserved for the removeContact method and is therefore not acessable by the end-user. 
            when more fields are available we can open it up to user-searching!
            */ 
            
            // check if empty
            if(phoneBook.isEmpty()){
                return null;
            }

            ListIterator<Contact> pbIterator = phoneBook.listIterator(); // Apparently Java's implimentation doesn't include next node type logic so we have to do this (https://www.geeksforgeeks.org/linkedlist-listiterator-method-in-java/ and https://softwareengineering.stackexchange.com/questions/312408/linkedlist-why-no-direct-next-on-elements)
            // search first element
            if(phoneBook.getFirst().getFirstName() == firstName){
                return phoneBook.getFirst();
            }
            // search all subsiquent eliments
            while (pbIterator.hasNext()) {
                Contact currentContact = pbIterator.next(); // get next contact in the list
                if (currentContact.getFirstName().equals(firstName)) {
                    return currentContact;
                }
            }
            // no results? return null
            return null;

           // return new Contact("Chloe", "Price", "(555)555-5555", "44 Ceder Drive \n Arcadia Bay, OR 97141"); // temporary - prevents comp error, actually return a contact object when called 
            // TODO: Stretch goal (EC?): return contact object after a basic search for a name.

        }
}
