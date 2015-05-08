package gscrot.uploader.imgbi;

import iconlib.IconUtils;

import java.awt.image.BufferedImage;

import com.redpois0n.gscrot.CaptureUploader;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Imgbi", IconUtils.getIcon("imgbi", Uploader.class));
	}

	@Override
	public void process(BufferedImage image) {
		try {
			System.out.println(Imgbi.upload(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
