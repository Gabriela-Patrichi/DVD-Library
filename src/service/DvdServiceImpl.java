package service;

import dao.DvdDao;
import dao.DvdDaoCollectionImpl;
import dao.DvdDaoFileCollectionImpl;
import model.DvdDto;

import java.util.List;

//Service Layer is added here more so to illustrate the design/architecture
// Service layer will interact with the Dao layer (calling methods), results which will then be passed to the presentation layer

/* LAYERS INTERACTION
Presentation ---> Service ---> DAO -->|
                                     |
Presentation <--- Service <--- DAO <--|
*/

public class DvdServiceImpl implements DvdService {

    DvdDao dvdDao = null; // DvdServiceImpl is dependent on DvdDaoCollectionImpl

    //constructor
    public DvdServiceImpl() {

        //now this can be commented out and refer to the collection File I/O instead
        //dvdDao = new DvdDaoCollectionImpl();

        dvdDao = new DvdDaoFileCollectionImpl();

    }

    @Override
    public DvdDto addDVD(DvdDto newDVD) {
        return dvdDao.addDVD(newDVD); //returns the addDVD method from the Dao
    }

    @Override
    public void removeDVD(int dvdId) {
        dvdDao.removeDVD(dvdId);
    }

    @Override
    public DvdDto updateDVD(DvdDto updateDVD) {
        return dvdDao.updateDVD(updateDVD);
    }

    @Override
    public List<DvdDto> retrieveAllDVDs() {
        return dvdDao.retrieveAllDVDs();
    }

    @Override
    public DvdDto retrieveDVDById(int dvdId) {
        return dvdDao.retrieveDVDById(dvdId);
    }

    @Override
    public DvdDto retrieveDvdByTitle(String title) {
        return dvdDao.retrieveDvdByTitle(title);
    }

    @Override
    public boolean saveToFile() {
        return dvdDao.saveToFile();
    }
}
