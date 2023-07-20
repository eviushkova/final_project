package org.stepik.config;

import org.aeonbits.owner.Config;

@AppConfig.Sources({
        "classpath:config/properties"
})
public interface AppConfig extends Config {

    @Key("email")
    String getLogin();

    @Key("password")
    String getPassword();

    @Key("baseUrl")
    @DefaultValue("https://stepik.org")
    String getBaseUrl();
}
