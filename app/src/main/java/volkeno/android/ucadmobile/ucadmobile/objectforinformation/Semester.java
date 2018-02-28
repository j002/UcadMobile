package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Semester extends RealmObject {
    // @PrimaryKey
    private int id;
    private Diplomatype diplomatype;
    private String name;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Diplomatype getDiplomatype() {
        return diplomatype;
    }

    public void setDiplomatype(Diplomatype diplomatype) {
        this.diplomatype = diplomatype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
