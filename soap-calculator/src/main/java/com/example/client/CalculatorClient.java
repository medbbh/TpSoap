package com.example.client;

import com.example.service.CalculatorService;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // URL du WSDL
            URL wsdlURL = new URL("http://localhost:8080/soap-calculator/CalculatorService?wsdl");
            
            // Création du service
            QName qname = new QName("http://service.example.com/", "CalculatorService");
            Service service = Service.create(wsdlURL, qname);
            
            // Obtention du port
            CalculatorService calculator = service.getPort(CalculatorService.class);
            
            // Tests des opérations
            System.out.println("Test des opérations de la calculatrice:");
            System.out.println("Addition (10 + 5) = " + calculator.addition(10, 5));
            System.out.println("Soustraction (10 - 5) = " + calculator.soustraction(10, 5));
            System.out.println("Multiplication (10 * 5) = " + calculator.multiplication(10, 5));
            System.out.println("Division (10 / 5) = " + calculator.division(10, 5));
            
        } catch (Exception e) {
            System.out.println("Erreur lors de l'exécution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}