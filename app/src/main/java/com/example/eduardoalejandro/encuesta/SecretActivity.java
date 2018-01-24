package com.example.eduardoalejandro.encuesta;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecretActivity extends AppCompatActivity {

    Button botonEnviar;
    EditText editTxtTelefono;
    private String respuestaHttp;
    Vibrator rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_secret);

        botonEnviar = (Button) findViewById(R.id.boton_ingresar);
        editTxtTelefono= (EditText) findViewById(R.id.edittxt_telefono);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //metodo boton

    }
}
