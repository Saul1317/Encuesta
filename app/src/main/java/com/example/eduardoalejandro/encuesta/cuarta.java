package com.example.eduardoalejandro.encuesta;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class cuarta extends AppCompatActivity {

    ImageButton ibtn, ibtn13, ibtn14, ibtn15;
    private TextView txt_respuesta_muy_satifecho2,txt_respuesta_satifecho2, txt_respuesta_insatisfecho2, txt_respuesta_muy_insatisfecho2;
    private String respuestaHttp;
    Vibrator rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_cuarta);

        ibtn =(ImageButton) findViewById(R.id.ibtn);
        ibtn13 =(ImageButton) findViewById(R.id.ibtn13);
        ibtn14 =(ImageButton) findViewById(R.id.ibtn14);
        ibtn15 =(ImageButton) findViewById(R.id.ibtn15);

        //Agregar
        txt_respuesta_muy_satifecho2 = (TextView) findViewById(R.id.respuesta_muy_satifecho2);
        txt_respuesta_satifecho2 = (TextView) findViewById(R.id.respuesta_satifecho2);
        txt_respuesta_insatisfecho2 = (TextView) findViewById(R.id.respuesta_insatisfecho2);
        txt_respuesta_muy_insatisfecho2 = (TextView) findViewById(R.id.respuesta_muy_insatisfecho2);

        final String txt_respuesta = txt_respuesta_muy_satifecho2.getText().toString();
        final String txt_respuesta13 = txt_respuesta_satifecho2.getText().toString();
        final String txt_respuesta14 = txt_respuesta_insatisfecho2.getText().toString();
        final String txt_respuesta15 = txt_respuesta_muy_insatisfecho2.getText().toString();

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    startActivity(i);
                }
            }
        });
        ibtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta13, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    startActivity(i);
                }
            }
        });
        ibtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta14, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    startActivity(i);
                }
            }
        });
        ibtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta15, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    startActivity(i);
                }
            }
        });

    }
}
