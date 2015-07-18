
package test;

import java.util.HashMap;
import java.util.Map;

import main.Utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest
{
    @Test(enabled = true)
    public void testBoundaryNotEqual()
    {
        String[] testData = {"1", "2", "4", "1"};
        Map expected = new HashMap<>();
        expected.put("1", 2);
        expected.put("2", 1);
        expected.put("4", 1);

        Map actual = Utils.getCharsOccurrencesMap(testData);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testBoundaryEqual()
    {
        String[] testData = {"1", "1", "4", "4"};
        Map expected = new HashMap<>();
        expected.put("1", 2);
        expected.put("4", 2);

        Map actual = Utils.getCharsOccurrencesMap(testData);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testEmpty()
    {
        String[] testData = {""};
        Map expected = new HashMap<>();

        Map actual = Utils.getCharsOccurrencesMap(testData);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAllEqual()
    {
        String[] testData = {"5", "5", "5", "5", "5", "5", "5"};
        Map expected = new HashMap<>();
        expected.put("5", 7);
        Map actual = Utils.getCharsOccurrencesMap(testData);
        Assert.assertEquals(actual, expected);
    }
}
