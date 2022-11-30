import java.io.Serializable;
import java.util.ArrayList;

// user class to store user information
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String passWord;
    private String mail;
    private ArrayList<Note> notes;

    public User(String userName, String passWord, String mail) {
        this.userName = userName;
        this.passWord = passWord;
        this.mail = mail;
        this.notes = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }
}
