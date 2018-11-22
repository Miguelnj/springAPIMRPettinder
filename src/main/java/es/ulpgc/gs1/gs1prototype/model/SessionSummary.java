package es.ulpgc.gs1.gs1prototype.model;

import es.ulpgc.gs1.gs1prototype.model.user.Vet;

import javax.persistence.*;

@Entity
@Table(name = "sessionsummaries")
public class SessionSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Log log;
    private String recipe;
    private String observations;
    @OneToOne(fetch = FetchType.EAGER)
    private Vet attendedBy;

    public SessionSummary(Log log, String recipe, String observations, Vet attendedBy) {
        this.log = log;
        this.recipe = recipe;
        this.observations = observations;
        this.attendedBy = attendedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Vet getAttendedBy() {
        return attendedBy;
    }

    public void setAttendedBy(Vet attendedBy) {
        this.attendedBy = attendedBy;
    }
}
