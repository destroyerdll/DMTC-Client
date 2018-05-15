package com.latsykroman.dmtc;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        sendNotification(remoteMessage.getNotification().getBody());

    }
    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, MainActivity.class );
        Intent ilist = new Intent(this, list.class );
        Intent isettings = new Intent(this, MyPreferenceSettings.class );
        Intent iscore = new Intent(this, ScoreActivity.class );
        Intent irozklad = new Intent(this, rozklad.class );
        Intent iaboutcollege = new Intent(this, AboutCollege.class );
        Intent iauth = new Intent(this, AutActivity.class );
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ilist.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        isettings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        iscore.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        irozklad.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        iaboutcollege.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        iauth.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher))
                .setContentTitle(this.getString(R.string.app_name))
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }
}

