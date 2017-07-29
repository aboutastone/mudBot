package core;

import bot.BaseBot;
import bot.LoginBot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {

        Client client = new Client();
        client.connect("216.136.9.21", 6666);

        new RESTServer(client);
        Thread.sleep(50);
        List<BaseBot> botList = new ArrayList();
        botList.add(new LoginBot(client));

        BotPlatform platform = new BotPlatform(client,botList);
        Thread platformThread =new Thread(platform);
        platformThread.start();

        platformThread.join();
        client.disconnect();
    }

}
