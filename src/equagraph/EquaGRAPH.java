/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equagraph;

import static equagraph.EquaGRAPH.userScreenWidth;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Image ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.net.URL ;
import java.awt.Cursor;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon ;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author anupamsworld
 */
class handleJFrame_c{

    static void makeThisWindowLikeMyWay_m(JFrame myFrame,String myFrame_name,int myFrame_width,int myFrame_height,boolean myFrame_resizable,Image myFrame_image,int myFrame_location_x,int myFrame_location_y,int myFrame_default_close_operation,boolean myFrame_visible){
        myFrame.setTitle(myFrame_name);
        myFrame.setMinimumSize(new Dimension(myFrame_width, myFrame_height));
        myFrame.setResizable(myFrame_resizable);
        myFrame.setIconImage(myFrame_image);
        myFrame.setLocation(myFrame_location_x, myFrame_location_y);
        myFrame.setDefaultCloseOperation(myFrame_default_close_operation);
        myFrame.setVisible(myFrame_visible);
    }
}
class handleJLabel_c{
    static void makeThisJLabelLikeMyWay_m(JLabel myJLabel,String myJLabel_text,int myJLabel_width,int myJLabel_height,int myJLabel_location_x,int myJLabel_location_y,Color myJLabel_foreground_color,Font myJLabel_font,String myJLabel_ImageIcon_path){
        myJLabel.setText(myJLabel_text);
        myJLabel.setBounds(myJLabel_location_x, myJLabel_location_y, myJLabel_width, myJLabel_height);
        myJLabel.setForeground(myJLabel_foreground_color);
        myJLabel.setFont(myJLabel_font);
        if(myJLabel_ImageIcon_path!=null){
            ImageIcon myJLabel_ImageIcon=new handleImage_c().returnImageIconOfTheUrl_m(myJLabel_ImageIcon_path) ;
            myJLabel_ImageIcon=new handleImage_c().returnResizedImageIcon(myJLabel_ImageIcon, myJLabel_width, myJLabel_height) ;
            myJLabel.setIcon(myJLabel_ImageIcon);
        }
    }
}
class handleTextField_c extends MouseAdapter{
    JTextField txt_field=null ;
    @Override
    public void mouseClicked(MouseEvent e){
        txt_field.setText(null);
    }
    static void makeThisTextFieldiLkeMyWay_m(JTextField myTextField,int myTextField_width,int myTextField_height,int myTextField_location_x,int myTextField_location_y,String myTextField_text_first,String myTextField_text_after_clicking){
        myTextField.setText(myTextField_text_first);
        myTextField.setBounds(myTextField_location_x, myTextField_location_y, myTextField_width, myTextField_height);
        handleTextField_c mouse_listener_for_myTextField=new handleTextField_c() ;
        mouse_listener_for_myTextField.txt_field=myTextField ;
        myTextField.addMouseListener(mouse_listener_for_myTextField);
    }
}
class handleImage_c{
    Image returnImageOfTheUrl_m(String Image_path){
        Image imageImage=null ;
        try{
            URL imageUrl=getClass().getResource(Image_path) ;
            ImageIcon imageIcon=new ImageIcon(imageUrl) ;
            imageImage=imageIcon.getImage() ;
        }catch(Exception e){}
        return imageImage ;
    }
    ImageIcon returnImageIconOfTheUrl_m(String ImageIcon_path){
        ImageIcon imageIcon = null;
        try{
            java.net.URL imageUrl=getClass().getResource(ImageIcon_path) ;
            imageIcon=new javax.swing.ImageIcon(imageUrl);
            
        }catch(Exception e){}
        
        return imageIcon ;
    }
    ImageIcon returnResizedImageIcon(ImageIcon myImageIcon,int myImageIcon_resized_width,int myImageIcon_resized_height){
        Image myImage,myImage2 ;
        myImage=myImageIcon.getImage() ;
        myImage2=myImage.getScaledInstance(myImageIcon_resized_width, myImageIcon_resized_height, Image.SCALE_SMOOTH) ;
        ImageIcon myImageIcon_resized=new ImageIcon(myImage2) ;
        return myImageIcon_resized ;
    }
    
    
    /*
    ImageIcon returnLoadingImageIcon_m(){
        ImageIcon imageIcon = null;
        try{
            java.net.URL imageUrl=getClass().getResource("loading.gif") ;
            imageIcon=new javax.swing.ImageIcon(imageUrl);
        }catch(Exception e){}
        return imageIcon ;
    }*/
}
/*
class graphPad extends JPanel{
    
    graphPad(int panel_Width,int panel_Height){
        this.setBackground(Color.getHSBColor((float)0.40, (float)0.70, (float)0.90));
        this.setBounds(0, 30, 518, 518);
        goForGraphWindow.panel_for_graphPad.add(this) ;
    }
    @Override
    public void paintComponent(Graphics g){
        goForGraphWindow.plotTheGraph(g, this);
    }
}*/
class goForGraphWindow{
    static JPanel panel_for_graphPad ;
    private static JPanel panelUp_in_graphPad ;
    private static JPanel panel_for_setEquation ;
    private static JPanel panelDown_in_graphPad ;
    private static JLabel JLabel_equation=new JLabel() ;
    private static JLabel JLabel_equation_afterPlay=new JLabel() ;
    private static JLabel JLabel_playTheGraph=new JLabel() ;
    private static JLabel JLabel_done_playTheGraph=new JLabel() ;
    
    private static float coefficientValues[]=new float[10] ;
    private static int noOfPoweredX ;
    private static int no_of_minus=0 ;
    private static int no_of_points=0 ;
    private static int which_to_plot=0 ;
    private static float range_of_X=10 ;
    private static float range_of_Y ;
    private static float X[]=new float[520],Y[]=new float[520] ;
    JSpinner JSpinner_noOfPoweredX_in_setEquation ;
    static String user_first_name ;
    static String user_last_name ;
    private static JTextField JTextfield_coefficientValue ;
    private JTextField JTextField_range_of_X ;
    private JTextField JTextField_range_of_Y ;
    private static int set_value_is_clicked=0 ;
    //static JSpinner JSpinner_noOfPoweredX_in_setEquation ;
    private static JComboBox JComboBox_poweredX ;
    private static JFrame graph_window ;
    private static JComboBox JComboBox_plus_minus ;
    private static JButton button_setCoefficientValue;
    private static JButton JButton_delete_point ;
    int factorial(int raw_no){
        int fact=1 ;
        for(int i=raw_no;i>=1;i--){
            fact=fact*i ;
        }
        return fact ;
    }
    static boolean arrayHaveTheValue_m(float targetValue){
        for(int i=0;i<no_of_points;i++){
            if(X[i]==targetValue){
                return true ;
            }
        }
        return false ;
    }
    static float returnResultPower_m(float raw_no,int power){
        float result=1 ;
        for(int i=1;i<=power;i++){
            result=result*raw_no ;
        }
        return result ;
    }
    static float fx(float value_of_X){
        float value_of_Y=0 ;
        for(int fact=1,i=0;i<noOfPoweredX;i++){
            value_of_Y += coefficientValues[i]*returnResultPower_m(value_of_X, i) ;
        }
        return value_of_Y ;
    }
    void sortAddedPoints(){
        for(int i=1;i<=no_of_points-1;i++){
            for(int j=i;j>=1;j--){
                
            }
        }
    }
    static void aboutEquaGraphWindow_m(){
        JFrame jf=new JFrame() ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "|| About equaGRAPH programmer ||", 500, 400, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                    JPanel jp=new JPanel() ;
                    jp.setLayout(null) ;
                    jf.add(jp) ;
                    JLabel jl3=new JLabel("About Programmer of equaGRAPH") ;
                    jl3.setBounds(0, 0, 500, 20);
                    jl3.setFont(new Font("Arial", Font.BOLD, 12));
                    jl3.setForeground(Color.BLUE);
                    jp.add(jl3) ;
                    JLabel jl=new JLabel() ;
                    handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 100, 100, 0, 20, Color.yellow, null, "anupam.jpg");
                    JPanel JPanel_my_details=new JPanel() ;
                    JPanel_my_details.setLayout(new GridLayout(0, 2, 1, 3));
                    JPanel_my_details.add(new JLabel(">>NAME :: ")) ;
                    //JPanel_my_details.add(new JLabel("::")) ;
                    JPanel_my_details.add(new JLabel("ANUPAM CHANDA")) ;
                    JPanel_my_details.add(new JLabel(">>eMAIL :: ")) ;
                    JPanel_my_details.add(new JLabel("mailmeanupamchanda@gmail.com")) ;
                    JPanel_my_details.add(new JLabel(">>Facebook Public Page :: ")) ;
                    //JPanel_my_details.add(new JLabel("::")) ;
                    JPanel_my_details.add(new JLabel("www.facebook.com/likeanupam")) ;
                    JScrollPane jsp1=new JScrollPane(JPanel_my_details) ;
                    jsp1.setBounds(100, 40, 390, 80);
                    jp.add(jsp1) ;
                    jp.add(jl) ;
                    JPanel jp2=new JPanel() ;
                    jp2.setLayout(new GridLayout(0, 2,5,5));
                    JLabel jl2=new JLabel("Some people who have helped me to build equaGRAPH") ;
                    jl2.setBounds(0, 130, 500, 20);
                    jl2.setFont(new Font("Arial", Font.BOLD, 12));
                    jl2.setForeground(Color.BLUE);
                    jp.add(jl2) ;
                    JScrollPane jsp=new JScrollPane(jp2) ;
                    jsp.setBounds(0, 150, 490, 100);
                    jp2.add(new JLabel("Satyabrata Bhattacharjee")) ;
                    jp2.add(new JLabel("facebook.com/satyabrata.bhattacharjee.33")) ;
                    jp2.add(new JLabel("Kiranmoy Pradhan")) ;
                    jp2.add(new JLabel("facebook.com/kiran.pradhan.186")) ;
                    jp2.add(new JLabel("Sumit Ranjan")) ;
                    jp2.add(new JLabel("facebook.com/sumit.ranjan.104855")) ;
                    jp.add(jsp) ;
                    JPanel jp4=new JPanel() ;
                    JScrollPane jsp2=new JScrollPane(jp4) ;
                    jsp2.setBounds(0, 260, 490, 40);
                    jp4.add(new JLabel("I am ANUPAM CHANDA, have made this application software by my own logic. Its my own algorithm. If somehow this algorithm matches with any other then I am not responsible for that situation. Some emotional pictures are used in this software, which are of 3rd party. If the owner of those pictures claims, then those pictures will be removed. If you find anyone to sell this software or doing illegal activity related to this software, else if you want to check whether this copy of software is genuine or not then please inform/ask me at my email id. Thanks a lot !!")) ;
                    jp.add(jsp2) ;
                    
                    jf.setVisible(true);
                    graph_window.setEnabled(false);
                    JButton jb=new JButton("Got it !") ;
                    jb.setBounds(200, 320, 100, 20);
                    jp.add(jb) ;
                    jb.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.dispose();
                            graph_window.setEnabled(true);
                        }
                    });
                    jf.add(jp) ;
    }
    static void whatIsPoweredXWindow_m(){
        JFrame jf=new JFrame() ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "What is powered X term ?", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                    JPanel jp=new JPanel() ;
                    jf.add(jp) ;
                    JLabel jl=new JLabel() ;
                    handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 119, 120, 0, 0, Color.yellow, null, "info_boy.png");
                    jp.add(jl) ;
                    JTextArea jta=new JTextArea(2,20) ;
                    jta.setText("Here supported equation format is Y=+a1*X^0+a2*X^1+....+aN*X^(N-1), [+ or - can be used anytime in the place of + of demo equation]. Where a1,a2,...,aN is constants and N is number of terms. So we are calling every term as 'powered X term' .");
                    jta.setEditable(false);
                    jta.setFont(new Font("Arial", Font.ITALIC, 12));
                    jta.setLineWrap(true);
                    jta.setWrapStyleWord(true);// setWrapStyleWord will work if setLineWrap is true there
                    jp.add(jta) ;
                    jf.setVisible(true);
                    graph_window.setEnabled(false);
                    JButton jb=new JButton("Got it !") ;
                    jp.add(jb) ;
                    jb.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.dispose();
                            graph_window.setEnabled(true);
                        }
                    });
                    jf.add(jp) ;
    }
    static void showNumberFormatException(String msg){
        JFrame jf=new JFrame() ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "Caution !!", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                    JPanel jp=new JPanel() ;
                    jf.add(jp) ;
                    JLabel jl=new JLabel() ;
                    handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 99, 123, 0, 0, Color.yellow, null, "not_happy_boy.png");
                    jp.add(jl) ;
                    JTextArea jta=new JTextArea(2,20) ;
                    jta.setText("Sorry "+user_first_name+" ! "+msg);
                    jta.setEditable(false);
                    jta.setFont(new Font("Arial", Font.BOLD, 15));
                    jta.setLineWrap(true);
                    jta.setWrapStyleWord(true);// setWrapStyleWord will work if setLineWrap is true there
                    jp.add(jta) ;
                    jf.setVisible(true);
                    graph_window.setEnabled(false);
                    JButton jb=new JButton("Got it !") ;
                    jp.add(jb) ;
                    jb.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.dispose();
                            graph_window.setEnabled(true);
                        }
                    });
                    jf.add(jp) ;
    }
    
    static void plotTheGraph(){
        goForGraphWindow.panelDown_in_graphPad.removeAll();
        JPanel test=new JPanel(){
                            @Override
                            public void paintComponent(Graphics g){
                                //g.setFont(new Font("Arial", Font.ITALIC, 10)) ;
                                g.setFont(new Font("Arial", Font.BOLD, 15)) ;
                                
                                
                                
                                g.setColor(Color.white);
                                for(int point_x=270;point_x<=519;point_x+=10){
                                    g.drawLine(point_x, 0, point_x, 519);
                                }
                                for(int point_x=250;point_x>=0;point_x-=10){
                                    g.drawLine(point_x, 0, point_x, 519);
                                }
                                for(int point_y=270;point_y<=519;point_y+=10){
                                    g.drawLine(0, point_y, 519, point_y);
                                }
                                for(int point_y=250;point_y>=0;point_y-=10){
                                    g.drawLine(0, point_y, 519, point_y);
                                }
                                
                                g.setColor(Color.blue);
                                g.drawLine(0, 260, 519, 260);
                                
                                g.drawString(">", 513, 265);
                                g.drawString("<", 1, 265);
                                g.drawString("X", 510, 275);
                                g.drawString("X'", 5, 275);
                                
                                g.setColor(Color.red);
                                g.drawLine(260, 0, 260, 519);
                                g.drawString("^", 257, 12);
                                g.drawString("x", 257, 522);
                                g.drawString("Y", 245, 15);
                                g.drawString("Y'", 245, 515);
                                
                                g.setColor(Color.black);
                                g.setFont(new Font("Arial", Font.ITALIC, 10)) ;
                                for(int level_position=0,i=1;i<=259;i+=1){
                                    if(i%30 ==0){
                                        DecimalFormat df=new DecimalFormat("#.##") ;
                                        
                                        if(level_position==1){
                                                g.drawString(df.format(((range_of_X/259)*i)), 260+i, 260-1);
                                                g.drawString("-"+df.format(((range_of_X/259)*i)), 260-i, 260-1);
                                                g.setColor(Color.BLUE);
                                                g.drawOval(260+i-1, 259, 2, 2);
                                                g.drawOval(260-i-1, 259, 2, 2);
                                                g.setColor(Color.BLACK);
                                                level_position=0 ;
                                        }
                                        else if(level_position==0){
                                                g.drawString(df.format(((range_of_X/259)*i)), 260+i, 260+9);
                                                g.drawString("-"+df.format(((range_of_X/259)*i)), 260-i, 260+9);
                                                g.setColor(Color.BLUE);
                                                g.drawOval(260+i-1, 259, 2, 2);
                                                g.drawOval(260-i-1, 259, 2, 2);
                                                g.setColor(Color.BLACK);
                                                level_position=1 ;
                                        }
                                                
                                                g.drawString(df.format(((range_of_Y/259)*i)), 260, 260-i);
                                                g.drawString("-"+df.format(((range_of_Y/259)*i)), 260, 260+i);
                                                g.setColor(Color.RED);
                                                g.drawOval(260-1, 260-i-1, 2, 2);
                                                g.drawOval(260-1, 260+i-1, 2, 2);
                                                g.setColor(Color.BLACK);
                                            }
                                }
                                //System.out.println("range of x="+range_of_X+"   range of y="+range_of_Y);
                                
                                
                                if(which_to_plot==2){
                                    //ln("no_of_points >> "+no_of_points);
                                    for(int h=0;h<no_of_points;h++){
                                        //ln("X["+h+"] >> "+X[h]+"   Y["+h+"] >> "+Y[h]);
                                    }
                                    int i ;
                                    for(i=0;i<no_of_points-1;i++){
                                        g.setColor(Color.black);
                                        g.drawLine((int)(260+((259/range_of_X)*X[i])), (int)(260-((259/range_of_Y)*Y[i])), (int)(260+((259/range_of_X)*X[i+1])), (int)(260-((259/range_of_Y)*Y[i+1])));
                                        //g.setColor(Color.pink);
                                        g.drawOval((int)(260+((259/range_of_X)*X[i]))-5, (int)(260-((259/range_of_Y)*Y[i]))-5, 10, 10);
                                        
                                        g.drawString("("+X[i]+","+Y[i]+")", (int)(260+((259/range_of_X)*X[i]))+8, (int)(260-((259/range_of_Y)*Y[i]))+8);
                                    }
                                    g.drawOval((int)(260+((259/range_of_X)*X[i]))-5, (int)(260-((259/range_of_Y)*Y[i]))-5, 10, 10);
                                    g.drawString("("+X[i]+","+Y[i]+")", (int)(260+((259/range_of_X)*X[i]))+8, (int)(260-((259/range_of_Y)*Y[i]))+8);
                                }
                                else if(which_to_plot==1){
                                    int p_position_X=260+0,p_position_Y=(int)(260-((259*fx((range_of_X*0)/259))/range_of_Y)),n_position_X,n_position_Y ;
                                    for(int i=1;i<=259;i+=1){
                                        if(fx(range_of_X/i)>=0){
                                            n_position_X=260+i ;
                                            n_position_Y=(int)(260-((259*fx((range_of_X*i)/259))/range_of_Y)) ;
                                            //System.out.println("259*fx((range_of_X*i)/259)) = "+(259*fx((range_of_X*i)/259)));
                                            //System.out.println("(259*fx((range_of_X*i)/259))/range_of_Y = "+(259*fx((range_of_X*i)/259))/range_of_Y);
                                            //System.out.println(n_position_X+","+n_position_Y);
                                            //System.out.println("(px,py)=("+(p_position_X-260)+","+(260-p_position_Y)+")"+"    "+"(nx,ny)=("+(n_position_X-260)+","+(260-n_position_Y)+")"+"    "+"(x,y)=("+(float)((range_of_X*i)/259)+","+(float)fx((range_of_X*i)/259)+")");
                                            g.drawLine(p_position_X, p_position_Y, n_position_X, n_position_Y);
                                            p_position_X=n_position_X ;
                                            p_position_Y=n_position_Y ;
                                            /*if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_X/259)*i)), 260+i, 260);
                                            }
                                            if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_Y/259)*i)), 260, 260-i);
                                            }*/
                                        }
                                        else{
                                            n_position_X=260+i ;
                                            n_position_Y=(int)((260-((259*fx((range_of_X*i)/259))/range_of_Y))) ;
                                            //System.out.println("259*fx((range_of_X*i)/259)) = "+(259*fx((range_of_X*i)/259)));
                                            //System.out.println("(259*fx((range_of_X*i)/259))/range_of_Y = "+(259*fx((range_of_X*i)/259))/range_of_Y);
                                            //System.out.println(n_position_X+","+n_position_Y);
                                            //System.out.println("(px,py)=("+(p_position_X-260)+","+(260-p_position_Y)+")"+"    "+"(nx,ny)=("+(n_position_X-260)+","+(260-n_position_Y)+")"+"    "+"(x,y)=("+(float)((range_of_X*i)/259)+","+(float)fx((range_of_X*i)/259)+")");
                                            g.drawLine(p_position_X, p_position_Y, n_position_X, n_position_Y);
                                            p_position_X=n_position_X ;
                                            p_position_Y=n_position_Y ;
                                            /*if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_X*i)/259)), 260+i, 260);

                                            }
                                            if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_Y/259)*i)), 260, 260-i);
                                            }*/
                                        }
                                    }
                                    p_position_X=260+0 ; p_position_Y=(int)(260-((259*fx((range_of_X*0)/259))/range_of_Y)) ;
                                    for(int i=-1;i>=-259;i-=1){
                                        if(fx(range_of_X/i)>=0){
                                            n_position_X=260+(i) ;
                                            n_position_Y=(int)(260-((259*fx((range_of_X*i)/259))/range_of_Y)) ;
                                            //System.out.println("259*fx((range_of_X*i)/259)) = "+(259*fx((range_of_X*i)/259)));
                                            //System.out.println("(259*fx((range_of_X*i)/259))/range_of_Y = "+(259*fx((range_of_X*i)/259))/range_of_Y);
                                            //System.out.println(n_position_X+","+n_position_Y);
                                            //System.out.println("(px,py)=("+(p_position_X-260)+","+(260-p_position_Y)+")"+"    "+"(nx,ny)=("+(n_position_X-260)+","+(260-n_position_Y)+")"+"    "+"(x,y)=("+(float)((range_of_X*i)/259)+","+(float)fx((range_of_X*i)/259)+")");
                                            g.drawLine(p_position_X, p_position_Y, n_position_X, n_position_Y);
                                            p_position_X=n_position_X ;
                                            p_position_Y=n_position_Y ;
                                            /*if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_X*i)/259)), 260+i, 260);

                                            }
                                            if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_Y/259)*i)), 260, 260-i);
                                            }*/
                                        }
                                        else{
                                            n_position_X=260+(i) ;
                                            n_position_Y=(int)((260-((259*fx((range_of_X*i)/259))/range_of_Y))) ;
                                            //System.out.println("259*fx((range_of_X*i)/259)) = "+(259*fx((range_of_X*i)/259)));
                                            //System.out.println("(259*fx((range_of_X*i)/259))/range_of_Y = "+(259*fx((range_of_X*i)/259))/range_of_Y);
                                            //System.out.println(n_position_X+","+n_position_Y);
                                            //System.out.println("(px,py)=("+(p_position_X-260)+","+(260-p_position_Y)+")"+"    "+"(nx,ny)=("+(n_position_X-260)+","+(260-n_position_Y)+")"+"    "+"(x,y)=("+(float)((range_of_X*i)/259)+","+(float)fx((range_of_X*i)/259)+")");
                                            g.drawLine(p_position_X, p_position_Y, n_position_X, n_position_Y);
                                            p_position_X=n_position_X ;
                                            p_position_Y=n_position_Y ;
                                            /*if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_X*i)/259)), 260+i, 260);

                                            }
                                            if(i%30 ==0){
                                                g.drawString(Integer.toString((int)((range_of_Y/259)*i)), 260, 260-i);
                                            }*/
                                        }
                                    }
                                 }
                            }
                        } ;
                        test.setLayout(null);
                        panelDown_in_graphPad.add(test) ;
                        test.setBounds(0, 0, 519, 519);
    }
    goForGraphWindow() {
        JLabel JLabel_after_playTheGaph_by_point=new JLabel() ;
        JLabel_after_playTheGaph_by_point.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel_after_playTheGaph_by_point.setForeground(Color.GREEN) ;
        JLabel_after_playTheGaph_by_point.setBounds(130, 490, 400, 30);
        
        JLabel_playTheGraph.setToolTipText("Click to plot graph");
        SpinnerNumberModel SpinnerNoModel ;
        JLabel_equation.setForeground(Color.getHSBColor((float)1.0, (float)0.90, (float)0.80));
        JLabel_equation.setFont(new Font("arial", Font.BOLD, 13));
        JLabel_equation_afterPlay.setForeground(Color.getHSBColor((float)0.35, (float)0.90, (float)0.50));
        JLabel_equation_afterPlay.setFont(new Font("arial", Font.BOLD, 13));
        graph_window=new JFrame() ;
        goForSecondWindow.second_user_details_window.setVisible(false);
        EquaGRAPH.status_second_window=3 ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(graph_window, "GraphPad"+" || "+EquaGRAPH.project_name+" || "+"Version>>"+EquaGRAPH.project_version+" || "+EquaGRAPH.contact_in_title, 550, 600, false, new handleImage_c().returnImageOfTheUrl_m("graph_logo4_4.png"), (EquaGRAPH.userScreenWidth/2)-275, (EquaGRAPH.userScreenHeight/2)-300, JFrame.EXIT_ON_CLOSE, true);
        graph_window.setLayout(null);
        
        JTabbedPane tabbedPanel_graph_pad=new JTabbedPane() ;
        graph_window.add(tabbedPanel_graph_pad) ;
        tabbedPanel_graph_pad.setBounds(0, 0, 550, 600);
        
       JTabbedPane tabbedPanel_set_parameter=new JTabbedPane() ;
        tabbedPanel_set_parameter.setBounds(0, 0, 550, 600);
        
        panel_for_graphPad=new JPanel() ;
        panel_for_graphPad.setLayout(null);
        panelUp_in_graphPad=new JPanel() ;
        panelUp_in_graphPad.setLayout(null);
        panel_for_setEquation=new JPanel() ;
        panel_for_setEquation.setLayout(null);
        panel_for_setEquation.setBackground(Color.GRAY);
        
        JPanel JPanel_for_setParameters=new JPanel() ;
        JPanel_for_setParameters.setLayout(null);
        JPanel_for_setParameters.add(tabbedPanel_set_parameter) ;
        
        JPanel JPanel_for_setPoints=new JPanel() ;
        JPanel_for_setPoints.setBackground(Color.GRAY);
        JPanel_for_setPoints.setLayout(null);
        
        tabbedPanel_graph_pad.addTab("Set Parameters", JPanel_for_setParameters);
        tabbedPanel_graph_pad.addTab("GRAPH Pad", panel_for_graphPad) ;
        
        tabbedPanel_set_parameter.addTab("Set Equation", panel_for_setEquation);
        tabbedPanel_set_parameter.addTab("Set Points", JPanel_for_setPoints);
  /*******************************************************************************************************************************/
        /* code for JPanel_for_setPoints */
        
        JLabel JLabel_playTheGraph_byPoint=new  JLabel() ;
        
        JLabel label_for_user_name_in_setPoint=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_for_user_name_in_setPoint, "Hey "+user_first_name+" !", 550, 20, 1, 0, Color.WHITE, new Font("arial", Font.BOLD, 15), null);
        JPanel_for_setPoints.add(label_for_user_name_in_setPoint) ;
        
        JLabel JLabel_about_in_setEquation_in_setPont=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_about_in_setEquation_in_setPont, null, 40, 40, 490, 0, Color.yellow, null, "about.png");
        JLabel_about_in_setEquation_in_setPont.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel_for_setPoints.add(JLabel_about_in_setEquation_in_setPont) ;
        JLabel_about_in_setEquation_in_setPont.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    aboutEquaGraphWindow_m() ;
                }
        });
        JLabel jl_in_setPoint=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(jl_in_setPoint, "About Programmer", 130, 20, 430, 35, Color.CYAN, new Font("Arial", Font.ITALIC, 11), null);
        JPanel_for_setPoints.add(jl_in_setPoint) ;
        
        JLabel JLabel_request_X_Y_points=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_request_X_Y_points,"Kindly provide (x,y) points through which graph has to be plotted", 500, 20, 1, 46, Color.WHITE, new Font("Arial", Font.BOLD, 15), null);
        JPanel_for_setPoints.add(JLabel_request_X_Y_points) ;
        
        JLabel JLabel_register_point=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_register_point, "Register point X : ", 102, 20, 5, 85, Color.WHITE, new Font("Arial", Font.BOLD, 12), null);
        JPanel_for_setPoints.add(JLabel_register_point) ;
        
        JTextField JTextField_for_X_point=new JTextField() ;
        JTextField_for_X_point.setBounds(108, 85, 100, 20);
        JPanel_for_setPoints.add(JTextField_for_X_point) ;
        JTextField_for_X_point.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar() ;
               
                if( ((c>='0') && (c<='9')) || (c=='-') || (c=='.') ){}
                else{
                    e.consume();
                    
                    //JTextfield_coefficientValue.setText(JTextfield_coefficientValue.getText().substring(0, JTextfield_coefficientValue.getText().length())) ;
                }
            }
        });
        
        JLabel JLabel_andY=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_andY, " and Y : ", 50, 20, 209, 85, Color.WHITE, new Font("Arial", Font.BOLD, 12), null);
        JPanel_for_setPoints.add(JLabel_andY) ;
        
        JTextField JTextField_for_Y_point=new JTextField() ;
        JTextField_for_Y_point.setBounds(260, 85, 100, 20);
        JPanel_for_setPoints.add(JTextField_for_Y_point) ;
        JTextField_for_Y_point.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar() ;
               
                if( ((c>='0') && (c<='9')) || (c=='-') || (c=='.') ){}
                else{
                    e.consume();
                    
                    //JTextfield_coefficientValue.setText(JTextfield_coefficientValue.getText().substring(0, JTextfield_coefficientValue.getText().length())) ;
                }
            }
        });
        
        JComboBox JComboBox_X_Y_points=new JComboBox() ;
        JComboBox_X_Y_points.setBounds(5, 115, 300, 20);
        JPanel_for_setPoints.add(JComboBox_X_Y_points) ;
        
        //float y_temp[]=new float[520] ;
        JButton JButton_add_point=new JButton("Add") ;
        JButton_add_point.addMouseListener(new MouseAdapter() {
            
            
            
            @Override
            public void mouseClicked(MouseEvent e){
                
                try{
                //JComboBox_X_Y_points.addItem("("+Float.parseFloat(JTextField_for_X_point.getText())+","+Float.parseFloat(JTextField_for_Y_point.getText())+")");
                if(no_of_points==0){
                    goForGraphWindow.X[goForGraphWindow.no_of_points]=Float.parseFloat(JTextField_for_X_point.getText()) ;
                    goForGraphWindow.Y[goForGraphWindow.no_of_points]=Float.parseFloat(JTextField_for_Y_point.getText()) ;
                    no_of_points+=1 ;
                }
                else{
                    Float.parseFloat(JTextField_for_X_point.getText()) ;
                    Float.parseFloat(JTextField_for_Y_point.getText()) ;
                    if(arrayHaveTheValue_m(Float.parseFloat(JTextField_for_X_point.getText()))){
                        graph_window.setEnabled(false) ;
                        JFrame jf=new JFrame() ;
                        handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "Warning !!", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                        JPanel jp=new JPanel() ;
                        JLabel jl=new JLabel() ;
                        handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 99, 125, 0, 0, Color.yellow, null, "thinking_boy.png");
                        jp.add(jl) ;
                        JTextArea jtf=new JTextArea(2,20);
                        jtf.setText("Hey "+user_first_name+" ! I have found one more same value of X has been added. If this was by mistake then delete it.");
                        jtf.setFont(new Font("Arial", Font.BOLD, 15)) ;
                        jtf.setLineWrap(true) ;
                        jtf.setWrapStyleWord(true) ;
                        jtf.setEditable(false) ;
                        jp.add(jtf) ;
                        JButton jb=new JButton("Got it !") ;
                        jp.add(jb) ;
                        jb.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e){
                                jf.dispose() ;
                                graph_window.setEnabled(true) ;
                            }
                        });
                        jf.add(jp) ;
                    }
                    //else{
                            goForGraphWindow.X[goForGraphWindow.no_of_points]=Float.parseFloat(JTextField_for_X_point.getText()) ;
                            goForGraphWindow.Y[goForGraphWindow.no_of_points]=Float.parseFloat(JTextField_for_Y_point.getText()) ;
                            no_of_points+=1 ;
                            float tempX,tempY ;
                            for(int i=no_of_points-2;i>=0;i--){
                                if(X[i]>Float.parseFloat(JTextField_for_X_point.getText())){
                                    tempX=X[i+1] ;
                                    X[i+1]=X[i] ;
                                    X[i]=tempX ;

                                    tempY=Y[i+1] ;
                                    Y[i+1]=Y[i] ;
                                    Y[i]=tempY ;
                                }
                                else break ;
                            }
                    //}
                }
                            JLabel_after_playTheGaph_by_point.setText("Graph has been updated with new point. Go to GRAPH pad tab.");
                            JPanel_for_setPoints.repaint() ;
                            JComboBox_X_Y_points.removeAllItems();
                            for(int i=0;i<no_of_points;i++){
                                JComboBox_X_Y_points.addItem("("+X[i]+","+Y[i]+")");
                            }
                            if(no_of_points>=1)
                            JButton_delete_point.setEnabled(true) ;
                            if(no_of_points>=2)
                                JLabel_playTheGraph_byPoint.setEnabled(true) ;
                }catch(NumberFormatException exp){
                    showNumberFormatException(" Somewhere you have entered wrong format of number.") ;
                }
            }
        });
        JButton_add_point.setBounds(375, 85, 80, 20);
        JPanel_for_setPoints.add(JButton_add_point) ;
        
        JButton_delete_point=new JButton("Delete Selected") ;
        JButton_delete_point.setEnabled(false) ;
        JButton_delete_point.setBounds(310, 115, 150, 20);
        JPanel_for_setPoints.add(JButton_delete_point) ;
        JButton_delete_point.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(JButton_delete_point.isEnabled()){
                    if(JComboBox_X_Y_points.getItemCount()-1==0){
                            JButton_delete_point.setEnabled(false) ;
                            JLabel_playTheGraph_byPoint.setEnabled(false) ;
                    }
                    //System.out.println(JComboBox_X_Y_points.getSelectedIndex());
                    for(int i=JComboBox_X_Y_points.getSelectedIndex();i<no_of_points-1;i++){
                        X[i]=X[i+1] ;
                        Y[i]=Y[i+1] ;
                    }
                    JComboBox_X_Y_points.removeItemAt(JComboBox_X_Y_points.getSelectedIndex());
                    no_of_points-=1 ;
                }
            }
        });
        
        
        
        JLabel_playTheGraph_byPoint.setEnabled(false) ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_playTheGraph_byPoint, null, 100, 100, 225, 300, Color.yellow, null, "graph_logo4_4.png");
        JLabel_playTheGraph_byPoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel_for_setPoints.add(JLabel_playTheGraph_byPoint) ;
        JLabel_playTheGraph_byPoint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(JLabel_playTheGraph_byPoint.isEnabled()){
                    which_to_plot=2 ;
                    range_of_Y=range_of_X ;
                    plotTheGraph() ;
                    JTextField_range_of_X.setText(Float.toString(range_of_X));
                    JTextField_range_of_Y.setText(Float.toString(range_of_Y));
                    JTextField_range_of_X.setEnabled(true);
                    JTextField_range_of_Y.setEnabled(true);
                    JPanel_for_setPoints.add(JLabel_after_playTheGaph_by_point) ;
                    JLabel_after_playTheGaph_by_point.setText("Graph has been plotted ! Goto GRAPH pad tab.") ;
                    JPanel_for_setPoints.repaint();
                    goForGraphWindow.panelDown_in_graphPad.repaint() ;
                }
            }
        });
        
  /*******************************************************************************************************************************/
        /*  code for panel_for_setEquation */
        JLabel label_for_user_name=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_for_user_name, "Hey "+user_first_name+" !", 550, 20, 1, 0, Color.WHITE, new Font("arial", Font.BOLD, 15), null);
        panel_for_setEquation.add(label_for_user_name) ;
        
        JLabel JLabel_about_in_setEquation=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_about_in_setEquation, null, 40, 40, 490, 0, Color.yellow, null, "about.png");
        JLabel_about_in_setEquation.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel_for_setEquation.add(JLabel_about_in_setEquation) ;
        JLabel_about_in_setEquation.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    aboutEquaGraphWindow_m() ;
                }
        });
        JLabel jl=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, "About Programmer", 130, 20, 430, 35, Color.CYAN, new Font("Arial", Font.ITALIC, 11), null);
        panel_for_setEquation.add(jl) ;
        
        JLabel label_for_equation_input=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_for_equation_input, "Kindly set the equation of which graph has to be plotted", 550, 20, 1, 45, Color.WHITE, new Font("arial", Font.BOLD, 15), null);
        panel_for_setEquation.add(label_for_equation_input) ;
        
        JLabel JLabel_info_of_powered_X=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_info_of_powered_X, null, 20, 20, 190, 77, null, null, "i_sign.png");
        JLabel_info_of_powered_X.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel_info_of_powered_X.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    whatIsPoweredXWindow_m() ;
                }
        });
        panel_for_setEquation.add(JLabel_info_of_powered_X) ;
        
        JLabel JLabel_set=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_set, "Set", 20, 20, 1, 85, Color.WHITE, new Font("arian", Font.BOLD, 12), null);
        panel_for_setEquation.add(JLabel_set) ;
        
        SpinnerNoModel=new SpinnerNumberModel(1, 1, 10, 1) ;
        JSpinner_noOfPoweredX_in_setEquation=new JSpinner(SpinnerNoModel) ;
        panel_for_setEquation.add(JSpinner_noOfPoweredX_in_setEquation) ;
        JSpinner_noOfPoweredX_in_setEquation.setBounds(30, 85, 50, 20);
        
        JLabel JLabel_powered_X=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_powered_X, "powered X term(s)", 129, 20, 82, 85, Color.WHITE, new Font("arian", Font.BOLD, 12), null);
        panel_for_setEquation.add(JLabel_powered_X) ;
        
        JButton button_setNoOfPoweredX=new JButton("Set Value") ;
        button_setNoOfPoweredX.addMouseListener(new MouseAdapter() {
            
            
            
            @Override
            public void mouseClicked(MouseEvent e){
                goForGraphWindow.set_value_is_clicked=1 ;
                //if(){}
                JComboBox_poweredX.removeAllItems();
                noOfPoweredX=(int)JSpinner_noOfPoweredX_in_setEquation.getValue() ;
                //ln(noOfPoweredX);
                for(int i=0;i<noOfPoweredX;i++){
                    JComboBox_poweredX.addItem("X^"+i);
                    JComboBox_poweredX.repaint() ;
                }
                for(int k=0;k<10;k++){
                    coefficientValues[k]=0 ;
                }
                JLabel_equation.setText("Y = ");
                for(int i=0;i<noOfPoweredX;i++){
                    if(coefficientValues[i]>=0){
                        JLabel_equation.setText(JLabel_equation.getText()+"+");
                    }
                    JLabel_equation.setText(JLabel_equation.getText()+coefficientValues[i]+" X^"+i+"  ");
                }
                JTextfield_coefficientValue.setEnabled(true);
                JComboBox_plus_minus.setEnabled(true);
                button_setCoefficientValue.setEnabled(true);
                JLabel_playTheGraph.setEnabled(true);
                JLabel_done_playTheGraph.setEnabled(false);
                JLabel_equation_afterPlay.setText(null);
                JTextField_range_of_X.setEnabled(false);
                JTextField_range_of_Y.setEnabled(false);
                JLabel_after_playTheGaph_by_point.setText(null);
                panel_for_setEquation.repaint() ;
                panelDown_in_graphPad.removeAll();
            }
        });
        button_setNoOfPoweredX.setBounds(235, 85, 88, 20);
        panel_for_setEquation.add(button_setNoOfPoweredX) ;
        
        
        String JComboBox_poweredX_components ;
        
        JLabel JLabel_coefficient_of=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_coefficient_of, "Coefficient of", 78, 20, 1, 115, Color.WHITE, new Font("arian", Font.BOLD, 12), null);
        panel_for_setEquation.add(JLabel_coefficient_of) ;
        
        JComboBox_poweredX=new JComboBox() ;
        panel_for_setEquation.add(JComboBox_poweredX) ;
        JComboBox_poweredX.setBounds(80, 115, 60, 20);
        JComboBox_poweredX.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goForGraphWindow.JTextfield_coefficientValue.setText(null);
            }
        });
        
        JLabel JLabel_equals_to=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_equals_to, "equals to", 52, 20, 151, 115, Color.WHITE, new Font("arian", Font.BOLD, 12), null);
        panel_for_setEquation.add(JLabel_equals_to) ;
        
        JComboBox_plus_minus=new JComboBox() ;
        JComboBox_plus_minus.setEnabled(false);
        JComboBox_plus_minus.addItem('+');
        JComboBox_plus_minus.addItem('-');
        JComboBox_plus_minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        JComboBox_plus_minus.setBounds(215, 115, 50, 20);
        panel_for_setEquation.add(JComboBox_plus_minus) ;
        
        JTextfield_coefficientValue=new JTextField() ;
        JTextfield_coefficientValue.setEnabled(false);
        handleTextField_c.makeThisTextFieldiLkeMyWay_m(JTextfield_coefficientValue, 90, 20, 270, 115, null, null);
        JTextfield_coefficientValue.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseAdapter e){}
        });
        panel_for_setEquation.add(JTextfield_coefficientValue) ;
        JTextfield_coefficientValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar() ;
               
                if((c>='0') && (c<='9') || c=='.'){}
                else{
                    e.consume();
                    
                    //JTextfield_coefficientValue.setText(JTextfield_coefficientValue.getText().substring(0, JTextfield_coefficientValue.getText().length())) ;
                }
            }
        });
        
        button_setCoefficientValue=new JButton("Set Coefficient Value") ;
        button_setCoefficientValue.setEnabled(false);
        button_setCoefficientValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    if(Float.parseFloat(JTextfield_coefficientValue.getText())==0 && (char)JComboBox_plus_minus.getSelectedItem()=='-'){
                        showNumberFormatException("At the same time -ve and 0 are not allowed ! Correct it !") ;
                    }
                    else {
                            try{
                                coefficientValues[JComboBox_poweredX.getSelectedIndex()]=Float.parseFloat(JTextfield_coefficientValue.getText())  ;
                            }catch(NumberFormatException ex){
                                goForGraphWindow.showNumberFormatException(" Somewhere you have entered wrong format of number.") ;
                            }
                            if((char)JComboBox_plus_minus.getSelectedItem()=='-'){
                                coefficientValues[JComboBox_poweredX.getSelectedIndex()] *= -1 ;
                            }
                            JLabel_equation.setText("Y = ");
                            //System.out.println(noOfPoweredX);
                            for(int i=0;i<noOfPoweredX;i++){
                                if(coefficientValues[i]>=0){
                                    JLabel_equation.setText(JLabel_equation.getText()+"+");
                                }
                                JLabel_equation.setText(JLabel_equation.getText()+coefficientValues[i]+" X^"+i+"  ");
                            }
                    }
              }catch(NumberFormatException ex){
                  goForGraphWindow.showNumberFormatException(" Somewhere you have entered wrong format of number.") ;
              }
            }
        });
        button_setCoefficientValue.setBounds(361, 115, 155, 20);
        panel_for_setEquation.add(button_setCoefficientValue) ;
        
        JPanel jpn=new JPanel() ;
        JScrollPane JScrollPane_equation_display=new JScrollPane(jpn) ;
        JScrollPane_equation_display.setBounds(1, 135, 540, 50);
        panel_for_setEquation.add(JScrollPane_equation_display) ;
        JScrollPane_equation_display.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jpn.setBackground(Color.getHSBColor((float)0.5, (float)0.0, (float)0.60));
        //JScrollPane_equation_display.setVerticalScrollBarPolicy(JScrollPane_equation_display.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollPane_equation_display.getViewport().add(jpn) ;
        jpn.add(JLabel_equation) ;
        jpn.repaint() ;
        JScrollPane_equation_display.repaint() ;
        
        JLabel_playTheGraph=new JLabel() ;
        JLabel_playTheGraph.setEnabled(false);
        handleJLabel_c.makeThisJLabelLikeMyWay_m(JLabel_playTheGraph, null, 100, 100, 225, 300, null, null, "graph_logo4_4.png");
        JLabel_playTheGraph.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel_for_setEquation.add(JLabel_playTheGraph) ;
        
        JPanel jpn2=new JPanel() ;
        JScrollPane JScrollPane_equation_display_afterPlay=new JScrollPane(jpn2) ;
        JScrollPane_equation_display_afterPlay.setBounds(21, 420, 520, 50);
        panel_for_setEquation.add(JScrollPane_equation_display_afterPlay) ;
        JScrollPane_equation_display_afterPlay.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jpn2.setBackground(Color.getHSBColor((float)0.5, (float)0.0, (float)0.60));
        JScrollPane_equation_display_afterPlay.getViewport().add(jpn2) ;
        jpn2.add(JLabel_equation_afterPlay) ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(goForGraphWindow.JLabel_done_playTheGraph, null, 20, 20, 0, 420, null, null, "done.png");
        panel_for_setEquation.add(JLabel_done_playTheGraph) ;
        JLabel_done_playTheGraph.setEnabled(false);
        
        JLabel_playTheGraph.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(goForGraphWindow.JLabel_playTheGraph.isEnabled()){
                    which_to_plot=1 ;
                    /*
                    JLabel kl=new JLabel(JLabel_equation.getText()) ;
                    goForGraphWindow.panelDown_in_graphPad.add(kl) ;
                    kl.setBounds(10, 10, 100, 100);
                    goForGraphWindow.panelDown_in_graphPad.repaint(); */


                    JLabel_done_playTheGraph.setEnabled(true);
                    goForGraphWindow.JLabel_equation_afterPlay.setText(JLabel_equation.getText());
                    range_of_Y=range_of_X;
                    plotTheGraph();
                    JTextField_range_of_X.setText(Float.toString(range_of_X));
                    JTextField_range_of_Y.setText(Float.toString(range_of_Y));
                    JTextField_range_of_X.setEnabled(true);
                    JTextField_range_of_Y.setEnabled(true);
                    panel_for_setEquation.add(JLabel_after_playTheGaph_by_point) ;
                    JLabel_after_playTheGaph_by_point.setText("Graph has been plotted ! Goto GRAPH pad tab.") ;
                    panel_for_setEquation.repaint() ;
                    goForGraphWindow.panelDown_in_graphPad.repaint() ;
                    //goForGraphWindow.panelDown_in_graphPad.removeAll();
                }
            }
        });
        
        
        
  /*****************************************************************************************************************************/
        /*  code for panel_for_graphPad */
        
        JTextField_range_of_X=new JTextField() ;
        JTextField_range_of_X.setEnabled(false);
        panel_for_graphPad.add(JTextField_range_of_X) ;
        JTextField_range_of_X.setBounds(97, 0, 100, 20);
        JTextField_range_of_X.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char ch=e.getKeyChar() ;
                if((ch<'0' || ch>'9') && ch!='.') {
                    e.consume() ;
                }
                else if(((ch>='0' && ch<='9') || ch=='.'|| e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)  && JTextField_range_of_X.getText()!=null){
                    try{
                        if(Float.parseFloat(JTextField_range_of_X.getText()+e.getKeyChar())!=0)
                            range_of_X=Float.parseFloat(JTextField_range_of_X.getText()+e.getKeyChar()) ;
                        else{
                            JFrame jf=new JFrame() ;
                            handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "Caution !!", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                            JPanel jp=new JPanel() ;
                            jf.add(jp) ;
                            JLabel jl=new JLabel() ;
                            handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 99, 123, 0, 0, Color.yellow, null, "not_happy_boy.png");
                            jp.add(jl) ;
                            JTextArea jta=new JTextArea(2,20) ;
                            jta.setText("Sorry "+user_first_name+" ! Range of X can't be zero.");
                            jta.setEditable(false);
                            jta.setFont(new Font("Arial", Font.BOLD, 15));
                            jta.setLineWrap(true);
                            jta.setWrapStyleWord(true);// setWrapStyleWord will work if setLineWrap is true there
                            jp.add(jta) ;
                            jf.setVisible(true);
                            graph_window.setEnabled(false);
                            JButton jb=new JButton("Got it !") ;
                            jp.add(jb) ;
                            jb.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jf.dispose();
                                    graph_window.setEnabled(true);
                                }
                            });
                            jf.add(jp) ;
                        }
                    }catch(NumberFormatException exp){
                        showNumberFormatException(" Somewhere you have entered wrong format of number.") ;
                    }
                    plotTheGraph() ;
                    goForGraphWindow.panelDown_in_graphPad.repaint() ;
                }
            }
        });
        JTextField_range_of_Y=new JTextField() ;
        JTextField_range_of_Y.setEnabled(false);
        panel_for_graphPad.add(JTextField_range_of_Y) ;
        JTextField_range_of_Y.setBounds(314, 0, 100, 20);
        JTextField_range_of_Y.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char ch=e.getKeyChar() ;
                if((ch<'0' || ch>'9') && ch!='.'){
                    e.consume() ;
                }
                else if(((ch>='0' && ch<='9') || ch=='.'|| e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) && JTextField_range_of_Y.getText()!=null){
                    try{
                        if(Float.parseFloat(JTextField_range_of_Y.getText()+e.getKeyChar())!=0)
                            range_of_Y=Float.parseFloat(JTextField_range_of_Y.getText()+e.getKeyChar()) ;
                        else{
                            JFrame jf=new JFrame() ;
                            handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "Caution !!", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                            JPanel jp=new JPanel() ;
                            jf.add(jp) ;
                            JLabel jl=new JLabel() ;
                            handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 99, 123, 0, 0, Color.yellow, null, "not_happy_boy.png");
                            jp.add(jl) ;
                            JTextArea jta=new JTextArea(2,20) ;
                            jta.setText("Sorry "+user_first_name+" ! Range of Y can't be zero.");
                            jta.setEditable(false);
                            jta.setFont(new Font("Arial", Font.BOLD, 15));
                            jta.setLineWrap(true);
                            jta.setWrapStyleWord(true);// setWrapStyleWord will work if setLineWrap is true there
                            jp.add(jta) ;
                            jf.setVisible(true);
                            graph_window.setEnabled(false);
                            JButton jb=new JButton("Got it !") ;
                            jp.add(jb) ;
                            jb.addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jf.dispose();
                                    graph_window.setEnabled(true);
                                }
                            });
                            jf.add(jp) ;
                        }
                    }catch(NumberFormatException exp){
                        showNumberFormatException(" Somewhere you have entered wrong format of number.") ;
                    }
                    plotTheGraph() ;
                    goForGraphWindow.panelDown_in_graphPad.repaint() ;
                }
            }
        });
        
        panelUp_in_graphPad.setBounds(0, 0, 550, 20);
        panelUp_in_graphPad.setBackground(Color.getHSBColor((float)0.52, (float)0.70, (float)0.70));
        panel_for_graphPad.add(panelUp_in_graphPad) ;
        JLabel label_in_panelUp=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_in_panelUp, "Range of X axis : ", 97, 15, 0, 0, Color.WHITE, new Font("arial",Font.BOLD,12), null);
        panelUp_in_graphPad.add(label_in_panelUp) ;
        
        JLabel label_2_in_panelUp=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_2_in_panelUp, "Range of Y axis : ", 97, 15, 217, 0, Color.WHITE, new Font("arial",Font.BOLD,12), null);
        panelUp_in_graphPad.add(label_2_in_panelUp) ;
        
        panelDown_in_graphPad=new JPanel() ;
        panelDown_in_graphPad.setLayout(null);
        panel_for_graphPad.add(panelDown_in_graphPad) ;
        panelDown_in_graphPad.setBackground(Color.getHSBColor((float)0.40, (float)0.70, (float)0.90)) ;
        panelDown_in_graphPad.setBounds(10, 23, 520, 520);
        
        
        
        
        
        //for(int j=0;j<){}
        
        graph_window.repaint() ;
    }
}
class goForSecondWindow{
    static JFrame second_user_details_window ;
    private static JTextField user_first_name_tf ;
    private static JTextField user_last_name_tf ;
    goForSecondWindow(){
        EquaGRAPH.main_welcome_window.setVisible(false);
        //EquaGRAPH.main_welcome_window.show(false);
        EquaGRAPH.status_first_welcome_window=3 ;
        second_user_details_window=new JFrame();
        EquaGRAPH.status_second_window=1 ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(second_user_details_window, ("UserDetails"+" || "+EquaGRAPH.project_name+" || "+"Version>>"+EquaGRAPH.project_version+" || "+EquaGRAPH.contact_in_title), 600, 200, false, new handleImage_c().returnImageOfTheUrl_m("graph_logo4_4.png"), (EquaGRAPH.userScreenWidth/2)-300, (EquaGRAPH.userScreenHeight/2)-100, JFrame.EXIT_ON_CLOSE, true);
        EquaGRAPH.status_second_window=2 ;
        
        JPanel panel_in_second_window=new JPanel() ;
        panel_in_second_window.setLayout(null);
        panel_in_second_window.setBounds(0, 0, 600, 200);
        panel_in_second_window.setBackground(Color.gray);
        second_user_details_window.add(panel_in_second_window) ;
        
        JLabel jlabel1_in_second_window=new JLabel() ;
        panel_in_second_window.add(jlabel1_in_second_window) ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(jlabel1_in_second_window, "Kindly provide these following informations for future interaction", 590, 20, 1, 0, Color.WHITE, new Font("arial", Font.BOLD, 13),null);
        
        
        JTextField user_first_name_tf=new JTextField() ;
        JTextField user_last_name_tf=new JTextField() ;
        handleTextField_c.makeThisTextFieldiLkeMyWay_m(user_first_name_tf, 290, 20, 5, 25, "Enter your First Name Here", null);
        handleTextField_c.makeThisTextFieldiLkeMyWay_m(user_last_name_tf, 280, 20, 310, 25, "Enter your Last Name Here", null);
        
        user_first_name_tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                //System.out.println(""+user_first_name_tf.getText());
                char ch=e.getKeyChar() ;
                if( (ch<'A') || (ch>'z') || (ch>'Z' && ch<'a') ){
                    e.consume();
                }
                else{
                    if(user_first_name_tf.getText().equals("Enter your First Name Here") ){
                        user_first_name_tf.setText("") ;
                    }
                }
            }
        });
        user_last_name_tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                char ch=e.getKeyChar() ;
                if( (ch<'A') || (ch>'z') || (ch>'Z' && ch<'a') ){
                    e.consume();
                }
                else{
                    if(user_last_name_tf.getText().equals("Enter your Last Name Here") ){
                        user_last_name_tf.setText("") ;
                    }
                }
            }
        });
        
        panel_in_second_window.add(user_first_name_tf) ;
        panel_in_second_window.add(user_last_name_tf) ;
        
        JButton goto_graph_window_jb=new JButton("Save & Continue >>") ;
        panel_in_second_window.add(goto_graph_window_jb) ;
        goto_graph_window_jb.setBounds(410, 140, 155, 20);
        goto_graph_window_jb.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(!user_first_name_tf.getText().equals("Enter your First Name Here") && !user_last_name_tf.getText().equals("Enter your Last Name Here") && !user_first_name_tf.getText().equals("") && !user_last_name_tf.getText().equals("")){
                    goForGraphWindow.user_first_name=user_first_name_tf.getText() ;
                    goForGraphWindow.user_last_name=user_last_name_tf.getText() ;
                    new goForGraphWindow() ;
                }
                else{
                    JFrame jf=new JFrame() ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(jf, "Caution !!", 500, 240, false, null, (EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-120, JFrame.DO_NOTHING_ON_CLOSE, true);
                    JPanel jp=new JPanel() ;
                    jf.add(jp) ;
                    JLabel jl=new JLabel() ;
                    handleJLabel_c.makeThisJLabelLikeMyWay_m(jl, null, 99, 123, 0, 0, Color.yellow, null, "not_happy_boy.png");
                    jp.add(jl) ;
                    JTextArea jta=new JTextArea(2,20) ;
                    jta.setText("Sorry dear user ! You haven't entered your name ! Your name is required for future interaction.");
                    jta.setEditable(false);
                    jta.setFont(new Font("Arial", Font.BOLD, 15));
                    jta.setLineWrap(true);
                    jta.setWrapStyleWord(true);// setWrapStyleWord will work if setLineWrap is true there
                    jp.add(jta) ;
                    jf.setVisible(true);
                    second_user_details_window.setEnabled(false);
                    JButton jb=new JButton("Got it !") ;
                    jp.add(jb) ;
                    jb.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jf.dispose();
                            second_user_details_window.setEnabled(true);
                        }
                    });
                    jf.add(jp) ;
                }
            }
        });
        
    }
}
class sleepingAndWorking_c implements Runnable{
    static int sleep_over=0 ;
    @Override
    public void run(){
                JFrame middle_of_1_2_jf=new JFrame("Loading... || equaGRAPH || Version > 1.0.0 || fb.com/likeanupam") ;
                middle_of_1_2_jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                middle_of_1_2_jf.setResizable(false);
                middle_of_1_2_jf.setVisible(true);
                middle_of_1_2_jf.setMinimumSize(new Dimension(500, 500));
                middle_of_1_2_jf.setLocation((EquaGRAPH.userScreenWidth/2)-250, (EquaGRAPH.userScreenHeight/2)-250);
                middle_of_1_2_jf.add(new JLabel(new handleImage_c().returnImageIconOfTheUrl_m("loading.gif"))) ;
        //try{Thread.sleep(5000);}catch(Exception e){}
        //sleep_over=1 ;
    }
}
public class EquaGRAPH {
    static String project_version="Beta",project_name="equaGRAPH",contact_in_title="fb.com/likeanupam";
    static JFrame main_welcome_window=new JFrame() ;
    static int status_first_welcome_window=1 ;
    static int status_second_window=0 ;
    static int userScreenHeight=0 ;
    static int userScreenWidth=0 ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphWindow graphwindow=new GraphWindow() ;
        graphwindow.show(true);
        // TODO code application logic here
        Toolkit tool_kit=Toolkit.getDefaultToolkit() ;
        userScreenHeight=tool_kit.getScreenSize().height ;
        userScreenWidth=tool_kit.getScreenSize().width ;
        handleJFrame_c.makeThisWindowLikeMyWay_m(main_welcome_window, ("Welcome"+" || "+project_name+" || "+"Version>>"+project_version+" || "+contact_in_title), 550, 200, false, new handleImage_c().returnImageOfTheUrl_m("graph_logo4_4.png"), (userScreenWidth/2)-275, (userScreenHeight/2)-100, JFrame.EXIT_ON_CLOSE, true);
        status_first_welcome_window=2 ;
        main_welcome_window.setLayout(null);
        
        JPanel panel_at_main_welcome_window=new JPanel() ;
        panel_at_main_welcome_window.setBackground(Color.getHSBColor((float)0.0, (float)0.08, (float)1.0));
        main_welcome_window.add(panel_at_main_welcome_window) ;
        panel_at_main_welcome_window.setLayout(null);
        panel_at_main_welcome_window.setBounds(0, 0, 550, 200);
        
        JLabel label_for_welcome_guy=new JLabel(new handleImage_c().returnImageIconOfTheUrl_m("welcome_boy.png")) ;
        panel_at_main_welcome_window.add(label_for_welcome_guy) ;
        label_for_welcome_guy.setBounds(30, 1, 110, 120);
        
        JLabel label_for_welcome_note=new JLabel(new handleImage_c().returnImageIconOfTheUrl_m("welcome.png")) ;
        panel_at_main_welcome_window.add(label_for_welcome_note) ;
        label_for_welcome_note.setBounds(50, 1, 490, 100);
        
        JLabel label_welcome_details=new JLabel() ;
        handleJLabel_c.makeThisJLabelLikeMyWay_m(label_welcome_details, "Hi ! This is equaGRAPH (Beta). "+" Plot your desired Equation into a Graph !", 540, 30, 6, 105, Color.BLUE,new Font("Comic Sans MS",Font.PLAIN,15),null);
        panel_at_main_welcome_window.add(label_welcome_details) ;
        panel_at_main_welcome_window.repaint() ;
        //label_welcome_details.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        
        JButton first_window_to_second_b=new JButton("Yes ! Lets go >>") ;
        first_window_to_second_b.setToolTipText("Enter to equaGRAPH");
        panel_at_main_welcome_window.add(first_window_to_second_b) ;
        first_window_to_second_b.setBounds(200, 140, 150, 20);
        first_window_to_second_b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent eve){
                /*
                (new Thread(new sleepingAndWorking_c())).start();
                try{
                    Thread.sleep(5000);
                }catch(Exception e){}*/
                new goForSecondWindow();
            }
        });
    }
    
}