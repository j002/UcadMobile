package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Privateinfo extends RealmObject {
    //@PrimaryKey
    private int id;
    private Faculty faculty;
    private Institute institute;
    private Trainingschool school;
    private Detaileddiploma detaileddiploma;
    private Department department;
    private String monthlypayment;
    private String requiredlevel;
    private String moreinfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonthlypayment() {
        return monthlypayment;
    }

    public void setMonthlypayment(String monthlypayment) {
        this.monthlypayment = monthlypayment;
    }

    public String getRequiredlevel() {
        return requiredlevel;
    }

    public void setRequiredlevel(String requiredlevel) {
        this.requiredlevel = requiredlevel;
    }

    public String getMoreinfo() {
        return moreinfo;
    }

    public void setMoreinfo(String moreinfo) {
        this.moreinfo = moreinfo;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Trainingschool getSchool() {
        return school;
    }

    public void setSchool(Trainingschool school) {
        this.school = school;
    }

    public Detaileddiploma getDetaileddiploma() {
        return detaileddiploma;
    }

    public void setDetaileddiploma(Detaileddiploma detaileddiploma) {
        this.detaileddiploma = detaileddiploma;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
