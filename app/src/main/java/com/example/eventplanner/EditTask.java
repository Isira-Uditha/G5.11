//This class for Edit Task
package com.example.eventplanner;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventplanner.Database.DBHelper;
import com.example.eventplanner.Database.Task;

public class EditTask extends AppCompatActivity {

    //Create objects of the elements that are used in the xml file
    Button b1;
    TextView editDescription , editTime;
    CheckBox editFinished;
    TextView editTaskName , editDate;

    private DBHelper dbHelper;
    private Context context;
    private Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        context = this;
        dbHelper = new DBHelper(context);

        b1 = (Button)findViewById(R.id.button2);
        editTaskName = (TextView) findViewById(R.id.idEditTaskName);
        editDescription = (TextView)findViewById(R.id.idEditDescription);
        editDate = (TextView)findViewById(R.id.idEditDate);
        editTime = (TextView)findViewById(R.id.idEditTime);
        editFinished = (CheckBox) findViewById(R.id.idEditFinished);

        //Set the checkBox as not clickable to the user since this page is only retrieve the task details and can not be changed
        editFinished.setClickable(false);


        final String id = getIntent().getStringExtra("id");

        //Call the getSingleTask function in the DBHelper class to retrieve a task details
        final Task task = dbHelper.getSingleTask(Integer.parseInt(id));

        getSupportActionBar().setTitle(task.getTaskName());

        editTaskName.setText(task.getTaskName());
        editDescription.setText(task.getDescription());
        editDate.setText(task.getDate());
        editTime.setText(task.getTime());

        int checkId = task.getFinished();



        //If the task is done the value of the checkId is greater than 0.If it is Checkbox marked as checked
        if(checkId > 0){

            editFinished.setChecked(true);
        }

        System.out.println(id);
        System.out.println(task.getDescription());
        System.out.println(task.getFinished());





        //This executes when user clicks on Edit button in the EditTask interface
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //User navigates to the UpdateTask interface
                Intent intent = new Intent(EditTask.this , UpdateTask.class);
                intent.putExtra("id",String.valueOf(task.getId()));

                Context context = getApplicationContext();
                CharSequence text = "Update Your Task Here.....";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();

                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 10);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home){

            Intent intent = new Intent(EditTask.this,TaskHome.class);

            startActivity(intent);

        }
        return true;
    }
}