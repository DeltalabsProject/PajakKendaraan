package id.delta.pajakkendaraan.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

import id.delta.pajakkendaraan.R;
import id.delta.pajakkendaraan.retrofit.ApiInterface;
import id.delta.pajakkendaraan.retrofit.models.ResponsePajak;
import id.delta.pajakkendaraan.retrofit.models.aceh.Data;
import id.delta.pajakkendaraan.retrofit.models.aceh.ResponseAceh;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    private LayoutInflater inflater;
    Spinner spProvinsi;
    ProgressDialog pgDialog;

    EditText inKode, inNomor, inSeri;
    TextView txHasil, titleHasil, txSumber, txProvinsi, txMessage;
    Button btnCek, btnDetil;

    id.delta.pajakkendaraan.retrofit.models.Data data;
    Data dataAceh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        komposisiTampilan();
        komposisiSpinner();
    }

    private void komposisiSpinner(){
        spProvinsi = (Spinner)findViewById(R.id.spinner_provinsi);
        spProvinsi.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("DKI Jakarta");
        categories.add("Jawa Tengah");
        categories.add("Kalimantan Tengah");
        categories.add("Aceh");
     //   categories.add("Riau");
     //   categories.add("Lampung");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProvinsi.setAdapter(dataAdapter);
    }

    private void komposisiTampilan(){

        pgDialog = new ProgressDialog(this);
        pgDialog.setIndeterminate(true);
        pgDialog.setCancelable(false);

        txHasil = (TextView)findViewById(R.id.hasil);
        titleHasil = (TextView)findViewById(R.id.title_hasil);
        txSumber =(TextView)findViewById(R.id.sumber);
        txProvinsi = (TextView)findViewById(R.id.provinsi);
        txMessage = (TextView)findViewById(R.id.message);

        inKode = (EditText)findViewById(R.id.kode);
        inSeri = (EditText)findViewById(R.id.seri);
        inNomor = (EditText)findViewById(R.id.nomor);

        btnDetil = (Button)findViewById(R.id.tombol_detail);
        btnDetil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDetail();
            }
        });

        btnCek = (Button)findViewById(R.id.tombol_cek);

    }


    private void getDataKalTeng(){
        final String kode = inKode.getText().toString();
        final String nomor = inNomor.getText().toString();
        final String seri = inSeri.getText().toString();

        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getResponse("KH", nomor, seri).enqueue(new Callback<ResponsePajak>() {
            @Override
            public void onResponse(Call<ResponsePajak> call, Response<ResponsePajak> response) {
                pgDialog.dismiss();
                ResponsePajak responsePajak = response.body();
                data = responsePajak.getData();

                Log.d("onSuccess", "onSuccess: "+response.toString());

                try {

                    String status = responsePajak.getStatus();
                    if (status.equals("success")){
                        txHasil.setVisibility(View.VISIBLE);
                        titleHasil.setText("Pajak Kendaraan "+data.getNopol());
                        txSumber.setText("SUMBER\t\t\t= "+responsePajak.getSumber());
                        txProvinsi.setText("Provinsi\t\t\t= "+responsePajak.getProvinsi());
                        txMessage.setVisibility(View.GONE);
                        dataKalTeng();

                  //      btnDetil.setVisibility(View.VISIBLE);

                    }else {
                        txHasil.setVisibility(View.GONE);
                        txMessage.setText(responsePajak.getMessage());
                        txMessage.setVisibility(View.VISIBLE);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponsePajak> call, Throwable t) {
                pgDialog.dismiss();
            }
        });
    }

    private void dialogDetail(){
        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.dialog_tentang, null);

     //   final TextView detilHasil = (TextView)content.findViewById(R.id.detail_hasil);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(content);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            dialogDetail();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                inKode.setText("B");
                inKode.setEnabled(false);
                btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataDki();
                    }
                });
                break;
            case 1:
                inKode.setText("");
                inKode.setEnabled(true);
                btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataJateng();
                    }
                });
                break;
            case 2:
                inKode.setText("KH");
                inKode.setEnabled(false);
                btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataKalTeng();
                    }
                });
                break;
            case 3:
                inKode.setText("BL");
                inKode.setEnabled(false);
                btnCek.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataAceh();
                    }
                });
                break;
            case 4:
                inKode.setText("");
                inKode.setEnabled(true);
                break;
            case 5:
                inKode.setText("");
                inKode.setEnabled(true);
                break;
        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private void dataKalTeng(){

        final String nomesin = data.getKendaraan().getNoMesin();
        final String norangka = data.getKendaraan().getNoRangka();

        txHasil.setText("Nomor Polisi\t= "+data.getNopol()
                +"\nPemilik\t\t\t\t= "+data.getPemilik().getNama()
                +"\nAlamat\t\t\t\t= "+data.getPemilik().getAlamat()
                +"\n"
                +"\nJenis\t\t\t\t\t= "+data.getKendaraan().getJenis()
                +"\nMerk\t\t\t\t\t="+data.getKendaraan().getMerk()
                +"\nType\t\t\t\t\t= "+data.getKendaraan().getType()
                +"\nWarna\t\t\t\t= "+data.getKendaraan().getWarna()
                +"\nCC\t\t\t\t\t\t= "+data.getKendaraan().getCc()
                +"\nNo. Mesin\t\t\t= "+nomesin
                +"\nNo. Rangka\t\t= "+norangka
                +"\nPembuatan\t\t= "+data.getKendaraan().getTahunPembuatan()
                +"\n"
                +"\nMasa Berlaku"
                +"\nNotice\t\t\t\t= "+data.getMasaBerlaku().getNotice()
                +"\nSTNK\t\t\t\t\t= "+data.getMasaBerlaku().getStnk()
                +"\nProgresif\t\t\t= "+data.getMasaBerlaku().getProgresif()

                +"\n"
                +"\nHistory"
                +"\nTanggal\t\t\t\t= "+data.getHistory().getTgl()
                +"\nJumlah\t\t\t\t= "+data.getHistory().getJumlah()
                +"\nTempat\t\t\t\t= "+data.getHistory().getTempat()
                +"\n"
                +"\nPAJAK\t\t\t\t= "+data.getPajak().getTotal()
                +"\n\t\tBERJALAN"
                +"\n\t\t\t\t- BBN"
                +"\n\t\t\t\t\t\t\tPokok\t= "+data.getPajak().getBerjalan().getBbn().getPokok()
                +"\n\t\t\t\t\t\t\tSanksi\t= "+data.getPajak().getBerjalan().getBbn().getSanksi()
                +"\n\t\t\t\t\t\t\tJumlah\t= "+data.getPajak().getBerjalan().getBbn().getJumlah()
                +"\n\t\t\t\t- PKB"
                +"\n\t\t\t\t\t\t\tPokok\t= "+data.getPajak().getBerjalan().getPkb().getPokok()
                +"\n\t\t\t\t\t\t\tSanksi\t= "+data.getPajak().getBerjalan().getPkb().getSanksi()
                +"\n\t\t\t\t\t\t\tJumlah\t= "+data.getPajak().getBerjalan().getPkb().getJumlah()
                +"\n\t\t\t\t- SWDKLLJ"
                +"\n\t\t\t\t\t\t\tPokok\t= "+data.getPajak().getBerjalan().getSwdkllj().getPokok()
                +"\n\t\t\t\t\t\t\tSanksi\t= "+data.getPajak().getBerjalan().getSwdkllj().getSanksi()
                +"\n\t\t\t\t\t\t\tJumlah\t= "+data.getPajak().getBerjalan().getSwdkllj().getJumlah()
                +"\n\t\tTOTAL PAJAK BERJALAN\t\t= "+data.getPajak().getBerjalan().getTotal()
                +"\n\t\tTUNGGAKAN"
                +"\n\t\t\t\t- PKB"
                +"\n\t\t\t\t\t\t\tPokok\t= "+data.getPajak().getTunggakan().getPkb().getPokok()
                +"\n\t\t\t\t\t\t\tSanksi\t= "+data.getPajak().getTunggakan().getPkb().getSanksi()
                +"\n\t\t\t\t\t\t\tJumlah\t= "+data.getPajak().getTunggakan().getPkb().getJumlah()
                +"\n\t\t\t\t- SWDKLLJ"
                +"\n\t\t\t\t\t\t\tPokok\t= "+data.getPajak().getTunggakan().getSwdkllj().getPokok()
                +"\n\t\t\t\t\t\t\tSanksi\t= "+data.getPajak().getTunggakan().getSwdkllj().getSanksi()
                +"\n\t\t\t\t\t\t\tJumlah\t= "+data.getPajak().getTunggakan().getSwdkllj().getJumlah()
                +"\n\t\tTOTAL TUNGGAKAN PAJAK\t= "+data.getPajak().getTunggakan().getTotal()
                +"\n"
                +"\nTerlambat\t\t\t= "+data.getTerlambat()
        );
    }

    private void getDataDki(){

        final String kode = inKode.getText().toString();
        final String nomor = inNomor.getText().toString();
        final String seri = inSeri.getText().toString();

        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getResponse(kode, nomor, seri).enqueue(new Callback<ResponsePajak>() {
            @Override
            public void onResponse(Call<ResponsePajak> call, Response<ResponsePajak> response) {
                pgDialog.dismiss();
                ResponsePajak responsePajak = response.body();
                data = responsePajak.getData();

                Log.d("onSuccess", "onSuccess: "+response.toString());

                try {

                    String status = responsePajak.getStatus();
                    if (status.equals("success")){
                        txHasil.setVisibility(View.VISIBLE);
                        titleHasil.setText("Pajak Kendaraan "+data.getNopol());
                        txSumber.setText("SUMBER\t\t\t= "+responsePajak.getSumber());
                        txProvinsi.setText("Provinsi\t\t\t= "+responsePajak.getProvinsi());

                        txHasil.setText("Nomor Polisi\t= "+data.getNopol()
                                +"\nJenis\t\t\t\t\t= "+data.getKendaraan().getJenis()
                                +"\nMerk\t\t\t\t\t="+data.getKendaraan().getMerk()
                                +"\nPembuatan\t\t= "+data.getKendaraan().getTahunPembuatan()
                                +"\n"
                                +"\nPajak"
                                +"\nPKB\t\t\t\t\t= "+data.getPajak().getPkb()
                                +"\nSWDKLLJ\t\t\t= "+data.getPajak().getSwdkllj()
                                +"\n"
                                +"\nJatuh Tempo"
                                +"\nPKB\t\t\t\t\t= "+data.getJatuhTempo().getPkb()
                                +"\nSWDKLLJ\t\t\t= "+data.getJatuhTempo().getSwdkllj()
                                +"\nSTNK\t\t\t\t\t= "+data.getJatuhTempo().getStnk()
                                +"\n"
                                +"\nNilai Jual\t\t\t\t\t\t\t\t= "+data.getNilaiJual()
                                +"\nDasar Pengenaan Pajak\t= "+data.getDasarPengenaanPajak()
                        );
                        txMessage.setVisibility(View.GONE);

                        //      btnDetil.setVisibility(View.VISIBLE);

                    }else {
                        txHasil.setVisibility(View.GONE);
                        txMessage.setVisibility(View.VISIBLE);
                        txMessage.setText(responsePajak.getMessage());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponsePajak> call, Throwable t) {
                pgDialog.dismiss();
            }
        });
    }

    private void getDataJateng(){

        final String kode = inKode.getText().toString();
        final String nomor = inNomor.getText().toString();
        final String seri = inSeri.getText().toString();

        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getResponse(kode, nomor, seri).enqueue(new Callback<ResponsePajak>() {
            @Override
            public void onResponse(Call<ResponsePajak> call, Response<ResponsePajak> response) {
                pgDialog.dismiss();
                ResponsePajak responsePajak = response.body();
                data = responsePajak.getData();

                Log.d("onSuccess", "onSuccess: "+response.toString());

                try {

                    String status = responsePajak.getStatus();
                    if (status.equals("success")){
                        txHasil.setVisibility(View.VISIBLE);
                        titleHasil.setText("Pajak Kendaraan "+data.getNopol());
                        txSumber.setText("SUMBER\t\t\t= "+responsePajak.getSumber());
                        txProvinsi.setText("Provinsi\t\t\t= "+responsePajak.getProvinsi());

                        txHasil.setText("Nomor Polisi\t= "+data.getNopol()
                                +"\nJenis\t\t\t\t\t="+data.getKendaraan().getJenis()
                                +"\nMerk\t\t\t\t\t="+data.getKendaraan().getMerk()
                                +"\nType\t\t\t\t\t= "+data.getKendaraan().getType()
                                +"\nWarna\t\t\t\t= "+data.getKendaraan().getWarna()
                                +"\nPembuatan\t\t= "+data.getKendaraan().getTahunPembuatan()
                                +"\nWilayah\t\t\t\t= "+data.getKendaraan().getWilayah()
                                +"\n"
                                +"\nPKB"
                                +"\nJumlah\t\t\t\t= "+data.getPkb().getJumlah()
                                +"\nJatuh Tempo\t= "+data.getPkb().getJatuhTempo()
                                +"\n"
                                +"\nBiaya"
                                +"\nBalik Nama\t\t= "+data.getBiaya().getBalikNama()
                                +"\nJasa Raharja\t= "+data.getBiaya().getJasaRaharja()
                        );
                        txMessage.setVisibility(View.GONE);

                        //      btnDetil.setVisibility(View.VISIBLE);

                    }else {
                        txHasil.setVisibility(View.GONE);
                        txMessage.setVisibility(View.VISIBLE);
                        txMessage.setText(responsePajak.getMessage());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponsePajak> call, Throwable t) {
                pgDialog.dismiss();
            }
        });
    }

    private void getDataAceh(){

        final String kode = inKode.getText().toString();
        final String nomor = inNomor.getText().toString();
        final String seri = inSeri.getText().toString();

        pgDialog.setMessage("Sedang Mengambil Data...");
        pgDialog.show();

        ApiInterface apiInterface = ApiInterface.retrofit.create(ApiInterface.class);
        apiInterface.getAcehResponse(kode, nomor, seri).enqueue(new Callback<ResponseAceh>() {
            @Override
            public void onResponse(Call<ResponseAceh> call, Response<ResponseAceh> response) {
                pgDialog.dismiss();
                ResponseAceh responseAceh = response.body();
                dataAceh = responseAceh.getData();

                Log.d("onSuccess", "onSuccess: "+response.toString());

                try {

                    String status = responseAceh.getStatus();
                    if (status.equals("success")){
                        txHasil.setVisibility(View.VISIBLE);
                        titleHasil.setText("Pajak Kendaraan "+dataAceh.getNopol());
                        txSumber.setText("SUMBER\t\t\t= "+responseAceh.getSumber());
                        txProvinsi.setText("Provinsi\t\t\t= "+responseAceh.getProvinsi());

                        txHasil.setText("Nomor Polisi\t= "+dataAceh.getNopol()
                                +"\nJenis\t\t\t\t\t= "+dataAceh.getKendaraan().getJenis()
                                +"\nType\t\t\t\t\t= "+dataAceh.getKendaraan().getType()
                                +"\n"
                                +"\nPajak"
                                +"\nPKB\t\t\t\t\t= "+dataAceh.getPajak().getPkb()
                                +"\nSWDKLLJ\t\t\t= "+dataAceh.getPajak().getSwdkllj()
                                +"\n"
                                +"\nJatuh Tempo\t= "+dataAceh.getJatuhTempo()
                        );
                        txMessage.setVisibility(View.GONE);

                        //      btnDetil.setVisibility(View.VISIBLE);

                    }else {
                        txHasil.setVisibility(View.GONE);
                        txMessage.setVisibility(View.VISIBLE);
                        txMessage.setText(responseAceh.getMessage());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseAceh> call, Throwable t) {
                pgDialog.dismiss();
            }
        });
    }

}
