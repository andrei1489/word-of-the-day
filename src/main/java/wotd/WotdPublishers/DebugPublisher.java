package wotd.WotdPublishers;

import wotd.Util.AppConfig;
import wotd.Util.MessageFormatter;
import wotd.Util.Wotd;

public class DebugPublisher implements Publisher{
    private AppConfig config;
    public DebugPublisher(AppConfig config) {
        this.config = config;
    }

    @Override
    public void publishWotd(Wotd wotd) {
        System.out.println(MessageFormatter.formatMessage(wotd, config));
    }
}
