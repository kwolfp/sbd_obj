package pl.edu.wat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.garret.perst.Persistent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Czat extends Persistent {

    private String title;
    private List<Wiadomosc> messages;

    public Czat() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Osoba author, String content) {
        Wiadomosc msg = new Wiadomosc();
        msg.setAuthor(author);
        msg.setContent(content);
        msg.setDate(new Date());
        this.messages.add(msg);
        this.modify();
    }

    public void printConversation() {
        this.messages.sort(Comparator.comparing(Wiadomosc::getDate));
        for(Wiadomosc msg : this.messages) {
            System.out.printf("%s %s: %s%n", msg.getAuthor(), msg.getDate(), msg.getContent());
        }
    }

}
