package Datos;


import javax.sound.sampled.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class EntidadSonora {
    private Clip backgroundClip;
    private Map<String, Clip> efectosDeSonido;

    public EntidadSonora() {
        efectosDeSonido = new HashMap<>();
            cargarSonido("salto", "/Datos/sonidos/mario-bros-jump.wav");
            cargarSonido("vida", "/Datos/sonidos/mario-bros-vida.wav");
            cargarSonido("moneda", "/Datos/sonidos/mario-coin.wav");
            cargarSonido("victoria", "/Datos/sonidos/mario-win.wav");
            cargarSonido("powerup", "/Datos/sonidos/mario-power-up.wav");
            cargarSonido("muerte",  "/Datos/sonidos/muerte.wav" );
            cargarSonido("bola","/Datos/sonidos/bola-de-fuego.wav");
            
    }

    private void cargarSonido(String nombre,String ruta){
       
        try{
            Clip clip = AudioSystem.getClip();    
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(ruta));
            clip.open(audioInputStream);
            efectosDeSonido.put(nombre, clip);
            
        }catch(IOException | UnsupportedAudioFileException | LineUnavailableException e){
            e.printStackTrace();

            
        }
            

    }
    public void iniciarLoopMario(){
        try{
            if(backgroundClip != null)
                detenerLoopEstrella();
            
            backgroundClip = AudioSystem.getClip();
            AudioInputStream ringtoneStream = AudioSystem.getAudioInputStream(
                getClass().getResource("/Datos/sonidos/ringtones-super-mario-bros.wav"));
            backgroundClip.open(ringtoneStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();
        }catch(IOException | UnsupportedAudioFileException | LineUnavailableException e){
            e.printStackTrace();
            }
    }

    public void detenerLoopMario(){
        backgroundClip.stop();
    }

    public void reproducirSonido(String nombre) {
        Clip clip = efectosDeSonido.get(nombre);

        switch(nombre){
            case "muerte":{
                detenerLoopMario();
                clip.setFramePosition(0);
                clip.start();
                break;
            }
            case "estrella": {
                detenerLoopMario();
                iniciarLoopEstrella();
                break;
            } 
            
            case "victoria": {
                detenerLoopMario();
                clip.setFramePosition(0);
                clip.start();
                break;
            }
            
            default:{
            clip.setFramePosition(0); 
            clip.start(); 
            break;
            }
        }
    }

    private void iniciarLoopEstrella(){
        try{
            backgroundClip = AudioSystem.getClip();
            AudioInputStream ringtoneStream = AudioSystem.getAudioInputStream(
                getClass().getResource("/Datos/sonidos/mario-bros-estrella.wav"));
            backgroundClip.open(ringtoneStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();
        }catch(IOException | UnsupportedAudioFileException | LineUnavailableException e){
            e.printStackTrace();
            }
    }

    private void detenerLoopEstrella(){
        backgroundClip.stop();//DEBERIA DETENERSE AL FINALIZAR EL EFECTO DE LA ESTRELLA
    }

}


