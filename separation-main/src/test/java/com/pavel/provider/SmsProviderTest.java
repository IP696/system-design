package com.pavel.provider;

import com.pavel.domain.Message;
import com.pavel.domain.MessageSendException;
import com.pavel.provider.MessageProvider;
import com.pavel.provider.SmsProvider;
import org.junit.Before;
import org.junit.Test;

public class SmsProviderTest {

    private MessageProvider messageProvider;

    @Before
    public void setUp() {
        messageProvider = new SmsProvider();
    }

    @Test(expected = MessageSendException.class)
    public void sendMessageShouldThrowsException() {
        messageProvider.sendMessage(new Message(""));
    }

    @Test
    public void sendMessageShouldSendMessage() {
        messageProvider.sendMessage(new Message("text"));
    }
}