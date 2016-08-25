
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Kendaraan {

    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("merk")
    @Expose
    private String merk;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("warna")
    @Expose
    private String warna;
    @SerializedName("no_mesin")
    @Expose
    private String noMesin;
    @SerializedName("no_rangka")
    @Expose
    private String noRangka;
    @SerializedName("tahun_pembuatan")
    @Expose
    private String tahunPembuatan;
    @SerializedName("cc")
    @Expose
    private String cc;


    //Tambahan Jateng
    @SerializedName("wilayah")
    @Expose
    private String wilayah;

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

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
     *     The merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * 
     * @param merk
     *     The merk
     */
    public void setMerk(String merk) {
        this.merk = merk;
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

    /**
     * 
     * @return
     *     The warna
     */
    public String getWarna() {
        return warna;
    }

    /**
     * 
     * @param warna
     *     The warna
     */
    public void setWarna(String warna) {
        this.warna = warna;
    }

    /**
     * 
     * @return
     *     The noMesin
     */
    public String getNoMesin() {
        return noMesin;
    }

    /**
     * 
     * @param noMesin
     *     The no_mesin
     */
    public void setNoMesin(String noMesin) {
        this.noMesin = noMesin;
    }

    /**
     * 
     * @return
     *     The noRangka
     */
    public String getNoRangka() {
        return noRangka;
    }

    /**
     * 
     * @param noRangka
     *     The no_rangka
     */
    public void setNoRangka(String noRangka) {
        this.noRangka = noRangka;
    }

    /**
     * 
     * @return
     *     The tahunPembuatan
     */
    public String getTahunPembuatan() {
        return tahunPembuatan;
    }

    /**
     * 
     * @param tahunPembuatan
     *     The tahun_pembuatan
     */
    public void setTahunPembuatan(String tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    /**
     * 
     * @return
     *     The cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * 
     * @param cc
     *     The cc
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

}
