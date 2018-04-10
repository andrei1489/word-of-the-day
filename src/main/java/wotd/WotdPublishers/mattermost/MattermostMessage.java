package wotd.WotdPublishers.mattermost;

public class MattermostMessage {
    private String text;
    private String username;

    public MattermostMessage(String text, String user) {
        this.text = text;
        this.username = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
