package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String text, PoemDecorator poemDecorator){
        //return poemDecorator.decorate(text);
        System.out.println(poemDecorator.decorate(text));
    }
}
