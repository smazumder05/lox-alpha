package com.sm.lox;

import java.util.logging.StreamHandler;

public interface LoxErrorReporter {

    /**
     * Reports error in Lox Compiler
     *
     * @param sh
     * @param err
     * @param msg
     */
    public void reportError(StreamHandler sh, Error err, String msg);


    /**
     * Reports any warning from the Lox compiler
     * @param sh
     * @param msg
     */
    public void reportWarning(StreamHandler sh, String msg);

}
