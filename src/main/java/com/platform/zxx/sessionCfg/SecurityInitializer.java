package com.platform.zxx.sessionCfg;


import com.platform.zxx.security.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(WebSecurityConfig.class,HttpSessionConfig.class);
    }

}