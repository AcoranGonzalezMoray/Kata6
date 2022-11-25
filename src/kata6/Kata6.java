package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        Cocktails resultPojo = GsonMethod.init( new URL("https://www.thecocktaildb.com/api/json/v1/1/random.php"));
        System.out.println(resultPojo);
        JAXBMethod.init(resultPojo);
    }
    //Formato json
    public class  GsonMethod{
        
        public static Cocktails init(URL url) throws IOException{
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(read(url), JsonObject.class).getAsJsonObject().get("drinks").getAsJsonArray().get(0).getAsJsonObject();
            Cocktails cocktail = gson.fromJson(jsonObject, Cocktails.class);
            return cocktail;
        }

        
        private static String read(URL url) throws IOException {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                return reader.lines().collect(joining());
            }           
        }
    
    } 
    //Formato xml
    public class  JAXBMethod{
        
        public static void init(Cocktails cocktail) throws IOException, JAXBException{
            JAXBContext context = JAXBContext.newInstance(Cocktails.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(cocktail, System.out);
        }
 
    } 
}
