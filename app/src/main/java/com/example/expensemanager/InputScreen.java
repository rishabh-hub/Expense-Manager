package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import com.example.expensemanager.MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.expensemanager.AddItem.arr1;
import static com.example.expensemanager.AddItem.arr2;

import static com.example.expensemanager.AddItem.arr3;
import static com.example.expensemanager.AddItem.arr4;
import static com.example.expensemanager.MainActivity.y1;

public class InputScreen extends AppCompatActivity  {
    Spinner spinner1;
    Spinner spinner2;
    FloatingActionButton btn2;
    EditText et1;
    EditText Amount1;
    Intent intent;
    AddItem additem =new AddItem();
//    static InputScreen inputScreen;

//    public static InputScreen getInstance() {
//        return this;
//    }

    public static ArrayList<String> GiveArr() {
        return arr;

    }

    public static ArrayList<String> GiveStr() {
        return str;

    }

    public static ArrayList<String> arr;

    {
        arr = new ArrayList<String>();
    }

    public static ArrayList<String> str;

    {
        str = new ArrayList<String>();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        btn2 = findViewById(R.id.btn2);
        Amount1 = findViewById(R.id.amount1);
        et1 = findViewById(R.id.et1);
        intent = getIntent();
//        inputScreen = this;



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Expense, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Tags, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name;
                Name = et1.getText().toString();

                String Amt;
                Amt = Amount1.getText().toString();

                String type = spinner1.getSelectedItem().toString();
                String tag = spinner2.getSelectedItem().toString();



                if (Name.equals("") || Amt.equals("")) {
                    Toast.makeText(InputScreen.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

                }
                else {
//                    arr.add(Name);
//                    str.add(Amt);
//                    MainActivity.y1.add(Name);
//                    MainActivity.y2.add(Amt);

                    arr1.add(Name);
                    arr2.add(Amt);
                    arr3.add(type);
                    arr4.add(tag);
//                    Toast.makeText(InputScreen.this,y1.get(0), Toast.LENGTH_SHORT).show();

                    et1.setText(null);
                    Amount1.setText(null);
//                    saveData();



//                    SharedPreferences SpName =getSharedPreferences("Name",MODE_PRIVATE);
//                    SharedPreferences.Editor edName=SpName.edit();
//                    edName.putString("name",Name);
//                    edName.apply();
//                    SharedPreferences SpAmt =getSharedPreferences("Amt",MODE_PRIVATE);
//                    SharedPreferences.Editor edAmt=SpAmt.edit();
//                    edAmt.putString("Amt",Amt);
//                    edAmt.apply();
                    SharedPreferences Sp = getSharedPreferences("App", MODE_PRIVATE);
                    SharedPreferences.Editor editor = Sp.edit();
                    Gson gson = new Gson();
                    String json1 = gson.toJson(arr1);
                    String json2 = gson.toJson(arr2);
                    String json3 = gson.toJson(arr3);
                    String json4 = gson.toJson(arr4);

//                    editor.remove("name").commit();
//                    editor.remove("Amt").commit();
                    editor.putString("name", json1);
                    editor.putString("Amt",json2);
                    editor.putString("type",json3);
                    editor.putString("tag",json4);

                    editor.apply();




//                    try {
//                        editor.putString("name", ObjectSerializer.serialize(arr));
//                        editor.putString("Amt", ObjectSerializer.serialize(str));
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    editor.commit();
//                }


                    Intent intent = new Intent(InputScreen.this, MainActivity.class);
                    intent.putExtra("Name1", Name);
                    intent.putExtra("amt1", Amt);
                    intent.putExtra("Id1", "1");
                    startActivity(intent);

                }


//
//
//
//
////                activity.arr.add(Name);
////                activity.str.add(Amt);
//
//                Bundle args = intent.getBundleExtra("BUNDLE");
//                ArrayList<String> arr = (ArrayList<String>) args.getSerializable("ARRAYLIST");
//                Bundle args1 = intent.getBundleExtra("BUNDLE1");
//                ArrayList<String> str = (ArrayList<String>) args1.getSerializable("ARRAYLIST1");
//                arr.add(Name);
//                str.add(Amt);
//                String element = y1.get(0);
//
//                String element1 = str.get(0);
//
//                Toast.makeText(InputScreen.this, "Here is your Value"+element+element1, Toast.LENGTH_SHORT).show();
//
//


//                Bundle args2 = new Bundle();

//                args.putSerializable("ARRAYLIST2",(Serializable)arr);
//                intent1.putExtra("BUNDLE",args2);
//
//
//                Bundle args3 = new Bundle();
//                args1.putSerializable("ARRAYLIST3",(Serializable)str);
//                intent1.putExtra("BUNDLE3",args3);
            }



        });


    }private void saveData(){
        SharedPreferences Sp =getSharedPreferences("App",MODE_PRIVATE);
        SharedPreferences.Editor editor =Sp.edit();
        Gson gson =new Gson();
        String json =gson.toJson(arr);
        String json1=gson.toJson(str);
        editor.putString("name",json);
        editor.putString("Amt",json1);
        editor.apply();
    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("App", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("name", null);
//        Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();

        arr1 = gson.fromJson(json,
                new TypeToken<List<String>>() {
                }.getType());
//        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        String json1 = sharedPreferences.getString("Amt", null);
        arr2 = gson.fromJson(json1,
                new TypeToken<List<String>>() {
                }.getType());
        String json2 = sharedPreferences.getString("type", null);
        arr3 = gson.fromJson(json2,
                new TypeToken<List<String>>() {
                }.getType());
        String json3 = sharedPreferences.getString("tag", null);
        arr4 = gson.fromJson(json3,
                new TypeToken<List<String>>() {
                }.getType());
    }


}