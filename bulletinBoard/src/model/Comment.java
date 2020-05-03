package model;

import java.io.Serializable;

public class Comment implements Serializable{
		private String id;
		private String text;
		public Comment() {}
		public Comment(String id,String text) {
			this.id=id;
			this.text=text;
		}

		public String getId() {return this.id;}
		public void setId(String id) {this.id=id;}
		public String getText() {return this.text;}
		public void setText(String text) {this.text=text;}
}
