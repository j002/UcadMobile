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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester;

public class ModuleRealmProxy extends Module
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_SEMESTER;
    private static long INDEX_DIPLOMA;
    private static long INDEX_DEPARTMENT;
    private static long INDEX_NAME;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("semester");
        fieldNames.add("diploma");
        fieldNames.add("department");
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
    public Semester getSemester() {
        if (row.isNullLink(INDEX_SEMESTER)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester.class, row.getLink(INDEX_SEMESTER));
    }

    @Override
    public void setSemester(Semester value) {
        if (value == null) {
            row.nullifyLink(INDEX_SEMESTER);
            return;
        }
        row.setLink(INDEX_SEMESTER, value.row.getIndex());
    }

    @Override
    public Diplomatype getDiploma() {
        if (row.isNullLink(INDEX_DIPLOMA)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype.class, row.getLink(INDEX_DIPLOMA));
    }

    @Override
    public void setDiploma(Diplomatype value) {
        if (value == null) {
            row.nullifyLink(INDEX_DIPLOMA);
            return;
        }
        row.setLink(INDEX_DIPLOMA, value.row.getIndex());
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

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Module")) {
            Table table = transaction.getTable("class_Module");
            table.addColumn(ColumnType.INTEGER, "id");
            if (!transaction.hasTable("class_Semester")) {
                SemesterRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "semester", transaction.getTable("class_Semester"));
            if (!transaction.hasTable("class_Diplomatype")) {
                DiplomatypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "diploma", transaction.getTable("class_Diplomatype"));
            if (!transaction.hasTable("class_Department")) {
                DepartmentRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "department", transaction.getTable("class_Department"));
            table.addColumn(ColumnType.STRING, "name");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Module");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Module")) {
            Table table = transaction.getTable("class_Module");
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
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Module");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_SEMESTER = table.getColumnIndex("semester");
            INDEX_DIPLOMA = table.getColumnIndex("diploma");
            INDEX_DEPARTMENT = table.getColumnIndex("department");
            INDEX_NAME = table.getColumnIndex("name");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (!columnTypes.containsKey("semester")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'semester'");
            }
            if (columnTypes.get("semester") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Semester' for field 'semester'");
            }
            if (!transaction.hasTable("class_Semester")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Semester' for field 'semester'");
            }
            Table table_1 = transaction.getTable("class_Semester");
            if (!table.getLinkTarget(INDEX_SEMESTER).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'semester': '" + table.getLinkTarget(INDEX_SEMESTER).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("diploma")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'diploma'");
            }
            if (columnTypes.get("diploma") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Diplomatype' for field 'diploma'");
            }
            if (!transaction.hasTable("class_Diplomatype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Diplomatype' for field 'diploma'");
            }
            Table table_2 = transaction.getTable("class_Diplomatype");
            if (!table.getLinkTarget(INDEX_DIPLOMA).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'diploma': '" + table.getLinkTarget(INDEX_DIPLOMA).getName() + "' expected - was '" + table_2.getName() + "'");
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
            Table table_3 = transaction.getTable("class_Department");
            if (!table.getLinkTarget(INDEX_DEPARTMENT).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'department': '" + table.getLinkTarget(INDEX_DEPARTMENT).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Module class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Module";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Module createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Module obj = realm.createObject(Module.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (!json.isNull("semester")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester semesterObj = SemesterRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("semester"), update);
            obj.setSemester(semesterObj);
        }
        if (!json.isNull("diploma")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("diploma"), update);
            obj.setDiploma(diplomaObj);
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
        return obj;
    }

    public static Module createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Module obj = realm.createObject(Module.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("semester")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester semesterObj = SemesterRealmProxy.createUsingJsonStream(realm, reader);
                obj.setSemester(semesterObj);
            } else if (name.equals("diploma")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDiploma(diplomaObj);
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
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Module copyOrUpdate(Realm realm, Module object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Module copy(Realm realm, Module newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Module realmObject = realm.createObject(Module.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester semesterObj = newObject.getSemester();
        if (semesterObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester cachesemester = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester) cache.get(semesterObj);
            if (cachesemester != null) {
                realmObject.setSemester(cachesemester);
            } else {
                realmObject.setSemester(SemesterRealmProxy.copyOrUpdate(realm, semesterObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = newObject.getDiploma();
        if (diplomaObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype cachediploma = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype) cache.get(diplomaObj);
            if (cachediploma != null) {
                realmObject.setDiploma(cachediploma);
            } else {
                realmObject.setDiploma(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomaObj, update, cache));
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
        return realmObject;
    }

    static Module update(Realm realm, Module realmObject, Module newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
        Semester semesterObj = newObject.getSemester();
        if (semesterObj != null) {
            Semester cachesemester = (Semester) cache.get(semesterObj);
            if (cachesemester != null) {
                realmObject.setSemester(cachesemester);
            } else {
                realmObject.setSemester(SemesterRealmProxy.copyOrUpdate(realm, semesterObj, true, cache));
            }
        } else {
            realmObject.setSemester(null);
        }
        Diplomatype diplomaObj = newObject.getDiploma();
        if (diplomaObj != null) {
            Diplomatype cachediploma = (Diplomatype) cache.get(diplomaObj);
            if (cachediploma != null) {
                realmObject.setDiploma(cachediploma);
            } else {
                realmObject.setDiploma(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomaObj, true, cache));
            }
        } else {
            realmObject.setDiploma(null);
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
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Module = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{semester:");
        stringBuilder.append(getSemester() != null ? "Semester" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diploma:");
        stringBuilder.append(getDiploma() != null ? "Diplomatype" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{department:");
        stringBuilder.append(getDepartment() != null ? "Department" : "null");
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
        ModuleRealmProxy aModule = (ModuleRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aModule.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aModule.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aModule.row.getIndex()) return false;

        return true;
    }

}
