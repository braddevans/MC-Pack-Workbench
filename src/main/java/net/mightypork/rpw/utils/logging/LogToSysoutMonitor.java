package net.mightypork.rpw.utils.logging;

import net.mightypork.rpw.Config;

import java.util.logging.Level;

public class LogToSysoutMonitor implements LogMonitor {

    @Override
    public void log(Level level, String message) {
        if (! Config.LOG_TO_STDOUT) { return; }

        if (level == Level.FINE || level == Level.FINER || level == Level.FINEST || level == Level.INFO) {
            System.out.print(message);
        }
        else if (level == Level.SEVERE || level == Level.WARNING) {
            System.err.print(message);
        }
    }

}
