package eg.emad.horoscope365.Model;

/**
 * Created by emad on 2/10/19.
 */

public class HomeItem {
    String title;
    String imgPath;

    public HomeItem(String title, String imgPath) {
        this.title = title;
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
