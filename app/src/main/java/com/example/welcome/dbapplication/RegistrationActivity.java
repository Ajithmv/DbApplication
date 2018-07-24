package com.example.welcome.dbapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText Name,Phone,Email,Password;
    Button Register;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name = (EditText)findViewById(R.id.et1Name);
        Phone = (EditText)findViewById(R.id.etPhone);
        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Register = (Button) findViewById(R.id.btRegister);

        mydb = new DbHelper(this);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean inserted = mydb.insertData(Name.getText().toString(),Phone.getText().toString(),Email.getText().toString(),Password.getText().toString() );
                if(inserted == true) {
                    Toast.makeText(RegistrationActivity.this, "Registered succesfully", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(RegistrationActivity.this, "Failed to register", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}
