
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class History {

    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("tempat")
    @Expose
    private String tempat;

    /**
     * 
     * @return
     *     The tgl
     */
    public String getTgl() {
        return tgl;
    }

    /**
     * 
     * @param tgl
     *     The tgl
     */
    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    /**
     * 
     * @return
     *     The jumlah
     */
    public String getJumlah() {
        return jumlah;
    }

    /**
     * 
     * @param jumlah
     *     The jumlah
     */
    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * 
     * @return
     *     The tempat
     */
    public String getTempat() {
        return tempat;
    }

    /**
     * 
     * @param tempat
     *     The tempat
     */
    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

}
