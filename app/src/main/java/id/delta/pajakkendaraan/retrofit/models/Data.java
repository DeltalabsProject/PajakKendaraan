
package id.delta.pajakkendaraan.retrofit.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("nopol")
    @Expose
    private String nopol;
    @SerializedName("pemilik")
    @Expose
    private Pemilik pemilik;
    @SerializedName("kendaraan")
    @Expose
    private Kendaraan kendaraan;
    @SerializedName("masa_berlaku")
    @Expose
    private MasaBerlaku masaBerlaku;
    @SerializedName("history")
    @Expose
    private History history;
    @SerializedName("pajak")
    @Expose
    private Pajak pajak;
    @SerializedName("terlambat")
    @Expose
    private String terlambat;


    //Tambahan DKI
    @SerializedName("jatuh_tempo")
    @Expose
    private JatuhTempo jatuhTempo;
    @SerializedName("nilai_jual")
    @Expose
    private String nilaiJual;
    @SerializedName("dasar_pengenaan_pajak")
    @Expose
    private String dasarPengenaanPajak;

    //Tambahan Jateng
    @SerializedName("pkb")
    @Expose
    private Pkb pkb;
    @SerializedName("biaya")
    @Expose
    private Biaya biaya;


    //Tambahan Aceh
  /*  @SerializedName("jatuh_tempo")
    @Expose
    private String jatuhTempoAceh;

    public String getJatuhTempoAceh() {
        return jatuhTempoAceh;
    }

    public void setJatuhTempoAceh(String jatuhTempoAceh) {
        this.jatuhTempoAceh = jatuhTempoAceh;
    } */

    public Pkb getPkb() {
        return pkb;
    }

    public void setPkb(Pkb pkb) {
        this.pkb = pkb;
    }

    public Biaya getBiaya() {
        return biaya;
    }

    public void setBiaya(Biaya biaya) {
        this.biaya = biaya;
    }

    public JatuhTempo getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(JatuhTempo jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public String getNilaiJual() {
        return nilaiJual;
    }

    public void setNilaiJual(String nilaiJual) {
        this.nilaiJual = nilaiJual;
    }

    public String getDasarPengenaanPajak() {
        return dasarPengenaanPajak;
    }

    public void setDasarPengenaanPajak(String dasarPengenaanPajak) {
        this.dasarPengenaanPajak = dasarPengenaanPajak;
    }

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
     *     The pemilik
     */
    public Pemilik getPemilik() {
        return pemilik;
    }

    /**
     * 
     * @param pemilik
     *     The pemilik
     */
    public void setPemilik(Pemilik pemilik) {
        this.pemilik = pemilik;
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
     *     The masaBerlaku
     */
    public MasaBerlaku getMasaBerlaku() {
        return masaBerlaku;
    }

    /**
     * 
     * @param masaBerlaku
     *     The masa_berlaku
     */
    public void setMasaBerlaku(MasaBerlaku masaBerlaku) {
        this.masaBerlaku = masaBerlaku;
    }

    /**
     * 
     * @return
     *     The history
     */
    public History getHistory() {
        return history;
    }

    /**
     * 
     * @param history
     *     The history
     */
    public void setHistory(History history) {
        this.history = history;
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
     *     The terlambat
     */
    public String getTerlambat() {
        return terlambat;
    }

    /**
     * 
     * @param terlambat
     *     The terlambat
     */
    public void setTerlambat(String terlambat) {
        this.terlambat = terlambat;
    }

}
