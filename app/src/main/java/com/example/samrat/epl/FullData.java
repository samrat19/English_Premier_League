package com.example.samrat.epl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullData extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8;
    ImageView imageView;
    int team_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_data);

        t1=(TextView)findViewById(R.id.mp);
        t2=(TextView)findViewById(R.id.win);
        t3=(TextView)findViewById(R.id.loss);
        t4=(TextView)findViewById(R.id.draw);
        t5=(TextView)findViewById(R.id.gf);
        t6=(TextView)findViewById(R.id.ga);
        t7=(TextView)findViewById(R.id.gd);
        t8=(TextView)findViewById(R.id.points);
        imageView=(ImageView)findViewById(R.id.crest);


        final Intent intent = getIntent();

        String mp=intent.getStringExtra("MATCH");
        String w=intent.getStringExtra("WIN");
        String l=intent.getStringExtra("LOSS");
        String d=intent.getStringExtra("DRAWS");
        String gf=intent.getStringExtra("GF");
        String ga=intent.getStringExtra("GA");
        String gd=intent.getStringExtra("GD");
        String p=intent.getStringExtra("POINT");
        String poster = intent.getStringExtra("POSTER");
        String tname=intent.getStringExtra("TEAM_NAME");

        t1.setText("Matches Played : "+" "+mp);
        t2.setText("Won : "+""+p);
        t3.setText("Loss : "+""+w);
        t4.setText("Draw : "+""+l);
        t5.setText("Goals For : "+""+gf);
        t6.setText("Goals Against : "+""+ga);
        t7.setText("Goal Difference : "+""+gd);
        t8.setText("Points : "+""+d);

        loadimage(poster);

    }

    private void loadimage(String poster) {

        Picasso.with(getApplicationContext()).load(poster).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
