package com.sm.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lox {

    static boolean hadError;


    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        } else if(args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }

    }

    /**
     *
     * @param path
     * @throws IOException
     */
    private static void runFile(String path) throws IOException {

        byte[] bytesRead = Files.readAllBytes(Paths.get(path));
        run(new String(bytesRead, Charset.defaultCharset ()));
    }

    /**
     *
     * @throws IOException
     */

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader (System.in);
        try (BufferedReader reader = new BufferedReader (input)) {
            //Run the repl
            for(;;) {
                System.out.println("lox-repl> ");
                String line = reader.readLine();
                if (line.trim().equals("exit")) {
                    break;
                } else {
                    run(line);
                }
            }

        }


    }

    private static void run(String source) {
        System.out.println(source);

    }

    /**
     *
     * @param line
     * @param msg
     */
    static void error(int line, String msg) {
        report(line,"",msg);

    }

    private static void report(int line, String where, String msg) {
        System.err.println(
                "[line " + line + "] Error" + where + ": " + msg);
        hadError = true;
    }
}
