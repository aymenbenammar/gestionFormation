package com.projet.formation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formateur implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="FormateurId")
    private Long IdFormateur;
    private String Nom;
    private String Prenom;
    @Column(unique=true,nullable = false)
    private String email;
    @Column(unique=true,nullable = false)
    private Long tel;
    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "formateur")
    private Set<Session> sessions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisme_id", insertable = false, updatable = false)
    private Organisme organisme;*/

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdFormateur() {
        return IdFormateur;
    }

    public void setIdFormateur(Long idFormateur) {
        IdFormateur = idFormateur;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Organisme getOrganisme() {
        return organisme;
    }

    public void setOrganisme(Organisme organisme) {
        this.organisme = organisme;
    }
}
