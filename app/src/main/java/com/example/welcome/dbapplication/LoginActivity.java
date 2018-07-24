package com.example.welcome.dbapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login;
    Button Register;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mydb = new DbHelper(this);

        Username = (EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btLogin);
        Register = (Button)findViewById(R.id.btRegister);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = Username.getText().toString();
                String s2 = Password.getText().toString();

                Cursor res = mydb.getAllData(s1,s2);

                while (res.moveToNext()) {

                    if (res.getCount()>0) {

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);

                    }else {

                        Toast.makeText(LoginActivity.this, "Username and Password incorrect", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);

            }
        });
    }
}
