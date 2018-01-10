package com.ipiecoles.java.java220;


import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    //2.2. Déclarer dans la classe Employe une méthode abstraite getPrimeAnnuelle retournant
    //un Double
    public abstract Double getPrimeAnnuelle();

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
    //postérieure à la date courante. (verifier que la date embauche ne soit pas nulle)

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
            this.dateEmbauche = dateEmbauche;
            if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
                throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
            }

    }

    //2.5. Déclarer et développer la méthode getNombreAnneeAnciennete calculant le nombre
    //d'année d'ancienneté d'un employé. Faire en sorte qu'elle ne puisse être redéfinie dans
    //d'éventuelles sous-classes.

    public final Integer getNombreAnneeAnciennete () {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    //2.7. Développer une méthode getNbConges retournant la constante de classe
    //NB_CONGES_BASE de la classe Entreprise.

    public Integer getNbConges () {
        Entreprise e = new Entreprise();
        return e.NB_CONGES_BASE;
    }

    //2.8. Redéfinir la méthode toString (héritée d'Object) pour afficher un employé de la
    //manière suivante : "Employe{nom='nom', prenom='prenom', matricule='12345',
    //dateEmbauche=1970-01-01, salaire=500.0}"
    @Override
    public String toString () {
        return "Employe{nom='"+nom+"', prenom='"+prenom+"', matricule='"+matricule+"', dateEmbauche="+dateEmbauche+", salaire="+salaire+"}";
    }


    //2.9. Redéfinir la méthode equals (héritée d'Object) testant l'égalité sur l'ensemble des
    //attributs de la classe Employe (avec Generate alt+inser equals et hashCode)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    //2.10. Redéfinir la méthode hashCode (héritée d'Object) en utilisant Objects.hash(...) et en
    //respectant l'ordre nom, prenom, matricule, dateEmbauche, salaire (avec Generate alt+inser equals et hashCode)
    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    //2.11. Coder la méthode augmenterSalaire prenant en paramètre un pourcentage
    //d'augmentation de type Double et augmentant l'attribut salaire du pourcentage passé en
    //paramètre. Ex : un salaire de 500.0, avec une augmentation de 0.50, cela donne un salaire de
    //750.0
    public void augmenterSalaire(Double pourcentage) {
        this.salaire = salaire*(1+pourcentage);
        //setSalaire(this.getSalaire() * (1 + pourcentage)); //On utilise pour prendre en compte les modifications dans les classes en dessous
    }



}


