package main.java.JVM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author macfmc
 * @date 2020/8/22-13:54
 */
public class StreamDemo {

    public void read() {
        InputStream in = null;
        try {
            in = new FileInputStream("A.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}