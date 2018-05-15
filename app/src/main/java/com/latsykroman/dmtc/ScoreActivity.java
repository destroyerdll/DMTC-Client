package com.latsykroman.dmtc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class ScoreActivity extends AppCompatActivity {
    private String list[] = {
            "Журнали",
            "Навчально-методичні матеріали",
            "Заміни",
    };
    ListView list_disk;
    Intent lekciya;
    Intent zhurnal;
    Intent zamina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        list_disk = (ListView) findViewById(R.id.list_disk);
        list_disk.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));


        list_disk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  if(position==0){
                      lekciya = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/spreadsheets/d/1R1ckPB7XjjlV-TyrJSnoY41o5ajwM3NUUILgmFp13uQ/edit?usp=sharing"));
                      startActivity(lekciya);
                  }else if(position==1){
                      zhurnal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/folders/0B14gVz7TfFh0fmNwZno2YlJ6MjhZTzZTU05LRG8taHVDSkNQcElBVHpLVUx5am9YUmVSRHM"));
                      startActivity(zhurnal);
                  }else if(position==2){
                      zamina = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1qK01OmXENOORmuGfSX1WdRpbDGTDiH1mniB7qmTKAqQ/edit?usp=sharing"));
                      startActivity(zamina);

                  }
            }
        });
    }

}
