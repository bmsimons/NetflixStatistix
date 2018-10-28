import logic.SubscriptionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubscriptionManagerTests {
    @Test
    void checkIfSubscriptionManagerIsNotNull() {
        SubscriptionManager subscriptionManager = new SubscriptionManager();

        if (subscriptionManager == null) {
            Assertions.assertTrue(false);
        } else {
            Assertions.assertTrue(true);
        }
    }
}
