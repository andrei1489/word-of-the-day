package wotd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import wotd.Util.AppConfig;
import wotd.Util.WotdTask;
import wotd.WotdGetters.WotdGetter;
import wotd.WotdGetters.WotdGetterDeserializer;
import wotd.WotdPublishers.DebugWotdPublisher;
import wotd.WotdPublishers.WotdPublisher;
import wotd.WotdPublishers.WotdPublisherDeserializer;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(WotdGetter.class, new WotdGetterDeserializer())
                .registerTypeAdapter(WotdPublisher.class, new WotdPublisherDeserializer())
                .create();
        try (FileReader fileReader = new FileReader("config.json")) {
            AppConfig config = gson.fromJson(fileReader, AppConfig.class);
            if (config.isDebugEnabled()){
                scheduler.scheduleWithFixedDelay(new WotdTask(config, new DebugWotdPublisher()), 0, 1, TimeUnit.DAYS);
            } else {
                for (WotdPublisher publisher: config.getWotdPublisherList()){
                    scheduler.scheduleWithFixedDelay(new WotdTask(config, publisher), 0, 1, TimeUnit.DAYS);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
