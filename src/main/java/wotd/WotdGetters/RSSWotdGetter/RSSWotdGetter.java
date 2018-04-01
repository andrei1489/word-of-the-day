package wotd.WotdGetters.RSSWotdGetter;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import wotd.Util.Wotd;
import wotd.WotdGetters.WotdGetter;

import java.io.IOException;
import java.net.URL;

public class RSSWotdGetter implements WotdGetter{
    private final String rssUrl;
    private final String language;

    public RSSWotdGetter(String rssUrl, String language) {
        this.rssUrl = rssUrl;
        this.language = language;
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    public Wotd getWotd() throws IOException, FeedException {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(new URL(rssUrl)));
        SyndEntry entry = (SyndEntry) feed.getEntries().get(0);
        String[] data = entry.getTitleEx().getValue().split(": ");
        Wotd wotd = new Wotd(data[0], data[1], this.language);
        return wotd;
    }
}
