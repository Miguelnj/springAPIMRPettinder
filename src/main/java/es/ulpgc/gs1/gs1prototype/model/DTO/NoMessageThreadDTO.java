package es.ulpgc.gs1.gs1prototype.model.DTO;

import java.time.LocalDateTime;

public class NoMessageThreadDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean isOpen;
    private LocalDateTime creationDate;
    private String createdBy;

    public NoMessageThreadDTO(Long id, String title, String description, Boolean isOpen, LocalDateTime creationDate, String createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isOpen = isOpen;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
