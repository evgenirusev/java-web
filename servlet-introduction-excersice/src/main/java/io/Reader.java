package io;

import java.io.*;

public final class Reader {
    private Reader() {
    }

    public static final String readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null) {
            sb.append(st);
        }
        return sb.toString();
    }
}
