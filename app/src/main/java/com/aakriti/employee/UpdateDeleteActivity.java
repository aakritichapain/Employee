package com.aakriti.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aakriti.employee.API.EmployeeAPI;
import com.aakriti.employee.Model.Employee;
import com.aakriti.employee.Model.EmployeeCUD;
import com.aakriti.employee.url.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDeleteActivity extends AppCompatActivity {

    EditText  etEName, etEAge, etESalary, etEmployee;
    Button btnS, btnUpdate, btnDelete;
    Retrofit retrofitt;
    EmployeeAPI employeeAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);


        etEName = findViewById(R.id.etEName);
        etEAge = findViewById(R.id.etEAge);
        etESalary = findViewById(R.id.etESalary);
        etEmployee = findViewById(R.id.etEmployee);

        btnS = findViewById(R.id.btnS);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployee();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEmployee();
            }
        });

    }

    /*private void CreateInstance() {
        retrofitt  = new Retrofit.Builder()
                .baseUrl(URL.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        employeeAPI = retrofitt.create(EmployeeAPI.class);

    }*/


    private void loadData() {
        EmployeeAPI employeeAPI = URL.CreateInstance().create(EmployeeAPI.class);
       // CreateInstance();
        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(etEmployee.getText().toString()));


        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                etEName.setText(response.body().getEmployee_name());
                etEAge.setText(Integer.toString(response.body().getEmployee_age()));
                etESalary.setText(response.body().getEmployee_salary());
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(UpdateDeleteActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateEmployee(){
        EmployeeAPI employeeAPI = URL.CreateInstance().create(EmployeeAPI.class);
        EmployeeCUD employeeCUD = new EmployeeCUD(
                etEName.getText().toString(),
               Integer.parseInt( etESalary.getText().toString()),
               Integer.parseInt(etEAge.getText().toString())

                );
        Call<Void> voidCall = employeeAPI.updateEmployee(Integer.parseInt(etEmployee.getText().toString()),employeeCUD);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateDeleteActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateDeleteActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void deleteEmployee(){
        EmployeeAPI employeeAPI = URL.CreateInstance().create(EmployeeAPI.class);
        Call<Void> voidCall = employeeAPI.deleteEmployee(Integer.parseInt(etEmployee.getText().toString()));

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateDeleteActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateDeleteActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
