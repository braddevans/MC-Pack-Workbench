package net.mightypork.rpw.struct;

import com.google.gson.reflect.TypeToken;
import net.mightypork.rpw.Const;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;

public class FileObjectIndex {

    private static Type type;

    public boolean virtual;
    public LinkedHashMap<String, FileObject> objects;

    public static Type getType() {
        if (type == null) {
            type = new TypeToken<FileObjectIndex>() {
            }.getType();
        }
        return type;
    }

    public static FileObjectIndex fromJson(String json) {
        return Const.GSON.fromJson(json, getType());
    }

    public String toJson() {
        return Const.GSON.toJson(this);
    }
}
