package net.m14m.katas.messaging;

import java.io.*;

public class ErrorReporter {
    private final PrintWriter console;

    public ErrorReporter(Writer console) {
        this.console = new PrintWriter(console);
    }

    public void validate(Address address) {
        if (!address.isValid()) {
            error(ErrorMessage.withCause("Invalid email address", address));
        }
    }

    public void error(ErrorMessage message) {
        console.println(message);
    }
}