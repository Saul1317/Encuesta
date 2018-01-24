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

public class sexta extends AppCompatActivity {

    ImageButton ibtn21, ibtn22, ibtn23;
    private TextView txt_respuesta1,txt_respuesta2,txt_respuesta3;
    private String respuestaHttp;
    int contador;
    Vibrator rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_sexta);

        ibtn21 =(ImageButton) findViewById(R.id.ibtn21);
        ibtn22 =(ImageButton) findViewById(R.id.ibtn22);
        ibtn23 =(ImageButton) findViewById(R.id.ibtn23);

        contador = getIntent().getIntExtra("contador",0);
        Toast.makeText(sexta.this, String.valueOf(contador), Toast.LENGTH_SHORT).show();

        //Agregar
        txt_respuesta1 = (TextView) findViewById(R.id.respuesta_muy_probable);
        txt_respuesta2 = (TextView) findViewById(R.id.respuesta_probable);
        txt_respuesta3 = (TextView) findViewById(R.id.respuesta_nada_probable);

        final String txt_respuesta21 = txt_respuesta1.getText().toString();
        final String txt_respuesta22 = txt_respuesta2.getText().toString();
        final String txt_respuesta23 = txt_respuesta3.getText().toString();

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //Hasta Aquí
        ibtn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P6", txt_respuesta21, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(sexta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(sexta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sexta.this,Final.class);
                    startActivity(i);
                }
            }
        });
        ibtn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P6", txt_respuesta21, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(sexta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(sexta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sexta.this,Final.class);
                    startActivity(i);
                }
            }
        });
        ibtn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P6", txt_respuesta22, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(sexta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(sexta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sexta.this,Final.class);
                    startActivity(i);
                }
            }
        });
        ibtn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rr.vibrate(50);
                respuestaHttp = httppost.post("P6", txt_respuesta23, "Matriz", "Movil", "-");

                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(sexta.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    if (contador==2){
                        Intent i = new Intent(sexta.this,SecretActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(sexta.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(sexta.this,Final.class);
                        i.putExtra("contador",contador+1);
                        startActivity(i);
                    }
                }
            }
        });
    }
}
