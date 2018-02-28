package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;

/**
 * Created by number on 17/09/15.
 */
public class Sector extends RealmObject {

    //   @PrimaryKey
    private int id;

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

    public Trainingschool getTrainingschool() {
        return trainingschool;
    }

    public void setTrainingschool(Trainingschool trainingschool) {
        this.trainingschool = trainingschool;
    }

    public Diplomatype getDiplomatype() {
        return diplomatype;
    }

    public void setDiplomatype(Diplomatype diplomatype) {
        this.diplomatype = diplomatype;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private Faculty faculty;
    private Institute institute;

    private Trainingschool trainingschool;
    private Diplomatype diplomatype;
    private Department department;
    private String name;
    private String opportunities;
    private String goal;
    private String admission;
    private String documentsrequired;

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

    public String getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(String opportunities) {
        this.opportunities = opportunities;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getDocumentsrequired() {
        return documentsrequired;
    }

    public void setDocumentsrequired(String documentsrequired) {
        this.documentsrequired = documentsrequired;
    }
}
