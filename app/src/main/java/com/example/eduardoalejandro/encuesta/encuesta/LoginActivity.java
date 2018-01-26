package com.example.eduardoalejandro.encuesta.encuesta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.eduardoalejandro.encuesta.R;

public class LoginActivity extends AppCompatActivity {



    String text_sucursal,text_sociedad;

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


        /*****adapatador para spinner sociedad*****/
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sociedades, android.R.layout.simple_spinner_item);

        /*****adapatadores por sucursal*****/
       final ArrayAdapter<CharSequence> adapter_arandas = ArrayAdapter.createFromResource(this, R.array.sucursales_arandas, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_autlan = ArrayAdapter.createFromResource(this, R.array.sucursales_autlan, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_ayotlan = ArrayAdapter.createFromResource(this, R.array.sucursales_ayotlan, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_bajio = ArrayAdapter.createFromResource(this, R.array.sucursales_bajio, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_dao = ArrayAdapter.createFromResource(this, R.array.sucursales_dao, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_gao = ArrayAdapter.createFromResource(this, R.array.sucursales_gao, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_ixtapa = ArrayAdapter.createFromResource(this, R.array.sucursales_ixtapa, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_la_cienega = ArrayAdapter.createFromResource(this, R.array.sucursales_lacienega, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_laminas = ArrayAdapter.createFromResource(this, R.array.sucursales_laminas_del_norte, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_los_altos = ArrayAdapter.createFromResource(this, R.array.sucursales_los_altos, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_mucha = ArrayAdapter.createFromResource(this, R.array.sucursales_mucha_lamina, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_pega = ArrayAdapter.createFromResource(this, R.array.sucursales_pega, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_SAABSA = ArrayAdapter.createFromResource(this, R.array.sucursales_saabsa, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_tepa = ArrayAdapter.createFromResource(this, R.array.sucursales_tepa, android.R.layout.simple_spinner_item);
       final ArrayAdapter<CharSequence> adapter_tijuna = ArrayAdapter.createFromResource(this, R.array.sucursales_tijuana, android.R.layout.simple_spinner_item);

       spinner_local.setAdapter(adapter);

        spinner_local.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinner_local.getSelectedItemPosition()==0){

                    spinner_sucursal.setAdapter(adapter_arandas);

                }
                else if(spinner_local.getSelectedItemPosition()==1){

                    spinner_sucursal.setAdapter(adapter_autlan);
                }
                else if(spinner_local.getSelectedItemPosition()==2){

                    spinner_sucursal.setAdapter(adapter_ayotlan);
                }
                else if(spinner_local.getSelectedItemPosition()==3){

                    spinner_sucursal.setAdapter(adapter_bajio);
                }
                else if(spinner_local.getSelectedItemPosition()==4){

                    spinner_sucursal.setAdapter(adapter_dao);
                }
                else if(spinner_local.getSelectedItemPosition()==5){

                    spinner_sucursal.setAdapter(adapter_gao);
                }
                else if(spinner_local.getSelectedItemPosition()==6){

                    spinner_sucursal.setAdapter(adapter_ixtapa);
                }

                else if(spinner_local.getSelectedItemPosition()==7){

                    spinner_sucursal.setAdapter(adapter_la_cienega);
                }
                else if(spinner_local.getSelectedItemPosition()==8){

                    spinner_sucursal.setAdapter(adapter_laminas);
                }
                else if(spinner_local.getSelectedItemPosition()==9){

                    spinner_sucursal.setAdapter(adapter_los_altos);
                }
                else if(spinner_local.getSelectedItemPosition()==10){

                    spinner_sucursal.setAdapter(adapter_mucha);
                }
                else if(spinner_local.getSelectedItemPosition()==11){

                    spinner_sucursal.setAdapter(adapter_pega);
                }
                else if(spinner_local.getSelectedItemPosition()==12){

                    spinner_sucursal.setAdapter(adapter_SAABSA);
                }
                else if(spinner_local.getSelectedItemPosition()==13){

                    spinner_sucursal.setAdapter(adapter_tepa);
                }
                else {
                    spinner_sucursal.setAdapter(adapter_tijuna);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });











        boton_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_sucursal = spinner_sucursal.getSelectedItem().toString();
                text_sociedad = spinner_local.getSelectedItem().toString();
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
