package childout_Manu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Listado extends javax.swing.JPanel {
    
    Salida salida = new Salida();
    GestionSalida gestion = new GestionSalida();
    
    public Listado() {
        initComponents();
        inicio();
    }
    
    private void inicio() {
        Conexion.conectar("localhost", "root", "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ordenarPor = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAlumno = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNumSalidas = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("Salidas");

        jLabel2.setText("Mostrar por:");

        ordenarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fecha", "Grupo", "Alumno/a", "Persona autorizada" }));
        ordenarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarPorActionPerformed(evt);
            }
        });

        jTextAreaAlumno.setColumns(20);
        jTextAreaAlumno.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAlumno);

        jTextAreaNumSalidas.setColumns(20);
        jTextAreaNumSalidas.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNumSalidas);

        jLabel4.setText("Nº Salidas:");

        jLabel5.setText("Por día:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ordenarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ordenarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarPorActionPerformed
        String ordenarElegido = ordenarPor.getSelectedItem().toString();
        if(ordenarElegido.equalsIgnoreCase("Fecha")) {
            jLabel5.setVisible(true);
            jDateChooser1.setVisible(true);
        } else {
            jLabel5.setVisible(false);
            jDateChooser1.setVisible(false);
        }
        
        ArrayList<Salida> listaAlumnos;
        
        switch(ordenarPor.getSelectedIndex()) {
            case 0:
                Date fechaSeleccionada = jDateChooser1.getDate();
                SimpleDateFormat  fechaCorta = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = fechaCorta.format(fechaSeleccionada);
                
                if(fecha.equals(gestion.get(1).getFecha().toString())) {
                    jTextAreaAlumno.setText(gestion.get(1).getFecha()+"");
                    
                }        
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                jTextAreaAlumno.setText(gestion.get(1).getIdAutorizado()+"");
                
                jTextAreaNumSalidas.setText("");
        }

        /*
        switch(ordenarPor.getSelectedIndex()) {
            case 0:
                listaAlumnos = gestion.findByAlumno(2);
                for (int i = 0; i < listaAlumnos.size(); i++) {
                    jTextAreaAlumno.append(gestion.get(i).getFecha()+"\n");
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
        }*/
    }//GEN-LAST:event_ordenarPorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaAlumno;
    private javax.swing.JTextArea jTextAreaNumSalidas;
    private javax.swing.JComboBox ordenarPor;
    // End of variables declaration//GEN-END:variables
}
