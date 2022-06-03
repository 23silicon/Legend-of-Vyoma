package main_classes;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMusic 
{
	private static Clip clip;
	private static File file;
	private static AudioInputStream audio;
	
	public PlayMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		file = new File("Music/You Belong with me 2022-05-31 18_18_31.wav");
		audio= AudioSystem.getAudioInputStream(file);
		
		clip=AudioSystem.getClip();
		clip.open(audio);
	}
	
	public void startMusic()
	{
		clip.start();
//		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void switchMusic(int frame)throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		clip.close();
		switch(frame)
		{
		case 1:
			file = new File("Music/Picture to Burn 2022-05-31 18_18_41.wav");
			audio= AudioSystem.getAudioInputStream(file);
			
			clip=AudioSystem.getClip();
			clip.open(audio);
		case 2:
			file = new File("Music/Our song 2022-05-31 18_18_56 (1).wav");
			audio= AudioSystem.getAudioInputStream(file);
			
			clip=AudioSystem.getClip();
			clip.open(audio);
		case 3:
			file = new File("Music/LWYMMD 2022-05-31 18_18_46.wav");
			audio= AudioSystem.getAudioInputStream(file);
			
			clip=AudioSystem.getClip();
			clip.open(audio);
		case 4:
			file = new File("Music/Bad Blood 2022-05-31 18_18_21.wav");
			audio= AudioSystem.getAudioInputStream(file);
			
			clip=AudioSystem.getClip();
			clip.open(audio);
		case 5:
			file = new File("Music/Shake it off 2022-05-31 18_19_06.wav");
			audio= AudioSystem.getAudioInputStream(file);
			
			clip=AudioSystem.getClip();
			clip.open(audio);
		}
	
		clip.start();
		
	}
}

