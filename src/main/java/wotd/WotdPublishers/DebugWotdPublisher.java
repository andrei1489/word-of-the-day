package wotd.WotdPublishers;

import wotd.Util.AppConfig;
import wotd.Util.MessageFormatter;
import wotd.Util.Wotd;

public class DebugWotdPublisher implements WotdPublisher {

    @Override
    public void publishWotd(Wotd wotd, AppConfig config) {
        System.out.println(MessageFormatter.formatMessage(wotd, config));
    }
}
