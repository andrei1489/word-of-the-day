package wotd.Util;

import wotd.WotdGetters.WotdGetter;

import java.util.List;

public class AppConfig {
    private String slackUrl;
    private List<WotdGetter> getterList;
    private String messageTemplate;
    private String exampleTemplate;
    private String exampleTranslatedTemplate;
    private boolean debugEnabled = false;

    public String getSlackUrl() {
        return slackUrl;
    }

    public void setSlackUrl(String slackUrl) {
        this.slackUrl = slackUrl;
    }

    public List<WotdGetter> getGetterList() {
        return getterList;
    }

    public void setGetterList(List<WotdGetter> getterList) {
        this.getterList = getterList;
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
