package core;

import bot.BaseBot;

import java.io.IOException;
import java.util.List;

public class BotPlatform implements Runnable{

    private Client mudClient;
    private boolean keepRunning = true;
    private List<BaseBot> botList;

    public BotPlatform(Client mudClient, List<BaseBot> botList) {
        this.mudClient = mudClient;
        this.botList = botList;
    }

    public void run() {
        try {
            while (keepRunning) {
                String content = mudClient.fetchBatch();
                System.out.print(content);
                for (BaseBot bot : botList) {
                    bot.publish(content);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            keepRunning = false;
        }
    }

    public void stopBot() {
        keepRunning = false;
    }
}
