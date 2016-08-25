
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Tunggakan {

    @SerializedName("pkb")
    @Expose
    private Pkb_ pkb;
    @SerializedName("swdkllj")
    @Expose
    private Swdkllj_ swdkllj;
    @SerializedName("total")
    @Expose
    private String total;

    /**
     * 
     * @return
     *     The pkb
     */
    public Pkb_ getPkb() {
        return pkb;
    }

    /**
     * 
     * @param pkb
     *     The pkb
     */
    public void setPkb(Pkb_ pkb) {
        this.pkb = pkb;
    }

    /**
     * 
     * @return
     *     The swdkllj
     */
    public Swdkllj_ getSwdkllj() {
        return swdkllj;
    }

    /**
     * 
     * @param swdkllj
     *     The swdkllj
     */
    public void setSwdkllj(Swdkllj_ swdkllj) {
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
