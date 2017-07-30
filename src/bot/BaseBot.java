package bot;

import core.Client;

public abstract class BaseBot {
    protected Client mudClient;
    protected boolean enabled = true;
    public BaseBot(Client mudClient) {
        this.mudClient = mudClient;
    }

    public void trigger(String content) {
        if (enabled) publish(content);
    }

    public abstract String toString();
    protected abstract void publish(String content);

    public void toggleEnable(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEnable() {
        if (enabled) { return "+";}
        else { return "-";}
    }
}
