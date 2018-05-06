package pl.edu.wat.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class Grupa extends Zrzeszenie {
    public List<Osoba> memebers;

    public Grupa() {
        this.memebers = new ArrayList<Osoba>();
    }

}
