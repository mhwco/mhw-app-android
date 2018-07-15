package org.mhwco.mhw;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;

public class main_JavaScript_interface {
    Context ctx;
    void main_JavaScript_interface(Context ctx){
        this.ctx=ctx;
    }
    //extend alert
    @JavascriptInterface
    public void PositiveAlert(String message,String title,String button){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        AlertDialog alertDialog = builder.setTitle(title).setMessage(message).setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create();
        alertDialog.show();
    }
    /*@JavascriptInterface
    public byte FullAlert(String message,String title,String positive_button,String negative_button,String neutral_button){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        AlertDialog alertDialog = builder.setTitle(title).setMessage(message).setPositiveButton(positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton(negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNeutralButton(neutral_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create();
        alertDialog.show();
        return 0;
    }*/

}
