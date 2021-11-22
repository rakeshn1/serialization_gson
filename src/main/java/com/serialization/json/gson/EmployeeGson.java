
package com.serialization.json.gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.serialization.json.model.HomeAddress;
import com.serialization.json.model.Employee;
import com.serialization.json.model.User;

public class EmployeeGson {

    public static void main(String[] args) throws IOException {
        Employee employeeZeo = createEmployeeEntry();

        // Get new Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // read the stored JSON file data as String
        String fileToParse = new String(Files.readAllBytes(Paths
                .get("employee.txt")));

        // parse the prepared json string to object using an already defined class
        Employee employeeFirst = gson.fromJson(fileToParse, Employee.class);

        // print data
        System.out.println("\n\nEmployee Object after parsing\n\n" + employeeFirst);

        // create a JSON String from a created Object
        String jsonConvertedEmployee = gson.toJson(employeeZeo);
        System.out.print(jsonConvertedEmployee);

        //Writing it to a file
        User user = createUser();
        String filePath = "src/test/resources/protocols/gson_user.json";
        Writer writer = new FileWriter(filePath);
        Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
        gson1.toJson(user, writer);

        writer.flush();
        writer.close();
    }

    public static Employee createEmployeeEntry() {

        Employee employeeObj = new Employee();

        employeeObj.setId(1001);
        employeeObj.setPhoneNumbers(new long[] { 12341324, 68765674 });
        employeeObj.setName("Luxembourg");
        employeeObj.setRole("Senior Manager");
        employeeObj.setPermanentEmployee(false);

        HomeAddress add = new HomeAddress();
        add.setCity("Bangalore");
        add.setStreetName("Banashankari 1st Stage");
        add.setZipcode(560101);
        employeeObj.setHomeAddress(add);

        List<String> locations = new ArrayList<String>();
        locations.add("San Francisco");
        locations.add("Seattle");
        employeeObj.setLocations(locations);

        Map<String, String> attrs = new HashMap<String, String>();
        attrs.put("salary", "20500");
        attrs.put("age", "29 years");
        employeeObj.setAttributes(attrs);

        return employeeObj;
    }

    public static User createUser() {

        User user = new User();
        user.setId(1001);
        user.setName("Luxembourg");
        return user;

    }
}

