# Hotel Management System

## 1. About

Introducing our Hotel Management App, a comprehensive solution that caters to the needs of both guests and administrators.

Guests can easily book rooms, update their personal information, and leave reviews, ensuring a personalized and comfortable stay. Our app prioritizes user satisfaction.

Administrators, on the other hand, have access to a suite of essential features. They can effortlessly view all bookings, ensuring smooth check-ins and check-outs. With the ability to check hotel income reports, administrators can make informed decisions to optimize revenue. Additionally, monitoring room availability is a breeze, ensuring efficient room assignment and management.

Our Hotel Management App is the perfect solution for both guests and administrators, creating a harmonious and efficient hotel experience for all.

### 1.1. Demo

Watch our demo on YouTube: https://youtu.be/5Sl7PLuSNgo

## 2. Authors

This project was created by:

* Marconi Alessandro
* Villotti Manuel

Collaborator: Khinchi Ganesh Kumar 

## 3. Usage

### Application Requirements

To run our application, you will need Java 17 installed on your system. If you haven't already, you can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html). 

Please ensure that your `JAVA_HOME` environment variable is correctly set to the installation folder of Java 17.

If you don't have Maven installed on your system, don't worry, it is already implemented in the repository.

### Commands

Follow these steps to compile and run the application:

1. Open a terminal in the repository's path.

2. It's always a good practice to clean the repository before compiling the code.

    ```shell
    ./mvnw clean
    ```

3. To build the application, use the following command:

    ```shell
    ./mvnw package
    ```

4. After successfully building the application, you can run it either using Maven or directly with Java.

    Using Maven:

    ```shell
    ./mvnw exec:exec
    ```

    Alternatively, you can run the JAR file directly:

    ```shell
    java -jar ./<path-to-the-jar-file>.jar
    ```

5. To run the test classes, use the following command:

    ```shell
    ./mvnw test
    ```

## 4. Implementation

### 4.1. Architectural Overview

src/main/java: This is the main source code directory where our Java classes reside.

a. AdminGUI: This component contains classes related to the graphical user interface for administrators.

b. DesignObjects: This component houses design-related objects or classes, related to the user interface design.

c. Logs: This component contains the log files.

d. Main: This component includes the main class or entry point for our application.

e. Objects: This directory holds most of our backend classes.

f. UserGUI: This component contains classes related to the graphical user interface for regular users.

g. WelcomeGUI: Component responsible for the welcome page.

src/main/resources: This directory holds all non-java files, such as JSON, jpeg, or png.

src/test: This is the directory where our Test units are.

### 4.2. Third-Party Libraries

org.netbeans.external:AbsoluteLayout (Version: RELEASE170)
Justification: This library was used for layout management.

com.toedter:jcalendar (Version: 1.4)
Justification: used for calendar-related functionality, for date selection, and display in the application.

com.google.code.gson:gson (Version: 2.10.1)
Justification: Gson was used for serializing and deserializing JSON data.

org.junit.jupiter:junit-jupiter-api (Version: 5.7.1)
Justification: JUnit was used for writing test cases for our code.

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
- **Casting:** We used casting to convert a value from one data type to another. It allowed us to change the type of a variable or an expression temporarily.
- **Lambda Expressions:** We used lambda expressions multiple times for concise functionality, especially within assert statements.

### 4.4. Tests

Our test suite encompasses unit, integration, boundary, error handling, and performance testing to thoroughly evaluate the main classes and methods, ensuring their functionality, reliability, and robustness under various conditions

## 5. Experience

### 5.1. Overall Experience

Creating this Java project was a challenging but rewarding journey. It began with careful planning, followed by meticulous coding and testing phases. Collaboration and adaptation were key. The project honed our skills and provided valuable lessons in software development and project management. 
In the end, the experience of developing this Java project was both demanding and fulfilling, leaving us with a profound sense of growth and achievement.

### 5.2. Division of Responsibilities

Describe the roles and responsibilities each member had in this project.

- **Khinchi Ganesh Kumar:** He made contributions to the project during the initial phase, working on the admin console and designing the gallery and services panel on the welcome page. Unfortunately, he had to leave the project during the semester.
- **Marconi Alessandro:** I primarily focused on enhancing the backend of our login and registration system. I also spearheaded the development of robust test suites for essential classes like User, Login & Register, and Room. Additionally, I played a key role in building the backend functionality for handling Reviews. Moreover, I implemented the logging mechanism in the login and register class. Ultimately, I helped here and there in the backend development. 
- **Villotti Manuel:** In this programming project, my first responsibility was to establish a well-organized project structure. This involved creating distinct JFrames and separating various JPanels across different packages, ensuring a clear and manageable architecture (also because it was needed to edit the design separately with NetBeans).
I took charge of designing and implementing the User, Room, and Booking objects, carefully interconnecting them using unique generated IDs. This seamless integration allowed for smooth interactions between booking records, reserved rooms, and user accounts. Additionally, I implemented methods, utilizing regular expressions, to validate user input during the account registration and editing process. This ensured that all information provided met the necessary criteria.
One of the pivotal components I developed was the GeneralController class, which serves as the backbone of the backend. It houses essential methods utilized by various classes and encompasses functionalities to handle data retrieval and storage from the Json database. This class serves as the central hub for viewing and modifying the objects I created (User, Room, and Booking), all of which are stored in arrays within the Json files.
A significant portion of my efforts went into crafting the User page, an interface for guest interaction. I implemented a management console, empowering users to create and edit their bookings and adjust their account details.
In collaboration with Ganesh, I also played a role in the development of the Admin Console. Together, we worked to ensure its functionality and completeness.
Turning to the design aspect, I devoted time to create visually appealing and intuitive interfaces. This included designing the welcome page with its distinct sections like home, gallery, and the left panel. Additionally, I crafted the login and registration popups, ensuring they were both aesthetically pleasing and user-friendly. In addition to these core contributions, I introduced the dark theme extra feature for the welcome page.

### 5.3. Main Challenges

Elaborate on the main challenges each group member faced throughout the project and how they were surpassed.

- **Marconi Alessandro:** The most difficult aspect of this project for me was to try to implement a server and client architecture, which I didn't manage to do exactly because of time management, which was also a significant problem I encountered. 
- **Villotti Manuel:** Navigating this project presented several notable challenges. Initially, I grappled with defining clear objectives and a starting point. Establishing a solid foundation was important.
Efficiently managing the extensive data proved to be another hurdle. It required planning to ensure seamless data handling throughout the application (I had to change the initial method).
However, the most demanding task was undoubtedly bug hunting and resolution. This demanded time and rigorous testing to identify and resolve issues. Fortunately, exceptions helped a lot with this aspect.


### 5.4. Learning Outcomes

Describe what you learned with this project.

- **Marconi Alessandro:**  Above all, I acquired valuable experience in serializing and deserializing JSON data, which with the whole project significantly improved my overall skills. 
- **Villotti Manuel:** Reflecting on this project, I've acquired a wealth of new skills that I am confident will prove invaluable in future projects, enabling me to streamline my workflow and save time. Additionally, I've noticed a transformation in my coding approach. I've become more diligent in documenting my code and handling exceptions, and now prioritize writing structured and organized code.




