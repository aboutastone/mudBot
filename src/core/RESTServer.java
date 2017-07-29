package core;

import static spark.Spark.*;

public class RESTServer {
    private static StringBuilder outputCache;

    public RESTServer (Client client) {
        outputCache = new StringBuilder();

        get("/events", (req, res) -> outputCache.toString());
        get("/cmd", (req, res) -> {
            String cmd = req.queryParams("run");
            client.sendMessage(req.queryParams("run"));
            return "sending " + cmd;
        });
    }

    public static void appendToOutputCache(String log) {
        if (outputCache.length() > 30000) {
            outputCache.delete(0, 1000);
        }
        outputCache.append(log);
    }
}
