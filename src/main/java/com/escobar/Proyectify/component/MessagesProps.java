package com.escobar.Proyectify.component;

import org.springframework.stereotype.Component;

@Component("messagesProps")
public class MessagesProps {

    public final String bundleLocale = "messages";

    public String bundleLocale() { return bundleLocale; }
}
