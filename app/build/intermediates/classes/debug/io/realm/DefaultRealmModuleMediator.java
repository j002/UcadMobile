package io.realm;


import android.util.JsonReader;
import io.realm.exceptions.RealmException;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Belong;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Privateinfo;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Sector;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Subject;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final List<Class<? extends RealmObject>> MODEL_CLASSES;
    static {
        List<Class<? extends RealmObject>> modelClasses = new ArrayList<Class<? extends RealmObject>>();
        modelClasses.add(News.class);
        modelClasses.add(Trainingschool.class);
        modelClasses.add(Department.class);
        modelClasses.add(Institute.class);
        modelClasses.add(Belong.class);
        modelClasses.add(Privateinfo.class);
        modelClasses.add(Semester.class);
        modelClasses.add(Diplomatype.class);
        modelClasses.add(Newstype.class);
        modelClasses.add(Sector.class);
        modelClasses.add(Subject.class);
        modelClasses.add(Module.class);
        modelClasses.add(Faculty.class);
        modelClasses.add(Detaileddiploma.class);
        MODEL_CLASSES = Collections.unmodifiableList(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return NewsRealmProxy.initTable(transaction);
        } else if (clazz.equals(Trainingschool.class)) {
            return TrainingschoolRealmProxy.initTable(transaction);
        } else if (clazz.equals(Department.class)) {
            return DepartmentRealmProxy.initTable(transaction);
        } else if (clazz.equals(Institute.class)) {
            return InstituteRealmProxy.initTable(transaction);
        } else if (clazz.equals(Belong.class)) {
            return BelongRealmProxy.initTable(transaction);
        } else if (clazz.equals(Privateinfo.class)) {
            return PrivateinfoRealmProxy.initTable(transaction);
        } else if (clazz.equals(Semester.class)) {
            return SemesterRealmProxy.initTable(transaction);
        } else if (clazz.equals(Diplomatype.class)) {
            return DiplomatypeRealmProxy.initTable(transaction);
        } else if (clazz.equals(Newstype.class)) {
            return NewstypeRealmProxy.initTable(transaction);
        } else if (clazz.equals(Sector.class)) {
            return SectorRealmProxy.initTable(transaction);
        } else if (clazz.equals(Subject.class)) {
            return SubjectRealmProxy.initTable(transaction);
        } else if (clazz.equals(Module.class)) {
            return ModuleRealmProxy.initTable(transaction);
        } else if (clazz.equals(Faculty.class)) {
            return FacultyRealmProxy.initTable(transaction);
        } else if (clazz.equals(Detaileddiploma.class)) {
            return DetaileddiplomaRealmProxy.initTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void validateTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            NewsRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Trainingschool.class)) {
            TrainingschoolRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Department.class)) {
            DepartmentRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Institute.class)) {
            InstituteRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Belong.class)) {
            BelongRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Privateinfo.class)) {
            PrivateinfoRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Semester.class)) {
            SemesterRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Diplomatype.class)) {
            DiplomatypeRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Newstype.class)) {
            NewstypeRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Sector.class)) {
            SectorRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Subject.class)) {
            SubjectRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Module.class)) {
            ModuleRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Faculty.class)) {
            FacultyRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Detaileddiploma.class)) {
            DetaileddiplomaRealmProxy.validateTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return NewsRealmProxy.getFieldNames();
        } else if (clazz.equals(Trainingschool.class)) {
            return TrainingschoolRealmProxy.getFieldNames();
        } else if (clazz.equals(Department.class)) {
            return DepartmentRealmProxy.getFieldNames();
        } else if (clazz.equals(Institute.class)) {
            return InstituteRealmProxy.getFieldNames();
        } else if (clazz.equals(Belong.class)) {
            return BelongRealmProxy.getFieldNames();
        } else if (clazz.equals(Privateinfo.class)) {
            return PrivateinfoRealmProxy.getFieldNames();
        } else if (clazz.equals(Semester.class)) {
            return SemesterRealmProxy.getFieldNames();
        } else if (clazz.equals(Diplomatype.class)) {
            return DiplomatypeRealmProxy.getFieldNames();
        } else if (clazz.equals(Newstype.class)) {
            return NewstypeRealmProxy.getFieldNames();
        } else if (clazz.equals(Sector.class)) {
            return SectorRealmProxy.getFieldNames();
        } else if (clazz.equals(Subject.class)) {
            return SubjectRealmProxy.getFieldNames();
        } else if (clazz.equals(Module.class)) {
            return ModuleRealmProxy.getFieldNames();
        } else if (clazz.equals(Faculty.class)) {
            return FacultyRealmProxy.getFieldNames();
        } else if (clazz.equals(Detaileddiploma.class)) {
            return DetaileddiplomaRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return NewsRealmProxy.getTableName();
        } else if (clazz.equals(Trainingschool.class)) {
            return TrainingschoolRealmProxy.getTableName();
        } else if (clazz.equals(Department.class)) {
            return DepartmentRealmProxy.getTableName();
        } else if (clazz.equals(Institute.class)) {
            return InstituteRealmProxy.getTableName();
        } else if (clazz.equals(Belong.class)) {
            return BelongRealmProxy.getTableName();
        } else if (clazz.equals(Privateinfo.class)) {
            return PrivateinfoRealmProxy.getTableName();
        } else if (clazz.equals(Semester.class)) {
            return SemesterRealmProxy.getTableName();
        } else if (clazz.equals(Diplomatype.class)) {
            return DiplomatypeRealmProxy.getTableName();
        } else if (clazz.equals(Newstype.class)) {
            return NewstypeRealmProxy.getTableName();
        } else if (clazz.equals(Sector.class)) {
            return SectorRealmProxy.getTableName();
        } else if (clazz.equals(Subject.class)) {
            return SubjectRealmProxy.getTableName();
        } else if (clazz.equals(Module.class)) {
            return ModuleRealmProxy.getTableName();
        } else if (clazz.equals(Faculty.class)) {
            return FacultyRealmProxy.getTableName();
        } else if (clazz.equals(Detaileddiploma.class)) {
            return DetaileddiplomaRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E newInstance(Class<E> clazz) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return clazz.cast(new NewsRealmProxy());
        } else if (clazz.equals(Trainingschool.class)) {
            return clazz.cast(new TrainingschoolRealmProxy());
        } else if (clazz.equals(Department.class)) {
            return clazz.cast(new DepartmentRealmProxy());
        } else if (clazz.equals(Institute.class)) {
            return clazz.cast(new InstituteRealmProxy());
        } else if (clazz.equals(Belong.class)) {
            return clazz.cast(new BelongRealmProxy());
        } else if (clazz.equals(Privateinfo.class)) {
            return clazz.cast(new PrivateinfoRealmProxy());
        } else if (clazz.equals(Semester.class)) {
            return clazz.cast(new SemesterRealmProxy());
        } else if (clazz.equals(Diplomatype.class)) {
            return clazz.cast(new DiplomatypeRealmProxy());
        } else if (clazz.equals(Newstype.class)) {
            return clazz.cast(new NewstypeRealmProxy());
        } else if (clazz.equals(Sector.class)) {
            return clazz.cast(new SectorRealmProxy());
        } else if (clazz.equals(Subject.class)) {
            return clazz.cast(new SubjectRealmProxy());
        } else if (clazz.equals(Module.class)) {
            return clazz.cast(new ModuleRealmProxy());
        } else if (clazz.equals(Faculty.class)) {
            return clazz.cast(new FacultyRealmProxy());
        } else if (clazz.equals(Detaileddiploma.class)) {
            return clazz.cast(new DetaileddiplomaRealmProxy());
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<Class<? extends RealmObject>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public Map<String, Long> getColumnIndices(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return NewsRealmProxy.getColumnIndices();
        } else if (clazz.equals(Trainingschool.class)) {
            return TrainingschoolRealmProxy.getColumnIndices();
        } else if (clazz.equals(Department.class)) {
            return DepartmentRealmProxy.getColumnIndices();
        } else if (clazz.equals(Institute.class)) {
            return InstituteRealmProxy.getColumnIndices();
        } else if (clazz.equals(Belong.class)) {
            return BelongRealmProxy.getColumnIndices();
        } else if (clazz.equals(Privateinfo.class)) {
            return PrivateinfoRealmProxy.getColumnIndices();
        } else if (clazz.equals(Semester.class)) {
            return SemesterRealmProxy.getColumnIndices();
        } else if (clazz.equals(Diplomatype.class)) {
            return DiplomatypeRealmProxy.getColumnIndices();
        } else if (clazz.equals(Newstype.class)) {
            return NewstypeRealmProxy.getColumnIndices();
        } else if (clazz.equals(Sector.class)) {
            return SectorRealmProxy.getColumnIndices();
        } else if (clazz.equals(Subject.class)) {
            return SubjectRealmProxy.getColumnIndices();
        } else if (clazz.equals(Module.class)) {
            return ModuleRealmProxy.getColumnIndices();
        } else if (clazz.equals(Faculty.class)) {
            return FacultyRealmProxy.getColumnIndices();
        } else if (clazz.equals(Detaileddiploma.class)) {
            return DetaileddiplomaRealmProxy.getColumnIndices();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmObject, RealmObjectProxy> cache) {
        // This cast is correct because obj is either 
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(News.class)) {
            return clazz.cast(NewsRealmProxy.copyOrUpdate(realm, (News) obj, update, cache));
        } else if (clazz.equals(Trainingschool.class)) {
            return clazz.cast(TrainingschoolRealmProxy.copyOrUpdate(realm, (Trainingschool) obj, update, cache));
        } else if (clazz.equals(Department.class)) {
            return clazz.cast(DepartmentRealmProxy.copyOrUpdate(realm, (Department) obj, update, cache));
        } else if (clazz.equals(Institute.class)) {
            return clazz.cast(InstituteRealmProxy.copyOrUpdate(realm, (Institute) obj, update, cache));
        } else if (clazz.equals(Belong.class)) {
            return clazz.cast(BelongRealmProxy.copyOrUpdate(realm, (Belong) obj, update, cache));
        } else if (clazz.equals(Privateinfo.class)) {
            return clazz.cast(PrivateinfoRealmProxy.copyOrUpdate(realm, (Privateinfo) obj, update, cache));
        } else if (clazz.equals(Semester.class)) {
            return clazz.cast(SemesterRealmProxy.copyOrUpdate(realm, (Semester) obj, update, cache));
        } else if (clazz.equals(Diplomatype.class)) {
            return clazz.cast(DiplomatypeRealmProxy.copyOrUpdate(realm, (Diplomatype) obj, update, cache));
        } else if (clazz.equals(Newstype.class)) {
            return clazz.cast(NewstypeRealmProxy.copyOrUpdate(realm, (Newstype) obj, update, cache));
        } else if (clazz.equals(Sector.class)) {
            return clazz.cast(SectorRealmProxy.copyOrUpdate(realm, (Sector) obj, update, cache));
        } else if (clazz.equals(Subject.class)) {
            return clazz.cast(SubjectRealmProxy.copyOrUpdate(realm, (Subject) obj, update, cache));
        } else if (clazz.equals(Module.class)) {
            return clazz.cast(ModuleRealmProxy.copyOrUpdate(realm, (Module) obj, update, cache));
        } else if (clazz.equals(Faculty.class)) {
            return clazz.cast(FacultyRealmProxy.copyOrUpdate(realm, (Faculty) obj, update, cache));
        } else if (clazz.equals(Detaileddiploma.class)) {
            return clazz.cast(DetaileddiplomaRealmProxy.copyOrUpdate(realm, (Detaileddiploma) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return clazz.cast(NewsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Trainingschool.class)) {
            return clazz.cast(TrainingschoolRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Department.class)) {
            return clazz.cast(DepartmentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Institute.class)) {
            return clazz.cast(InstituteRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Belong.class)) {
            return clazz.cast(BelongRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Privateinfo.class)) {
            return clazz.cast(PrivateinfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Semester.class)) {
            return clazz.cast(SemesterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Diplomatype.class)) {
            return clazz.cast(DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Newstype.class)) {
            return clazz.cast(NewstypeRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Sector.class)) {
            return clazz.cast(SectorRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Subject.class)) {
            return clazz.cast(SubjectRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Module.class)) {
            return clazz.cast(ModuleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Faculty.class)) {
            return clazz.cast(FacultyRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Detaileddiploma.class)) {
            return clazz.cast(DetaileddiplomaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(News.class)) {
            return clazz.cast(NewsRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Trainingschool.class)) {
            return clazz.cast(TrainingschoolRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Department.class)) {
            return clazz.cast(DepartmentRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Institute.class)) {
            return clazz.cast(InstituteRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Belong.class)) {
            return clazz.cast(BelongRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Privateinfo.class)) {
            return clazz.cast(PrivateinfoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Semester.class)) {
            return clazz.cast(SemesterRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Diplomatype.class)) {
            return clazz.cast(DiplomatypeRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Newstype.class)) {
            return clazz.cast(NewstypeRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Sector.class)) {
            return clazz.cast(SectorRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Subject.class)) {
            return clazz.cast(SubjectRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Module.class)) {
            return clazz.cast(ModuleRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Faculty.class)) {
            return clazz.cast(FacultyRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Detaileddiploma.class)) {
            return clazz.cast(DetaileddiplomaRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
