package com.example.library;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "LibraryService")
public class LibraryService {
    private Map<String, Book> books = new HashMap<>();

    @WebMethod(operationName = "addBook")
    public boolean addBook(
            @WebParam(name = "title") String title,
            @WebParam(name = "author") String author,
            @WebParam(name = "isbn") String isbn) {
        
        if (isbn == null || isbn.trim().isEmpty()) {
            return false;
        }
        
        if (!books.containsKey(isbn)) {
            books.put(isbn, new Book(title, author, isbn));
            return true;
        }
        return false;
    }

    @WebMethod(operationName = "getBook")
    public Book getBook(@WebParam(name = "isbn") String isbn) {
        return books.get(isbn);
    }

    @WebMethod(operationName = "removeBook")
    public boolean removeBook(@WebParam(name = "isbn") String isbn) {
        return books.remove(isbn) != null;
    }
}