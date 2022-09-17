package com.sudhirtheindian4.changelanguage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView helloworld,dialog_language;
    int lang_selected;
    RelativeLayout show_lan_dialog;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_language = (TextView)findViewById(R.id.dialog_language);
        helloworld =(TextView)findViewById(R.id.helloworld);
        show_lan_dialog = (RelativeLayout)findViewById(R.id.showlangdialog);

        if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en"))
        {
            context = LocaleHelper.setLocale(MainActivity.this,"en");
            resources =context.getResources();
            dialog_language.setText("ENGLISH");
            helloworld.setText(resources.getString(R.string.hellow_world));
            setTitle(resources.getString(R.string.app_name));
            lang_selected = 0;
        }else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("hi")){
            context = LocaleHelper.setLocale(MainActivity.this,"hi");
            resources =context.getResources();
            dialog_language.setText("हिन्दी");
            helloworld.setText(resources.getString(R.string.hellow_world));
            setTitle(resources.getString(R.string.app_name));
            lang_selected =1;
        }
        else if(LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("bh")){
            context = LocaleHelper.setLocale(MainActivity.this,"bh");
            resources =context.getResources();
            dialog_language.setText("भोजपुरी");
            helloworld.setText(resources.getString(R.string.hellow_world));
            setTitle(resources.getString(R.string.app_name));
            lang_selected =2;
        }
        show_lan_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] Language = {"ENGLISH","हिन्दी","भोजपुरी"};
                final int checkItem;
                Log.d("Clicked","Clicked");
                final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Select a Language")
                        .setSingleChoiceItems(Language, lang_selected, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog_language.setText(Language[i]);
                                if(Language[i].equals("ENGLISH")){
                                    context = LocaleHelper.setLocale(MainActivity.this,"en");
                                    resources =context.getResources();
                                    lang_selected = 0;
                                    helloworld.setText(resources.getString(R.string.hellow_world));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if(Language[i].equals("हिन्दी"))
                                {
                                    context = LocaleHelper.setLocale(MainActivity.this,"hi");
                                    resources =context.getResources();
                                    lang_selected = 1;
                                    helloworld.setText(resources.getString(R.string.hellow_world));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                                if(Language[i].equals("भोजपुरी"))
                                {
                                    context = LocaleHelper.setLocale(MainActivity.this,"bh");
                                    resources =context.getResources();
                                    lang_selected = 2;
                                    helloworld.setText(resources.getString(R.string.hellow_world));
                                    setTitle(resources.getString(R.string.app_name));
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                dialogBuilder.create().show();
            }
        });
    }
    }
