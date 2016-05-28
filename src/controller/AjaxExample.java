package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;

@ManagedBean
@SessionScoped
public class AjaxExample implements Serializable {

	private static final long serialVersionUID = -877392086919906281L;

	private final static Logger LOG = Logger.getLogger(AjaxExample.class);

	private String text;

	public String getText() {
		LOG.info("getText(): text=" + text);
		return text;
	}

	public void setText(String text) {
		LOG.info("setText(" + text + ")");
		this.text = text;
	}

}
