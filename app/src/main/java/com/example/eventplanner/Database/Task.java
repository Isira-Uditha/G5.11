//This is the model class for the Task table in the Database
package com.example.eventplanner.Database;

public class Task {

    //Declare variables relative to the columns in the Task table
    private int id;
    private String taskName , description;
    private int finished;
    private String date , time;
    private int eventId;

    public Task() {
    }

    //Overloaded Constructor without id and eventId variables
    public Task(String taskName, String description, String date, int finished, String time) {
        this.taskName = taskName;
        this.description = description;
        this.date = date;
        this.finished = finished;
        this.time = time;
    }

    //Overloaded Constructor without eventId variable
    public Task(int id, String taskName,String date,String time, String description, int finished) {
        this.id = id;
        this.taskName = taskName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.finished = finished;

    }

    //Overloaded Constructor with all declared variables
    public Task(int id, String taskName,String date,String time, String description, int finished , int eventId) {
        this.id = id;
        this.taskName = taskName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.finished = finished;
        this.eventId = eventId;

    }

    //Setters and Getter for the all variables

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
