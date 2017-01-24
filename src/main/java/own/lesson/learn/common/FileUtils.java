/*
 * Copyright (c) 2017. @author lev-gc
 */

package own.lesson.learn.common;

import java.io.File;
import java.nio.file.Paths;

/**
 * <b><code>FileUtils</code></b>
 * <p/>
 * FileUtils
 * <p/>
 * <b>Creation Time:</b> 2016/5/30 11:06.
 *
 * @author lev-gc
 * @version $Revision$ 2016/5/30 11:06.
 * @since LessonLearn 1.0
 */
public class FileUtils {

    /**
     * Deletes file and the empty directory to this file on server.
     *
     * @param position the file path from root
     */
    public static void removeFileAndDir(String position) {
        File srcFile = new File(Paths.get(getRootPath(), position).toString());
        if (srcFile.exists()) {
            srcFile.delete();
            File dir = srcFile.getParentFile();
            while (dir.exists() && dir.list().length == 0) {
                dir.delete();
                dir = dir.getParentFile();
            }
        }
    }

    /**
     * Gets the root path of server.
     *
     * @return the root path
     */
    public static String getRootPath() {
        String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String rootPath = "";

        /* For Windows */
        if ("\\".equals(File.separator)) {
            String path = classPath.substring(1, classPath.indexOf("/WEB-INF/classes"));
            rootPath = path.substring(0, path.lastIndexOf("/"));
            rootPath = rootPath.replace("/", "\\");
        }

        /* For Linux */
        if ("/".equals(File.separator)) {
            String path = classPath.substring(0, classPath.indexOf("/WEB-INF/classes"));
            rootPath = path.substring(0, path.lastIndexOf("/"));
            rootPath = rootPath.replace("\\", "/");
        }
        return rootPath;
    }

}
