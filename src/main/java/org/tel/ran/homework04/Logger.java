package org.tel.ran.homework04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private String path;
    private boolean doAppend;

    public Logger(String path, boolean doAppend) {
        this.path = path;
        this.doAppend = doAppend;
    }

    public void log(String message, Class<?> clazz) {
        try (FileWriter fileWriter = new FileWriter(path, doAppend)) {
            BufferedWriter writer = new BufferedWriter(fileWriter);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LocalDateTime.now())
                    .append(" ERROR :")
                    .append(clazz.getName())
                    .append(" - ")
                    .append(message)
                    .append("\n");
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
