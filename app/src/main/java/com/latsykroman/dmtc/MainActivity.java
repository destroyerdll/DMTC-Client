package com.latsykroman.dmtc;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView sitedmtc;
    ImageButton ImageButton1, ImageButton2, ImageButton3, ImageButton4, ImageButton5, ImageButton6, ImageButton7;
    Intent inst, fb, yt, fond, rozkld, about, set, dmtc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        ImageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        ImageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        ImageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        ImageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        ImageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        sitedmtc = (ImageView) findViewById(R.id.imageView);
        ImageButton1.setOnClickListener(this);
        sitedmtc.setOnClickListener(this);
        ImageButton2.setOnClickListener(this);
        ImageButton3.setOnClickListener(this);
        ImageButton4.setOnClickListener(this);
        ImageButton5.setOnClickListener(this);
        ImageButton6.setOnClickListener(this);
        ImageButton7.setOnClickListener(this);

        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v==ImageButton1){
            inst = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dmtccollege/"));
            startActivity(inst);

        }else if(v==ImageButton2){
            fb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dmtc.college.page/"));
            startActivity(fb);

        }else if(v==ImageButton3){
            yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLLJ443RzJVN5JLnutKHjyw"));
            startActivity(yt);

        }else if(v==ImageButton4){
            fond = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(fond);

        }else if(v==ImageButton5){
            set = new Intent(MainActivity.this, MyPreferenceSettings.class);
            startActivity(set);

        }else if(v==ImageButton6){
            about = new Intent(MainActivity.this, AboutCollege.class);
            startActivity(about);

        }else if(v==ImageButton7){
            rozkld = new Intent(MainActivity.this, list.class);
            startActivity(rozkld);
        }
    }

}
