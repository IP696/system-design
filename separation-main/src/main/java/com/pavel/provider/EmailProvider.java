package com.pavel.provider;

import com.pavel.domain.Message;
import com.pavel.domain.MessageSendException;

public class EmailProvider implements MessageProvider {

    @Override
    public void sendMessage(Message message) {
        if (message == null) throw new MessageSendException("message is null!");

        if (message.getText() == null || message.getText().isEmpty()) {
            throw new MessageSendException("text is required parameter!");
        }

        sendMessage(message.getText());
    }

    @Override
    public ProviderType getType() {
        return ProviderType.EMAIL;
    }

    private void sendMessage(String text) {
        System.out.println("Email message has been sent: " + text);
    }
}
