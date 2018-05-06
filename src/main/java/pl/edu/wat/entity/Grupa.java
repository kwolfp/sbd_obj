package pl.edu.wat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Grupa extends Zrzeszenie {
    private List<Osoba> memebers;

    public Grupa() {
        this.memebers = new ArrayList<>();
    }

    public void addMember(Osoba osoba) {
        this.memebers.add(osoba);
        this.modify();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Memebers:");
        for(Osoba o : memebers) {
            System.out.printf(" > %s %s%n", o.getName(), o.getLastname());
        }
    }

}
