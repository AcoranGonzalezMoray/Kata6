package kata6;
import javax.xml.bind.annotation.XmlRootElement;


// POJO
@XmlRootElement
public class Cocktails {
    public String idDrink;
    public String strDrink;
    public String strAlcoholic;
    public String strGlass;
    public String strInstructions;


    @Override
    public String toString() {
        return "Cocktails{" + "idDrink=" + idDrink + ", strDrink=" + strDrink + ", strAlcoholic=" + strAlcoholic + ", strGlass=" + strGlass + ", strInstructions=" + strInstructions + '}';
    }


     
}
