package com.ipiecoles.java.java220;

// 3.1. Faire en sorte que la classe Commercial hérite de la classe Employé. Analyser le
//message d'erreur remonté par l'IDE et utiliser l'IDE pour résoudre le problème.

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe {
    private Double caAnnuel = 0d;
    private static final double PRIME_DEFAUT = 500d;
    private static final Double COEFF_PRIME = 0.05d;
    private Integer performance;
    // 3.2. Modifier la classe Commercial pour ajouter un attribut caAnnuel de type Double
    //avec son getter et son setter.

    public Commercial () {

    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }
    //3.3. Modifier la méthode getPrimeAnnuelle précédemment générée par l'IDE pour que la
    //prime soit égale à 5% du caAnnuel, avec un minimum de 500 € même en cas de chiffre
    //d'affaire nul. Faire en sorte que la prime soit toujours arrondi à l'euro supérieur (Voir la
    //classe Math)
    @Override
    public Double getPrimeAnnuelle() {
        if(caAnnuel == null){
            return PRIME_DEFAUT;
        }
            return Math.max(Math.ceil(this.getCaAnnuel()*COEFF_PRIME), PRIME_DEFAUT);
        }

    //3.4. Créer un constructeur pour la classe Commercial qui initialise tous les attributs
    //hérités de la classe Employe en faisant appel au constructeur d'Employe et qui initialise
    //également l'attribut caAnnuel.
    public Commercial (String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    //3.5. Redéfinir la méthode equals pour permettre de tester l'égalité entre deux instances de
    //la classe Commercial. Appeler la méthode equals de la classe Employe.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), caAnnuel, performance);
    }

    //3.6. Ajouter un attribut Integer performance. Ajouter une méthode performanceEgale
    //prenant un Integer en paramètre qui renvoie true si la performance du commercial est égale
    //à celle passée en paramètre, false sinon. (faire get, set, constructeur, equals et hashcode,

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Boolean performanceEgale (Integer performance) {
            return  Objects.equals(this.performance, performance);
    }

    //3.7. Créer un enum note avec les valeurs INSUFFISANT, PASSABLE, BIEN,
    //TRES_BIEN et créer une méthode equivalenceNote (sans utiliser de if) traduisant une
    //performance en Note :
    //a) Si performance = 0 ou 50 : INSUFFISANT
    //b) Si performance = 100 : PASSABLE
    //c) Si performance = 150 : BIEN
    //d) Si performance = 200 : TRES_BIEN
    // CRéer Enum comme une classe
    public Note equivalenceNote () {
        switch (this.performance) {
            case 0 :
            case 50 :
                return Note.INSUFFISANT;
            case 100 :
                return Note.PASSABLE;
            case 150 :
                return Note.BIEN;
            case 200 :
                return Note.TRES_BIEN;
            default:
                return null;
        }

    }


}
