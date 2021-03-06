/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.awaaz;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author dev
 */
public class Tray extends javax.swing.JFrame {

    /**
     * Creates new form a
     */
    public Tray() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 if (SystemTray.isSupported()) {
            // Yes My System Support System Tray
            System.out.println("System Try Supported");
 
            // Create SystemTray and TrayIcon (TrayIcon : It is icon that
            // display in SystemTray)
            final SystemTray systemTray = SystemTray.getSystemTray();
                PopupMenu popup = new PopupMenu();
 MenuItem action = new MenuItem("Open App");
    action.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new MyAwaaz().show();        }
    });     
    popup.add(action);

    //2nd menuitem of popupmenu
    MenuItem close = new MenuItem("Exit App");
    close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);             
        }
    });
    popup.add(close);
            final TrayIcon trayIcon = new TrayIcon(getImage("app-icon-designer-diabetes-text-2-speach.png"),
                    "My Awaaz - Currenly in Running Phase",popup);
            trayIcon.setImageAutoSize(true);// Autosize icon base on space
                                            // available on
                                            // tray
 
            MouseAdapter mouseAdapter = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("My Awaaz - Currenly in Running Phase");
                    // This will display small popup message from System Tray
                    trayIcon.displayMessage("My Awaaz",
                            "The Ultimate Text To Speech Converter. Currently in Running Phase.",
                            TrayIcon.MessageType.INFO);
                }
            };
 
            trayIcon.addMouseListener(mouseAdapter);
 
            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
 
    }
 
    public static Image getImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage();
    }
 

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
