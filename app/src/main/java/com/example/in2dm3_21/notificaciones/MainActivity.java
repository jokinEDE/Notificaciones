package com.example.in2dm3_21.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFin(View view) {

        if (view.getId() == R.id.botonFin) {
            //Paso 1: Conseguir NotificationManager, quiero el Notification_Service
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            //Paso 2: Crear notificacion
            int icono = R.drawable.icono;
            CharSequence text = "Notification ticker text";
            long when = System.currentTimeMillis();

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

            builder.setSmallIcon(icono);
            builder.setTicker(text);
            builder.setWhen(when);

            Intent intencion = new Intent(this, NotificacionActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intencion, 0);

            builder.setContentTitle("Notificacion Titulo");
            builder.setContentText("Notificacion Texto");
            builder.setContentIntent(contentIntent);
            builder.setAutoCancel(true); //Para que cuando seleccionamos la notificacion  desaparezca

            builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
            builder.setDefaults(NotificationCompat.DEFAULT_SOUND);


            Notification notif = builder.build(); // Construir notificacion y guardarla en variable

            final int HELLO_ID = 1;
            mNotificationManager.notify(HELLO_ID, notif);
            finish();

        }
        if(view.getId() == R.id.botonFin2){

            NotificationManager mNotificacionManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            int icono = R.drawable.icono;
            String texto = "Notification ticker text";
            long when = System.currentTimeMillis();

            Notification.Builder builder = new Notification.Builder(getApplicationContext());

            builder.setSmallIcon(icono);
            builder.setTicker(texto);
            builder.setWhen(when);

            RemoteViews contentView = new RemoteViews(getPackageName(),R.layout.layout_prueba);
            contentView.setImageViewResource(R.id.imageNotif,R.drawable.icono);
            contentView.setTextViewText(R.id.textNotif, "Personalizada");
            contentView.setTextViewText(R.id.titleNotif,"Texto personalizado");

            builder.setAutoCancel(true);
            Intent intencion = new Intent(this,NotificacionActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this,0,intencion,0);
            builder.setContentIntent(contentIntent);

            Notification notif;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                builder.setCustomContentView(contentView);
                notif = builder.build();
            }else{
                notif = builder.build();
                notif.contentView = contentView;
            }

            final int HELLO_ID = 2;

            mNotificacionManager.notify(HELLO_ID,notif);
            finish();
        }

    }
}
