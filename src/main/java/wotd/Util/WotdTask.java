package wotd.Util;

import wotd.Util.AppConfig;
import wotd.WotdGetters.WotdGetter;
import wotd.WotdPublishers.Publisher;

public class WotdTask implements Runnable {
    private AppConfig config;
    private Publisher publisher;

    public WotdTask(AppConfig config, Publisher publisher) {
        this.config = config;
        this.publisher = publisher;
        System.out.println("Created Task");
    }

    @Override
    public void run() {
        System.out.println("Started Task");
        for (WotdGetter getter: config.getGetterList()){
            try {
                publisher.publishWotd(getter.getWotd());
            } catch (Exception e) {
                System.out.println("Could not get wotd for " + getter.getLanguage());
            }
        }
    }
}
