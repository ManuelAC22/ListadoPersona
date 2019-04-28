package com.glaxmac.appevaluacionuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayAdapter<String> adaptador;
    ListView listFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<String> listaAdapter = (ArrayList<String>) getIntent().getSerializableExtra("key");

        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaAdapter);
        listFinal= findViewById(R.id.listFinal);
        listFinal.setAdapter(adaptador);

    }
}
