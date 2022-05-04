import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Bot!");

        TelegramBot bot = new TelegramBot("5311105948:AAG3Mgl76Vojli6Sd8N2BwdaJsCcw5yXTGY");

        bot.setUpdatesListener(updates -> {
            long chatId = updates.get(0).message().chat().id();
            SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });




    }
}
