package core;

import bot.BaseBot;

import java.util.List;

import static spark.Spark.*;

public class RESTServer {
    private static StringBuilder outputCache;

    public RESTServer (Client client, List<BaseBot> botList) {
        outputCache = new StringBuilder();

        get("/events", (req, res) -> {
            String output =  outputCache.toString();
            outputCache = new StringBuilder();
            return output;
        });

        post("/cmd", (req, res) -> {
            String cmd = req.queryParams("run");
            client.sendMessage(req.queryParams("run"));
            return "sending " + cmd;
        });

        get("/bots", (req, res) -> {
            String output = "";
            for (BaseBot bot: botList) {
                output = output + " " + bot + bot.getEnable();
            }
            return output;
        });

        get("/bots/disable", (req, res) -> {
            String botName = req.queryParams("name");
            for (BaseBot bot: botList) {
                if (bot.toString().equals(botName)) {
                    bot.toggleEnable(false);
                    return "disabled";
                }
            }
            return "enabled";
        });

        get("/bots/enable", (req, res) -> {
            String botName = req.queryParams("name");
            for (BaseBot bot: botList) {
                if (bot.toString().equals(botName)) {
                    bot.toggleEnable(true);
                    return "enabled";
                }
            }
            return "disbled";
        });
    }

    public static void appendToOutputCache(String log) {
        if (outputCache.length() > 30000) {
            outputCache.delete(0, 1000);
        }
        outputCache.append(log);
    }
}
