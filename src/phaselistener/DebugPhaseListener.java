package phaselistener;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DebugPhaseListener.class);

	public void afterPhase(PhaseEvent event) {
	    LOG.info("--> afterPhase(): event.getPhaseId()=" + event.getPhaseId());
	    extractAndLogFacesMessages();
	}

    public void beforePhase(PhaseEvent event) {
		LOG.info("--> beforePhase(): event.getPhaseId()=" + event.getPhaseId());
		extractAndLogFacesMessages();
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	private void extractAndLogFacesMessages() {
	    List<FacesMessage> messageList = FacesContext.getCurrentInstance().getMessageList();
	    int size = messageList.size();
	    if (size > 0) {
	        for (FacesMessage message : messageList) {
	            Severity severity = message.getSeverity();
	            String summary = message.getSummary();
	            String detail = message.getDetail();
	            LOG.info(String.format("--- extractAndLogFacesMessages(). FacesMessage: [%s] %s. Detail: %s", severity, summary, detail));
	        }
	    }
	}
	
}
