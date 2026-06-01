package utilities;

import payLoads.CreateUserPayload;
import payLoads.UpdateUserPayload;

import java.util.HashMap;

public class TestDataBuilder {

    public static CreateUserPayload createUserPayload() {

        CreateUserPayload payload =
                new CreateUserPayload();

        payload.setName("Seenu");
        payload.setJob("Automation Tester");

        return payload;
    }
    public static CreateUserPayload updateUserPayload(){
        CreateUserPayload payload = new CreateUserPayload();
        payload.setName("Seenu");
        payload.setJob("Senior Automation Tester");
        return payload;

    }
    public static HashMap<String,Object> patchUserPayLoad(){
        HashMap<String,Object> payload = new HashMap<>();
        payload.put("job","Lead Automation Tester");
        return payload;
    }
}