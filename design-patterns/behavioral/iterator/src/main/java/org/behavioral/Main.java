package org.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        Book bookOne = new Book("test", "auth");
        Book bookTwo = new Book("test2", "auth2");
        bookList.add(bookOne);
        bookList.add(bookTwo);
        Library library = new Library(bookList);

        Iterator iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.toString());
        }
    }
}