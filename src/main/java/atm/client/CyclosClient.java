package atm.client;

import org.springframework.web.service.annotation.HttpExchange;

/**
 * The {@code CyclosClient} interface defines the contract for interacting with the Cyclos API.
 *
 * <p>This interface uses Spring's {@link org.springframework.web.service.annotation.HttpExchange} annotation
 * to facilitate communication with the remote service. Implementations of this interface will
 * handle the actual HTTP requests and responses.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * public interface Client extends CyclosClient {
 *     @GetExchange
 *     Object getAuthenticatedUser();
 * }
 *
 * </pre>
 *
 * @see org.springframework.web.service.annotation.HttpExchange
 */
@HttpExchange
public interface CyclosClient {
}
