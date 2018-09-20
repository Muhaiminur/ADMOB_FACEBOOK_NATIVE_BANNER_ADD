package com.muhaiminurabir.facebook_ad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muhaiminurabir.facebook_ad.Admob.Admob_Recycler;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button recyclernative;
    private android.widget.Button recycleradmobnative;
    private android.widget.Button recyclerfacbooknativelib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recyclerfacbooknativelib = (Button) findViewById(R.id.recycler__facbook_native_lib);
        recycleradmobnative =findViewById(R.id.recycler__admob_native);
        recyclernative =findViewById(R.id.recycler_native);
        recyclernative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Recycler_Native.class));
            }
        });
        recycleradmobnative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Admob_Recycler.class));
            }
        });
        recyclerfacbooknativelib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Facbook_ad_Lib.class));
            }
        });
        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            test.setText(Html.fromHtml(bodyDat, Html.FROM_HTML_MODE_LEGACY));
        } else {
            test.setText(Html.fromHtml(bodyData));
        }*/
        HtmlTextView htmlTextView = (HtmlTextView)findViewById(R.id.html_text);

// loads html from string and displays http://www.example.com/cat_pic.png from the Internet
        HtmlHttpImageGetter p=new HtmlHttpImageGetter(htmlTextView);
        p.enableCompressImage(true);
        htmlTextView.setHtml("<p>Die US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China</p>\n" +
                "<p><img src=\"http://heizolscout.itclanbd.com/photos/32/P6Fm7c6969Xi7syunfstGWDEOHIt70DvsSyIlcdU.jpeg\" alt=\"\" width=\"700\" /></p>\n" +
                "<p>belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich</p>\n" +
                "<p><img src=\"http://heizolscout.itclanbd.com/photos/32/K6Nwom0Oj8A8uDQNCmTgW8JXiYk1UZSMHnNYHVtU_ad9567733b94a3d66cd5faac156d890a.jpg\" alt=\"\" width=\"696\" height=\"338\" /></p>\n" +
                "<p>abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am DonnerstagDie US-Lagerbestandsdaten des Department of Energy und der sich abzeichnende Handelskrieg zwischen den USA und China belasten die &Ouml;lpreise. Kunden im Inland k&ouml;nnen mit leichten Abschl&auml;gen von bis zu 0,2 Cent bzw. Rappen je Liter Heiz&ouml;l rechnen. Die Roh&ouml;llagerbest&auml;nde stiegen in der letzten Woche um 1,2 Millionen Barrel an, wie das Department of Energy (DOE) am Donnerstag</p>\n" +
                "<p><img src=\"http://heizolscout.itclanbd.com/photos/32/9GhlKw0kbaPNvOQfUQR3Ddz5Qsvh0VPWVAcQMqkQ.jpeg\" alt=\"\" width=\"729\" height=\"320\" /></p>",p);
    }


}
