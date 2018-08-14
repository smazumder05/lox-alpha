package com.sm.lox;

import java.util.ArrayList;
import java.util.List;

import static com.sm.lox.TokenType.*;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<> ();

    private int start; //start location
    private int current;
    private int line;

    Scanner(String source) {
        this.source = source;
    }


    List<Token> scanTokens() {
        while(!isAtEnd()) {
            start = current;
            scanToken();
        }
        tokens.add(new Token(EOF,"",null,line));
        return tokens;
    }

    private void scanToken() {
        char c = advance(); //move to the next char pos
        switch(c) {
            case '(':
                addToken(LEFT_PAREN); break;
            case ')':
                addToken(RIGHT_PAREN); break;
            case '{':
                addToken(LEFT_BRACE); break;
            case '}':
                addToken(RIGHT_BRACE); break;
            case ',':
                addToken(COMMA);break;
            case '.':
                addToken(DOT);break;
            case '-':
                addToken(MINUS); break;
            case '+':
                addToken(PLUS); break;
            case ';':
                addToken(SEMICOLON); break;
            case '*':
                addToken(STAR);break;
            // Two char tokens such as comment /*, != >= etc
            case '!':
                addToken(match('=') ? BANG_EQUAL : BANG);
                break;
            case '=':
                addToken(match('=') ? EQUAL_EQUAL : EQUAL);
                break;
            case '<':
                addToken(match('<') ? LESS_EQUAL : EQUAL);
                break;
            case '>':
                addToken(match('>') ? GREATER_EQUAL : GREATER);
                break;
            case '/':
                if (match('/')) {
                    // A comment goes till the end of the line
                    while(peek() != '\n' && !isAtEnd()) advance();
                } else {
                    addToken(SLASH);
                }
                break;
            // Now look for whitespaces
            case ' ': //Ignore
            case '\r':
            case '\t': break;
            case '"':
                string ();
                break;
            default:
                if (isDigit (c)) {
                    number ();
                } else if (isAlpha (c)) {
                    identifier ();
                } else {
                    Lox.error (line, "Unreconized charecter.");
                }
                break;
        }
    }

    //HELPER METHODS

    /**
     *
     */
    private void identifier() {

    }

    /**
     *
     */
    private void number() {

    }

    /**
     *
     */
    private void string() {

    }

    private boolean match(char c) {
        return false;
    }

    private char peek() {
        return 'p';
    }

    private char peekNext() {

        return 'c';
    }

    private boolean isDigit(char c) {
        return false;
    }

    private boolean isAlpha(char c) {
        return false;

    }

    private boolean isAtEnd() {
        return false;
    }

    private void addToken(TokenType type) {

    }

    private void addToken(TokenType type, Object literal) {

    }

    private char advance() {
        return 'c';
    }
}

