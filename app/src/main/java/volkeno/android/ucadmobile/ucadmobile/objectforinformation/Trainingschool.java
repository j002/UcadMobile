package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Trainingschool extends RealmObject {
  //  @PrimaryKey
 private int id;
 private String name;
    private double latgeo;
    private double longgeo;
    private String description;

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

    public double getLatgeo() {
        return latgeo;
    }

    public void setLatgeo(double latgeo) {
        this.latgeo = latgeo;
    }

    public double getLonggeo() {
        return longgeo;
    }

    public void setLonggeo(double longgeo) {
        this.longgeo = longgeo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
