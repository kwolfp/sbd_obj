package pl.edu.wat.entity;

import org.garret.perst.Persistent;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class Osoba extends Persistent {
   public String name;
   public String lastname;

    public Osoba(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
