package volkeno.android.ucadmobile.ucadmobile.Db;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.test.AndroidTestCase;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Sector;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Subject;

/**
 * Created by number on 28/09/15.
 */
public class Insert extends FragmentActivity {



    public RealmResults <Faculty> SelectFaculty(Realm realm, Context context, RealmResults<Faculty> rst, String name)
    { realm = Realm.getInstance(context);
        if(name.equals("")) {

            rst = (realm.where(Faculty.class)
                    .findAll());
        }
        else{

            rst = (realm.where(Faculty.class)
                    .equalTo("name", name)
                    .findAll());
        }
        return rst;

    }
    public RealmResults <Institute> SelectInstitute(Realm realm, Context context, RealmResults<Institute> rst,String name)
    {
        realm=Realm.getInstance(context);
        if(name.equals("")){

            rst=(realm.where(Institute.class)
                    .findAll());
        }
        else{

            rst=(realm.where(Institute.class)
                    .equalTo("name", name)
                    .findAll());
        }
        return rst;

    }
    public RealmResults <Trainingschool> SelectTrainingSchool(Realm realm, Context context, RealmResults<Trainingschool> rst,String name)
    {
        realm = Realm.getInstance(context);

        if(name.equals("")) {
            rst = (realm.where(Trainingschool.class)
                    .findAll());
        }
        else
        {
            rst = (realm.where(Trainingschool.class)
                    .equalTo("name", name)
                    .findAll());
        }
        return rst;

    }
    public RealmResults <News> SelectInfos(Realm realm, Context context, RealmResults<News> rst,String name )
    {
        realm=Realm.getInstance(context);
        if(name.equals("")) {
            rst = (realm.where(News.class)
                    .findAll());
        }
        else {
            rst = (realm.where(News.class)
                    .equalTo("name", name)
                    .findAll());
        }
        return rst;

    }

    public RealmResults <Sector> SelectSector(Realm realm, Context context, RealmResults<Sector> rst)
    {
        realm=Realm.getInstance(context);
        rst=(realm.where(Sector.class)

                .findAll());
        return rst;

    }



    public RealmResults <Department> SelectDepartmenttype(Realm realm, Context context, RealmResults<Department> rst,String name)
    {
        realm=Realm.getInstance(context);
        rst=(realm.where(Department.class)
                .equalTo("name", name)
                .findAll());
        return rst;

    }
    public RealmResults<Newstype> SelectNewstype(Realm realm, Context context, RealmResults<Newstype> rst, String type)
    {
        realm= Realm.getInstance(context);
        rst=(realm.where(Newstype.class)
                .equalTo("name", type)
                .findAll());

        return rst;

    }
    public RealmResults <Department> SelectDepartment(Realm realm, Context context, RealmResults<Department> rst,String name)
    {
        realm=Realm.getInstance(context);

        rst=(realm.where(Department.class)
                .equalTo("faculty.name", name)
                .findAll());
        if(rst.isEmpty())
        {
            rst=(realm.where(Department.class)
                    .equalTo("institute.name", name)
                    .findAll());
            if(rst.isEmpty()){
                rst=(realm.where(Department.class)
                        .equalTo("school.name", name)
                        .findAll());
            }
        }
        return rst;

    }
    public RealmResults<Diplomatype> SelectDiplomatype(Realm realm, Context context, RealmResults<Diplomatype> rst, String name)
    {
        realm= Realm.getInstance(context);

        rst=(realm.where(Diplomatype.class)
                .equalTo("name",name)
                .findAll());

        return rst;

    }
    public RealmResults<Detaileddiploma> SelectDetaileddiploma(Realm realm, Context context, RealmResults<Detaileddiploma> rst, String name)
    {
        realm= Realm.getInstance(context);

        rst=(realm.where(Detaileddiploma.class)
                .equalTo("name",name)
                .findAll());


        return rst;

    }
    public RealmResults<Semester> SelectSemester(Realm realm, Context context, RealmResults<Semester> rst, String name)
    {
        realm= Realm.getInstance(context);

        rst=(realm.where(Semester.class)
                .equalTo("name", name)
                .findAll());


        return rst;

    }
    public RealmResults<Module> SelectModule(Realm realm, Context context, RealmResults<Module> rst, String name)
    {
        realm= Realm.getInstance(context);
        rst=(realm.where(Module.class)
                .equalTo("name", name)
                .findAll());
        return rst;

    }
    public RealmResults <Subject> SelectSubject(Realm realm, Context context, RealmResults<Subject> rst)
    {
        realm=Realm.getInstance(context);
        rst=(realm.where(Subject.class)
                .findAll());
        return rst;

    }
    public int InsertFaculty(Context context)
    {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Faculty Fac1 = realm.createObject(Faculty.class); // Create a new object
        Fac1.setName("Faculté de sciences et techniques");
        Fac1.setDescription("Description Contain " +
                "Faculté de sciences et techniques");
        Fac1.setLatgeo(14.684687);
        Fac1.setLonggeo(-17.464807);
        Fac1.setId(1);
        realm.commitTransaction();
        //F2
        realm.beginTransaction();
        Faculty Fac2 = realm.createObject(Faculty.class); // Create a new object
        Fac2.setName("Faculté de lettres et sciences humaines");
        Fac2.setDescription("Description Contain " +
                "Faculté de lettres et sciences humaines");
        Fac2.setLatgeo(14.686617);
        Fac2.setLonggeo(-17.463427);
        Fac2.setId(2);
        realm.commitTransaction();
        //F3
        realm.beginTransaction();
        Faculty Fac3 = realm.createObject(Faculty.class); // Create a new object
        Fac3.setName("Faculté de sciences juridiques et politique");
        Fac3.setDescription("Description Contain " +
                "Faculté de sciences juridiques et politique");
        Fac3.setLatgeo(14.687479);
        Fac3.setLonggeo(-17.463158);
        Fac3.setId(3);
        realm.commitTransaction();
        //F4
        realm.beginTransaction();
        Faculty Fac4 = realm.createObject(Faculty.class); // Create a new object
        Fac4.setName("Faculté de sciences économiques et de gestion");
        Fac4.setDescription("Description Contain " +
                "Faculté de sciences économiques et de gestion\"");
        Fac4.setLatgeo(14.690084);
        Fac4.setLonggeo(-17.467999);
        Fac4.setId(4);
        realm.commitTransaction();
        //F5
        realm.beginTransaction();
        Faculty Fac5 = realm.createObject(Faculty.class); // Create a new object
        Fac5.setName("Faculté des sciences et technologies de l'éducation et de la formation");
        Fac5.setLatgeo(14.699631);
        Fac5.setLonggeo(-17.466228);
        Fac5.setDescription(" La Nouvelle Faculté des Sciences et Technologies de l'Education " +
                "et de la Formation (FASTEF) a enclenché un processus de mutations fondamentales, " +
                "indispensable à la formation d'enseignants de type de l'éducation.");
        Fac5.setId(5);
        realm.commitTransaction();
        //F6
        realm.beginTransaction();
        Faculty Fac6 = realm.createObject(Faculty.class); // Create a new object
        Fac6.setName("Faculté de médecine, de pharmacie et d'odonto-stomatologie");
        Fac6.setLatgeo(14.686513);
        Fac6.setLonggeo(-17.466857);
        Fac6.setId(6);
        realm.commitTransaction();

        return 6;

    }
    public int InsertInstitute(Context context)
    {
        //
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Institute Ins1 = realm.createObject(Institute.class); // Create a new object
        Ins1.setName("Institut Fondamental d’Afrique Noire");
        Ins1.setLatgeo(14.683554);
        Ins1.setLonggeo(-17.467448);
        Ins1.setDescription("Description Contain" +
                "Institut Fondamental d’Afrique Noire");
        Ins1.setId(1);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins2 = realm.createObject(Institute.class); // Create a new object
        Ins2.setName("Bibliothéque universitaire");
        Ins2.setDescription("Description Contain" +
                "Bibliothéque universitaire");
        Ins2.setLatgeo(14.685672);
        Ins2.setLonggeo(-17.461955);
        Ins2.setId(2);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins3 = realm.createObject(Institute.class); // Create a new object
        Ins3.setName("Institut de Français pour les Etudiants Etrangers");
        Ins3.setDescription("Description Contain" +
                "Institut de Français pour les Etudiants Etrangers");
        Ins3.setLatgeo(14.684030);
        Ins3.setLonggeo(-17.465305);
        Ins3.setId(3);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins4 = realm.createObject(Institute.class); // Create a new object
        Ins4.setName("Institut de Recherches sur l’Enseignement de la Mathématique, de la Physique et de la Technologie");
        Ins4.setDescription("Description Contain" +
                "Institut de Recherches sur l’Enseignement de la Mathématique, de la Physique et de la Technologie");
        Ins4.setLatgeo(14.684030);
        Ins4.setLonggeo(-17.465305);
        Ins4.setId(4);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins5 = realm.createObject(Institute.class); // Create a new object
        Ins5.setName("Institut de Pédiatrie Sociale");
        Ins5.setDescription("Description Contain" +
                "Institut de Pédiatrie Sociale");
        Ins5.setLatgeo(14.687510);
        Ins5.setLonggeo(-17.463309);
        Ins5.setId(5);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins6 = realm.createObject(Institute.class); // Create a new object
        Ins6.setName("Institut des Sciences de l’Environnement");
        Ins6.setDescription("Description Contain" +
                "Institut des Sciences de l’Environnement");
        Ins6.setLatgeo(14.687510);
        Ins6.setLonggeo(-17.463309);
        Ins6.setId(6);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins7 = realm.createObject(Institute.class); // Create a new object
        Ins7.setName("Institut de formation et de recherche en Population Développement et Santé de la reproduction");
        Ins7.setDescription("Description Contain" +
                "Institut de formation et de recherche en Population Développement et Santé de la reproduction");
        Ins7.setLatgeo(14.687510);
        Ins7.setLonggeo(-17.463309);
        Ins7.setId(7);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins8 = realm.createObject(Institute.class); // Create a new object
        Ins8.setName("Centre de Linguistique Appliquée de Dakar");
        Ins8.setDescription("Description Contain" +
                "Centre de Linguistique Appliquée de Dakar");
        Ins8.setLatgeo(14.687510);
        Ins8.setLonggeo(-17.463309);
        Ins8.setId(8);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins9 = realm.createObject(Institute.class); // Create a new object
        Ins9.setName("Institut Universitaire de Pêche et d’Aquaculture");
        Ins9.setDescription("Description Contain");
        Ins9.setLatgeo(14.687510);
        Ins9.setLonggeo(-17.463309);
        Ins9.setId(9);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins10 = realm.createObject(Institute.class); // Create a new object
        Ins10.setName("Institut de Santé et Développement");
        Ins10.setDescription("Description Contain" +
                "Institut de Santé et Développement");
        Ins10.setLatgeo(14.687510);
        Ins10.setLonggeo(-17.463309);
        Ins10.setId(10);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins11 = realm.createObject(Institute.class); // Create a new object
        Ins11.setName("Centre d’Etudes et de Recherches sur les Energies Renouvelables");
        Ins11.setDescription("Description Contain" +
                "Centre d’Etudes et de Recherches sur les Energies Renouvelables");
        Ins11.setLatgeo(14.687510);
        Ins11.setLonggeo(-17.463309);
        Ins11.setId(11);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Institute Ins12 = realm.createObject(Institute.class); // Create a new object
        Ins12.setName("Institut des Droits de l'Homme et de la Paix");
        Ins12.setDescription("Description Contain" +
                "Institut des Droits de l'Homme et de la Paix");
        Ins12.setLatgeo(14.684030);
        Ins12.setLonggeo(-17.465305);
        Ins12.setId(12);
        realm.commitTransaction();

        return 12;

    }
    public int InsertTrainningschool(Context context)
    {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Trainingschool school1 = realm.createObject(Trainingschool.class); // Create a new object
        school1.setName("Centre d’Etudes des Sciences et Techniques de l’Information");
        school1.setLatgeo(14.689222);
        school1.setLonggeo(-17.460768);
        school1.setId(1);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Trainingschool school2 = realm.createObject(Trainingschool.class); // Create a new object
        school2.setName("Ecole Supérieure Polytechnique");
        school2.setLatgeo(14.682456);
        school2.setLonggeo(-17.466255);
        school2.setId(2);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Trainingschool school3 = realm.createObject(Trainingschool.class); // Create a new object
        school3.setName("Ecole des Bibliothécaires, Archivistes et Documentalistes");
        school3.setLatgeo(14.686359);
        school3.setLonggeo(-17.461816);
        school3.setId(3);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Trainingschool school4 = realm.createObject(Trainingschool.class); // Create a new object
        school4.setName("Ecole Normale Supérieure d’Enseignement Technique et Professionnel");
        school4.setLatgeo(14.678657);
        school4.setLonggeo(-17.465177);
        school4.setId(4);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Trainingschool school5 = realm.createObject(Trainingschool.class); // Create a new object
        school5.setName("Institut National Supérieur de l’Education Populaire et du Sport");
        school5.setLatgeo(14.680510);
        school5.setLonggeo(-17.446970);
        school5.setId(5);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Trainingschool school6 = realm.createObject(Trainingschool.class); // Create a new object
        school6.setName("Ecole Supérieure d'Economie Appliquée (ESEA - Ex ENEA)");
        school6.setLatgeo(14.704867);
        school6.setLonggeo(-17.478256);
        school6.setId(6);
        realm.commitTransaction();


        return 6;


    }
    public int InsertNews(Context context)
    {
        RealmResults<Newstype> rst;
        Realm realm = Realm.getInstance(context);
        //
        realm.beginTransaction();
        News New1 = realm.createObject(News.class);
        New1.setId(1);// Create a new object
        New1 .setContent("Institut Fondamental d’Afrique Noire");
        New1.setTittle("BASKET SENEGAL");
        RealmResults<Newstype> rst1=null;
        rst=SelectNewstype(realm, context, rst1, "SPORT");
        /*Newstype Newstype1 = realm.createObject(Newstype.class); // Create a new object
        Newstype1.setName("SPORT");
        Newstype1.setId(1);*/
        New1.setNewstype(rst.get(0));
        realm.commitTransaction();
        rst=null;
        //
        realm.beginTransaction();
        News New2 = realm.createObject(News.class); // Create a new object
        New2 .setId(2);
        New2.setContent("Institut Fondamental d’Afrique Noire");
        New2.setTittle("INNONDATION");
        rst=SelectNewstype(realm, context, rst1, "SOCIALE");
       /* Newstype Newstype2 = realm.createObject(Newstype.class); // Create a new object
        Newstype2.setName("SOCIALE");
        Newstype2.setId(2);*/
        New2.setNewstype(rst.get(0));
        realm.commitTransaction();
        rst=null;
        //
        realm.beginTransaction();
        News New3 = realm.createObject(News.class); // Create a new object
        New3 .setId(3);
        New3.setContent("Institut Fondamental d’Afrique Noire");
        New3.setTittle("MACKY SALL");
        rst=SelectNewstype(realm, context, rst1, "POLITIQUE");
       /* Newstype Newstype3 = realm.createObject(Newstype.class); // Create a new object
        Newstype3.setName("POLOTIQUE");
        Newstype3.setId(3);*/
        New3.setNewstype(rst.get(0));
        realm.commitTransaction();
        rst=null;

        return 3;


    }
    public void InsertNewsType(Context context)
    {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Newstype Newstype1 = realm.createObject(Newstype.class); // Create a new object
        Newstype1.setName("SPORT");
        Newstype1.setId(1);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Newstype Newstype2 = realm.createObject(Newstype.class); // Create a new object
        Newstype2.setName("SOCIALE");
        Newstype2.setId(2);
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Newstype Newstype3 = realm.createObject(Newstype.class); // Create a new object
        Newstype3.setName("POLITIQUE");
        Newstype3.setId(3);
        realm.commitTransaction();
    }
    public int InsertDepartment(Context context)
    {
        RealmResults<Faculty> rst;
        Realm realm = Realm.getInstance(context);
        //Faculté des sciences et technologies de l'éducation et de la formation
        RealmResults<Faculty> rst1=null;
        rst= SelectFaculty(realm, context, rst1, "Faculté des sciences et technologies de l'éducation et de la formation");
        //
        realm.beginTransaction();
        Department Department1 = realm.createObject(Department.class);
        Department1.setId(1);// Create a new object
        Department1 .setName("Didactique de l'anglais");
        Department1.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department2 = realm.createObject(Department.class);
        Department2.setId(2);// Create a new object
        Department2 .setName("Allemand");
        Department2.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department3 = realm.createObject(Department.class);
        Department3.setId(3);// Create a new object
        Department3 .setName("Arabe");
        Department3.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department4 = realm.createObject(Department.class);
        Department4.setId(4);// Create a new object
        Department4 .setName("Formation des inspecteurs");
        Department4.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department5 = realm.createObject(Department.class);
        Department5.setId(5);// Create a new object
        Department5 .setName("Histoire et géographie");
        Department5.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department6 = realm.createObject(Department.class);
        Department6.setId(6);// Create a new object
        Department6 .setName("Langues romanes");
        Department6.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department7 = realm.createObject(Department.class);
        Department7.setId(7);// Create a new object
        Department7 .setName("Langues slaves (russe)");
        Department7.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department8 = realm.createObject(Department.class);
        Department8.setId(8);// Create a new object
        Department8 .setName("Lettres classiques et modernes");
        Department8.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department9 = realm.createObject(Department.class);
        Department9.setId(9);// Create a new object
        Department9 .setName("Mathématiques");
        Department9.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department10 = realm.createObject(Department.class);
        Department10.setId(10);// Create a new object
        Department10 .setName("Philosophie");
        Department10.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department11 = realm.createObject(Department.class);
        Department11.setId(11);// Create a new object
        Department11 .setName("Physique Chimie");
        Department11.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department12 = realm.createObject(Department.class);
        Department12.setId(12);// Create a new object
        Department12 .setName("Psychopédagogie");
        Department12.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department13 = realm.createObject(Department.class);
        Department13.setId(13);// Create a new object
        Department13 .setName("Sciences de l'éducation");
        Department13.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department14 = realm.createObject(Department.class);
        Department14.setId(14);// Create a new object
        Department14 .setName("Sciences de la Vie et de la Terre");
        Department14.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department15 = realm.createObject(Department.class);
        Department15.setId(15);// Create a new object
        Department15 .setName("Technologies éducatives");
        Department15.setFaculty(rst.get(0));
        realm.commitTransaction();
        rst=null;

        //Faculté des sciences et technologies de l'éducation et de la formation
        rst= SelectFaculty(realm, context, rst1, "Faculté de sciences et techniques");
        //
        realm.beginTransaction();
        Department Department16 = realm.createObject(Department.class);
        Department16.setId(16);// Create a new object
        Department16 .setName("Mathématiques Informatique");
        Department16.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department17 = realm.createObject(Department.class);
        Department17.setId(17);// Create a new object
        Department17 .setName("Physique");
        Department17.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department18 = realm.createObject(Department.class);
        Department18.setId(18);// Create a new object
        Department18.setName("Chimie");
        Department18.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department19 = realm.createObject(Department.class);
        Department19.setId(19);// Create a new object
        Department19.setName("Biologie Animale");
        Department19.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department20 = realm.createObject(Department.class);
        Department20.setId(20);// Create a new object
        Department20.setName("Biologie Végétale");
        Department20.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department21 = realm.createObject(Department.class);
        Department21.setId(21);// Create a new object
        Department21.setName("Géologie");
        Department21.setFaculty(rst.get(0));
        realm.commitTransaction();

        rst=null;

        //Faculté de sciences juridiques et politique
        rst= SelectFaculty(realm, context, rst1, "Faculté de sciences juridiques et politique");
        //
        realm.beginTransaction();
        Department Department23 = realm.createObject(Department.class);
        Department23.setId(23);// Create a new object
        Department23 .setName("Droit privé");
        Department23.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department25 = realm.createObject(Department.class);
        Department25.setId(24);// Create a new object
        Department25 .setName("Droit public");
        Department25.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department26 = realm.createObject(Department.class);
        Department26.setId(25);// Create a new object
        Department26 .setName("Histoire du droit");
        Department26.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department27 = realm.createObject(Department.class);
        Department27.setId(26);// Create a new object
        Department27 .setName("Sciences politique");
        Department27.setFaculty(rst.get(0));
        realm.commitTransaction();

        rst=null;

        //Faculté de sciences juridiques et politique
        rst= SelectFaculty(realm, context, rst1, "Faculté de lettres et sciences humaines");
        //
        realm.beginTransaction();
        Department Department28 = realm.createObject(Department.class);
        Department28.setId(27);// Create a new object
        Department28 .setName("Allemand");
        Department28.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department29 = realm.createObject(Department.class);
        Department29.setId(28);// Create a new object
        Department29 .setName("Anglais");
        Department29.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department30 = realm.createObject(Department.class);
        Department30.setId(29);// Create a new object
        Department30 .setName("Arabe");
        Department30.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department31 = realm.createObject(Department.class);
        Department31.setId(30);// Create a new object
        Department31 .setName("Espagnol");
        Department31.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department32 = realm.createObject(Department.class);
        Department32.setId(31);// Create a new object
        Department32 .setName("Géographie");
        Department32.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department33 = realm.createObject(Department.class);
        Department33.setId(32);// Create a new object
        Department33 .setName("Histoire");
        Department33.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department34 = realm.createObject(Department.class);
        Department34.setId(33);// Create a new object
        Department34 .setName("Italien");
        Department34.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department35 = realm.createObject(Department.class);
        Department35.setId(34);// Create a new object
        Department35.setName("Portugais");
        Department35.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department36 = realm.createObject(Department.class);
        Department36.setId(35);// Create a new object
        Department36.setName("Lettres classiques");
        Department36.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department37 = realm.createObject(Department.class);
        Department37.setId(36);// Create a new object
        Department37.setName("Lettres Modernes");
        Department37.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department38 = realm.createObject(Department.class);
        Department38.setId(37);// Create a new object
        Department38.setName("Linguistique");
        Department38.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department39 = realm.createObject(Department.class);
        Department39.setId(38);// Create a new object
        Department39.setName("Persane");
        Department39.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department40 = realm.createObject(Department.class);
        Department40.setId(39);// Create a new object
        Department40.setName("Philosophie");
        Department40.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department41 = realm.createObject(Department.class);
        Department41.setId(40);// Create a new object
        Department41.setName("Russe");
        Department41.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department42 = realm.createObject(Department.class);
        Department42.setId(41);// Create a new object
        Department42.setName("Sociologie");
        Department42.setFaculty(rst.get(0));
        realm.commitTransaction();

        rst=null;
        //Faculté de médecine, de pharmacie et d'odonto-stomatologie
        rst= SelectFaculty(realm, context, rst1, "Faculté de médecine, de pharmacie et d'odonto-stomatologie");

        //
        realm.beginTransaction();
        Department Department43 = realm.createObject(Department.class);
        Department43.setId(42);// Create a new object
        Department43.setName("Echographie et Techniques ultrasonores");
        Department43.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department44 = realm.createObject(Department.class);
        Department44.setId(43);// Create a new object
        Department44.setName("ECHOGRAPHIE EN GYNECOLOGIE ET OBSTETRIQUE");
        Department44.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department45 = realm.createObject(Department.class);
        Department45.setId(44);// Create a new object
        Department45.setName("MEDECINE D'URGENCES");
        Department45.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department46 = realm.createObject(Department.class);
        Department46.setId(45);// Create a new object
        Department46.setName("Epileptologie");
        Department46.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department49 = realm.createObject(Department.class);
        Department49.setId(46);// Create a new object
        Department49.setName("Puériculture");
        Department49.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department50 = realm.createObject(Department.class);
        Department50.setId(47);// Create a new object
        Department50.setName("HERBORISTERIE MEDICINALE");
        Department50.setFaculty(rst.get(0));
        realm.commitTransaction();
        rst=null;
        //Faculté de sciences économiques et de gestion
        rst= SelectFaculty(realm, context, rst1, "Faculté de sciences économiques et de gestion");

        //
        realm.beginTransaction();
        Department Department51 = realm.createObject(Department.class);
        Department51.setId(48);// Create a new object
        Department51.setName("Finance et Comptabilité");
        Department51.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department52 = realm.createObject(Department.class);
        Department52.setId(49);// Create a new object
        Department52.setName("Marketing et Communication");
        Department52.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department53 = realm.createObject(Department.class);
        Department53.setId(50);// Create a new object
        Department53.setName("Banques et Institutions Financières");
        Department53.setFaculty(rst.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department54 = realm.createObject(Department.class);
        Department54.setId(51);// Create a new object
        Department54.setName("Sciences Economiques et Gestion");
        Department54.setFaculty(rst.get(0));
        realm.commitTransaction();

        //Insert Department for Institutes
        //With a new RealmResult

        RealmResults<Institute> rst3=null;
        RealmResults<Institute> rst4=null;

        //Institut Fondamental d’Afrique Noire
        rst3= SelectInstitute(realm, context, rst4, "Institut Fondamental d’Afrique Noire");
        //
        realm.beginTransaction();
        Department Department55 = realm.createObject(Department.class);
        Department55.setId(52);// Create a new object
        Department55 .setName("Didactique de l'anglais");
        Department55.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department56 = realm.createObject(Department.class);
        Department56.setId(53);// Create a new object
        Department56 .setName("Didactique de l'anglais");
        Department56.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut de Français pour les Etudiants Etrangers");
        //
        realm.beginTransaction();
        Department Department57 = realm.createObject(Department.class);
        Department57.setId(54);// Create a new object
        Department57 .setName("Didactique de l'anglais");
        Department57.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department58 = realm.createObject(Department.class);
        Department58.setId(55);// Create a new object
        Department58 .setName("Didactique de l'anglais");
        Department58.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut de Français pour les Etudiants Etrangers");
        //
        realm.beginTransaction();
        Department Department59 = realm.createObject(Department.class);
        Department59.setId(56);// Create a new object
        Department59 .setName("Didactique de l'anglais");
        Department59.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department60 = realm.createObject(Department.class);
        Department60.setId(57);// Create a new object
        Department60 .setName("Didactique de l'anglais");
        Department60.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut de Recherches sur l’Enseignement de la Mathématique, de la Physique et de la Technologie");
        //
        realm.beginTransaction();
        Department Department61 = realm.createObject(Department.class);
        Department61.setId(57);// Create a new object
        Department61 .setName("Didactique de l'anglais");
        Department61.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department62 = realm.createObject(Department.class);
        Department62.setId(58);// Create a new object
        Department62 .setName("Didactique de l'anglais");
        Department62.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut de Pédiatrie Sociale");
        //
        realm.beginTransaction();
        Department Department63 = realm.createObject(Department.class);
        Department63.setId(59);// Create a new object
        Department63 .setName("Didactique de l'anglais");
        Department63.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department64 = realm.createObject(Department.class);
        Department64.setId(59);// Create a new object
        Department64 .setName("Didactique de l'anglais");
        Department64.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut des Sciences de l’Environnement");
        realm.beginTransaction();
        Department Department65 = realm.createObject(Department.class);
        Department65.setId(60);// Create a new object
        Department65 .setName("Didactique de l'anglais");
        Department65.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department66 = realm.createObject(Department.class);
        Department66.setId(61);// Create a new object
        Department66 .setName("Didactique de l'anglais");
        Department66.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3=null;
        rst3= SelectInstitute(realm, context, rst4, "Institut de formation et de recherche en Population Développement et Santé de la reproduction");
        realm.beginTransaction();
        Department Department67 = realm.createObject(Department.class);
        Department67.setId(62);// Create a new object
        Department67 .setName("Didactique de l'anglais");
        Department67.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department68 = realm.createObject(Department.class);
        Department68.setId(63);// Create a new object
        Department68 .setName("Didactique de l'anglais");
        Department68.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Centre de Linguistique Appliquée de Dakar");
        realm.beginTransaction();
        Department Department69 = realm.createObject(Department.class);
        Department69.setId(64);// Create a new object
        Department69 .setName("Didactique de l'anglais");
        Department69.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department70 = realm.createObject(Department.class);
        Department70.setId(65);// Create a new object
        Department70 .setName("Didactique de l'anglais");
        Department70.setInstitute(rst3.get(0));
        realm.commitTransaction();
        rst3=null;
        //
        rst3= SelectInstitute(realm, context, rst4, "Institut Universitaire de Pêche et d’Aquaculture");
        //
        realm.beginTransaction();
        Department Department71 = realm.createObject(Department.class);
        Department71.setId(66);// Create a new object
        Department71 .setName("Didactique de l'anglais");
        Department71.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department72 = realm.createObject(Department.class);
        Department72.setId(67);// Create a new object
        Department72 .setName("Didactique de l'anglais");
        Department72.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3= SelectInstitute(realm, context, rst4, "Bibliothéque universitaire");
        //
        realm.beginTransaction();
        Department Department91= realm.createObject(Department.class);
        Department91.setId(86);// Create a new object
        Department91 .setName("Didactique de l'anglais");
        Department91.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department92 = realm.createObject(Department.class);
        Department92.setId(87);// Create a new object
        Department92 .setName("Didactique de l'anglais");
        Department92.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3=null;
        rst3= SelectInstitute(realm, context, rst4, "Institut de Santé et Développement");
        //
        realm.beginTransaction();
        Department Department73 = realm.createObject(Department.class);
        Department73.setId(68);// Create a new object
        Department73 .setName("Didactique de l'anglais");
        Department73.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department74 = realm.createObject(Department.class);
        Department74.setId(69);// Create a new object
        Department74 .setName("Didactique de l'anglais");
        Department74.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3=null;
        rst3= SelectInstitute(realm, context, rst4, "Centre d’Etudes et de Recherches sur les Energies Renouvelables");
        //
        realm.beginTransaction();
        Department Department75 = realm.createObject(Department.class);
        Department75.setId(70);// Create a new object
        Department75 .setName("Didactique de l'anglais");
        Department75.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department76 = realm.createObject(Department.class);
        Department76.setId(71);// Create a new object
        Department76 .setName("Didactique de l'anglais");
        Department76.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        rst3=null;
        rst3= SelectInstitute(realm, context, rst4, "Institut des Droits de l'Homme et de la Paix");
        //
        realm.beginTransaction();
        Department Department77 = realm.createObject(Department.class);
        Department77.setId(72);// Create a new object
        Department77 .setName("Didactique de l'anglais");
        Department77.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department78 = realm.createObject(Department.class);
        Department78.setId(73);// Create a new object
        Department78 .setName("Didactique de l'anglais");
        Department78.setInstitute(rst3.get(0));
        realm.commitTransaction();
        //
        //Insert Department for Training School
        //With a new RealmResult

        RealmResults<Trainingschool> rst5=null;
        RealmResults<Trainingschool> rst6=null;
        //
        rst5= SelectTrainingSchool(realm, context, rst6, "Centre d’Etudes des Sciences et Techniques de l’Information");
        //
        realm.beginTransaction();
        Department Department79 = realm.createObject(Department.class);
        Department79.setId(74);// Create a new object
        Department79 .setName("Didactique de l'anglais");
        Department79.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department80 = realm.createObject(Department.class);
        Department80.setId(75);// Create a new object
        Department80 .setName("Didactique de l'anglais");
        Department80.setSchool(rst5.get(0));
        realm.commitTransaction();

        //
        rst5=null;
        rst5= SelectTrainingSchool(realm, context, rst6, "Ecole des Bibliothécaires, Archivistes et Documentalistes");
        //
        realm.beginTransaction();
        Department Department81 = realm.createObject(Department.class);
        Department81.setId(76);// Create a new object
        Department81 .setName("Didactique de l'anglais");
        Department81.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department82 = realm.createObject(Department.class);
        Department82.setId(77);// Create a new object
        Department82 .setName("Didactique de l'anglais");
        Department82.setSchool(rst5.get(0));
        realm.commitTransaction();
        rst5=null;

        rst5= SelectTrainingSchool(realm, context, rst6, "Ecole Normale Supérieure d’Enseignement Technique et Professionnel");
        //
        realm.beginTransaction();
        Department Department83 = realm.createObject(Department.class);
        Department83.setId(78);// Create a new object
        Department83 .setName("Didactique de l'anglais");
        Department83.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department84 = realm.createObject(Department.class);
        Department84.setId(79);// Create a new object
        Department84 .setName("Didactique de l'anglais");
        Department84.setSchool(rst5.get(0));
        realm.commitTransaction();
        rst5=null;

        rst5= SelectTrainingSchool(realm, context, rst6, "Ecole Supérieure Polytechnique");
        //
        realm.beginTransaction();
        Department Department85 = realm.createObject(Department.class);
        Department85.setId(80);// Create a new object
        Department85 .setName("Didactique de l'anglais");
        Department85.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department86 = realm.createObject(Department.class);
        Department86.setId(81);// Create a new object
        Department86 .setName("Didactique de l'anglais");
        Department86.setSchool(rst5.get(0));
        realm.commitTransaction();

        rst5=null;

        rst5= SelectTrainingSchool(realm, context, rst6, "");
        //
        realm.beginTransaction();
        Department Department87 = realm.createObject(Department.class);
        Department87.setId(82);// Create a new object
        Department87 .setName("Didactique de l'anglais");
        Department87.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department88 = realm.createObject(Department.class);
        Department88.setId(83);// Create a new object
        Department88 .setName("Didactique de l'anglais");
        Department88.setSchool(rst5.get(0));
        realm.commitTransaction();
        rst5=null;
        //
        rst5= SelectTrainingSchool(realm, context, rst6, "Ecole Supérieure d'Economie Appliquée (ESEA - Ex ENEA)");
        //
        realm.beginTransaction();
        Department Department89 = realm.createObject(Department.class);
        Department89.setId(84);// Create a new object
        Department89 .setName("Didactique de l'anglais");
        Department89.setSchool(rst5.get(0));
        realm.commitTransaction();
        //
        realm.beginTransaction();
        Department Department90 = realm.createObject(Department.class);
        Department90.setId(85);// Create a new object
        Department90 .setName("Didactique de l'anglais");
        Department90.setSchool(rst5.get(0));
        realm.commitTransaction();

        return 87;
    }
    public int InsertSubject(Context context)
    {
        RealmResults<Diplomatype> rst;
        RealmResults<Detaileddiploma> rst2;
        RealmResults<Module> rst4;
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Subject Subject1 = realm.createObject(Subject.class); // Create a new object
        Subject1.setId(1);
        Subject1.setName("JAVA");
        Subject1.setHoursofcourses("10H");
        Subject1.setHoursofpraticalwork("20H");
        Subject1.setHoursoftutorials("30H");
        RealmResults<Diplomatype> rst1=null;
        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        Subject1.setDiploma(rst.get(0));
        RealmResults<Detaileddiploma> rst3 = null;
        rst2=SelectDetaileddiploma(realm, context, rst3, "LICENCE 1");
        Subject1.setDetaileddiploma(rst2.get(0));
        RealmResults<Module> rst5 = null;
        rst4=SelectModule(realm, context, rst5, "PROGRAMMATION");
        Subject1.setModule(rst4.get(0));
        realm.commitTransaction();
        rst=null;
        rst3=null;
        rst5=null;
        rst1=null;
//
        realm.beginTransaction();
        Subject Subject2 = realm.createObject(Subject.class); // Create a new object
        Subject2.setId(2);
        Subject2.setName("ANDROID");
        Subject2.setHoursofcourses("10H");
        Subject2.setHoursofpraticalwork("20H");
        Subject2.setHoursoftutorials("30H");

        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        Subject1.setDiploma(rst.get(0));

        rst2=SelectDetaileddiploma(realm, context, rst3, "LICENCE 1");
        Subject1.setDetaileddiploma(rst2.get(0));

        rst4=SelectModule(realm, context, rst5, "PROGRAMMATION");
        Subject1.setModule(rst4.get(0));
        realm.commitTransaction();
        return 2;
    }
    public int InsertDiplomatype(Context context)
    {
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Diplomatype diplomatype1 = realm.createObject(Diplomatype.class); // Create a new object
        diplomatype1.setId(1);
        diplomatype1.setName("LICENCE");

        realm.commitTransaction();
//
        realm.beginTransaction();
        Diplomatype diplomatype2 = realm.createObject(Diplomatype.class); // Create a new object
        diplomatype2.setId(2);
        diplomatype2.setName("MASTER");

        realm.commitTransaction();
//
        realm.beginTransaction();
        Diplomatype diplomatype3 = realm.createObject(Diplomatype.class); // Create a new object
        diplomatype3.setId(3);
        diplomatype3.setName("DOCTORAT");

        realm.commitTransaction();
        return 3;
    }
    public int InsertDetaileddiploma(Context context)
    {
        RealmResults<Diplomatype> rst;
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Detaileddiploma detaileddiploma1 = realm.createObject(Detaileddiploma.class); // Create a new object
        detaileddiploma1.setId(1);
        detaileddiploma1.setName("LICENCE 1");
        RealmResults<Diplomatype> rst1=null;
        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        detaileddiploma1.setDiploma(rst.get(0));
        realm.commitTransaction();
        rst=null;
        return 1;


    }
    public int InsertSemester(Context context)
    {
        RealmResults<Diplomatype> rst;
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Semester semester1 = realm.createObject(Semester.class); // Create a new object
        semester1.setId(1);
        semester1.setName("SEMESTER 1");
        RealmResults<Diplomatype> rst1=null;
        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        semester1.setDiplomatype(rst.get(0));
        realm.commitTransaction();
        rst=null;
        return 1;


    }
    public int InsertModule(Context context)
    {
        RealmResults<Diplomatype> rst;
        RealmResults<Semester> rst2;
        RealmResults<Department> rst3;
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        Module module1 = realm.createObject(Module.class); // Create a new object
        module1.setId(1);
        module1.setName("PROGRAMMATION");
        RealmResults<Diplomatype> rst1=null;
        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        module1.setDiploma(rst.get(0));
        RealmResults<Semester> rst4=null;
        rst2=SelectSemester(realm, context, rst4, "SEMESTER 1");
// module1.setSemester(rst2.get(0));
        RealmResults<Department> rst5=null;
        // rst3=SelectDepartement(realm, context, rst5, "SEMESTER 1");
// module1.setDepartment(rst3.get(0));
        realm.commitTransaction();
        rst=null;

        return 1;

    }
    public int InsertSector(Context context)
    {
        RealmResults<Diplomatype> rst;

        RealmResults<Trainingschool> rst4;

        RealmResults<Department> rst2;
        Realm realm = Realm.getInstance(context);
        //Mathématiques Informatique
        RealmResults<Department> rst3=null;
        rst2= SelectDepartmenttype(realm, context, rst3, "Mathématiques Informatique");

        realm.beginTransaction();
        Sector sector1 = realm.createObject(Sector.class); // Create a new object
        sector1.setId(1);
        sector1.setAdmission("admission");
        sector1.setDocumentsrequired("Documentsrequired");
        sector1.setGoal("goal");
        sector1.setName("INFORMATIQUE");
        sector1.setDepartment(rst2.get(0));
        RealmResults<Diplomatype> rst1=null;
        rst=SelectDiplomatype(realm, context, rst1, "LICENCE");
        sector1.setDiplomatype(rst.get(0));


        RealmResults<Trainingschool> rst5 = null;
        rst4=SelectTrainingSchool(realm, context, rst5, "Ecole Supérieure Polytechnique");
        sector1.setTrainingschool(rst4.get(0));
        realm.commitTransaction();
        rst=null;
        rst3=null;
        rst5=null;
        rst1=null;
//
        return 1;
}
}

