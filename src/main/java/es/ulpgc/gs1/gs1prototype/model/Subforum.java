package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;

@Entity
public class Subforum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    public Subforum() {
    }

    public Subforum(String title, String description) {
        this.title = title;
        this.description = description;
        //this.threads = threads;
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
}
