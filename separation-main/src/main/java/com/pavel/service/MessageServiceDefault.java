package com.pavel.service;

import com.pavel.domain.Message;
import com.pavel.provider.MessageProvider;

public class MessageServiceDefault implements MessageService {
    private final MessageProvider provider;

    public MessageServiceDefault(MessageProvider provider) {
        this.provider = provider;
    }

    public void sendMessage(String text) {
        provider.sendMessage(new Message(text));
    }
}
