package red.star;
import java.io.*;
public class Play {
    String pictureName[];
    String showImage;
    String webDir="";
    String tomcatDir;
    int index = 0;
    public Play() {
        File f= new File("");
        String path = f.getAbsolutePath();
        int index = path.indexOf("bin");
        tomcatDir = path.substring(0,index);
    }
    public void setWebDir(String s) {
        webDir = s;
        File dirImage = new File(tomcatDir+"/webapps/"+webDir+"/image");
        pictureName = dirImage.list();
    }
    public String getShowImage() {
        showImage = pictureName[index];
        return showImage;
    }
    public void setIndex(int i) {
        index = i;
        if(index>=pictureName.length)
            index = 0;
        if(index < 0)
            index = pictureName.length-1;
    }
    public int getIndex() {
        return  index ;
    }
}
