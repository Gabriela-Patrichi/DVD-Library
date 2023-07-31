package dao;

import model.DvdDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DvdDaoCollectionImpl implements DvdDao{

    //store the DVD Library in a collection
    List<DvdDto> dvdLibrary = new ArrayList<DvdDto>();

    //CONSTRUCTOR
    public DvdDaoCollectionImpl() {

        DvdDto dvd1= new DvdDto(1,"Jaws", LocalDate.of(1979,01,1),"15","Spielberg", "Warner Bros", 3,"A biteful");
        DvdDto dvd2 = new DvdDto(2,"One", LocalDate.of(1999,12,12),"18","Thorsen", "Warner Bros", 2,"Not so good...");
        DvdDto dvd3 = new DvdDto(3, "Gladiator", LocalDate.of(2000,05,1),"12","Ridley Scott", "DreamWorks", 5,"Awesome...");

        dvdLibrary.add(dvd1);
        dvdLibrary.add(dvd2);
        dvdLibrary.add(dvd3);
    }

    // IMPLEMENT METHODS FROM THE DvdDao Interface
    @Override
    public DvdDto addDVD(DvdDto newDVD) {

/*          THIS METHOD IS NOW IN MAIN AS GET DVDINFO(), USE ITS RETURN OBJECT VALUE TO PASS IT AS A PARAMETER IN THE ADDDVD METHOD HERE
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
      */

        // add the parameter object to the collection of DVDs
        dvdLibrary.add(newDVD);
        //return object
        return newDVD;
    }

    //method to remove a dvd, taking as parameter an int (user input)
    @Override
    public void removeDVD(int dvdId) {
        // loop through the array list and look for the DVD object with corresponding ID
        for(int i=0; i<dvdLibrary.size(); i++){
            if (dvdLibrary.get(i).getDvdId()== dvdId){ // when found, remove that object from the DVD library
                dvdLibrary.remove(i);
            }
        }
    }

    @Override
    public DvdDto updateDVD(DvdDto updateDVD) {

        DvdDto updateDvd = null;
        System.out.println("Enter the DVD id:");
        Scanner input = new Scanner(System.in);
        int getDvdId = input.nextInt();

        // loop through the array list and look for the DVD object with corresponding ID
        for(int i=0; i<dvdLibrary.size(); i++){
            if (dvdLibrary.get(i).getDvdId()== getDvdId ){
                //method to update the title (similarly could be done for any other var/ attribute)
                System.out.println("Current DVD details are: " + dvdLibrary.get(i).toString());
                updateDvd = dvdLibrary.get(i);

                System.out.println("Please update the DVD title: ");
                String newDvdUpdate = input.next();
                updateDvd.setTitle(newDvdUpdate);
                System.out.println("New DVD details are:" + updateDvd.toString());

            }
        }
        return updateDvd;
    }

    @Override
    public List<DvdDto> retrieveAllDVDs() {

        //good practice to create a copy
        List<DvdDto> returnDvdLibrary = new ArrayList<DvdDto>(dvdLibrary);
        return returnDvdLibrary;

        //return dvdLibrary;
    }

    @Override
    public DvdDto retrieveDVDById(int dvdId) {
        DvdDto retrieveDvd = null;

        for (int i = 0; i < dvdLibrary.size(); i++) {
            if (dvdLibrary.get(i).getDvdId() == dvdId) {
                System.out.println("Details for DVD are:" + dvdLibrary.get(i).toString());
                retrieveDvd = dvdLibrary.get(i);
            }
        }
        return retrieveDvd;
    }

    @Override
    public DvdDto retrieveDvdByTitle(String title) {

        DvdDto retrieveDvd = null;

        for (int i=0; i<dvdLibrary.size();i++){
            if(dvdLibrary.get(i).getTitle()== title){
                System.out.println("Details for this DVD are:" + dvdLibrary.get(i).toString());
                retrieveDvd = dvdLibrary.get(i);
            }
        }
        return retrieveDvd;
    }

    @Override
    public List<DvdDto> retrieveDvdLibrary() {
        return null;
    }

    @Override
    public boolean saveToFile(List<DvdDto> dvdLibrary) {
        return false;
    }



}
