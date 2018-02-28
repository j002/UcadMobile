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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Semester;

public class SemesterRealmProxy extends Semester
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_DIPLOMATYPE;
    private static long INDEX_NAME;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("diplomatype");
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
        if (!transaction.hasTable("class_Semester")) {
            Table table = transaction.getTable("class_Semester");
            table.addColumn(ColumnType.INTEGER, "id");
            if (!transaction.hasTable("class_Diplomatype")) {
                DiplomatypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "diplomatype", transaction.getTable("class_Diplomatype"));
            table.addColumn(ColumnType.STRING, "name");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Semester");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Semester")) {
            Table table = transaction.getTable("class_Semester");
            if (table.getColumnCount() != 3) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 3 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Semester");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_DIPLOMATYPE = table.getColumnIndex("diplomatype");
            INDEX_NAME = table.getColumnIndex("name");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
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
            Table table_1 = transaction.getTable("class_Diplomatype");
            if (!table.getLinkTarget(INDEX_DIPLOMATYPE).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'diplomatype': '" + table.getLinkTarget(INDEX_DIPLOMATYPE).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Semester class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Semester";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Semester createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Semester obj = realm.createObject(Semester.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (!json.isNull("diplomatype")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("diplomatype"), update);
            obj.setDiplomatype(diplomatypeObj);
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

    public static Semester createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Semester obj = realm.createObject(Semester.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("diplomatype")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = DiplomatypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDiplomatype(diplomatypeObj);
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

    public static Semester copyOrUpdate(Realm realm, Semester object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Semester copy(Realm realm, Semester newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Semester realmObject = realm.createObject(Semester.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomatypeObj = newObject.getDiplomatype();
        if (diplomatypeObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype cachediplomatype = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype) cache.get(diplomatypeObj);
            if (cachediplomatype != null) {
                realmObject.setDiplomatype(cachediplomatype);
            } else {
                realmObject.setDiplomatype(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomatypeObj, update, cache));
            }
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    static Semester update(Realm realm, Semester realmObject, Semester newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
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
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Semester = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diplomatype:");
        stringBuilder.append(getDiplomatype() != null ? "Diplomatype" : "null");
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
        SemesterRealmProxy aSemester = (SemesterRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aSemester.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aSemester.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aSemester.row.getIndex()) return false;

        return true;
    }

}
