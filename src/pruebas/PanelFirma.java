package pruebas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PanelFirma extends javax.swing.JPanel {

    private ArrayList<TrazoManoAlzada> listaTrazos = new ArrayList();
    TrazoManoAlzada trazoActual;
    
    public PanelFirma() {
        initComponents();
        this.setBackground(Color.WHITE);
    }

    public void limpiar() {
        listaTrazos.clear();
        trazoActual = null;
        repaint();
    }
    
    public int getMarginLeft() {
        int marginLeft = 0;
        if(listaTrazos.size()>0) {
            marginLeft = listaTrazos.get(0).getPointOrigen().x;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getPointOrigen().x < marginLeft) {
                    marginLeft = t.getPointOrigen().x;
                }
            }
        }    
        return marginLeft;
    }
    
    public int getMarginTop() {
        int marginTop = 0;
        if(listaTrazos.size()>0) {
            marginTop = listaTrazos.get(0).getPointOrigen().y;
            for(TrazoManoAlzada t:listaTrazos) {
                if(t.getPointOrigen().y < marginTop) {
                    marginTop = t.getPointOrigen().y;
                }
            }
        }       
        return marginTop;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(listaTrazos.size()>0) {
            for(TrazoManoAlzada t:listaTrazos) {
                t.draw(g);
            }
        }
        if(trazoActual!=null) {
            trazoActual.draw(g);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        trazoActual.addPoint(evt.getX(), evt.getY());
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        trazoActual = new TrazoManoAlzada(evt.getX(), evt.getY());
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        listaTrazos.add(trazoActual);
        repaint();
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
