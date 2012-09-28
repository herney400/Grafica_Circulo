/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computaciongrafica;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author palacioscuacialpud
 */
public class InterfazGrafica extends JFrame implements ActionListener{
   JPanel miPanel,panelSuper,pfan;
   Plano p=new Plano(30);
   JButton boto;
   JTextField jteradio;
    Vector vectorcartesian=new Vector();
     Circulo c=new Circulo();
   public InterfazGrafica()  {
        
        super("panel ");
        Container contenedor=getContentPane();
        gui();
        setSize(700, 600);
        setVisible(true);
        
    }
   
   public void gui(){
   JSplitPane jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        miPanel=new JPanel();
        panelSuper=new JPanel();
        pfan=new JPanel();
        jteradio=new JTextField(); 
       boto= new JButton("grafica");
      boto.setBounds(new Rectangle(30,30,100,75));
      
      miPanel.setLayout(new GridLayout(1,2));
      panelSuper.setLayout(new GridLayout(9, 1));
//        miPanel.setBackground(Color.red);
       // miPanel.setSize(400, 300);
        JSlider jslider=new JSlider(SwingConstants.VERTICAL,2,100,20);
//          jslider.setBounds(new Rectangle(50,150,50,350));
        jslider.putClientProperty("JSlider.isFilled", true);
        jslider.setPaintTicks(true);
        jslider.setMajorTickSpacing(6);
        jslider.setMinorTickSpacing(3);
        jslider.setPaintLabels(true);
        jslider.setForeground(Color.blue);
        jslider.setValue(10);
       
        ////        contenedor.add(miPanel, BorderLayout.CENTER);
        p.Limites(10, 10, -10, -10);
        p.Origen();
        miPanel.add(jteradio);
        miPanel.add(boto);
        
        panelSuper.add(pfan);
        panelSuper.add(miPanel);
        boto.addActionListener(this);
        jsp.add(panelSuper);
        jsp.add(p);
       
         add(jsp);
   
   }
   /*
    Hasta aqui esta graficanod el primer cuadrante
    
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boto) {
            int r=Integer.parseInt(jteradio.getText());
           
            c.crearCirculo(r);
            grafica();
        }
    }
    
    public void grafica(){
        
          vectorcartesian=c.getCordenadasX();
          
          for(int i=0;i<vectorcartesian.size();i++){
              p.Punto(((Point)vectorcartesian.elementAt(i)).x, ((Point)vectorcartesian.elementAt(i)).y);
              p.Punto(((Point)vectorcartesian.elementAt(i)).y, ((Point)vectorcartesian.elementAt(i)).x);
              p.Punto(((Point)vectorcartesian.elementAt(i)).x*-1, ((Point)vectorcartesian.elementAt(i)).y);
              p.Punto(((Point)vectorcartesian.elementAt(i)).y*-1, ((Point)vectorcartesian.elementAt(i)).x*-1);
              
//                 p.Punto(((Point)vectorcartesian.elementAt(i)).x*-1, ((Point)vectorcartesian.elementAt(i)).y);
//                 p.Punto(((Point)vectorcartesian.elementAt(i)).x, ((Point)vectorcartesian.elementAt(i)).y*-1);
   
              p.repaint();
          }
   
    
    }
    
    public static void main(String args[]){
    
          InterfazGrafica i=new InterfazGrafica();
    }

  

   
    
    
    
}
