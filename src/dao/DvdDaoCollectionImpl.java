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

        // add the parameter object to the collection of DVDs
        dvdLibrary.add(newDVD);

        //return object
        return newDVD;
    }

    //method to remove a dvd, taking as parameter an int
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

//  Rewrote method not to include any Scanner (user interaction - which has instead now been passed to App main)

        // loop through the array list and look for the DVD object with corresponding ID
        for(int i=0; i<dvdLibrary.size(); i++){
            if (dvdLibrary.get(i).getDvdId()== updateDVD.getDvdId() ){
                //once found, store the object at that index
                updateDVD = dvdLibrary.get(i);
            }
        }
        return updateDVD; //return object
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
                retrieveDvd = dvdLibrary.get(i);

                //BETTER TO CREATE COPIES - LOOSE COOPLING
            }
        }
        return retrieveDvd;
    }

    @Override
    public DvdDto retrieveDvdByTitle(String title) {

        DvdDto retrieveDvd = null;

        for (int i=0; i<dvdLibrary.size();i++){
            if(dvdLibrary.get(i).getTitle().equals(title)){
                retrieveDvd = dvdLibrary.get(i);
            }
        }
        return retrieveDvd;
    }


    @Override
    public boolean saveToFile() {
        return false;
    }



}
