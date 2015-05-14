package gscrot.uploader.imgbi;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class Imgbi {
	
	public static String upload(byte[] b) throws Exception {
		File file = File.createTempFile("imgbiupload", ".dat");

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(b);
		fos.close();
		
		String response = upload(file);
		
		file.delete();
		return response;
	}
	
	public static String upload(BufferedImage image) throws Exception {
		File file = File.createTempFile("imgbiupload", ".png");

		FileOutputStream fos = new FileOutputStream(file);
		ImageIO.write(image, "png", fos);
		fos.close();
		
		String response = upload(file);
		
		file.delete();
		return response;
	}
	
	public static String upload(String file) throws Exception {
		return upload(new File(file));
	}
	
	public static String upload(File file) throws Exception {
		ProcessBuilder pb = new ProcessBuilder(new String[] { "imgbi-client", "-i", file.getAbsolutePath() });
		pb.redirectErrorStream(true);
		Process p = pb.start();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream())); 
		
		String response = "";
		String line;
		
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("https://img.bi/")) {
				response += line + "\n";
			}
		}
		
		reader.close();
		
		return response;
	}
}
