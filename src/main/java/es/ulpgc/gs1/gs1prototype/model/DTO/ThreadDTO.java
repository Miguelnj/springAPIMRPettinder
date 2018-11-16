package es.ulpgc.gs1.gs1prototype.model.DTO;

import es.ulpgc.gs1.gs1prototype.model.Message;

import java.util.Set;

public class ThreadDTO {

    private Long parentSubforumId;
    private String title;
    private String description;
    private Set<Message> messages;

    public ThreadDTO(Long parentSubforumId, String title, String description, Set<Message> messages) {
        this.parentSubforumId = parentSubforumId;
        this.title = title;
        this.description = description;
        this.messages = messages;
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

    public Set<Message> getMessages() {
        return messages;
    }
}
