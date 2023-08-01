package service;

import model.DvdDto;

import java.util.List;

public interface DvdService {

    //the functionalities will correspond to the DvdDao interface;
    //Keep the same method names across layers for convenience


    //method to add a DVD to the collection, takes in a DvdDto object as arg and will return a DvdDto (Pojo) type of object
    DvdDto addDVD(DvdDto newDVD);

    //method to remove a DVD from the collection, takes in an int as arg (the DVD id); no return
    void removeDVD(int dvdId);

    //method to update an existing DVD, taking Dvd model object as parameter; returns DVD object to the collection
    DvdDto updateDVD(DvdDto newDVD);

    //method to display all DVDs in the collection
    List<DvdDto> retrieveAllDVDs();

    //display the information for a particular DVD, using an int as parameter; return the DVS object
    DvdDto retrieveDVDById(int dvdId);

    //method to display DVD info using a String title to fetch the object
    DvdDto retrieveDvdByTitle(String title);

    //save the DVD library to file
    boolean saveToFile();
}
