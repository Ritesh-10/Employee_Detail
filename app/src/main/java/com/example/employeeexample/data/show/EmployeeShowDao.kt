package com.example.employeeexample.data.show

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.employeeexample.data.Employee

interface EmployeeShowDao {
    @Query("SELECT * FROM employee WHERE `id` = :id")
    fun getEmployee(id: Long): LiveData<Employee>
}