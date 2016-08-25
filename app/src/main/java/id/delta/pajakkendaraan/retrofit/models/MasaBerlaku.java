
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class MasaBerlaku {

    @SerializedName("notice")
    @Expose
    private String notice;
    @SerializedName("stnk")
    @Expose
    private String stnk;
    @SerializedName("progresif")
    @Expose
    private String progresif;

    /**
     * 
     * @return
     *     The notice
     */
    public String getNotice() {
        return notice;
    }

    /**
     * 
     * @param notice
     *     The notice
     */
    public void setNotice(String notice) {
        this.notice = notice;
    }

    /**
     * 
     * @return
     *     The stnk
     */
    public String getStnk() {
        return stnk;
    }

    /**
     * 
     * @param stnk
     *     The stnk
     */
    public void setStnk(String stnk) {
        this.stnk = stnk;
    }

    /**
     * 
     * @return
     *     The progresif
     */
    public String getProgresif() {
        return progresif;
    }

    /**
     * 
     * @param progresif
     *     The progresif
     */
    public void setProgresif(String progresif) {
        this.progresif = progresif;
    }

}
