package core;

import bot.BaseBot;
import bot.FightDragon;
import bot.LoginBot;

import java.util.ArrayList;
import java.util.List;

public class LoginInstance implements Runnable {
    private String host, username, password;
    private int port;

    public LoginInstance(String host, int port, String username, String password) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.password = password;
    }

    @Override
    public void run() {
        Client client = new Client();
        client.connect(host, port);

        List<BaseBot> botList = new ArrayList();
        botList.add(new LoginBot(client,username,password));
        botList.add(new FightDragon(client));

        //new RESTServer(client,botList);

        BotPlatform platform = new BotPlatform(client,botList);
        platform.run();
        client.disconnect();
    }
}
