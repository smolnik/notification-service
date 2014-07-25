package net.adamsmolnik.boundary.notification;

import net.adamsmolnik.control.notification.Notifier;
import net.adamsmolnik.model.notification.NotificationRequest;

/**
 * @author ASmolnik
 *
 */
public class NotificationActivityImpl implements NotificationActivity {

    private final Notifier notifier;

    public NotificationActivityImpl(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void publish(NotificationRequest notificationRequest) {
        notifier.send(notificationRequest.message);
    }

}
