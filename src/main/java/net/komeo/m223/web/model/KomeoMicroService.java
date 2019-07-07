package net.komeo.m223.web.model;

import java.util.List;
import javax.ws.rs.core.MediaType;
import org.gitlab4j.api.models.User;
import com.sun.jersey.api.client.*;

public class KomeoMicroService {

    final String REST_URI = "https://m223-api.komeo.net";

    public List<User> getAllUser() {
        Client client = Client.create();
        WebResource resource = client.resource(REST_URI);
        List<User> users = resource.path("gitlab/user/gitlab").accept(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>() {
        });
        System.out.println(this.getClass().getName() + ".getAllUsers " + users.size() + " found");
        return users;
    }

    public long elapseTime() {
        long start = System.nanoTime();
        List<User> users = this.getAllUser();
        long stop = System.nanoTime();
        return stop - start;
    }
}
