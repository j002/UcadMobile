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

public class DiplomatypeRealmProxy extends Diplomatype
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
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
        if (!transaction.hasTable("class_Diplomatype")) {
            Table table = transaction.getTable("class_Diplomatype");
            table.addColumn(ColumnType.INTEGER, "id");
            table.addColumn(ColumnType.STRING, "name");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Diplomatype");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Diplomatype")) {
            Table table = transaction.getTable("class_Diplomatype");
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
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Diplomatype");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Diplomatype class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Diplomatype";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Diplomatype createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Diplomatype obj = realm.createObject(Diplomatype.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
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

    public static Diplomatype createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Diplomatype obj = realm.createObject(Diplomatype.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
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

    public static Diplomatype copyOrUpdate(Realm realm, Diplomatype object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Diplomatype copy(Realm realm, Diplomatype newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Diplomatype realmObject = realm.createObject(Diplomatype.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    static Diplomatype update(Realm realm, Diplomatype realmObject, Diplomatype newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Diplomatype = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
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
        DiplomatypeRealmProxy aDiplomatype = (DiplomatypeRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aDiplomatype.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aDiplomatype.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aDiplomatype.row.getIndex()) return false;

        return true;
    }

}
