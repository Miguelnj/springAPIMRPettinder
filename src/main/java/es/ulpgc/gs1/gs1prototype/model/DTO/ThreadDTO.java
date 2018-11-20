package es.ulpgc.gs1.gs1prototype.model.DTO;

public class ThreadDTO {

    private Long parentSubforumId;
    private String title;
    private String description;

    public ThreadDTO(Long parentSubforumId, String title, String description) {
        this.parentSubforumId = parentSubforumId;
        this.title = title;
        this.description = description;
    }

    public ThreadDTO(){}

    public Long getParentSubforumId() {
        return parentSubforumId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
