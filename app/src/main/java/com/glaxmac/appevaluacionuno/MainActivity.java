package com.glaxmac.appevaluacionuno;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar,btnListar,btnEstilos;
    EditText txtNombre;
    TextView txtIngreso;

    ListView lstView;

    private ArrayList<String> datosPersona;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datosPersona = new ArrayList<String>();

        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosPersona);
        lstView= findViewById(R.id.lstView);
        lstView.setAdapter(adaptador);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnListar = findViewById(R.id.btnListar);
        btnEstilos = findViewById(R.id.btnEstilos);

        txtNombre = findViewById(R.id.txtNombre);

        txtIngreso = findViewById(R.id.txtIngreso);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datosPersona.add(txtNombre.getText().toString());
                adaptador.notifyDataSetChanged();
                txtNombre.setText("");
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                i.putExtra("key", datosPersona);
                startActivity(i);
                finish();
            }
        });

        btnEstilos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAgregar.setBackgroundColor(Color.RED);
                btnAgregar.setTextColor(Color.WHITE);
                btnListar.setBackgroundColor(Color.RED);
                btnListar.setTextColor(Color.WHITE);
                btnEstilos.setBackgroundColor(Color.RED);
                btnEstilos.setTextColor(Color.WHITE);
                txtIngreso.setTextColor(Color.RED);
            }
        });

    }
}
