package nicebank.Hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.AtmServer;

public class ServerHooks {

    private static final int PORT = 9988;

    private AtmServer server;

    @Before
    public void startServer() throws Exception{
        server = new AtmServer(PORT);
        server.start();
    }

    @After
    public void stopServer() throws Exception{
        server.stop();
    }
}
