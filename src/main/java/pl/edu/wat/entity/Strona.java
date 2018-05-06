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
public class Strona extends Zrzeszenie {

    private List<Osoba> followers;
    private String about;

    public Strona() {
        this.followers = new ArrayList<>();
    }

    public void addFollower(Osoba o) {
        this.followers.add(o);
        this.modify();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Followers:");
        for(Osoba o : followers) {
            System.out.printf(" > %s %s%n", o.getName(), o.getLastname());
        }
    }
}
