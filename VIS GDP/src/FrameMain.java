
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import geomerative.RPoint;
import processing.core.PApplet;

public class FrameMain extends JFrame implements ActionListener, ChangeListener{
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel rightPanel2 = new JPanel();
	JButton button1 = new JButton("GDP");
	JButton button2 = new JButton("第一产业");
	JButton button3 = new JButton("第二产业");
	JButton button4 = new JButton("第三产业");
	JButton button5 = new JButton("金融");
	JButton button6 = new JButton("房地产");
	JSlider yearSlider = new JSlider(JSlider.HORIZONTAL,Data.startYear,Data.startYear+Data.yearCount,Data.startYear);
	PappletChinaMap chinaBarMap = new PappletChinaMap();
	PappletBarMap chinaBarMap2 = new PappletBarMap();
	PappletMap chinaMap = new PappletMap();
	public FrameMain() {
		setSize(1920, 1080);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		yearSlider.setMajorTickSpacing(5);
		yearSlider.setMinorTickSpacing(1);
		yearSlider.setPaintTicks(true);
		yearSlider.setPaintLabels(true);
		yearSlider.setBounds(300,620,300,50);
		
		leftPanel.setBackground(Color.white);
		leftPanel.setBounds(50, 50, 850, 550);
		rightPanel.setBackground(Color.white);
		rightPanel.setBounds(950, 10, 450, 400);
		rightPanel2.setBackground(Color.white);
		rightPanel2.setBounds(950, 420, 400, 300);
		
		button1.setBounds(150, 15, 90, 25);button1.addActionListener(this);
		button2.setBounds(250, 15, 90, 25);button2.addActionListener(this);
		button3.setBounds(350, 15, 90, 25);button3.addActionListener(this);
		button4.setBounds(450, 15, 90, 25);button4.addActionListener(this);
		button5.setBounds(550, 15, 90, 25);button5.addActionListener(this);
		button6.setBounds(650, 15, 90, 25);button6.addActionListener(this);
		
		chinaBarMap.setPreferredSize(new Dimension(800,500));
		chinaBarMap.init();chinaBarMap.start();
		chinaBarMap2.setPreferredSize(new Dimension(400,400));
		chinaBarMap2.init();chinaBarMap2.start();
		chinaMap.setPreferredSize(new Dimension(400,400));
		chinaMap.init();chinaMap.start();
		
		leftPanel.add(chinaBarMap);rightPanel.add(chinaMap);rightPanel2.add(chinaBarMap2);
		yearSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int year = Math.abs(yearSlider.getValue()-1980);
				if(year>=0&&year<20)
				Data.index = year;
			}
		});
		add(leftPanel);add(rightPanel);add(rightPanel2);add(button1);add(button2);add(button3);add(button4);add(button5);add(button6);
		add(yearSlider);
		setVisible(true);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		data.init("CRE_Gdp01.csv");
		FrameMain frameMain = new FrameMain();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		String name = button.getLabel();
		if(name.equals("GDP")) {
			if(Data.buttonFlag[0]==false) Data.buttonFlag[0]=true;
			else Data.buttonFlag[0]=false;
		}
		else if(name.equals("第一产业")) {
			if(Data.buttonFlag[1]==false) Data.buttonFlag[1]=true;
			else Data.buttonFlag[1]=false;
		}
		else if(name.equals("第二产业")) {
			if(Data.buttonFlag[2]==false) Data.buttonFlag[2]=true;
			else Data.buttonFlag[2]=false;
		}
		else if(name.equals("第三产业")) {
			if(Data.buttonFlag[3]==false) Data.buttonFlag[3]=true;
			else Data.buttonFlag[3]=false;
		}
		else if(name.equals("金融")) {
			if(Data.buttonFlag[4]==false) Data.buttonFlag[4]=true;
			else Data.buttonFlag[4]=false;
		}
		else if(name.equals("房地产")) {
			if(Data.buttonFlag[5]==false) Data.buttonFlag[5]=true;
			else Data.buttonFlag[5]=false;
		}
	}
}
