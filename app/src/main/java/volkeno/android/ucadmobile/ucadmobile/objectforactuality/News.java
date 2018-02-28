package volkeno.android.ucadmobile.ucadmobile.objectforactuality;


import io.realm.RealmObject;
//import io.realm.annotations.PrimaryKey;

/**
 * Created by number on 17/09/15.
 */
public class News extends RealmObject {

    //@PrimaryKey

    private int id;
    private String content;
    private String tittle;
    private Newstype newstype;
    private String date;
    //private ImageView image;

    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;

    }
    public String getContent() {

        return content;

    }

    public void setContent(String content) {

        this.content = content;

    }


    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public String getTittle() {
        return tittle;
    }

    public String getDate() {
        return date;

    }



    public void setDate(String date) {

        this.date = date;

    }

    public Newstype getNewstype() {
        return newstype;
    }

    public void setNewstype(Newstype newstype) {

        this.newstype = newstype;

    }
}




