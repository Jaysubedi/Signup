package com.example.my_new_application;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button SignUp_btn,Login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Login_btn= findViewById(R.id.btn1);
        SignUp_btn = findViewById((R.id.btn2));

        //on click method

        //Login Button Click

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"click to login button",Toast.LENGTH_SHORT);
                Intent button1intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(button1intent);
            }
        });
        SignUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"click to sign button",Toast.LENGTH_SHORT);
                Intent button2intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(button2intent);}
        });
    }
}
