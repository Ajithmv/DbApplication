package com.example.welcome.dbapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText Name, Email, Age;
    Button Submit;
    Button Show;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Name = (EditText)findViewById(R.id.etName);
        Email = (EditText)findViewById(R.id.etEmail);
        Age = (EditText)findViewById(R.id.etAge);
        Submit = (Button)findViewById(R.id.btSubmit);
        Show = (Button)findViewById(R.id.btShow);

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ViewList.class);
                startActivity(intent);
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = Name.getText().toString();
                /*String newEntry2 = Email.getText().toString();
                String newEntry3 = Age.getText().toString();*/

                if (Name.length() !=0){
                    addData(newEntry);
                    Name.setText("");
                }/*else {
                    Toast.makeText(HomeActivity.this, "You must write something in Name", Toast.LENGTH_SHORT).show();
                }
                if (Email.length() !=0){
                    addData(newEntry2);
                    Email.setText("");
                }else {
                    Toast.makeText(HomeActivity.this, "You must write something in Email", Toast.LENGTH_SHORT).show();
                }
                if (Age.length() !=0){
                    addData(newEntry3);
                    Age.setText("");
                }else {
                    Toast.makeText(HomeActivity.this, "You must write something in Age", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }
    public void addData(String newEntry){
        boolean inserted = mydb.addData(newEntry);
        if (inserted == true){

            Toast.makeText(this, "Successfully Entered", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
