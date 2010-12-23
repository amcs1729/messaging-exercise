package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class ValidatingMailer implements Mailer, ErrorHandler {
    private Mailer mailer;
    private final PrintWriter console;

    public ValidatingMailer(Mailer mailer, PrintWriter console) {
        this.mailer = mailer;
        this.console = console;
    }

    public void send(ToAddress to, Body body) {
        to.reportProblems(this);
        mailer.send(to, body);
    }

    public void error(Error error) {
        this.mailer = new NoOpMailer();
        error.writeTo(console);
    }

    private static class NoOpMailer implements Mailer {
        public void send(ToAddress to, Body body) {
        }
    }
}