package phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DebugPhaseListener.class);

	public void afterPhase(PhaseEvent event) {
//	    LOG.info("[DebugPhaseListener] After phase: " + event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
//		LOG.info("[DebugPhaseListener] Before phase: " + event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
