package c03.ppl.hidupsehat.Client;

import java.util.List;

import c03.ppl.hidupsehat.Entity.ResepMakanan;
import c03.ppl.hidupsehat.Entity.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by wahyuoi on 06/05/15.
 */
public interface HidupSehatClient {
    @GET("/users")
    public void getAllUsers(Callback<List<User>> call);

    @POST("/addUser")
    public void postUser(@Body User user, Callback<User> call);
}
