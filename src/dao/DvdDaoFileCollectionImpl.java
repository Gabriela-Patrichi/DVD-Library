
package dao;
import model.DvdDto;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// YET TO BE COMPLETED - DOES NOT WRITE TO FILE

//A NEW CLASS DUE TO THE LOOSE COUPLING PRINCIPLE

//whenever this class is accessed we want some code to run straight away:
//  - read from a file, collect data, create DvdDto and store it in a collection
// then , when exiting the app we want to write to file all DVDs


public class DvdDaoFileCollectionImpl implements DvdDao {

    //collection which will hold the data read from the file at the start of the application (and returned to file before program shuts down)
    List<DvdDto> dvdLibraryFileDataStore = new ArrayList<DvdDto>();


    //read from File in the constructor
    public DvdDaoFileCollectionImpl() {

        try {

            //1. create a File Object
            File myFile = new File("FileDB.txt");
            myFile.createNewFile();

            //2.create a FileReader object - will throw exception
            FileReader fr = new FileReader(myFile);

            //3. create a BufferReader object (because FileReader only reads char by char) - will also throw exception
            BufferedReader br = new BufferedReader(fr);

            //4. store each line of the BufferReader (read line by line and split the lines,)
            //String line = br.readLine();

            // take the tokens one by one and put them in var so that we can create a DVDDto object, to be then added to the dvd Library collection
            String line = null;
            while((line=br.readLine()) != null){
                //use the =, as delimitators (from the toString DvdDto method)
                StringTokenizer stringToken = new StringTokenizer(line,"=,");

                //store each token (a string) in attributes relevant to form a DvdDto object
                stringToken.nextToken();
                String dvdId = stringToken.nextToken();
                int dvdID = Integer.parseInt(dvdId); //parse to int

                stringToken.nextToken();
                String title = stringToken.nextToken();

                stringToken.nextToken();
                String date = stringToken.nextToken();
               // int date = Integer.parseInt(dateY);
                LocalDate releaseDate = LocalDate.parse(date);

                stringToken.nextToken();
                String ratingMPAA = stringToken.nextToken();

                stringToken.nextToken();
                String directorName = stringToken.nextToken();

                stringToken.nextToken();
                String studio = stringToken.nextToken();

                stringToken.nextToken();
                String userRating= stringToken.nextToken();
                int rating = Integer.parseInt(userRating);

                stringToken.nextToken();
                String userNote= stringToken.nextToken();

                //now, make an DVD DTO object
                DvdDto dvd = new DvdDto(dvdID,title,releaseDate,ratingMPAA,directorName,studio,rating,userNote);

                //add the DVD object to the Collection
                dvdLibraryFileDataStore.add(dvd);
            }
        }
        //Catch Exceptions
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    //METHODS TO BE COMPLETED - SAME AS THE DvdDaoCollectionImpl methods!!
    // BUT WITH REFERENCE TO THE dvdFileDataStore Collection !!
    @Override
    public DvdDto addDVD(DvdDto newDVD) {

        // add the parameter object to the collection of DVDs
        dvdLibraryFileDataStore.add(newDVD);

        //return object
        return newDVD;
    }

    //method to remove a dvd, taking as parameter an int
    @Override
    public void removeDVD(int dvdId) {
        // loop through the array list and look for the DVD object with corresponding ID
        for(int i=0; i<dvdLibraryFileDataStore.size(); i++){
            if (dvdLibraryFileDataStore.get(i).getDvdId()== dvdId){ // when found, remove that object from the DVD library
                dvdLibraryFileDataStore.remove(i);
            }
        }
    }

    @Override
    public DvdDto updateDVD(DvdDto updateDVD) {

//  Rewrote method not to include any Scanner (user interaction - which has instead now been passed to App main)

        // loop through the array list and look for the DVD object with corresponding ID
        for(int i=0; i<dvdLibraryFileDataStore.size(); i++){
            if (dvdLibraryFileDataStore.get(i).getDvdId()== updateDVD.getDvdId() ){
                //once found, store the object at that index
                updateDVD = dvdLibraryFileDataStore.get(i);
            }
        }
        return updateDVD; //return object
    }

    @Override
    public List<DvdDto> retrieveAllDVDs() {

        //good practice to create a copy
        List<DvdDto> returnDvdLibrary = new ArrayList<DvdDto>(dvdLibraryFileDataStore);
        return returnDvdLibrary;

        //return dvdLibrary;
    }

    @Override
    public DvdDto retrieveDVDById(int dvdId) {
        DvdDto retrieveDvd = null;

        for (int i = 0; i < dvdLibraryFileDataStore.size(); i++) {
            if (dvdLibraryFileDataStore.get(i).getDvdId() == dvdId) {
                retrieveDvd = dvdLibraryFileDataStore.get(i);

                //BETTER TO CREATE COPIES - LOOSE COOPLING
            }
        }
        return retrieveDvd;
    }

    @Override
    public DvdDto retrieveDvdByTitle(String title) {

        DvdDto retrieveDvd = null;

        for (int i=0; i<dvdLibraryFileDataStore.size();i++){
            if(dvdLibraryFileDataStore.get(i).getTitle().equals(title)){
                retrieveDvd = dvdLibraryFileDataStore.get(i);
            }
        }
        return retrieveDvd;
    }



    @Override
    public boolean saveToFile() {
        //first, traverse through the collection dvdFileDataStore
        //as we traverse write the String representation of Dvd objects to the file

        try {
            //First, create a file object (File type) representing our file
            File myFile = new File("FileDB.txt");

            //Second, we need a stream - a FileWriter object
            FileWriter fw = new FileWriter(myFile);

            //Thirdly, traverse through the collection dvdFileDataStore
            //as we traverse write the String representation of Dvd objects to the file
            for(DvdDto eachDvd: dvdLibraryFileDataStore) {
                fw.write((eachDvd.toString()+ "\n").toCharArray());
                fw.flush(); //make sure everything is written (flushed) to the file
            }
        //catch exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
