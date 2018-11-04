package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "threads")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean isOpen;
    @Column
    private LocalDateTime creationDate;

    public Thread(String title, String description, Long id, Boolean isOpen) {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.id = id;
        this.isOpen = isOpen;
    }

    public Thread(){
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public void setNullId() {
        this.id = null;
    }
}
