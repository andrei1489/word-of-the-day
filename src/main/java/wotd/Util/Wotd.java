package wotd.Util;

public class Wotd {
    private String word;
    private String translation;
    private String language;

    public Wotd(String word, String translation, String language) {
        this.word = word;
        this.translation = translation;
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Wotd{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
