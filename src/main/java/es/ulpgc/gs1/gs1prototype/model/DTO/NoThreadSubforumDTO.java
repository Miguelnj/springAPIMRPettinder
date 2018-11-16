package es.ulpgc.gs1.gs1prototype.model.DTO;

public class NoThreadSubforumDTO {

    private Long id;
    private String title;
    private String description;

    public NoThreadSubforumDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
