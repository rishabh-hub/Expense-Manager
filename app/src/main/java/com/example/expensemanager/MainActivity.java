package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView ;
    FloatingActionButton btn1;
    static MainActivity Activity;
    ArrayList<String> y1 ;
    ArrayList<String> y2 ;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity = this;
        recyclerView = findViewById(R.id.recyclerView);

//        if(getIntent().getStringExtra("Id")=="1") {
//            y2 = InputScreen.getInstance().GiveStr();
//            y1 = InputScreen.getInstance().GiveArr();
//        }


        TinyDB tinydb=new TinyDB(MainActivity.this);
        if(getIntent().getStringExtra("Id1").equals("1")){
            if (tinydb.getListString("Name") == null) {
                Toast.makeText(MainActivity.this,"null values", Toast.LENGTH_SHORT).show();

            }
            else {


                y1 = tinydb.getListString("Name");
                y2 = tinydb.getListString("Amt");
            }

        }


//        Bundle args2 = intent1.getBundleExtra("BUNDLE2");
//        ArrayList<String> arr1 = (ArrayList<String>) args2.getSerializable("ARRAYLIST2");
//        Bundle args3 = intent1.getBundleExtra("BUNDLE3");
//        ArrayList<String> str1 = (ArrayList<String>) args3.getSerializable("ARRAYLIST3");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        SharedPreferences SpName =getSharedPreferences("Name",MODE_PRIVATE);
//        SharedPreferences SpAmt =getSharedPreferences("Amt",MODE_PRIVATE);
//        String Val=SpName.getString("name",null);
//        String Val1=SpAmt.getString("Amt",null);
//
//        String element1=y1.get(0);
//
//        String element2=y2.get(0);
//        Toast.makeText(MainActivity.this,element1+element2, Toast.LENGTH_SHORT).show();

        btn1=findViewById(R.id.Button3);


        CustomAdapter c = new CustomAdapter(y1, y2);

        recyclerView.setAdapter(c);
        c.notifyDataSetChanged();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputScreen.class);
//                Bundle args = new Bundle();
//
//                args.putSerializable("ARRAYLIST",(Serializable)y1);
//                intent.putExtra("BUNDLE",args);
//
//
//                Bundle args1 = new Bundle();
//                args1.putSerializable("ARRAYLIST1",(Serializable)y2);
//                intent.putExtra("BUNDLE1",args1);
                startActivity(intent);
            }



        });







    }


}