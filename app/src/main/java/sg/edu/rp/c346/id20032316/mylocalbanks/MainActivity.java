package sg.edu.rp.c346.id20032316.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String contextBank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_language, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.EnglishSelected) {
            tvDBS.setText(getString(R.string.tv_dbs));
            tvOCBC.setText(getString(R.string.tv_ocbc));
            tvUOB.setText(getString(R.string.tv_uob));
        } else if (item.getItemId() == R.id.ChineseSelected) {
            tvDBS.setText(getString(R.string.dbs_chinese));
            tvOCBC.setText(getString(R.string.ocbc_chinese));
            tvUOB.setText(getString(R.string.uob_chinese));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_contact, menu);
        if (v == tvDBS) {
            contextBank = "1st";
        } else if (v == tvOCBC) {
            contextBank = "2nd";
        } else if (v == tvUOB) {
            contextBank = "3rd";
        }
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        if (contextBank.equalsIgnoreCase("1st")) {
            if (item.getItemId() == R.id.website) {
                String website = getString(R.string.dbs_website);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWeb);
            } else if (item.getItemId() == R.id.call) {
                String contact = getString(R.string.dbs_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + contact));
                startActivity(intentCall);
            } else if (item.getItemId() == R.id.favourite) {
                if (tvDBS.getCurrentTextColor() == getResources().getColor(android.R.color.holo_red_light)){
                    tvDBS.setTextColor(getResources().getColor(android.R.color.black));
                } else {
                    tvDBS.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }
            }

        } else if (contextBank.equalsIgnoreCase("2nd")){
            if (item.getItemId() == R.id.website) {
                String website = getString(R.string.ocbc_website);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWeb);
            } else if (item.getItemId() == R.id.call) {
                String contact = getString(R.string.ocbc_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + contact));
                startActivity(intentCall);
            } else if (item.getItemId() == R.id.favourite) {
                if (tvOCBC.getCurrentTextColor() == getResources().getColor(android.R.color.holo_red_light)){
                    tvOCBC.setTextColor(getResources().getColor(android.R.color.black));
                } else {
                    tvOCBC.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }
            }

        } else if (contextBank.equalsIgnoreCase("3rd")) {
            if (item.getItemId() == R.id.website) {
                String website = getString(R.string.uob_website);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intentWeb);
            } else if (item.getItemId() == R.id.call) {
                String contact = getString(R.string.uob_contact);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + contact));
                startActivity(intentCall);
            } else if (item.getItemId() == R.id.favourite) {
                if (tvUOB.getCurrentTextColor() == getResources().getColor(android.R.color.holo_red_light)){
                    tvUOB.setTextColor(getResources().getColor(android.R.color.black));
                } else {
                    tvUOB.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                }
            }
        }
        return super.onContextItemSelected(item);
    }


}