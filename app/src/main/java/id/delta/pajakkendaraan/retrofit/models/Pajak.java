
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Pajak {

    @SerializedName("berjalan")
    @Expose
    private Berjalan berjalan;
    @SerializedName("tunggakan")
    @Expose
    private Tunggakan tunggakan;
    @SerializedName("total")
    @Expose
    private String total;


    //Tambahan DKI
    @SerializedName("pkb")
    @Expose
    private String pkb;
    @SerializedName("swdkllj")
    @Expose
    private String swdkllj;

    public String getPkb() {
        return pkb;
    }

    public void setPkb(String pkb) {
        this.pkb = pkb;
    }

    public String getSwdkllj() {
        return swdkllj;
    }

    public void setSwdkllj(String swdkllj) {
        this.swdkllj = swdkllj;
    }

    /**
     * 
     * @return
     *     The berjalan
     */
    public Berjalan getBerjalan() {
        return berjalan;
    }

    /**
     * 
     * @param berjalan
     *     The berjalan
     */
    public void setBerjalan(Berjalan berjalan) {
        this.berjalan = berjalan;
    }

    /**
     * 
     * @return
     *     The tunggakan
     */
    public Tunggakan getTunggakan() {
        return tunggakan;
    }

    /**
     * 
     * @param tunggakan
     *     The tunggakan
     */
    public void setTunggakan(Tunggakan tunggakan) {
        this.tunggakan = tunggakan;
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
