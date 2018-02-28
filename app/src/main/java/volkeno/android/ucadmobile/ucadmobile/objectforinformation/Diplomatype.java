package volkeno.android.ucadmobile.ucadmobile.objectforinformation;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class Diplomatype extends RealmObject {
 // @PrimaryKey
 private int id;
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
}
