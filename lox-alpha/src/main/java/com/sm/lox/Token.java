package com.sm.lox;

/**
 *
 */
public class Token {

    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line; //location

    Token(TokenType type,String lexeme,Object literal,int location) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = location;
    }

    public String toString() {
        return line + "|| "+  type +  " | " + lexeme + " | " + literal;
    }


}
