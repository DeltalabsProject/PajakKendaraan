
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class JatuhTempo {

    @SerializedName("pkb")
    @Expose
    private String pkb;
    @SerializedName("swdkllj")
    @Expose
    private String swdkllj;
    @SerializedName("stnk")
    @Expose
    private String stnk;

    /**
     * 
     * @return
     *     The pkb
     */
    public String getPkb() {
        return pkb;
    }

    /**
     * 
     * @param pkb
     *     The pkb
     */
    public void setPkb(String pkb) {
        this.pkb = pkb;
    }

    /**
     * 
     * @return
     *     The swdkllj
     */
    public String getSwdkllj() {
        return swdkllj;
    }

    /**
     * 
     * @param swdkllj
     *     The swdkllj
     */
    public void setSwdkllj(String swdkllj) {
        this.swdkllj = swdkllj;
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

}
