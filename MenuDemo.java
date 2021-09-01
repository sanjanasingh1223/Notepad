import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

class MenuDemo implements Runnable , ActionListener
{
	JFrame fr,fontfr;
	JMenuBar mb;
	JMenu mnu1,mnu2,mnu3,sty,sz;
	JMenuItem n,o,s,e,ct,cp,ps,fnt,st1,st2,st3,size[];
	JTextArea ta;
	JTextField t1;
	JButton bt1,bt2;
	JList ls;
	JScrollPane jsp,listjsp;
	JLabel lb1,lb2,lb3,lb4;
	JPanel header,footer,sample;
	JToolBar tool;
	JButton b1,b2,b3,b4,b5,b6;
	JPopupMenu pop;
	JMenuItem p1,p2,p3,p4,p5,p6;
	Dimension dim;
	Thread th;
	int z=10;

	int fontstyle=0,fontsize=12;
	String fontname="Verdana",path,saveddata;

	public MenuDemo()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		fr = new JFrame("Untitled - Notepad");
		fr.setSize(dim.width , dim.height);
		fr.setLayout(new BorderLayout());

		Image img = Toolkit.getDefaultToolkit().getImage("images/note.png");
		fr.setIconImage(img);

		ta = new JTextArea();
		ta.setFont(new Font(fontname,fontstyle,fontsize));
		ta.setForeground(Color.black);
		jsp = new JScrollPane(ta);
		fr.add(jsp,BorderLayout.CENTER);	

		header = new JPanel();
		header.setLayout(new BorderLayout());

		mb = new JMenuBar();
		mnu1 = new JMenu("File");
		n = new JMenuItem("   New   ");
		o = new JMenuItem("   Open  ");
		s = new JMenuItem("   Save  ");
		e = new JMenuItem("   Exit  ");

		n.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , Event.CTRL_MASK));
		o.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , Event.CTRL_MASK));
		s.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , Event.CTRL_MASK));
		e.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E , Event.CTRL_MASK));

		n.setFont(new Font("verdana",Font.PLAIN,14));
		o.setFont(new Font("verdana",Font.PLAIN,14));
		s.setFont(new Font("verdana",Font.PLAIN,14));
		e.setFont(new Font("verdana",Font.PLAIN,14));
		n.setIcon(new ImageIcon("images/new1.png"));
		o.setIcon(new ImageIcon("images/open1.png"));
		s.setIcon(new ImageIcon("images/save1.png"));
		e.setIcon(new ImageIcon("images/exit1.png"));

		n.addActionListener(this);
		o.addActionListener(this);
		s.addActionListener(this);
		e.addActionListener(this);

		mnu1.add(n);
		mnu1.addSeparator();
		mnu1.add(o);
		mnu1.addSeparator();
		mnu1.add(s);
		mnu1.addSeparator();
		mnu1.add(e);

		mnu2 = new JMenu("Edit");
		ct = new JMenuItem("   Cut   ");
		cp = new JMenuItem("   Copy  ");
		ps = new JMenuItem("   Paste ");

		ct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , Event.CTRL_MASK));
		cp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , Event.CTRL_MASK));
		ps.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , Event.CTRL_MASK));

		ct.addActionListener(this);
		cp.addActionListener(this);
		ps.addActionListener(this);

		ct.setFont(new Font("verdana",Font.PLAIN,14));
		cp.setFont(new Font("verdana",Font.PLAIN,14));
		ps.setFont(new Font("verdana",Font.PLAIN,14));
		ct.setIcon(new ImageIcon("images/cut1.png"));
		cp.setIcon(new ImageIcon("images/copy1.png"));
		ps.setIcon(new ImageIcon("images/paste1.png"));
		mnu2.add(ct);
		mnu2.addSeparator();
		mnu2.add(cp);
		mnu2.addSeparator();
		mnu2.add(ps);

		mnu3 = new JMenu("Format");

		sty = new JMenu("   Style  ");
		sty.setIcon(new ImageIcon("images/style.png"));
		sty.setFont(new Font("verdana",Font.PLAIN,14));
		st1 = new JMenuItem("Bold    ");
		st2 = new JMenuItem("Italic  ");
		st3 = new JMenuItem("Plain   ");

		st1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B , Event.CTRL_MASK));
		st2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I , Event.CTRL_MASK));
		st3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , Event.CTRL_MASK));

		st1.setFont(new Font("verdana",Font.BOLD,14));
		st2.setFont(new Font("verdana",Font.ITALIC,14));
		st3.setFont(new Font("verdana",Font.PLAIN,14));
		
		st1.addActionListener(this);
		st2.addActionListener(this);
		st3.addActionListener(this);

		sty.add(st1);
		sty.add(st2);
		sty.add(st3);
		
		
		fnt = new JMenuItem("   Font...  ");
		fnt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F , Event.CTRL_MASK));
		fnt.setIcon(new ImageIcon("images/font.png"));
		fnt.setFont(new Font("verdana",Font.PLAIN,14));
		fnt.addActionListener(this);

		sz = new JMenu("   Size");
		sz.setIcon(new ImageIcon("images/size.png"));
		sz.setFont(new Font("verdana",Font.PLAIN,14));
		size = new JMenuItem[10];
		for(int i=0 ; i<size.length ; i++)
		{
			size[i] = new JMenuItem(""+z);
			size[i].setFont(new Font("verdana",Font.PLAIN,14));
			size[i].addActionListener(this);
			sz.add(size[i]);
			z = z + 2;
		}
		
		mnu3.add(sty);
		mnu3.addSeparator();
		mnu3.add(fnt);
		mnu3.addSeparator();
		mnu3.add(sz);

		mnu1.setFont(new Font("verdana",Font.PLAIN,14));
		mnu2.setFont(new Font("verdana",Font.PLAIN,14));
		mnu3.setFont(new Font("verdana",Font.PLAIN,14));
		mb.add(mnu1);
		mb.add(mnu2);
		mb.add(mnu3);
		header.add(mb,BorderLayout.NORTH);		
		
		tool = new JToolBar("Operations");
		b1 = new JButton(new ImageIcon("images/new1.png"));
		b2 = new JButton(new ImageIcon("images/open1.png"));
		b3 = new JButton(new ImageIcon("images/save1.png"));
		b4 = new JButton(new ImageIcon("images/cut1.png"));
		b5 = new JButton(new ImageIcon("images/copy1.png"));
		b6 = new JButton(new ImageIcon("images/paste1.png"));
		b1.setToolTipText("New");
		b2.setToolTipText("Open");
		b3.setToolTipText("Save");
		b4.setToolTipText("Cut");
		b5.setToolTipText("Copy");
		b6.setToolTipText("Paste");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		tool.add(b1);
		tool.add(b2);
		tool.add(b3);
		tool.add(b4);
		tool.add(b5);
		tool.add(b6);
		header.add(tool,BorderLayout.SOUTH);		

		footer = new JPanel();
		footer.setLayout(new BorderLayout());
	
		lb1= new JLabel(" Designed & Developed at javaTpoint");
		lb1.setFont(new Font("verdana",Font.PLAIN,14));			
		lb1.setForeground(Color.blue);
		
		lb2= new JLabel();
		lb2.setFont(new Font("verdana",Font.PLAIN,14));			
		lb2.setForeground(Color.blue);

		footer.add(lb1,BorderLayout.WEST);		
		footer.add(lb2,BorderLayout.EAST);		

		fr.add(header,BorderLayout.NORTH);
		fr.add(footer,BorderLayout.SOUTH);

		pop = new JPopupMenu();
		p1 = new JMenuItem("   New");
		p2 = new JMenuItem("   Open");
		p3 = new JMenuItem("   Save");
		p4 = new JMenuItem("   Cut");
		p5 = new JMenuItem("   Copy");
		p6 = new JMenuItem("   Paste");
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		p4.addActionListener(this);
		p5.addActionListener(this);
		p6.addActionListener(this);
		p1.setIcon(new ImageIcon("images/new1.png"));
		p2.setIcon(new ImageIcon("images/open1.png"));
		p3.setIcon(new ImageIcon("images/save1.png"));
		p4.setIcon(new ImageIcon("images/cut1.png"));
		p5.setIcon(new ImageIcon("images/copy1.png"));
		p6.setIcon(new ImageIcon("images/paste1.png"));
		pop.add(p1);
		pop.add(p2);
		pop.add(p3);
		pop.addSeparator();
		pop.add(p4);
		pop.add(p5);
		pop.add(p6);

		ta.addMouseListener(new MouseAdapter()
		{
			public void cat(MouseEvent me)
			{
				if(me.isPopupTrigger())
				{
					pop.show(fr,me.getX(),me.getY());
				}
			}

			public void mousePressed(MouseEvent me)
			{
				cat(me);
			}

			public void mouseReleased(MouseEvent me)	
			{
				cat(me);
			}
		});
	
		fr.setVisible(true);
		fr.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				if(ta.getText().trim().length()!=0)		
				{
					if(fr.getTitle().equals("Untitled - Notepad"))
					{
						int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to Untitled?");
						if(z==0)	
						{
							save(ta.getText());
							System.exit(0);
						}
						else if(z==1)
						{
							System.exit(0);
						}
						else if(z==2)
						{
							fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						}
					}
					else
					{
						String currentdata = ta.getText();
						if(!currentdata.equals(saveddata))
						{
							int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to "+path);
							if(z==0)
							{
								try
								{
									byte by[] = currentdata.getBytes();
									File fe = new File(path);
									FileOutputStream fos = new FileOutputStream(fe);
									ByteArrayOutputStream baos = new ByteArrayOutputStream();
									baos.write(by);
									baos.writeTo(fos);
									baos.close();
									fos.close();
								}
								catch(Exception e)
								{}
								System.exit(0);
							}
							else if(z==1)
							{
								System.exit(0);
							}
							else if(z==2)
							{
								fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
							}
						}
						else
						{
							System.exit(0);
						}	
					}
				}
				else
				{
					System.exit(0);
				}
			}
		});
		th = new Thread(this);
		th.start();
	}

	public void run()
	{
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY hh:mm:ss a");	
		while(true)
		{
			try
			{
				dt = new Date();
				lb2.setText(""+sdf.format(dt)+"  ");	
				Thread.sleep(1000);
			}
			catch(Exception e)
			{}
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==fnt)
		{
			fr.setEnabled(false);

			fontfr = new JFrame("Select Font");
			fontfr.setBounds((dim.width-400)/2,(dim.height-400)/2,400,400);
			fontfr.setLayout(null);

			lb3 = new JLabel("Font:");
			lb3.setFont(new Font("verdana",Font.PLAIN,16));
			lb3.setForeground(Color.black);
			lb3.setBounds(30,15,100,20);
			fontfr.add(lb3);	

			t1 = new JTextField(fontname);
			t1.setFont(new Font("verdana",Font.PLAIN,16));
			t1.setForeground(Color.black);
			t1.setBounds(30,40,335,30);
			fontfr.add(t1);

			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
      			String fontnames[] = env.getAvailableFontFamilyNames();

			ls = new JList(fontnames);
			ls.setFont(new Font("verdana",Font.PLAIN,16));
			ls.setForeground(Color.black);
			listjsp = new JScrollPane(ls);
			listjsp.setBounds(30,70,335,165);
			fontfr.add(listjsp);
			ls.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent me)
				{
					t1.setText(ls.getSelectedValue().toString());
					lb4.setFont(new Font(t1.getText(),Font.PLAIN,30));
				}
			});
			ls.setSelectedValue(fontname,true);

			ls.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent ke)
				{
					if(ke.getKeyCode()==KeyEvent.VK_UP || ke.getKeyCode()==KeyEvent.VK_DOWN)
					{
						t1.setText(ls.getSelectedValue().toString());
						lb4.setFont(new Font(t1.getText(),Font.PLAIN,30));
					}	
				}
			});
		
			lb4 = new JLabel("Sample Text");
			lb4.setHorizontalAlignment(SwingConstants.CENTER);
			lb4.setVerticalAlignment(SwingConstants.CENTER);
			lb4.setBounds(30,250,335,60);
			lb4.setBackground(Color.GRAY);
			lb4.setOpaque(true);
			lb4.setFont(new Font(fontname,Font.PLAIN,30));
			lb4.setForeground(Color.BLACK);
			fontfr.add(lb4);

			bt1 = new JButton("OK");
			bt2 = new JButton("Cancel");
			bt1.setBounds(95,330,100,30);
			bt2.setBounds(205,330,100,30);
			bt1.setFont(new Font("verdana",Font.PLAIN,16));
			bt2.setFont(new Font("verdana",Font.PLAIN,16));
			fontfr.add(bt1);
			fontfr.add(bt2);
			bt1.addActionListener(this);
			bt2.addActionListener(this);
	
			fontfr.setVisible(true);	
			fontfr.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					fr.setEnabled(true);
					fontfr.dispose();
				}
			});
		}

		else if(ae.getSource()==bt1)
		{
			fontname = t1.getText();
			ta.setFont(new Font(fontname,fontstyle,fontsize));
			fr.setEnabled(true);
			fontfr.dispose();
		}
	
		else if(ae.getSource()==bt2)
		{
			fr.setEnabled(true);
			fontfr.dispose();
		}

		else if(ae.getSource()==ct || ae.getSource()==p4 || ae.getSource()==b4)
		{
			ta.cut();
		}

		else if(ae.getSource()==cp || ae.getSource()==p5 || ae.getSource()==b5)
		{
			ta.copy();
		}

		else if(ae.getSource()==ps || ae.getSource()==p6 || ae.getSource()==b6)
		{
			ta.paste();
		}

		else if(ae.getSource()==st1)
		{
			fontstyle = 1;
			ta.setFont(new Font(fontname,fontstyle,fontsize));
		}

		else if(ae.getSource()==st2)
		{
			fontstyle = 2;
			ta.setFont(new Font(fontname,fontstyle,fontsize));
		}

		else if(ae.getSource()==st3)
		{
			fontstyle = 0;
			ta.setFont(new Font(fontname,fontstyle,fontsize));
		}

		else if(ae.getSource()==n || ae.getSource()==p1 || ae.getSource()==b1)
		{
			if(ta.getText().trim().length()==0)
			{
				ta.setText("");
			}
			else
			{
				if(fr.getTitle().equals("Untitled - Notepad"))
				{
					int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to Untitled?");
					if(z==0)	
					{
						save(ta.getText());
						ta.setText("");
						fr.setTitle("Untitled - Notepad");
					}
					else if(z==1)
					{
						ta.setText("");
					}
				}
				else 
				{
					String currentdata = ta.getText();
					if(!currentdata.equals(saveddata))
					{
						int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to "+path);
						if(z==0)
						{
							try
							{
								byte by[] = currentdata.getBytes();
								File fe = new File(path);
								FileOutputStream fos = new FileOutputStream(fe);
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								baos.write(by);
								baos.writeTo(fos);
								baos.close();
								fos.close();
							}
							catch(Exception e)
							{}
							ta.setText("");
							fr.setTitle("Untitled - Notepad");
						}
						else if(z==1)
						{
							ta.setText("");
							fr.setTitle("Untitled - Notepad");
						}
					}
					else
					{
						ta.setText("");
						fr.setTitle("Untitled - Notepad");
					}	
				}
			}
		}

		else if(ae.getSource()==o || ae.getSource()==p2 || ae.getSource()==b2)
		{
			if(ta.getText().trim().length()==0)
			{
				ta.setText("");
				open();
			}
			else
			{
				if(fr.getTitle().equals("Untitled - Notepad"))
				{
					int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to Untitled?");
					if(z==0)	
					{
						save(ta.getText());
						ta.setText("");
						fr.setTitle("Untitled - Notepad");
						open();
					}
					else if(z==1)
					{
						open();
					}
				}
				else
				{
					String currentdata = ta.getText();
					if(!currentdata.equals(saveddata))
					{
						int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to "+path);
						if(z==0)
						{
							try
							{
								byte by[] = currentdata.getBytes();
								File fe = new File(path);
								FileOutputStream fos = new FileOutputStream(fe);
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								baos.write(by);
								baos.writeTo(fos);
								baos.close();
								fos.close();
							}
							catch(Exception e)
							{}
							ta.setText("");
							open();
						}
						else if(z==1)
						{
							open();
						}
					}
					else
					{
						open();
					}	
				}
			}
		}

		else if(ae.getSource()==s || ae.getSource()==p3 || ae.getSource()==b3)
		{
			save(ta.getText());
		}

		else if(ae.getSource()==e)
		{
			if(ta.getText().trim().length()!=0)		
			{
				if(fr.getTitle().equals("Untitled - Notepad"))
				{
					int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to Untitled?");
					if(z==0)	
					{
						save(ta.getText());
						System.exit(0);
					}
					else if(z==1)
					{
						System.exit(0);
					}
					else if(z==2)
					{
						fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				}
				else
				{
					String currentdata = ta.getText();
					if(!currentdata.equals(saveddata))
					{
						int z = JOptionPane.showConfirmDialog(fr,"Do you want to save changes to "+path);
						if(z==0)
						{
							try
							{
								byte by[] = currentdata.getBytes();
								File fe = new File(path);
								FileOutputStream fos = new FileOutputStream(fe);
								ByteArrayOutputStream baos = new ByteArrayOutputStream();
								baos.write(by);
								baos.writeTo(fos);
								baos.close();
								fos.close();
							}
							catch(Exception e)
							{}
							System.exit(0);
						}
						else if(z==1)
						{
							System.exit(0);
						}
						else if(z==2)
						{
							fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						}
					}
					else
					{
						System.exit(0);
					}	
				}
			}
			else
			{
				System.exit(0);
			}
		}

		else
		{
			fontsize = Integer.parseInt(ae.getActionCommand());
			ta.setFont(new Font(fontname,fontstyle,fontsize));
		}
	}

	private void save(String data)
	{
		try
		{
			FileDialog fd = new FileDialog(fr , "Save As" , FileDialog.SAVE);
			fd.setVisible(true);

			String filename = fd.getFile();

			if(!filename.equals("null"))
			{
				if(!(filename.endsWith(".txt") || filename.endsWith(".TXT")))
				{
					filename = filename + ".txt";	
				}

				path = fd.getDirectory() + filename;
			
				byte by[] = data.getBytes();
				saveddata = data;
				File fe = new File(path);
				FileOutputStream fos = new FileOutputStream(fe);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				baos.write(by);
				baos.writeTo(fos);
				baos.close();
				fos.close();

				if(filename.endsWith(".txt"))
				{
					filename = filename.substring(0,filename.indexOf("."));
				}

				fr.setTitle(filename + " - Notepad");
			}
		}
		catch(Exception e)
		{
		}
	}

	private void open()
	{
		try
		{
			FileDialog fd = new FileDialog(fr,"Open",FileDialog.LOAD);
			fd.setVisible(true);
			path = fd.getDirectory() + fd.getFile();
			if(!path.equals("nullnull"))	
			{
				String fn = fd.getFile();
				fn = fn.substring(0,fn.indexOf("."));
				fr.setTitle(fn + " - Notepad");
				Reader rd = new FileReader(path);
				BufferedReader br = new BufferedReader(rd);
				String str="";
				StringBuffer sb = new StringBuffer("");
				while((str=br.readLine())!=null)
				{
					sb.append(str+"\n");
				}
				saveddata = sb.toString();
				ta.setText(sb.toString());
			}
		}
		catch(Exception e)
		{}
	}

	public static void main(String args[])
	{
		new MenuDemo();	
	}
}