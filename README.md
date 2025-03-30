# Worklog Service

## Description
The Worklog Service is a Java-based application designed to manage and track work logs for projects. It provides APIs to create, read, update, and delete work logs, enabling efficient project management and time tracking.

## Features
- Create new work logs
- Retrieve existing work logs
- Update work logs
- Delete work logs
- Search work logs by various criteria

## Technology Stack
- Java
- Spring Boot
- Hibernate
- MySQL
- Maven

## Installation

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- MySQL

### Steps
1. Clone the repository:
    ```sh
    git clone https://github.com/sethiyasanskar63/worklog-service.git
    ```
2. Navigate to the project directory:
    ```sh
    cd worklog-service
    ```
3. Configure the MySQL database:
    - Create a new database named `worklog_service`.
    - Update the database configuration in `src/main/resources/application.properties`.

4. Build the project:
    ```sh
    mvn clean install
    ```

5. Run the application:
    ```sh
    mvn spring-boot:run
    ```

## Usage
Once the application is running, you can access the APIs at `http://localhost:8080/api/worklogs`.

### API Endpoints
- `GET /api/worklogs` - Retrieve all work logs
- `GET /api/worklogs/{id}` - Retrieve a work log by ID
- `POST /api/worklogs` - Create a new work log
- `PUT /api/worklogs/{id}` - Update a work log by ID
- `DELETE /api/worklogs/{id}` - Delete a work log by ID

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or questions, please contact Sanskar Sethiya at [your-email@example.com].
