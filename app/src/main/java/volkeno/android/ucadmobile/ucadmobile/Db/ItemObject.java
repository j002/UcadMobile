package volkeno.android.ucadmobile.ucadmobile.Db;

/**
 * Created by number on 21/09/15.
 */
public class ItemObject {

    private   int   screenShot ;
    private   String title;
    private   String textcontent;
    public ItemObject(int screenShot, String title, String textcontent)   {
        this . screenShot   =   screenShot ;
        this .title = title;
        this .textcontent = textcontent;
    }
    public ItemObject(String Title)   {
        this . title   =   Title ;

    }
    public   int   getScreenShot ( )   {
        return   screenShot ;
    }

    public   String getTitte()   {
        return title;
    }

    public   String getTextcontent()   {
        return textcontent;
    }
}
