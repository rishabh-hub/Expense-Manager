package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.expensemanager.R;

import java.util.ArrayList;

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



    ArrayList<String> category;
    ArrayList<Integer> expense;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopping.findViewById(R.id.shopping);
        entertainment.findViewById(R.id.entertainment);
        travelling.findViewById(R.id.travel);
        food.findViewById(R.id.food);
        household.findViewById(R.id.household);
        others.findViewById(R.id.others);

        category=new ArrayList<>();
        expense=new ArrayList<>();
        category = getIntent().getStringArrayListExtra("");
        expense = getIntent().getIntegerArrayListExtra("");

        for (int i = 0; i < category.size(); i++)

        {
            if (category.get(i) == "shopping") {
                shopping_sum = shopping_sum + expense.get(i);
            } else if (category.get(i) == "leisure") {
                entertainment_sum = entertainment_sum + expense.get(i);

            } else if (category.get(i) == "travelling") {
                travelling_sum = travelling_sum + expense.get(i);

            } else if (category.get(i) == "food") {
                food_sum = food_sum + expense.get(i);

            } else if (category.get(i) == "household") {
                household_sum = household_sum + expense.get(i);

            } else {
                others_sum = others_sum + expense.get(i);

            }

        }



        shopping.setText(Double.toString(shopping_sum));
        entertainment.setText(Double.toString(entertainment_sum));
        travelling.setText(Double.toString(travelling_sum));
        food.setText(Double.toString(food_sum));
        household.setText(Double.toString(household_sum));
        others.setText(Double.toString(others_sum));}}