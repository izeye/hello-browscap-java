package learningtest.com.blueconic.browscap;

import com.blueconic.browscap.BrowsCapField;
import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UserAgentParser}.
 *
 * @author Johnny Lim
 */
class UserAgentParserTests {

    @Test
    void parse() throws IOException, ParseException {
        String desktopUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36";
        String mobilePhoneUserAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko)";

        UserAgentService userAgentService = new UserAgentService();
        UserAgentParser parser = userAgentService.loadParser(List.of(BrowsCapField.DEVICE_TYPE));

        Capabilities capabilities = parser.parse(desktopUserAgent);
        assertThat(capabilities.getDeviceType()).isEqualTo("Desktop");

        capabilities = parser.parse(mobilePhoneUserAgent);
        assertThat(capabilities.getDeviceType()).isEqualTo("Mobile Phone");
    }

}
