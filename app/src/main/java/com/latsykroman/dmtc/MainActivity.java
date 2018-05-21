package com.latsykroman.dmtc;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView sitedmtc;
    private ImageButton block_facebook, block_youtube, block_instagram, block_archive, block_settings, block_info, block_rozklad;
    private Intent inst, fb, yt, fond, rozkld, about, set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        block_instagram = (ImageButton) findViewById(R.id.image_instagram);
        block_facebook = (ImageButton) findViewById(R.id.image_facebook);
        block_youtube = (ImageButton) findViewById(R.id.image_youtube);
        block_archive = (ImageButton) findViewById(R.id.image_archive);
        block_settings = (ImageButton) findViewById(R.id.image_settings);
        block_info = (ImageButton) findViewById(R.id.image_info);
        block_rozklad = (ImageButton) findViewById(R.id.image_rozklad);
        sitedmtc = (ImageView) findViewById(R.id.image_dmtc);
        block_archive.setOnClickListener(this);
        sitedmtc.setOnClickListener(this);
        block_info.setOnClickListener(this);
        block_rozklad.setOnClickListener(this);
        block_settings.setOnClickListener(this);
        block_instagram.setOnClickListener(this);
        block_facebook.setOnClickListener(this);
        block_youtube.setOnClickListener(this);

        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (v==block_instagram){
            inst = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dmtccollege/"));
            startActivity(inst);

        }else if(v==block_facebook){
            fb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dmtc.college.page/"));
            startActivity(fb);

        }else if(v==block_youtube){
            yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLLJ443RzJVN5JLnutKHjyw"));
            startActivity(yt);

        }else if(v==block_archive){
            fond = new Intent(MainActivity.this, ScoreActivity.class);
            startActivity(fond);

        }else if(v==block_settings){
            set = new Intent(MainActivity.this, MyPreferenceSettings.class);
            startActivity(set);

        }else if(v==block_info){
            about = new Intent(MainActivity.this, AboutCollege.class);
            startActivity(about);

        }else if(v==block_rozklad){
            rozkld = new Intent(MainActivity.this, list.class);
            startActivity(rozkld);
        }
    }

}
