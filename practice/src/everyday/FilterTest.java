import java.io.File;

public class FilterTest {
    public static void main(String[] args) {
        File file = new File("E:\\grz\\ideaProject\\practice");
        getAllFile(file);
    }
    public static void getAllFile(File dir){
        File[] files = dir.listFiles(new FileFilterImpl());
        for (File file : files) {
            if(file.isFile()){
                System.out.println(file);
            }else {
                getAllFile(file);
            }
        }
    }
}
