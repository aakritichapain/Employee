package com.aakriti.employee.API;

import android.content.Context;

import com.aakriti.employee.Model.Employee;
import com.aakriti.employee.Model.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeAPI {


    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    //foeSearch
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empID);

    //forRegistration
    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);

    //update
    @PUT("update/{empID}")
    Call<Void> updateEmployee(@Path("empID") int empId,@Body EmployeeCUD emp);

    //delete
    @DELETE("delete/{empID}")
    Call<Void> deleteEmployee(@Path("empID") int empId);

}
