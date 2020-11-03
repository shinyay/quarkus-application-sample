package com.google.shinyay.resource

import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
class EmployeeResource {
}