
package main;

import java.io.InputStream;
import java.util.Arrays;
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
        Arrays.sort(outputValueArr);

        int i;
        if (outputValueArr[0].equals(""))
        {
            i = 2;
        }
        else
        {
            i = 1;
        }

        for (int count = 1; i < outputValueArr.length; count++, i++)
        {
            if (!outputValueArr[i].equals(outputValueArr[i - 1]) || i == outputValueArr.length - 1)
            {
                if (i == outputValueArr.length - 1 && !outputValueArr[i].equals(outputValueArr[i - 1]))
                {
                    resultMap.put(outputValueArr[i - 1], count);
                    resultMap.put(outputValueArr[i], 1);
                    break;
                }
                if (i == outputValueArr.length - 1 && outputValueArr[i].equals(outputValueArr[i - 1]))
                {
                    resultMap.put(outputValueArr[i], count + 1);
                    break;
                }

                resultMap.put(outputValueArr[i - 1], count);
                count = 0;
            }
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
