package net.mightypork.rpw;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        App.onCrash(e);
    }

}
