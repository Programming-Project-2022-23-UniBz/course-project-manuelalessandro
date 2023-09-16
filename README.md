[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/KEbQ1JIO)
# Hotel Management System

## 1. About

Introducing our Hotel Management App, a comprehensive solution that caters to the needs of both guests and administrators.

Guests can easily book rooms, update their personal information, and leave reviews, ensuring a personalized and comfortable stay. Our app prioritizes user satisfaction.

Administrators, on the other hand, have access to a suite of essential features. They can effortlessly view all bookings, ensuring smooth check-ins and check-outs. With the ability to check hotel income reports, administrators can make informed decisions to optimize revenue. Additionally, monitoring room availability is a breeze, ensuring efficient room assignment and management.

Our Hotel Management App is the perfect solution for both guests and administrators, creating a harmonious and efficient hotel experience for all.

### 1.1. Demo

video here

## 2. Authors

This project was created by:

* Khinchi Ganesh Kumar 
* Marconi Alessandro
* Villotti Manuel

## 3. Usage

Describe how to compile, package, and Main your project here.

To build the project, Main:

```shell
mvn package
```

To do X, Main:

```
mvn abc
```

## 4. Implementation

### 4.1. Architectural Overview

Describe the architecture of your application.

### 4.2. Third-Party Libraries

org.netbeans.external:AbsoluteLayout (Version: RELEASE170)
Justification: This library was used for layout management.

com.toedter:jcalendar (Version: 1.4)
Justification: used for calendar-related functionality, for date selection, and display in the application.

com.google.code.gson:gson (Version: 2.10.1)
Justification: Gson was used for serializing and deserializing JSON data.

org.junit.jupiter:junit-jupiter-api (Version: 5.7.1)
Justification: JUnit was used for writing test cases for your code.

org.junit.jupiter:junit-jupiter-engine (Version: 5.7.1)
Justification: This is the JUnit engine required for executing JUnit 5 tests.

joda-time:joda-time (Version: 2.12.5)
Justification: Joda-Time was used for handling date and time operations in a more user-friendly and flexible manner compared to Java's built-in date and time classes.

org.apache.maven.plugins:maven-compiler-plugin (Version: 3.8.1)
Justification: Used for compiling the project's source code.

org.apache.maven.plugins:maven-resources-plugin (Version: 3.2.0)
Justification: Used for managing and copying resources (e.g., configuration files) during the build process.

jfree:jfreechart (Version: 1.0.13)
Justification: JFreeChart was used for data visualization in the application, in the admin frame.

org.assertj:assertj-core (Version: 3.22.0)
Justification: AssertJ is a library for enhancing assertions in test cases, making it easier to write and read test assertions.

### 4.3. Programming Techniques

- **Serialization:** We used Serialization to convert a JSON object into a string because we used them as our database. 
- **Deserialization:** We used Deserialization to do the opposite and update a JSON object or add a JSON object to the array.
- **Regular Expressions:** We used regular expressions to check the user input during the register phase.
- **Try-Catch blocks:** Try-Catch blocks were a significant part of our code because they allowed us to handle and gracefully manage potential exceptions during file reading, ensuring the reliability and stability of our application even in the face of unexpected errors, such as file not found or permission issues.
- **Test hooks:** We used Test hooks as they provide a means to isolate and test specific components or functions within our codebase.
- **Graphical Interface:** We used a Graphical user interface because it makes the app easier to use.
- **File I/O:** We used File I/O to work with the jsons.
- **Overriding:** We used overriding to provide a specific implementation, for example, of the "mouseClicked" method for each button, which overrides the default behavior in the MouseAdapter class and defines custom actions for each button's click event
- **Collections:** We used collections to make the usage of the combo boxes easier or also in the management of rooms.
- **Logging:** We used logging to control better the inputs users give when they log in or register, in case someone finds an exploit and uses it to gain admin privileges. 

### 4.4. Tests

Our test suite encompasses unit, integration, boundary, error handling, and performance testing to thoroughly evaluate the main classes and methods, ensuring their functionality, reliability, and robustness under various conditions

## 5. Experience

### 5.1. Overall Experience

Creating this Java project was a challenging but rewarding journey. It began with careful planning, followed by meticulous coding and testing phases. Collaboration and adaptation were key. The project honed our skills and provided valuable lessons in software development and project management. 
In the end, the experience of developing this Java project was both demanding and fulfilling, leaving us with a profound sense of growth and achievement.

### 5.2. Division of Responsibilities

Describe the roles and responsibilities each member had in this project.

- **Khinchi Ganesh Kumar:** I was responsible for implementing components `x` and `y`. I also helped 2 to implement technique `z`.
- **Marconi Alessandro:** I primarily focused on enhancing the backend of our login and registration system. I also spearheaded the development of robust test suites for essential classes like User, Login & Register, and Room. Additionally, I played a key role in building the backend functionality for handling Reviews. Moreover, I implemented the logging mechanism in the login and register class. Ultimately, I helped here and there in the backend development. 
- **Villotti Manuel:** 

### 5.3. Main Challenges

Elaborate on the main challenges each group member faced throughout the project and how they were surpassed.

- **Khinchi Ganesh Kumar:** The most challenging aspect in this project for me was to implement the unit tests. The reason was X so I had to do Y and I achived Z.
- **Marconi Alessandro:** The most difficult aspect of this project for me was to try to implement a server and client architecture, which I didn't manage to do exactly because of time management, which was also a significant problem I encountered. 
- **Villotti Manuel:** ...

### 5.4. Learning Outcomes

Describe what you learned with this project.

- **Khinchi Ganesh Kumar:** I learned a new library called `XYZ`!
- **Marconi Alessandro:**  Above all, I acquired valuable experience in serializing and deserializing JSON data, which with the whole project significantly improved my overall skills. 
- **Villotti Manuel:** ...




