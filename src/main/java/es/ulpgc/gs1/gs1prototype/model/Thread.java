package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Thread {

    private String title;
    private String description;
    private LocalDateTime creationDate;
    private Long id;
    private Boolean isOpen;

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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }
}
