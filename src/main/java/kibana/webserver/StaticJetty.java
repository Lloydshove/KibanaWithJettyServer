package kibana.webserver;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;


public class StaticJetty {

    public static void main(String[] args) throws Exception{
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[] { "index.html" });
        resource_handler.setResourceBase("./static/");


        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler });
        server.setHandler(handlers);


        server.start();
        server.join();

    }

}
