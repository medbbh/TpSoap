package com.example.service;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "CalculatorService")
public class CalculatorService {
    
    @WebMethod(operationName = "addition")
    public double addition(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a + b;
    }
    
    @WebMethod(operationName = "soustraction")
    public double soustraction(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a - b;
    }
    
    @WebMethod(operationName = "multiplication")
    public double multiplication(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a * b;
    }
    
    @WebMethod(operationName = "division")
    public double division(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        return a / b;
    }
}