**Introduction**

This documentation provides a step-by-step guide for setting up and running the Spring Boot-based Location Selection project.
It covers prerequisites, environment setup, required tools, project structure, and how to run the application.

**Requirements**
- Java JDK 17 or higher
- Apache Maven 3.8+
- Spring Boot 3.x
- Apache NetBeans IDE 12.5 (for full Java support)
- Visual Studio Code (for frontend or hybrid development)
- MySQL Server & MySQL Workbench 8.0 CE
- Web browser (Chrome, Firefox, Edge)

**Setup & Installation Steps**
1. Download and Install Java JDK:
 https://www.oracle.com/java/technologies/javase-jdk17-downloads.html
2. Install Apache Maven:
 https://maven.apache.org/download.cgi
 Commands:
 - Check Java: java -version
 - Check Maven: mvn -v
3. Install MySQL Workbench & Server 8.0:
 https://dev.mysql.com/downloads/workbench/
4. Create Database in MySQL Workbench:
 CREATE DATABASE location_app;
5. Import the tables with updated schema (country_name, state_name, etc.).
6. Open NetBeans IDE 12.5 or Visual Studio Code.
7. Clone or create the project with the following structure:
 - Entities: Country, State, District, City, Pincode, LocationSelection
 - Repositories: JpaRepository interfaces for each entity
 - Controller: LocationController.java
 - Templates: index.html using Thymeleaf + Bootstrap 5 + SweetAlert2
8. Install SweetAlert2 via CDN in index.html:
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
9. Add the JavaScript alert + redirect logic:
 Swal.fire({ title: 'Success!', ... }).then(() => { window.location.href = "/"; });
10. Run the Application:
 mvn spring-boot:run
11. Open the browser and navigate to:
 http://localhost:8080/

**Final Notes**
SweetAlert2 has been integrated for success messages, and Bootstrap 5 is used for styling.
Ensure that the Thymeleaf template engine is configured correctly in your Spring Boot project.

**Happy coding!**
