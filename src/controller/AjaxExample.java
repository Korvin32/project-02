package controller;

import java.io.Serializable;

import org.jboss.logging.Logger;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.SessionScoped
@javax.inject.Named
@javax.enterprise.context.SessionScoped
public class AjaxExample implements Serializable {

	private static final long serialVersionUID = 1L;

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
