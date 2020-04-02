package ru.kravchenko.se.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * @author Roman Kravchenko
 */
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText("Привет тебе братишь " + update.getMessage().getFrom().getFirstName() +
                " от ТрололоБОТА!!! " + update.getMessage().getText());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "TrololoMurBot";
    }

    @Override
    public String getBotToken() {
        return "1128991859:AAF8Oer-XPFpo6kNUtlAXs607TCJxNRSjVI";
    }

}


//        Message message = update.getMessage();
//        if (message != null && message.hasText()) {    1128991859:AAF8Oer-XPFpo6kNUtlAXs607TCJxNRSjVI  -- TrololoMurBot
//            switch (message.getText()) {
//                case "/help":
//                    sendMsg(message, "Чем могу помочь?");
//                    break;
//                case "/setting":
//                    sendMsg(message, "Что будем настраивать?");
//                default:
//            }
//        }

//    public void sendMsg(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(message.getChatId().toString());
//        sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//        try {
//            sendMessage(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }