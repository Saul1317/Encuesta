package com.example.eduardoalejandro.encuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Spinner spinner_sucursal, spinner_local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spinner_sucursal = (Spinner) findViewById(R.id.spinner_sucursal);
        spinner_local = (Spinner) findViewById(R.id.spinner_local);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_sucursal, android.R.layout.simple_spinner_item);
        spinner_sucursal.setAdapter(adapter);
        spinner_local.setAdapter(adapter);

        spinner_sucursal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spinner_sucursal.getSelectedItem().toString();
                Toast.makeText(LoginActivity.this, text , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_local.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spinner_sucursal.getSelectedItem().toString();
                Toast.makeText(LoginActivity.this, text , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
