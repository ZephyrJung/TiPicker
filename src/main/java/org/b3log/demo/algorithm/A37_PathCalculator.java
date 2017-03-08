package org.b3log.demo.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/21.
 * 给出一个绝对路径和两个相对路径，计算最终的实际绝对路径
 */
public class A37_PathCalculator {

    public static final String DIR_SEPARATOR = "/";

    public static void main(String[] args){
        String finalPath = new A37_PathCalculator().calculate("/usr/bin/mail", "../../../etc/xyz", "../abc");
        System.out.println(finalPath);
    }

    public String calculate(String absolute, String r1, String r2) {
        if (absolute == null || r1 == null || r2 == null) {
            throw new IllegalArgumentException("You can't pass null strings as input.");
        }

        String[] absolutePath = absolute.split(DIR_SEPARATOR);
        String[] r1Path = r1.split(DIR_SEPARATOR);
        String[] r2Path = r2.split(DIR_SEPARATOR);
        String[] result = calculatePath(absolutePath, r1Path, r2Path);

        StringBuilder stringBuilder = new StringBuilder(DIR_SEPARATOR);
        for (String dir : result) {
            stringBuilder.append(dir);
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    private static String[] calculatePath(String[]... paths) {
        List<String> finalPath = new LinkedList<String>();
        for (String[] path : paths) {
            for (String dir : path) {
                if (dir.equals("..")) {
                    if (!finalPath.isEmpty()) {
                        finalPath.remove(finalPath.size() - 1);
                    }
                } else if (!dir.isEmpty()) {
                    finalPath.add(dir);
                }
            }
        }
        return finalPath.toArray(new String[finalPath.size()]);
    }
}
