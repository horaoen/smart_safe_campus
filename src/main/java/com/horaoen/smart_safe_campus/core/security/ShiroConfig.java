package com.horaoen.smart_safe_campus.core.security;

import com.horaoen.smart_safe_campus.core.security.JwtRealm;
import com.horaoen.smart_safe_campus.core.security.SessionRealm;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public Realm myRealm() {
        return new SessionRealm();
    }

    @Bean
    public DefaultWebSecurityManager mySecurityManager(Realm myRealm, ModularRealmAuthenticator modularRealmAuthenticator) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setAuthenticator(modularRealmAuthenticator);
        securityManager.setRealm(myRealm);
        //securityManager.setRealm(new JwtRealm());

        securityManager.setRememberMeManager(getCookieRememberMeManager());
        AbstractCacheManager cacheManager = new MemoryConstrainedCacheManager();
        securityManager.setCacheManager(cacheManager);

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager mySecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(mySecurityManager);

        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("/auth/login", "anon");
        filterMap.put("/v1/role/**", "authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }

    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator() {
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return authenticator;
    }

    private RememberMeManager getCookieRememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);
        rememberMeManager.setCookie(simpleCookie);
        return rememberMeManager;
    }

}
