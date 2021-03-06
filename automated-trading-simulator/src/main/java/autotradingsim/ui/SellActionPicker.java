package autotradingsim.ui;

import autotradingsim.util.Pair;

/**
 *
 * @author Bill Feng
 */
public class SellActionPicker extends javax.swing.JDialog {

    /**
     * Creates new form ActionPicker
     */
    String actionName;
    public SellActionPicker(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth()/2 - this.getWidth()/2, 
                         parent.getY() + parent.getHeight()/2 - this.getHeight()/2);
        this.actionName = "";
        amount.setText("0.0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sell = new javax.swing.JLabel();
        numShares = new javax.swing.JRadioButton();
        percentShares = new javax.swing.JRadioButton();
        worthAmountShares = new javax.swing.JRadioButton();
        amount = new javax.swing.JTextField();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Action");
        setResizable(false);

        Sell.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Sell.setText("Sell");

        numShares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numShares.setText("Fixed Quantity");

        percentShares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        percentShares.setText("% of share balance");

        worthAmountShares.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        worthAmountShares.setText("Sell shares worth X amount");

        submit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(Sell))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numShares)
                                .addGap(76, 76, 76)
                                .addComponent(percentShares)
                                .addGap(48, 48, 48)
                                .addComponent(worthAmountShares))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Sell)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numShares)
                    .addComponent(percentShares)
                    .addComponent(worthAmountShares))
                .addGap(21, 21, 21)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_submitActionPerformed
    public static boolean isNumeric(String str)
    {
        return str.matches("[+-]?\\d*(\\.\\d+)?");
    }
    public Pair run(){
        this.setVisible(true);
        if(isNumeric(amount.getText())){
            return new Pair("buy", Integer.valueOf(amount.getText()));
        }else{
            throw new IllegalArgumentException("Did not enter a number in amount field");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Sell;
    private javax.swing.JTextField amount;
    private javax.swing.JRadioButton numShares;
    private javax.swing.JRadioButton percentShares;
    private javax.swing.JButton submit;
    private javax.swing.JRadioButton worthAmountShares;
    // End of variables declaration//GEN-END:variables
}
