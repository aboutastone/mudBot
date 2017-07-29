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
        if (content.contains("您是否是中小学学生或年龄更小？(yes/no)")) {
            mudClient.sendMessage("no");
        }
        if (content.contains("您的英文名字：（新玩家请键入 new 注册" )) {
            mudClient.sendMessage("ziji");
        }
        if (content.contains("请输入相应密码：" )) {
            mudClient.sendMessage("770512");
        }
    }
}
