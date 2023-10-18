package com.sarmexin.postman.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Sergey Gavrilov
 */
@Configuration
@EnableJpaRepositories("com.sarmexin.postman.repository")
public class SpringConfig {


}
