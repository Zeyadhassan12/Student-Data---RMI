import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StudentI extends Remote {
    String serviceName = "Students";
    int port = 56540;//6942
    void AddStudent(Student student) throws RemoteException;
    Student getStudentInfo(String id) throws RemoteException;
    ArrayList<Student> aboveAvgGPA() throws RemoteException;
}
