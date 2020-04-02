package util;

import java.io.*;
import java.util.*;

public class ReaderFile {
    public static String read() {
        Properties properties = new Properties();
        InputStream in;
        try {
            in = ReaderFile.class.getResourceAsStream("/dao.properties");
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("daotype");
    }
}
