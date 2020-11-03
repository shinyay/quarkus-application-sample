package com.google.shinyay.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

@Entity
data class Employee : PanacheEntity() {
}