package midterm;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;


public class Part1 extends JFrame {

	static JTextArea OutputText;
	static JTextArea InputText;
	JButton SubmitButton;
	JScrollPane areaScrollPane;
	private static ServerSocket Servsock;
	private static final int port = 5002;
	private static int dataCheck=0;	
	
	
    public Part1(){
	
	super( "Part1" );
	setLayout( new FlowLayout() );
	String temp= null;
	


	SubmitButton = new JButton("C.Submit Button");
	OutputText = new JTextArea(5, 20);
	OutputText.setEditable (false);
	InputText = new JTextArea(4,10);
	
	areaScrollPane = new JScrollPane(OutputText);
	//areaScrollPane.setVerticalScrollBarPolicy(ScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	//areaScrollPane.setPreferredSize(new Dimension(250, 250));
	
	SubmitButton.setToolTipText("Click To Submit Your Text");
	InputText.setToolTipText("Enter Your Text Here");
	OutputText.setToolTipText("Output Text");
	
	add(OutputText);
	add(InputText);
	add(SubmitButton);
		
	
	PerformSubmit Submithandler= new PerformSubmit();
		
		
		
	SubmitButton.addActionListener(Submithandler);
	
	
	}



	private class PerformSubmit implements ActionListener{
		
		String input=null;
		String display=null;
		
		public void actionPerformed(ActionEvent event){
		System.out.println("Text is");
		OutputText.setText (InputText.getText());
		InputText.setText(null);
		try{
		doComunicate();}
		catch(Exception e){};
			
		}
		
	}

	public String getText(){
		
		return InputText.getText();
	
	}
	
	public void setText(String a){
	
		OutputText.setText(a);
	
	}

	public void doComunicate()throws Exception{
		
        try {
            Servsock = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
			Socket socket=Servsock.accept();
			System.out.println("received a connection - moving to port:");
			ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			
			while(true){

				String output = InputText.getText();
				oos.writeObject(output);
			}
		
		}	

	public static void main(String[] argu){
	
			Part1 frame =new Part1();
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			frame.setSize( 300, 200 ); // set frame size
       		frame.setVisible( true ); // display frame
			frame.setResizable ( false );
	
	}
	



}