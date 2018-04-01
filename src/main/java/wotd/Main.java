package wotd;

import com.google.gson.Gson;
import wotd.Util.AppConfig;
import wotd.Util.WotdTask;
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
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader("config.json")) {
            AppConfig config = gson.fromJson(fileReader, AppConfig.class);
            Publisher publisher = new SlackPublisher(config);
            scheduler.scheduleWithFixedDelay(new WotdTask(config, publisher), 0, 1, TimeUnit.DAYS);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
