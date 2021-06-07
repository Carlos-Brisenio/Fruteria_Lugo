
package Ventas;

import java.awt.Frame;
import javax.swing.table.DefaultTableModel;
import Clases.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import Productos.*;


public class NuevaVenta extends javax.swing.JDialog{

    AdminVentasCompras acv;
    Productos[] productos;
    Clientes[] clientes;
    DefaultTableModel table;   
    int cantidad[]=new int[20];
    Validar validar = new Validar();
    float total;
    Frame parent;
    String id;
    float ganancia = 1.16f;
    
    /**
     * Creates new form NuevaVenta
     * @param parent
     * @param md
     */
    public NuevaVenta(AdminVentasCompras acv,Frame parent, boolean md) {
        super(parent, md);
        this.acv=acv;
        this.parent = parent;                      
        initComponents();  
        this.setLocationRelativeTo(null);
        table=(DefaultTableModel) tablaProducto.getModel();
        tablaProducto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);         
        tablaProducto.changeSelection(tablaProducto.getRowCount(), 1, false, false);        
        clientes=acv.consultarClientes("nombre");
        try{
            for(int x=0; x<clientes.length;x++)
                listaNombres.addItem((String)clientes[x].getNombre());            
        }catch(Exception e){}
        productos=acv.consultarProductos("nombre");
        try{
            for(int x=0; x<productos.length;x++)
            listProductos.addItem((String)productos[x].getNombre()); 
        }catch(Exception e){}
            total = 0;    
        this.acv.setNumproductos(0);
        this.acv.setOp("ventas");
        //id=this.acv.generarID("Encabezadoventa"); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listaNombres = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        listProductos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnRealizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/manzanita.png"))); // NOI18N
        jLabel1.setText("PUNTO DE VENTA FRUTERIA LUGO");

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3643764-back-backward-left-reply-turn_113415.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnRegresar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Realizar Venta"));

        jLabel2.setText("Cliente: ");

        listaNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaNombresActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 255, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_circle_create_expand_new_plus_icon_123218.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        listProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listProductosActionPerformed(evt);
            }
        });

        jLabel3.setText("Producto:");

        txtCantidad.setText("1");

        jLabel4.setText("Cantidad:");

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProducto);

        jLabel6.setText("Total: ");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnRealizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check_ok_accept_apply_1582.png"))); // NOI18N
        btnRealizar.setText("Relizar Venta");
        btnRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/canceltheapplication_cancelar_2901.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(163, 163, 163))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(listProductos, 0, 238, Short.MAX_VALUE)
                                        .addComponent(listaNombres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(32, 32, 32)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)))))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Finalizar transaccion de venta"
                , "Finalizar venta", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {   
            String idCliente;            
            Calendar fecha = Calendar.getInstance();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            idCliente= clientes[listaNombres.getSelectedIndex()].getId();
            id = acv.generarID("ventas_detalladas");   
            JOptionPane.showMessageDialog(this, "Venta realizada, el numero de id de la venta es: "+id
                +"\nFecha: " +dia+"/"+mes+"/"+año,"Venta realizada", JOptionPane.INFORMATION_MESSAGE);                     
            acv.setDetalladas(id, idCliente, total, dia, mes ,año);                        
            
            acv.actualizarUnidades(cantidad);                                      
            
            acv.guardar();            
        }
    }//GEN-LAST:event_btnRealizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(acv.getNumproductos()<20){
            int indice, cant;
            float subtotal;
            String  idP;
            String scant;
            String row[];
            scant=txtCantidad.getText();              
            subtotal=0;
            if(validar.cantidad(scant)){
                int indexCV;
                indice=(int)listProductos.getSelectedIndex();  
                idP=productos[indice].getId();  
                cant=Integer.parseInt(scant);                                
                indexCV = acv.buscarCompraVenta(idP);
                if(indexCV==-1){                    
                    if(productos[indice].getExistencia()>=cant){      
                        cantidad[acv.getNumproductos()]=cant;
                        productos[indice].setExistencia(productos[indice].getExistencia()-cant);
                        subtotal= productos[indice].getPrecio()*ganancia*cant;
                        //to add new row: new Object[] {String, float,String,int, float}
                        table.insertRow(table.getRowCount(), new Object[] { 
                            productos[indice].getNombre() , productos[indice].getPrecio()
                             ,cant , subtotal });                  
                        total+=subtotal;                             
                        acv.agregarCompraVenta(id, idP, cant ,subtotal);
                    }else
                        JOptionPane.showMessageDialog(this, "No hay existencias suficientes para"
                                + "completar este pedido"
                            , "Existencias insuficientes", JOptionPane.ERROR_MESSAGE);
                }else{
                    cant+=acv.getCantidadCV(indexCV);
                    if(productos[indice].getExistencia()>=cant-1){                                                           
                        subtotal= productos[indice].getPrecio()*ganancia*cant;
                        cantidad[indexCV]=cant;
                        table.setValueAt(cant, indexCV, 3);
                        table.setValueAt(subtotal, indexCV, 4);                           
                        total+=productos[indice].getPrecio()*(cant-acv.getCantidadCV(indexCV));                             
                        acv.agregarCompraVenta(indexCV,id, idP, cant ,subtotal);
                    }else
                        JOptionPane.showMessageDialog(this, "No hay existencias suficientes para"
                                + "completar este pedido"
                            , "Existencias insuficientes", JOptionPane.ERROR_MESSAGE);
                }
                
            }else
                    JOptionPane.showMessageDialog(this, "Favor de no dejar el campo Cantidad vacio"
                            , "Campo Vacio", JOptionPane.ERROR_MESSAGE);
            txtTotal.setText("$"+total);
            btnRealizar.setEnabled(true);                                    
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Se ha alcanzado la cantidad maxima de productos por venta"
                        , "Carrito lleno", JOptionPane.ERROR_MESSAGE);
        }
    }                                           

    private void opc1TablaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ///////////////////////////////////////////////////////////////////////////////
        try{
            int index = tablaProducto.getSelectedRow();  
            total-=(float) table.getValueAt(index, 5);          
            for(int x=index; x<acv.getNumproductos()-1;x++){
                cantidad[x]=cantidad[x+1];                
            }
            table.removeRow(index);          
            txtTotal.setText("$"+total);            
            acv.quitarCompraVenta(index);
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("error:"+e);
        }
        if(tablaProducto.getRowCount()==0){
            btnRealizar.setEnabled(false);           
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la compra actual?"
                , "Cancelar compra", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {            
            JOptionPane.showMessageDialog(null, "Venta cancelada");
            if(acv.getNumproductos()>0){                
                for (int i = 0; i < acv.getNumproductos(); i++) {
                    table.removeRow(0);
                }
                acv.setNumproductos(0);
            }
            txtCantidad.setText("");
            txtTotal.setText("");
            listProductos.setSelectedIndex(0);
            listaNombres.setSelectedIndex(0);            
        } 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void listaNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaNombresActionPerformed
       clientes[listaNombres.getSelectedIndex()].getNombre();
    }//GEN-LAST:event_listaNombresActionPerformed

    private void listProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listProductosActionPerformed
        productos[listProductos.getSelectedIndex()].getNombre();
    }//GEN-LAST:event_listProductosActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tablaProductoMousePressed(java.awt.event.MouseEvent evt) {                                           
        if ((evt.getModifiers() & 4) !=0)
            {//pop.show(this,evt.getX()+37, evt.getY()+298);
        }
    }                                          

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {                                     
        tablaProducto.clearSelection();
    }                                    

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
        listProductos.removeAllItems();
        productos=acv.consultarProductos("nombre");
        for (Productos producto : productos) {
            listProductos.addItem((String) producto.getNombre());        
        }
    }                                      
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRealizar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listProductos;
    private javax.swing.JComboBox<String> listaNombres;
    private javax.swing.JTable tablaProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}