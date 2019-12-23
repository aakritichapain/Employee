package com.aakriti.employee;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aakriti.employee.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class EmployeeAdaptar extends RecyclerView.Adapter<EmployeeAdaptar.EmployeeViewHolder>
{

    private List<Employee>employeeList;

    public EmployeeAdaptar(List<Employee>employeeList){
        this.employeeList=employeeList;


    }



    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_employee_details,parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.tvid.setText(Integer.toString(employee.getId()));
        holder.tvname.setText(employee.getEmployee_name());
        holder.tvage.setText(Integer.toString(employee.getEmployee_age()));
        holder.tvsalary.setText(employee.getEmployee_salary().toString());
        holder.tvprofile.setText(employee.getProfile_image());
    }

    @Override
    public int getItemCount() {
        return employeeList.size()  ;
    }


    public class EmployeeViewHolder extends RecyclerView.ViewHolder{
        TextView tvid,tvname,tvage,tvsalary,tvprofile;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvid=itemView.findViewById(R.id.tvId);
            tvname=itemView.findViewById(R.id.tvName);
            tvage=itemView.findViewById(R.id.tvAge);
            tvsalary=itemView.findViewById(R.id.tvSalary);
            tvprofile=itemView.findViewById(R.id.tvProfile);

        }

    }

}
