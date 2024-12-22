package testData;

import java.util.HashMap;

public class PetStoreData {


    public HashMap<String, Object> setupTestData(){

        HashMap<String, Object> sixthPet = new HashMap<>();
        sixthPet.put("id", 9223372016900014766L);
        sixthPet.put("category_id", 0);
        sixthPet.put("category_name", "string");
        sixthPet.put("name", "doggie");
        sixthPet.put("tags_id", 0);
        sixthPet.put("profile_image", "string");

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode", 200);
        expectedData.put("once_pet_id", 9223372016900014737L);
        expectedData.put("second_name", "prueba otro name");
        expectedData.put("fifth_name", "doggie");
        expectedData.put("sixthPet", sixthPet);

        return expectedData;

    }


}
