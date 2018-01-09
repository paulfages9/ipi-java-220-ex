package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exception.TechnicienException;
import org.joda.time.LocalDate;

public class Technicien extends Employe {
    private Integer grade;

    public Technicien () {
        super();
    }

    //4.2. Modifier la classe Technicien pour ajouter un attribut grade de type int avec son
    //getter et son setter.
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if (grade <= 0 || grade > 5){
            throw new TechnicienException("Le grade doit être compris entre 1 et 5 : "+ grade +", technicien : "  + this.toString());
        }
        this.grade = grade;
    }
    // 4.3. Créer un constructeur pour la classe Technicien qui initialise tous les attributs hérités
    //de la classe Employe en faisant appel au constructeur d'Employe et qui initialise également
    //l'attribut grade.
    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    //4.4. Modifier le setter de l'attribut grade pour qu'il lève une exception de la classe
    //TechnicienException (à créer) et dont le message est : "Le grade doit être compris entre 1 et
    //5 : X, technicien : Technicien{grade=X} Employe{nom='NOM', prenom='PRENOM',
    //matricule='MATRICULE', dateEmbauche=DATE, salaire=SALAIRE}"
    //Avec X = valeur incorrecte passée au setter et NOM, PRENOM... les valeurs des attributs
    //d'Employe.
    //Astuce : Ajouter une méthode toString à Technicien
    //creation de la classe TechnicienException

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Technicien{");
        sb.append("grade=").append(grade);
        sb.append("} ");
        sb.append(super.toString()); //info de l'employé
        return sb.toString();
    }

    //4.5. Redéfinir le setter de l'attribut salaire pour qu'il renvoie la valeur de l'attribut salaire,
    //auquel on ajoute la bonification du grade qui est égale à une augmentation de X0% par
    //rapport au salaire de base :
    //Ex : Grade 3 : 30% d'augmentation : 1000.0 de salaire avec grade 1 : 1100.0.
    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire*(1+(grade*0.1)));
    }

    //4.6. Redéfinir le getter de nbConges pour retourner le nombre de congés de base + autant
    //de congés que d'année d'ancienneté.
    @Override
    public Integer getNbConges () {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    //4.7. Modifier le code de la méthode getPrimeAnnuelle pour qu'elle renvoie la prime
    //annuelle de base à laquelle on ajoute un pourcentage en fonction du grade (idem exo 3.5)
    //ainsi que la prime d'ancienneté multipliée par le nombre d'année d'ancienneté.
    @Override
    public Double getPrimeAnnuelle() {
        Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
        Double primeGrade = primeAnnuelleBase * (1 + grade * 0.1);
        Double primeAnciennete = Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
        return primeAnnuelleBase + primeGrade + primeAnciennete;
    }
}
