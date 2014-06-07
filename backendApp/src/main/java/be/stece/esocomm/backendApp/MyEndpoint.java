package be.stece.esocomm.backendApp;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(name = "esoCommBackendApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backendApp.esocomm.stece.be", ownerName = "backendApp.esocomm.stece.be", packagePath=""))
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
      MyBean response = new MyBean();
      response.setData("Hi, " + name);

      return response;
    }

}