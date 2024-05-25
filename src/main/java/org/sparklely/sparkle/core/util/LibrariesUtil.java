package org.sparklely.sparkle.core.util;
import net.byteflux.libby.LibraryManager;
import net.byteflux.libby.classloader.URLClassLoaderHelper;
import net.byteflux.libby.logging.adapters.JDKLogAdapter;
import org.sparklely.sparkle.core.Meta;
import org.sparklely.sparkle.core.util.ctlib.plugin.util.LibrariesLoader;
import java.net.URLClassLoader;
import java.nio.file.Path;
import static org.sparklely.sparkle.core.util.ctlib.plugin.util.LibrariesLoader.load;
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
        try{
            Class.forName("com.google.common.collect.MapMaker");
        }catch (Exception e){
            load("com.google.guava","guava","33.2.0-jre");
        }
        try{
            Class.forName("kotlin.UInt");
        }catch (Exception e){
            load("org.jetbrains.kotlin","kotlin-stdlib","2.0.0");
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
