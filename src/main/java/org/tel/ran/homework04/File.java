package org.tel.ran.homework04;

public class File extends Content {

    private static final int MIN_NAME_LENGTH = 4;
    private static final int MIN_LENGTH_EXTENSION = 3;
    private static final int MAX_LENGTH_EXTENSION = 6;

    public File(String name) {
        super(name);
    }

    public static boolean isFile(String name){
        if (name.length() - MIN_NAME_LENGTH < 0) return false;
        if (!name.contains(".")) return false;
        return name.indexOf(".") <= (name.length() - MIN_LENGTH_EXTENSION) && name.indexOf(".") >= (name.length() - MAX_LENGTH_EXTENSION);
    }
}
