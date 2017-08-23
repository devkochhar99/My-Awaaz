package my.awaaz;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Scanner;

import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import java.io.Closeable;
import java.io.IOException;


public class TextToSpeech{
    
    public static class TTS implements Closeable {  //for female voice using Mary TTS(Text To Speech)

        private final LocalMaryInterface mary;

        public TTS() throws MaryConfigurationException {
            mary = new LocalMaryInterface();
          // mary.setAudioEffects("F0Scale(f0Scale:0.0)+Robot(amount:75.0)+Whisper(amount:35)");
        }

        public TTS speak(String text) throws SynthesisException, LineUnavailableException, IOException, InterruptedException {
            AudioInputStream audioInputStream = mary.generateAudio(text);
            AudioPlayer player = new AudioPlayer(audioInputStream, event -> {
            });
            player.start(); //audio player started
            while (player.isAlive()) {
                Thread.sleep(100);  //sleep main thread for 100 msec
            }
            return this;
        }

        @Override
        public void close() throws IOException {
        }
    }
        
    public static void main(String [] args){

 }
    }