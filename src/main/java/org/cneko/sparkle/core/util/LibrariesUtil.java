package org.cneko.sparkle.core.util;
import net.byteflux.libby.LibraryManager;
import net.byteflux.libby.classloader.URLClassLoaderHelper;
import net.byteflux.libby.logging.adapters.JDKLogAdapter;
import org.cneko.sparkle.core.Meta;
import org.cneko.sparkle.core.util.ctlib.plugin.util.LibrariesLoader;
import java.net.URLClassLoader;
import java.nio.file.Path;

import static org.cneko.sparkle.core.util.ctlib.plugin.util.LibrariesLoader.load;
public class LibrariesUtil {

    // 下载依赖项目
    public static void download(){
        LibrariesLoader.setManager(new Manger());
       try{
           Class.forName("com.google.gson.Gson");
       }catch (Exception e){
            load("com.google.code.gson","gson","2.11.0");
       }
       try {
           Class.forName("org.yaml.snakeyaml.Yaml");
       } catch (ClassNotFoundException e) {
           load("org.yaml","snakeyaml","2.2");
       }
    }

    public static class Manger extends LibraryManager {
        private static String DATA_FOLDER = "sparkle";
        private static String DIR = "lib";

        private final URLClassLoaderHelper classLoader;
        public Manger() {
            super(new JDKLogAdapter(Meta.INSTANCE.getLogger()),Path.of(DATA_FOLDER),DIR );
            this.classLoader = new URLClassLoaderHelper((URLClassLoader)Meta.INSTANCE.getClass().getClassLoader(), this);
        }

        @Override
        protected void addToClasspath(Path file) {
            this.classLoader.addToClasspath(file);
        }
    }
}
