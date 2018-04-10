package wotd.WotdPublishers;

import wotd.Util.AppConfig;
import wotd.Util.Wotd;

public interface WotdPublisher {
    public void publishWotd(Wotd wotd, AppConfig config);
}
