package com.example.in2dm3_21.notificaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        Toast.makeText(this,"Recibido",Toast.LENGTH_SHORT).show();



    }
}
