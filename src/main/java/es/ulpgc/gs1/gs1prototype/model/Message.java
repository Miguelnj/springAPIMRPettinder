package es.ulpgc.gs1.gs1prototype.model;

import es.ulpgc.gs1.gs1prototype.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String content;
    private LocalDateTime writtenDate;
    private LocalDateTime lastEditDate;
    private int timesModified;
    private String writtenBy;


    public Message(){}

    public Message(String content, String writtenBy) {
        this.content = content;
        this.writtenBy = writtenBy;
        this.writtenDate = LocalDateTime.now();
        this.lastEditDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getWrittenDate() {
        return writtenDate;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public int getTimesModified() {
        return timesModified;
    }

    public void increaseModifiedCount() {
        this.timesModified++;
    }

    public String getWrittenBy() {
        return writtenBy;
    }
}
