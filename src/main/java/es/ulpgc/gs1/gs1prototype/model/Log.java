package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;

@Entity
@Table(name="Logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    private String chatMessages;
    private String uploadedMedia;

    public Log(String chatMessages, String uploadedMedia) {
        this.chatMessages = chatMessages;
        this.uploadedMedia = uploadedMedia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(String chatMessages) {
        this.chatMessages = chatMessages;
    }

    public String getUploadedMedia() {
        return uploadedMedia;
    }

    public void setUploadedMedia(String uploadedMedia) {
        this.uploadedMedia = uploadedMedia;
    }
}
