package wotd.Util;

public class Wotd {
    private String word;
    private String translation;
    private String language;
    private String exampleSentence;
    private String exampleSentenceTranslated;
    private String partOfSpeech;

    public Wotd(String word, String translation, String language, String exampleSentence, String exampleSentenceTranslated, String partOfSpeech) {
        this.word = word;
        this.translation = translation;
        this.language = language;
        this.exampleSentence = exampleSentence;
        this.exampleSentenceTranslated = exampleSentenceTranslated;
        this.partOfSpeech = partOfSpeech;
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

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getExampleSentenceTranslated() {
        return exampleSentenceTranslated;
    }

    public void setExampleSentenceTranslated(String exampleSentenceTranslated) {
        this.exampleSentenceTranslated = exampleSentenceTranslated;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public String toString() {
        return "Wotd{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", language='" + language + '\'' +
                ", exampleSentence='" + exampleSentence + '\'' +
                ", exampleSentenceTranslated='" + exampleSentenceTranslated + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                '}';
    }
}
