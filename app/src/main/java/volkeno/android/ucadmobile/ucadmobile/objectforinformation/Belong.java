package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;

/**
 * Created by number on 17/09/15.
 */
public class Belong extends RealmObject {
    private Diplomatype diploma;
    private Department department;

    public Diplomatype getDiploma() {
        return diploma;
    }

    public void setDiploma(Diplomatype diploma) {
        this.diploma = diploma;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
