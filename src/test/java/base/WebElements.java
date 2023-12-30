package base;
import java.util.HashMap;


public class WebElements {
    public HashMap<String, HashMap<String, String>> elements = new HashMap<String, HashMap<String, String>>();
    public WebElements() {
        elements.put("search_box", buildHashMap("name", "0", "q"));
        }

    private HashMap<String, String> buildHashMap(String method, String order, String value){
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("method", method);
        tmp.put("order", order);
        tmp.put("value", value);
        return tmp;
    }
}
