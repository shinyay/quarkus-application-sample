import com.google.shinyay.entity.Employee
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

@QuarkusTest
class EmployeeResourceTest {

    @Test
    fun testGetAll() {
        given().get("/employees")
                .then()
                .statusCode(200)
    }

    @Test
    fun testAddEmployee() {
        val employee = Employee(
                firstName = "Alice",
                lastName = "Liddel",
                role = "Developer",
                salary = 10000
        )
        given().body(employee).contentType(ContentType.JSON)
                .post("/employees")
                .then()
                .statusCode(201)
    }
}