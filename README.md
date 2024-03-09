# Employee Management System

This is a simple Employee Management System built with Spring Boot. It provides CRUD (Create, Read, Update, Delete) operations for managing employees.

## Features

- **Create**: Add a new employee to the system.
- **Read**: Retrieve information about all employees or a specific employee.
- **Update**: Update information of an existing employee.
- **Delete**: Remove an employee from the system.


## Technologies Used

- Java
- Spring Boot
- MySQL
- RESTful APIs

## Getting Started

To run the application locally, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Akshat53/employee-management-system-backend.git

2. **Navigate to the project directory:**
    
    cd employee-management

3. **Build the application:**

    ./mvnw clean package

4. **Start the application:**

    java -jar target/employee-management-0.0.1-SNAPSHOT.jar
    
    **Note: Make sure you have MySQL running and configured correctly.**

5. **Access the application:**

    The application will be accessible at http://localhost:8080.

    **Default username and password for basic authentication are:**

        Username: admin
        Password: admin

## Usage

**Create a new employee:**

    POST http://localhost:8080/api/employees

 **Create Employee API Example**

To create a new employee, send a POST request to the `/api/employees` endpoint with the following JSON data:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "mobileNumber": "1234567890",
  "gender": "Male",
  "companyName": "ABC Corp"
}
```

**List all employees:**
    GET http://localhost:8080/api/employees

**Get an employee by ID:**
    GET http://localhost:8080/api/employees/{id}


**Update an employee:**
    PUT http://localhost:8080/api/employees/{id}

**Delete an employee:**
    DELETE http://localhost:8080/api/employees/{id}

**Get an employee:**
    GET http://localhost:8080/api/employees/department{department}

**Get an employee by role:**
    GET http://localhost:8080/api/employees/role/{role}


## Contributing

Feel free to contribute to this project by forking the repository and submitting a pull request. Any contributions are welcome!

## License

This project is licensed under the MIT License - see the LICENSE file for details.



