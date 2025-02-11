package net.mightypork.rpw.struct;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Sound sub-entry (one of the sounds assigned to a sound entry)
 *
 * @author Ondřej Hruška (MightyPork)
 */
public class SoundSubEntry {

    /**
     * Resource name (path) - eg. random/splash
     */
    public String name;
    /**
     * Be streamed (not loaded all at once)
     */
    public boolean stream = false;

    public SoundSubEntry() {
    }
    public SoundSubEntry(String name) {
        name = name.replace('\\', '/');
        this.name = name;
        this.stream = false;
    }

    public SoundSubEntry(String name, boolean stream) {
        name = name.replace('\\', '/');
        this.name = name;
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "S(\"" + name + "\", stream: " + stream + ")";
    }

    public static class Deserializer implements JsonDeserializer<SoundSubEntry> {

        @Override
        public SoundSubEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                if (json.isJsonObject()) {
                    final JsonObject jso = json.getAsJsonObject();

                    String name = jso.get("name").getAsString();
                    return new SoundSubEntry(name, jso.get("stream").getAsBoolean());
                }

                return new SoundSubEntry(json.getAsJsonPrimitive().getAsString());
            }
            catch (final ClassCastException e) {
                throw new JsonParseException("Failed to parse sound sub-entry.");
            }
        }
    }

    public static class Serializer implements JsonSerializer<SoundSubEntry> {

        @Override
        public JsonElement serialize(SoundSubEntry src, Type typeOfSrc, JsonSerializationContext context) {
            if (src.stream == false) {
                return new JsonPrimitive(src.name);
            }

            final JsonObject jsonobj = new JsonObject();
            jsonobj.addProperty("name", src.name);
            jsonobj.addProperty("stream", src.stream);
            return jsonobj;
        }
    }
}
