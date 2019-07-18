package com.espark.adarsh.configuraiton;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class ApplicationConfig {


    @Bean
    HazelcastInstance hazelcastInstance() {
        ClientConfig config = new ClientConfig();
        config.getGroupConfig().setName("dev").setPassword("dev-pass");
        config.getNetworkConfig().addAddress("192.168.99.100");
        config.setInstanceName("cache-1");
        HazelcastInstance instance = HazelcastClient.newHazelcastClient(config);
        return instance;
    }

    @Bean
    CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }

}
