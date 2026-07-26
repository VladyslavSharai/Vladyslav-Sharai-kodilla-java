package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;


public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello world", text -> text.toUpperCase());
        poemBeautifier.beautify("Hello world", text -> "***" + text + "***");
        poemBeautifier.beautify("Hello world", text -> text.replace(" ", "_"));
    }
}