package com.example.eduardoalejandro.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    private ImageButton ibtn1, ibtn2,ibtn3,ibtn4,ibtn5;
    private TextView txt_respuesta_primeraVez,txt_respuesta_diariamente, txt_respuesta_semanalmente, txt_respuesta_cada_15_dias, txt_respuesta_mensual;
    private String respuestaHttp;
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
        setContentView(R.layout.activity_inicio);




        ibtn1 =(ImageButton) findViewById(R.id.ibtn1);
        ibtn2 =(ImageButton) findViewById(R.id.ibtn2);
        ibtn3 =(ImageButton) findViewById(R.id.ibtn3);
        ibtn4 =(ImageButton) findViewById(R.id.ibtn4);
        ibtn5 =(ImageButton) findViewById(R.id.ibtn5);

        //Agregar
        txt_respuesta_primeraVez = (TextView) findViewById(R.id.primeraVez);
        txt_respuesta_diariamente = (TextView) findViewById(R.id.diariamente);
        txt_respuesta_semanalmente = (TextView) findViewById(R.id.semanalmente);
        txt_respuesta_cada_15_dias = (TextView) findViewById(R.id.quincena);
        txt_respuesta_mensual = (TextView) findViewById(R.id.mensualmente);

        final String txt_respuesta1 = txt_respuesta_primeraVez.getText().toString();
        final String txt_respuesta2 = txt_respuesta_diariamente.getText().toString();
        final String txt_respuesta3 = txt_respuesta_semanalmente.getText().toString();
        final String txt_respuesta4 = txt_respuesta_cada_15_dias.getText().toString();
        final String txt_respuesta5 = txt_respuesta_mensual.getText().toString();

        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí


        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this,segunda.class);
                startActivity(i);
            }
        });
        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rr.vibrate(50);
                respuestaHttp = httppost.post("P1", txt_respuesta1, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Inicio.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Inicio.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Inicio.this, segunda.class);
                    startActivity(i);
                }
            }
        });

        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rr.vibrate(50);
                respuestaHttp = httppost.post("P1", txt_respuesta2, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Inicio.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Inicio.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Inicio.this, segunda.class);
                    startActivity(i);
                }
            }
        });

        ibtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P1", txt_respuesta3, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Inicio.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Inicio.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Inicio.this, segunda.class);
                    startActivity(i);
                }
            }
        });
        ibtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                rr.vibrate(50);
                respuestaHttp = httppost.post("P1", txt_respuesta4, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Inicio.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Inicio.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Inicio.this, segunda.class);
                    startActivity(i);
                }

            }
        });
        ibtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P1", txt_respuesta5, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Inicio.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Inicio.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Inicio.this, segunda.class);
                    startActivity(i);
                }

            }
        });

    }
}
