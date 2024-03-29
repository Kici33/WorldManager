package pl.in3time.worldmanager.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileUtils {

    public static void copyFile(File source, File target) throws IOException {
        ArrayList<String> ignore = new ArrayList<>(Arrays.asList("uid.dat", "session.dat"));
        if(!ignore.contains(source.getName())) {
            if(source.isDirectory()) {
                if(!target.exists())
                    target.mkdirs();
                String[] files = source.list();
                for (String file : files) {
                    File srcFile = new File(source, file);
                    File destFile = new File(target, file);
                    copyFile(srcFile, destFile);
                }
            } else {
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0)
                    out.write(buffer, 0, length);
                in.close();
                out.close();
            }
        }
    }
}
