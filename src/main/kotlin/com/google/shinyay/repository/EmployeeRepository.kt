package com.google.shinyay.repository

import com.google.shinyay.entity.Employee
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class EmployeeRepository: PanacheRepository<Employee> {

    fun findByFirstNameAndLastName(firstName: String, lastName: String) =
            list("firstName = ?1 and lastName = ?2", firstName, lastName)

    fun findBySalary(salary: Int) = list("salary", salary)

    fun findBySalaryGreaterThan(salary: Int) = list("salary > ?1", salary)
}