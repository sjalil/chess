
import java.util.*;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.io.*;

import java.net.ServerSocket;

import java.net.Socket;

import java.net.InetAddress;


public class Part2 extends JFrame {


	JTextArea OutputText;

	JTextArea InputText;

	JButton SubmitButton;

	private static ServerSocket Servsock;

	private static final int port = 5002;

	private static int dataCheck=0;
	
	
	
    public Part2(){



	
				super( "Part2" );


				setLayout( new FlowLayout() );

				String temp= null;
	


	
				SubmitButton = new JButton("C.Submit Button");

				OutputText = new JTextArea(5, 20);
	
				OutputText.setEditable (false);
			
	InputText = new JTextArea(4,10);

			
	SubmitButton.setToolTipText("Click To Submit Your Text");
			
	InputText.setToolTipText("Enter Your Text Here");

				OutputText.setToolTipText("Output Text");
	
	
				add(OutputText);

				add(InputText);
	add(SubmitButton);
	
	
	
				PerformSubmit Submithandler= new PerformSubmit();

		
		
SubmitButton.addActionListener(Submithandler);
	
	
	
}



	
	private class PerformSubmit implements ActionListener
	{
		
		
		String input=null;

		String display=null;

		
public void actionPerformed(ActionEvent event){

		System.out.println("Text is");

		try{
	
			input = doComunicate();
		   }
	
	        catch(Exception e){};
	
	
		OutputText.setText (input);

			
		
          }
		
	}

	
	public String getText(){


		return InputText.getText();

	

	}
	
	public void setText(String a){
	

		OutputText.setText(a);
	

	}

	
	public String doComunicate()throws Exception{


		
Socket socket=new Socket("localhost",port );

		System.out.println("socket to server created");
		
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
	
	ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
	
	String text= (String)ois.readObject();

		
		return text;
		
		
	}





	public static void main(String[] argu){
	

			Part1 frame =new Part1();

			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	
		frame.setSize( 300, 200 ); // set frame size
 
      		frame.setVisible( true ); // display frame

			frame.setResizable ( false );
	
	
}

		
	










}