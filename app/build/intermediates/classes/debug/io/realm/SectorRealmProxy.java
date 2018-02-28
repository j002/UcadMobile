package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Sector;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool;

public class SectorRealmProxy extends Sector
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_FACULTY;
    private static long INDEX_INSTITUTE;
    private static long INDEX_TRAININGSCHOOL;
    private static long INDEX_DIPLOMATYPE;
    private static long INDEX_DEPARTMENT;
    private static long INDEX_NAME;
    private static long INDEX_OPPORTUNITIES;
    private static long INDEX_GOAL;
    private static long INDEX_ADMISSION;
    private static long INDEX_DOCUMENTSREQUIRED;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("faculty");
        fieldNames.add("institute");
        fieldNames.add("trainingschool");
        fieldNames.add("diplomatype");
        fieldNames.add("department");
        fieldNames.add("name");
        fieldNames.add("opportunities");
        fieldNames.add("goal");
        fieldNames.add("admission");
        fieldNames.add("documentsrequired");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public int getId() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_ID);
    }

    @Override
    public void setId(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_ID, (long) value);
    }

    @Override
    public Faculty getFaculty() {
        if (row.isNullLink(INDEX_FACULTY)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty.class, row.getLink(INDEX_FACULTY));
    }

    @Override
    public void setFaculty(Faculty value) {
        if (value == null) {
            row.nullifyLink(INDEX_FACULTY);
            return;
        }
        row.setLink(INDEX_FACULTY, value.row.getIndex());
    }

    @Override
    public Institute getInstitute() {
        if (row.isNullLink(INDEX_INSTITUTE)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute.class, row.getLink(INDEX_INSTITUTE));
    }

    @Override
    public void setInstitute(Institute value) {
        if (value == null) {
            row.nullifyLink(INDEX_INSTITUTE);
            return;
        }
        row.setLink(INDEX_INSTITUTE, value.row.getIndex());
    }

    @Override
    public Trainingschool getTrainingschool() {
        if (row.isNullLink(INDEX_TRAININGSCHOOL)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool.class, row.getLink(INDEX_TRAININGSCHOOL));
    }

    @Override
    public void setTrainingschool(Trainingschool value) {
        if (value == null) {
            row.nullifyLink(INDEX_TRAININGSCHOOL);
            return;
        }
        row.setLink(INDEX_TRAININGSCHOOL, value.row.getIndex());
    }

    @Override
    public Diplomatype getDiplomatype() {
        if (row.isNullLink(INDEX_DIPLOMATYPE)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype.class, row.getLink(INDEX_DIPLOMATYPE));
    }

    @Override
    public void setDiplomatype(Diplomatype value) {
        if (value == null) {
            row.nullifyLink(INDEX_DIPLOMATYPE);
            return;
        }
        row.setLink(INDEX_DIPLOMATYPE, value.row.getIndex());
    }

    @Override
    public Department getDepartment() {
        if (row.isNullLink(INDEX_DEPARTMENT)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department.class, row.getLink(INDEX_DEPARTMENT));
    }

    @Override
    public void setDepartment(Department value) {
        if (value == null) {
            row.nullifyLink(INDEX_DEPARTMENT);
            return;
        }
        row.setLink(INDEX_DEPARTMENT, value.row.getIndex());
    }

    @Override
    public String getName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_NAME);
    }

    @Override
    public void setName(String value) {
        realm.checkIfValid();
        row.setString(INDEX_NAME, (String) value);
    }

    @Override
    public String getOpportunities() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_OPPORTUNITIES);
    }

    @Override
    public void setOpportunities(String value) {
        realm.checkIfValid();
        row.setString(INDEX_OPPORTUNITIES, (String) value);
    }

    @Override
    public String getGoal() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_GOAL);
    }

    @Override
    public void setGoal(String value) {
        realm.checkIfValid();
        row.setString(INDEX_GOAL, (String) value);
    }

    @Override
    public String getAdmission() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ADMISSION);
    }

    @Override
    public void setAdmission(String value) {
        realm.checkIfValid();
        row.setString(INDEX_ADMISSION, (String) value);
    }

    @Override
    public String getDocumentsrequired() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DOCUMENTSREQUIRED);
    }

    @Override
    public void setDocumentsrequired(String value) {
        realm.checkIfValid();
        row.setString(INDEX_DOCUMENTSREQUIRED, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Sector")) {
            Table table = transaction.getTable("class_Sector");
            table.addColumn(ColumnType.INTEGER, "id");
            if (!transaction.hasTable("class_Faculty")) {
                FacultyRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "faculty", transaction.getTable("class_Faculty"));
            if (!transaction.hasTable("class_Institute")) {
                InstituteRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "institute", transaction.getTable("class_Institute"));
            if (!transaction.hasTable("class_Trainingschool")) {
                TrainingschoolRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "trainingschool", transaction.getTable("class_Trainingschool"));
            if (!transaction.hasTable("class_Diplomatype")) {
                DiplomatypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "diplomatype", transaction.getTable("class_Diplomatype"));
            if (!transaction.hasTable("class_Department")) {
                DepartmentRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "department", transaction.getTable("class_Department"));
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "opportunities");
            table.addColumn(ColumnType.STRING, "goal");
            table.addColumn(ColumnType.STRING, "admission");
            table.addColumn(ColumnType.STRING, "documentsrequired");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Sector");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Sector")) {
            Table table = transaction.getTable("class_Sector");
            if (table.getColumnCount() != 11) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 11 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 11; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Sector");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_FACULTY = table.getColumnIndex("faculty");
            INDEX_INSTITUTE = table.getColumnIndex("institute");
            INDEX_TRAININGSCHOOL = table.getColumnIndex("trainingschool");
            INDEX_DIPLOMATYPE = table.getColumnIndex("diplomatype");
            INDEX_DEPARTMENT = table.getColumnIndex("department");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_OPPORTUNITIES = table.getColumnIndex("opportunities");
            INDEX_GOAL = table.getColumnIndex("goal");
            INDEX_ADMISSION = table.getColumnIndex("admission");
            INDEX_DOCUMENTSREQUIRED = table.getColumnIndex("documentsrequired");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (!columnTypes.containsKey("faculty")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'faculty'");
            }
            if (columnTypes.get("faculty") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Faculty' for field 'faculty'");
            }
            if (!transaction.hasTable("class_Faculty")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Faculty' for field 'faculty'");
            }
            Table table_1 = transaction.getTable("class_Faculty");
            if (!table.getLinkTarget(INDEX_FACULTY).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'faculty': '" + table.getLinkTarget(INDEX_FACULTY).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("institute")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'institute'");
            }
            if (columnTypes.get("institute") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Institute' for field 'institute'");
            }
            if (!transaction.hasTable("class_Institute")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Institute' for field 'institute'");
            }
            Table table_2 = transaction.getTable("class_Institute");
            if (!table.getLinkTarget(INDEX_INSTITUTE).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'institute': '" + table.getLinkTarget(INDEX_INSTITUTE).getName() + "' expected - was '" + table_2.getName() + "'");
            }
            if (!columnTypes.containsKey("trainingschool")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'trainingschool'");
            }
            if (columnTypes.get("trainingschool") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Trainingschool' for field 'trainingschool'");
            }
            if (!transaction.hasTable("class_Trainingschool")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Trainingschool' for field 'trainingschool'");
            }
            Table table_3 = transaction.getTable("class_Trainingschool");
            if (!table.getLinkTarget(INDEX_TRAININGSCHOOL).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'trainingschool': '" + table.getLinkTarget(INDEX_TRAININGSCHOOL).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("diplomatype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'diplomatype'");
            }
            if (columnTypes.get("diplomatype") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Diplomatype' for field 'diplomatype'");
            }
            if (!transaction.hasTable("class_Diplomatype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Diplomatype' for field 'diplomatype'");
            }
            Table table_4 = transaction.getTable("class_Diplomatype");
            if (!table.getLinkTarget(INDEX_DIPLOMATYPE).hasSameSchema(table_4)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'diplomatype': '" + table.getLinkTarget(INDEX_DIPLOMATYPE).getName() + "' expected - was '" + table_4.getName() + "'");
            }
            if (!columnTypes.containsKey("department")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'department'");
            }
            if (columnTypes.get("department") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Department' for field 'department'");
            }
            if (!transaction.hasTable("class_Department")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Department' for field 'department'");
            }
            Table table_5 = transaction.getTable("class_Department");
            if (!table.getLinkTarget(INDEX_DEPARTMENT).hasSameSchema(table_5)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'department': '" + table.getLinkTarget(INDEX_DEPARTMENT).getName() + "' expected - was '" + table_5.getName() + "'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
            if (!columnTypes.containsKey("opportunities")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'opportunities'");
            }
            if (columnTypes.get("opportunities") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'opportunities'");
            }
            if (!columnTypes.containsKey("goal")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'goal'");
            }
            if (columnTypes.get("goal") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'goal'");
            }
            if (!columnTypes.containsKey("admission")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'admission'");
            }
            if (columnTypes.get("admission") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'admission'");
            }
            if (!columnTypes.containsKey("documentsrequired")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'documentsrequired'");
            }
            if (columnTypes.get("documentsrequired") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'documentsrequired'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Sector class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Sector";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Sector createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Sector obj = realm.createObject(Sector.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (!json.isNull("faculty")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty facultyObj = FacultyRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("faculty"), update);
            obj.setFaculty(facultyObj);
        }
        if (!json.isNull("institute")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute instituteObj = InstituteRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("institute"), update);
            obj.setInstitute(instituteObj);
        }
        if (!json.isNull("trainingschool")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool trainingschoolObj = TrainingschoolRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("trainingschool"), update);
            obj.setTrainingschool(trainingschoolObj);
        }
        if (!json.isNull("diplomatype")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("diplomatype"), update);
            obj.setDiplomatype(diplomatypeObj);
        }
        if (!json.isNull("department")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department departmentObj = DepartmentRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("department"), update);
            obj.setDepartment(departmentObj);
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName("");
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        if (json.has("opportunities")) {
            if (json.isNull("opportunities")) {
                obj.setOpportunities("");
            } else {
                obj.setOpportunities((String) json.getString("opportunities"));
            }
        }
        if (json.has("goal")) {
            if (json.isNull("goal")) {
                obj.setGoal("");
            } else {
                obj.setGoal((String) json.getString("goal"));
            }
        }
        if (json.has("admission")) {
            if (json.isNull("admission")) {
                obj.setAdmission("");
            } else {
                obj.setAdmission((String) json.getString("admission"));
            }
        }
        if (json.has("documentsrequired")) {
            if (json.isNull("documentsrequired")) {
                obj.setDocumentsrequired("");
            } else {
                obj.setDocumentsrequired((String) json.getString("documentsrequired"));
            }
        }
        return obj;
    }

    public static Sector createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Sector obj = realm.createObject(Sector.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("faculty")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty facultyObj = FacultyRealmProxy.createUsingJsonStream(realm, reader);
                obj.setFaculty(facultyObj);
            } else if (name.equals("institute")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute instituteObj = InstituteRealmProxy.createUsingJsonStream(realm, reader);
                obj.setInstitute(instituteObj);
            } else if (name.equals("trainingschool")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool trainingschoolObj = TrainingschoolRealmProxy.createUsingJsonStream(realm, reader);
                obj.setTrainingschool(trainingschoolObj);
            } else if (name.equals("diplomatype")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = DiplomatypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDiplomatype(diplomatypeObj);
            } else if (name.equals("department")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department departmentObj = DepartmentRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDepartment(departmentObj);
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setName("");
                    reader.skipValue();
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else if (name.equals("opportunities")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setOpportunities("");
                    reader.skipValue();
                } else {
                    obj.setOpportunities((String) reader.nextString());
                }
            } else if (name.equals("goal")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setGoal("");
                    reader.skipValue();
                } else {
                    obj.setGoal((String) reader.nextString());
                }
            } else if (name.equals("admission")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setAdmission("");
                    reader.skipValue();
                } else {
                    obj.setAdmission((String) reader.nextString());
                }
            } else if (name.equals("documentsrequired")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setDocumentsrequired("");
                    reader.skipValue();
                } else {
                    obj.setDocumentsrequired((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Sector copyOrUpdate(Realm realm, Sector object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Sector copy(Realm realm, Sector newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Sector realmObject = realm.createObject(Sector.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty facultyObj = newObject.getFaculty();
        if (facultyObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty cachefaculty = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty) cache.get(facultyObj);
            if (cachefaculty != null) {
                realmObject.setFaculty(cachefaculty);
            } else {
                realmObject.setFaculty(FacultyRealmProxy.copyOrUpdate(realm, facultyObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute instituteObj = newObject.getInstitute();
        if (instituteObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute cacheinstitute = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute) cache.get(instituteObj);
            if (cacheinstitute != null) {
                realmObject.setInstitute(cacheinstitute);
            } else {
                realmObject.setInstitute(InstituteRealmProxy.copyOrUpdate(realm, instituteObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool trainingschoolObj = newObject.getTrainingschool();
        if (trainingschoolObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool cachetrainingschool = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool) cache.get(trainingschoolObj);
            if (cachetrainingschool != null) {
                realmObject.setTrainingschool(cachetrainingschool);
            } else {
                realmObject.setTrainingschool(TrainingschoolRealmProxy.copyOrUpdate(realm, trainingschoolObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = newObject.getDiplomatype();
        if (diplomatypeObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype cachediplomatype = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype) cache.get(diplomatypeObj);
            if (cachediplomatype != null) {
                realmObject.setDiplomatype(cachediplomatype);
            } else {
                realmObject.setDiplomatype(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomatypeObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department departmentObj = newObject.getDepartment();
        if (departmentObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department cachedepartment = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department) cache.get(departmentObj);
            if (cachedepartment != null) {
                realmObject.setDepartment(cachedepartment);
            } else {
                realmObject.setDepartment(DepartmentRealmProxy.copyOrUpdate(realm, departmentObj, update, cache));
            }
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setOpportunities(newObject.getOpportunities() != null ? newObject.getOpportunities() : "");
        realmObject.setGoal(newObject.getGoal() != null ? newObject.getGoal() : "");
        realmObject.setAdmission(newObject.getAdmission() != null ? newObject.getAdmission() : "");
        realmObject.setDocumentsrequired(newObject.getDocumentsrequired() != null ? newObject.getDocumentsrequired() : "");
        return realmObject;
    }

    static Sector update(Realm realm, Sector realmObject, Sector newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
        Faculty facultyObj = newObject.getFaculty();
        if (facultyObj != null) {
            Faculty cachefaculty = (Faculty) cache.get(facultyObj);
            if (cachefaculty != null) {
                realmObject.setFaculty(cachefaculty);
            } else {
                realmObject.setFaculty(FacultyRealmProxy.copyOrUpdate(realm, facultyObj, true, cache));
            }
        } else {
            realmObject.setFaculty(null);
        }
        Institute instituteObj = newObject.getInstitute();
        if (instituteObj != null) {
            Institute cacheinstitute = (Institute) cache.get(instituteObj);
            if (cacheinstitute != null) {
                realmObject.setInstitute(cacheinstitute);
            } else {
                realmObject.setInstitute(InstituteRealmProxy.copyOrUpdate(realm, instituteObj, true, cache));
            }
        } else {
            realmObject.setInstitute(null);
        }
        Trainingschool trainingschoolObj = newObject.getTrainingschool();
        if (trainingschoolObj != null) {
            Trainingschool cachetrainingschool = (Trainingschool) cache.get(trainingschoolObj);
            if (cachetrainingschool != null) {
                realmObject.setTrainingschool(cachetrainingschool);
            } else {
                realmObject.setTrainingschool(TrainingschoolRealmProxy.copyOrUpdate(realm, trainingschoolObj, true, cache));
            }
        } else {
            realmObject.setTrainingschool(null);
        }
        Diplomatype diplomatypeObj = newObject.getDiplomatype();
        if (diplomatypeObj != null) {
            Diplomatype cachediplomatype = (Diplomatype) cache.get(diplomatypeObj);
            if (cachediplomatype != null) {
                realmObject.setDiplomatype(cachediplomatype);
            } else {
                realmObject.setDiplomatype(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomatypeObj, true, cache));
            }
        } else {
            realmObject.setDiplomatype(null);
        }
        Department departmentObj = newObject.getDepartment();
        if (departmentObj != null) {
            Department cachedepartment = (Department) cache.get(departmentObj);
            if (cachedepartment != null) {
                realmObject.setDepartment(cachedepartment);
            } else {
                realmObject.setDepartment(DepartmentRealmProxy.copyOrUpdate(realm, departmentObj, true, cache));
            }
        } else {
            realmObject.setDepartment(null);
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setOpportunities(newObject.getOpportunities() != null ? newObject.getOpportunities() : "");
        realmObject.setGoal(newObject.getGoal() != null ? newObject.getGoal() : "");
        realmObject.setAdmission(newObject.getAdmission() != null ? newObject.getAdmission() : "");
        realmObject.setDocumentsrequired(newObject.getDocumentsrequired() != null ? newObject.getDocumentsrequired() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Sector = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{faculty:");
        stringBuilder.append(getFaculty() != null ? "Faculty" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{institute:");
        stringBuilder.append(getInstitute() != null ? "Institute" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{trainingschool:");
        stringBuilder.append(getTrainingschool() != null ? "Trainingschool" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diplomatype:");
        stringBuilder.append(getDiplomatype() != null ? "Diplomatype" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{department:");
        stringBuilder.append(getDepartment() != null ? "Department" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{opportunities:");
        stringBuilder.append(getOpportunities());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{goal:");
        stringBuilder.append(getGoal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{admission:");
        stringBuilder.append(getAdmission());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{documentsrequired:");
        stringBuilder.append(getDocumentsrequired());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorRealmProxy aSector = (SectorRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aSector.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aSector.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aSector.row.getIndex()) return false;

        return true;
    }

}
