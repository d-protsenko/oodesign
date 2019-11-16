package ru.omsu.imit.adapter;

import com.google.gson.Gson;
import ru.omsu.imit.abstract_factory.Phone;

public class PhoneToJsonAdapter {
    public static String convertPhoneToJson(Phone phone){
        Gson gson = new Gson();
        return gson.toJson(phone);
    }
}
