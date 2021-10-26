package com.bnp.mytest.utils;

import com.bnp.mytest.book.Book;

public class Catalog {


        public static Book GivenACleanCodeBook(){
            Book book = new Book(1L,"Clean Code","Robert Martin","2008");

            return book;
        }

        public static Book GivenATheCleanCoderBook(){
            Book book =   new Book(2L,"The Clean Coder","Robert Martin","2011");

            return book;
        }

        public static Book GivenACleanArchitectureBook(){
            Book book = new Book(3L,"Clean Architecture","Robert Martin","2017");

            return book;
        }

        public static Book GivenATestDrivenDevelopmentByExampleBook(){
            Book book =  new Book(4L,"Test Driven Development by Example","Kent Beck","2003");

            return book;
        }

        public static Book GivenAWorkingEffectivelyWithLegacyCodeBook(){
            Book book = new Book(5L,"Working Effectively With Legacy Code","Michael C. Feathers","2004");

            return book;
        }


}
