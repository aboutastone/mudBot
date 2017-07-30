package bot;

import core.Client;

public class FightDragon extends BaseBot {
    public FightDragon(Client mudClient) {
        super(mudClient);
    }

    @Override
    protected void publish(String content) {

    }

    @Override
    public String toString() {
        return "Dragon Bot";
    }
}
