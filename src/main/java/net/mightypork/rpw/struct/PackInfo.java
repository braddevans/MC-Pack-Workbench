package net.mightypork.rpw.struct;

public class PackInfo {

    public int pack_format;
    public String description;

    public PackInfo() {
    }

    public PackInfo(int format, String desc) {
        pack_format = format;
        description = desc;
    }

    @Override
    public String toString() {
        return "\"pack\": {\"pack_format\": " + pack_format + ", \"description\": \"" + description + "\"}";
    }
}
