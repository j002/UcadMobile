package volkeno.android.ucadmobile.ucadmobile.objectforinformation;


import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Department  extends RealmObject {
  //  @PrimaryKey
    private int id;
    private Faculty faculty;
  //  @Ignore
    private Institute institute;
    //@Ignore
    private Trainingschool school;

    private String name;

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

}
