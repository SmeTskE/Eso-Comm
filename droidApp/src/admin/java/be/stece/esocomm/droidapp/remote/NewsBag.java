package be.stece.esocomm.droidapp.remote;

import java.util.List;
import be.stece.esocomm.droidapp.models.NewsMessage;

/**
 * Created by Stece on 15/06/2014.
 */
public interface NewsBag {

    void storeNewsItem(NewsMessage newsItem);

    List<NewsMessage> getNewsItems();
}
