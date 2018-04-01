package wotd.WotdPublishers.slack;

public class SlackMessage {
    private String text;

    public SlackMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
