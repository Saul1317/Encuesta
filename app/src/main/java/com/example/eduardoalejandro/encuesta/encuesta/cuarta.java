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

public class cuarta extends AppCompatActivity {

    ImageButton ibtn, ibtn13, ibtn14, ibtn15;
    private TextView txt_respuesta_muy_satifecho2,txt_respuesta_satifecho2, txt_respuesta_insatisfecho2, txt_respuesta_muy_insatisfecho2;
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
        setContentView(R.layout.activity_cuarta);

        ibtn =(ImageButton) findViewById(R.id.ibtn);
        ibtn13 =(ImageButton) findViewById(R.id.ibtn13);
        ibtn14 =(ImageButton) findViewById(R.id.ibtn14);
        ibtn15 =(ImageButton) findViewById(R.id.ibtn15);

        //Toma los datos pasados por la instancia
        contador = getIntent().getIntExtra("contador",0);
        //Agregar
        txt_respuesta_muy_satifecho2 = (TextView) findViewById(R.id.respuesta_muy_satifecho2);
        txt_respuesta_satifecho2 = (TextView) findViewById(R.id.respuesta_satifecho2);
        txt_respuesta_insatisfecho2 = (TextView) findViewById(R.id.respuesta_insatisfecho2);
        txt_respuesta_muy_insatisfecho2 = (TextView) findViewById(R.id.respuesta_muy_insatisfecho2);

        final String txt_respuesta = txt_respuesta_muy_satifecho2.getText().toString();
        final String txt_respuesta13 = txt_respuesta_satifecho2.getText().toString();
        final String txt_respuesta14 = txt_respuesta_insatisfecho2.getText().toString();
        final String txt_respuesta15 = txt_respuesta_muy_insatisfecho2.getText().toString();

        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí

        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta13, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta14, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(cuarta.this,quinta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });

        //Boton Negativo
        ibtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P4", txt_respuesta15, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(cuarta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                        Toast.makeText(cuarta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(cuarta.this,quinta.class);
                        i.putExtra("contador",contador+1);
                        startActivity(i);
                    }
            }
        });

    }
}
