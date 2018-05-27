package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        try{
            fileReader.readFile("file/names.txt");
        }catch (FileReaderException fileReaderException){
            System.out.println("Problem while reading a file!");
        }
    }
}
