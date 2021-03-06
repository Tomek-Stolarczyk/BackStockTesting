package autotradingsim.ui;
import autotradingsim.application.*;
import autotradingsim.stocks.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;

/**
 *
 * @author Bill Feng
 */
public class StockViewer extends javax.swing.JFrame {

    /**
     * Creates new form StockViewer
     */
    public StockViewer() {
        initComponents();
    }

    StockList parent;
    DefaultTableModel stockTableModel = new DefaultTableModel();
    TradingApplication application = TradingApplication.getInstance();
    Object[] columnIdentifiers = {"Date", "Open", "High", "Low", "Close", "Volume"};
    public StockViewer(StockList parent) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth() / 2 - this.getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - this.getHeight() / 2);
        stockTable.setModel(stockTableModel);
        //Object[][] dataVector = {{"11/12", 1.1,2.1,3.1,4.1,5.1},{"11/13", 1.2,2.2,3.2,4.2,5.2}};
        // Object[] columnIdentifiers = {"Date", "Open", "High", "Low", "Close", "Volume"};
        //stockTableModel.setDataVector(dataVector, columnIdentifiers);
    }

    protected void setNameText(String symbol) {
        stockName.setText(symbol);
    }

    /**
     * construct dataVector by getting stockday information with stock symbol
     * set stockviewer to display all stockdays for that stock
     * @param name
     * @throws java.text.ParseException
     */
    protected void setDataVectors(String name) { //currently only displays startday data
        IStock currStock = application.getStock(name);
        Object[] stockdays = currStock.getAllStockDays().toArray();
        Object[][] dataVector = new Object[stockdays.length][];
        for (int i=0; i<stockdays.length; i++) {
            StockDay stockday = (StockDay) stockdays[i];
            dataVector[i] = new Object[]{currStock.getStartDate().minusDays(i), stockday.getValue(StockDay.Values.OPEN), stockday.getValue(StockDay.Values.CLOSE), stockday.getValue(StockDay.Values.HIGH), stockday.getValue(StockDay.Values.LOW), stockday.getVolume()};
        }
        stockTableModel.setDataVector(dataVector, columnIdentifiers);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stockName = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock Viewer");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        stockName.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        stockName.setText("AAPL (Apple Inc.)");

        Back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        Back.setText("Back");
        Back.setPreferredSize(new java.awt.Dimension(200, 50));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(stockTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                                        .addComponent(stockName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(stockName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.setVisible(false);
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel stockName;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
