package io.github.bennetrr.bedwarsplugin.exceptions;

public class NotEnoughPlayersException extends Exception {
    public NotEnoughPlayersException(String errorMessage) {
        super(errorMessage);
    }
}
