## Student-Data---RMI
This Java RMI project demonstrates a distributed system for managing student information. It includes functionalities for adding student data, retrieving specific student information, and identifying students with above-average GPAs.



# Project Structure:
Client Class (client): 
  This class connects to the server, adds new students, retrieves student information, and lists students with above-average GPAs.
Server Class (server): 
  This class initializes and binds the StudentI implementation (Servant) to the RMI registry, allowing clients to interact with the student data.
Servant Class (Servant): 
  This class implements StudentI and manages student data. It provides methods to:
  Add a Student: Adds a new student to the list.
  Get Student Info: Retrieves details for a specific student.
  List Above Average GPA Students: Calculates the average GPA and lists students with GPAs above this average, sorted in descending order.
Student Class (Student): A serializable class representing student data, including attributes like ID, name, department, GPA, and semester.
Interface (StudentI): Defines remote methods accessible to clients:
  AddStudent(Student student): Adds a student.
  getStudentInfo(String id): Retrieves information for a student with the given ID.
  aboveAvgGPA(): Returns a list of students with GPAs above the calculated average.
