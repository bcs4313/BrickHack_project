package com.company;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;


public class Manager_Menu {
    String company_name = "Chungus Corp";
    double interest_rate = 0.05;
    double profit = 1000;
    double profit_month = 300;
    private init pointer;
    private Company company_pointer;
    public Manager_Menu(init p, Company cp, String _name, double _interest, double _profit, double _profit_month)
    {
        company_name = _name;
        interest_rate = _interest;
        profit = _profit;
        profit_month = _profit_month;
        constructMM(p, cp);
    }

    public void constructMM(init p, Company cp)
    {
        pointer = p;
        company_pointer = cp;
        GridBagLayout GBCLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JFrame window = new JFrame();
        window.setSize(new Dimension(960,720));
        window.setLayout(GBCLayout);
        window.setVisible(true);

        JLabel companyLabel;
        companyLabel = new JLabel("<html><font size='12' color=blue> Company: " + company_name,SwingConstants.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        window.add(companyLabel, gbc);

        JLabel interestLabel;
        companyLabel = new JLabel("<html><font size='12' color=blue> Interest Rate: " + (interest_rate * 100) + "%",SwingConstants.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        window.add(companyLabel, gbc);

        JLabel currentProfitLabel = new JLabel("<html><font size='12' color=green> Earnings this month: " + profit_month + "$",SwingConstants.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        window.add(currentProfitLabel, gbc);

        JLabel profitLabel = new JLabel("<html><font size='12' color=green> Net Profit: " + profit + "$",SwingConstants.CENTER);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        window.add(profitLabel, gbc);

        // Control Scheme
        JButton nextMonthButton = new JButton("Progress to next Month");
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.4;
        nextMonthButton.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Company comp = pointer.getComp(company_name);
                pointer.nextMonth(comp);
            }
        });
        window.add(nextMonthButton, gbc);
    }
}
