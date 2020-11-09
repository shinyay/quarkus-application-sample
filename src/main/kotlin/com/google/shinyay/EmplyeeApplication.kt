package com.google.shinyay

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.core.Application

@OpenAPIDefinition(info = Info(title = "Employee API", version = "1.0.0"))
class EmployeeApplication: Application()

val Any.logger: Logger
    get() = LoggerFactory.getLogger(this.javaClass)