/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.utils;

/**
 *
 * @author alok.meher
 */
public class RepositoryException extends Exception {
    
    public RepositoryException() {
    }
    
    public RepositoryException(String msg) {
        super(msg);
    }
    
    public RepositoryException(Throwable e) {
        super(e);
    }    
}
