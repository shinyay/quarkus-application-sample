package com.google.shinyay.repository

import com.google.shinyay.entity.Employee
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class EmployeeRepository: PanacheRepository<Employee> {
}