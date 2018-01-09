package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Commercial c = new Commercial("Fages","Paul","110", LocalDate.now(),1500d,100000d, 100);

        System.out.println(c.getPrenom() +" "+ c.getNom() +" a une prime annuelle de "+ c.getPrimeAnnuelle());
        System.out.println(c.equivalenceNote());
    }

}
