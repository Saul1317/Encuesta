package com.example.eduardoalejandro.encuesta.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardoalejandro.encuesta.R;

public class quinta extends AppCompatActivity {

    ImageButton ibtn16, ibtn17, ibtn18, ibtn19, ibtn20;
    private TextView txt_respuesta1,txt_respuesta2,txt_respuesta3,txt_respuesta4,txt_respuesta5;
    private String respuestaHttp;
    int contador;
    Vibrator rr;

    /******* variable para preferencias*****/
    private SharedPreferences prs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_quinta);

        ibtn16 =(ImageButton) findViewById(R.id.ibtn16);
        ibtn17 =(ImageButton) findViewById(R.id.ibtn17);
        ibtn18 =(ImageButton) findViewById(R.id.ibtn18);
        ibtn19 =(ImageButton) findViewById(R.id.ibtn19);
        ibtn20 =(ImageButton) findViewById(R.id.ibtn20);

        contador = getIntent().getIntExtra("contador",0);
        //Agregar
        txt_respuesta1 = (TextView) findViewById(R.id.respuesta_mucho_mejor);
        txt_respuesta2 = (TextView) findViewById(R.id.respuesta_mejor);
        txt_respuesta3 = (TextView) findViewById(R.id.respuesta_igual);
        txt_respuesta4 = (TextView) findViewById(R.id.respuesta_peor);
        txt_respuesta5 = (TextView) findViewById(R.id.respuesta_no_lo_se);

        final String txt_respuesta16 = txt_respuesta1.getText().toString();
        final String txt_respuesta17 = txt_respuesta2.getText().toString();
        final String txt_respuesta18 = txt_respuesta3.getText().toString();
        final String txt_respuesta19 = txt_respuesta4.getText().toString();
        final String txt_respuesta20 = txt_respuesta5.getText().toString();

        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí

        ibtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P5", txt_respuesta16, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(quinta.this,sexta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P5", txt_respuesta17, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(quinta.this,sexta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P5", txt_respuesta18, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(quinta.this,sexta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                respuestaHttp = httppost.post("P5", txt_respuesta19, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                        Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(quinta.this,sexta.class);
                        i.putExtra("contador",contador+1);
                        startActivity(i);
                }
            }
        });
        ibtn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P5", txt_respuesta20, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(quinta.this,sexta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P5", txt_respuesta16, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(quinta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(quinta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(quinta.this,sexta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
    }
}
