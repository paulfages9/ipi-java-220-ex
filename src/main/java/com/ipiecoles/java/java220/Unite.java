package com.ipiecoles.java.java220;



import java.util.HashSet;

public class Unite <T> {
    private T responsable;
    private HashSet <T> membres = new HashSet<>();

    public Unite(T responsable) {
    }

    public Unite(T responsable, HashSet<T> membre) {
        this.responsable = responsable;
        this.membre = membre;
    }

    public T getResponsable() {
        return responsable;
    }

    public void setResponsable(T responsable) {
        this.responsable = responsable;
    }

    public HashSet<T> getMembre() {
        return membre;
    }

    public void setMembre(HashSet<T> membre) {
        this.membre = membre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Unite{");
        sb.append("responsable=").append(responsable);
        sb.append(", membre=").append(membre);
        sb.append('}');
        return sb.toString();
    }

    //Ajouter une méthode ajouterMembre qui peut prendre autant de type générique que l'on veut
    //Générer une méthode toString
     void ajouterMembre (T...membres) {
        for (T membre : membres) {
            this.membres.add(membre);
         }
     }
}
