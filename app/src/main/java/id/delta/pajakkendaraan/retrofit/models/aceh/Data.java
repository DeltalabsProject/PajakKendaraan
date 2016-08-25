
package id.delta.pajakkendaraan.retrofit.models.aceh;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("nopol")
    @Expose
    private String nopol;
    @SerializedName("kendaraan")
    @Expose
    private Kendaraan kendaraan;
    @SerializedName("pajak")
    @Expose
    private Pajak pajak;
    @SerializedName("jatuh_tempo")
    @Expose
    private String jatuhTempo;

    /**
     * 
     * @return
     *     The nopol
     */
    public String getNopol() {
        return nopol;
    }

    /**
     * 
     * @param nopol
     *     The nopol
     */
    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    /**
     * 
     * @return
     *     The kendaraan
     */
    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    /**
     * 
     * @param kendaraan
     *     The kendaraan
     */
    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    /**
     * 
     * @return
     *     The pajak
     */
    public Pajak getPajak() {
        return pajak;
    }

    /**
     * 
     * @param pajak
     *     The pajak
     */
    public void setPajak(Pajak pajak) {
        this.pajak = pajak;
    }

    /**
     * 
     * @return
     *     The jatuhTempo
     */
    public String getJatuhTempo() {
        return jatuhTempo;
    }

    /**
     * 
     * @param jatuhTempo
     *     The jatuh_tempo
     */
    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

}
