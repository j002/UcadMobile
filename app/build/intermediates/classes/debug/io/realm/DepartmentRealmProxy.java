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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Faculty;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool;

public class DepartmentRealmProxy extends Department
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_FACULTY;
    private static long INDEX_INSTITUTE;
    private static long INDEX_SCHOOL;
    private static long INDEX_NAME;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("faculty");
        fieldNames.add("institute");
        fieldNames.add("school");
        fieldNames.add("name");
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
    public Trainingschool getSchool() {
        if (row.isNullLink(INDEX_SCHOOL)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool.class, row.getLink(INDEX_SCHOOL));
    }

    @Override
    public void setSchool(Trainingschool value) {
        if (value == null) {
            row.nullifyLink(INDEX_SCHOOL);
            return;
        }
        row.setLink(INDEX_SCHOOL, value.row.getIndex());
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

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Department")) {
            Table table = transaction.getTable("class_Department");
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
            table.addColumnLink(ColumnType.LINK, "school", transaction.getTable("class_Trainingschool"));
            table.addColumn(ColumnType.STRING, "name");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Department");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Department")) {
            Table table = transaction.getTable("class_Department");
            if (table.getColumnCount() != 5) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 5 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 5; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Department");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_FACULTY = table.getColumnIndex("faculty");
            INDEX_INSTITUTE = table.getColumnIndex("institute");
            INDEX_SCHOOL = table.getColumnIndex("school");
            INDEX_NAME = table.getColumnIndex("name");

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
            if (!columnTypes.containsKey("school")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'school'");
            }
            if (columnTypes.get("school") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Trainingschool' for field 'school'");
            }
            if (!transaction.hasTable("class_Trainingschool")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Trainingschool' for field 'school'");
            }
            Table table_3 = transaction.getTable("class_Trainingschool");
            if (!table.getLinkTarget(INDEX_SCHOOL).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'school': '" + table.getLinkTarget(INDEX_SCHOOL).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Department class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Department";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Department createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Department obj = realm.createObject(Department.class);
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
        if (!json.isNull("school")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool schoolObj = TrainingschoolRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("school"), update);
            obj.setSchool(schoolObj);
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName("");
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        return obj;
    }

    public static Department createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Department obj = realm.createObject(Department.class);
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
            } else if (name.equals("school")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool schoolObj = TrainingschoolRealmProxy.createUsingJsonStream(realm, reader);
                obj.setSchool(schoolObj);
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setName("");
                    reader.skipValue();
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Department copyOrUpdate(Realm realm, Department object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Department copy(Realm realm, Department newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Department realmObject = realm.createObject(Department.class);
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

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool schoolObj = newObject.getSchool();
        if (schoolObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool cacheschool = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Trainingschool) cache.get(schoolObj);
            if (cacheschool != null) {
                realmObject.setSchool(cacheschool);
            } else {
                realmObject.setSchool(TrainingschoolRealmProxy.copyOrUpdate(realm, schoolObj, update, cache));
            }
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    static Department update(Realm realm, Department realmObject, Department newObject, Map<RealmObject, RealmObjectProxy> cache) {
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
        Trainingschool schoolObj = newObject.getSchool();
        if (schoolObj != null) {
            Trainingschool cacheschool = (Trainingschool) cache.get(schoolObj);
            if (cacheschool != null) {
                realmObject.setSchool(cacheschool);
            } else {
                realmObject.setSchool(TrainingschoolRealmProxy.copyOrUpdate(realm, schoolObj, true, cache));
            }
        } else {
            realmObject.setSchool(null);
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Department = [");
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
        stringBuilder.append("{school:");
        stringBuilder.append(getSchool() != null ? "Trainingschool" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
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
        DepartmentRealmProxy aDepartment = (DepartmentRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aDepartment.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aDepartment.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aDepartment.row.getIndex()) return false;

        return true;
    }

}
