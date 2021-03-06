// This is the class use for Update a Guest record
package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventplanner.Database.DBGuest;
import com.example.eventplanner.Database.DBHelper;
import com.example.eventplanner.Database.GuestModel;

public class GuestUpdate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //button
    Button btn;
    private DBHelper dbGuest;
    private Context context;
    private  Long updatedDate;
    TextView guest_Name;
    TextView guest_Contact;
    TextView guest_Email;
    TextView guest_Note;
    //TextView guest_Gender;
    //TextView guest_Age;
    CheckBox guest_Invited;
    String title;
    String guest_spin1;
    int checked;
    String s1;
    String s2;
    Spinner spinner1;
    Spinner spinner2;
    String compareValueGender;
    String compareValueAge;

    //This is the onCreate function in GuestUpdate class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_update);
        title = getIntent().getExtras().getString("title");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn = (Button) findViewById(R.id.g_update);

        context = this;
        dbGuest = new DBHelper(context);

        //Call to a function by a reference of the View class
        guest_Name = findViewById(R.id.guest_Name);
        guest_Contact = findViewById(R.id.guest_Contact);
        guest_Email = findViewById(R.id.guest_Email);
        guest_Note = findViewById(R.id.guest_Note);
        guest_Invited = findViewById(R.id.checkInvited);
        guest_Invited.setClickable(true);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        final String id = getIntent().getStringExtra("id");
        final GuestModel guest = dbGuest.readSelectedGuest(Integer.parseInt(id));

        compareValueGender = guest.getGuestGender();
        compareValueAge = guest.getGuestAge();
        //Spinner Gender
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.Spinner_Gender, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        if (compareValueGender != null) {
            int spinnerPosition = adapter1.getPosition(compareValueGender);
            spinner1.setSelection(spinnerPosition);
        }
        spinner1.setOnItemSelectedListener(this);
        //Spinner Age
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Spinner_Age, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        if (compareValueAge != null) {
            int spinnerPosition = adapter2.getPosition(compareValueAge);
            spinner2.setSelection(spinnerPosition);
        }
        spinner2.setOnItemSelectedListener(this);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = adapterView.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s2 = adapterView.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        //Display the details in the View page
        guest_Name.setText(guest.getGuestName());
        guest_Contact.setText(guest.getGuestContact());
        guest_Email.setText(guest.getGuestEmail());
        //guest_Gender.setText(guest.getGuestGender());
        //guest_Age.setText(guest.getGuestAge());


        //guest_Invited.setText(guest.getGuestCheck());
        guest_Note.setText(guest.getGuestNote());

        //System.out.println(id);

        guest_Invited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true){
                    checked = 1;
                } else{
                    checked = 0;
                }
            }
        });

        if(guest.getGuestCheck() > 0){
            guest_Invited.setChecked(true);
            checked = 1;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InputValidatorHelper inputValidatorHelper = new InputValidatorHelper();

                boolean allowSave = true;

                //This is a validation used for the Guest name
                if(inputValidatorHelper.isNullOrEmpty(guest_Name.getText().toString())){

                    // errMsg.append("Task Name Should not be Empty.\n");
                    Toast.makeText(GuestUpdate.this, "Guest Name Should not be Empty", Toast.LENGTH_LONG).show();
                    allowSave = false;

                }

                //This is a validation used for the Contact number
                if(inputValidatorHelper.ischeckContact(guest_Contact.getText().toString())){

                    // errMsg.append("Task Name Should not be Empty.\n");
                    //Toast.makeText(this, "Please Insert a Correct Contact Number", Toast.LENGTH_SHORT).show();
                    Toast.makeText(GuestUpdate.this, "Please Insert a Correct Contact Number", Toast.LENGTH_LONG).show();

                    allowSave = false;

                }

                //This is a validation used for the Email address
                if(!inputValidatorHelper.isValidGuestEmail(guest_Email.getText().toString())){

                    // errMsg.append("Task Name Should not be Empty.\n");
                    //Toast.makeText(this, "Please Insert a Correct E-mail Address", Toast.LENGTH_SHORT).show();
                    Toast.makeText(GuestUpdate.this, "Please Insert a Correct E-mail Address", Toast.LENGTH_LONG).show();
                    allowSave = false;

                }

                String g_name = guest_Name.getText().toString();
                String g_contact = guest_Contact.getText().toString();
                String g_email = guest_Email.getText().toString();
                String g_gender = s1;
                String g_age = s2;
                String g_note = guest_Note.getText().toString();
                int g_invited = checked;
                int id1 = Integer.parseInt(id);

                //This condition statement is check whether the allowSave is True
                if(allowSave) {

                    GuestModel guest = new GuestModel(id1, g_name, g_gender, g_age, g_contact, g_email, g_invited, g_note);
                    //calling the updateGuest function
                    int status = dbGuest.updateGuest(guest);
                    startActivity(new Intent(context, GuestHome.class));

                }


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //This code segment is required to functioning the Navigation Bar
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){

        int id1 = item.getItemId();
        context = this;
        dbGuest = new DBHelper(context);
        final String id = getIntent().getStringExtra("id");
        final GuestModel guest = dbGuest.readSelectedGuest(Integer.parseInt(id));

        if (id1 == android.R.id.home) {

            title = getIntent().getExtras().getString("title");
            Intent intent = new Intent(GuestUpdate.this, GuestEdit.class);
            intent.putExtra("id",id);
            intent.putExtra("g_name",title);

            startActivity(intent);

        }
        return true;

    }
}