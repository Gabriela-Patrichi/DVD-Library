import dao.DvdDaoCollectionImpl;
import model.DvdDto;

import java.time.LocalDate;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        DvdDaoCollectionImpl myDVDDao = new DvdDaoCollectionImpl();

        DvdDto trialDVD =new DvdDto();

        char continueOption='n';

        System.out.println("First, Load the DVD library from a file");
        //
        //method
        System.out.println("DVD library loaded from file successfully");

        do{
            System.out.println("**************************");
            System.out.println("1. Add a new DVD");
            System.out.println("2. Remove a DVD");
            System.out.println("3. Update a DVD");
            System.out.println("4. Display DVD library");
            System.out.println("5. Display a particular DVD information, search by ID");
            System.out.println("6. Search for a DVD by title");
            System.out.println("7. Exit");
            System.out.println("Enter your option: ");
            int userChoice = input.nextInt();

            switch (userChoice){
                case 1:

//                   DvdDto newUserDvd = getNewDvdInfo(); // for testing purposes only
//                   System.out.println(newUserDvd.toString()); for testing purposes only
//                   DvdDaoCollectionImpl.addDVD(getNewDvdInfo()); - Static reference

                //    DvdDto newlyDvd = getNewDvdInfo();
                    myDVDDao.addDVD(getNewDvdInfo());
                    System.out.println("DVD added to the Library" + getNewDvdInfo().toString());
                    break;

                case 2:
                    System.out.println("Insert the DVD Id you wish to remove: ");
                    int dvdId = input.nextInt();
                    myDVDDao.removeDVD(dvdId);
                    System.out.println("DVD removed");
                    break;
                case 3:
                    myDVDDao.updateDVD(trialDVD);
                    System.out.println("DVD details updated.");
                    break;
                case 4:
                    myDVDDao.retrieveAllDVDs();
                    System.out.println("DVD Library fetched and displayed: " + myDVDDao.retrieveAllDVDs());
                    break;
                case 5:
                    System.out.println("Insert the DVD Id you wish to fetch: ");
                    int details= input.nextInt();
                    System.out.println(myDVDDao.retrieveDVDById(details));
                    break;
                case 6:
                    System.out.println("Insert the DVD's title: ");
                    String dvdTitle = input.next();
                    System.out.println(myDVDDao.retrieveDvdByTitle(dvdTitle));
                    break;
                case 7:
                    System.out.println("DVD library saved back to the file.");
                    break;
                case 8:
                    System.out.println("Thank you for using the book management system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Do you want to continue? y/n");
            continueOption = input.next().charAt(0);

        }while(continueOption == 'y');

        System.out.println("Saving... the DVD library back to the file");
        //method
        //method
        System.out.println("Written to file successfully. Goodbye.");

    }

    public static DvdDto getNewDvdInfo(){

        //take user input for DVD details:
        Scanner input = new Scanner(System.in);

        System.out.println("Insert Dvd Id:");
        int dvdId = input.nextInt();
        // newDvd.setDvdId(dvdId);

        System.out.println("Insert Dvd Title:");
        String dvdTitle = input.next();
        //newDvd.setTitle(dvdTitle);

        System.out.println("Insert Dvd Date: YYYY\n" +
                "MM\n" +
                "DD");
        LocalDate dvdDate = LocalDate.of(input.nextInt(),input.nextInt(),input.nextInt());

        System.out.println("Insert MPAA rating:");
        String dvdMPAARating = input.next();

        System.out.println("Insert director's name:");
        String directorName = input.next();

        System.out.println("Insert studio name:");
        String studio = input.next();

        System.out.println("Rating,from 1 to 5 (1 being the lowest and 5 the highest)");
        int userRating= input.nextInt();

        System.out.println("Leave a short review:");
        String review = input.next();

        //use user values to create a new DVD object, instance of DvdDto class
        DvdDto userDVD = new DvdDto(dvdId,dvdTitle,dvdDate,dvdMPAARating,directorName,studio,userRating,review);

        //return the new DVD object
        return userDVD;
    }
}