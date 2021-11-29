package com.example.hamida.taxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private Button login;
    private Button google;
    private Button facebook;
    private EditText passwurd;
    private EditText username;
    private FirebaseAuth mAuth;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.bt_login);
        register = (TextView) findViewById(R.id.tx_regester);
        facebook = (Button) findViewById(R.id.bt_facebook);
        google = (Button) findViewById(R.id.bt_google);
        username = (EditText) findViewById(R.id.tx_username);
        passwurd = (EditText) findViewById(R.id.tx_password);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Inscription.class));

            }

        });
        facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }

        });
        google.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }

        });
        if (username.getText()==null){
            Toast.makeText(Login.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show(); }
        else if (passwurd.getText()==null) {
            Toast.makeText(Login.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();
        }else{
            login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(Login.this, AppMainActivity.class));

                }

            });

        }
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

}
