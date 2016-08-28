package utils;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HttpMethod;

import org.jboss.logging.Logger;

public final class FacesUtils {

    public static final Logger LOG = Logger.getLogger(FacesUtils.class);

    public static void addErrorFacesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public static String getCurrentViewId() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }

    public static boolean isRequestMethodGet() {
        LOG.info("checkRequestMethod().");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String method = request.getMethod();
        if (HttpMethod.GET.equals(method)) {
            LOG.info("checkRequestMethod(): HTTP request method: " + method);
            return true;
        }
        return false;
    }

    public static String extractParameterValueFromRequestMap(String viewParameterName) throws RequestParameterNotFoundException {
        LOG.info("extractParameterValueFromRequestMap().");
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String viewParameterValue = ctx.getRequestParameterMap().get(viewParameterName);
        if (viewParameterValue == null) {
            throw new RequestParameterNotFoundException(viewParameterName);
        }
        return viewParameterValue;
    }
    
    public static <T> T getManagedBean (String beanName, Class<T> clazz) {
    	FacesContext ctx = FacesContext.getCurrentInstance();
    	ELContext elContext = ctx.getELContext();
    	Object value = elContext.getELResolver().getValue(elContext, null, beanName);
    	T bean = clazz.cast(value);
    	return bean;
    }
}
