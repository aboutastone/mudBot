package bot;

import core.Client;

public class LoginBot extends BaseBot{
    public LoginBot(Client mudClient) {
        super(mudClient);
    }

    public void publish(String content) {
        if (content.contains("Welcome to Xi You Ji! Select GB or BIG5")) {
            mudClient.sendMessage("gb");
        }
    }
}
