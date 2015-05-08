package gscrot.uploader.imgbi;

import iconlib.IconUtils;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

public class Uploader extends CaptureUploader {
	
	public Uploader() {
		super("Imgbi", IconUtils.getIcon("imgbi", Uploader.class));
	}

	@Override
	public UploadResponse process(Capture capture) throws Exception {
		String response = Imgbi.upload(capture.getBinary());
		
		if (response.startsWith("ERROR: ")) {
			throw new Exception(response);
		} else {
			String[] split = response.split("\n");
			String url = split[0];
			String rmurl = split[1];
			
			return new UploadResponse(url, rmurl);
		}
	}

}
