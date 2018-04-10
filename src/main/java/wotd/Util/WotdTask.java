package wotd.Util;

import wotd.WotdGetters.WotdGetter;
import wotd.WotdPublishers.WotdPublisher;

public class WotdTask implements Runnable {
    private AppConfig config;
    private WotdPublisher wotdPublisher;

    public WotdTask(AppConfig config, WotdPublisher wotdPublisher) {
        this.config = config;
        this.wotdPublisher = wotdPublisher;
        System.out.println("Created Task");
    }

    @Override
    public void run() {
        System.out.println("Started Task");
        for (WotdGetter getter: config.getWotdGetterList()){
            try {
                wotdPublisher.publishWotd(getter.getWotd(), config);
            } catch (Exception e) {
                System.out.println("Could not get wotd for " + getter.getLanguage());
            }
        }
    }
}
