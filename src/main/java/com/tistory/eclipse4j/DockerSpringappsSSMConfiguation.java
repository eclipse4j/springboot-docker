package com.tistory.eclipse4j;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy
@ImportResource("simplesm-context.xml")
public class DockerSpringappsSSMConfiguation extends CachingConfigurerSupport {

}
