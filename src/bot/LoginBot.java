package bot;

import core.Client;

public class LoginBot extends BaseBot{
    private String username;
    private String password;
    public LoginBot(Client mudClient, String username, String password) {
        super(mudClient);
        this.username = username;
        this.password = password;
    }

    @Override
    protected void publish(String content) {
        if (content.contains("Welcome to Xi You Ji! Select GB or BIG5")) {
            mudClient.sendMessage("gb");
        }
        if (content.contains("您是否是中小学学生或年龄更小？(yes/no)")) {
            mudClient.sendMessage("no");
        }
        if (content.contains("您的英文名字：（新玩家请键入 new 注册" )) {
            mudClient.sendMessage(username);
        }
        if (content.contains("请输入相应密码：" )) {
            mudClient.sendMessage(password);
        }
        if (content.contains("您要将另一个连线中的相同人物赶出去，取而代之吗？(y/n)" )) {
            mudClient.sendMessage("y");
        }
    }

    @Override
    public String toString() {
        return "Login Bot";
    }
}
