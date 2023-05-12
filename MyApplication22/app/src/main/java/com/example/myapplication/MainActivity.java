package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login, signin;
    EditText usernameEdit, passwordEdit;
    DbHelperLogin db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signin = findViewById(R.id.signin);
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);

        db = new DbHelperLogin(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = db.fetchUser(usernameEdit.getText().toString(), passwordEdit.getText().toString());
                if (result == true) {
                    Toast.makeText(MainActivity.this, "It worked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Homepage.class));
                }

                else {
                    Toast.makeText(MainActivity.this, "Didn't work", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, Signin.class));
            }
        });

    }
}