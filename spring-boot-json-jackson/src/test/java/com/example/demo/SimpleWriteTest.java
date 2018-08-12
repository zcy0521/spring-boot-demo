package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class SimpleWriteTest extends TestBase {

    public void testWriteObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JsonOrgModule());

        // Ok: let's create JSONObject from JSON text
        String JSON = "{\"a\":{\"b\":3}}";
        JSONTokener tok = new JSONTokener(JSON);
        JSONObject ob = (JSONObject) tok.nextValue();
        assertEquals(JSON, mapper.writeValueAsString(ob));

        // And for [Issue#2], with null(s):
        JSON = "{\"a\":null}";
        tok = new JSONTokener(JSON);
        ob = (JSONObject) tok.nextValue();
        assertEquals(JSON, mapper.writeValueAsString(ob));
    }

    public void testWriteArray() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JsonOrgModule());

        // Ok: let's create JSONObject from JSON text
        String JSON = "[1,true,\"text\",[null,3],{\"a\":[1.25]}]";
        JSONTokener tok = new JSONTokener(JSON);
        JSONArray ob = (JSONArray) tok.nextValue();
        assertEquals(JSON, mapper.writeValueAsString(ob));
    }

}
