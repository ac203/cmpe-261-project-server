import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface INoteService extends Remote {
    void addNote(User user, Note note) throws RemoteException;
    void saveNote(User user, Note note) throws RemoteException;

    ArrayList<Note> getAllNotes(User user) throws RemoteException;

    void deleteNote(User user, Note note) throws RemoteException;
}
