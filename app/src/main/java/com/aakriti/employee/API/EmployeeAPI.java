package com.aakriti.employee.API;

import android.content.Context;

import com.aakriti.employee.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {


    @GET("employees")
    Call<List<Employee>> getAllEmployees();

}
