package com.latsykroman.dmtc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class list extends AppCompatActivity {


    private String array[] = {
            "ПК-41",
            "ПК-42",
            "ДЗ-41",
            "ОР-41",
            "ЕК-41"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

      ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent pc41 = new Intent(list.this, rozklad.class );
                pc41.putExtra("head", i);
                startActivity(pc41);
            }
        });
        }

            }


