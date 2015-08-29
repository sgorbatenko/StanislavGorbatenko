
package main;

import java.net.HttpURLConnection;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class RestClientApp
{
    public static void main(String[] args)
    {
        try
        {
            new RestClientApp().start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void start() throws Exception
    {
        calcCharOccurrences();
    }

    public void calcCharOccurrences() throws Exception
    {
        String outputValue = getLastOutputValue();
        String[] outputValueArr = outputValue.split("");
        System.out.println(Utils.getCharsOccurrencesMap(outputValueArr));
    }

    public String getLastOutputValue() throws Exception
    {
        URL url = new URL("https://beacon.nist.gov/rest/record/last");
        return getOutputValue(url);
    }

    public static String getForTimeStampOutputValue(String timestamp) throws Exception
    {
        URL url = new URL("https://beacon.nist.gov/rest/record/" + timestamp);
        return getOutputValue(url);
    }

    private static String getOutputValue(URL url) throws Exception
    {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        Document doc = Utils.parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("outputValue");

        String outputValue = descNodes.item(0).getTextContent();
        return outputValue;
    }

}