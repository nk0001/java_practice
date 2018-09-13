package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private String name;
	private String text;

	public Mutter() {}

	public Mutter(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

}
