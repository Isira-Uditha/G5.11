// This is the class use to initialize the constructors
package com.example.eventplanner.Database;

public class GuestModel {

        //Declaring the variables relative to the columns in the Guest table
        private int guestID;
        private String guestName,guestGender,guestAge,guestContact,guestEmail;
        private int guestCheck;
        private String guestNote;
        private int EID;

    public GuestModel(int guestID, String guestName, String guestGender, String guestAge, String guestContact, String guestEmail, int guestCheck, String guestNote, int eID) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.guestGender = guestGender;
        this.guestAge = guestAge;
        this.guestContact = guestContact;
        this.guestEmail = guestEmail;
        this.guestCheck = guestCheck;
        this.guestNote = guestNote;
        EID = eID;
    }

    //Default constructor of the GuestModel class
    public GuestModel() {
    }

    public GuestModel(int guestID, String guestName, String guestGender, String guestAge, String guestContact, String guestEmail, int guestCheck, String guestNote) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.guestGender = guestGender;
        this.guestAge = guestAge;
        this.guestContact = guestContact;
        this.guestEmail = guestEmail;
        this.guestCheck = guestCheck;
        this.guestNote = guestNote;
    }

    public GuestModel(String guestName, String guestGender, String guestAge, String guestContact, String guestEmail, int guestCheck, String guestNote) {
        this.guestName = guestName;
        this.guestGender = guestGender;
        this.guestAge = guestAge;
        this.guestContact = guestContact;
        this.guestEmail = guestEmail;
        this.guestCheck = guestCheck;
        this.guestNote = guestNote;
    }

    //Initializing the getters and setter
    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getGuestAge() {
        return guestAge;
    }

    public void setGuestAge(String guestAge) {
        this.guestAge = guestAge;
    }

    public String getGuestContact() {
        return guestContact;
    }

    public void setGuestContact(String guestContact) {
        this.guestContact = guestContact;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public int getGuestCheck() {
        return guestCheck;
    }

    public void setGuestCheck(int guestCheck) {
        this.guestCheck = guestCheck;
    }

    public String getGuestNote() {
        return guestNote;
    }

    public void setGuestNote(String guestNote) {
        this.guestNote = guestNote;
    }

    public int getEmpID() {
        return EID;
    }

    public void setEmpID(int eID) {
        EID = eID;
    }
}
