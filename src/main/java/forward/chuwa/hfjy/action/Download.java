package forward.chuwa.hfjy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/")
@Action("download")
@Results({ @Result(name = "input", type = "stream", params = { "contentType",
		"contentType", "inputName", "stream", "bufferSize", "1024",
		"contentDisposition", "c=\"${c}\"" }) })
public class Download extends BaseAction {
	private static final long serialVersionUID = 1L;

	private InputStream stream;

	private String c;

	public String execute() throws FileNotFoundException {
		stream = new FileInputStream(getRealPath("images/img/tag1.png"));
		if (!StringUtils.isEmpty(c)) {
			File flie = new File(getRealPath("files/" + c));
			if(flie.exists()){
				stream = new FileInputStream(getRealPath("files/" + c));
			}
		}
		return INPUT;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
}
