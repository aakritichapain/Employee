package com.aakriti.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateDeleteActivity extends AppCompatActivity {

    EditText etEmployee,etName,etAge,etSalary;
    Button btnS,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        etEmployee=findViewById(R.id.etEmployee);
        etName=findViewById(R.id.etNameE);
        etAge=findViewById(R.id.etAge);
        etSalary=findViewById(R.id.etSalary);

        btnS=findViewById(R.id.btnS);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnUpdate=findViewById(R.id.btnUpdate);


    }
}
