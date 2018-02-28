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
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype;

public class NewsRealmProxy extends News
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_CONTENT;
    private static long INDEX_TITTLE;
    private static long INDEX_NEWSTYPE;
    private static long INDEX_DATE;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("content");
        fieldNames.add("tittle");
        fieldNames.add("newstype");
        fieldNames.add("date");
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
    public String getContent() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CONTENT);
    }

    @Override
    public void setContent(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CONTENT, (String) value);
    }

    @Override
    public String getTittle() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_TITTLE);
    }

    @Override
    public void setTittle(String value) {
        realm.checkIfValid();
        row.setString(INDEX_TITTLE, (String) value);
    }

    @Override
    public Newstype getNewstype() {
        if (row.isNullLink(INDEX_NEWSTYPE)) {
            return null;
        }
        return realm.get(volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype.class, row.getLink(INDEX_NEWSTYPE));
    }

    @Override
    public void setNewstype(Newstype value) {
        if (value == null) {
            row.nullifyLink(INDEX_NEWSTYPE);
            return;
        }
        row.setLink(INDEX_NEWSTYPE, value.row.getIndex());
    }

    @Override
    public String getDate() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_DATE);
    }

    @Override
    public void setDate(String value) {
        realm.checkIfValid();
        row.setString(INDEX_DATE, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_News")) {
            Table table = transaction.getTable("class_News");
            table.addColumn(ColumnType.INTEGER, "id");
            table.addColumn(ColumnType.STRING, "content");
            table.addColumn(ColumnType.STRING, "tittle");
            if (!transaction.hasTable("class_Newstype")) {
                NewstypeRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK, "newstype", transaction.getTable("class_Newstype"));
            table.addColumn(ColumnType.STRING, "date");
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_News");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_News")) {
            Table table = transaction.getTable("class_News");
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
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type News");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_CONTENT = table.getColumnIndex("content");
            INDEX_TITTLE = table.getColumnIndex("tittle");
            INDEX_NEWSTYPE = table.getColumnIndex("newstype");
            INDEX_DATE = table.getColumnIndex("date");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (!columnTypes.containsKey("content")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'content'");
            }
            if (columnTypes.get("content") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'content'");
            }
            if (!columnTypes.containsKey("tittle")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'tittle'");
            }
            if (columnTypes.get("tittle") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'tittle'");
            }
            if (!columnTypes.containsKey("newstype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'newstype'");
            }
            if (columnTypes.get("newstype") != ColumnType.LINK) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Newstype' for field 'newstype'");
            }
            if (!transaction.hasTable("class_Newstype")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Newstype' for field 'newstype'");
            }
            Table table_3 = transaction.getTable("class_Newstype");
            if (!table.getLinkTarget(INDEX_NEWSTYPE).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'newstype': '" + table.getLinkTarget(INDEX_NEWSTYPE).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("date")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'date'");
            }
            if (columnTypes.get("date") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'date'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The News class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_News";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static News createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        News obj = realm.createObject(News.class);
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                obj.setContent("");
            } else {
                obj.setContent((String) json.getString("content"));
            }
        }
        if (json.has("tittle")) {
            if (json.isNull("tittle")) {
                obj.setTittle("");
            } else {
                obj.setTittle((String) json.getString("tittle"));
            }
        }
        if (!json.isNull("newstype")) {
            volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype newstypeObj = NewstypeRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("newstype"), update);
            obj.setNewstype(newstypeObj);
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                obj.setDate("");
            } else {
                obj.setDate((String) json.getString("date"));
            }
        }
        return obj;
    }

    public static News createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        News obj = realm.createObject(News.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setContent("");
                    reader.skipValue();
                } else {
                    obj.setContent((String) reader.nextString());
                }
            } else if (name.equals("tittle")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setTittle("");
                    reader.skipValue();
                } else {
                    obj.setTittle((String) reader.nextString());
                }
            } else if (name.equals("newstype")  && reader.peek() != JsonToken.NULL) {
                volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype newstypeObj = NewstypeRealmProxy.createUsingJsonStream(realm, reader);
                obj.setNewstype(newstypeObj);
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setDate("");
                    reader.skipValue();
                } else {
                    obj.setDate((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static News copyOrUpdate(Realm realm, News object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static News copy(Realm realm, News newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        News realmObject = realm.createObject(News.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());
        realmObject.setContent(newObject.getContent() != null ? newObject.getContent() : "");
        realmObject.setTittle(newObject.getTittle() != null ? newObject.getTittle() : "");

        volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype newstypeObj = newObject.getNewstype();
        if (newstypeObj != null) {
            volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype cachenewstype = (volkeno.android.ucadmobile.ucadmobile.objectforactuality.Newstype) cache.get(newstypeObj);
            if (cachenewstype != null) {
                realmObject.setNewstype(cachenewstype);
            } else {
                realmObject.setNewstype(NewstypeRealmProxy.copyOrUpdate(realm, newstypeObj, update, cache));
            }
        }
        realmObject.setDate(newObject.getDate() != null ? newObject.getDate() : "");
        return realmObject;
    }

    static News update(Realm realm, News realmObject, News newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setId(newObject.getId());
        realmObject.setContent(newObject.getContent() != null ? newObject.getContent() : "");
        realmObject.setTittle(newObject.getTittle() != null ? newObject.getTittle() : "");
        Newstype newstypeObj = newObject.getNewstype();
        if (newstypeObj != null) {
            Newstype cachenewstype = (Newstype) cache.get(newstypeObj);
            if (cachenewstype != null) {
                realmObject.setNewstype(cachenewstype);
            } else {
                realmObject.setNewstype(NewstypeRealmProxy.copyOrUpdate(realm, newstypeObj, true, cache));
            }
        } else {
            realmObject.setNewstype(null);
        }
        realmObject.setDate(newObject.getDate() != null ? newObject.getDate() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("News = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(getContent());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tittle:");
        stringBuilder.append(getTittle());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{newstype:");
        stringBuilder.append(getNewstype() != null ? "Newstype" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(getDate());
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
        NewsRealmProxy aNews = (NewsRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aNews.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aNews.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aNews.row.getIndex()) return false;

        return true;
    }

}
