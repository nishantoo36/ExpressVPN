package driverFactory.Web;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class JsonReader {

    JSONParser parser = new JSONParser();
    public  static JSONObject Jsonobject = null;
    private static String commonConfigFilePath = null;

    public JsonReader(String lang){
        commonConfigFilePath = System.getProperty("user.dir") + "/src/main/resources/Data" + "/" + lang + ".json";
        readJsonData();
    }

    public void readJsonData(){
        try {
            Object obj = parser.parse(new FileReader(commonConfigFilePath));
            Jsonobject = (JSONObject) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getJsonDataWithJsonPath(String path){
        String [] pathData= path.split("-");
        int len =pathData.length;
        if(len==1){
            return (String) JsonReader.Jsonobject.get(pathData[0]);
        }else {
            JSONObject jsonObject = (JSONObject) JsonReader.Jsonobject.get(pathData[0]);
            for (int i = 1; i < len - 1; i++) {
                jsonObject = (JSONObject) jsonObject.get(pathData[i]);
            }
            return (String) jsonObject.get(pathData[len - 1]);
        }
    }

}
