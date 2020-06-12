package com.pavel;

import com.pavel.provider.MessageProvider;
import com.pavel.provider.ProviderType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProviderBuilderTest {

    private ProviderBuilder providerBuilder;

    @Before
    public void setUp() {
        providerBuilder = new ProviderBuilder();
    }

    @Test
    public void createSmsProvider() {
        MessageProvider provider = providerBuilder.createMessageProvider("sms");

        assertEquals(ProviderType.SMS, provider.getType());
    }

    @Test
    public void createEmailProvider() {
        MessageProvider provider = providerBuilder.createMessageProvider("email");

        assertEquals(ProviderType.EMAIL, provider.getType());
    }

    @Test
    public void createEmailProviderAsDefault() {
        MessageProvider provider = providerBuilder.createMessageProvider("");

        assertEquals(ProviderType.EMAIL, provider.getType());
    }
}