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
        if (content.contains("���Ƿ�����Сѧѧ���������С��(yes/no)")) {
            mudClient.sendMessage("no");
        }
        if (content.contains("����Ӣ�����֣������������� new ע��" )) {
            mudClient.sendMessage("ziji");
        }
        if (content.contains("��������Ӧ���룺" )) {
            mudClient.sendMessage("770512");
        }
    }
}
