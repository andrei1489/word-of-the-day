package wotd.WotdGetters.RSSWotdGetter;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.jdom.CDATA;
import org.jdom.Element;
import wotd.Util.Wotd;
import wotd.WotdGetters.WotdGetter;

import java.net.URL;
import java.util.List;

public class MerriamWebsterRssWotdGetter implements WotdGetter{
    private String rssUrl;
    private String language;

    public MerriamWebsterRssWotdGetter(String rssUrl, String language) {
        this.rssUrl = rssUrl;
        this.language = language;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public Wotd getWotd() throws Exception {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(new URL(rssUrl)));
        SyndEntry entry = (SyndEntry) feed.getEntries().get(0);
        String word = entry.getTitle();
        CDATA data = (CDATA) ((List<Element>) entry.getForeignMarkup()).get(4).getContent().get(0);
        String definition = data.getText();
        return new Wotd(word,definition,this.language,null,null);
    }
}
