package driverFactory.Web;

import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static boolean compareList(List l1, List l2){
        if (l1.size()== l2.size()){
            for (Object l:l1){
               if(!l2.contains(l)){
                   return false;
               }
            }
        }else {
            return false;
        }
        return true;
    }

   public static List<String> convertJsonArrayToList(JSONArray arr){
        List <String> values = new ArrayList<>();
       for (Object o : arr) {
           values.add((String) o);
       }
        return values;
   }
}
