import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class NoteService extends UnicastRemoteObject implements INoteService {

    protected NoteService() throws RemoteException {
    }

    @Override
    public void addNote(User user, Note note) throws RemoteException {
        for (User u : Main.userList) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassWord().equals(user.getPassWord())) {
                u.addNote(note);
            }
        }
    }

    @Override
    public void saveNote(User user, Note note) throws RemoteException {
        for (User u : Main.userList) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassWord().equals(user.getPassWord())) {
                for (Note n : u.getNotes()) {
                    n = note;
                }
            }
        }
    }

    @Override
    public ArrayList<Note> getAllNotes(User user) throws RemoteException {
        ArrayList<Note> noteList = new ArrayList<>();
        for (User u : Main.userList) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassWord().equals(user.getPassWord())) {
                noteList = u.getNotes();
            }
        }
        return noteList;
    }

    @Override
    public void deleteNote(User user, Note note) throws RemoteException {
        for (User u : Main.userList) {
            if (u.getUserName().equals(user.getUserName()) && u.getPassWord().equals(user.getPassWord())) {
                u.getNotes().remove(note);
            }
        }
    }
}
