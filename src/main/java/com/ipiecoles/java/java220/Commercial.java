package com.ipiecoles.java.java220;

// 3.1. Faire en sorte que la classe Commercial hérite de la classe Employé. Analyser le
//message d'erreur remonté par l'IDE et utiliser l'IDE pour résoudre le problème.

public class Commercial extends Employe {
    // 3.2. Modifier la classe Commercial pour ajouter un attribut caAnnuel de type Double
    //avec son getter et son setter.
    private Double caAnnuel;

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        return null;
    }
}
