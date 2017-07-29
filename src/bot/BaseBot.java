package bot;

import core.Client;

public abstract class BaseBot {
    protected Client mudClient;
    public BaseBot(Client mudClient) {
        this.mudClient = mudClient;
    }

    public abstract void publish(String content);
}
