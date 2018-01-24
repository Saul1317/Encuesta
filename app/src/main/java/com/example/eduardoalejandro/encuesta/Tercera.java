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

public class Tercera extends AppCompatActivity {

    ImageButton ibtn9, ibtn10, ibtn11, ibtn12;
    int contador;
    private TextView txt_respuesta_muy_satifecho,txt_respuesta_satifecho, txt_respuesta_insatisfecho, txt_respuesta_muy_insatisfecho;
    private String respuestaHttp;
    Vibrator rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_tercera);

        //Toma los datos pasados por la instancia
        contador = getIntent().getIntExtra("contador",0);
        Toast.makeText(Tercera.this, String.valueOf(contador), Toast.LENGTH_SHORT).show();

        ibtn9 =(ImageButton) findViewById(R.id.ibtn9);
        ibtn10 =(ImageButton) findViewById(R.id.ibtn10);
        ibtn11 =(ImageButton) findViewById(R.id.ibtn11);
        ibtn12 =(ImageButton) findViewById(R.id.ibtn12);

        //Agregar
        txt_respuesta_muy_satifecho = (TextView) findViewById(R.id.respuesta_muy_satifecho);
        txt_respuesta_satifecho = (TextView) findViewById(R.id.respuesta_satifecho);
        txt_respuesta_insatisfecho = (TextView) findViewById(R.id.respuesta_insatisfecho);
        txt_respuesta_muy_insatisfecho = (TextView) findViewById(R.id.respuesta_muy_insatisfecho);

        final String txt_respuesta9 = txt_respuesta_muy_satifecho.getText().toString();
        final String txt_respuesta10 = txt_respuesta_satifecho.getText().toString();
        final String txt_respuesta11 = txt_respuesta_insatisfecho.getText().toString();
        final String txt_respuesta12 = txt_respuesta_muy_insatisfecho.getText().toString();

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Hasta Aquí

        ibtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rr.vibrate(50);
                respuestaHttp = httppost.post("P3", txt_respuesta9, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Tercera.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Tercera.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Tercera.this,cuarta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P3", txt_respuesta10, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Tercera.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Tercera.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Tercera.this,cuarta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P3", txt_respuesta11, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Tercera.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Tercera.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Tercera.this,cuarta.class);
                    i.putExtra("contador",contador);
                    startActivity(i);
                }
            }
        });
        ibtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Boton negativo
                rr.vibrate(50);
                respuestaHttp = httppost.post("P3", txt_respuesta12, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(Tercera.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    if (contador==2){
                        Intent i = new Intent(Tercera.this,SecretActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(Tercera.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Tercera.this,cuarta.class);
                        i.putExtra("contador",contador+1);
                        startActivity(i);
                    }
                }
            }
        });




    }
}
