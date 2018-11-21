package es.ulpgc.gs1.gs1prototype.model;

import javax.persistence.*;

@Entity
@Table(name = "payerinfos")
public class PayerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;

    private String name;
    private String surname;
    private String documentation;

    public PayerInfo(String name, String surname, String documentation) {
        this.name = name;
        this.surname = surname;
        this.documentation = documentation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}
