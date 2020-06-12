package com.pavel.provider;

import com.pavel.domain.Message;
import com.pavel.domain.MessageSendException;
import com.pavel.provider.EmailProvider;
import com.pavel.provider.MessageProvider;
import org.junit.Before;
import org.junit.Test;

public class EmailProviderTest {

    private MessageProvider messageProvider;

    @Before
    public void setUp() {
        messageProvider = new EmailProvider();
    }

    @Test(expected = MessageSendException.class)
    public void sendMessageShouldThrowException() {
        messageProvider.sendMessage(new Message(""));
    }

    @Test
    public void sendMessageShouldSendMessage() {
        messageProvider.sendMessage(new Message("text"));
    }

}