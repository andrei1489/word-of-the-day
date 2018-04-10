package wotd.Util;

import wotd.WotdGetters.WotdGetter;
import wotd.WotdPublishers.WotdPublisher;

import java.util.List;

public class AppConfig {
    private List<WotdPublisher> wotdPublisherList;
    private List<WotdGetter> wotdGetterList;
    private String messageTemplate;
    private String exampleTemplate;
    private String exampleTranslatedTemplate;
    private boolean debugEnabled = false;

    public List<WotdPublisher> getWotdPublisherList() {
        return wotdPublisherList;
    }

    public void setWotdPublisherList(List<WotdPublisher> wotdPublisherList) {
        this.wotdPublisherList = wotdPublisherList;
    }

    public List<WotdGetter> getWotdGetterList() {
        return wotdGetterList;
    }

    public void setWotdGetterList(List<WotdGetter> wotdGetterList) {
        this.wotdGetterList = wotdGetterList;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public boolean isDebugEnabled() {
        return debugEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
        this.debugEnabled = debugEnabled;
    }

    public String getExampleTemplate() {
        return exampleTemplate;
    }

    public void setExampleTemplate(String exampleTemplate) {
        this.exampleTemplate = exampleTemplate;
    }

    public String getExampleTranslatedTemplate() {
        return exampleTranslatedTemplate;
    }

    public void setExampleTranslatedTemplate(String exampleTranslatedTemplate) {
        this.exampleTranslatedTemplate = exampleTranslatedTemplate;
    }
}
