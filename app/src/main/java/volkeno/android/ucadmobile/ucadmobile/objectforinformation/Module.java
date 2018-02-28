package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Module extends RealmObject {
    // @PrimaryKey
    private int id;
    private Semester semester;
    private Diplomatype diploma;
    private Department department;
    private String name;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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
    public Diplomatype getDiploma() {
        return diploma;
    }

    public void setDiploma(Diplomatype diploma) {
        this.diploma = diploma;
    }
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
