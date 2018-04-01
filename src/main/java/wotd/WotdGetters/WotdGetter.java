package wotd.WotdGetters;

import wotd.Util.Wotd;

public interface WotdGetter {
    public String getLanguage();
    public Wotd getWotd() throws Exception;
}
