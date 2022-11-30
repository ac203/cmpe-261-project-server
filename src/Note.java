import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private String title;
    private String note;

    public Note(String title, String note) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
