package main;

public class PrivateMessageEvent {

	private String contenu;
	private Object source;
	
	public PrivateMessageEvent(Object source,String contenu) {
		this.setContenu(contenu);
		this.setSource(source);
	}
	
	
	
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Object getSource() {
		return source;
	}
	public void setSource(Object source) {
		this.source = source;
	}

	
}
