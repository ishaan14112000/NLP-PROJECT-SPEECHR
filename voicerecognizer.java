package test;

import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class voicerecognizer {

	public static void main(String[] args) throws IOException {
		Configuration configuration= new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("/Users/ishaa/eclipse-workspace/voice recognition/src/resources/3345.dic");
		configuration.setLanguageModelPath("/Users/ishaa/eclipse-workspace/voice recognition/src/resources/3345.lm");

		LiveSpeechRecognizer recognize=new LiveSpeechRecognizer(configuration);
		recognize.startRecognition(true);
		SpeechResult speechResult;
		while((speechResult=recognize.getResult())!=null) {
			
			String command=speechResult.getHypothesis();
			System.out.println("INPUT GIVEN IS:"+command);
			if(command.equalsIgnoreCase("internet")) {
				 try {
					   
					   URI uri= new URI("http://www.google.com");
					   
					   java.awt.Desktop.getDesktop().browse(uri);
					    
					 
					  } catch (Exception e) {
					   
					   e.printStackTrace();
					  }
			}
			
			}
		}
	}


