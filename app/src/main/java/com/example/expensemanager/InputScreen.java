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

import java.io.Serializable;
import java.util.ArrayList;

public class InputScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1;
    Spinner spinner2;
    FloatingActionButton btn2;
    EditText et1;
    EditText Amount1;
    MainActivity activity=new MainActivity();
    Intent intent ;
    static InputScreen inputScreen;

    public static InputScreen getInstance(){
        return   inputScreen;
    }
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
        inputScreen = this;



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
        TinyDB tinydb=new TinyDB(InputScreen.this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name ;
                Name = et1.getText().toString();

                String Amt ;
                Amt = Amount1.getText().toString();
                arr.add("item1");
                str.add("item2");


                if (Name.equals("") || Amt.equals("")){
                    Toast.makeText(InputScreen.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

                }
                else{
                    arr.add(Name);
                    str.add(Amt);

                    et1.setText(null);
                    Amount1.setText(null);



                    tinydb.putListString("Name",arr);
                    tinydb.putListString("Amt",str);




//                    Toast.makeText(InputScreen.this, Amt+Name, Toast.LENGTH_SHORT).show();
//                    SharedPreferences SpName =getSharedPreferences("Name",MODE_PRIVATE);
//                    SharedPreferences.Editor edName=SpName.edit();
//                    edName.putString("name",Name);
//                    edName.apply();
//                    SharedPreferences SpAmt =getSharedPreferences("Amt",MODE_PRIVATE);
//                    SharedPreferences.Editor edAmt=SpAmt.edit();
//                    edAmt.putString("Amt",Amt);
//                    edAmt.apply();

                    Intent intent1 = new Intent(InputScreen.this, MainActivity.class);
//                    intent1.putExtra("Name1",Name);
//                    intent1.putExtra("amt1",Amt);
                    intent1.putExtra("Id1","1");
                    startActivity(intent1);

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





        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using

         //parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}