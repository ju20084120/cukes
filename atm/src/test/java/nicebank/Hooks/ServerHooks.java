package nicebank.Hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.AtmServer;
import nicebank.KnowsTheDomain;

public class ServerHooks {

    private static final int PORT = 9988;
    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(KnowsTheDomain helper){
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception{
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void stopServer() throws Exception{
        server.stop();
    }
}
