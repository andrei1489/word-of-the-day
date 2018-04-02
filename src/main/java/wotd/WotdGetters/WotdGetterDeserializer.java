package wotd.WotdGetters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import wotd.WotdGetters.RSSWotdGetter.FeedBlitzRSSWotdGetter;
import wotd.WotdGetters.RSSWotdGetter.MiriamWebsterRssWotdGetter;

import java.lang.reflect.Type;

public class WotdGetterDeserializer implements JsonDeserializer<WotdGetter>{

    @Override
    public WotdGetter deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WotdGetter getter = null;
        try {
            String url = jsonElement.getAsJsonObject().get("rssUrl").getAsString();
            String language = jsonElement.getAsJsonObject().get("language").getAsString();
            String getterType = jsonElement.getAsJsonObject().get("type").getAsString();
            switch(getterType){
                case "feedblitz": {
                    getter = new FeedBlitzRSSWotdGetter(url, language);
                    break;
                }
                case "miriamwebster": {
                    getter = new MiriamWebsterRssWotdGetter(url, language);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not deserialize getter.\n" + e.getMessage());
        }
        return getter;
    }
}
