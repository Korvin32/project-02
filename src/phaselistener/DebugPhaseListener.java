package phaselistener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class DebugPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {
//	    System.out.println("[DebugPhaseListener] After phase: " + event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
//		System.out.println("[DebugPhaseListener] Before phase: " + event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
