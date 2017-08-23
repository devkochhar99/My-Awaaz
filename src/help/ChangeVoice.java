/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import my.awaaz.TextToSpeech;
import my.awaaz.TextToSpeech;

/**
 *
 * @author dev
 */

public class ChangeVoice extends javax.swing.JFrame {
    
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;

    public void TextToSpeechMale(String s) throws EngineException, AudioException, InterruptedException{
    System.setProperty("freetts.voices"//key
    ,"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory"/*value or property*/);   

    //System.setProperty() method sets the system property indicated by the specified key
    //sets freetts.voices property as KevinVoiceDirectory.class
    
   Central.registerEngineCentral
    ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
   
    //Register a speech engine with the Central class for use by the current application.
    //parameter - name of a class that implements the EngineCentral interface and provides access to an engine implementation
    
   //The Central class is the initial access point to all speech input and output capabilities. 
   //Central provides the ability to locate, select and create speech recognizers and speech synthesizers

   Synthesizer  synthesizer =
    Central.createSynthesizer(new SynthesizerModeDesc(Locale.ENGLISH));
   
    //A synthesizer generates sound.
    //synthesizer or speech engines created
   //createSynthesizer() parameter is an EngineModeDesc and may be one of the sub-classes: RecognizerModeDesc or SynthesizerModeDesc
   //Locale.English - mode descriptor which defines a set of properties for an engine
   
   synthesizer.allocate();  //getting synthesizer ready to speak
   synthesizer.resume();
   synthesizer.speakPlainText(s, null);//speak a plain text string
  // synthesizer.speak("Bye!! And Please give us chance to serve you soon!!",null);
   synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY/*specified state*/);// wait till speaking is done 
   synthesizer.deallocate();//release resourses
    }
    
    public void TextToSpeechFemale(String s){
    try (TextToSpeech.TTS tts = new TextToSpeech.TTS()) {
            tts.speak(s);
         } catch (MaryConfigurationException | IOException | SynthesisException | LineUnavailableException | InterruptedException e) {
            System.err.println("MaryTTS doesn't seem to work on this machine.");
        }
    }
    
    public ChangeVoice() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("Male Voice (Default)");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("Female Voice");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Change Voice");

        jButton1.setText("Submit");
        
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TextToSpeechMale("You selected male voice");
                } catch (EngineException ex) {
                    Logger.getLogger(ChangeVoice.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AudioException ex) {
                    Logger.getLogger(ChangeVoice.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChangeVoice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextToSpeechFemale("You selected female voice");
            }
        });
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(152, 152, 152))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.hide();        // TODO add your handling code here:
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ChangeVoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeVoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeVoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeVoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeVoice().setVisible(true);
            }
        });
    }
    
    
}
