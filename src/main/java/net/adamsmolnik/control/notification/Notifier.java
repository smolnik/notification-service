package net.adamsmolnik.control.notification;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import net.adamsmolnik.provider.NotifierProvider;

@Dependent
public class Notifier {

    @Inject
    private NotifierProvider notifierProvider;

    public void subscribe(String email) {
        notifierProvider.subscribe(email);
    }

    public void send(String message) {
        notifierProvider.publish(message);
    }

}
