package com.example.hamida.taxi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class Profile extends Fragment {
    private ImageView imag_taxi;
    private EditText matricul;
    private RatingBar ratingbar;
    private RadioButton radioButton;
    private LinearLayout linearLayout;
    private TextView optionTaxi;


    public Profile() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

        imag_taxi = (ImageView) container.findViewById(R.id.imagTaxi);
        matricul = (EditText) container.findViewById(R.id.tx_matricul);
        radioButton = (RadioButton) container.findViewById(R.id.radioButton);
        ratingbar = (RatingBar) container.findViewById(R.id.ratingBar);
        optionTaxi = (TextView) container.findViewById(R.id.tx_option);
        if(radioButton.isChecked()){
            showOptionTaxi();}
        else
        { hideOptioTaxi();}




    }

    private void hideOptioTaxi() {
        imag_taxi.setVisibility(View.GONE);
        matricul.setVisibility(View.GONE);
        radioButton.setVisibility(View.GONE);
        ratingbar.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
        optionTaxi.setVisibility(View.GONE);

    }

   private void showOptionTaxi() {
        imag_taxi.setVisibility(View.VISIBLE);
        matricul.setVisibility(View.VISIBLE);
        radioButton.setVisibility(View.VISIBLE);
        ratingbar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.VISIBLE);
        optionTaxi.setVisibility(View.VISIBLE);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Profile.this , Float.toString( rating ) , Toast.LENGTH_LONG ).show( );

            }
        });

    }


}
