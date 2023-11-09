//package model;
//
//import java.util.LinkedList;
//
//import javax.swing.JLabel;
//
//public class Evidence {
//	private LinkedList<String> texts;
//	private LinkedList<byte[]> images;
//	private int textSize = 0;
//	
//	public LinkedList<String> getTexts() {
//		return texts;
//	}
//	public void setTexts(LinkedList<String> texts) {
//		this.texts = texts;
//	}
//	public LinkedList<byte[]> getImages() {
//		return images;
//	}
//	public void setImages(LinkedList<byte[]> images) {
//		this.images = images;
//	}
//	private void addText(String text) {
//		texts.add(text);
//	}
//	private void addImage(byte[]image) {
//		images.add(image);
//	}
//	public Evidence() {
//		texts = new LinkedList<String>();
//		images = new LinkedList<byte[]>();
//	}
//	public int getTextSize() {
//		return textSize;
//	}
//	public void setTextSize(int textSize) {
//		this.textSize = textSize;
//	}
//	public JLabel generateLabel() {
//		JLabel returnLabel = new JLabel ("Label" + textSize);
//		textSize = textSize +1;
//		return returnLabel;
//	}
//	
//	
//	
//	
//	
//	
//}
