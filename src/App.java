import dao.DvdDaoCollectionImpl;
import model.DvdDto;
import service.DvdService;
import service.DvdServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;


public class App {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
/*
        This  no longer applies, as Service Layer was created instead to handle interaction with the DAO layer
  //      DvdDaoCollectionImpl myDVDDao = new DvdDaoCollectionImpl();
        Also, better to reference the Interface instead of the implementation as teh latter may contain logic that applies only to that class
*/
        //myDvdService object in order to access the DvdServiceImpl methods
        DvdService myDvdService = new DvdServiceImpl();

        //char declared for menu purposes , initialized with n (to avoid an infinite loop)
        char continueOption='n';


        System.out.println("First, Load the DVD library from a file");
        //
        //method
        System.out.println("DVD library loaded from file successfully");

        //do-while loop for the menu, to give the user the option to do more actions in the same session
        do{
            System.out.println("**************************");
            System.out.println("1. Add a new DVD to the library");
            System.out.println("2. Remove a DVD from the library");
            System.out.println("3. Update a DVD information");
            System.out.println("4. Display the entire DVD library");
            System.out.println("5. Find a DVD by ID");
            System.out.println("6. Find a DVD by title");
            System.out.println("7. Exit");
            System.out.println("Enter your option: ");
            int userChoice = input.nextInt();
            //switch case based on user choice
            switch (userChoice){
                case 1:
                    //store the return DVD object of getNewDvdInfo() in a new DVD model object
                    DvdDto newlyCreatedDvd = getNewDvdInfo();

                    //call the addDVD method passing the newlyCreatedDvd object as parameter
                    myDvdService.addDVD(newlyCreatedDvd);

                    //display the DVD information to console
                    System.out.println("DVD added to the Library: " + newlyCreatedDvd);
                    break;

                case 2:
                    //first, locate the DVD by ID
                    System.out.println("Insert the DVD Id you wish to remove: ");
                    int dvdId = input.nextInt();

                    //store the return object of the retrieveDVDById method in a new DvdDto object (removeDvdById)
                    DvdDto removeDvdById = myDvdService.retrieveDVDById(dvdId);

                    //if the returned value is null - the DVD does not exist
                    if(removeDvdById==null){
                        System.out.println("There is no DVD with this Id.");
                        break;
                    }

                    //if Dvd is found, display its information to the user
                    System.out.println(removeDvdById);

                    //confirm Remove choice
                    System.out.println( "Are you sure you want to remove the DVD? y/n");
                    char choice = input.next().charAt(0);

                    // if user chooses y - call removeDVD from DvdServiceImpl to remove the DVD object
                    if (choice=='y'){
                        myDvdService.removeDVD(dvdId);
                        System.out.println("DVD successfully removed."); // output result
                    } else if (choice=='n') {
                        System.out.println("Ok. DVD removal aborted.");
                    }
                    break;

                case 3:
                    //method to update DVD, in this example title of DVD, but similarly could be for other attributes/var
                    //again, first retrieve the DVD, using the ID
                    System.out.println("Insert the DVD Id you wish to update: ");
                    int updateDvdId = input.nextInt();

                    //find and store the DVD object into the updateDvdById var
                    DvdDto updateDvdById = myDvdService.retrieveDVDById(updateDvdId);

                    //if the returned value is null - the DVD does not exist
                    if(updateDvdById==null){
                        System.out.println("There is no DVD with this Id.");
                        break;
                    }
                    //if found, display and then update info
                    else{
                        //first, display DVD info to user
                        System.out.println(updateDvdById);

                        //then, take new input from user to update the DVD info (in this case title)
                        System.out.println("Update the DVD Title:");
                        input.nextLine();
                        String newTitle = input.nextLine();

                        // set the user input (String newTitle) as the new title of the updateDvdById object
                        updateDvdById.setTitle(newTitle);

                        //now call the updateDVD methods, passing the updated DVD object as parameter
                        myDvdService.updateDVD(updateDvdById);

                        //inform user of the outcome
                        System.out.println("DVD details updated successfully.");
                    }

                    break;

                case 4:
                    //access the retriveAllDVDs method from DvdService(which will access the DAO)
                    myDvdService.retrieveAllDVDs();

                    //display to user
                    System.out.println("DVD Library fetched and displayed: " + myDvdService.retrieveAllDVDs());
                    break;

                case 5:
                    System.out.println("Insert the ID of the DVD you wish to access: ");
                    int details= input.nextInt(); // take user input and store it in details int var

                    //create a DVD model object where we store the retrieveDVDByID return object
                    //in order to test whether the DVD with that id exists or not
                    DvdDto retrievedDvdById = myDvdService.retrieveDVDById(details);

                    //if the returned value is null - the DVD does not exist
                    if(retrievedDvdById==null){
                        System.out.println("There is no DVD with this Id.");
                        break;
                    }
                    //if Dvd is found, display its information to the user
                    System.out.println("DVD found: " + retrievedDvdById);
                    break;

                case 6:
                    System.out.println("Insert the DVD title: ");
                    input.nextLine();
                    String dvdTitle = input.nextLine();

                    DvdDto retrievedDvdByTitle = myDvdService.retrieveDvdByTitle(dvdTitle);

                    if(retrievedDvdByTitle==null){ //if the returned value is null - the DVD does not exist
                        System.out.println("There is no DVD with this Title.");
                        break;
                    }
                    //if Dvd is found, display its information to the user
                    System.out.println("DVD found: " + retrievedDvdByTitle);
                    break;

                case 7:
                    System.out.println("Thank you for using the book management system.");
                    myDvdService.saveToFile();
                    System.exit(0);

                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Do you want to continue? y/n");
            continueOption = input.next().charAt(0);

        }while(continueOption == 'y');

        //Before the program quits, save to File
        System.out.println("Saving... the DVD library back to the file");
        myDvdService.saveToFile();
        System.out.println("Written to file successfully. Goodbye.");

    }

    public static DvdDto getNewDvdInfo(){

        //take user input for DVD details:
        Scanner input = new Scanner(System.in);

        System.out.println("Insert Dvd Id:");
        int dvdId = input.nextInt();
        // newDvd.setDvdId(dvdId);

        System.out.println("Insert Dvd Title:");
        input.nextLine();
        String dvdTitle = input.nextLine();
        //newDvd.setTitle(dvdTitle);

        System.out.println("Insert Dvd Date: YYYY\n" +
                "MM\n" +
                "DD");
        LocalDate dvdDate = LocalDate.of(input.nextInt(),input.nextInt(),input.nextInt());

        System.out.println("Insert MPAA rating:");
        input.nextLine();
        String dvdMPAARating = input.nextLine();

        System.out.println("Insert director's name:");
        String directorName = input.nextLine();

        System.out.println("Insert studio name:");
        String studio = input.nextLine();

        System.out.println("Rating,from 1 to 5 (1 being the lowest and 5 the highest)");
        int userRating= input.nextInt();

        System.out.println("Leave a short review:");
        input.nextLine();
        String review = input.nextLine();

        //use user values to create a new DVD object, instance of DvdDto class
        DvdDto userDVD = new DvdDto(dvdId,dvdTitle,dvdDate,dvdMPAARating,directorName,studio,userRating,review);

        //return the new DVD object
        return userDVD;
    }
}