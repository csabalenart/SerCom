/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.irt.scom;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Csaba Lénárt
 */
public class MainForm extends javax.swing.JFrame implements SerialPortDataListener{
    private final LogWin log=new LogWin(this,false);
    public final AtomicBoolean connected=new AtomicBoolean(false);
    private final CustomByte cf = new CustomByte(this);
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        fillComportList();
        setConnected(false);
        DefaultCaret caret = (DefaultCaret)console.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    
    SerialPort comPort;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        send26 = new javax.swing.JButton();
        sendcustom = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comList = new javax.swing.JComboBox<>();
        baudrate = new javax.swing.JComboBox<>();
        extracrlf = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        conScroll = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        command = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IRT SerCom");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Main operations"));

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Log");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Clear console");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        send26.setText("Send #26");
        send26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send26ActionPerformed(evt);
            }
        });

        sendcustom.setText("Send Custom byteCode");
        sendcustom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendcustomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disconnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendcustom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
            .addComponent(disconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(send26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sendcustom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Comport settings"));

        comList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comListActionPerformed(evt);
            }
        });

        baudrate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "110", "300", "600", "1200", "2400", "4800", "9600", "14400", "19200", "38400", "57600", "115200", "128000", "256000" }));
        baudrate.setSelectedIndex(6);

        extracrlf.setSelected(true);
        extracrlf.setText("Add EXTRA cr+lf");

        jLabel1.setText("ComPort:");

        jLabel2.setText("BaudRate:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(baudrate, 0, 183, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(extracrlf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baudrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(extracrlf))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Console"));

        console.setEditable(false);
        console.setColumns(20);
        console.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        console.setRows(5);
        conScroll.setViewportView(console);

        command.setText("AT");
        command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandActionPerformed(evt);
            }
        });

        sendButton.setText("send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(command)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(conScroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comListActionPerformed

    /**
     * 
     * @return visszaadja a kiválasztott COM port példányt
     * @throws RuntimeException ha nincs kiválasztva com port, vagy, ha
     * nem létezik a kiválasztott port.
     */
    public SerialPort getSelectedComPort(){
	String comname=comList.getSelectedItem()==null?null:comList.getSelectedItem().toString();
	if(comname==null){
	    throw new RuntimeException("No Com port selected");
	}
	SerialPort port = SerialPort.getCommPort(comname);
	if(port==null){
	    throw new RuntimeException("The selected com port ("+comname+") does not exist");
	}
	return port;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        log.setVisible(!log.isVisible());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
	    comPort = getSelectedComPort();
            comPort.setBaudRate(Integer.parseInt(baudrate.getSelectedItem().toString()));
            comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            comPort.addDataListener(this);
            setConnected(comPort.openPort(2000));
	} catch (Exception ex) {
	    showMessage(ex.getMessage(), true);
            setConnected(false);
	}
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        setConnected(false);
        if(this.comPort!=null) {
            log.logInfo("Disconnected: "+comPort.closePort());
            
        }
        
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("EXITING and closing port (if open)...");
        connected.set(false);
        if(comPort!=null) comPort.closePort();
    }//GEN-LAST:event_formWindowClosing

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if(comPort!=null){
            try {
                String toAdd=""+(char)13+(char)10;
                String toSend=command.getText()+(extracrlf.isSelected()?toAdd:"");
                /*byte[] toSend=(command.getText()+toAdd).getBytes();
                this.comPort.writeBytes(toSend, toSend.length);*/
                PrintWriter pw = new PrintWriter(comPort.getOutputStream());
                pw.println(toSend);
                pw.flush();
                log.logInfo("Command "+toSend+" sent");
            } catch (Exception ex) {
                log.logException("Error sending command", ex);
            }
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void commandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandActionPerformed
        this.sendButtonActionPerformed(evt);
    }//GEN-LAST:event_commandActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        console.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public void sendData(String toSend){
        if(comPort!=null || toSend==null){
            try {
                PrintWriter pw = new PrintWriter(comPort.getOutputStream());
                pw.println(toSend);
                pw.flush();
                log.logInfo("Custom byte stream sent: "+getByteForm(toSend));
            } catch (Exception ex) {
                log.logException("Error sending #26", ex);
            }
        }
    }
    
    public void logError(String err){
        this.log.logError(err);
    }
    
    private String getByteForm(String what){
        if(what==null) return null;
        String res="";
        for(byte b:what.getBytes()){
            res+=(res.isEmpty()?"":", ")+b;
        }
        return res;
    }
    
    private void send26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send26ActionPerformed
        sendData(""+(char)26);
    }//GEN-LAST:event_send26ActionPerformed

    private void sendcustomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendcustomActionPerformed
        this.cf.setVisible(true);
    }//GEN-LAST:event_sendcustomActionPerformed

    public final void setConnected(boolean conn){
        if(conn==false){
            System.err.println("Called with FALSE");
            cf.setVisible(false);
        } else {
            log.logInfo("Connected to com port");
        }
        this.sendcustom.setEnabled(conn);
        this.connectButton.setEnabled(!conn);
        this.disconnectButton.setEnabled(conn);
        this.sendButton.setEnabled(conn);
        this.command.setEnabled(conn);
        this.send26.setEnabled(conn);
        connected.set(conn);
    }
    public static void showMessage(String message,boolean isError){
	JOptionPane.showMessageDialog(null, message, isError?"Error":"Information", isError?JOptionPane.ERROR_MESSAGE:JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void fillComportList(){
        try{
            List<String> ports = new ArrayList<>();
            for(SerialPort sp:SerialPort.getCommPorts()){
                ports.add(sp.getSystemPortName());
            }
            Collections.sort(ports);
            comList.setModel(new javax.swing.DefaultComboBoxModel<>(ports.toArray(new String[0])));
        }catch(Exception ex){
            log.logError("Error getting comport list: "+ ex.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> baudrate;
    private javax.swing.JComboBox<String> comList;
    private javax.swing.JTextField command;
    private javax.swing.JScrollPane conScroll;
    private javax.swing.JButton connectButton;
    private javax.swing.JTextArea console;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JCheckBox extracrlf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton send26;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton sendcustom;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent evt) {
        String data=new String(evt.getReceivedData());
        if(data==null || data.trim().isEmpty())return;
        console.append(data.trim()+"\n");
    }
}
