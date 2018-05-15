package com.latsykroman.dmtc;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class AboutCollege extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper viewFlipper, viewFlipper2;
    ImageButton tney, nty, ntny, politeh;
    ImageButton next, prevs;
    ImageButton prevs1, next1;
    ImageButton osp_logo, min_osv_logo, ped_press_logo, ugl_logo, dmtc_logo;
    Intent ipoliteh1, inty, intny, ithey;
    Intent iosp_logo, imin_osv, iped_press, iugl, idmtc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_college);
        next = (ImageButton) findViewById(R.id.next);
        prevs = (ImageButton) findViewById(R.id.prevs);
        dmtc_logo = (ImageButton) findViewById(R.id.dmtc_logo);
        politeh = (ImageButton) findViewById(R.id.politeh);
        tney = (ImageButton) findViewById(R.id.tney);
        ntny = (ImageButton) findViewById(R.id.ntny);
        nty = (ImageButton) findViewById(R.id.nty);
        osp_logo = (ImageButton) findViewById(R.id.osp_logo);
        min_osv_logo = (ImageButton) findViewById(R.id.min_osv_logo);
        ped_press_logo = (ImageButton) findViewById(R.id.ped_press_logo);
        ugl_logo = (ImageButton) findViewById(R.id.ugl_logo);
        next1 = (ImageButton) findViewById(R.id.next1);
        prevs1 = (ImageButton) findViewById(R.id.prevs1);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper2 = (ViewFlipper) findViewById(R.id.viewFlipper2);
        next.setOnClickListener(this);
        prevs.setOnClickListener(this);
        next1.setOnClickListener(this);
        prevs1.setOnClickListener(this);
        politeh.setOnClickListener(this);
        nty.setOnClickListener(this);
        tney.setOnClickListener(this);
        ntny.setOnClickListener(this);
        osp_logo.setOnClickListener(this);
        ugl_logo.setOnClickListener(this);
        ped_press_logo.setOnClickListener(this);
        min_osv_logo.setOnClickListener(this);
        dmtc_logo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == next) {
            viewFlipper.showNext();
        } else if (v == prevs) {
            viewFlipper.showPrevious();
        } else if (v == next1) {
            viewFlipper2.showNext();
        } else if (v == prevs1) {
            viewFlipper2.showPrevious();


        } else if (v == tney) {
            ithey = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tneu.edu.ua/"));
            startActivity(ithey);
        } else if (v == nty) {
            inty = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ntu.edu.ua/"));
            startActivity(inty);
        } else if (v == ntny) {
            intny = new Intent(Intent.ACTION_VIEW, Uri.parse("http://tntu.edu.ua/"));
            startActivity(intny);
        } else if (v == politeh) {
            ipoliteh1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lp.edu.ua/"));
            startActivity(ipoliteh1);


            //Корисні посилання
        } else if (v == osp_logo) {
            iosp_logo = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mon.gov.ua/"));
            startActivity(iosp_logo);
        } else if (v == ugl_logo) {
            iugl = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ukc.gov.ua/"));
            startActivity(iugl);
        } else if (v == min_osv_logo) {
            imin_osv = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.osvitportal.lviv.ua/"));
            startActivity(imin_osv);
        } else if (v == ped_press_logo) {
            iped_press = new Intent(Intent.ACTION_VIEW, Uri.parse("http://pedpresa.ua/"));
            startActivity(iped_press);
        } else if (v == dmtc_logo) {
            idmtc = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dmtc.org.ua/"));
            startActivity(idmtc);
        }
    }

}




