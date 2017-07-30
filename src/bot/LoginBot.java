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
        if (content.contains("���Ƿ�����Сѧѧ���������С��(yes/no)")) {
            mudClient.sendMessage("no");
        }
        if (content.contains("����Ӣ�����֣������������� new ע��" )) {
            mudClient.sendMessage(username);
        }
        if (content.contains("��������Ӧ���룺" )) {
            mudClient.sendMessage(password);
        }
        if (content.contains("��Ҫ����һ�������е���ͬ����ϳ�ȥ��ȡ����֮��(y/n)" )) {
            mudClient.sendMessage("y");
        }
    }

    @Override
    public String toString() {
        return "Login Bot";
    }
}
