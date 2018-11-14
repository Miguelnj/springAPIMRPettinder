package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    private LocalDateTime creationDate;
    private String createdBy;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Message> messages;

    public Thread(String title, String description,Set<Message> messages, String createdBy) {
        this.title = title;
        this.createdBy = createdBy;
        this.description = description;
        this.messages = messages;
        this.creationDate = LocalDateTime.now();
        this.isOpen = true;
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

    public Set<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString(){
        return "Thread with id: " + id +
                "\nCreated: " + creationDate +
                "\nThread with title: " + title +
                "\nWith description:\n" + description +
                "\nAnd status: " + (isOpen ? "Open" : "Closed") +
                "\nThread have the following messages: ";
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
