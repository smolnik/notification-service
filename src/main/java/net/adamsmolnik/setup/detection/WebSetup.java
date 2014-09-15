package net.adamsmolnik.setup.detection;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import net.adamsmolnik.boundary.notification.NotificationActivityImpl;
import net.adamsmolnik.control.notification.Notifier;
import net.adamsmolnik.setup.ActivityLauncher;
import net.adamsmolnik.util.Configuration;

/**
 * @author ASmolnik
 *
 */
@WebListener("notificationActivitySetup")
public class WebSetup implements ServletContextListener {

    @Inject
    private Configuration conf;

    @Inject
    private Notifier notifier;

    @Inject
    private ActivityLauncher al;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        notifier.subscribe(conf.getServiceValue("sns.subscription.email"));
        al.register(new NotificationActivityImpl(notifier));
        al.launch();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        al.shutdown();
    }

}
