package gscrot.uploader.imgbi;

import gscrot.api.Plugin;

import com.redpois0n.gscrot.CaptureUploader;

public class ImgbiPlugin extends Plugin {

	public ImgbiPlugin() {
		super("Imgbi");
		CaptureUploader.addUploader(new ImgbiUploader());
	}

}
