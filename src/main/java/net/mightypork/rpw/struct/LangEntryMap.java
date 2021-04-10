package net.mightypork.rpw.struct;

import com.google.gson.reflect.TypeToken;
import net.mightypork.rpw.Const;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class LangEntryMap extends LinkedHashMap<String, LangEntry> {

    private static Type type;

    public static Type getType() {
        if (type == null) {
            type = new TypeToken<LangEntryMap>() {
            }.getType();
        }
        return type;
    }

    public static LangEntryMap fromJson(String json) {
        return Const.GSON.fromJson(json, LangEntryMap.class);
    }

    public String toJson() {
        return Const.GSON.toJson(this);
    }
}
