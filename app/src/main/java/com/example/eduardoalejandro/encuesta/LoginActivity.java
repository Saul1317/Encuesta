package com.example.eduardoalejandro.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    /******variables para spinners*********/
    Spinner spinner_sucursal, spinner_local;

    /*******variable para boton**********/
    Button boton_ingresar;

    /******* variable para preferencias*****/
    private SharedPreferences prs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /****ejecuta identificadores *****/
        Identificadores();


        prs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);


        /****adapatador para spinner sociedad*****/

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sociedades, android.R.layout.simple_spinner_item);
        spinner_sucursal.setAdapter(adapter);
        spinner_local.setAdapter(adapter);

        boton_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_sucursal = spinner_sucursal.getSelectedItem().toString();
                String text_sociedad = spinner_local.getSelectedItem().toString();
                Toast.makeText(LoginActivity.this, text_sucursal +" "+ text_sociedad, Toast.LENGTH_SHORT).show();
                NuevaActividad();
                GuardarPreferencias(text_sociedad, text_sucursal);
            }
        });
    }

    private void GuardarPreferencias(String sociedad, String sucursal){
        SharedPreferences.Editor editor = prs.edit();
        editor.putString("sociedad", sociedad);
        editor.putString("sucursal", sucursal);
        editor.apply();
    }

    /******* metodo identificadores ********/
    private void Identificadores(){
        spinner_sucursal = (Spinner) findViewById(R.id.spinner_sucursal);
        spinner_local = (Spinner) findViewById(R.id.spinner_local);
        boton_ingresar= (Button) findViewById(R.id.boton_ingresar);
    }

    /******* metodo para mostrar actividad ********/
    private void NuevaActividad(){
        Intent i = new Intent(LoginActivity.this, Inicio.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    /******* metodo para setear sucural y sociedad ********/
    private void setPreferencias(){
        String sociedad = MetodosSharedPreference.getSociedadPref(prs);
        String sucursal = MetodosSharedPreference.getSucursalPref(prs);
    }
}
