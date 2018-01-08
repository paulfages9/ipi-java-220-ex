package com.ipiecoles.java.java220;


import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    //2.3 ajouter dans la classe Employe les champs suivants avec leur getters/setters
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    // 2.4. Définir un constructeur par défaut dans la classe Employé
    public Employe () {

    }

    //2.4. Définir un constructeur avec l'ensemble des arguments précédemment créés, dans le même ordre.
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom =prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    //2.6. Modifier le setter de dateEmbauche pour lever une Exception avec le message "La
    //date d'embauche ne peut être postérieure à la date courante" lorsque la date d'embauche est
    //postérieure à la date courante.

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
            this.dateEmbauche = dateEmbauche;
            if (dateEmbauche.isAfter(LocalDate.now())) {
                throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
            }

    }

    //2.5. Déclarer et développer la méthode getNombreAnneeAnciennete calculant le nombre
    //d'année d'ancienneté d'un employé. Faire en sorte qu'elle ne puisse être redéfinie dans
    //d'éventuelles sous-classes.

    public final Integer getNombreAnneeAnciennete () {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }
}


