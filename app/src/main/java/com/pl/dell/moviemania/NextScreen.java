package com.pl.dell.moviemania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NextScreen extends AppCompatActivity {

    ImageView iv;
    TextView rating;
    TextView title;
    TextView overview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_screen);

        iv=(ImageView) findViewById(R.id.image);
        rating=(TextView) findViewById(R.id.rating);
        title=(TextView)findViewById(R.id.name);
        overview=(TextView)findViewById(R.id.description);



        String t=getIntent().getStringExtra("Title");
        String i=getIntent().getStringExtra("Image");
        double r=getIntent().getDoubleExtra("Rating", 0.0);
        String O=getIntent().getStringExtra("Overview");

        Log.d("Adapter"," " +r);



        title.setText(t);
        overview.setText(O +" " + " "+r);
        Picasso.with(getApplicationContext()).load(i).into(iv);
        rating.setText("Rating: "+r);

        Log.d("Adapter"," abhin" +rating);


    }
}
