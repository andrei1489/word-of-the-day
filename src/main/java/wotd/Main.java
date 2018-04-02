package wotd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import wotd.Util.AppConfig;
import wotd.Util.WotdTask;
import wotd.WotdGetters.WotdGetter;
import wotd.WotdGetters.WotdGetterDeserializer;
import wotd.WotdPublishers.DebugPublisher;
import wotd.WotdPublishers.Publisher;
import wotd.WotdPublishers.slack.SlackPublisher;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Gson gson = new GsonBuilder().registerTypeAdapter(WotdGetter.class, new WotdGetterDeserializer()).create();
        try (FileReader fileReader = new FileReader("config.json")) {
            AppConfig config = gson.fromJson(fileReader, AppConfig.class);
            Publisher publisher = config.isDebugEnabled() ? new DebugPublisher(config) : new SlackPublisher(config);
            scheduler.scheduleWithFixedDelay(new WotdTask(config, publisher), 0, 1, TimeUnit.DAYS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
