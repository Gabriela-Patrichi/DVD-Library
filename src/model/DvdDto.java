package model;

import java.time.LocalDate;

public class DvdDto {
    private int dvdId;
    private String title;
    private LocalDate releaseDate;
    private String ratingMPAA;
    private String directorName;
    private String studio;
    private int userRating;
    private String userNote;

// public Constructors


    public DvdDto() {
    }

    public DvdDto(int dvdId, String title, LocalDate releaseDate, String ratingMPAA, String directorName, String studio, int userRating, String userNote) {
        this.dvdId = dvdId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.ratingMPAA = ratingMPAA;
        this.directorName = directorName;
        this.studio = studio;
        this.userRating = userRating;
        this.userNote = userNote;
    }

    //public Getters and Setters to access the private variables - Encapsulation


    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRatingMPAA() {
        return ratingMPAA;
    }

    public void setRatingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    public String toString() {
        return
                "dvdId=" + dvdId +
                ", title=" + title +
                ", releaseDate=" + releaseDate +
                ", ratingMPAA=" + ratingMPAA +
                ", directorName=" + directorName  +
                ", studio=" + studio  +
                ", userRating=" + userRating +
                ", userNote=" + userNote  +
                '}';
    }
}