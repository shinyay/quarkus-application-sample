package com.google.shinyay.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

@Entity
data class Employee(var firstName: String = "",
                    var lastName: String = "",
                    var role: String = "",
                    var salary: Int = 0,
                    var organizationId: Long? = null,
                    var departmentId: Long? = null) : PanacheEntity()