package com.example.hamida.taxi;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inscription extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private EditText first_last_name;
    private EditText confirmpassword;
    private EditText phone;
    private Button inscription;
    private ImageView imag_taxi;
    private ImageView imag_popup;
    private EditText matricul;
    private RatingBar ratingbar;
    private TextView optionTaxi;
    private RadioButton radioButton;
    private LinearLayout linearLayout;
    private Button buttonReturn;
    private Button ok;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        mAuth = FirebaseAuth.getInstance();

        inscription = (Button) findViewById(R.id.bt_inscription);
        email = (EditText) findViewById(R.id.tx_username);
        password = (EditText) findViewById(R.id.tx_password);
         first_last_name=(EditText) findViewById(R.id.tx_name);
        phone=(EditText) findViewById(R.id.tx_telephone);
        confirmpassword=(EditText) findViewById(R.id.confirm_password);
        //test de verification des information
        if ( first_last_name.getText()== null ) {
            Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();
        }else if(phone.getText() == null){
            Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();

        }else if(password.getText() == null){
            Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();

        }else if(email.getText() == null){
            Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();

        }else if(confirmpassword.getText() == null){
            Toast.makeText(Inscription.this, "ERROR:check the wo rd enter.",
                    Toast.LENGTH_SHORT).show();

        }else if(confirmpassword.getText() != password.getText())){
            Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                    Toast.LENGTH_SHORT).show();

        }else{
            inscription.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(Inscription.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                        startActivity(new Intent(Inscription.this, AppMainActivity.class));

                                        Toast.makeText(Inscription.this, "Inscription Sucess.",
                                                Toast.LENGTH_SHORT).show();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Inscription.this, "Inscription failed.",
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });

                }
            });

        }

        ok = (Button) findViewById(R.id.bt_ok);
        buttonReturn = (Button) findViewById(R.id.bt_return);
        imag_popup = (ImageView) findViewById(R.id.back_popup_optionTaxi);
        imag_taxi = (ImageView) findViewById(R.id.imagTaxi);
        matricul = (EditText) findViewById(R.id.tx_matricul);
        radioButton = (RadioButton) findViewById(R.id.radio);
        ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        optionTaxi = (TextView) findViewById(R.id.tx_option);
        if (radioButton.isChecked()) {
            showOptionTaxi();
            if (matricul.getText()==null){
                Toast.makeText(Inscription.this, "ERROR:check the word enter.",
                        Toast.LENGTH_SHORT).show();
            }
            ok.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    hideOptionTaxi();
                }
            });
            buttonReturn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    hideOptionTaxi();
                }

            });
        }

    }

    private void updateUI(FirebaseUser user) {
        FirebaseUser myuser = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            Log.e("user name", name + "email" + email);
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
    }

    public void hideOptionTaxi(){
        imag_taxi.setVisibility(View.GONE);
        imag_popup.setVisibility(View.GONE);
        matricul.setVisibility(View.GONE);
        radioButton.setVisibility(View.GONE);
        rating.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
        optionTaxi.setVisibility(View.GONE);
        buttonReturn.setVisibility(View.GONE);
        ok.setVisibility(View.GONE);
    }
        public <context> void showOptionTaxi(){
            imag_taxi.setVisibility(View.VISIBLE);
            imag_popup.setVisibility(View.VISIBLE);
            matricul.setVisibility(View.VISIBLE);
            radioButton.setVisibility(View.VISIBLE);
            ratingbar.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            optionTaxi.setVisibility(View.VISIBLE);
            buttonReturn.setVisibility(View.VISIBLE);
            ok.setVisibility(View.VISIBLE);
            ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Inscription.this,Float.toString(rating),Toast.LENGTH_LONG).show();

                }
            });
        }

}



