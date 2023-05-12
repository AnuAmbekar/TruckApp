package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {

    Button button;
    DbHelperLogin db;
    EditText passwordEdit, name, confirmPassword, phone;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        button = findViewById(R.id.button);
        passwordEdit = findViewById(R.id.passwordedit);
        name = findViewById(R.id.name);
        confirmPassword = findViewById(R.id.confirmpassword);
        phone = findViewById(R.id.phone);
        db = new DbHelperLogin(this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEdit.getText().toString();
                String username = name.getText().toString();
                String confirmPass = confirmPassword.getText().toString();
                String phoneNo = phone.getText().toString();
                //insert = db.insertUser(username, password);

                if (!confirmPass.equals(password)) {
                    Toast.makeText(Signin.this, "Didn't work.", Toast.LENGTH_SHORT).show();
                }

                else {
                    long insert = db.insertUser(username, password);

                    if (insert > 0) {
                        Toast.makeText(Signin.this, "Worked", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Signin.this, MainActivity.class));
                    }

                    else {
                        Toast.makeText(Signin.this, "Didn't work", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }


}