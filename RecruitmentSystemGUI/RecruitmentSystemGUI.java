import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI implements ActionListener {
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    private JTextField vacancyField, designationField, jobTypeField, nameField;
    private JTextField joinDateField, qualificationField, appointedByField;
    private JCheckBox joinedCheck;
    private JTextField salaryField, hoursField, workingHourField, wagesField, shiftField;
    private JTextArea displayArea;
    private JFrame frame;  // JFrame instance

    public RecruitmentSystemGUI() {
        frame = new JFrame("Staff Recruitment System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Staff Details"));

        vacancyField = new JTextField();
        designationField = new JTextField();
        jobTypeField = new JTextField();
        nameField = new JTextField();
        joinDateField = new JTextField();
        qualificationField = new JTextField();
        appointedByField = new JTextField();
        joinedCheck = new JCheckBox("Joined");

        // FullTime Specific
        salaryField = new JTextField();
        hoursField = new JTextField();

        // PartTime Specific
        workingHourField = new JTextField();
        wagesField = new JTextField();
        shiftField = new JTextField();

        addField(inputPanel, "Vacancy Number:", vacancyField);
        addField(inputPanel, "Designation:", designationField);
        addField(inputPanel, "Job Type:", jobTypeField);
        addField(inputPanel, "Staff Name:", nameField);
        addField(inputPanel, "Joining Date", joinDateField);
        addField(inputPanel, "Qualification", qualificationField);
        addField(inputPanel, "Appointed By", appointedByField);
        inputPanel.add(new JLabel("Joined:"));
        inputPanel.add(joinedCheck);

        // Full-Time Fields
        addField(inputPanel, "Salary (FT):", salaryField);
        addField(inputPanel, "Weekly Hours (FT):", hoursField);

        // Part-Time Fields
        addField(inputPanel, "Working Hours (PT):", workingHourField);
        addField(inputPanel, "Wages/Hour (PT):", wagesField);
        addField(inputPanel, "Shift (PT):", shiftField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addFullTimeBtn = new JButton("Add Full-Time");
        JButton addPartTimeBtn = new JButton("Add Part-Time");
        JButton displayBtn = new JButton("Display Staff");
        JButton clearBtn = new JButton("Clear");

        addFullTimeBtn.addActionListener(this);
        addPartTimeBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        buttonPanel.add(addFullTimeBtn);
        buttonPanel.add(addPartTimeBtn);
        buttonPanel.add(displayBtn);
        buttonPanel.add(clearBtn);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        frame.add(mainPanel);  // Add mainPanel to the JFrame
        frame.setVisible(true);  // Make frame visible
    }

    private void addField(JPanel panel, String label, JComponent field) {
        panel.add(new JLabel(label));
        panel.add(field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "Add Full-Time":
                    addFullTimeStaff();
                    break;
                case "Add Part-Time":
                    addPartTimeStaff();
                    break;
                case "Display Staff":
                    displayStaff();
                    break;
                case "Clear":
                    clearFields();
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addFullTimeStaff() throws NumberFormatException {
        int vacancy = Integer.parseInt(vacancyField.getText());
        double salary = Double.parseDouble(salaryField.getText());
        int hours = Integer.parseInt(hoursField.getText());

        FullTimeStaffHire staff = new FullTimeStaffHire(
                vacancy, designationField.getText(), jobTypeField.getText(),
                nameField.getText(), joinDateField.getText(), qualificationField.getText(),
                appointedByField.getText(), joinedCheck.isSelected(), salary, hours
        );

        staffList.add(staff);
        JOptionPane.showMessageDialog(frame, "Full-Time Staff Added Successfully!");
    }

    private void addPartTimeStaff() throws NumberFormatException {
        int vacancy = Integer.parseInt(vacancyField.getText());
        int workingHours = Integer.parseInt(workingHourField.getText());
        double wages = Double.parseDouble(wagesField.getText());

        PartTimeStaffHire staff = new PartTimeStaffHire(
                vacancy, designationField.getText(), jobTypeField.getText(),
                nameField.getText(), joinDateField.getText(), qualificationField.getText(),
                appointedByField.getText(), joinedCheck.isSelected(), workingHours,
                wages, shiftField.getText()
        );

        staffList.add(staff);
        JOptionPane.showMessageDialog(frame, "Part-Time Staff Added Successfully!");
    }

    private void displayStaff() {
        displayArea.setText("");
        for (StaffHire staff : staffList) {
            StringBuilder sb = new StringBuilder();
            if (staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire ftStaff = (FullTimeStaffHire) staff;
                sb.append("--- Full-Time Details ---\n");
                sb.append("Salary: £").append(String.format("%.2f", ftStaff.getSalary())).append("\n");
                sb.append("Weekly Hours: ").append(ftStaff.getWeeklyFractionalHours()).append(" hrs/week\n");
            } else if (staff instanceof PartTimeStaffHire) {
                PartTimeStaffHire ptStaff = (PartTimeStaffHire) staff;
                sb.append("--- Part-Time Details ---\n");
                sb.append("Working Hours: ").append(ptStaff.getWorkingHours()).append(" hrs/day\n");
                sb.append("Wages/Hour: £").append(String.format("%.2f", ptStaff.getWagesPerHour())).append("\n");
                sb.append("Shift: ").append(ptStaff.getShifts()).append("\n");
                sb.append("Daily Income: £").append(String.format("%.2f", ptStaff.getWorkingHours() * ptStaff.getWagesPerHour())).append("\n");
            }
            sb.append("Vacancy Number: ").append(staff.getVacancyNumber()).append("\n");
            sb.append("Designation: ").append(staff.getDesignation()).append("\n");
            sb.append("Job Type: ").append(staff.getjobType()).append("\n");
            sb.append("Staff Name: ").append(staff.getStaffName()).append("\n");
            sb.append("Joining Date: ").append(staff.getJoiningDate()).append("\n");
            sb.append("Qualification: ").append(staff.getQualification()).append("\n");
            sb.append("Appointed By: ").append(staff.getAppointedBy()).append("\n");
            sb.append("Joined: ").append(staff.getJoined() ? "Yes" : "No").append("\n\n");
            displayArea.append(sb.toString());
        }
    }

    private void clearFields() {
        vacancyField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        nameField.setText("");
        joinDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
    }

    public static void main(String[] args) {
        new RecruitmentSystemGUI();
    }
}
