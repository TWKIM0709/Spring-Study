package kr.or.kosa;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask{
	private String email;
	
	public TestTimerTask() {
		super();
	}

	public TestTimerTask(String email) {
		this.email = email;
	}

	@Override
	public void run() {
		EmailCodeMap.removeMap(email);
	}
}
