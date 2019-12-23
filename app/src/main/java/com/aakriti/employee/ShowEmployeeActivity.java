package com.aakriti.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.aakriti.employee.API.EmployeeAPI;
import com.aakriti.employee.Model.Employee;
import com.aakriti.employee.url.URL;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowEmployeeActivity extends AppCompatActivity {
    //TextView tvOutput;
    private  EmployeeAdaptar employeeAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        //tvOutput= findViewById(R.id.tvOutput);


        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(URL.base_url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        Call<List<Employee>> listCall = employeeAPI.getAllEmployees();

        //Asynchronous call
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ShowEmployeeActivity.this, "Error code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                LoadDataList(response.body());

               /* List<Employee> employeeList = response.body();

                for (Employee emp : employeeList){
                    String data= "";
                    data += "Name is :" + emp.getEmployee_name() + "\n";
                    data += "Salary is :" + emp.getEmployee_salary() + "\n";
                    data +="----------------------" + "\n";

                    tvOutput.append(data);
                }*/

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("Message", "onFailure: " + t.getLocalizedMessage());
               // Toast.makeText(ShowEmployeeActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    //get refrence to the retrieved data as a list
    private void LoadDataList(List<Employee>employeeList){
        recyclerView=findViewById(R.id.recylerView);
        employeeAdapter=new EmployeeAdaptar(employeeList);


        //using a linear layout manager
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(ShowEmployeeActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        //set adapter to the recyclerview
        recyclerView.setAdapter(employeeAdapter);
    }
}
