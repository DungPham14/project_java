/*
    * Developed by: 
    * Tran Van Luong
    * Pham Duc Dung
    * Duong Dinh Hiep
    * Phan Cong Thang
    * Nguyen Ngoc Duy
*/

package dictionary;

import java.awt.*;

import java.io.*;

import java.util.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.logging.*;


public class Dictionary extends javax.swing.JFrame {


    /**
     * Creates new form Dictionary
     */

    public Dictionary() {

        super("Dictionary");

        setVisible(true);
 
        initComponents();

    }

    
    @SuppressWarnings("unchecked")

    private void initComponents() {
        /*---- Developed by: Tran Van Luong----  */

        jScrollPane1 = new javax.swing.JScrollPane();

        taMean = new javax.swing.JTextArea();

        lbDich = new javax.swing.JLabel();

        btDich = new javax.swing.JButton();

        btThem = new javax.swing.JButton();

        btSua = new javax.swing.JButton();

        tfNhap = new javax.swing.JTextField();

        cbKieu = new javax.swing.JComboBox();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Từ Điển Anh Việt - Việt Anh");


        taMean.setColumns(20);

        taMean.setRows(5);

        jScrollPane1.setViewportView(taMean);


        lbDich.setText("Translate");


        btDich.setText("Dịch");

        btDich.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btDichActionPerformed(evt);
            }

        });


        btThem.setText("Thêm");

        btThem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btThemActionPerformed(evt);

            }

        });


        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btSuaActionPerformed(evt);

            }

        });


        tfNhap.setText("Nhập văn bản");

        tfNhap.setName("nhập");
 // NOI18N


        cbKieu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Anh-Việt", "Việt-Anh" }));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()

                .addGap(45, 45, 45)

                .addComponent(lbDich)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

                        .addGroup(layout.createSequentialGroup()

                        .addComponent(btDich, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                        .addComponent(btThem)

                        .addGap(58, 58, 58)

                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addGroup(layout.createSequentialGroup()

                        .addComponent(tfNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                        .addComponent(cbKieu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))

                .addGap(20, 20, 20))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                .addGap(55, 55, 55)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                    .addComponent(tfNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(cbKieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(lbDich)

                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addComponent(btDich)

                    .addComponent(btThem)

                    .addComponent(btSua))

                .addGap(95, 95, 95))
        ) ;

        pack();

    }
// </editor-fold>//GEN-END:initComponents


    private void btDichActionPerformed(java.awt.event.ActionEvent evt) {
    /*----------------- Developed by: Pham Duc Dung -----------------*/

        class Test {

            String E, V;

            public Test(String E, String V) {
                this.E = E;
                this.V = V;
            }
            
            public Test() {           }
            
            public String getE() {      return E;        }

            public String getV() {  return V;  }

            public void setE(String english) {   this.E = english;   }

            public void setV(String vietnamese) {  this.V = vietnamese;   }


        }


        class Mains {

           int numberFrom;

            private ArrayList<Test> dictionarys = new ArrayList<>();

            private String[] save;

            public void readFile() throws IOException {

                File file = new File("word.txt");

                FileReader fr = new FileReader(file);

                BufferedReader br = new BufferedReader(fr);

                String line = null;

                int count = 0;

                try {

                    while ((line = br.readLine()) != null) {

                        try {
                            save = line.split("-");
                            dictionarys.add(new Test(save[0], save[1]));
                        }
                        catch (Exception e) {     continue;   }
                        
                        count++;
                    }

                    numberFrom = count;

                    System.out.println(numberFrom);

                    fr.close();

                    br.close();

                } catch (Exception e) {    }

 
           }


            public void englishVietnam() {

                String word = tfNhap.getText();

                for (int i = 0; i < numberFrom; i++) {

                    if (dictionarys.get(i).getE().equalsIgnoreCase(word)) {

                        taMean.setText(dictionarys.get(i).getV());

                    }
                }
            }

            public void vietnamEnglish() {

                String word = tfNhap.getText();

                for (int i = 0; i < numberFrom; i++) {

                    if (dictionarys.get(i).getV().equalsIgnoreCase(word)) {

                        taMean.setText(dictionarys.get(i).getE());

                    }
                    else {

                        String[] tv = dictionarys.get(i).getV().split(", ");

                        for (int j = 0; j < tv.length; j++) {
 
                           if (tv[j].equalsIgnoreCase(word)) {
                                taMean.setText(dictionarys.get(i).getE());
                            }
                           
                        }
                    }
                }
            }
 
       }

        Mains m = new Mains();

        try {        m.readFile();       }
        
	catch (IOException ex) {
            Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ((cbKieu.getSelectedItem().toString()).equalsIgnoreCase("Anh-Việt")) {

            m.englishVietnam();

        }

        if ((cbKieu.getSelectedItem().toString()).equalsIgnoreCase("Việt-Anh")) {

            m.vietnamEnglish();

        }
    }


    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {
        /*----------- Developed by: Nguyen Ngoc Duy ----------*/

        class AddWords extends JFrame {

            private JTextField tfWord;

            private JTextArea taMeaning;

            private JButton btnAdd;

            private String w;

            private String m;


            public AddWords() {

                super("Add Words");

                GridBagLayout gbl = new GridBagLayout();

                GridBagConstraints gbc = new GridBagConstraints();

                gbc.insets = new Insets(5, 5, 5, 5);

                gbc.fill = GridBagConstraints.BOTH;


                tfWord = new JTextField(35);

                taMeaning = new JTextArea();

                btnAdd = new JButton("Add Word");

                btnAdd.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                       if (tfWord.getText().length() > 0 && taMeaning.getText().length() > 0) {

                            w = tfWord.getText();

                            m = taMeaning.getText();

                            tfWord.setText("");

                            taMeaning.setText("");

                            tfWord.requestFocus();


                            File file = new File("word.txt");

                            try {

                                file.createNewFile();

                                FileWriter fw = new FileWriter(file, true);

                                BufferedWriter bw = new BufferedWriter(fw);

                                fw.write("\n" + w);

                                fw.write("-");

                                fw.write(m + "\r\n");

                                fw.close();

                                bw.close();


                            } catch (IOException ex) {

                                Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);

                            }

                            JOptionPane.showMessageDialog(AddWords.this, "Added Word Successfully!", "Add Word", JOptionPane.INFORMATION_MESSAGE);

                        } else {

                            JOptionPane.showMessageDialog(AddWords.this, "Please enter word and meaning!", "Add Word", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                } );

                Container c = getContentPane();

                c.setLayout(gbl);


                // add tfWord

                gbc.anchor = GridBagConstraints.EAST;

                c.add(new JLabel("Enter Word :"), gbc);

                gbc.anchor = GridBagConstraints.WEST;

                c.add(tfWord);


                // add taMeaning

                gbc.gridx = 0;

                gbc.anchor = GridBagConstraints.EAST;

                c.add(new JLabel("Enter Meaning :"), gbc);

                gbc.anchor = GridBagConstraints.WEST;

                gbc.gridx = 1;

                gbc.gridwidth = 2;

                gbc.gridheight = 2;

                taMeaning.setRows(3);

                taMeaning.setColumns(30);

                JScrollPane sp = new JScrollPane(taMeaning, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                c.add(sp, gbc);


                // add button

                gbc.gridx = 0;

                gbc.gridwidth = 3;

                gbc.anchor = GridBagConstraints.CENTER;

                gbc.fill = GridBagConstraints.NONE;

                c.add(btnAdd, gbc);


                pack();
 // get requried size based on
            }
        }

        AddWords w = new AddWords();

        w.setVisible(true);

    }
//GEN-LAST:event_btThemActionPerformed


    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {
        /*------------- Developed by: Phan Cong Thang AND Duong Dinh Hiep ---------*/

            class EditWords extends JFrame {


                private JTextField tfWord;

                private JTextField tfEdit;

                private JButton btnAdd;


                public EditWords() {

                    super("Edit Words");

                    setVisible(true);

                    GridBagLayout gbl = new GridBagLayout();

                    GridBagConstraints gbc = new GridBagConstraints();

                    gbc.insets = new Insets(5, 5, 5, 5);

                    gbc.fill = GridBagConstraints.BOTH;


                    tfWord = new JTextField(35);

                    tfEdit = new JTextField(35);

                    btnAdd = new JButton("Edit Word");

                    btnAdd.addActionListener(new ActionListener() {


                        public void actionPerformed(ActionEvent e) {
 
                           if (tfWord.getText().length() > 0 && tfEdit.getText().length() > 0) {

                                try {

                                    File file = new File("word.txt");

                                    BufferedReader reader = new BufferedReader(new FileReader(file));

                                    String line = "", oldtext = "";

                                    while ((line = reader.readLine()) != null) {

                                        oldtext +=  line + "\r\n";
                                    }
 
                                   reader.close();
                                  
                            String newtext = oldtext.replaceAll(tfWord.getText(),tfEdit.getText());


                                    FileWriter writer = new FileWriter("word.txt");

                                    writer.write(newtext + "\r\n");

                                    writer.close();

                                } catch (IOException ex) {

                                    ex.printStackTrace();

                                }

                                tfWord.setText("");

                                tfEdit.setText("");

                                tfWord.requestFocus();


                                JOptionPane.showMessageDialog(EditWords.this, "Added Word Successfully!", "Add Word", JOptionPane.INFORMATION_MESSAGE);

                            }
                            else {

                                JOptionPane.showMessageDialog(EditWords.this, "Please enter word and edit word!", "Add Word", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });


                    Container c = getContentPane();
                    c.setLayout(gbl);


                    // add tfWord
 
                   gbc.anchor = GridBagConstraints.EAST;


                    c.add(
                new JLabel("Enter Word :"), gbc);

                    gbc.anchor = GridBagConstraints.WEST;


                    c.add(tfWord);


                    // add taMeaning
                    gbc.gridx = 0;

                    gbc.anchor = GridBagConstraints.EAST;


                    c.add(
                new JLabel("Enter Edit Word :"), gbc);

                    gbc.anchor = GridBagConstraints.WEST;

                    gbc.gridx = 1;

                    gbc.gridwidth = 2;

                    gbc.gridheight = 2;

                    JScrollPane sp = new JScrollPane(tfEdit, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


                    c.add(sp, gbc);


                    // add button

                    gbc.gridx = 0;

                    gbc.gridwidth = 3;

                    gbc.anchor = GridBagConstraints.CENTER;

                    gbc.fill = GridBagConstraints.NONE;


                    c.add(btnAdd, gbc);

                    pack(); 
 
                }

            }


            EditWords e = new EditWords();

            e.setVisible(true);

    }


    public static void main(String args[]) {

        
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

            java.util.logging.Logger.getLogger(Dictionary.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(Dictionary.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(Dictionary.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(Dictionary.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Dictionary().setVisible(true);
            }

        });

    }

    
// Variables declaration - do not modify
//GEN-BEGIN:variables

    private javax.swing.JButton btDich;

    private javax.swing.JButton btSua;

    private javax.swing.JButton btThem;

    private javax.swing.JComboBox cbKieu;

    private javax.swing.JScrollPane jScrollPane1;

    private javax.swing.JLabel lbDich;

    private javax.swing.JTextArea taMean;

    private javax.swing.JTextField tfNhap;

    // End of variables declaration//GEN-END:variables
}
