package dojo.gwt.server;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dojo.gwt.shared.TimeService;

public class TimeServiceImpl extends RemoteServiceServlet implements
		TimeService {

	private static final long serialVersionUID = -816672068202265801L;

	@Override
	public Date getTime() {
		// Simule un traitement long
		waitQuietly(1500);

		return new Date();
	}

	private void waitQuietly(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// Rien ici...
		}
	}

}
