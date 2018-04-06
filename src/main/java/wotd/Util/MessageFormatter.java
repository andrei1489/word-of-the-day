package wotd.Util;

public class MessageFormatter {
    public static String formatMessage(Wotd wotd, AppConfig config){
        String compiledMessage = String.format(config.getMessageTemplate(), wotd.getLanguage(), wotd.getPartOfSpeech(),
                wotd.getWord(), wotd.getTranslation());

        if(wotd.getExampleSentence() != null ){
            compiledMessage += String.format(config.getExampleTemplate(), wotd.getExampleSentence());
        }

        if(wotd.getExampleSentenceTranslated() != null){
            compiledMessage += String.format(config.getExampleTranslatedTemplate(), wotd.getExampleSentenceTranslated());
        }
        return compiledMessage;
    }
}
