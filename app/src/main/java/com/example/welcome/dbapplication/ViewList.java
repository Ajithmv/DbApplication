package com.example.welcome.dbapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewList extends AppCompatActivity {

    DbHelper Mydb;
 
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontentslayout);

        ListView listView = (ListView)findViewById(R.id.ListView);
        Mydb = new DbHelper(this);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = Mydb.getListContents();

        if (data.getCount() == 0){
            Toast.makeText(this, "The database was empty", Toast.LENGTH_SHORT).show();
        }else{
            while (data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,thelist);
                listView.setAdapter(listAdapter);
            }
        }

    }
}
