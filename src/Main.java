import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Main {

    // for now, we store all user information in this list
    public static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        // test user
        initUser();

        try {
            UserService userService = new UserService();
            NoteService noteService = new NoteService();

            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Naming.rebind("rmi://localhost/userService", userService);
            Naming.rebind("rmi://localhost/noteService", noteService);

            System.out.println("Note and User services bound to registry!");

        } catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initUser() {
        // initialize test users
        User testUser = new User("testuser", "1234", "abc@mail.com");
        User testUser2 = new User("aa", "aa", "aa");

        Note note1 = new Note("Note 1", "This is the first note.");
        Note note2 = new Note("Note 2", "This is the second note.");
        Note note3 = new Note("Note 3", "This is the third note.");
        Note note4 = new Note("Note 4", "This is the 4th note.");
        Note note5 = new Note("Note FIVE", "Note number five.");
        Note note6 = new Note("6th Note", "Note number six.");

        testUser.addNote(note1);
        testUser.addNote(note2);
        testUser.addNote(note3);

        testUser2.addNote(note4);
        testUser2.addNote(note5);
        testUser2.addNote(note6);

        userList.add(testUser);
        userList.add(testUser2);
    }
}