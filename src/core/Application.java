package core;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> instancePool = new ArrayList();
        instancePool.add(new Thread(new LoginInstance("216.136.9.21", 6666, "ziji", "770512")));
        instancePool.add(new Thread(new LoginInstance("216.136.9.21", 6666, "mik", "770512")));

        for (Thread instance: instancePool) {
            instance.start();
        }

        for (Thread instance: instancePool) {
            instance.join();
        }
        System.exit(1);
    }

}
