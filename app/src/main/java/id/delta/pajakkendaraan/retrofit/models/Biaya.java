
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Biaya {

    @SerializedName("balik_nama")
    @Expose
    private String balikNama;
    @SerializedName("jasa_raharja")
    @Expose
    private String jasaRaharja;

    /**
     * 
     * @return
     *     The balikNama
     */
    public String getBalikNama() {
        return balikNama;
    }

    /**
     * 
     * @param balikNama
     *     The balik_nama
     */
    public void setBalikNama(String balikNama) {
        this.balikNama = balikNama;
    }

    /**
     * 
     * @return
     *     The jasaRaharja
     */
    public String getJasaRaharja() {
        return jasaRaharja;
    }

    /**
     * 
     * @param jasaRaharja
     *     The jasa_raharja
     */
    public void setJasaRaharja(String jasaRaharja) {
        this.jasaRaharja = jasaRaharja;
    }

}
