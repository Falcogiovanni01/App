package com.example.gym;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class listBack {
    // 3 ELEMENTI : IMMAGINE, TITOLO TESTO  :
    private Drawable image ;
    private String title ;
    private String description ;

    public listBack() {
        image= null ;
        title = null ;
        description = null ;
    }

    public listBack(Drawable i , String t, String d) {
            image = i;

            title = t;

            description = d;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getImage() {
        return image;
    }
}
