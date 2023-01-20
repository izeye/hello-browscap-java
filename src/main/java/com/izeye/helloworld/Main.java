package com.izeye.helloworld;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentService;

import java.io.IOException;

/**
 * Hello world for browscap-java.
 *
 * @author Johnny Lim
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36";
        Capabilities capabilities = new UserAgentService().loadParser().parse(userAgent);
        System.out.println(capabilities);
    }
}
