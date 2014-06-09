package be.stece.esocomm.backendApp;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import java.util.ArrayList;
import java.util.List;

/** An endpoint class we are exposing */
@Api(name = "esoCommBackendApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backendApp.esocomm.stece.be", ownerName = "backendApp.esocomm.stece.be", packagePath=""))
public class EsoCommEndpoint {

    private static final String KEY_NAME = "EsoComm";

    @ApiMethod(name = "getNewsItems")
    public List<NewsBean> getNewsItems() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key newsBeanParentKey = KeyFactory.createKey("NewsBeanParent", KEY_NAME);
        Query query = new Query(newsBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());

        ArrayList<NewsBean> newsBeans = new ArrayList<NewsBean>();
        for (Entity result : results) {
            NewsBean newsBean = new NewsBean();
            newsBean.setId(result.getKey().getId());
            newsBean.setTitle(result.getProperty("title").toString());
            newsBean.setBody(result.getProperty("body").toString());
            newsBeans.add(newsBean);
        }

        return newsBeans;
    }
}