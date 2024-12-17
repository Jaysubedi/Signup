package com.example.my_new_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Page extends AppCompatActivity {
    EditText email, password, ConfirmPassword;
    Button signup;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_page);
       email = findViewById(R.id.txt_email1);
       password = findViewById(R.id.txt_password2);
       ConfirmPassword = findViewById(R.id.txt_Cpassword);

       firebaseAuth =FirebaseAuth.getInstance();

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String Email = email.getText().toString().trim();
               String Password = password.getText().toString().trim();

               if (Email.isEmpty()){
                   Toast.makeText(SignUp_Page.this,"please Enter the Email", Toast.LENGTH_SHORT);
               }
               if(Password.isEmpty()){
                   Toast.makeText(SignUp_Page.this,"please Enter the Password", Toast.LENGTH_SHORT);

               }
               if(Password.length()<6){
                   Toast.makeText(SignUp_Page.this,"Password is too short", Toast.LENGTH_SHORT);

               }
               if(ConfirmPassword.equals(Password)){
                   firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if(task.isSuccessful()){
                                       Intent intent = new Intent (SignUp_Page.this, MainActivity.class);
                                       startActivity(intent);
                                       finish();
                                   }
                                   else{
                                       Toast.makeText(SignUp_Page.this, "someThing is Wrong", Toast.LENGTH_SHORT);
                                   }
                               }
                           });
               }
           }
       });
    }
}