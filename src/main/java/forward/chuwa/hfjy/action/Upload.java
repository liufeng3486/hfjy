package forward.chuwa.hfjy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
public class Upload extends BaseAction {
	private static final long serialVersionUID = 1L;
	private File file;
	
	@Action(value = "upload")
	public void upload() {
		String name = UUID.randomUUID().toString();
		String path = "files/" + name;
		try {
			FileUtils.copyFile(file, new File(getRealPath(path)));
			writeJson(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


}
