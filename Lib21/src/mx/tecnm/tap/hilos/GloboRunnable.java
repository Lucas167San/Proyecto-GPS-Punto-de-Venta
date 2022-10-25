package mx.tecnm.tap.hilos;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GloboRunnable implements Runnable {
    
    JFrame  parent;
    Color        color;
    int          radioInicial;
    int          radioActual;
    int          periodoSleep;
    int          x;
    int          y;
    boolean      creciendo;

    public GloboRunnable() {
        
        this.parent = null;
        this.color = null;
        this.radioInicial = 0;
        this.radioActual = 0;
        this.periodoSleep = 0;
        this.x = 0;
        this.y = 0;
        this.creciendo = false;
        
    }
    
    public GloboRunnable ( JFrame parent, Color color, int radioInicial, 
                   int periodoSleep, int x, int y  ) {
        this.parent       = parent;
        this.color        = color;
        this.radioInicial = radioInicial;
        this.radioActual  = radioInicial;
        this.periodoSleep = periodoSleep;
        this.x            = x;
        this.y            = y;
        creciendo         = ( Math.random() > 0.5 ) ? true : false;
    }
    
    public void start()
    {
        Thread thread = new Thread( this );
        thread.start();
    }
    
    
    @Override
    public void run () {
       while ( true ) {
          if ( isCreciendo() )
              radioActual++;
          else
              radioActual--;
          
          if ( radioActual <= 5 || radioActual >= radioInicial * 2  )
              creciendo = ! creciendo;
          
          parent.repaint ();
          
          try {
              Thread.sleep ( getPeriodoSleep() );
          } catch ( InterruptedException ex ) {
            System.out.println ( ex );      
          }
       } 
    }
    
    public void dibujar ( Graphics g ) {
        g.setColor ( getColor() );
        g.fillOval ( x - getRadioActual(), y - getRadioActual(), 2 * getRadioActual(), 2 * getRadioActual() );
    }

    public JFrame getParent() {
        return parent;
    }

    public void setParent(JFrame parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRadioInicial() {
        return radioInicial;
    }

    public void setRadioInicial(int radioInicial) {
        this.radioInicial = radioInicial;
    }

    public int getRadioActual() {
        return radioActual;
    }

    public void setRadioActual(int radioActual) {
        this.radioActual = radioActual;
    }

    public int getPeriodoSleep() {
        return periodoSleep;
    }

    public void setPeriodoSleep(int periodoSleep) {
        this.periodoSleep = periodoSleep;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCreciendo() {
        return creciendo;
    }

    public void setCreciendo(boolean creciendo) {
        this.creciendo = creciendo;
    }
    
}
