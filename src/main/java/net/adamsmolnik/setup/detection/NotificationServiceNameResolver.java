package net.adamsmolnik.setup.detection;

import javax.inject.Singleton;
import net.adamsmolnik.setup.ServiceNameResolver;

/**
 * @author ASmolnik
 *
 */
@Singleton
public class NotificationServiceNameResolver implements ServiceNameResolver {

    @Override
    public String getServiceName() {
        return "notification-service";
    }

}
