package net.adamsmolnik.setup.detection;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import net.adamsmolnik.boundary.notification.NotificationService;

/**
 * @author ASmolnik
 *
 */
@ApplicationPath("/*")
public class RestSetup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(NotificationService.class);
        return classes;
    }
}
