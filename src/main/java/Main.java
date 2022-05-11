import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.response.GetChatResponse;
import com.pengrad.telegrambot.response.GetMeResponse;

import okhttp3.*;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static String toParamValue(Object obj) {
        if (obj.getClass().isPrimitive() ||
                obj.getClass().isEnum() ||
                obj.getClass().getName().startsWith("java.lang")) {
            return String.valueOf(obj);
        }
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static Response sendRequest(String url, String method, Map<String, Object> params) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String fullUrl = url + "/" + method;

        Request request;
        if (params == null || params.isEmpty()) {
            request = new Request.Builder()
                    .url(fullUrl)
                    .build();
        } else {
            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (Map.Entry<String, Object> parameter : params.entrySet()) {
                String name = parameter.getKey();
                Object value = parameter.getValue();
                builder.addFormDataPart(name, toParamValue(value));
            }
            RequestBody formBody = builder.build();
            request = new Request.Builder()
                    .url(fullUrl)
                    .post(formBody)
                    .build();
        }

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }


    public static void main(String[] args) {
        System.out.println("Hello, Bot!");

        String token = "5311105948:AAG3Mgl76Vojli6Sd8N2BwdaJsCcw5yXTGY";

        String url = "https://api.telegram.org/bot" + token;

        // getMe request.
        try {
            Map<String, String> params = new HashMap<>();
            Response response = sendRequest(url, "getMe", null);
            Gson gson = new Gson();
            GetMeResponse meResponse = gson.fromJson(response.body().string(), GetMeResponse.class);
            System.out.println(meResponse.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Simple echo server.
        Integer nextUpdate = 0;
        Map<String, Object> params = new HashMap<>();
        while (true) {
            try {
                params.clear();
                params.put("offset", Integer.toString(nextUpdate));
                Response response = sendRequest(url, "getUpdates", params);
                Gson gson = new Gson();
                GetUpdatesResponse updates = gson.fromJson(response.body().string(), GetUpdatesResponse.class);
                for (Update update : updates.updates()) {
                    Integer updateId = update.updateId();
                    nextUpdate = updateId + 1;
                    if (update.message() != null) {
                        long chatId = update.message().chat().id();
                        String text = update.message().text();
                        if (text == null) {
                            text = update.message().location().toString();
                        }
                        System.out.println("Chat id: " + chatId);
                        System.out.println(text);

                        //InlineKeyboardMarkup keyboard = createInlineKeyboard();
                        ReplyKeyboardMarkup keyboard = createReplyKeyboard();

                        params.clear();
                        params.put("chat_id", chatId);

                        params.put("text", text);
                        params.put("reply_markup", keyboard);
                        response = sendRequest(url, "sendMessage", params);
                    } else if (update.callbackQuery() != null) {
                        String queryId = update.callbackQuery().id();
                        String text = update.callbackQuery().data();
                        params.clear();
                        params.put("callback_query_id", queryId);
                        params.put("text", text);
                        response = sendRequest(url, "answerCallbackQuery", params);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        /*OkHttpClient client = new OkHttpClient();
        //TelegramBot bot = new TelegramBot("5311105948:AAG3Mgl76Vojli6Sd8N2BwdaJsCcw5yXTGY");
        TelegramBot bot = new TelegramBot.
                Builder("5311105948:AAG3Mgl76Vojli6Sd8N2BwdaJsCcw5yXTGY").
                okHttpClient(client).
                build();


        bot.setUpdatesListener(updates -> {
            long chatId = updates.get(0).message().chat().id();
            System.out.println(updates.get(0).message().chat().username()
                    + ": " + updates.get(0).message().text());
            SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });*/

    }

    public static InlineKeyboardMarkup createInlineKeyboard() {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton("button1");
        button1.callbackData("button1");
        InlineKeyboardButton button2 = new InlineKeyboardButton("button2");
        button2.callbackData("button2");
        keyboard.addRow(button1, button2);
        //keyboard.addRow(button2);
        return keyboard;
    }

    public static ReplyKeyboardMarkup createReplyKeyboard() {
        KeyboardButton button1 = new KeyboardButton("button1");
        KeyboardButton button2 = new KeyboardButton("button2");
        KeyboardButton locationButton = new KeyboardButton("User's location");
        locationButton.requestLocation(true);
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup(button1, button2);
        keyboard.addRow(locationButton);
        return keyboard;
    }
}
