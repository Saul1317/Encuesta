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

public class segunda extends AppCompatActivity {

    ImageButton ibtn6, ibtn7, ibtn8;
    private TextView txt_respuesta_Si,txt_respuesta_No, txt_respuesta_Parcial;
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
        setContentView(R.layout.activity_segunda);

        ibtn6 =(ImageButton) findViewById(R.id.ibtn6);
        ibtn7 =(ImageButton) findViewById(R.id.ibtn7);
        ibtn8 =(ImageButton) findViewById(R.id.ibtn8);

        //Agregar
        txt_respuesta_Si = (TextView) findViewById(R.id.respuesta_Si);
        txt_respuesta_No = (TextView) findViewById(R.id.respuesta_No);
        txt_respuesta_Parcial = (TextView) findViewById(R.id.respuesta_Parcial);

        final String txt_respuesta6 = txt_respuesta_Si.getText().toString();
        final String txt_respuesta7 = txt_respuesta_No.getText().toString();
        final String txt_respuesta8 = txt_respuesta_Parcial.getText().toString();

        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí

        ibtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P2", txt_respuesta6, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(segunda.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(segunda.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(segunda.this,Tercera.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rr.vibrate(50);
                respuestaHttp = httppost.post("P2", txt_respuesta7, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(segunda.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                        Toast.makeText(segunda.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(segunda.this,Tercera.class);
                        i.putExtra("contador",contador+1);
                        startActivity(i);
                }
            }
        });
        ibtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rr.vibrate(50);
                respuestaHttp = httppost.post("P2", txt_respuesta8, MetodosSharedPreference.getSucursalPref(prs), "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(segunda.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(segunda.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(segunda.this,Tercera.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });

    }
}
