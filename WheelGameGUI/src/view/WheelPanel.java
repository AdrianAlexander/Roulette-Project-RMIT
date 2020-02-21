package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WheelPanel extends JPanel {
	
	ImageIcon imageIcon;
	Image image;
	JLabel label = new JLabel();
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		imageIcon = new ImageIcon("C:/Users/User/eclipse-workspace/WheelGameGUII/images/Wheel.png");
		image = imageIcon.getImage();
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		
		double imgAspect = (double) height/width;
		
		int cHeight = getHeight();
		int cWidth = getWidth();
		
		double labelAspect = (double) cHeight/cWidth;
		
		int x1 =0;
		int x2 =0;
		int y1=0;
		int y2=0;
		
		if(width<cWidth && height<cHeight) {
			x1 = (cWidth - width)/2;
			y1 = (cHeight- height)/2;
			x2 = width + x1;
			y2 = height + y1;
		}else {
			if(labelAspect > imgAspect) {
				y1 = cHeight;
				cHeight = (int) (cWidth* imgAspect);
				y1 = (y1 - cHeight);
			}else {
				x1 = cWidth;
				cWidth = (int) (cHeight/imgAspect);
				x1 = (x1 - cWidth)/2;
			}
			x2 = cWidth + x1;
			y2 = cHeight + y1;
		}
		g.drawImage(image, x1,y1,x2,y2,0,0,width,height, this);
	}

}
