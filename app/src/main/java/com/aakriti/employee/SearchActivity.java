package com.aakriti.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {
    EditText etNameE;
    Button btnSearch;
    ListView lstEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etNameE=findViewById(R.id.etNameE);
        btnSearch=findViewById(R.id.btnSearch);
        lstEmployee=findViewById(R.id.lstEmployee);


    }
}
