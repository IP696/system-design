package com.pavel.service;

import com.pavel.domain.Message;
import com.pavel.domain.MessageSendException;
import com.pavel.provider.MessageProvider;
import com.pavel.provider.ProviderType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MessageServiceDefaultTest {

    @Test(expected = MessageSendException.class)
    public void sendMessageShouldThrowException() {
        MessageService messageService = new MessageServiceDefault(new AlwaysExceptionProviderStub());
        messageService.sendMessage("hello!");
    }

    @Test
    public void sendMessageShouldSendMessage() {
        AlwaysSuccessfulProviderStub provider = new AlwaysSuccessfulProviderStub();
        MessageService messageService = new MessageServiceDefault(provider);
        messageService.sendMessage("hello!");

        assertTrue(provider.isMessageWasSent());
    }

    private static class AlwaysExceptionProviderStub implements MessageProvider {
        public void sendMessage(Message message) {
            throw new MessageSendException();
        }

        @Override
        public ProviderType getType() {
            return null;
        }
    }

    private static class AlwaysSuccessfulProviderStub implements MessageProvider {
        private boolean messageWasSent;

        public void sendMessage(Message message) {
            messageWasSent = true;
        }

        @Override
        public ProviderType getType() {
            return null;
        }

        public boolean isMessageWasSent() {
            return messageWasSent;
        }
    }
}