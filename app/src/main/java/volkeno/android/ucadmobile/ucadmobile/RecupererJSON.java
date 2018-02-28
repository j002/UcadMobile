package volkeno.android.ucadmobile.ucadmobile; /**
 * Created by prince on 9/22/15.
 */
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


//import volkeno.android.ucadmobile.ucadmobile.InputStreamOperations;
import volkeno.android.ucadmobile.ucadmobile.objectforactuality.News;

public class RecupererJSON {
    /**
     * Récupère une liste de personnes.
     * @return ArrayList<Personne>: ou autre type de données.
     */
    public static ArrayList<News> getPersonnes() {

        ArrayList<News> personnes = new ArrayList<News>();

        try {
            String myurl= "http://www.exemple.com/getPersonnes";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString("personnes"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Personne - Objet JSON
                News personne = new News();
                personne.setContent(obj.getString("nom"));
                personne.setTittle(obj.getString("prenom"));
                // On ajoute la personne à la liste
                personnes.add(personne);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
        return personnes;
    }
}
