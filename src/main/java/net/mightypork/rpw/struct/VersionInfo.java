package net.mightypork.rpw.struct;

import com.google.gson.reflect.TypeToken;
import net.mightypork.rpw.Const;

import java.lang.reflect.Type;

public class VersionInfo {

    private static Type versionInfoType;

    public String id;
    public String type;
    public String assets;

    public static Type getType() {
        if (versionInfoType == null) {
            versionInfoType = new TypeToken<VersionInfo>() {
            }.getType();
        }
        return versionInfoType;
    }

    public static VersionInfo fromJson(String json) {
        return Const.GSON.fromJson(json, getType());
    }

    public String toJson() {
        return Const.GSON.toJson(this);
    }

    public boolean isReleaseOrSnapshot() {
        return type != null && (type.equals("release") || type.equals("snapshot"));
    }

}
