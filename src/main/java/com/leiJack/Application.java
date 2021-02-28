package com.leiJack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
        System.out.println( "test-server:Hello World!" );
        System.out.println("hello world");
    }
}
