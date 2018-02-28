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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Institute;

public class InstituteRealmProxy extends Institute
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_NAME;
    private static long INDEX_LATGEO;
    private static long INDEX_LONGGEO;
    private static long INDEX_DESCRIPTION;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("latgeo");
        fieldNames.add("longgeo");
        fieldNames.add("description");
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

    @Override
    public double getLatgeo() {
        realm.checkIfValid();
        return (double) row.getDouble(INDEX_LATGEO);
    }

    @Override
    public void setLatgeo(double value) {
        realm.checkIfValid();
        row.setDouble(INDEX_LATGEO, (double) value);
    }

    @Override
    public double getLonggeo() {
        realm.checkIfValid();
        return (double) row.getDouble(INDEX_LONGGEO);
    }

    @Override
    public void setLonggeo(double value) {
        realm.checkIfValid();
        row.setDouble(INDEX_LONGGEO, (double) value);
    }

    @Override
    public String getDescription() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DESCRIPTION);
    }

    @Override
    public void setDescription(String value) {
        realm.checkIfValid();
        row.setString(INDEX_DESCRIPTION, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Institute")) {
            Table table = transaction.getTable("class_Institute");
            table.addColumn(ColumnType.INTEGER, "id");
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.DOUBLE, "latgeo");
            table.addColumn(ColumnType.DOUBLE, "longgeo");
            table.addColumn(ColumnType.STRING, "description");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Institute");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Institute")) {
            Table table = transaction.getTable("class_Institute");
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
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Institute");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_LATGEO = table.getColumnIndex("latgeo");
            INDEX_LONGGEO = table.getColumnIndex("longgeo");
            INDEX_DESCRIPTION = table.getColumnIndex("description");

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
            if (!columnTypes.containsKey("latgeo")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'latgeo'");
            }
            if (columnTypes.get("latgeo") != ColumnType.DOUBLE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'double' for field 'latgeo'");
            }
            if (!columnTypes.containsKey("longgeo")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'longgeo'");
            }
            if (columnTypes.get("longgeo") != ColumnType.DOUBLE) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'double' for field 'longgeo'");
            }
            if (!columnTypes.containsKey("description")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'description'");
            }
            if (columnTypes.get("description") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'description'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Institute class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Institute";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Institute createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Institute obj = realm.createObject(Institute.class);
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
        if (!json.isNull("latgeo")) {
            obj.setLatgeo((double) json.getDouble("latgeo"));
        }
        if (!json.isNull("longgeo")) {
            obj.setLonggeo((double) json.getDouble("longgeo"));
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                obj.setDescription("");
            } else {
                obj.setDescription((String) json.getString("description"));
            }
        }
        return obj;
    }

    public static Institute createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Institute obj = realm.createObject(Institute.class);
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
            } else if (name.equals("latgeo")  && reader.peek() != JsonToken.NULL) {
                obj.setLatgeo((double) reader.nextDouble());
            } else if (name.equals("longgeo")  && reader.peek() != JsonToken.NULL) {
                obj.setLonggeo((double) reader.nextDouble());
            } else if (name.equals("description")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setDescription("");
                    reader.skipValue();
                } else {
                    obj.setDescription((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Institute copyOrUpdate(Realm realm, Institute object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Institute copy(Realm realm, Institute newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Institute realmObject = realm.createObject(Institute.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setLatgeo(newObject.getLatgeo());
        realmObject.setLonggeo(newObject.getLonggeo());
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");
        return realmObject;
    }

    static Institute update(Realm realm, Institute realmObject, Institute newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setLatgeo(newObject.getLatgeo());
        realmObject.setLonggeo(newObject.getLonggeo());
        realmObject.setDescription(newObject.getDescription() != null ? newObject.getDescription() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Institute = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latgeo:");
        stringBuilder.append(getLatgeo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longgeo:");
        stringBuilder.append(getLonggeo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(getDescription());
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
        InstituteRealmProxy aInstitute = (InstituteRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aInstitute.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aInstitute.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aInstitute.row.getIndex()) return false;

        return true;
    }

}
