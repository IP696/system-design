package com.pavel;

import com.pavel.provider.EmailProvider;
import com.pavel.provider.MessageProvider;
import com.pavel.provider.SmsProvider;

public class ProviderBuilder {
    private static final String SMS_PROVIDER = "sms";

    MessageProvider createMessageProvider(String providerName) {
        if (SMS_PROVIDER.equalsIgnoreCase(providerName)) {
            return new SmsProvider();
        } else {
            return new EmailProvider();
        }
    }
}
