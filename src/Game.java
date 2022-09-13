import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener,KeyListener
{
	
	private ImageIcon title;
	private int [] snakexlength=new int[750];
	private int [] snakeylength=new int[750];
	private int score=0;
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private int move=0;
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private Timer timer;
	private int delay=100;
	private int lengthofsnake=3;
	private ImageIcon snakeimage;
	private int[] enemyxpos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] enemyypos= {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	private ImageIcon enemyimg;
	private Random random =new Random();
	private int xpos=random.nextInt(34);
	private int ypos=random.nextInt(23);
	public Game()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(move==0)
		{
			snakexlength[2]=50;
			snakexlength[1]=75;
			snakexlength[0]=100;
			
			snakeylength[2]=100;
			snakeylength[1]=100;
			snakeylength[0]=100;
		}
		g.setColor(Color.white);//title border
		g.drawRect(24, 10, 851, 55);
		
		
		title=new ImageIcon("snaketitle.jpeg");//title image
		title.paintIcon(this, g, 25, 11);
		
		
		g.setColor(Color.white);//playing area border 
		g.drawRect(24, 74, 851, 577);
	
		
		g.setColor(Color.black);//gameplay background
		g.fillRect(25, 75, 850,575);
		
		//score
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Length :"+lengthofsnake, 780, 50);
		
		
		//draw length snake
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Scores :"+score, 780, 30);
		
		rightmouth=new ImageIcon("rightmouth.jpeg");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int a=0;a<lengthofsnake;a++)
		{
			if(a==0&&right)
			{
				rightmouth=new ImageIcon("rightmouth.jpeg");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			
			if(a==0&&left)
			{
				leftmouth=new ImageIcon("leftmouth.jpeg");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0&&up)
			{
				upmouth=new ImageIcon("upmouth.jpeg");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			if(a==0&&down)
			{
				downmouth=new ImageIcon("downmouth.jpeg");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
				
			}
			
			if(a!=0)
			{
		
					snakeimage=new ImageIcon("snakeimage.jpeg");
					snakeimage.paintIcon(this, g, snakexlength[a], snakeylength[a]);
					
				
			}
			
		}
		enemyimg=new ImageIcon("enemy.jpeg");
		enemyimg.paintIcon(this, g, enemyxpos[xpos],enemyypos[ypos] );
		if(enemyxpos[xpos]==snakexlength[0]&&enemyypos[ypos]==snakeylength[0])
		{
			score++;
			lengthofsnake++;
			xpos=random.nextInt(34);
			ypos=random.nextInt(23);
		}
		for(int b=1;b<lengthofsnake;b++)
		{
			if(snakexlength[b]==snakexlength[0] && snakeylength[b]==snakeylength[0])
			{
				right=false;
				left=false;
				up=false;
				down=false;
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("GAME OVER", 300, 300);
				
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("PRESS SPACE TO RESTART", 320, 340);
				addKeyListener(this);
			}
		}
		g.dispose();
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			move=0;
			score=0;
			lengthofsnake=3;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			move++;
			right=true;
			if(!left)
			{
				right=true;
			}
			else
			{
				right=false;
				left=true;
			}
			up=false;
			down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			move++;
			left=true;
			if(!right)
			{
				left=true;
			}
			else
			{
				left=false;
				right=true;
			}
			up=false;
			down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			move++;
			up=true;
			if(!down)
			{
				up=true;
			}
			else
			{
				up=false;
				down=true;
			}
			left=false;
			right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			move++;
			down=true;
			if(!up)
			{
				down=true;
			}
			else
			{
				down=false;
				up=true;
			}
			left=false;
			right=false;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		timer.start();
		if(right)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeylength[i+1]=snakeylength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakexlength[i]=snakexlength[i]+25;
					
				}
				else
				{
					snakexlength[i]=snakexlength[i-1];
				}
			
				if(snakexlength[i]>850)
				{
					snakexlength[i]=25;
					
				}
			}
			repaint();
		}
		if(left)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeylength[i+1]=snakeylength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakexlength[i]=snakexlength[i]-25;
					
				}
				else
				{
					snakexlength[i]=snakexlength[i-1];
				}
			
				if(snakexlength[i]<25)
				{
					snakexlength[i]=850;
					
				}
			}
			repaint();
			
		}
		if(up)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakexlength[i+1]=snakexlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeylength[i]=snakeylength[i]-25;
					
				}
				else
				{
					snakeylength[i]=snakeylength[i-1];
				}
			
				if(snakeylength[i]<75)
				{
					snakeylength[i]=625;
					
				}
			}
			repaint();
			
		}
		if(down)
		{
			for(int i=lengthofsnake;i>=0;i--)
		{
			snakexlength[i+1]=snakexlength[i];
		}
		for(int i=lengthofsnake;i>=0;i--)
		{
			if(i==0)
			{
				snakeylength[i]=snakeylength[i]+25;
				
			}
			else
			{
				snakeylength[i]=snakeylength[i-1];
			}
		
			if(snakeylength[i]>625)
			{
				snakeylength[i]=75;
				
			}
		}
		repaint();
			
		}
		
	}



}
