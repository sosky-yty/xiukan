package com.example.sosky.xiukan.adapter.item;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import static com.example.sosky.xiukan.XiuKan.Objects_equals;

public class Linkable implements Serializable {

    public String link;

    public String getLink(){
        return link;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Linkable)){
            return  false;
        }

        return  Objects_equals(link, ((Linkable) obj).link);
    }

    @NonNull
    @Override
    public String toString() {
        return "Linkable{" +
                "link='" + link + '\'' +
                '}';
    }
}
