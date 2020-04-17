package Game;

import java.io.*; 


import javax.sound.sampled.*; 
 

public class Play { 



private Clip clip; 
public Play(String filename) { 
    
try { 
     File soundFile = new File(filename); 
     AudioInputStream source = AudioSystem.getAudioInputStream(soundFile); 
     DataLine.Info clipInfo = new DataLine.Info(Clip.class, source.getFormat()); 
     if(AudioSystem.isLineSupported(clipInfo)) { 
      clip = (Clip) AudioSystem.getLine(clipInfo); 
      clip.open(source);      
      } 
   } 
   catch(UnsupportedAudioFileException ex) { 
     ex.printStackTrace();  
   } 
   catch(LineUnavailableException ex) { 
     ex.printStackTrace();  
   } 
   catch(IOException ex) { 
     ex.printStackTrace(); 
   } 
  } 
  public void play() { 
    new Thread() { 
     public void run() { 
       try { 
         if(clip != null) {   
          clip.start(); 
          long waitTime = (long)Math.ceil(clip.getMicrosecondLength()/1000.0);      
          Thread.sleep(waitTime); 
        } 
       }  
       catch(InterruptedException ex) { 
         ex.printStackTrace(); 
       }  
     } 
    }.start(); 
  } 
  public void stop() { 
    if(clip != null) { 
      clip.stop(); 
     clip.setFramePosition(0); 
   }   
  } 
  public void pause() { 
    if(clip != null) { 
     clip.stop(); 
   }   
  } 
}