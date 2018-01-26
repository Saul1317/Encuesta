package com.example.eduardoalejandro.encuesta.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.eduardoalejandro.encuesta.R;

public class SecretActivity extends AppCompatActivity {

    private ImageButton botonEnviar;
    EditText editTxtTelefono;
    private String respuestaHttp;
    private SharedPreferences prs;
    Vibrator rr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        StrictMode.enableDefaults();
        setContentView(R.layout.activity_secret);

        botonEnviar = (ImageButton) findViewById(R.id.ibtntel);
        editTxtTelefono= (EditText) findViewById(R.id.edittxt_telefono);

        final Httppost httppost = new Httppost();
        rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        //metodo boton
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rr.vibrate(50);
                respuestaHttp = httppost.Telefono(editTxtTelefono.getText().toString(),MetodosSharedPreference.getSucursalPref(prs));
                if (respuestaHttp.equals("ERROR")){
                    Toast.makeText(SecretActivity.this, "Error al mandar los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecretActivity.this, "Se envio correctamente la respuesta", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SecretActivity.this, Final.class);
                    startActivity(i);
                }
            }
        });
    }
}
