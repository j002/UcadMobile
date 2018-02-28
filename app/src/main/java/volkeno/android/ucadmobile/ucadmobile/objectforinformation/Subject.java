package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Subject extends RealmObject {
    // @PrimaryKey
    private int id;
    private Diplomatype diploma;
    private Detaileddiploma detaileddiploma;
    private Module module;
    private String name;
    private String hoursoftutorials;
    private String hoursofpraticalwork;
    private String hoursofcourses;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHoursoftutorials() {
        return hoursoftutorials;
    }

    public void setHoursoftutorials(String hoursoftutorials) {
        this.hoursoftutorials = hoursoftutorials;
    }

    public String getHoursofpraticalwork() {
        return hoursofpraticalwork;
    }

    public void setHoursofpraticalwork(String hoursofpraticalwork) {
        this.hoursofpraticalwork = hoursofpraticalwork;
    }

    public String getHoursofcourses() {
        return hoursofcourses;
    }

    public void setHoursofcourses(String hoursofcourses) {
        this.hoursofcourses = hoursofcourses;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Diplomatype getDiploma() {
        return diploma;
    }

    public void setDiploma(Diplomatype diploma) {
        this.diploma = diploma;
    }

    public Detaileddiploma getDetaileddiploma() {
        return detaileddiploma;
    }

    public void setDetaileddiploma(Detaileddiploma detaileddiploma) {
        this.detaileddiploma = detaileddiploma;
    }


}
