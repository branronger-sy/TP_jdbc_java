# Student Management System (TP Collections JDBC)

A comprehensive Java application demonstrating the use of Java Collections Framework and JDBC for managing student records. This project showcases practical implementation of data structures (List, Set, Map), database operations, and object-oriented programming principles.

## 📋 Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Project Structure](#project-structure)
- [Usage](#usage)
- [Examples](#examples)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

##  Features

- **Student CRUD Operations**: Create, Read, Update operations for student records
- **Database Integration**: MySQL database connectivity using JDBC
- **Collections Framework**: Demonstrates usage of:
  - `List` (ArrayList) for ordered collections
  - `Set` (HashSet) for unique elements
  - `Map` (HashMap) for key-value pairs
- **Sorting Capabilities**: 
  - Natural sorting by student name (using `Comparable`)
  - Custom sorting by average grade (using `Comparator`)
- **Filtering**: Filter students by minimum average grade
- **Interactive CLI**: User-friendly command-line interface for managing students
- **DAO Pattern**: Data Access Object pattern for clean database operations

##  Technologies Used

- **Java 17**: Core programming language
- **Maven**: Build automation and dependency management
- **MySQL**: Relational database management system
- **JDBC**: Java Database Connectivity API
- **JUnit 5**: Testing framework (for unit tests)

##  Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 17** or higher
- **Maven 3.6+**
- **MySQL Server 8.0+**
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code) - optional but recommended

##  Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/TP_Collections_JDBC.git
   cd TP_Collections_JDBC
   ```

2. **Build the project using Maven**
   ```bash
   mvn clean install
   ```

3. **Configure database connection** (see [Database Setup](#database-setup))

##  Database Setup

1. **Create the database**
   ```sql
   CREATE DATABASE tp_collections_jdbc;
   ```

2. **Create the students table**
   ```sql
   USE tp_collections_jdbc;
   
   CREATE TABLE etudiants (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nom VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL,
       moyenne DECIMAL(4,2) NOT NULL
   );
   ```

3. **Update database credentials** in `src/main/java/tp/dao/ConnexionBD.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/tp_collections_jdbc";
   private static final String USER = "your_username";
   private static final String PASS = "your_password";
   ```

4. **Insert sample data** (optional)
   ```sql
   INSERT INTO etudiants (nom, email, moyenne) VALUES
   ('John Doe', 'john.doe@example.com', 18.5),
   ('Jane Smith', 'jane.smith@example.com', 16.0),
   ('Bob Johnson', 'bob.johnson@example.com', 14.5);
   ```

##  Project Structure

```
TP_Collections_JDBC/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── tp/
│   │           ├── app/
│   │           │   ├── AppEtudiants.java      # Main interactive application
│   │           │   ├── TestCollections.java   # Collections framework demo
│   │           │   └── TestDao.java           # DAO testing
│   │           ├── dao/
│   │           │   ├── ConnexionBD.java       # Database connection utility
│   │           │   └── EtudiantDao.java       # Data Access Object
│   │           └── model/
│   │               ├── Etudiant.java          # Student entity class
│   │               └── PerMoy.java            # Comparator for sorting by average
│   └── test/
│       └── java/
│           └── tp/
│               └── AppTest.java              # Unit tests
├── pom.xml                                    # Maven configuration
└── README.md                                  # Project documentation
```

##  Usage

### Running the Main Application

Execute the interactive student management application:

```bash
mvn exec:java -Dexec.mainClass="tp.app.AppEtudiants"
```

Or compile and run manually:

```bash
mvn compile
java -cp target/classes tp.app.AppEtudiants
```

### Application Menu

The application provides the following options:

1. **List all students** - Display all students from the database
2. **Search student by ID** - Find a specific student using their ID
3. **Filter by minimum average** - Get students with average grade above a threshold
4. **Add new student** - Insert a new student record
5. **Update student average** - Modify a student's average grade
0. **Exit** - Close the application

### Running Test Classes

**Test Collections Framework:**
```bash
mvn exec:java -Dexec.mainClass="tp.app.TestCollections"
```

**Test DAO Operations:**
```bash
mvn exec:java -Dexec.mainClass="tp.app.TestDao"
```

##  Examples

### Example 1: Using Collections

The `TestCollections` class demonstrates:
- Creating and manipulating `ArrayList`
- Sorting using `Comparable` (by name) and `Comparator` (by average)
- Using `HashSet` to eliminate duplicates
- Using `HashMap` for key-value storage

### Example 2: Database Operations

The `EtudiantDao` class provides methods for:
- `findAll()`: Retrieve all students as a List
- `findAllAsMap()`: Retrieve all students as a Map (ID -> Student)
- `filtrerParMoyenneMin(double)`: Filter students by minimum average
- `insert(Etudiant)`: Add a new student
- `updateMoyenne(int, double)`: Update a student's average

### Example 3: Student Model

The `Etudiant` class implements:
- `Comparable<Etudiant>` for natural ordering by name
- `equals()` and `hashCode()` for proper Set operations
- Standard getters and setters

##  Testing

Run the test suite using Maven:

```bash
mvn test
```

##  Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 👤 Author

**Issam AFJDGHIGH**
- GitHub: [@branronger-sy](https://github.com/branronger-sy)

## 🙏 Acknowledgments

- This project was created as a practical exercise for learning Java Collections and JDBC
- Special thanks to the Java community for excellent documentation and resources

---

**Note**: Make sure to update the database credentials in `ConnexionBD.java` before running the application. For production use, consider using environment variables or a configuration file for sensitive information.

