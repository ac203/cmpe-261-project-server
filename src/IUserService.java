import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserService extends Remote {
    User login(String userName, String password) throws RemoteException;
    User getUserFromUserList(String userName, String password) throws RemoteException;

    boolean checkIfUserAlreadyRegistered(String userName, String mail) throws RemoteException;
    boolean checkIfUserExists(String userName, String password) throws RemoteException;
    void registerUser(User user) throws RemoteException;

}
