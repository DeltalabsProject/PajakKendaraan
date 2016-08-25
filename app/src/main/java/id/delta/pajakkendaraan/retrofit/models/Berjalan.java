
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Berjalan {

    @SerializedName("bbn")
    @Expose
    private Bbn bbn;
    @SerializedName("pkb")
    @Expose
    private Pkb pkb;
    @SerializedName("swdkllj")
    @Expose
    private Swdkllj swdkllj;
    @SerializedName("total")
    @Expose
    private String total;

    /**
     * 
     * @return
     *     The bbn
     */
    public Bbn getBbn() {
        return bbn;
    }

    /**
     * 
     * @param bbn
     *     The bbn
     */
    public void setBbn(Bbn bbn) {
        this.bbn = bbn;
    }

    /**
     * 
     * @return
     *     The pkb
     */
    public Pkb getPkb() {
        return pkb;
    }

    /**
     * 
     * @param pkb
     *     The pkb
     */
    public void setPkb(Pkb pkb) {
        this.pkb = pkb;
    }

    /**
     * 
     * @return
     *     The swdkllj
     */
    public Swdkllj getSwdkllj() {
        return swdkllj;
    }

    /**
     * 
     * @param swdkllj
     *     The swdkllj
     */
    public void setSwdkllj(Swdkllj swdkllj) {
        this.swdkllj = swdkllj;
    }

    /**
     * 
     * @return
     *     The total
     */
    public String getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

}
