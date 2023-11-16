import io.github.cdimascio.dotenv.Dotenv;

public class MyBotMain {
    private static String channel1;
    private static String channel;

    public MyBotMain() {
        // Load the .env file
        Dotenv dotenv = Dotenv.configure().load();

        // Retrieve the value of Channel from .env
        channel1 = dotenv.get("Channel");
        channel = "#" + channel1;
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of MyBotMain to initialize channel1
        MyBotMain myBotMain = new MyBotMain();

        // Now start our bot up.
        MyBot bot = new MyBot();

        // Enable debugging output.
        bot.setVerbose(true);


        // Connect to the IRC server.
         bot.connect("irc.us.libera.chat");


        // Join the #pircbot channel.
         bot.joinChannel(channel);
    }
}
