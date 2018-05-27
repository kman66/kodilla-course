package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile(String path) throws FileReaderException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        try(Stream<String> fileLines = Files.lines(Paths.get(file.getPath())) ){
            fileLines.forEach(System.out::println);
        }catch (IOException ioe){
            new FileReaderException();
        }finally {
            System.out.println("I'm gonna be here... always!");
        }
    }
}
