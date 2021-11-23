package com.customserialization.json.customgson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
public class CustomGson {
    public CustomGson(){

    }
    public String toJson(Object o) {
        //TODO handle complex objects having other objects as members and convert to JSON
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        String ObjectBegin = beginObject();
        stringWriter.write(ObjectBegin);
        Field [] fields = o.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            try {
                String key = fields[i].getName();
                stringWriter.write("\""+key+"\"");
                stringWriter.write(":");
                String value;
                if(fields[i].getType().getSimpleName().equals("Map")){
                    value = handleMap((Map<String, String>) fields[i].get(o));
                    if(i != fields.length-1){
                        stringWriter.write(value);
                        stringWriter.write(",");
                    }else{
                        stringWriter.write(value);
                    }
                }else{
                    value = fields[i].get(o).toString();
                    if(i != fields.length-1){
                        stringWriter.write("\""+value+"\"");
                        stringWriter.write(",");
                    }else{
                        stringWriter.write("\""+value+"\"");
                    }
                }

            }catch (Exception e){
                return "Exception: "+e;
            }
        }
        String ObjectEnd = endObject();
        stringWriter.write(ObjectEnd);

        // Serialization with JsonWriter library
        /*JsonObject jsonObj = Json.createObjectBuilder()
                .add("id", 456)
                .add("name", "Pathrose")
                .add("age", 35)
                .add("netSalary", 75000)
                .add("homeAddress", Json.createObjectBuilder().add("streetName", "31st street Banashankari")
                                .add("city", "Bangalore")
                                .add("zipCode", "560084")
                                .build()
                )
                .add("phoneNumbers", Json.createArrayBuilder().add("9959984000")
                                .add("7702144400")
                                .build()
                )
                .build();
        JsonWriter jsonWriter;
        jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(jsonObj);
        jsonWriter.close();*/

        System.out.println(stringWriter.getBuffer().toString());
        return stringWriter.getBuffer().toString();
    }

    public String beginObject() {
        return "{";
    }

    public String endObject() {
        return "}";
    }

    public String beginArray(){
        return "[";
    }

    public String endArray(){
        return "]";
    }

    public String handleMap(Map<String, String> m){
        String result = beginObject();
        for (Map.Entry<String,String> entry : m.entrySet()){
            result += "\""+entry.getKey()+"\"";
            result += ":";
            result += "\""+entry.getValue()+"\"";

            //Just a quick fix
            if(entry.getKey() == "salary"){
                result += ",";
            }
        }
        result += endObject();
        return result;
    }
}
