package autotradingsim.ui;
import autotradingsim.application.TradingApplication;
import autotradingsim.engine.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author Bill Feng
 */
public class ExperimentList extends javax.swing.JFrame {

    /**
     * Creates new form Experiment
     */
    AutomatedTradingSimulator parent;
    DefaultListModel experimentListModel = new DefaultListModel();
    TradingApplication application = TradingApplication.getInstance();
    ExperimentEngine experimentengine = ExperimentEngine.getInstance();

    public ExperimentList(AutomatedTradingSimulator parent) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth() / 2 - this.getWidth() / 2,
                parent.getY() + parent.getHeight() / 2 - this.getHeight() / 2);
        experimentList.setModel(experimentListModel);
        loadExperiments(experimentListModel);

    }
    //loads filenames of experiments into the list model
    private void loadExperiments(DefaultListModel experimentListModel){
        for(String n: application.getAvailableExperiments()){
            experimentListModel.addElement(n);
        }
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
        experimentList = new javax.swing.JList();
        create = new javax.swing.JButton();
        open = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experiment List");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        experimentList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        experimentList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(experimentList);

        create.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        create.setLabel("Create");
        create.setPreferredSize(new java.awt.Dimension(200, 50));
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        open.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        open.setText("Open");
        open.setPreferredSize(new java.awt.Dimension(200, 50));
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        delete.setText("Delete");
        delete.setPreferredSize(new java.awt.Dimension(200, 50));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(200, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(open, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(create, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                    .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void createActionPerformed(java.awt.event.ActionEvent evt) {                                       
        dialogInput di = new dialogInput(this, true);
        String name = di.run();
        if(name.length() > 0 && !experimentListModel.contains(name)){
            application.addExperiment(experimentengine.createExperiment(name));
            experimentListModel.addElement(name);
            ExperimentViewer ev = new ExperimentViewer(this,application.getExperiment(name));
            ev.setNameText(name);
            ev.setExperiment(application.getExperiment(name));
            ev.setStrategyList();
            ev.setStockList();
            this.setVisible(false);
            ev.setVisible(true);
            
        }
    }                                        

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        if(experimentList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to open!");
            dm.setVisible(true);
        }else{

            String name=experimentListModel.getElementAt(experimentList.getSelectedIndex()).toString();
            ExperimentViewer ev = new ExperimentViewer(this, application.getExperiment(name));
            ev.setNameText(name);
            ev.setExperiment(application.getExperiment(name));
            ev.setStrategyList();
            ev.setStockList();
            this.setVisible(false);
            ev.setVisible(true);
        }
    }//GEN-LAST:event_openActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(experimentList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to delete!");
            dm.setVisible(true);
        }else{
            dialogConfirm dc = new dialogConfirm(this, true);
            boolean delete = dc.run();
            if(delete){
                String expname = experimentListModel.getElementAt(experimentList.getSelectedIndex()).toString();
                experimentListModel.removeElementAt(experimentList.getSelectedIndex());
                application.delExperiment(expname);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JList experimentList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton open;
    // End of variables declaration//GEN-END:variables
}
