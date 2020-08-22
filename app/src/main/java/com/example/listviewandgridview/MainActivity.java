package com.example.listviewandgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        listView = (ListView) findViewById(R.id.listView);

        names = new ArrayList<String>();
        names.add("Kratos");
        names.add("Drake");
        names.add("Joel");
        names.add("Aloy");
        names.add("Ellie");
        names.add("Spiderman");

        //adaptador, como se muestran los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        //enlazar adaptador con listview
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Toast.makeText(MainActivity.this, "Tocaste a " + names.get(posicion), Toast.LENGTH_SHORT).show();

            }
        });


        //enlazamos con adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);
    }
}

