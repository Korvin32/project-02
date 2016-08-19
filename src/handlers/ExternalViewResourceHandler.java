package handlers;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.application.ViewResource;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.ExternalViewResourceProvider;

public class ExternalViewResourceHandler extends ResourceHandlerWrapper {

    private static final Logger LOG = LoggerFactory.getLogger(ExternalViewResourceHandler.class.getName());
    
    private ResourceHandler wrapped;

    public ExternalViewResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ViewResource createViewResource(FacesContext context, String resourceName) {
        LOG.info(String.format("createViewResource(%s)", resourceName));
        ViewResource resource = super.createViewResource(context, resourceName);
        if (resource == null) {
            resource = new ViewResource() {
                
                @Override
                public URL getURL() {
                    try {
                        return ExternalViewResourceProvider.getUrl(resourceName);
                    } catch (MalformedURLException e) {
                        // TODO - make it property!!!
                        e.printStackTrace();
                    }
                    return null;
                }
            };
        }
        
        return resource;
    }
    
    @Override
    public ResourceHandler getWrapped() {
        return this.wrapped;
    }

}
