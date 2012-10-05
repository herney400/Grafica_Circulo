/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computaciongrafica;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author palacioscuacialpud
 */
public class Circulo extends JPanel {
     Vector vectorcartesian=new Vector();
     Vector vectorcordenadasjava=new Vector();
      
      public Circulo(){}
//      
     public Vector getCordenadasX(){
        return vectorcartesian;
     }  
   
     public Vector getCordenadasjava(){
        return vectorcordenadasjava;
     }
     
     public void crearCirculo( int radio){
        
     int x,y;
     double yr,yj,yjava,yseva,ylista ,yenviar;
      x = 0;
      y = radio;
      yr = radio ;
      yj=radio;
      
     while (x < yr){
        x = x + 1;
        yr = Math.sqrt(radio*radio-x*x);
        yj=Math.sqrt(radio*radio-x*x);
        yjava=(long)yj;
        yseva=yj-(double)yjava;
        
        y = (int)Math.round(yr);
//       yenviar= Math.rint((ylista=ylista+yseva)*10)/10;
        vectorcartesian.add(new Point(x, y));
        
//       vectorcordenadasjava.add(new Point.Double(x, yenviar) );                
     } 
     }
     
     public void crearCirculoPM(int radio){
     int x=0,y,d;
     y=radio;
     d=1-radio;
     
         while (y>x) {             
            if(d<0){
              d=d+2*x+3;
               x=x+1;       
            
            }else{
               d=d+2*(x-y)+5;
               x=x+1;
               y=y-1;
            
            }
             
            vectorcartesian.add(new Point(x, y)); 
             
         }
     
     }
     
     
     
   
}
