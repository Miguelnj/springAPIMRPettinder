package es.ulpgc.gs1.gs1prototype.model;

public class MessageDTO {

    private Long parentThreadId;
    private String content;

    public MessageDTO(){}

    public MessageDTO(Long parentThreadId, String content) {
        this.parentThreadId = parentThreadId;
        this.content = content;
    }

    public Long getParentThreadId() {
        return parentThreadId;
    }

    public String getContent() {
        return content;
    }
}
