package org.b3log.zephyr.algorithm;

/**
 * Created by yaya on 17-2-19.
 */
public class A23_RemoveComments {

    public static void main(String[] args){
        System.out.println(new A23_RemoveComments().remove(new FakeFile("Hello world ", "this is the content /*/ of a fake file */", "of a real file")));
    }

    private static final char ASTERISK = '*';
    private static final char SLASH = '/';
    private static final char ANY_CHAR = 'c';

    public String remove(FakeFile file) {
        if (file == null) {
            throw new IllegalArgumentException("You can't pass a null file as argument.");
        }

        StringBuilder result = new StringBuilder();
        boolean openComment = false;
        String line = file.getLine();
        while (line != null) {
            char previous = ANY_CHAR;
            int openIndex = -1;

            char[] arr = line.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (openComment) {
                    if (c == SLASH && previous == ASTERISK && openIndex < (i - 2)) {
                        openComment = false;
                    }
                } else {
                    if (c == ASTERISK && previous == SLASH) {
                        openIndex = i - 1;
                        openComment = true;
                        result.deleteCharAt(result.length() - 1);
                    } else {
                        result.append(c);
                    }
                }
                previous = c;
            }
            line = file.getLine();
        }
        return result.toString();
    }
}

class FakeFile {

    private final String[] lines;
    private int index;

    FakeFile(String... lines) {
        this.lines = lines != null ? lines : new String[0];
    }

    String getLine() {
        return index <= lines.length - 1 ? lines[index++] : null;
    }
}
