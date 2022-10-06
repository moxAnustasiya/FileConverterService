package JSON;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static Read.ReadJSON.read;

public class jsontoxml
{
    private static JSONObject object = new JSONObject();
    private static Hospital hospital;
    public jsontoxml(File file)
    {
        JSONParser parser = new JSONParser();
        try
        {
            JSONObject object = (JSONObject) parser.parse(new FileReader(file.getName()));
            this.object = object;
        }
        catch (IOException | ParseException ex) {Logger.getLogger(jsontoxml.class.getName());}
    }
    private static void Reading()
    {
        hospital = read(object);
    }
}
