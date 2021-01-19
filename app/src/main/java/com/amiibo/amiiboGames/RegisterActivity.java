package com.amiibo.amiiboGames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        final EditText name1 = findViewById(R.id.name);
        final EditText email1 = findViewById(R.id.email);

        Button registerBtn1 = findViewById(R.id.register_btn1);

        registerBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name1.getText().toString();
                String email = email1.getText().toString();

                email1.setError(null);

                if(EmailValidation.isEmailValid(email)){
                    Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(gotoLoginActivity);
                }else {
                    email1.setError(getResources().getString(R.string.register_invalid_email_message));
                    email1.requestFocus();
                }
                Toast.makeText(RegisterActivity.this, "Name: " + name + "\n" + "Email: "
                +email, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
