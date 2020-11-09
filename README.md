# Quarkus Sample Application with Database

Quarkus Sample Application with Database Integration.
This application also implements the following features.

- REST Endpoints
- Integration with Database (H2)
- Swagger Documentation
- Health check
- Basic metrics
- Unit Test

## Description
### Dependencies
- quarkus-kotlin
- quarkus-resteasy-jackson
- quarkus-jdbc-h2
- quarkus-jdbc-postgresql
- quarkus-hibernate-orm-panache-kotlin
- quarkus-smallrye-openapi
- quarkus-smallrye-health
- quarkus-smallrye-metrics
- quarkus-container-image-jib"
- quarkus-kubernetes
- quarkus-kubernetes-config

### Entity with Panache
Entity class extends `PanacheEntity` which has already defined *ID*.
Therefore, you don't have to define id field at your entity class.

```kotlin
@Entity
data class Employee(var firstName: String = "",
                    var salary: Int = 0,
                    var organizationId: Int? = null): PanacheEntity()
```

#### Custom ID Entity
Entity class should extend `PanacheEntityBase` when you want to implement your own ID.

```kotlin
@Entity
data class Employee(@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    var id: Integer)
```

### Repository with Panache
Repository class extends `PanacheRepository` to use PanacheEntity class

```kotlin
@ApplicationScoped
class EmployeeRepository: PanacheRepository<Employee> {
}
```

#### Repository for Custom ID Entity
Repository class should extend `PanacheRepositoryBase` when you deal with Custom ID entity which extends `PanacheEntityBase`

```kotlin
@ApplicationScoped
class EmployeeRepository: PanacheRepositoryBase<Employee, Integer> {
}
```

### Resource for JAX-RS
Resource classes are annotated with @Path or a request method designator, such as @GET, @PUT, @POST, or @DELETE.

```kotlin
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class EmployeeResource { }
```

#### HTTP Endpoint
You can use JAX-RS annotation to specify HTTP Method

```kotlin
@GET
fun findAll() = repository.listAll()
```

You can use `import org.jboss.resteasy.annotations.jaxrs.PathParam` instead of JAX-RS.
RESTEasy annotation makes you to specify value parameter without parameter for annotation.

- RESTEasy annotation
```kotlin
    @GET
    @Path("/{id}")
    fun findById(@PathParam id: Long): Employee? = repository.findById(id)
```

- JAX-RS annotation
```kotlin
    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: Long): Employee? = repository.findById(id)
```


## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
