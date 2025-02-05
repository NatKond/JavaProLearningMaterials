package org.tel.ran.homework04;

public interface FileSystemObject extends Comparable {

    public void displayFormatedContent(String indent);

    public String getName();

    @Override
    default int compareTo(Object o) {
        FileSystemObject obj = (FileSystemObject) o;
        return this.getName().compareTo(obj.getName());
    }

}
