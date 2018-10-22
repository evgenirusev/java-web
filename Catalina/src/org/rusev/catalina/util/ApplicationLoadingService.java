package org.rusev.catalina.util;

import org.rusev.catalina.servlet.HttpServlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApplicationLoadingService {

    private Map<String, HttpServlet> loadedApplications;

    private JarFileUnzipService jarFileUnzipService;

    public ApplicationLoadingService(JarFileUnzipService jarFileUnzipService) {
        this.jarFileUnzipService = jarFileUnzipService;
    }

    private boolean isJarFile(File file) {
        return file.isFile() && file.getName().endsWith(".jar");
    }


    private void loadApplicationFromFolder(String applciationRootFolderPath) {
        String classesRootFolderPath = applciationRootFolderPath + "classes" + File.separator;
        String librariesRootFolderPath = applciationRootFolderPath + "lib" + File.separator;


    }

    public Map<String, HttpServlet> loadApplications(String applicationsFolderPath) throws IOException {
        File applicationsFolder = new File(applicationsFolderPath);

        if (!applicationsFolder.exists() && applicationsFolder.isDirectory()) {
            List<File> allJarFiles = Arrays.stream(applicationsFolder.listFiles()).filter(x -> this.isJarFile(x))
                    .collect(Collectors.toList());

            for (File applicationJarFile : allJarFiles) {
                this.jarFileUnzipService.unzipJar(applicationJarFile);
                this.loadApplicationFromFolder(applicationJarFile.getCanonicalPath().replace(".jar", File.separator));
            }
        }


        return this.loadedApplications;
    }
}
