package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;
import sun.text.normalizer.UTF16;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename;

    File file;
    FileUtils fu = new FileUtils();

    public FileEventLogger(String filename) {
        this.file = new File(filename);
    }

    public void init() throws IOException {
        file.canWrite();
    }

    public void logEvent(Event event) {
            try {
                fu.writeStringToFile(file, "Log message: " + event.toString() + "\n", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
