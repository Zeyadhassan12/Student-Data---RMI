import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Servant extends UnicastRemoteObject implements StudentI{
    private static final long serialVersionUID = 1L;
    private List<Student> studentList;

    public Servant() throws RemoteException{
        super();
        this.studentList = new ArrayList<>();
        initializeStudentList();
    }

    private void initializeStudentList() {

        studentList.add(new Student("12345670", "Alice", "CS", 3.1, 5));
        studentList.add(new Student("12345671", "Bob", "SE", 3.0, 6));
        studentList.add(new Student("12345672", "Carol", "IS", 3.6, 5));
        studentList.add(new Student("12345673", "Dan", "GM", 3.7, 7));


    }


    @Override
    public void AddStudent(Student student) throws RemoteException {

        studentList.add(student);

    }

    @Override
    public Student getStudentInfo(String id) throws RemoteException {
        for(Student student : studentList){
            if(student.getId().equals(id)){
                return student;
            }

        }

        return null;
    }

    @Override
    public ArrayList<Student> aboveAvgGPA() throws RemoteException {

        double AvgGpa = calAvgGpa();
        ArrayList<Student> aboveAvgList = new ArrayList<>();
        for(Student student : studentList){
            if(student.getGpa() > AvgGpa){
                aboveAvgList.add(student);
            }
        }

        aboveAvgList.sort(Comparator.comparingDouble(Student::getGpa).reversed());




        return aboveAvgList;
    }


    private double calAvgGpa(){
        if (studentList.isEmpty()) {
            return 0.0;
        }
        double totalGPA = 0.0;
        for (Student student : studentList) {
            totalGPA += student.getGpa();
        }
        return totalGPA / studentList.size();
    }


}
