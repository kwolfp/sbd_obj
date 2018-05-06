package pl.edu.wat;

import org.garret.perst.Database;
import org.garret.perst.Storage;
import org.garret.perst.StorageFactory;
import pl.edu.wat.entity.Czat;
import pl.edu.wat.entity.Grupa;
import pl.edu.wat.entity.Osoba;
import pl.edu.wat.entity.Strona;
import pl.edu.wat.entity.Wiadomosc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kamil Przyborowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018.
 */
public class InsertDataMain {

    private Storage storage;
    private Database database;

    String pattern = "yyyy-MM-dd";
    SimpleDateFormat format = new SimpleDateFormat(pattern);


    public static void main(String[] args) throws ParseException {
        InsertDataMain insertDataMain = new InsertDataMain("sbd_obj");
        insertDataMain.insertDataAndClose();
    }

    private InsertDataMain(String dbName) {
        this.storage = StorageFactory.getInstance().createStorage();
        this.storage.open(dbName + ".dbs");
        this.database = new Database(storage, true);
    }

    private void closeDb() {
        if(this.storage != null) {
            this.storage.close();
        }
    }

    private void insertData(){
        this.insertOsoba();
        this.insertWiadomosc();
        this.insertGrupa();
        this.insertStrona();
    }

    private void insertDataAndClose(){
        this.insertData();
        this.closeDb();
    }

    private void insertOsoba() {
        insertOsoba("Caprice", "Hampshire");
        insertOsoba("Delcie", "Brecht");
        insertOsoba("Katia", "Grider");
        insertOsoba("Kaleigh", "Rochon");
        insertOsoba("Royal", "Overturf");
        insertOsoba("Sonia", "Eckles");
        insertOsoba("Ellan", "Mummert");
        insertOsoba("Candelaria", "Lubin");
        insertOsoba("Spencer", "Rudolph");
        insertOsoba("Teri", "Dinh");
        insertOsoba("Delphia", "Goins");
        insertOsoba("Rosella", "Magill");
        insertOsoba("Alfredia", "Bogar");
        insertOsoba("Bruna", "Aronson");
        insertOsoba("Derick", "Sponaugle");
        insertOsoba("Nick", "Kirwin");
        insertOsoba("Sherise", "Collelo");
        insertOsoba("Marvis", "Klosterman");
        insertOsoba("Keri", "Rolling");
        insertOsoba("Jan", "Hennessee");
        insertOsoba("John ", "Puccino");
        insertOsoba("Marek", "Puzyn");
        insertOsoba("John", "Brymer");
        insertOsoba("Anita", "Vardaman");
        insertOsoba("Anita", "Mohtashami");
        insertOsoba("Nick", "Talley");

    }

    private void insertOsoba(String name, String lastName) {
        database.beginTransaction();
        try {
            database.addRecord(new Osoba(name, lastName));
            database.commitTransaction();
        } catch (Exception x) {
            database.rollbackTransaction();
        }
    }

    private void insertGrupa() {
        database.beginTransaction();
        try {
            Grupa grupa = createGrupa("SBD OBJ", "https://api.adorable.io/avatars/285/sbd_obj.png", new Osoba[]{getOsobaByNameAndLastName("Ellan", "Mummert"),
                    getOsobaByNameAndLastName("Nick", "Lubin"),
                    getOsobaByNameAndLastName("Spencer", "Rudolph"),
                    getOsobaByNameAndLastName("Teri", "Dinh"),
                    getOsobaByNameAndLastName("Delphia", "Goins")});
            database.addRecord(grupa);
            database.commitTransaction();
        } catch (Exception x) {
            database.rollbackTransaction();
            x.printStackTrace();
        }
    }

    private Grupa createGrupa(String name, String avatar, Osoba[] memebers) {
        Grupa g = new Grupa();
        g.setName(name);
        g.setAvatar(avatar);
        g.getMemebers().addAll(Arrays.asList(memebers));
        return g;
    }
    private Wiadomosc createWiadomosc(String content, Date date, Osoba author){
        Wiadomosc w = new Wiadomosc();
        w.setContent(content);
        w.setDate(date);
        w.setAuthor(author);
        return w;
    }

    private void insertWiadomosc() {
        database.beginTransaction();
        try {
            Wiadomosc wiadomosc = createWiadomosc("CONTENT", format.parse("2008-02-02"), new Osoba(getOsobaByNameAndLastName("Nick","Lubin")));
            Wiadomosc wiadomosc2 = createWiadomosc("CONTENT NR. 2", format.parse("2011-08-22"), new Osoba(getOsobaByNameAndLastName("Delphia","Goins")));
            Wiadomosc wiadomosc3 = createWiadomosc("CONTENT NR. 3", format.parse("2011-05-12"), new Osoba(getOsobaByNameAndLastName("Teri","Dinh")));
            Wiadomosc wiadomosc4 = createWiadomosc("CONTENT NR. 4", format.parse("2012-12-07"), new Osoba(getOsobaByNameAndLastName("Katia","Grider")));
            Wiadomosc wiadomosc5 = createWiadomosc("CONTENT NR. 5", format.parse("2012-05-09"), new Osoba(getOsobaByNameAndLastName("Spencer","Rudolph")));
            database.addRecord(wiadomosc5);
            database.addRecord(wiadomosc4);
            database.addRecord(wiadomosc3);
            database.addRecord(wiadomosc2);
            database.addRecord(wiadomosc);
            database.commitTransaction();
        } catch (Exception x) {
            database.rollbackTransaction();
            x.printStackTrace();
        }
    }

    private Osoba getOsobaByNameAndLastName(String name, String lastName) {
        if(this.database == null) {
            return null;
        }
        return (Osoba) this.database.select(Osoba.class, "name='"+name+"' and lastname='"+lastName+"'").first();
    }

    private Strona createStrona(String about, Osoba[] followers){
        Strona s = new Strona();
        s.setAbout(about);
        s.getFollowers().addAll(Arrays.asList(followers));
        return s;
    }

    private void insertStrona() {
        database.beginTransaction();
        try {
            Strona strona = createStrona("Strona 1 SBD OBJ ", new Osoba[]{getOsobaByNameAndLastName("John", "Puccino")});
            database.addRecord(strona);
            database.commitTransaction();
        } catch (Exception x) {
            database.rollbackTransaction();
            x.printStackTrace();
        }
    }


}
