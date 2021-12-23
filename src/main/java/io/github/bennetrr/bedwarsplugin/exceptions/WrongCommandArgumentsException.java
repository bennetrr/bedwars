package io.github.bennetrr.bedwarsplugin.exceptions;

public class WrongCommandArgumentsException extends Exception {
    public WrongCommandArgumentsException(String errorMessage) {
        super(errorMessage);
    }
}
