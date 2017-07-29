package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    Socket pingSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;
    private int MAXBUFFER_SIZE = 50000;
    public void connect(String host, int port) {
        try {
            pingSocket = new Socket(host, port);
            out = new PrintWriter(pingSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
        } catch (IOException e) {
            return;
        }
    }

    public String fetchBatch() throws IOException {
        char[] byteBuffer = new char[MAXBUFFER_SIZE];
        in.read(byteBuffer);
        return  String.valueOf(byteBuffer);
    }

    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }

    public void disconnect() {
        out.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pingSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        Client client = new Client();
        client.connect("216.136.9.21", 6666);
        System.out.println(client.fetchBatch());
        client.sendMessage("gb");
        Thread.sleep(1000);
        System.out.println(client.fetchBatch());
        client.sendMessage("yes");
        System.out.println(client.fetchBatch());
    }
}