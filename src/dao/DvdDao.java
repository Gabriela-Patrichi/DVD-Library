package dao;

import model.DvdDto;

import java.util.List;

public interface DvdDao {

    //one should not be able to access the class directly, thus a DVDDao interface,
    // which will contain the methods (from user stories) which relate to DVDs

 /*
 *
 * The program must do the following:
1. Allow the user to add a DVD to the collection
2. Allow the user to remove a DVD from the collection
3. Allow the user to edit the information for an existing DVD in the collection
4. Allow the user to list the DVDs in the collection
5. Allow the user to display the information for a particular DVD
6. Allow the user to search for a DVD by title
7. Load the DVD library from a file
8. Save the DVD library back to the file when the program completes
9. Allow the user to add, edit, or delete many DVDs in one session
*
 */

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

    //method to access all DVDs - Library; returns a collection
    List<DvdDto> retrieveDvdLibrary();

    //save the DVD library to file
    boolean saveToFile( List<DvdDto> dvdLibrary);


        /*
9. Allow the user to add, edit, or delete many DVDs in one session
    * */
}
