package item;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FileItem {
    private final String path = "C:\\Users\\ak_he\\IdeaProjects\\not icloud\\src\\main\\java\\files\\";
    private final File folder = new File(path);


    public File getFolder() {
        return folder;
    }

    public String getPath() {
        return path;
    }

    public String getType(File file) {
        return file.getName().substring(file.getName().lastIndexOf(".") + 1);
    }

    public Long getSize(File file) {

        return file.getTotalSpace();
    }

    public String getImg(File file) throws IOException {
        return String.valueOf(ImageIO.read(file));
    }
}
