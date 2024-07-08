package atm.config;

import atm.client.CyclosClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Configuration class for setting up the client beans used for communicating with external services.
 */
@Configuration
public class ClientConfig {

    /**
     * Creates a {@link WebClient} bean configured to interact with the Cyclos service.
     *
     * @return a {@link WebClient} instance configured with the base URL for the Cyclos service.
     */
    @Bean
    public WebClient cyclosWebClient() {
        return WebClient.builder().baseUrl("https://cyclos.amalitech-dev.net").build();
    }

    /**
     * Creates a {@link CyclosClient} bean using a {@link HttpServiceProxyFactory}.
     * The factory is configured with the {@link WebClient} instance created by {@link #cyclosWebClient()}.
     *
     * @return a {@link CyclosClient} instance for interacting with the Cyclos service.
     */
    @Bean
    public CyclosClient cyclosService() {
        HttpServiceProxyFactory factory =
                HttpServiceProxyFactory.builderFor(WebClientAdapter.create(cyclosWebClient())).build();
        return factory.createClient(CyclosClient.class);
    }
}
