package com.latsykroman.dmtc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class rozklad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rozklad);
        WebView webView = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();
        String resName = "n" + intent.getIntExtra("head", 0);
        Log.i("name", "resname");
        Context context = getBaseContext();
        String text = readRawTextFile(context, getResources().getIdentifier(resName, "raw", "com.latsykroman.dmtc"));
        webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null);
    }

    public static String readRawTextFile(Context context, int raw) {
        InputStream inputStream = context.getResources().openRawResource(raw);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while (( line = buffReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }
}


