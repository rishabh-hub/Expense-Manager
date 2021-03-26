package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.expensemanager.AddItem.arr1;
import static com.example.expensemanager.AddItem.arr2;
import static com.example.expensemanager.AddItem.arr3;
import static com.example.expensemanager.AddItem.arr4;

public class MainActivity extends AppCompatActivity implements java.io.Serializable {
    RecyclerView recyclerView ;
    FloatingActionButton btn1;
    FloatingActionButton btn2;
    TextView Counter;

//    static MainActivity Activity;
    public static ArrayList<String> y1 =new ArrayList<String>();
    public static ArrayList<String> y2=new ArrayList<String>();
    Intent intent;
//    private ArrayList<String> arr1 = new ArrayList<String>();
//    private ArrayList<String>  arr2 = new ArrayList<String>();
    private String Name;
    private String Amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AddItem additem =new AddItem();

//        Activity = this;
        recyclerView = findViewById(R.id.recyclerView);
        btn1 = findViewById(R.id.Button3);
        intent=getIntent();
        Counter=findViewById(R.id.Counter);
        btn2=findViewById(R.id.ActionButton);
        String NAME;
        String AMT;



//        y1 = new ArrayList<String>(3);
//        y2 = new ArrayList<String>(3);


//        y2 = InputScreen.getInstance().GiveStr();
//        y1 = InputScreen.getInstance().GiveArr();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        double c2;
//        c2= AddItem.count;
//        AMT=Double.toString(c2);
//        Counter.setText("Your Balance:"+AMT);
//        arr1.add("name");
//        arr2.add("Amt");
//        arr3.add("type");
//        arr4.add("tag");
//        NAME = intent.getStringExtra("Name1");
//        AMT = intent.getStringExtra("amt1");
//        addName(NAME,AMT);
//        addName("This","150");
//        loadData();
////        Toast.makeText(MainActivity.this,y1.get(0)+y2.get(0), Toast.LENGTH_SHORT).show();
//        loadData();

        if(arr1!= null && arr2!=null) {
//            Toast.makeText(MainActivity.this,arr1.get(0), Toast.LENGTH_SHORT).show();
            double[] doubleList = new double[arr2.size()];
            double sum = 0;
            for (int i = 0; i < arr2.size(); ++i) {

                doubleList[i] = Double.parseDouble(arr2.get(i));
                if (arr3.get(i).equals("Income")) {
                    sum += doubleList[i];
                }
                else{
                    sum -= doubleList[i];
                }
            }
            AMT=Double.toString(sum);
            Counter.setText("Your Balance: ₹"+AMT);



            Collections.reverse(arr1);
            Collections.reverse(arr2);
            Collections.reverse(arr3);
            Collections.reverse(arr4);





            CustomAdapter c = new CustomAdapter(arr1, arr2, arr3, arr4);
            recyclerView.setAdapter(c);
            c.notifyDataSetChanged();
        }





//        y1.add(NAME);
//        y2.add(AMT);
//        c.notifyItemInserted(0);
//        y1.add("Item");
//        y1.add("Salary");
//        y2.add("Fees");
//        y2.add("Item");
//        y1.add("Item");
//        y2.add("Item");

//        SharedPreferences SpName =getSharedPreferences("Name",MODE_PRIVATE);
//        SharedPreferences SpAmt =getSharedPreferences("Amt",MODE_PRIVATE);
//        String Val=SpName.getString("name",null);
//        String Val1=SpAmt.getString("Amt",null);
//
//        String element1=y1.get(0);
//
//        String element2=y2.get(0);
//        Toast.makeText(MainActivity.this,element1+element2, Toast.LENGTH_SHORT).show();

//        btn1=findViewById(R.id.Button3);
//        SharedPreferences Sp = getSharedPreferences("App", MODE_PRIVATE);
//        try {
//            y1 = (ArrayList<String>) ObjectSerializer.deserialize(Sp.getString("name", ObjectSerializer.serialize(new ArrayList<String>())));
//            y1 = (ArrayList<String>) ObjectSerializer.deserialize(Sp.getString("Amt", ObjectSerializer.serialize(new ArrayList<String>())));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        y1.add("item");
//        y2.add("item");


//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, .class);
//
//                startActivity(intent);
//
//            }
//        });










        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputScreen.class);

                startActivity(intent);

            }









        });







    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("App", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("name", null);
//        Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();

        arr1= gson.fromJson(json,
                new TypeToken<List<String>>(){}.getType());
//        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        String json1 = sharedPreferences.getString("Amt", null);
        arr2= gson.fromJson(json1,
                new TypeToken<List<String>>(){}.getType());
        String json2 = sharedPreferences.getString("type", null);
        arr3= gson.fromJson(json2,
                new TypeToken<List<String>>(){}.getType());
        String json3 = sharedPreferences.getString("tag", null);
        arr4= gson.fromJson(json3,
                new TypeToken<List<String>>(){}.getType());



//        Type type1 = new TypeToken<ArrayList<String>>() {}.getType();
//        y1 = gson.fromJson(json, type);
//        y2 = gson.fromJson(json1,type1);
    }
    public void  addName(String line1,String line2){
        Name=line1;
        arr1.add(Name);
        Amt = line2;
        arr2.add(Amt);;
    }




}