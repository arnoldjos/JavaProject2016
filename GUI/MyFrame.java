package GUI;
import LOGIC.EmployeeList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.*;
import javax.swing.table.*;
public class MyFrame extends JFrame implements ActionListener
{
    protected EmployeeList list = new EmployeeList();
    int id;
    protected JButton homeMenu,addMenu,editMenu,deleteMenu,exitMenu,submit,submit2,reset,reset2,delete_delete_button,edit_edit_button;
    
    protected JPanel up,nav,cards,cards2,addpanel_weekly,addpanel_hourly,add_pw,add_ph,time_panel,
    homepanel,editpanel,deletepanel,left_sidebar,right_sidebar,radio_panel,logo_panel,home_logo_panel,
    main_add_panel,blank,button_pnl,button_pnl2,edit_panel,sub_edit_panel,sub_edit_panel2,sub_edit_panel3,all_emp_panel,all_hourly_panel,all_weekly_panel,
    delete_panel,sub_delete_panel,sub_delete_panel2,sub_delete_panel3,main_edit_panel,main_delete_panel;
    
    protected JRadioButton hourly_radio,weekly_radio;
    protected ButtonGroup radio;
    
    protected JTextField firstname_text,lastname_text,job_title_text,hourly_rate_text,delete_firstname_text,
    delete_lastname_text,delete_jt_text,delete_et_text,
    hours_worked_text,weekly_rate_text,weekly_firstname_text,weekly_lastname_text,
    weekly_job_title_text,edit_firstname_text,edit_lastname_text,edit_jt_text;
    
    protected JLabel firstname_label,lastname_label,job_title_label,hourly_rate_label,logo_label,time_label,
    hours_worked_label,weekly_rate_label,weekly_firstname_label,weekly_lastname_label,home_logo,
    weekly_job_title_label,delete_firstname_label,delete_lastname_label,edit_firstname_label,edit_lastname_label,edit_jt_label,delete_jt_label,delete_et_label;
    
    protected JComboBox<String> edit_box,delete_box;
    protected JTable tableemployee, tablehourly,tableweekly;
    protected DefaultTableModel model,model2,model3;
    protected JScrollPane scroll,scroll2,scroll3;
    JPanel panel4 = new JPanel();
    protected DateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy h:m:ss a");;
    protected Date resultdate;
    String[] array;
    protected Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);   

      
    public MyFrame(String title)
    {
        super("title");
        setLayout(new BorderLayout());
        up = new JPanel(new BorderLayout());
        nav = new JPanel(new GridLayout(1,6,2,2));
        logo_panel = new JPanel(new BorderLayout());
        home_logo_panel = new JPanel(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();


        time_panel = new JPanel();
        
        time_label = new JLabel();
        
        //up.setPreferredSize(new Dimension(1000,75));
        ImageIcon image = new ImageIcon("jpindus.png");
        logo_label = new JLabel("", image, JLabel.CENTER);
        logo_panel.setBackground(new Color(59,89,152));
        logo_panel.add(logo_label, BorderLayout.CENTER);
        logo_panel.setPreferredSize(new Dimension(200,50));
        
        ImageIcon homelogo = new ImageIcon("homelogo.png");
        home_logo = new JLabel("", homelogo, JLabel.CENTER);
        home_logo_panel.setBackground(new Color(109,107,107));
        home_logo_panel.add(home_logo, BorderLayout.CENTER);
        
        
        model = new DefaultTableModel();
        model.addColumn("Employee Number");
        model.addColumn("Lastname");
        model.addColumn("Firstname");
        model.addColumn("Job Title");
        model.addColumn("Employee Type");
        tableemployee = new JTable(model);
        tableemployee.setBackground(Color.white);
       
        tableemployee.setDefaultEditor(Object.class, null);
        scroll = new JScrollPane(tableemployee);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setPreferredSize(new Dimension(650,200));   
         
        
        model2 = new DefaultTableModel();
        model2.addColumn("Employee Number");
        model2.addColumn("Lastname");
        model2.addColumn("Firstname");
        model2.addColumn("Job Title");
        model2.addColumn("Weekly Pay");
        tablehourly = new JTable(model2);
        tablehourly.setBackground(Color.white);
       
        tablehourly.setDefaultEditor(Object.class, null);
        scroll2 = new JScrollPane(tablehourly);
        scroll2.setBorder(BorderFactory.createEmptyBorder());
        scroll2.setPreferredSize(new Dimension(650,200));  
        
        model3 = new DefaultTableModel();
        model3.addColumn("Employee Number");
        model3.addColumn("Lastname");
        model3.addColumn("Firstname");
        model3.addColumn("Job Title");
        model3.addColumn("Weekly Pay");
        tableweekly = new JTable(model3);
        tableweekly.setBackground(Color.white);
       
        tableweekly.setDefaultEditor(Object.class, null);
        scroll3 = new JScrollPane(tableweekly);
        scroll3.setBorder(BorderFactory.createEmptyBorder());
        scroll3.setPreferredSize(new Dimension(650,200));  
        
        
        time_panel = new JPanel(new BorderLayout());
        showTime();
        
        
        Toolkit tk = Toolkit.getDefaultToolkit();  
         int xSize = ((int) tk.getScreenSize().getWidth());  
         int ySize = ((int) tk.getScreenSize().getHeight());  
        left_sidebar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        int h = (int)(Math.round(ySize * 40.0/100));
        int w = (int)(Math.round(xSize * 40.0/100));
        left_sidebar.setPreferredSize(new Dimension(h, w));
        left_sidebar.setBackground(new Color(109,107,107));
        right_sidebar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        right_sidebar.setPreferredSize(new Dimension(h,w));
        right_sidebar.setBackground(new Color(109,107,107));        
        homepanel = new JPanel(new BorderLayout());
        homepanel.add(home_logo_panel,BorderLayout.CENTER);
        
        radio_panel = new JPanel(new FlowLayout());
        main_add_panel = new JPanel(new GridBagLayout());
        blank = new JPanel(new FlowLayout());
        
        addpanel_weekly = new JPanel();
        addpanel_hourly = new JPanel();
        add_pw = new JPanel();
        add_ph = new JPanel();
        addpanel_weekly.setLayout(new BoxLayout(addpanel_weekly,BoxLayout.PAGE_AXIS));
        addpanel_hourly.setLayout(new BoxLayout(addpanel_hourly,BoxLayout.PAGE_AXIS));
        edit_panel = new JPanel(new GridLayout(3,1));
        main_edit_panel = new JPanel(new GridBagLayout());
        main_delete_panel = new JPanel(new GridBagLayout());        
        delete_panel = new JPanel(new GridLayout(3,1));
        
        edit_box = new JComboBox<>();
        delete_box = new JComboBox<>();
        
        all_emp_panel = new JPanel(new FlowLayout());
        all_emp_panel.add(scroll);
        all_hourly_panel = new JPanel(new FlowLayout());
        all_hourly_panel.add(scroll2);
        all_weekly_panel = new JPanel(new FlowLayout());
        all_weekly_panel.add(scroll3);
        
        sub_edit_panel = new JPanel(new GridLayout(3,0));
        sub_edit_panel2 = new JPanel(new GridLayout(4,1));
        sub_edit_panel3 = new JPanel(new FlowLayout());
        sub_delete_panel = new JPanel(new GridLayout(3,0));
        sub_delete_panel2 = new JPanel(new GridLayout(4,1));
        sub_delete_panel3 = new JPanel(new FlowLayout());
        button_pnl = new JPanel(new FlowLayout());
        button_pnl2 = new JPanel(new FlowLayout());
        cards = new JPanel(new CardLayout());
        cards2 = new JPanel(new CardLayout());
        homeMenu = new JButton("Home");
        addMenu = new JButton("Add");
        editMenu = new JButton("Edit");
        deleteMenu = new JButton("Delete");
        exitMenu = new JButton("Exit");
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        submit2 = new JButton("Submit");
        reset2 = new JButton("Reset");
        delete_delete_button = new JButton("Delete");
        edit_edit_button = new JButton("Edit");
        firstname_text = new JTextField(15);
        weekly_firstname_text = new JTextField(15);
        lastname_text = new JTextField(15);
        weekly_lastname_text = new JTextField(15);
        job_title_text = new JTextField(15);
        weekly_job_title_text = new JTextField(15);
        weekly_rate_text = new JTextField(15);
        hourly_rate_text = new JTextField(15);
        hours_worked_text = new JTextField(10);
        edit_firstname_text = new JTextField(15);
        edit_lastname_text = new JTextField(15);
        edit_jt_text = new JTextField(15);
        
        
        delete_firstname_text = new JTextField(15);
        delete_firstname_text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
        delete_firstname_text.setEditable(false);
        delete_lastname_text = new JTextField(15);
        delete_lastname_text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
        delete_lastname_text.setEditable(false);
        delete_jt_text = new JTextField(15);        
        delete_jt_text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
        delete_jt_text.setEditable(false);
        delete_et_text = new JTextField(15);          
        delete_et_text.setBorder(BorderFactory.createLineBorder(new Color(238,238,238)));
        delete_et_text.setEditable(false);
        
        hours_worked_label = new JLabel("Work Hours");
        hourly_rate_label = new JLabel("Hourly Rate");
        firstname_label = new JLabel("Firstname ");
        weekly_firstname_label = new JLabel("Firstname ");
        lastname_label = new JLabel("Lastname ");
        edit_firstname_label = new JLabel("Firstname ");
        edit_lastname_label = new JLabel("Lastname ");
        edit_jt_label = new JLabel("Job Title ");
        delete_et_label = new JLabel("Employee Type :");
        delete_firstname_label = new JLabel("Firstname :");
        delete_lastname_label = new JLabel("Lastname :");
        delete_jt_label = new JLabel("Job Title :");
        weekly_lastname_label = new JLabel("Lastname ");
        job_title_label = new JLabel("Job Title ");
        weekly_job_title_label = new JLabel("Job Title ");
        weekly_rate_label = new JLabel("Weekly Salary");
        radio = new ButtonGroup();
        hourly_radio = new JRadioButton("Hourly Employee");
        hourly_radio.setFocusPainted(false);
        weekly_radio = new JRadioButton("Weekly Employee");
        weekly_radio.setFocusPainted(false);
        JMenuBar menubar = new JMenuBar();
        JMenu displayMenu = new JMenu("Display Employees");
        
        JMenuItem all_emp = new JMenuItem("All Employees");
        JMenuItem all_hourly = new JMenuItem("All Hourly");
        JMenuItem all_weekly = new JMenuItem("All Salary");
        menubar.setBackground(new Color(59,89,152));
        nav.setBackground(new Color(59,89,152));
        panel4.setLayout(new GridLayout(0,1)); 
        menubar.setBorderPainted(false); 

        homeMenu.setForeground(Color.WHITE);
        homeMenu.setFocusPainted(false);
        homeMenu.setBorderPainted(false); 
        homeMenu.setBackground(new Color(59,89,152));
        homeMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addMenu.setForeground(Color.WHITE);
        addMenu.setFocusPainted(false);
        addMenu.setBorderPainted(false); 
        addMenu.setBackground(new Color(59,89,152));
        addMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        editMenu.setFocusPainted(false);
        editMenu.setForeground(Color.WHITE);
        editMenu.setBorderPainted(false); 
        editMenu.setBackground(new Color(59,89,152));
        editMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        deleteMenu.setFocusPainted(false);
        deleteMenu.setForeground(Color.WHITE);
        deleteMenu.setBorderPainted(false); 
        deleteMenu.setBackground(new Color(59,89,152));
        deleteMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        displayMenu.setForeground(Color.WHITE);
        displayMenu.setFocusPainted(false);
        displayMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        all_emp.setFont(new Font("Tahoma", Font.PLAIN, 15));
        all_hourly.setFont(new Font("Tahoma", Font.PLAIN, 15));
        all_weekly.setFont(new Font("Tahoma", Font.PLAIN, 15));
        exitMenu.setFocusPainted(false);
        exitMenu.setForeground(Color.WHITE);
        exitMenu.setBorderPainted(false); 
        exitMenu.setBackground(new Color(59,89,152));
        exitMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        radio.add(hourly_radio);
        radio.add(weekly_radio);
        radio_panel.add(hourly_radio);
        radio_panel.add(weekly_radio);
        
        addpanel_weekly.add(weekly_firstname_label);
        addpanel_weekly.add(weekly_firstname_text);
        addpanel_weekly.add(weekly_lastname_label);
        addpanel_weekly.add(weekly_lastname_text);
        addpanel_weekly.add(weekly_job_title_label);
        addpanel_weekly.add(weekly_job_title_text);
        addpanel_weekly.add(weekly_rate_label);
        addpanel_weekly.add(weekly_rate_text);
        add_pw.add(addpanel_weekly);
        
        addpanel_hourly.add(firstname_label);
        addpanel_hourly.add(firstname_text);
        addpanel_hourly.add(lastname_label);
        addpanel_hourly.add(lastname_text);
        addpanel_hourly.add(job_title_label);
        addpanel_hourly.add(job_title_text);
        addpanel_hourly.add(hourly_rate_label);
        addpanel_hourly.add(hourly_rate_text);
        addpanel_hourly.add(hours_worked_label);
        addpanel_hourly.add(hours_worked_text);        
        add_ph.add(addpanel_hourly);
        
        button_pnl.add(submit);
        button_pnl.add(reset);
        button_pnl.setVisible(false);
        button_pnl2.add(submit2);
        button_pnl2.add(reset2);
        button_pnl2.setVisible(false);
        
        sub_edit_panel.add(edit_box);
        sub_edit_panel2.add(edit_firstname_label);
        sub_edit_panel2.add(edit_firstname_text);
        sub_edit_panel2.add(edit_lastname_label);
        sub_edit_panel2.add(edit_lastname_text);
        sub_edit_panel2.add(edit_jt_label);
        sub_edit_panel2.add(edit_jt_text);
        sub_edit_panel3.add(edit_edit_button);
        edit_panel.add(sub_edit_panel);
        edit_panel.add(sub_edit_panel2);
        edit_panel.add(sub_edit_panel3);
        
        sub_delete_panel.add(delete_box);        
        sub_delete_panel2.add(delete_firstname_label);
        sub_delete_panel2.add(delete_firstname_text);
        sub_delete_panel2.add(delete_lastname_label);
        sub_delete_panel2.add(delete_lastname_text);
        sub_delete_panel2.add(delete_jt_label);
        sub_delete_panel2.add(delete_jt_text);
        sub_delete_panel2.add(delete_et_label);
        sub_delete_panel2.add(delete_et_text);
        sub_delete_panel3.add(delete_delete_button);
        delete_panel.add(sub_delete_panel);
        delete_panel.add(sub_delete_panel2);
        delete_panel.add(sub_delete_panel3);
        
        displayMenu.add(all_emp);
        displayMenu.add(all_hourly);
        displayMenu.add(all_weekly);
        menubar.add(displayMenu);
        up.add(logo_panel,BorderLayout.LINE_START);
        nav.add(homeMenu);
        nav.add(addMenu);
        nav.add(editMenu);
        nav.add(deleteMenu);
        nav.add(menubar);
        nav.add(exitMenu);
        nav.add(time_panel);
        
        
        
        cards.add(homepanel,"Homepanel");
      
        cards2.add(add_pw,"Weekly Employee");
        cards2.add(add_ph,"Hourly Employee");
        cards2.add(blank,"Blank");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,100,0);
        main_add_panel.add(radio_panel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,100,0);
        main_add_panel.add(cards2,c);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        main_add_panel.add(button_pnl,c);
        main_add_panel.add(button_pnl2,c);
       
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,100,0);
        main_edit_panel.add(edit_panel,c);
     
        sub_edit_panel3.setVisible(false);
       
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,100,0);
        main_delete_panel.add(delete_panel,c);
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,100,0);
        
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);

        sub_delete_panel3.setVisible(false);
        cards.add(main_add_panel,"Grid");
        cards.add(all_emp_panel,"Allemployee");
        cards.add(all_hourly_panel,"Allhourly");
        cards.add(all_weekly_panel,"Allweekly");
        cards.add(main_edit_panel,"Editpanel");
        cards.add(main_delete_panel,"Deletepanel");
        
        up.add(nav);
        up.setBackground(new Color(59,89,152));
        homeMenu.addActionListener(this);
        addMenu.addActionListener(this);
        editMenu.addActionListener(this);
        all_emp.addActionListener(this);
        all_hourly.addActionListener(this);
        all_weekly.addActionListener(this);
        
        submit.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent b)
                        {
                            firstname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            lastname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            job_title_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            hourly_rate_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            hours_worked_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));                  
                            
                            String fn = firstname_text.getText();
                            String ln = lastname_text.getText();
                            String job = job_title_text.getText();
                            String rate = hourly_rate_text.getText();
                            String hrs = hours_worked_text.getText();
                            if(fn==null||fn.isEmpty()||fn.equals(" ")||fn.matches(".*\\d+.*")|| p.matcher(fn).find())
                            {
                                if(fn==null||fn.isEmpty()||fn.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Firstname field is required!");
                                }
                                else
                                {
                                     JOptionPane.showMessageDialog(null,"Invalid Firstname entry!");
                                }
                                firstname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                firstname_text.requestFocus();
                            }
                            else if(ln==null||ln.isEmpty()||ln.equals(" ")||ln.matches(".*\\d+.*")|| p.matcher(ln).find())
                            {
                                if(ln==null||ln.isEmpty()||ln.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Lastname field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Lastname entry!");
                                }
                                lastname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                lastname_text.requestFocus();
                            }
                            else if(job==null||job.isEmpty()||job.equals(" ")||job.matches(".*\\d+.*")|| p.matcher(job).find())
                            {
                                if(job==null||job.isEmpty()||job.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Job Title field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Job Title entry!");
                                }
                                job_title_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                job_title_text.requestFocus();
                            }
                            else if(rate==null||rate.isEmpty()||rate.contains(" ")||rate.equals(" ")||!rate.matches(".*\\d+.*")||rate.contains("[a-zA-Z]+")|| p.matcher(fn).find() || Double.parseDouble(rate) <= 0)
                            {
                                if(rate.contains("[a-zA-Z]+"))
                                {
                                if(Double.parseDouble(rate) <= 0)
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Hourly Rate entry!");
                                }
                                }
                                
                                if(rate==null||rate.isEmpty()||rate.contains(" ")||rate.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Hourly Rate field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Hourly Rate entry!");
                                }
                                
                                hourly_rate_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                hourly_rate_text.requestFocus();
                            }
                            else if(hrs==null||hrs.isEmpty()||hrs.contains(" ")||hrs.equals(" ")||!hrs.matches(".*\\d+.*")||hrs.contains("[a-zA-Z]+")|| p.matcher(fn).find() || Double.parseDouble(hrs) <= 0)
                            {
                               
                                if(hrs.contains("[a-zA-Z]+"))
                                {
                                if(Double.parseDouble(hrs) <= 0)
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Work Hours entry!");
                                }
                                }
                                
                                if(hrs==null||hrs.isEmpty()||hrs.contains(" ")||hrs.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Work Hours field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Work Hours entry!");
                                }
                                
                                hours_worked_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                hours_worked_text.requestFocus();
                            }
                            else
                            {
                                list.addHourly(fn,ln,job,rate,hrs);
                                JOptionPane.showMessageDialog(null,"Successfully Submitted!");
                          
                                resetText();
                            }
                            
                        }
                    });
             
        submit2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent b)
                        {
                            weekly_firstname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            weekly_lastname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            weekly_job_title_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            weekly_rate_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                  
                            String fn = weekly_firstname_text.getText();
                            String ln = weekly_lastname_text.getText();
                            String job = weekly_job_title_text.getText();
                            String rate = weekly_rate_text.getText();
                            
                            if(fn==null||fn.isEmpty()||fn.equals(" ")||fn.matches(".*\\d+.*")|| p.matcher(fn).find())
                            {
                                if(fn==null||fn.isEmpty()||fn.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Firstname field is required!");
                                }
                                else
                                {
                                     JOptionPane.showMessageDialog(null,"Invalid Firstname entry!");
                                }
                                weekly_firstname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                weekly_firstname_text.requestFocus();
                            }
                            else if(ln==null||ln.isEmpty()||ln.equals(" ")||ln.matches(".*\\d+.*")|| p.matcher(ln).find())
                            {
                                if(ln==null||ln.isEmpty()||ln.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Lastname field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Lastname entry!");
                                }
                                weekly_lastname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                weekly_lastname_text.requestFocus();
                            }
                            else if(job==null||job.isEmpty()||job.equals(" ")||job.matches(".*\\d+.*")|| p.matcher(job).find())
                            {
                                if(job==null||job.isEmpty()||job.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Job Title field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Job Title entry!");
                                }
                                weekly_job_title_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                weekly_job_title_text.requestFocus();
                            }
                            else if(rate==null||rate.isEmpty()||rate.contains(" ")||rate.equals(" ")||!rate.matches(".*\\d+.*")||rate.contains("[a-zA-Z]+")|| p.matcher(fn).find() || Double.parseDouble(rate) <= 0)
                            {
                                if(rate.contains("[a-zA-Z]+"))
                                {
                                if(Double.parseDouble(rate) <= 0)
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Weekly Salary entry!");
                                }
                                }
                                if(rate==null||rate.isEmpty()||rate.contains(" ")||rate.equals(" "))
                                {
                                    JOptionPane.showMessageDialog(null,"Weekly Salary field is required!");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Invalid Weekly Salary entry!");
                                }
                                weekly_rate_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                weekly_rate_text.requestFocus();
                            }
                            else
                            {
                                 list.addSalary(fn,ln,job,rate);
                                 JOptionPane.showMessageDialog(null,"Successfully Submitted!");
                                 resetText();
                            }
                           
                        }
                    });
                    
        edit_edit_button.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent c)
                        {
                            edit_firstname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            edit_lastname_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            edit_jt_text.setBorder(BorderFactory.createLineBorder(new Color(122,138,153)));
                            
                            String fn = edit_firstname_text.getText();
                            String ln = edit_lastname_text.getText();
                            String job = edit_jt_text.getText();
                            
                          
                                if(fn==null||fn.isEmpty()||fn.equals(" ")||fn.matches(".*\\d+.*")|| p.matcher(fn).find())
                                {
                                    if(fn==null||fn.isEmpty()||fn.equals(" "))
                                    {
                                        JOptionPane.showMessageDialog(null,"Firstname field is required!");
                                    }
                                    else
                                    {
                                         JOptionPane.showMessageDialog(null,"Invalid Firstname entry!");
                                    }
                                    edit_firstname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                    edit_firstname_text.requestFocus();
                                }
                                else if(ln==null||ln.isEmpty()||ln.equals(" ")||ln.matches(".*\\d+.*")|| p.matcher(ln).find())
                                {
                                    if(ln==null||ln.isEmpty()||ln.equals(" "))
                                    {
                                        JOptionPane.showMessageDialog(null,"Lastname field is required!");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,"Invalid Lastname entry!");
                                    }
                                    edit_lastname_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                    edit_lastname_text.requestFocus();
                                }
                                else if(job==null||job.isEmpty()||job.equals(" ")||job.matches(".*\\d+.*")|| p.matcher(job).find())
                                {
                                    if(job==null||job.isEmpty()||job.equals(" "))
                                    {
                                        JOptionPane.showMessageDialog(null,"Job Title field is required!");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,"Invalid Job Title entry!");
                                    }
                                   edit_jt_text.setBorder(BorderFactory.createLineBorder(Color.red));
                                   edit_jt_text.requestFocus();
                                }
                                else if(list.edit(id,fn,ln,job))
                                {
                                    JOptionPane.showMessageDialog(null,"Successfully Edited");
                                    resetText();
                                    edit_edit_button.setVisible(false);
                                    sub_edit_panel.removeAll();
                                    sub_edit_panel.add(edit_box = new JComboBox<>());
                                      
                                    CardLayout cardlayout2 = (CardLayout)cards.getLayout();          
                                    cardlayout2.show(cards,"Editpanel");
    
                                      array = new String[list.getEmployeeList().size()];          
                                      for(int i = 0; i < array.length; i++) 
                                      {
                                          array[i] = list.displayBox(i);
                                          edit_box.addItem(array[i]);
                                      }
             
                                      edit_box.addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e){
                                                String x = edit_box.getSelectedItem().toString();
                                                edit_edit_button.setVisible(true);
                                                String[] value = x.split(" ");
                                                String ids = value[0];              
                                                id = Integer.parseInt(ids);
                                                edit_firstname_text.setText(list.forFname(id));
                                                edit_lastname_text.setText(list.forLname(id));
                                                edit_jt_text.setText(list.forJobTitle(id));  
                                                sub_edit_panel3.setVisible(true);
                                                ids = null;
                                                x = null;
                                                value = null;
                                                
                                                array = new String[list.getEmployeeList().size()];          
                                                          
                                                    }
                                       });
                              
                            }
                        }
                    });
                    
        delete_delete_button.addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent c)
                        {   
                            if(list.getEmployeeList().isEmpty()==true)
                            {
                              JOptionPane.showMessageDialog(null,"Empty List!");  
                              CardLayout cardlayout = (CardLayout)cards.getLayout();          
                              cardlayout.show(cards,"Homepanel");
                            }
                            else
                            {
                                if(list.delete(id)){
                                    JOptionPane.showMessageDialog(null,"Successfully Deleted");
                                    delete_delete_button.setVisible(false);
                                    resetText();
                                    if(list.getEmployeeList().isEmpty()==true)
                                    {
                                      JOptionPane.showMessageDialog(null,"Empty List!");  
                                      CardLayout cardlayout = (CardLayout)cards.getLayout();          
                                      cardlayout.show(cards,"Homepanel");
                                    }
                                    else
                                    {
                                      sub_delete_panel.removeAll();
                                      sub_delete_panel.add(delete_box = new JComboBox<>());
                                      
                                      CardLayout cardlayout = (CardLayout)cards.getLayout();          
                                      cardlayout.show(cards,"Deletepanel");
                                      
                                          array = new String[list.getEmployeeList().size()];          
                                          for(int i = 0; i < array.length; i++) 
                                          {
                                              array[i] = list.displayBox(i);
                                              delete_box.addItem(array[i]);
                                          }
                                             
                                          delete_box.addActionListener(new ActionListener(){
                                                        public void actionPerformed(ActionEvent e){

                                                            String x = delete_box.getSelectedItem().toString();
                                                            delete_delete_button.setVisible(true);

                                                            String[] value = x.split(" ");
                                                            String ids = value[0];
              
                                                            id = Integer.parseInt(ids);
                                                            delete_firstname_text.setText(list.forFname(id));
                                                            delete_lastname_text.setText(list.forLname(id));
                                                            delete_jt_text.setText(list.forJobTitle(id)); 
                                                            delete_et_text.setText(list.forEtype(id));
                                                            sub_delete_panel3.setVisible(true);
                                                            ids = null;
                                                            x = null;
                                                            value = null;
                                                            
                                                            array = new String[list.getEmployeeList().size()];                  
                                                        }
                                                    });
                                     }
                                }
                            }
                        }
                    });
                    
        reset.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent b)
                        {
                            resetText();
                        }
                    });
                    
        reset2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent b)
                        {
                            resetText();
                        }
                    });
       
        deleteMenu.addActionListener(this);
        exitMenu.addActionListener(this);
        
        ActionListener sliceActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent a)
            {
                AbstractButton aButton = (AbstractButton) a.getSource();
                
                if(aButton.getText().equals("Hourly Employee"))
                {
                    CardLayout cardlayout = (CardLayout)cards2.getLayout();
                    cardlayout.show(cards2,"Hourly Employee");   
                    resetText();
                    button_pnl.setVisible(true);
                    button_pnl2.setVisible(false);
                }
                else if(aButton.getText().equals("Weekly Employee")){
                    CardLayout cardlayout = (CardLayout)cards2.getLayout();
                    cardlayout.show(cards2,"Weekly Employee");
                    resetText();
                    button_pnl2.setVisible(true);
                    button_pnl.setVisible(false);
                }                 
                }
        } ;
        
        weekly_radio.addActionListener(sliceActionListener);
        hourly_radio.addActionListener(sliceActionListener);
        
        add(left_sidebar,BorderLayout.WEST);
        add(right_sidebar,BorderLayout.EAST);
        add(up,BorderLayout.NORTH);
        add(cards,BorderLayout.CENTER);
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setAlwaysOnTop(false);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String temp = ae.getActionCommand();
        
            if(temp.equals("Home"))
            {
                CardLayout cardlayout = (CardLayout)cards.getLayout();
                cardlayout.show(cards,"Homepanel");     
                resetText();
            }
            else if(temp.equals("Add"))
            {
                radio.clearSelection();
                CardLayout cardlayout =(CardLayout)cards2.getLayout();          
                cardlayout.show(cards2,"Blank"); 
                CardLayout cardlayout2 = (CardLayout)cards.getLayout();          
                cardlayout2.show(cards,"Grid");    
                resetText();
                button_pnl.setVisible(false);
                button_pnl2.setVisible(false);
                  
            }
            else if(temp.equals("Edit"))
            {
                if(list.getEmployeeList().isEmpty()==true)
                  {
                      JOptionPane.showMessageDialog(null,"Empty List!");
                  }
                  else
                  {
                      sub_edit_panel.removeAll();
                      sub_edit_panel.add(edit_box = new JComboBox<>());
                  
                      CardLayout cardlayout2 = (CardLayout)cards.getLayout();          
                      cardlayout2.show(cards,"Editpanel");
                      resetText();
                  
                      edit_edit_button.setVisible(false);

                          array = new String[list.getEmployeeList().size()];          
                          for(int i = 0; i < array.length; i++) 
                          {
                              array[i] = list.displayBox(i);
                              edit_box.addItem(array[i]);
                          }
 
                       edit_box.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    edit_edit_button.setVisible(true);
                                    String x = edit_box.getSelectedItem().toString();

                                    String[] value = x.split(" ");
                                    String ids = value[0];
               
                                    id = Integer.parseInt(ids);
                                    edit_firstname_text.setText(list.forFname(id));
                                    edit_lastname_text.setText(list.forLname(id));
                                    edit_jt_text.setText(list.forJobTitle(id));  
                                    sub_edit_panel3.setVisible(true);
                                    ids = null;
                                    x = null;
                                    value = null;
                                    
                                    array = new String[list.getEmployeeList().size()];          
         
                                }
                            });
                    }
        }
        else if(temp.equals("Delete"))
        {
            if(list.getEmployeeList().isEmpty()==true)
            {
                JOptionPane.showMessageDialog(null,"Empty List!");
            }

            else
            {     
              sub_delete_panel.removeAll();
              sub_delete_panel.add(delete_box = new JComboBox<>());
              
              CardLayout cardlayout = (CardLayout)cards.getLayout();          
              cardlayout.show(cards,"Deletepanel");
              resetText();
              delete_delete_button.setVisible(false);
              array = new String[list.getEmployeeList().size()];          
              for(int i = 0; i < array.length; i++) 
              {
                  array[i] = list.displayBox(i);
                  delete_box.addItem(array[i]);
              }
   
                        delete_box.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    delete_delete_button.setVisible(true);
                                    String x = delete_box.getSelectedItem().toString();
                                    delete_delete_button.setVisible(true);
                                    String[] value = x.split(" ");
                                    String ids = value[0];
              
                                    id = Integer.parseInt(ids);
                                    delete_firstname_text.setText(list.forFname(id));
                                    delete_lastname_text.setText(list.forLname(id));
                                    delete_jt_text.setText(list.forJobTitle(id)); 
                                    delete_et_text.setText(list.forEtype(id));
                                    sub_delete_panel3.setVisible(true);
                                    ids = null;
                                    x = null;
                                    value = null;
                                    
                                    array = new String[list.getEmployeeList().size()];          
         
                                }
                            });  
                        }
        }
        else if(temp.equals("All Employees"))
        {
            if(list.getEmployeeList().isEmpty()==true)
          {
              JOptionPane.showMessageDialog(null,"Empty List!");
          }
          else
          {
            tableemployee.getTableHeader().getColumnModel().getColumn(4).setHeaderValue("Employee Type");
            repaint();

            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            CardLayout cardlayout = (CardLayout)cards.getLayout();          
            cardlayout.show(cards,"Allemployee");
            resetText();

           
           for(int i=0;i<list.getEmployeeList().size();i++){   
               model.addRow(new Object[]{list.childId(i),list.childLname(i),list.childFname(i),list.childJob(i),list.childType(i)}); 
          }
         }
    }
        else if(temp.equals("All Hourly"))
        {
             if(list.getHourlyList().isEmpty()==true)
             {
                 JOptionPane.showMessageDialog(null,"Empty List!");
             }
             else
             {
    
                int rowCount = model2.getRowCount();
                for (int i = rowCount-1; i >= 0; i--) {
                    model2.removeRow(i);
                }
                CardLayout cardlayout = (CardLayout)cards.getLayout();          
                cardlayout.show(cards,"Allhourly");
                resetText();
           
                for(int i=0;i<list.getHourlyList().size();i++)
                {
               model2.addRow(new Object[]{list.childIdHourly(i),list.childLnameHourly(i),list.childFnameHourly(i),list.childJobHourly(i),list.childPayHourly(i)});
                }
            }
        }
        else if(temp.equals("All Salary"))
        {
            if(list.getSalaryList().isEmpty()==true)
            {
                JOptionPane.showMessageDialog(null,"Empty List!");
            }
            else
            {

                int rowCount = model3.getRowCount();
                for (int i = rowCount-1 ; i >= 0; i--) {
                    model3.removeRow(i);
                }
                  CardLayout cardlayout = (CardLayout)cards.getLayout();          
                  cardlayout.show(cards,"Allweekly");
                  resetText();
           
                for(int i=0;i<list.getSalaryList().size();i++)
                {
                    model3.addRow(new Object[]{list.childIdWeekly(i),list.childLnameWeekly(i),list.childFnameWeekly(i),list.childJobWeekly(i),list.childPayWeekly(i)});
                }       
            }
        }
        else if(temp.equals("Exit"))
        {
            System.exit(0);
        }
    }
    
    public void resetText()
    {
        firstname_text.setText("");
        lastname_text.setText("");
        job_title_text.setText("");
        hourly_rate_text.setText("");
        delete_firstname_text.setText("");
        delete_lastname_text.setText("");
        delete_jt_text.setText("");
        delete_et_text.setText("");
        hours_worked_text.setText("");      
        weekly_firstname_text.setText("");
        weekly_lastname_text.setText("");
        weekly_job_title_text.setText("");
        weekly_rate_text.setText("");        
        edit_firstname_text.setText("");
        edit_lastname_text.setText("");
        edit_jt_text.setText("");
        weekly_rate_text.setText("");
        
    }
    
    public void showTime(){

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                time_label.setText(dateFormat.format(new Date()));
                time_label.repaint();
            }
        });
        time_label.setForeground(Color.WHITE);
        time_label.setText(dateFormat.format(new Date()));
        time_panel.setBackground(new Color(59,89,152));
        time_panel.add(time_label,BorderLayout.CENTER);
        timer.start();
    }
}