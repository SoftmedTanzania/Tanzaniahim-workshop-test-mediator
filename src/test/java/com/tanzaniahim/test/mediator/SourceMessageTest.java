package com.tanzaniahim.test.mediator;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class SourceMessageTest {
    @Test
    public void testSerialization() throws Exception{
        InputStream inputStream = SourceMessageTest.class.getClassLoader().getResourceAsStream("source.json");

        SourceMessage sourceMessage = new Gson().fromJson(IOUtils.toString(inputStream),SourceMessage.class);
        Assert.assertNotNull(sourceMessage);

        JSONObject message = new JSONObject(new Gson().toJson(sourceMessage));

        Assert.assertTrue(message.has("name"));
        Assert.assertTrue(message.has("zone"));
        Assert.assertTrue(message.has("council"));
        Assert.assertTrue(message.has("ward"));
        Assert.assertTrue(message.has("village"));
        Assert.assertTrue(message.has("latitude"));
        Assert.assertTrue(message.has("longitude"));

        Assert.assertFalse(message.has("Name"));
        Assert.assertFalse(message.has("Zone"));
        Assert.assertFalse(message.has("Council"));
        Assert.assertFalse(message.has("Ward"));
        Assert.assertFalse(message.has("Village"));
        Assert.assertFalse(message.has("Latitude"));
        Assert.assertFalse(message.has("Longitude"));
    }

}