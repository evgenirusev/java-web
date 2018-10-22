package org.rusev.catalina.util;

import org.rusev.catalina.servlet.HttpServlet;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplicationLoadingService {
    private Map<String, HttpServlet> loadedApplications;

    private boolean isJarFile(File file) {
        return file.isFile() && file.getName().endsWith(".jar");
    }

    public Map<String, HttpServlet> loadApplications(String applicationsFolderPath) {
        File applicationsFolder = new File(applicationsFolderPath);

        if (!applicationsFolder.exists() && applicationsFolder.isDirectory()) {
            List<File> allJarFiles = Arrays.stream(applicationsFolder.listFiles()).filter(x -> this.isJarFile(x))
                    .collect(Collectors.toList());

            // TODO
        }


        return this.loadedApplications;
    }
}
