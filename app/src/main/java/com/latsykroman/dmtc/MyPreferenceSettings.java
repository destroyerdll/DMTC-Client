package com.latsykroman.dmtc;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.content.ContextCompat;
import android.text.style.BackgroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;


/**
 * Created by Latsyk Roman on 08.10.2017.
 */

public class MyPreferenceSettings extends PreferenceActivity {
    Intent close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }


    @Override
    protected void onResume() {
        super.onResume();
        PreferenceScreen exit = (PreferenceScreen) findPreference("exit");
        PreferenceScreen about = (PreferenceScreen) findPreference("about");

        exit.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                close = new Intent(MyPreferenceSettings.this, MainActivity.class);
                close.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                close.putExtra("EXIT", true);
                startActivity(close);
                return false;
            }
        });

        about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(MyPreferenceSettings.this, "Клієнт ДМТК (початкова стадія розробки). " +
                        "Розробник: Лацик Роман", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        NotificationManager notificationManager = (NotificationManager)
                getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        Boolean opennotif = prefs.getBoolean(getString(R.string.opentotification), true);
        if (opennotif) {
            Toast.makeText(getApplicationContext(), "Включено", Toast.LENGTH_SHORT).show();
            notificationManager.cancelAll();
        }

        if (!opennotif){
            Toast.makeText(getApplicationContext(), "Виключено", Toast.LENGTH_SHORT).show();
            notificationManager.cancelAll();
        }
        }

}
