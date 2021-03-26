package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expensemanager.R;

import java.util.ArrayList;

import static com.example.expensemanager.AddItem.arr2;
import static com.example.expensemanager.AddItem.arr4;


public class screen3 extends AppCompatActivity {

    TextView shopping;
    TextView entertainment;
    TextView travelling;
    TextView food;
    TextView household;
    TextView others;
    double shopping_sum;
    double entertainment_sum;
    double travelling_sum;
    double food_sum;
    double household_sum;
    double others_sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        shopping=findViewById(R.id.shopping);
        travelling=findViewById(R.id.travel);
        entertainment=findViewById(R.id.entertainment);
        food=findViewById(R.id.food);
        household=findViewById(R.id.household);
        others=findViewById(R.id.others);


        //category = getIntent().getStringArrayListExtra("");
        //expense = getIntent().getIntegerArrayListExtra("");

        for (int i = 0; i < arr4.size(); i++)

        {
            if (arr4.get(i).equals("SHOPPING")) {
                shopping_sum = shopping_sum + Integer.parseInt(arr2.get(i));
            }  if (arr4.get(i).equals("ENTERTAINMENT")) {
                entertainment_sum = entertainment_sum + Integer.parseInt(arr2.get(i));

            }  if (arr4.get(i).equals("TRAVEL")) {
                travelling_sum = travelling_sum + Integer.parseInt(arr2.get(i));

            }  if (arr4.get(i).equals("FOOD")) {
                food_sum = food_sum + Integer.parseInt(arr2.get(i));

            }  if (arr4.get(i).equals("HOUSEHOLD")) {
                household_sum = household_sum + Integer.parseInt(arr2.get(i));

            } if (arr4.get(i).equals("OTHERS")){
                others_sum = others_sum + Integer.parseInt(arr2.get(i));

            }

        }



        Toast.makeText(screen3.this,""+shopping_sum, Toast.LENGTH_SHORT).show();
        shopping.setText(""+shopping_sum);
        entertainment.setText(""+entertainment_sum);
        travelling.setText(""+travelling_sum);
        food.setText(""+food_sum);
        household.setText(""+household_sum);
        others.setText(""+others_sum);
    }
}