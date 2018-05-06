package pl.edu.wat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.garret.perst.PinnedPersistent;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class Zrzeszenie extends PinnedPersistent {
    private String name;
    private String avatar;

    public void printInfo() {
        System.out.printf("Name: %s%nAvatar: %s%n", name, avatar);
    }
}
