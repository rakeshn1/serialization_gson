package com.customserialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.serialization.json.model.User;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCustomGsonTest {
    @Test
    public void customGsonLibraryTest() throws Exception {

        String filePath = "src/test/resources/protocols/custom_gson_user.json";
        //Reading from file
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        User deserializedUser = gson1.fromJson(new FileReader(filePath), (Type) User.class);
        assertEquals(456, deserializedUser.getId());
        assertEquals("Pathrose", deserializedUser.getName());
    }
}