package wotd.Util;

public class MessageFormatter {
    public static String formatMessage(Wotd wotd, AppConfig config){
        String compiledMessage = String.format(config.getMessageTemplate(), wotd.getLanguage(), wotd.getWord(),
                wotd.getTranslation());
        if(wotd.getExampleSentence() != null && wotd.getExampleSentenceTranslated() != null){
            compiledMessage += String.format(config.getExampleTemplate(),
                    wotd.getExampleSentence(), wotd.getExampleSentenceTranslated());
        }
        return compiledMessage;
    }
}
