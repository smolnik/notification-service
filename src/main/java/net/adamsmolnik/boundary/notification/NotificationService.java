package net.adamsmolnik.boundary.notification;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import net.adamsmolnik.control.notification.Notifier;
import net.adamsmolnik.model.notification.NotificationRequest;
import net.adamsmolnik.model.notification.SubscriptionRequest;

/**
 * @author ASmolnik
 *
 */
@Path("/ns")
@RequestScoped
public class NotificationService {

    @Inject
    private Notifier notifier;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("send")
    public void send(@FormParam("message") String message) {
        notifier.send(message);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("send")
    public void send(NotificationRequest notificationRequest) {
        notifier.send(notificationRequest.message);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("subscribe")
    public void subscribe(@FormParam("email") String email) {
        notifier.subscribe(email);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("subscribe")
    public void subscribe(SubscriptionRequest subscriptionRequest) {
        notifier.subscribe(subscriptionRequest.email);
    }

}
