package com.igor.meuapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

public class NivelPantalha extends MainActivity {

    int lado, radio, radioPeq, traco;

    float[] angulos;

    Bitmap fundo;

    Paint tracoDebaixo;

    Bitmap bolha;

    public NivelPantalha(Context contexto, int lado){

        super(contexto);

        this.lado=lado;

        radio=lado/2;

        radioPeq=lado/10;

        traco=lado/100;

        angulos=new float[2];

        angulos[0]=0;

        angulos[1]=0;

        fundo=iniciafundo();

        tracoDebaixo=new Paint();

        tracoDebaixo.setColor(Color.BLACK);

        tracoDebaixo.setTextSize(20);

        BitmapDrawable bola=(BitmapDrawable) ContextCompat.getDrawable(contexto, R.drawable.bolha);

        bolha=bola.getBitmap();

        bolha=Bitmap.createScaledBitmap(bolha, radioPeq*2, radioPeq*2, true);

    }


    private Bitmap iniciafundo(){

        Bitmap.Config conf=Bitmap.Config.ARGB_4444;

        Bitmap fundo=Bitmap.createBitmap(lado, lado, conf);

        Canvas tela=new Canvas(fundo);

        Paint lapis=new Paint();

        lapis.setColor(Color.RED);

        tela.drawCircle(radio, radio, radio, lapis);

        lapis.setColor(Color.BLACK);

        tela.drawCircle(radio, radio, radio-traco, lapis);

        lapis.setColor(Color.RED);

        tela.drawCircle(radio, radio, radioPeq+traco, lapis);

        lapis.setStrokeWidth(traco);

        tela.drawLine(radio, 0, radio, lado, lapis);

        tela.drawLine(0, radio, lado, radio, lapis);

        return fundo;

    }

    public void angulos(float[] angulos){

        this.angulos=angulos;

        invalidate();

    }


    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(lado, lado);

    }

    protected void onDraw(Canvas tela){

        super.onDraw(tela);

        tela.drawBitmap(fundo, 0, 0, null);

        int posX=radio-radioPeq+(int)(angulos[0]/10*radio);

        int posY=radio-radioPeq-(int)(angulos[1]/10*radio);

        tela.drawBitmap(bolha, posX, posY, null);


    }

}
