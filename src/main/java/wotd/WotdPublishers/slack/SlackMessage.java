package wotd.WotdPublishers.slack;

public class SlackMessage {
    private String text;
    private boolean mrkdwn = true;

    SlackMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMrkdwn() {
        return mrkdwn;
    }

    public void setMrkdwn(boolean mrkdwn) {
        this.mrkdwn = mrkdwn;
    }
}
