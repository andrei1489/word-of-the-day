package wotd.WotdGetters.RSSWotdGetter;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.jdom.CDATA;
import org.jdom.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import wotd.Util.Wotd;
import wotd.WotdGetters.WotdGetter;

import java.net.URL;
import java.util.List;

public class MerriamWebsterRssWotdGetter implements WotdGetter {
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
        String[] sentencesAndPos = getSentencesAndPOS(entry.getDescription().getValue());
        return new Wotd(word, definition, this.language, sentencesAndPos[0], null, sentencesAndPos[1]);
    }

    private String[] getSentencesAndPOS(String html) {
        String[] sentencesAndPos = new String[2];
        Document doc = Jsoup.parse(html);
        Elements paragraphs = doc.select("p");
        for (int index = 0; index < paragraphs.size(); index++) {
            if (paragraphs.get(index).text().contains("Examples")) {
                sentencesAndPos[0] = paragraphs.get(index + 1).text();
                break;
            }
        }
        sentencesAndPos[1] = paragraphs.get(1).select("em").get(0).text();
        return sentencesAndPos;
    }
}
