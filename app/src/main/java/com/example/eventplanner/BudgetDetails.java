package com.example.eventplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eventplanner.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class BudgetDetails extends AppCompatActivity {

    ImageButton imageButton;
    Button button;
    ImageView imageView;
    ImageView imageView3;
    private ListView budgetView;

    Context context;
    private DBHelper dbHelper;
    private List<Budgets> bds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_details);
        //disable nagivation  bar
        getSupportActionBar().hide();

        context = this;
        dbHelper = new DBHelper(context);
        budgetView = (ListView)findViewById(R.id.idBudgetView);

        bds = new ArrayList<>();

        bds = dbHelper.readAllBudgets();
       BudgetAdapter adapter = new BudgetAdapter(context , R.layout.single_budget, bds);
       budgetView.setAdapter(adapter);


        //visit to the back page
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetDetails.this,BudgetOne.class);
                Context context = getApplicationContext();
                CharSequence text = context.getString(R.string.click_back);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 10);
                startActivity(intent);
            }
        });

        //Add Budget
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetDetails.this, AddBudget.class);
                Context context = getApplicationContext();
                CharSequence text = context.getString(R.string.bd_toast);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
                toast.setGravity(Gravity.BOTTOM| Gravity.CENTER, 0, 10);
                startActivity(intent);
            }
        });

        //Edit budget
        /*imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetDetails.this, EditBudget.class);
                startActivity(intent);
            }
        });*/


        //Edit shoppinglist
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetDetails.this, EditShoppingList.class);
                startActivity(intent);
            }
        });
    }
}