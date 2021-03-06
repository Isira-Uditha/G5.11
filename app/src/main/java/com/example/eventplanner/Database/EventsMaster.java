package com.example.eventplanner.Database;

        
import android.provider.BaseColumns;

public class EventsMaster {
//<<<<<<< Kasuni
    public EventsMaster() {
    }

    //This static class for the Task table in the Database.
    public static class Tasks implements BaseColumns{

        //Define the column names of the Task Table
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_TASK_NAME= "taskName";
        public static final String COLUMN_NAME_DATE="date";
        public static final String COLUMN_NAME_TIME= "time";
        public static final String COLUMN_NAME_DESCRIPTION= "description";
        public static final String COLUMN_NAME_FINISHED= "finished";
        public static final String COLUMN_NAME_EVENT_ID= "eventId";

        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getColumnNameTaskName() {
            return COLUMN_NAME_TASK_NAME;
        }

        public static String getColumnNameDate() {
            return COLUMN_NAME_DATE;
        }

        public static String getColumnNameTime() {
            return COLUMN_NAME_TIME;
        }

        public static String getColumnNameDescription() {
            return COLUMN_NAME_DESCRIPTION;
        }

        public static String getColumnNameFinished() {
            return COLUMN_NAME_FINISHED;
        }
    }

    //Initializing the column names of the Guest table
    public static class Guest implements BaseColumns{

        public static final String TABLE_NAME = "guest";
        public static final String COLUMN_NAME_GUEST_NAME = "guest_name";
        public static final String COLUMN_NAME_GUEST_GENDER = "gender";
        public static final String COLUMN_NAME_GUEST_AGE= "age";
        public static final String COLUMN_NAME_GUEST_CONTACT = "guest_contact";
        public static final String COLUMN_NAME_GUEST_EMAIL = "guest_email";
        public static final String COLUMN_NAME_GUEST_INVITED = "invited";
        public static final String COLUMN_NAME_GUEST_NOTE = "note";
        public static final String COLUMN_NAME_GUEST_EVENT_ID = "EmpID";


    }
  
      public static class Events implements BaseColumns {
        public static final String TABLE_NAME = "events";
        public static final String COLUMN_NAME_EVENTNAME = "eventname";
        public static final String COLUMN_NAME_DATE = "eventdate";
        public static final String COLUMN_NAME_TIME = "eventtime";
        public static final String COLUMN_NAME_LOCATION = "eventlocation";
        public static final String COLUMN_NAME_THEME = "eventtheme";
        public static final String COLUMN_NAME_DRESSCODE = "eventdresscode";
        public static final String COLUMN_NAME_PHOTOGRAPHERS = "eventphotographers";
        public static final String COLUMN_NAME_DESCRIPTION = "eventdescription";
        public static final String COLUMN_NAME_PLACE = "place";
      }

      //Anuththara's
      //This static class for the Budget table in the Database.
      public static class Budgets implements BaseColumns{
          public static final String TABLE_NAME="budget";
          public static final String COLUMN_NAME_EBNAME="bname";
          public static final String COLUMN_NAME_EBPADIDA="bpadia";
          public static final String COLUMN_NAME_EBAMOUNT="bamount";
          public static final String COLUMN_NAME_EBNOTE="bnote";
          public static final String COLUMN_NAME_EMP_ID="emp";

      }

    //This static class for the Shopping List table in the Database.
    public static class Shoppings implements  BaseColumns{
        public static final  String TABLE_SNAME="shopping";
        public static final String COLUMN_NAME_SNAME="sname";
        public static final String COLUMN_NAME_SQTY="sqty";
        public static final String COLUMN_NAME_SPRICE="sprice";
        public static final String COLUMN_NAME_SNOTE="snote";
        public static final String COLUMN_NAME_EMP_ID="emp";
    }
}
