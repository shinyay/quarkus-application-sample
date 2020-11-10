package com.google.shinyay.resource

import com.google.shinyay.entity.Employee
import com.google.shinyay.logger
import com.google.shinyay.repository.EmployeeRepository
import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.transaction.Transactional
import javax.ws.rs.*

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class EmployeeResource(val repository: EmployeeRepository) {

    @GET
    fun findAll() = repository.listAll()

    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: Long): Employee? = repository.findById(id)

    @POST
    @Transactional
    fun add(employee: Employee): Response {
        logger.info("ADD: $employee.toString()")
        repository.persist(employee)
        return Response.ok(employee).status(201).build()
    }

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam id: Long) {
        logger.info("DELETE: $id")
        repository.deleteById(id)
    }
}