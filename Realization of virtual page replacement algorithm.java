import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import java.util.Random;

import javax.swing.*;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

public class Xnym extends JFrame implements ActionListener
{
	
	JRadioButton BO = new JRadioButton("OPT");
	JRadioButton BF = new JRadioButton("FIFO");
	JRadioButton BL = new JRadioButton("LRU");

	
	
	ButtonGroup group0 = new ButtonGroup();
	ButtonGroup group1 = new ButtonGroup();
	JRadioButton SJ = new JRadioButton("随机");
	JRadioButton SD = new JRadioButton("手动");
	
	Label labelBT = new Label("XNYMZHSF",Label.CENTER);
	Label labelYM = new Label("YMFWCX",Label.CENTER);
	Label labelNC = new Label("NCKS",Label.CENTER);
	Label labelQY = new Label("SFQY",Label.CENTER);
	Label labelQYS = new Label("QYS",Label.CENTER);
	JTextField QYS = new JTextField();
	
	
	JTextField[] t = new JTextField[50];
	public Xnym()
	{
		super("虚拟页面置换算法");
		final JPanel panel0 = new JPanel(new GridLayout(2,1,3,3));
		final JPanel panel1 = new JPanel(new BorderLayout());
		final JPanel panel2 = new JPanel(new GridLayout(1,7,2,2));
		final JPanel panel3 = new JPanel(new GridLayout(3,1,2,2));
		final JPanel panel4 = new JPanel(new GridLayout(5,10));
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel0,panel1);
		this.add(split);
		
		group0.add(BO);
		group0.add(BF);
		group0.add(BL);
		
		group1.add(SJ);
		group1.add(SD);
		
		
		panel0.add(labelBT);
		panel0.add(panel2);
		
		panel1.add(panel3, BorderLayout.WEST);
		panel1.add(panel4);
		
		
		panel2.add(BO);BO.addActionListener(this);
		panel2.add(BF);BF.addActionListener(this);
		panel2.add(BL);BL.addActionListener(this);
		panel2.add(SJ);SJ.addActionListener(this);
		panel2.add(SD);SD.addActionListener(this);
		panel2.add(labelQYS);
		panel2.add(QYS);QYS.setEditable(false);
		
		panel3.add(labelYM);
	
		panel3.add(labelNC);

		panel3.add(labelQY);
		
		
		Font font0 = new Font("宋体",0,28);
		Font font1 = new Font("宋体",0,24);
		
		for(int i = 0;i<50;i++)
		{
			t[i] = new JTextField(null);
			t[i].setFont(font0);
		}
		for(int i = 0;i<50;i++)
		{
			panel4.add(t[i]);
		}
		for(int i = 10;i<50;i++)
		{
			t[i].setEnabled(false);
		}
		
		labelBT.setFont(font1);
		this.setSize(600,370);//设置窗口大小
		this.setLocation(30,240);//设置窗口位置
		this.setVisible(true);	
		
	}
	public void Cunru()
	{
	    int num[] = new int[10];
		for(int i = 0;i<10;i++)
		{
			num[i] = Integer.parseInt(t[i].getText());
		}
	}
	
	public void reset()
	{
		for(int i = 10;i<50;i++)
			t[i].setText(null);
	}
	
	
	
	//主函数
	public static void main( String[] args) 
	{
		new Xnym();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int qys;
		
		Object an = e.getSource();
		if(an == SJ)
		{
			reset();qys = 0;
			for(int i = 0;i < 10;i++)
			{
				int number = new Random().nextInt(8)+1;
				String a = String.valueOf(number);
				t[i].setText(a);
				t[i].setEnabled(false);
			}
		}
		if(an == SD)
		{
			reset();qys = 0;
			for(int i = 0;i < 10;i++)
			{
				t[i].setEnabled(true);
				t[i].setText(null);
			}
		}
		if(an == BO)
		{
			reset();qys = 0;
			 int num[] = new int[10];
				for(int i = 0;i<10;i++)
				{
					num[i] = Integer.parseInt(t[i].getText());
				}
			t[10].setText(t[0].getText());
			if(num[1]!=num[0])
			{
				t[11].setText(t[0].getText());
				t[21].setText(t[1].getText());
			}
			else t[11].setText(t[0].getText());
			for(int i = 2;i<10;i++)
			{
				if()
				{
					t[10+i].setText(t[9+i].getText());
					t[20+i].setText(t[19+i].getText());
					t[30+i].setText(t[29+i].getText());
				}
				else
				{
					
					if(i == 2)
					{
						t[10+i].setText(t[9+i].getText());
						t[20+i].setText(t[19+i].getText());
						t[30+i].setText(t[i].getText());
					}
					else
					{
						int n1 = 0,n2 = 0,n3 = 0;
						for(int k = i+1;k<10;k++)
						{
							if(Integer.parseInt(t[9+i].getText())==num[k])
							{
								n1 = k-i;
							}
						}
						for(int k = i+1;k<10;k++)
						{
							if(Integer.parseInt(t[19+i].getText())==num[k])
							{
								
								n2 = k-i;
							}
						}
						for(int k = i+1;k<10;k++)
						{
							if(Integer.parseInt(t[29+i].getText())==num[k])
							{
								
								n3 = k-i;
							}
						}
						if((n1<n2)&&(n1<n3))
						{
							t[10+i].setText(t[i].getText());
							t[20+i].setText(t[19+i].getText());
							t[30+i].setText(t[29+i].getText());
						}
						if((n2<n1)&&(n2<n3))
						{
							t[10+i].setText(t[9+i].getText());
							t[20+i].setText(t[i].getText());
							t[30+i].setText(t[29+i].getText());
						}
						if((n3<n2)&&(n3<n1))
						{
							t[10+i].setText(t[9+i].getText());
							t[20+i].setText(t[19+i].getText());
							t[30+i].setText(t[i].getText());
						}
					}
				}
			}
			
		}
		if(an == BF)
		{
			reset();qys = 0;
			int num[] = new int[10];
			for(int i = 0;i<10;i++)
			{
				num[i] = Integer.parseInt(t[i].getText());
			}
			t[10].setText(t[0].getText());
			t[40].setText("√");qys++;
			if(num[1]==num[0])
			{
				t[11].setText(t[10].getText());
			}
			else 
			{
				t[11].setText(t[1].getText());
				t[21].setText(t[0].getText());
				t[41].setText("√");qys++;
			}
			for(int i = 2;i<10;i++)
			{
				if(num[i]==num[i-1]||num[i]==num[i-2])
				{
					t[10+i].setText(t[9+i].getText());
					t[20+i].setText(t[19+i].getText());
					t[30+i].setText(t[29+i].getText());
				}
				else
				{
					t[10+i].setText(t[i].getText());
					t[20+i].setText(t[9+i].getText());
					t[30+i].setText(t[19+i].getText());
					t[40+i].setText("√");qys++;
				}
			}
		}
		if(an == BL)
		{
			reset();
			int num[] = new int[10];
			for(int i = 0;i<10;i++)
			{
				num[i] = Integer.parseInt(t[i].getText());
			}
			t[10].setText(t[0].getText());
			t[40].setText("√");qys++;
			for(int i = 1;i<10;i++)
			{
				if(num[i]==num[i-1])
				{
					t[10+i].setText(t[9+i].getText());
					t[20+i].setText(t[19+i].getText());
					t[30+i].setText(t[29+i].getText());
				}
				else
				{
					t[10+i].setText(t[i].getText());
					t[20+i].setText(t[9+i].getText());
					t[30+i].setText(t[19+i].getText());
					t[40+i].setText("√");qys++;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
}

