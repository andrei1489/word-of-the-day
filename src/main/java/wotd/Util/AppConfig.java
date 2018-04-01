package wotd.Util;

import wotd.WotdGetters.RSSWotdGetter.RSSWotdGetter;

import java.util.List;

public class AppConfig {
    private String slackUrl;
    private List<RSSWotdGetter> getterList;
    private String message;

    public String getSlackUrl() {
        return slackUrl;
    }

    public void setSlackUrl(String slackUrl) {
        this.slackUrl = slackUrl;
    }

    public List<RSSWotdGetter> getGetterList() {
        return getterList;
    }

    public void setGetterList(List<RSSWotdGetter> getterList) {
        this.getterList = getterList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
