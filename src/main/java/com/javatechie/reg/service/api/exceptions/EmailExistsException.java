/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatechie.reg.service.api.exceptions;

/**
 *
 * @author Paulo
 */
public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }
}
