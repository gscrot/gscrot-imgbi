package gscrot.uploader.imgbi;

import iconlib.IconUtils;

import com.redpois0n.gscrot.Capture;
import com.redpois0n.gscrot.CaptureUploader;
import com.redpois0n.gscrot.UploadResponse;

public class ImgbiUploader extends CaptureUploader {
	
	public ImgbiUploader() {
		super("Imgbi", IconUtils.getIcon("imgbi", ImgbiUploader.class));
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
