package learningtest.com.blueconic.browscap;

import com.blueconic.browscap.BrowsCapField;
import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

/**
 * Tests for {@link UserAgentParser}.
 *
 * @author Johnny Lim
 */
class UserAgentParserTests {

    @Test
    void time() {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36";

        UserAgentService userAgentService = time(() -> new UserAgentService());
        UserAgentParser parser = time(() -> {
            try {
                return userAgentService.loadParser(List.of(BrowsCapField.DEVICE_TYPE));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
        Capabilities capabilities = time(() -> parser.parse(userAgent));
        String deviceType = time(() -> capabilities.getDeviceType());
        System.out.println(deviceType);
    }

    private <T> T time(Supplier<T> supplier) {
        long startTimeMillis = System.currentTimeMillis();
        T result = supplier.get();
        long elapsedTimeMillis = System.currentTimeMillis() - startTimeMillis;
        System.out.printf("Elapsed time: %d ms%n", elapsedTimeMillis);
        return result;
    }

}
