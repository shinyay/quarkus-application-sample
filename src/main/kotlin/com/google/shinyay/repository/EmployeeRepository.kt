package com.google.shinyay.repository

import com.google.shinyay.entity.Employee
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository


class EmployeeRepository: PanacheRepository<Employee> {
}