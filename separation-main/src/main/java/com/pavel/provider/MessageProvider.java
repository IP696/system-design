package com.pavel.provider;

import com.pavel.domain.Message;

public interface MessageProvider {
    void sendMessage(Message message);
    ProviderType getType();
}
