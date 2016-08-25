
package id.delta.pajakkendaraan.retrofit.models.aceh;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Kendaraan {

    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * 
     * @return
     *     The jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * 
     * @param jenis
     *     The jenis
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

}
