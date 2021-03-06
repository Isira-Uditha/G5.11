//This class is the eventEdit.java class
package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventplanner.Database.DBHelper;

public class EventEdit extends AppCompatActivity {

    //create objects
    TextView etEventName,etEventDate,etEventTime,tietLocation,tietTheme,etDressCode,etPhotographer,etDescription , etLocationType;
    public String myExtra = "text";
    Button btnedit;
    private DBHelper dbevent;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        context = this;
        dbevent = new DBHelper(context);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etEventName=findViewById(R.id.editEventName);
        etEventDate=findViewById(R.id.editDate);
        etEventTime=findViewById(R.id.editEventTime);
        tietLocation=findViewById(R.id.editLocation);
        tietTheme=findViewById(R.id.editTheme);
        etDressCode=findViewById(R.id.editDressCode);
        etPhotographer=findViewById(R.id.editPhotographer);
        etDescription=findViewById(R.id.editDescription);
        btnedit = (Button)findViewById(R.id.editButton);
        etLocationType = (TextView) findViewById(R.id.editLocationType);

        final String id = getIntent().getStringExtra("id");
        //retrieve the event details by calling getSingleEvent function in dbHelper class.
        final com.example.eventplanner.Database.Event event = dbevent.getSingleEvent(Integer.parseInt(id));
        getSupportActionBar().setTitle(event.getEventName());

        etEventName.setText(event.getEventName());
        etEventDate.setText(event.getDate());
        etEventTime.setText(event.getTime());
        tietLocation.setText(event.getLocation());
        tietTheme.setText(event.getTheme());
        etDressCode.setText(event.getDressCode());
        etPhotographer.setText(event.getPhotographer());
        etDescription.setText(event.getDescription());
        etLocationType.setText(event.getPlace());
        System.out.println(id);

        //Can execute By clicking edit button in the EventEdit interface.
        btnedit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent myIntent = new Intent(EventEdit.this, EventUpdate.class);
                myIntent.putExtra("id",String.valueOf(event.getId()));
                Context context = getApplicationContext();
                CharSequence text = context.getString(R.string.edit);
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();

                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 10);
                myIntent.putExtra("MAIN_EXTRA", myExtra);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent = new Intent(EventEdit.this,EventHome.class);
            SharedPreferences prf = getSharedPreferences("eid",MODE_PRIVATE);
            String eid = prf.getString("eid", "No ID");
            intent.putExtra("id",eid);
            startActivity(intent);
        }
        return true;
    }
}