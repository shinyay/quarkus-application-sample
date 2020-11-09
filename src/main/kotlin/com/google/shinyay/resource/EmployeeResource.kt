package com.google.shinyay.resource

import com.google.shinyay.entity.Employee
import com.google.shinyay.repository.EmployeeRepository
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class EmployeeResource(val repository: EmployeeRepository) {

    @GET
    fun findAll() = repository.listAll()

    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: Long): Employee? = repository.findById(id)
}