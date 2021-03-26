package com.example.expensemanager;

import java.util.ArrayList;

public class AddItem {
    ArrayList<String> arr1 = new ArrayList<String>();
    ArrayList<String>  arr2 = new ArrayList<String>();
    private String Name;
    private String Amt;

    public ArrayList<String> addName(String line1){
        Name=line1;
        arr1.add(Name);
        return arr1;
    }
    public ArrayList<String> addAmt(String line2){
        Amt=line2;
        arr2.add(Amt);
        return arr2;

    }





}
