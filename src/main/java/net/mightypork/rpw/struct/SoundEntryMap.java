package net.mightypork.rpw.struct;

import com.google.gson.reflect.TypeToken;
import net.mightypork.rpw.Const;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class SoundEntryMap extends LinkedHashMap<String, SoundEntry> {

    private static Type type = null;

    public static Type getType() {
        if (type == null) {
            type = new TypeToken<SoundEntryMap>() {
            }.getType();
        }
        return type;
    }

    public static SoundEntryMap fromJson(String json) {
        SoundEntryMap sem = Const.GSON.fromJson(json, getType());

        return sem;
    }

    public String toJson() {
        return Const.GSON.toJson(this);
    }
}
