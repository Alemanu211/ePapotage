package main;

public class PapotageEvent {
	
	private String theme;
	private String corps;
	
	public PapotageEvent (Object source, String theme, String corps ) {
		this.setTheme(theme);
		this.setCorps(corps);
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}
	
	
}
