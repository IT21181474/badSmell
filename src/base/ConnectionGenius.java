package base;

import java.net.InetAddress;

/**
 * Manages the connection for a game.
 * 
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */
public class ConnectionGenius {

    private InetAddress ipAddress;

    public ConnectionGenius(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void fireUpGame() {
        downloadWebVersion();
        connectToWebService();
        awayWeGo();
    }

    public void downloadWebVersion() {
        WebVersionDownloader downloader = new WebVersionDownloader();
        downloader.download();
    }

    public void connectToWebService() {
        WebServiceConnector connector = new WebServiceConnector();
        connector.connect();
    }

    private void awayWeGo() {
        System.out.println("Ready to play");
    }

    // Inner class to handle downloading web version
    private class WebVersionDownloader {
        public void download() {
            System.out.println("Getting specialized web version.");
            System.out.println("Wait a couple of moments");
        }
    }

    // Inner class to handle connecting to web service
    private class WebServiceConnector {
        public void connect() {
            System.out.println("Connecting");
        }
    }
}
