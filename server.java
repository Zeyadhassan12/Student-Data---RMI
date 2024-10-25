import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args){
        try{

            StudentI server = new Servant();
            Registry registry = LocateRegistry.createRegistry(StudentI.port);
            registry.rebind(StudentI.serviceName,server);
            System.out.println("Server is running...");




        }catch(RemoteException e){
            e.printStackTrace();
        }

    }
}
