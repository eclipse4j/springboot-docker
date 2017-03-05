package com.tistory.eclipse4j;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.config.DefaultAddressProvider;
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl;
import com.google.code.ssm.providers.xmemcached.XMemcachedConfiguration;
import com.google.code.ssm.spring.SSMCache;
import com.google.code.ssm.spring.SSMCacheManager;

@Configuration
@EnableCaching
@EnableAspectJAutoProxy
@ImportResource("classpath:simplesm-context.xml")
public class DockerSpringappsSSMConfiguration extends CachingConfigurerSupport {

    @Value("${memcached.server}")
    private String server;

    @Value("${memcached.cache.name}")
    private String cacheName;

    @Bean
    @Override
    public CacheManager cacheManager() {
        Set<SSMCache> ssmCacheSet = new HashSet<>();
        SSMCache ssmCache = new SSMCache(cacheFactory().getCache(), 300, false);
        ssmCacheSet.add(ssmCache);
        SSMCacheManager ssmCacheManager = new SSMCacheManager();
        ssmCacheManager.setCaches(ssmCacheSet);
        return ssmCacheManager;
    }

    @Bean
    // @DependsOn("cacheBase")
    public CacheFactory cacheFactory() {
        CacheFactory cacheFactory = new CacheFactory();
        cacheFactory.setCacheName(cacheName);
        cacheFactory.setCacheClientFactory(new MemcacheClientFactoryImpl());
        XMemcachedConfiguration cacheConfiguration = createCacheConfiguration(server);
        cacheFactory.setAddressProvider(new DefaultAddressProvider(server));
        cacheFactory.setConfiguration(cacheConfiguration);

        return cacheFactory;
    }

    private XMemcachedConfiguration createCacheConfiguration(final String server) {
        XMemcachedConfiguration cacheConfiguration = new XMemcachedConfiguration();
        cacheConfiguration.setConsistentHashing(true);
        cacheConfiguration.setUseBinaryProtocol(true);
        return cacheConfiguration;
    }

}
