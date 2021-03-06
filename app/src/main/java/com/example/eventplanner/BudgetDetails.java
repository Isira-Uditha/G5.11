package com.example.eventplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventplanner.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class BudgetDetails extends AppCompatActivity {


    Button button;
    ImageView imageView;
    ImageView imageView3;

    TextView btot, bpaid, bamount ;
    private ListView budgetView;


    Context context;
    private DBHelper dbHelper;
    private List<Budgets> bds;


    //for calculation
    private int overTotal = 0 ;
    private  int overPaid=0;

    private  int overDue= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Budget Information");
        //disable nagivation  bar
        //getSupportActionBar().hide();

        context = this;
        dbHelper = new DBHelper(context);
        budgetView = (ListView)findViewById(R.id.idBudgetView);
        btot = findViewById(R.id.tvTota);
        bpaid = findViewById(R.id.tvPaidA);
        bamount = findViewById(R.id.tvAmount);


        bds = new ArrayList<>();
        SharedPreferences prf = getSharedPreferences("eid",MODE_PRIVATE);
        String eid = prf.getString("eid", "No ID");
        bds = dbHelper.readAllBudgets(eid);


        overTotal = dbHelper.sumBudget(eid);
        btot.setText(String.valueOf(overTotal));
        System.out.println( "Summmmmmmmmmmmmmmmmmmmmm " + overTotal);

        overPaid = dbHelper.sumBPaid(eid);
        bpaid.setText(String.valueOf(overPaid));

        overDue = calculateOverDue(overTotal,overPaid) ;
        bamount.setText(String.valueOf(overDue));


        BudgetAdapter adapter = new BudgetAdapter(context , R.layout.single_budget, bds);
        budgetView.setAdapter(adapter);


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

        /*budgetView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                final Budgets buds = bds.get(position);
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle(buds.getBudgetName());
                builder.setMessage("Paid Amount :");
                builder.setMessage(buds.getPadiAmount());
                builder.setMessage("Amount :");
                builder.setMessage(buds.getAmount());
                builder.show();
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(context,BudgetDetails.class));
                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        dbHelper.deleteBudget(buds.getId());

                    }
                });

            }
        });*/



        //Edit shoppinglist
        /*imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetDetails.this, EditShoppingList.class);
                startActivity(intent);
            }
        });*/

        //Calculation
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home){

            Intent intent = new Intent(BudgetDetails.this,BudgetOne.class);

            /*Context context = getApplicationContext();
            CharSequence text = context.getString(R.string.g_toast_redirect);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 10);
            toast.show();*/

            startActivity(intent);

        }
        return true;
    }

    public int calculateOverDue(int total , int paid){

        int duePay = total - paid;
        return duePay;

    }



}