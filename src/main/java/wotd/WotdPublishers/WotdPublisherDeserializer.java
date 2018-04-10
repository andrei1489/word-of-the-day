package wotd.WotdPublishers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import wotd.WotdPublishers.mattermost.MattermostWotdPublisher;
import wotd.WotdPublishers.slack.SlackWotdPublisher;

import java.lang.reflect.Type;

public class WotdPublisherDeserializer implements JsonDeserializer<WotdPublisher>{

    @Override
    public WotdPublisher deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WotdPublisher publisher = null;
        try {
            String url = jsonElement.getAsJsonObject().get("url").getAsString();
            String publisherType = jsonElement.getAsJsonObject().get("type").getAsString();
            switch(publisherType){
                case "slack": {
                    publisher = new SlackWotdPublisher(url);
                    break;
                }
                case "mattermost": {
                    String username = jsonElement.getAsJsonObject().get("username").getAsString();
                    publisher = new MattermostWotdPublisher(url, username);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not deserialize publisher.\n" + e.getMessage());
        }
        return publisher;
    }
}
