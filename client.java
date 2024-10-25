import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class client {
    public static void main(String[] args){
        String host = "192.168.1.6";
        try{
            Registry registry = LocateRegistry.getRegistry(host, StudentI.port);

            StudentI server = (StudentI) registry.lookup(StudentI.serviceName);


            server.AddStudent(new Student("20101209","zeyad", "CS" ,3.9 ,7));


            Student student = server.getStudentInfo("12345672");

            System.out.println("Student Info: " + student.getName() + ", GPA: " + student.getGpa());


            System.out.println("Above Average GPA Students:");
            ArrayList<Student> aboveAvgList = server.aboveAvgGPA();
            for (Student aboveAvgStudent : aboveAvgList) {
                System.out.println(aboveAvgStudent.getName()+   ", GPA: " + aboveAvgStudent.getGpa());
            }




//            String response = helloStub.sayHello("World!");
//            System.out.println(response);





        }catch (RemoteException e){
            e.printStackTrace();
        }catch (NotBoundException e){
            e.printStackTrace();
//            Logger.getLogger(client.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
