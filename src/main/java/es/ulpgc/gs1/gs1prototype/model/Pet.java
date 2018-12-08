package es.ulpgc.gs1.gs1prototype.model;

import es.ulpgc.gs1.gs1prototype.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long id;
    private String name;
    private String photo_url;

    public Pet(){}
    public Pet(String name, String photo_url) {
        this.name = name;
        this.photo_url = photo_url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

}
