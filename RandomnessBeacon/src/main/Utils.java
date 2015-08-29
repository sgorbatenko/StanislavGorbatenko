
package main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Utils
{
    public static Map<String, Integer> getCharsOccurrencesMap(String[] outputValueArr)
    {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        for (String key : outputValueArr)
        {
            if (resultMap.containsKey(key))
                resultMap.put(key, resultMap.get(key) + 1);
            else if (!key.equals(""))
                resultMap.put(key, 1);
        }
        return resultMap;
    }

    public static Document parseXML(InputStream stream)
        throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch (Exception ex)
        {
            throw ex;
        }

        return doc;
    }
}
