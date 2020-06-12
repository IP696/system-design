package com.pavel;

import com.pavel.provider.MessageProvider;
import com.pavel.service.MessageService;
import com.pavel.service.MessageServiceDefault;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start...");

        String providername = "email"; //default name

        if (args.length > 0) providername = args[0];

        ProviderBuilder providerBuilder = new ProviderBuilder();
        MessageProvider provider = providerBuilder.createMessageProvider(providername);

        MessageService messageService = new MessageServiceDefault(provider);
        messageService.sendMessage("hello!");
    }
}
