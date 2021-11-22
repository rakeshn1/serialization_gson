package com.customserialization.json;

import com.customserialization.json.customgson.CustomGson;
import com.serialization.json.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeCustomGson {
    public static void main(String[] args) throws IOException {
        CustomGson customGson = new CustomGson();
        User user = createUser();
        String jsonResult = customGson.toJson(user);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/test/resources/protocols/custom_gson_user.json");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        BufferedWriter out = new BufferedWriter(fileWriter);
        out.write(jsonResult);
        out.close();
    }

    public static User createUser() {

        User user = new User();
        user.setId(456);
        user.setName("Pathrose");
        return user;

    }
}
