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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Belong;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;

public class BelongRealmProxy extends Belong
    implements RealmObjectProxy {

    private static long INDEX_DIPLOMA;
    private static long INDEX_DEPARTMENT;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("diploma");
        fieldNames.add("department");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
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

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Belong")) {
            Table table = transaction.getTable("class_Belong");
            if (!transaction.hasTable("class_Diplomatype")) {
                DiplomatypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "diploma", transaction.getTable("class_Diplomatype"));
            if (!transaction.hasTable("class_Department")) {
                DepartmentRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "department", transaction.getTable("class_Department"));
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Belong");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Belong")) {
            Table table = transaction.getTable("class_Belong");
            if (table.getColumnCount() != 2) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 2 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Belong");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_DIPLOMA = table.getColumnIndex("diploma");
            INDEX_DEPARTMENT = table.getColumnIndex("department");

            if (!columnTypes.containsKey("diploma")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'diploma'");
            }
            if (columnTypes.get("diploma") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Diplomatype' for field 'diploma'");
            }
            if (!transaction.hasTable("class_Diplomatype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Diplomatype' for field 'diploma'");
            }
            Table table_0 = transaction.getTable("class_Diplomatype");
            if (!table.getLinkTarget(INDEX_DIPLOMA).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'diploma': '" + table.getLinkTarget(INDEX_DIPLOMA).getName() + "' expected - was '" + table_0.getName() + "'");
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
            Table table_1 = transaction.getTable("class_Department");
            if (!table.getLinkTarget(INDEX_DEPARTMENT).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'department': '" + table.getLinkTarget(INDEX_DEPARTMENT).getName() + "' expected - was '" + table_1.getName() + "'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Belong class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Belong";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Belong createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Belong obj = realm.createObject(Belong.class);
        if (!json.isNull("diploma")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("diploma"), update);
            obj.setDiploma(diplomaObj);
        }
        if (!json.isNull("department")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department departmentObj = DepartmentRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("department"), update);
            obj.setDepartment(departmentObj);
        }
        return obj;
    }

    public static Belong createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Belong obj = realm.createObject(Belong.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("diploma") && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDiploma(diplomaObj);
            } else if (name.equals("department")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Department departmentObj = DepartmentRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDepartment(departmentObj);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Belong copyOrUpdate(Realm realm, Belong object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Belong copy(Realm realm, Belong newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Belong realmObject = realm.createObject(Belong.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);

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
        return realmObject;
    }

    static Belong update(Realm realm, Belong realmObject, Belong newObject, Map<RealmObject, RealmObjectProxy> cache) {
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
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Belong = [");
        stringBuilder.append("{diploma:");
        stringBuilder.append(getDiploma() != null ? "Diplomatype" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{department:");
        stringBuilder.append(getDepartment() != null ? "Department" : "null");
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
        BelongRealmProxy aBelong = (BelongRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aBelong.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aBelong.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aBelong.row.getIndex()) return false;

        return true;
    }

}
