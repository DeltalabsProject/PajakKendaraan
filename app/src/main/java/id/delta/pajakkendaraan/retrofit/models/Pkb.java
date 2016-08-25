
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pkb {

    @SerializedName("pokok")
    @Expose
    private String pokok;
    @SerializedName("sanksi")
    @Expose
    private String sanksi;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;

    //Tambahan Jateng
    @SerializedName("jatuh_tempo")
    @Expose
    private String jatuhTempo;

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    /**
     * 
     * @return
     *     The pokok
     */
    public String getPokok() {
        return pokok;
    }

    /**
     * 
     * @param pokok
     *     The pokok
     */
    public void setPokok(String pokok) {
        this.pokok = pokok;
    }

    /**
     * 
     * @return
     *     The sanksi
     */
    public String getSanksi() {
        return sanksi;
    }

    /**
     * 
     * @param sanksi
     *     The sanksi
     */
    public void setSanksi(String sanksi) {
        this.sanksi = sanksi;
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

}
