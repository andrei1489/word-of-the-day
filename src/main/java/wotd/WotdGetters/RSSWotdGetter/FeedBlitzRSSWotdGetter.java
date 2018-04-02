package wotd.WotdGetters.RSSWotdGetter;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import wotd.Util.Wotd;
import wotd.WotdGetters.WotdGetter;

import java.io.IOException;
import java.net.URL;

public class FeedBlitzRSSWotdGetter implements WotdGetter{
    private final String rssUrl;
    private final String language;

    public FeedBlitzRSSWotdGetter(String rssUrl, String language) {
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
        String extraData = entry.getDescription().getValue();
        String[][] sentences = this.getSentences(extraData);

        return new Wotd(data[0], data[1], this.language,sentences[1][0], sentences[2][0]);
    }

    private String[][] getSentences(String html){
        Document doc = Jsoup.parse(html);
        Elements tables = doc.select("table");
        String[][] sentences = null;
        for (Element table : tables) {
            Elements trs = table.select("tr");
            sentences = new String[trs.size()][];
            for (int i = 0; i < trs.size(); i++) {
                Elements tds = trs.get(i).select("td");
                sentences[i] = new String[tds.size()];
                for (int j = 0; j < tds.size(); j++) {
                    sentences[i][j] = tds.get(j).text();
                }
            }
        }
        return sentences;
    }
}
