package com.customserialization.json.customgson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
public class CustomGson {
    public CustomGson(){

    }
    public String toJson(Object o) {
        //TODO handle complex objects as input arguments and convert to JSON
        StringWriter stringWriter;
        stringWriter = new StringWriter();
        stringWriter.write("{");
        for(Field field: o.getClass().getDeclaredFields()){
            try {
                String key = field.getName();
                stringWriter.write("\""+key+"\"");
                stringWriter.write(":");
                String value = field.get(o).toString();
                if(key == "id"){
                    stringWriter.write(value);
                    stringWriter.write(",");
                }else{
                    stringWriter.write("\""+value+"\"");
                }

            }catch (Exception e){
                return "Exception: "+e;
            }
        }
        stringWriter.write("}");

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
}
