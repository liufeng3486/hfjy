package forward.chuwa.hfjy.utility;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ConditionBuilder {
	private StringBuilder sb = new StringBuilder();

	private StringBuilder sbWith = new StringBuilder();

	private List<Object> params = new ArrayList<>();

	public void appendWith(String condition) {
		sbWith.append(condition);
	}

	public void appendWith(String condition, Object param) {
		params.add(param);
		sbWith.append(MessageFormat.format(condition, ":p" + params.size()));
	}

	public void append(String condition) {
		sb.append(condition);
	}

	public void append(String condition, Object param) {
		params.add(param);
		sb.append(MessageFormat.format(condition, ":p" + params.size()));
	}

	public String getCondition() {
		return sb.toString();
	}

	public String getWith() {
		return sbWith.toString();
	}

	public List<Object> getParams() {
		return params;
	}
}
