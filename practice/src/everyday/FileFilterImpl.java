import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".java")||pathname.isDirectory();

    }
}
