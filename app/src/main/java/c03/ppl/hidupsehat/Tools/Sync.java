package c03.ppl.hidupsehat.Tools;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import c03.ppl.hidupsehat.Auth.SignUp;
import c03.ppl.hidupsehat.Client.HidupSehatClient;
import c03.ppl.hidupsehat.Entity.ResepMakanan;
import c03.ppl.hidupsehat.Entity.User;
import c03.ppl.hidupsehat.database.DatabaseField;
import c03.ppl.hidupsehat.database.DatabaseInfo;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by wahyuoi on 06/05/15.
 */
public class Sync {
    final String API_URL = "http://ppl-c03.cs.ui.ac.id/index.php/service/";

    public void fetchUsers(final Context context) {

        // Create a very simple REST adapter which points the HidupSehat API endpoint.
        HidupSehatClient client = ServiceGenerator.createService(HidupSehatClient.class, API_URL);

        // Fetch and print a list of the contributors to this library.
        client.getAllUsers(new Callback<List<User>>() {
            @Override
            public void success(List<User> users, Response response) {
                DatabaseInfo dbInfo = new DatabaseInfo(context);
                dbInfo.deleteTableContent(DatabaseField.USER_TABLE);
                for (User user : users) {
                    ContentValues values = new ContentValues();
                    values.put(DatabaseField.USER_COLUMN_ID, user.getId());
                    values.put(DatabaseField.USER_COLUMN_NAMA, user.getNama());
                    values.put(DatabaseField.USER_COLUMN_KELAMIN, user.getKelamin());
                    values.put(DatabaseField.USER_COLUMN_PASSWORD, user.getPassword());
                    values.put(DatabaseField.USER_COLUMN_USERNAME, user.getUsername());
                    values.put(DatabaseField.USER_COLUMN_BERAT, user.getBerat_badan());
                    values.put(DatabaseField.USER_COLUMN_TINGGI, user.getTinggi_badan());

                    dbInfo.insert(DatabaseField.USER_TABLE,values);
                }
                System.err.println("Sync users down ok");
            }

            @Override
            public void failure(RetrofitError error) {
                System.err.println("Sync users down fail");
            }
        });

        client.getAllResep(new Callback<List<ResepMakanan>>() {
            @Override
            public void success(List<ResepMakanan> resepMakanans, Response response) {
                DatabaseInfo dbInfo = new DatabaseInfo(context);
                dbInfo.deleteTableContent(DatabaseField.RESEP_MAKANAN_TABLE);
                for (ResepMakanan resepMakanan : resepMakanans) {
                    ContentValues values = new ContentValues();
                    values.put(DatabaseField.RESEP_MAKANAN_ID, resepMakanan.getId());
                    values.put(DatabaseField.RESEP_MAKANAN_CARA_MEMBUAT, resepMakanan.getCaraMembuat());
                    values.put(DatabaseField.RESEP_MAKANAN_KALORI, resepMakanan.getKalori());
                    values.put(DatabaseField.RESEP_MAKANAN_NAMA, resepMakanan.getNama());
                    values.put(DatabaseField.RESEP_MAKANAN_SARAN_PENYAJIAN, resepMakanan.getSaranPenyajian());

                    dbInfo.insert(DatabaseField.RESEP_MAKANAN_TABLE,values);
                }
                System.err.println("Sync resep makanan down ok");
            }

            @Override
            public void failure(RetrofitError error) {
                System.err.println("Sync resep makanan down fail");
            }
        });
    }

    public void registerUser(ContentValues values, Context context) {
        HidupSehatClient client = ServiceGenerator.createService(HidupSehatClient.class, API_URL);
        User user = new User();
        user.setId(values.getAsInteger(DatabaseField.USER_COLUMN_ID));
        user.setNama(values.getAsString(DatabaseField.USER_COLUMN_NAMA));
        user.setBerat_badan(values.getAsInteger(DatabaseField.USER_COLUMN_BERAT));
        user.setTinggi_badan(values.getAsInteger(DatabaseField.USER_COLUMN_TINGGI));
        user.setKelamin(values.getAsString(DatabaseField.USER_COLUMN_KELAMIN));
        user.setPassword(values.getAsString(DatabaseField.USER_COLUMN_PASSWORD));
        user.setUsername(values.getAsString(DatabaseField.USER_COLUMN_USERNAME));
        client.postUser(user, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                System.err.println("Sync up ok");
            }

            @Override
            public void failure(RetrofitError error) {
                System.err.println("Sync up fail : " + error.getResponse().getReason());
            }
        });
    }
}
