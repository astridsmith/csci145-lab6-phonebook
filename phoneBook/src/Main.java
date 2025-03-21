import java.util.Scanner;

public class Main {
    // this is the test class but I don't like calling it "test"
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // TODO: Scanner implimentation to ask user if they want to add, remove, view, search, etc. 
        // TODO: Add fake contacts to populate the phone book.

        // add 2 phone numbers to da book
        PhonebookManager bellinghamPhoneBook = new PhonebookManager();
        
        bellinghamPhoneBook.addContact("Dawn", "Smith", "(750)442-253", "319 E Magnolia Street\nBellingham WA 98225");
        bellinghamPhoneBook.addContact("John", "Doe", "(555) 555-5555", "1234 Elm Street, Apt 5B\nBellingham WA 98225");

        // chatgpt gave me some more lines bc I lack imaginaton sometimes
        bellinghamPhoneBook.addContact("Emily", "Johnson", "(360) 123-4567", "456 Oak Avenue\nBellingham WA 98225");
        bellinghamPhoneBook.addContact("Michael", "Anderson", "(425) 987-6543", "789 Maple Street, Unit 12\nBellingham WA 98225");
        bellinghamPhoneBook.addContact("Sarah", "Williams", "(206) 555-7890", "321 Pine Road\nBellingham WA 98225");
        bellinghamPhoneBook.addContact("David", "Brown", "(509) 246-8101", "555 Birch Lane, Suite 200\nBellingham WA 98225");
        bellinghamPhoneBook.addContact("Jessica", "Taylor", "(253) 369-1122", "678 Cedar Street\nBellingham WA 98225");

        // User choice loop
        while (1==1) {
            System.out.println("--- Bellingham Phone Book ---");
            System.out.println("-What would you like to do?- \n1) View the entite book.\n2) Add a phone book entry.\n3) Delete a phone book entry.\n4) Search the phone book for a specific entry.\n5) Quit.");
            Scanner functionUserChoice = new Scanner(System.in);
            String functionChoice = functionUserChoice.nextLine();
            // functionUserChoice.close(); // apparently closing system.in AT ALL prevents it from being used again -_- removing this functionality - system resource usage will be minimal anyway
            switch (functionChoice) {
                case "1":
                    bellinghamPhoneBook.viewPhonebook(); // prints out the current phonebook 
                    break;
                case "2":
                    System.out.println("☑ Phonebook entry creation wizard");

                    System.out.println("Please enter the first name of the contact to be added:\n");
                    Scanner fnInput = new Scanner(System.in);
                    String fnToAdd = fnInput.nextLine();
                    // fnInput.close();

                    System.out.println("Please enter the last name of the contact to be added:\n");
                    Scanner lnInput = new Scanner(System.in);
                    String lnToAdd = lnInput.nextLine();
                    // lnInput.close();

                    System.out.println("Please enter the phone number of the contact to be added:\n");
                    Scanner pnInput = new Scanner(System.in);
                    String pnToAdd = pnInput.nextLine();
                    // pnInput.close();

                    // System.out.println("Please enter the adress of the contact to be added (use \"\\n\" to seperate lines):\n");
                    System.out.println("Please enter the adress of the contact to be added:\n"); // newlines in scanner inputs don't work, would need a different implimentaton :( skipping for now
                    Scanner adressInput = new Scanner(System.in);
                    String adressToAdd = adressInput.nextLine();
                    // adressInput.close();

                    // submit deets to addContact
                    bellinghamPhoneBook.addContact(fnToAdd, lnToAdd, pnToAdd, adressToAdd);

                    System.out.println("The entry for " + fnToAdd + " " + lnToAdd + " was added to the phonebook.\n Returning to main menu...");

                    break;
                case "3":
                    //System.out.println("[INFO] Feature not implimented :(");
                    System.out.println("☑ Phonebook entry deletion wizard");
                    System.out.println("Please enter the first name of the contact to be erased:\n");
                    Scanner deleteInput = new Scanner(System.in);
                    String diToSearch = deleteInput.nextLine();
                    // search for it
                    Contact searchResultForDeletion = bellinghamPhoneBook.searchPhonebook(diToSearch);
                    if (searchResultForDeletion != null) {
                        // ask for confirmation
                        boolean chosen = false;
                        while(chosen == false){
                            System.out.println("Found a matching contact:\n" + searchResultForDeletion.toString() + "\nAre you sure you want to delete " + searchResultForDeletion.getFirstName() + "'s information from the phone book? (y/n)");
                            Scanner deleteConf = new Scanner(System.in);
                            String deleteChoice = deleteConf.nextLine();
                            if (deleteChoice.equals("y")){
                                bellinghamPhoneBook.removeContact(searchResultForDeletion);
                                System.out.println("Contact Erased!");
                                chosen = true;
                            } else if(deleteChoice.equals("n")){ chosen = true; } else{
                                System.out.println("Please use the exact formatting: \"y\" or \"n\"");
                            }
                        }
                        
                    } else {
                        System.out.println("The contact could not be erased. Please check the spelling and capitalization of the provided name.");
                    }
                    break;
                case "4":
                    System.out.println("🔎 Phonebook Search Tool");
                    System.out.println("[WARNING] This feature is not fully implimented. Only exact case first-name search is available.");
                    System.out.println("Enter the desired search term:\n");
                    Scanner searchString = new Scanner(System.in);
                    String searchQuery = searchString.nextLine();
                    Contact searchResult = bellinghamPhoneBook.searchPhonebook(searchQuery);
                    if(searchResult != null){
                        System.out.println("Found matching contact!:");
                        System.out.println(searchResult);
                    } else {
                        System.out.println("[ERROR] Could not find contact with specified information.");
                    }

                    
                    // tester
                    // Contact result = bellinghamPhoneBook.searchPhonebook("Sarah");
                    // System.out.println(result);
                    break;
                case "5":
                    System.out.println("Thank you for using the Bellingham Phonebook. Phonebook Exiting...");
                    System.exit(0); // exit process
                default:
                    System.out.println("[ERROR] Your selection was invalid. Please use a number between 1 and 4.");
                    break;
            }

        }
    }
}
