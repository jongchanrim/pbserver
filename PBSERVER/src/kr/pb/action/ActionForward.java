package kr.pb.action;

public class ActionForward {
	private String nextURL; //��� URL�� �̵����� �����־����. URL�� ������ �̵������ �����Ϸ� �Ѵ�.
	private boolean isForward;//true�� Forward������� �̵��ϰ�,false�� Redirect ������� �Ѵ�. boolean�� isForward�� �Ѱ��ָ� �ȴ�.
	//getter�� setter�޼ҵ�� source �޴��� ���� �����ϸ� �ڵ����� ���������.
	public String getNextURL() {
		return nextURL;
	}
	public void setNextURL(String nextURL) {
		this.nextURL = nextURL;
	}
	public boolean isForward() {
		return isForward;
	}
	public void setForward(boolean isForward) {
		this.isForward = isForward;
	}
	

}
