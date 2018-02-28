package volkeno.android.ucadmobile.ucadmobile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Sector;

/**
 * Created by prince on 10/5/15.
 */
public class Operation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addinfo() {
        try {
            Realm real = Realm.getInstance(getApplicationContext());
            real.beginTransaction();
            News new1 = real.createObject(News.class); // Create a new object
            new1.setTittle("Actu1");
            new1.setContent("test pour le contenu de l'actualite bla bla bla");
            new1.setDate("22/09/2015");
            new1.setId(1);
            real.commitTransaction();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public News voir(String name,Context context) {
        News n = new News();
        try {
            Realm realm = Realm.getInstance(context);
            RealmResults<News> result = realm.where(News.class)
                        .equalTo("tittle", name)
                        .findAll();
            n = (News) result.first();
            //n =  query.findFirst();
        } catch (Exception e) {
           e.printStackTrace();
          Toast.makeText(context, "guissoul", Toast.LENGTH_LONG).show();
        }
        return n;

    }

    public void addsector(Context context) {
        try {
            //dougal de departement
            Realm rel = Realm.getInstance(context);
            rel.beginTransaction();

            Department dp = rel.createObject(Department.class); // Create a new object
            dp.setId(2);
            dp.setName("dep3");
            rel.commitTransaction();
            Toast.makeText(context, "Departement in", Toast.LENGTH_LONG).show();

            //dougal filiere 1
            Realm real = Realm.getInstance(context);
            real.beginTransaction();
            Sector sec1 = real.createObject(Sector.class); // Create a new object
            sec1.setId(1);
            sec1.setAdmission("admission");
            sec1.setDocumentsrequired("Documentsrequired");
            sec1.setGoal("goal");
            sec1.setName("filiere 4");
            sec1.setDepartment(dp);
            real.commitTransaction();
            Toast.makeText(context, "sector in", Toast.LENGTH_LONG).show();

            //dougal filiere 2
            Realm r = Realm.getInstance(context);
            real.beginTransaction();
            Sector s = r.createObject(Sector.class); // Create a new object
            s.setId(1);
            s.setAdmission("admission");
            s.setDocumentsrequired("Documentsrequired");
            s.setGoal("goal");
            s.setName("filiere 3");
            s.setDepartment(dp);
            r.commitTransaction();
            Toast.makeText(context, "sector in", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "sector not in", Toast.LENGTH_LONG).show();
        }
    }

    public void voir_fil(Context context,ListView lv) {
        try {

            Realm realm = Realm.getInstance(context);

            Sector f = new Sector();
            Vector<String> values = new Vector<>();


            //Toast.makeText(this, "av number", Toast.LENGTH_LONG).show();
            RealmResults<Sector> result = realm.where(Sector.class)
                    .equalTo("iddepartment.name", "dep3")
                    .findAll();

            int number = result.size();//kham niatta filiere gno neik si departement bignou choisir


            Toast.makeText(context, "ba fi ok", Toast.LENGTH_LONG).show();

            for (int i = 0; i < number; i++) {
                values.add(result.get(i).getName());
                //f=result.get(i);
                //ad.add(result.get(i).getName());
            }//recuperer one by one filiere yi defko si adapter bi
            Toast.makeText(context, "adapter ok", Toast.LENGTH_LONG).show();
            ArrayAdapter<String> ad = new ArrayAdapter<String>(context,
                    android.R.layout.simple_list_item_1, android.R.id.text1, values);//diema recuperer les noms des filieres issues des resultats pour defko si gried view bi
            lv.setAdapter(ad);//diemko dougal si griedview bi

            Toast.makeText(context, "guiss na filiere", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "guissoul filiere", Toast.LENGTH_LONG).show();
        }

    }
}

