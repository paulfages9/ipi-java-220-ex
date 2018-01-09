package com.ipiecoles.java.java220;

import java.util.HashSet;

public class Manager extends Employe {
    //5.2. Modifier la classe Manager pour ajouter un attribut equipe permettant de stocker un
    //ensemble non ordonné de techniciens avec son getter et son setter

    private HashSet <Technicien> equipe = new HashSet<>();

    public HashSet <Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }
    //5.5. Modifier le code de la méthode getPrimeAnnuelle pour qu'elle renvoie la prime de
    //base, à laquelle on ajoute la prime du manager en fonction du nombre de membres de son
    //équipe (en utilisant Entreprise.PRIME_MANAGER_PAR_TECHNICIEN).
    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + Entreprise.PRIME_MANAGER_PAR_TECHNICIEN*equipe.size();
    }

    //5.3. Ajouter une méthode ajoutTechnicienEquipe qui prend en paramètre un technicien et
    //qui l'ajoute dans l'équipe

    public void ajoutTechnicienEquipe (Technicien t) {
       equipe.add(t);
    }

    //5.4. Redéfinir le setter de l'attribut salaire pour qu'il renvoie la valeur du salaire
    //multipliée par l'indice manager (en utilisant Entreprise.INDICE_MANAGER), auquel on
    //ajoute 10% (sur le salaire passé en paramètre) par membre d'équipe

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire*Entreprise.INDICE_MANAGER + salaire*(0.1*equipe.size()));
    }
}
