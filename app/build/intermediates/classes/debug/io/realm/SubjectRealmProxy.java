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
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module;
import volkeno.android.ucadmobile.ucadmobile.objectforinformation.Subject;

public class SubjectRealmProxy extends Subject
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_DIPLOMA;
    private static long INDEX_DETAILEDDIPLOMA;
    private static long INDEX_MODULE;
    private static long INDEX_NAME;
    private static long INDEX_HOURSOFTUTORIALS;
    private static long INDEX_HOURSOFPRATICALWORK;
    private static long INDEX_HOURSOFCOURSES;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("diploma");
        fieldNames.add("detaileddiploma");
        fieldNames.add("module");
        fieldNames.add("name");
        fieldNames.add("hoursoftutorials");
        fieldNames.add("hoursofpraticalwork");
        fieldNames.add("hoursofcourses");
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
    public Detaileddiploma getDetaileddiploma() {
        if (row.isNullLink(INDEX_DETAILEDDIPLOMA)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma.class, row.getLink(INDEX_DETAILEDDIPLOMA));
    }

    @Override
    public void setDetaileddiploma(Detaileddiploma value) {
        if (value == null) {
            row.nullifyLink(INDEX_DETAILEDDIPLOMA);
            return;
        }
        row.setLink(INDEX_DETAILEDDIPLOMA, value.row.getIndex());
    }

    @Override
    public Module getModule() {
        if (row.isNullLink(INDEX_MODULE)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module.class, row.getLink(INDEX_MODULE));
    }

    @Override
    public void setModule(Module value) {
        if (value == null) {
            row.nullifyLink(INDEX_MODULE);
            return;
        }
        row.setLink(INDEX_MODULE, value.row.getIndex());
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
    public String getHoursoftutorials() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_HOURSOFTUTORIALS);
    }

    @Override
    public void setHoursoftutorials(String value) {
        realm.checkIfValid();
        row.setString(INDEX_HOURSOFTUTORIALS, (String) value);
    }

    @Override
    public String getHoursofpraticalwork() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_HOURSOFPRATICALWORK);
    }

    @Override
    public void setHoursofpraticalwork(String value) {
        realm.checkIfValid();
        row.setString(INDEX_HOURSOFPRATICALWORK, (String) value);
    }

    @Override
    public String getHoursofcourses() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_HOURSOFCOURSES);
    }

    @Override
    public void setHoursofcourses(String value) {
        realm.checkIfValid();
        row.setString(INDEX_HOURSOFCOURSES, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Subject")) {
            Table table = transaction.getTable("class_Subject");
            table.addColumn(ColumnType.INTEGER, "id");
            if (!transaction.hasTable("class_Diplomatype")) {
                DiplomatypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "diploma", transaction.getTable("class_Diplomatype"));
            if (!transaction.hasTable("class_Detaileddiploma")) {
                DetaileddiplomaRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "detaileddiploma", transaction.getTable("class_Detaileddiploma"));
            if (!transaction.hasTable("class_Module")) {
                ModuleRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "module", transaction.getTable("class_Module"));
            table.addColumn(ColumnType.STRING, "name");
            table.addColumn(ColumnType.STRING, "hoursoftutorials");
            table.addColumn(ColumnType.STRING, "hoursofpraticalwork");
            table.addColumn(ColumnType.STRING, "hoursofcourses");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Subject");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Subject")) {
            Table table = transaction.getTable("class_Subject");
            if (table.getColumnCount() != 8) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 8 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 8; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type Subject");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_DIPLOMA = table.getColumnIndex("diploma");
            INDEX_DETAILEDDIPLOMA = table.getColumnIndex("detaileddiploma");
            INDEX_MODULE = table.getColumnIndex("module");
            INDEX_NAME = table.getColumnIndex("name");
            INDEX_HOURSOFTUTORIALS = table.getColumnIndex("hoursoftutorials");
            INDEX_HOURSOFPRATICALWORK = table.getColumnIndex("hoursofpraticalwork");
            INDEX_HOURSOFCOURSES = table.getColumnIndex("hoursofcourses");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
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
            Table table_1 = transaction.getTable("class_Diplomatype");
            if (!table.getLinkTarget(INDEX_DIPLOMA).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'diploma': '" + table.getLinkTarget(INDEX_DIPLOMA).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("detaileddiploma")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'detaileddiploma'");
            }
            if (columnTypes.get("detaileddiploma") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Detaileddiploma' for field 'detaileddiploma'");
            }
            if (!transaction.hasTable("class_Detaileddiploma")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Detaileddiploma' for field 'detaileddiploma'");
            }
            Table table_2 = transaction.getTable("class_Detaileddiploma");
            if (!table.getLinkTarget(INDEX_DETAILEDDIPLOMA).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'detaileddiploma': '" + table.getLinkTarget(INDEX_DETAILEDDIPLOMA).getName() + "' expected - was '" + table_2.getName() + "'");
            }
            if (!columnTypes.containsKey("module")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'module'");
            }
            if (columnTypes.get("module") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Module' for field 'module'");
            }
            if (!transaction.hasTable("class_Module")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Module' for field 'module'");
            }
            Table table_3 = transaction.getTable("class_Module");
            if (!table.getLinkTarget(INDEX_MODULE).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'module': '" + table.getLinkTarget(INDEX_MODULE).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name'");
            }
            if (columnTypes.get("name") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name'");
            }
            if (!columnTypes.containsKey("hoursoftutorials")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'hoursoftutorials'");
            }
            if (columnTypes.get("hoursoftutorials") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'hoursoftutorials'");
            }
            if (!columnTypes.containsKey("hoursofpraticalwork")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'hoursofpraticalwork'");
            }
            if (columnTypes.get("hoursofpraticalwork") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'hoursofpraticalwork'");
            }
            if (!columnTypes.containsKey("hoursofcourses")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'hoursofcourses'");
            }
            if (columnTypes.get("hoursofcourses") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'hoursofcourses'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Subject class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Subject";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static Subject createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Subject obj = realm.createObject(Subject.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (!json.isNull("diploma")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("diploma"), update);
            obj.setDiploma(diplomaObj);
        }
        if (!json.isNull("detaileddiploma")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma detaileddiplomaObj = DetaileddiplomaRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("detaileddiploma"), update);
            obj.setDetaileddiploma(detaileddiplomaObj);
        }
        if (!json.isNull("module")) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module moduleObj = ModuleRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("module"), update);
            obj.setModule(moduleObj);
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                obj.setName("");
            } else {
                obj.setName((String) json.getString("name"));
            }
        }
        if (json.has("hoursoftutorials")) {
            if (json.isNull("hoursoftutorials")) {
                obj.setHoursoftutorials("");
            } else {
                obj.setHoursoftutorials((String) json.getString("hoursoftutorials"));
            }
        }
        if (json.has("hoursofpraticalwork")) {
            if (json.isNull("hoursofpraticalwork")) {
                obj.setHoursofpraticalwork("");
            } else {
                obj.setHoursofpraticalwork((String) json.getString("hoursofpraticalwork"));
            }
        }
        if (json.has("hoursofcourses")) {
            if (json.isNull("hoursofcourses")) {
                obj.setHoursofcourses("");
            } else {
                obj.setHoursofcourses((String) json.getString("hoursofcourses"));
            }
        }
        return obj;
    }

    public static Subject createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Subject obj = realm.createObject(Subject.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("diploma")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = DiplomatypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDiploma(diplomaObj);
            } else if (name.equals("detaileddiploma")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma detaileddiplomaObj = DetaileddiplomaRealmProxy.createUsingJsonStream(realm, reader);
                obj.setDetaileddiploma(detaileddiplomaObj);
            } else if (name.equals("module")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module moduleObj = ModuleRealmProxy.createUsingJsonStream(realm, reader);
                obj.setModule(moduleObj);
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setName("");
                    reader.skipValue();
                } else {
                    obj.setName((String) reader.nextString());
                }
            } else if (name.equals("hoursoftutorials")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setHoursoftutorials("");
                    reader.skipValue();
                } else {
                    obj.setHoursoftutorials((String) reader.nextString());
                }
            } else if (name.equals("hoursofpraticalwork")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setHoursofpraticalwork("");
                    reader.skipValue();
                } else {
                    obj.setHoursofpraticalwork((String) reader.nextString());
                }
            } else if (name.equals("hoursofcourses")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setHoursofcourses("");
                    reader.skipValue();
                } else {
                    obj.setHoursofcourses((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Subject copyOrUpdate(Realm realm, Subject object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Subject copy(Realm realm, Subject newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        Subject realmObject = realm.createObject(Subject.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype diplomaObj = newObject.getDiploma();
        if (diplomaObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype cachediploma = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Diplomatype) cache.get(diplomaObj);
            if (cachediploma != null) {
                realmObject.setDiploma(cachediploma);
            } else {
                realmObject.setDiploma(DiplomatypeRealmProxy.copyOrUpdate(realm, diplomaObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma detaileddiplomaObj = newObject.getDetaileddiploma();
        if (detaileddiplomaObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma cachedetaileddiploma = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Detaileddiploma) cache.get(detaileddiplomaObj);
            if (cachedetaileddiploma != null) {
                realmObject.setDetaileddiploma(cachedetaileddiploma);
            } else {
                realmObject.setDetaileddiploma(DetaileddiplomaRealmProxy.copyOrUpdate(realm, detaileddiplomaObj, update, cache));
            }
        }

        volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module moduleObj = newObject.getModule();
        if (moduleObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module cachemodule = (volkeno.android.ucadmobile.ucadmobile.objectforinformation.Module) cache.get(moduleObj);
            if (cachemodule != null) {
                realmObject.setModule(cachemodule);
            } else {
                realmObject.setModule(ModuleRealmProxy.copyOrUpdate(realm, moduleObj, update, cache));
            }
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setHoursoftutorials(newObject.getHoursoftutorials() != null ? newObject.getHoursoftutorials() : "");
        realmObject.setHoursofpraticalwork(newObject.getHoursofpraticalwork() != null ? newObject.getHoursofpraticalwork() : "");
        realmObject.setHoursofcourses(newObject.getHoursofcourses() != null ? newObject.getHoursofcourses() : "");
        return realmObject;
    }

    static Subject update(Realm realm, Subject realmObject, Subject newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
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
        Detaileddiploma detaileddiplomaObj = newObject.getDetaileddiploma();
        if (detaileddiplomaObj != null) {
            Detaileddiploma cachedetaileddiploma = (Detaileddiploma) cache.get(detaileddiplomaObj);
            if (cachedetaileddiploma != null) {
                realmObject.setDetaileddiploma(cachedetaileddiploma);
            } else {
                realmObject.setDetaileddiploma(DetaileddiplomaRealmProxy.copyOrUpdate(realm, detaileddiplomaObj, true, cache));
            }
        } else {
            realmObject.setDetaileddiploma(null);
        }
        Module moduleObj = newObject.getModule();
        if (moduleObj != null) {
            Module cachemodule = (Module) cache.get(moduleObj);
            if (cachemodule != null) {
                realmObject.setModule(cachemodule);
            } else {
                realmObject.setModule(ModuleRealmProxy.copyOrUpdate(realm, moduleObj, true, cache));
            }
        } else {
            realmObject.setModule(null);
        }
        realmObject.setName(newObject.getName() != null ? newObject.getName() : "");
        realmObject.setHoursoftutorials(newObject.getHoursoftutorials() != null ? newObject.getHoursoftutorials() : "");
        realmObject.setHoursofpraticalwork(newObject.getHoursofpraticalwork() != null ? newObject.getHoursofpraticalwork() : "");
        realmObject.setHoursofcourses(newObject.getHoursofcourses() != null ? newObject.getHoursofcourses() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Subject = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diploma:");
        stringBuilder.append(getDiploma() != null ? "Diplomatype" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{detaileddiploma:");
        stringBuilder.append(getDetaileddiploma() != null ? "Detaileddiploma" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{module:");
        stringBuilder.append(getModule() != null ? "Module" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(getName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hoursoftutorials:");
        stringBuilder.append(getHoursoftutorials());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hoursofpraticalwork:");
        stringBuilder.append(getHoursofpraticalwork());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hoursofcourses:");
        stringBuilder.append(getHoursofcourses());
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
        SubjectRealmProxy aSubject = (SubjectRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aSubject.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aSubject.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aSubject.row.getIndex()) return false;

        return true;
    }

}
