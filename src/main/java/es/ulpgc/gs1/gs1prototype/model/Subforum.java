package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subforum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Thread> threads;

    public Subforum() {
    }

    public Subforum(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNullId() {
        this.id = null;
    }


    public Set<Thread> getThreads() {
        return threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

    @Override
    public String toString(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("Subforum with id: ").append(id);
        toReturn.append("\nSubforum titled: ").append(title);
        toReturn.append("\nWith description:\n").append(description);
        toReturn.append("\nAnd owes the following threads:");
        for (Thread thread : threads) {
            toReturn.append("\n\n\n").append(thread.toString());
        }
        return toReturn.toString();
    }
}
