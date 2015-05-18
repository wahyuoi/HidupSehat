package c03.ppl.hidupsehat.Entity;

/**
 * Created by wahyuoi on 06/05/15.
 */
public class User {
    int id;
    String kelamin;
    int berat_badan;
    int tinggi_badan;
    String nama;
    String username;
    String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public void setBerat_badan(int berat_badan) {
        this.berat_badan = berat_badan;
    }

    public void setTinggi_badan(int tinggi_badan) {
        this.tinggi_badan = tinggi_badan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getKelamin() {
        return kelamin;
    }

    public int getBerat_badan() {
        return berat_badan;
    }

    public int getTinggi_badan() {
        return tinggi_badan;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
