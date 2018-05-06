package pl.edu.wat;

import org.garret.perst.Database;
import org.garret.perst.IterableIterator;
import org.garret.perst.Persistent;
import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;
import pl.edu.wat.entity.Czat;
import pl.edu.wat.entity.Grupa;
import pl.edu.wat.entity.Osoba;
import pl.edu.wat.entity.Strona;
import pl.edu.wat.entity.Wiadomosc;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class Main extends Persistent {

    public static void main(String[] args) {
        Storage storage = StorageFactory.getInstance().createStorage();
        storage.open("sbd_obj.dbs");
        Database database = new Database(storage, true);

        System.out.println("Przed modyfikacją:");
        database.beginTransaction();
        IterableIterator<Grupa> groups = database.getRecords(Grupa.class);
        IterableIterator<Strona> strona = database.getRecords(Strona.class);
        for(Grupa g : groups) {
            g.printInfo();
        }
        for (Strona s : strona){
            s.printInfo();
        }
        database.commitTransaction();

        database.beginTransaction();
        Osoba o = database.<Osoba>select(Osoba.class, "name='Spencer' and lastname='Rudolph'").first();
        o.setName("Jan");
        o.modify();
        database.commitTransaction();

        System.out.println("Po modyfikacji:");
        database.beginTransaction();
        groups = database.getRecords(Grupa.class);
        for(Grupa g : groups) {
            g.printInfo();
        }
        for (Strona s : strona){
            s.printInfo();
        }
        database.commitTransaction();

        storage.close();
    }

}
