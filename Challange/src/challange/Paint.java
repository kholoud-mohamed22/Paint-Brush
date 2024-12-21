/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challange;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;


/**
 *
 * @author Khloud
 */
public class Paint extends javax.swing.JFrame {

    /**
     * Creates new form Paint
     */
    int x1,y1,x2,y2,width,height,redc,blackc,greenc,bluec,startx,starty,er;
    String shape;
    List<Rectangle> recs = new ArrayList<>(); 
    List<Rectangle> ovals = new ArrayList<>(); 
     List<Line2D.Double> lines = new ArrayList<>();
     List<String> undo = new ArrayList<>(); 
     List<Rectangle> erasers = new ArrayList<>(); 
     List<Shape> sh = new ArrayList<>(); 
     boolean dottedLine = false;
     boolean solidLine = true; 
     String last,c_coler;
        
    public Paint() {
        initComponents();
        
        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               recs.clear();
               ovals.clear();
               lines.clear();
                erasers.clear(); 
               repaint();
            }
        });
        undo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String lastShape = undo.get(undo.size() - 1);
                
                 if (last.equals("line") ) {
                    lines.remove(lines.size() - 1);
                    repaint();
                } else if ("rec".equals(last) ) {
                    recs.remove(recs.size() - 1);
                    repaint();
                } else if ("oval".equals(last) ) {
                    ovals.remove(ovals.size() - 1);
                    repaint();
                }
                 undo.remove(undo.size() - 1);
                 repaint();
           
            }
        });
        

        pen.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        shape = "pen";

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
               
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                        x2 = e.getX();
                        y2 = e.getY();
                        if (shape=="pen") {
                            lines.add(new Line2D.Double(x1, y1, x2, y2));
                        }
                        repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                lines.add(new Line2D.Double(x1, y1, x2, y2));
                x1=x2;
                y1=y2;
               
                repaint();  
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
});
        
        line.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        shape = "line";

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // لا حاجة لكتابة شيء هنا
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
              
                if (shape =="line"){
                    lines.add(new Line2D.Double(x1, y1, x2, y2));
                    last="line";
                   // repaint(); 
                }
                undo.add("line");
   
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
  
               x2=e.getX();
                y2=e.getY();
                repaint();  
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
});

        
        rec.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
            shape="rec";
            addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
            
            }

            @Override
            public void mousePressed(MouseEvent e) {
                  x1=e.getX();
                  y1=e.getY();
             
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                 x2 = e.getX();
                y2 = e.getY();
                
                if (shape.equals("rec")) {
                            recs.add(new Rectangle(startx, starty, width, height));
                     last="rec";   
                }
                      //  repaint();
                      undo.add("rec");
              
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               }

            @Override
            public void mouseExited(MouseEvent e) {
                }
        });
        
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
               
                
                repaint();
                
                  
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                }
        });
            
            
            
            }
                });
        
        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape="oval";
               
            
            addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
            
            }

            @Override
            public void mousePressed(MouseEvent e) {
                  x1=e.getX();
                  y1=e.getY();
             
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                x2 = e.getX();
                y2 = e.getY();

                if (shape.equals("oval")) {
                            ovals.add(new Rectangle(startx, starty, width, height));
                  last="oval";      
                }
                      undo.add("oval");
           }

            @Override
            public void mouseEntered(MouseEvent e) {
               }

            @Override
            public void mouseExited(MouseEvent e) {
                }
        });
        
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2=e.getX();
                y2=e.getY();
               
                repaint();
                 
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                }
        });
            
            
            
            }
                });
        
        eraser.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               
            shape="ers";
           
            addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
            
            }

            @Override
            public void mousePressed(MouseEvent e) {
                  x1=e.getX();
                  y1=e.getY();
             
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                 x2 = e.getX();
                y2 = e.getY();
                
                if (shape.equals("ers")) {
                    erasers.add(new Rectangle(x1, y1, 20, 20)); // حجم الممحاة أصغر
                    repaint();
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
               }

            @Override
            public void mouseExited(MouseEvent e) {
                }
        });
        
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                 x2=e.getX();
                y2=e.getY();
                
               if ("ers".equals(shape)) {
        erasers.add(new Rectangle(x2, y2, 20, 20)); // حجم الممحاة هنا 20x20
    }

    repaint();
                  
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                }
        });
            
            
            
            }
                });
        dotted.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dottedLine = true;
                solidLine = false;
            }
        });

        solid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solidLine = true;
                dottedLine = false;
            }
        });
        
        black.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    blackc=1;
                    c_coler="blac";
            }
            
        });
        red.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    redc=1;
                    c_coler="red";
            }
            
        });
        green.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    greenc=1;
            }
            
        });
        blue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    bluec=1;
            }
            
        });
        
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rec = new javax.swing.JButton();
        red = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        oval = new javax.swing.JButton();
        line = new javax.swing.JButton();
        pen = new javax.swing.JButton();
        undo_button = new javax.swing.JButton();
        black = new javax.swing.JButton();
        green = new javax.swing.JButton();
        blue = new javax.swing.JButton();
        eraser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dotted = new javax.swing.JCheckBox();
        solid = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rec.setText("Rec");

        red.setBackground(new java.awt.Color(204, 0, 0));
        red.setText("Red");

        clear_button.setText("Clear");

        oval.setText("Oval");

        line.setText("Line");

        pen.setText("Pencil");

        undo_button.setText("Undo");

        black.setBackground(new java.awt.Color(0, 0, 0));
        black.setForeground(new java.awt.Color(255, 255, 255));
        black.setText("Black");

        green.setBackground(new java.awt.Color(0, 102, 0));
        green.setText("Green");

        blue.setBackground(new java.awt.Color(0, 0, 153));
        blue.setText("Blue");

        eraser.setText("Eraser");

        jLabel1.setText("Colors:");

        dotted.setText("Dotted");

        solid.setText("Solid");

        jLabel2.setText("Paint Mode");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clear_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undo_button)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rec, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oval, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eraser)
                .addGap(36, 36, 36)
                .addComponent(solid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dotted)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(black)
                .addGap(18, 18, 18)
                .addComponent(red)
                .addGap(18, 18, 18)
                .addComponent(green)
                .addGap(18, 18, 18)
                .addComponent(blue)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rec)
                    .addComponent(red)
                    .addComponent(clear_button)
                    .addComponent(oval)
                    .addComponent(line)
                    .addComponent(pen)
                    .addComponent(undo_button)
                    .addComponent(black)
                    .addComponent(green)
                    .addComponent(blue)
                    .addComponent(eraser)
                    .addComponent(jLabel1)
                    .addComponent(dotted)
                    .addComponent(solid)
                    .addComponent(jLabel2))
                .addContainerGap(522, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }
     @Override
    public void paint(Graphics g) {
        super.paint(g); 


        Graphics2D g2d = (Graphics2D) g;
 
        for (Line2D.Double line : lines) {
            g2d.draw(line);
        }
         if (blackc == 1) {
            g.setColor(Color.BLACK);
        }
         if (redc == 1) {
            g.setColor(Color.RED);
        }
         if (greenc == 1) {
            g.setColor(Color.GREEN);
        }
         if (bluec == 1) {
            g.setColor(Color.blue);
        }
         
       
        
        for (Rectangle rect : recs) {
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        
    }
        for (Rectangle ov : ovals) {
        g.drawOval(ov.x, ov.y, ov.width, ov.height);
    }
       for (Line2D l : lines) {  // تعديل هنا لاستخدام Line2D.Double
            g.drawLine((int) l.getX1(), (int) l.getY1(), (int) l.getX2(), (int) l.getY2());  // تعديل هنا لتحويل الإحداثيات إلى int
        }
       for (Rectangle rect : erasers) {
          g.setColor(Color.decode("#D6D9DF"));
          g.fillRect(rect.x, rect.y, rect.width, rect.height);
          }
         if (blackc == 1) {
            g.setColor(Color.BLACK);
        }
         if (redc == 1) {
            g.setColor(Color.RED);
        }
         if (greenc == 1) {
            g.setColor(Color.GREEN);
        }
         if (bluec == 1) {
            g.setColor(Color.blue);
        }
         

     
         width = Math.abs(x2 - x1);
         height = Math.abs(y2 - y1);
         startx=Math.min(x1, x2);
         starty=Math.min(y1, y2);
        
        
       
      if(shape=="rec"){
           
           g.drawRect(startx,starty,width, height);
      }else if(shape=="oval"){
           g.drawOval(startx, starty, width, width);
      }else if(shape=="ers"){
           g.setColor(Color.decode("#D6D9DF"));
          g.fillRect(startx, starty, 50, 50);
      }
      else if ("pen".equals(shape) ) {
        g.drawLine(x1, y1, x2, y2);
    }
      else if ("line".equals(shape) ) {
        g.drawLine(x1, y1, x2, y2);
    }
      
       
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton black;
    private javax.swing.JButton blue;
    private javax.swing.JButton clear_button;
    private javax.swing.JCheckBox dotted;
    private javax.swing.JButton eraser;
    private javax.swing.JButton green;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton line;
    private javax.swing.JButton oval;
    private javax.swing.JButton pen;
    private javax.swing.JButton rec;
    private javax.swing.JButton red;
    private javax.swing.JCheckBox solid;
    private javax.swing.JButton undo_button;
    // End of variables declaration//GEN-END:variables
}
