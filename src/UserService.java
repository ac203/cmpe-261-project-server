import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserService extends UnicastRemoteObject implements IUserService {
    protected UserService() throws RemoteException {
    }

    @Override
    public User login(String userName, String password) throws RemoteException {
        return null;
    }

    @Override
    public User getUserFromUserList(String userName, String password) throws RemoteException {
        // get registered user from user list

        User user = null;
        for (User u : Main.userList) {
            if (u.getUserName().equals(userName) && u.getPassWord().equals(password)) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public boolean checkIfUserAlreadyRegistered(String userName, String mail) throws RemoteException {
        // iterate through list of users and return true if user is already registered
        for (User u : Main.userList) {
            if (userName.equals(u.getUserName()) || mail.equals(u.getMail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkIfUserExists(String userName, String password) throws RemoteException {
        // iterate through list of users and return true if user exists
        for (User u : Main.userList) {
            if (userName.equals(u.getUserName()) && password.equals(u.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void registerUser(User user) throws RemoteException {
        Main.userList.add(user);
    }
}
