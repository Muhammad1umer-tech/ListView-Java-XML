package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText personsearch, name;
    AppCompatButton insert,delete,update;
    ListView namelist;
    ArrayList<String>arrylist =  new ArrayList<String>();
    String item;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initcomponents();
        settingupListners1();
        settingupListners2();
        settingupListners3();
        settingupListners4();
    }


    private void settingupListners2() {
        delete.setOnClickListener(View->{
            if(arrylist.size()>0)
            {
                if(!name.getText().toString().isEmpty())
                {
                    arrylist.remove(name.getText().toString());
                    ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,arrylist);
                namelist.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "deleted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "There is no element to delete", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void settingupListners1() {
        insert.setOnClickListener(view -> {
            String n = name.getText().toString();
            arrylist.add(n);

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,arrylist);
            namelist.setAdapter(adapter);
        });
    }
    private void settingupListners3() {
        namelist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
             item = parent.getItemAtPosition(i).toString() + " selected";
             index = i;
             Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });
    }
    private void settingupListners4() {
        update.setOnClickListener(View->{
         String n = name.getText().toString();
         arrylist.set(index, n);
         ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1 ,arrylist);
         adapter.notifyDataSetChanged();
        });
    }

    private void initcomponents() {
        personsearch = findViewById(R.id.personSearch);
        name = findViewById(R.id.name);
        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        namelist=findViewById(R.id.ourlist);
    }
}