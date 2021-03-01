package com.javatechie.reg.service.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author paulo.h.bezerra
 */
@Development
public class MyConfig {
    @Bean
    public CommandLineRunner executar(){
        return args ->{
            System.out.println("rodando config dev");
        };
    }

    @Bean(name= "applicationName")
    public String applicationName(){
        return "Sistema com.javatechie.reg.service.api.de Venda";
    }

}

