package be.stece.esocomm.droidapp.remote;

import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import be.stece.esocomm.backendapp.esoCommBackendApi.EsoCommBackendApi;
import be.stece.esocomm.backendapp.esoCommBackendApi.model.NewsBean;
import be.stece.esocomm.droidapp.models.NewsMessage;

/**
 * Created by Stece on 15/06/2014.
 */
public class NewsBagImpl implements NewsBag {

    final EsoCommBackendApi esoCommBackendApi;

    // Constructor
    public NewsBagImpl() {
        EsoCommBackendApi.Builder builder = new EsoCommBackendApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                                                       @Override
                                                       public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                                               throws IOException {
                                                           abstractGoogleClientRequest.setDisableGZipContent(true);
                                                       }
                                                   }
                );
        esoCommBackendApi = builder.build();
    }

    @Override
    public synchronized void pushToRemote(NewsMessage newsItem) {
        try {
            NewsBean newsBean = new NewsBean();
            newsBean.setTitle(newsItem.getTitle());
            newsBean.setBody(newsItem.getBody());

            esoCommBackendApi.storeNewsItem(newsBean).execute();
        } catch (IOException e) {
            Log.e(NewsBagImpl.class.getSimpleName(),
                    "Error when storing news items", e);
        }
    }

    @Override
    public synchronized List<NewsMessage> pullFromRemote() {
        ArrayList<NewsMessage> newsList = null;
        try {
            // Remote Call
            List<NewsBean> remoteNews = esoCommBackendApi.getNewsItems().execute().getItems();

            if (remoteNews != null) {
                newsList = new ArrayList<NewsMessage>();
                for (NewsBean newsBean : remoteNews) {
                    newsList.add(new NewsMessage(newsBean.getId(), newsBean.getTitle(), newsBean.getBody()));
                }
            }
        } catch (IOException e) {
            newsList = null;
            Log.e(NewsBagImpl.class.getSimpleName(), "Error when loading tasks", e);
        }
        return newsList;
    }
}