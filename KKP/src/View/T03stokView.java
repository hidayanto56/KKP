/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.T01jualCtrl;
import Control.T03stokCtrl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thinkpad
 */
public class T03stokView extends javax.swing.JInternalFrame {

    /**
     * Creates new form T03stokView
     */
    public T03stokView() {
        initComponents();
        txtID.setEditable(false);
        txtTanggal.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//        txtTanggal.setBorder(;

        T03stokCtrl t01 = new T03stokCtrl();
        tblStok.setModel(t01.getDaftarStok());
//        setEditStatus(false);
        setVisible(true);

        for (int i = 0; i < t01.getKodeTabung().getRowCount(); i++) {
            cmbKdTabung.addItem(t01.getKodeTabung().getValueAt(i, 0));

        }
//        for (int i=0; i < t01.getKodeCustomer().getRowCount(); i++){
//            cmbKdCust.addItem(t01.getKodeCustomer().getValueAt(i, 0));
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStok = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtTanggal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNmTabung = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbKdTabung = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setClosable(true);

        tblStok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStokMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStok);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(270, 232));

        txtTanggal.setToolTipText("DD-MM-YYYY");
        txtTanggal.setPreferredSize(new java.awt.Dimension(160, 20));
        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });
        txtTanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTanggalKeyReleased(evt);
            }
        });

        jLabel2.setText("Kode Tabung");

        jLabel1.setText("Tanggal");

        txtHarga.setPreferredSize(new java.awt.Dimension(140, 20));

        jLabel3.setText("Nama Tabung");

        txtNmTabung.setPreferredSize(new java.awt.Dimension(140, 20));
        txtNmTabung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNmTabungActionPerformed(evt);
            }
        });

        jLabel4.setText("Harga Satuan");

        jLabel7.setText("Jumlah");

        txtJumlah.setPreferredSize(new java.awt.Dimension(140, 20));

        jLabel8.setText("Keterangan");

        cmbKdTabung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKdTabungActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtKeterangan.setColumns(18);
        txtKeterangan.setRows(5);
        jScrollPane2.setViewportView(txtKeterangan);

        jLabel9.setText("Kode");

        txtID.setToolTipText("DD-MM-YYYY");
        txtID.setPreferredSize(new java.awt.Dimension(160, 20));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNmTabung, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKdTabung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbKdTabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNmTabung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTambah.setText("Tambah");
        btnTambah.setPreferredSize(new java.awt.Dimension(80, 23));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.setPreferredSize(new java.awt.Dimension(80, 23));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 23));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setPreferredSize(new java.awt.Dimension(80, 23));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.setPreferredSize(new java.awt.Dimension(80, 23));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(80, 23));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setPreferredSize(new java.awt.Dimension(80, 23));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void txtTanggalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTanggalKeyReleased
//        txtTanggal.setText(txtTanggal.getText().toUpperCase());
    }//GEN-LAST:event_txtTanggalKeyReleased

    private void txtNmTabungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNmTabungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNmTabungActionPerformed

    private void cmbKdTabungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKdTabungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKdTabungActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyReleased

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        if (!txtTanggal.getText().equals("") || txtTanggal.getText() != null) {
            T03stokCtrl cb = new T03stokCtrl();
            String tanggal = txtTanggal.getText();
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = null;
            try {
                date = format.parse(tanggal);
            } catch (ParseException ex) {
                Logger.getLogger(T03stokView.class.getName()).log(Level.SEVERE, null, ex);
            }

            cb.setTanggal(date);
            cb.setKd_tabung(cmbKdTabung.getSelectedItem().toString());
            if (txtJumlah.getText() != null) {
                cb.setJumlah(Integer.parseInt(txtJumlah.getText()));
            } else {
                cb.setJumlah(0);
            }
            cb.setKeterangan(txtKeterangan.getText());
            cb.tambahStok();

            btnClearActionPerformed(evt);
            tblStok.setModel(cb.getDaftarStok());

        } else {
            JOptionPane.showInternalMessageDialog(this, "Tanggal tidak boleh kosong", "Error", JOptionPane.INFORMATION_MESSAGE);
            //            JOptionPane.showInternalMessageDialog(null,
            //                    "Kode Customer dan Nama Customer harus diisi", "ERROR",
            //                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        try {
            T03stokCtrl cbm = new T03stokCtrl();

            String tanggal = txtTanggal.getText();
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(tanggal);

            cbm.setTanggal(date);
            cbm.setKd_tabung(cmbKdTabung.getSelectedItem().toString());
            tblStok.setModel(cbm.getCariStok());
        } catch (ParseException ex) {
            Logger.getLogger(T03stokView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        T03stokCtrl cb = new T03stokCtrl();
        String tanggal = txtTanggal.getText();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = format.parse(tanggal);
        } catch (ParseException ex) {
            Logger.getLogger(T03stokView.class.getName()).log(Level.SEVERE, null, ex);
        }

        cb.setTanggal((java.sql.Date) date);
        cb.setKd_tabung(cmbKdTabung.getSelectedItem().toString());
        if (txtJumlah.getText() != null) {
            cb.setJumlah(Integer.parseInt(txtJumlah.getText()));
        } else {
            cb.setJumlah(0);
        }
        cb.setKeterangan(txtKeterangan.getText());
        cb.editStok();

        setEditStatus(false);
        btnClearActionPerformed(evt);

        T03stokCtrl cb2 = new T03stokCtrl();
        tblStok.setModel(cb2.getDaftarStok());
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearText();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        T03stokCtrl cb = new T03stokCtrl();
        cb.printStok();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        T03stokCtrl cb = new T03stokCtrl();
        cb.setT03_id(Long.parseLong(txtID.getText()));
//        cb.setNmcust(txtNmCust.getText());
        cb.hapusStok();

        setHapusStatus(false);
        btnClearActionPerformed(evt);

        T03stokCtrl cb2 = new T03stokCtrl();
        tblStok.setModel(cb2.getDaftarStok());
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        setEditStatus(false);
        btnClearActionPerformed(evt);
        T03stokCtrl cb = new T03stokCtrl();
        tblStok.setModel(cb.getDaftarStok());
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tblStokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStokMouseClicked
        int tableData = tblStok.getSelectedRow();
        txtID.setText(tblStok.getValueAt(tableData, 0).toString());
        txtTanggal.setText(tblStok.getValueAt(tableData, 1).toString());
        cmbKdTabung.setSelectedItem(tblStok.getValueAt(tableData, 2).toString());
        txtNmTabung.setText(tblStok.getValueAt(tableData, 3).toString());
        txtHarga.setText(tblStok.getValueAt(tableData, 4).toString());
        txtJumlah.setText(tblStok.getValueAt(tableData, 5).toString());
        txtKeterangan.setText(tblStok.getValueAt(tableData, 6).toString());
       
                setEditStatus(false);
    }//GEN-LAST:event_tblStokMouseClicked

    private void setEditStatus(boolean status) {
        if (status == false) {
            btnCari.setEnabled(true);
            btnTambah.setEnabled(true);
            btnHapus.setEnabled(true);
            btnEdit.setEnabled(false);
            btnBatal.setEnabled(true);
            txtTanggal.setEditable(false);
            cmbKdTabung.setEnabled(false);
            txtNmTabung.setEditable(false);
            txtHarga.setEditable(false);
            txtJumlah.setEditable(false);
            txtKeterangan.setEditable(false);

        } else {
            btnCari.setEnabled(false);
            btnTambah.setEnabled(false);
            btnHapus.setEnabled(true);
            btnEdit.setEnabled(true);
            btnBatal.setEnabled(true);
            txtTanggal.setEditable(true);
            cmbKdTabung.setEnabled(true);
            txtNmTabung.setEditable(true);
            txtHarga.setEditable(true);
            txtJumlah.setEditable(false);
            txtKeterangan.setEditable(false);

        }
    }

    private void clearText() {
        txtID.setText("");
        txtTanggal.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        txtNmTabung.setText("");
        txtHarga.setText("");
        txtJumlah.setText("");
        txtKeterangan.setText("");
    }

    private void setHapusStatus(boolean status) {
        if (status == false) {
            btnCari.setEnabled(true);
            btnTambah.setEnabled(true);
            btnClear.setEnabled(true);
            btnEdit.setEnabled(false);
            btnHapus.setEnabled(false);
            btnBatal.setEnabled(false);
            txtTanggal.setEditable(true);
            cmbKdTabung.setEnabled(true);
            txtNmTabung.setEditable(true);
            txtHarga.setEditable(true);
            txtJumlah.setEditable(true);
            txtKeterangan.setEditable(true);

        } else {
            btnCari.setEnabled(false);
            btnTambah.setEnabled(false);
            btnClear.setEnabled(false);
            btnEdit.setEnabled(true);
            btnHapus.setEnabled(true);
            btnBatal.setEnabled(true);
            txtTanggal.setEditable(false);
            cmbKdTabung.setEnabled(false);
            txtNmTabung.setEditable(false);
            txtHarga.setEditable(false);
            txtJumlah.setEditable(false);
            txtKeterangan.setEditable(false);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox cmbKdTabung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStok;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtNmTabung;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
