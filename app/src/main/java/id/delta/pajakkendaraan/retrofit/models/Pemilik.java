
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pemilik {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("alamat")
    @Expose
    private String alamat;

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * 
     * @param alamat
     *     The alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
