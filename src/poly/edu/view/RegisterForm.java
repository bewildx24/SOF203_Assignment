package poly.edu.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import poly.edu.model.User;
import poly.edu.service.impl.UserService;
import poly.edu.utility.ContactHelper;
import poly.edu.utility.DialogHelper;
import view.LoginForm;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class RegisterForm extends javax.swing.JFrame {

    UserService us = new UserService();
    DialogHelper dialogHelper = new DialogHelper();
    ContactHelper contactHelper = new ContactHelper();

    public RegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void signUpMethod() {
        User user = new User();
        String password = new String(txt_password.getPassword());
        String repassword = new String(txt_repassword.getPassword());
        boolean checkUser = false, checkPass = false, checkRepass = false, checkVaitro = false;
        if (txt_username.getText().isEmpty()) {
            lbl_errUser.setText("Không được để trống!");
            txt_username.requestFocus();
            return;
        } else {
            lbl_errUser.setText(" ");
            user.setUsername(txt_username.getText());
            checkUser = true;
        }
        if (password.isEmpty()) {
            lbl_errPass.setText("Không được để trống!");
            txt_password.requestFocus();
            return;
        } else if (!repassword.equals(password)) {
            lbl_errRePass.setText("Xác nhận mật khẩu không khớp!");
            lbl_errPass.setText(" ");
            txt_repassword.requestFocus();
        } else {
            lbl_errRePass.setText(" ");
            user.setPassword(password);
            checkPass = true;
            checkRepass = true;
        }

        if (txt_vaitro.getText().isEmpty()) {
            lbl_errVaitro.setText("Không được để trống!");
            txt_vaitro.requestFocus();
        } else if (!txt_vaitro.getText().equalsIgnoreCase("Giảng viên") && !txt_vaitro.getText().equalsIgnoreCase("Đào tạo")) {
            lbl_errVaitro.setText("Vui lòng nhập 'Giảng viên' hoặc 'Đào tạo'!");
            txt_vaitro.requestFocus();
        } else {
            if (txt_vaitro.getText().equals("Giảng viên")) {
                user.setVaitro(1);
            } else {
                user.setVaitro(0);
            }
            checkVaitro = true;
            lbl_errVaitro.setText(" ");
        }
        if (checkUser && checkPass && checkRepass && checkVaitro && chk_dieukhoan.isSelected()) {
            if (us.getOne(txt_username.getText()) != null) {
                lbl_errUser.setText("Tên đăng nhập đã tồn tại");
                dialogHelper.alert(this, "Tên đăng nhập đã tồn tại!");
                return;
            } else {
                us.addUser(user);
                dialogHelper.alert(this, "Đăng ký thành công!");
            }

            chk_dieukhoan.setForeground(Color.white);
            if (us.getAll().size() == 0) {
                us.addUser(user);

                dialogHelper.alert(this, "Đăng ký thành công!");
            }
        } else {
            chk_dieukhoan.setForeground(Color.yellow);
        }

    }

    private void pressKey(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            signUpMethod();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        lbl_title1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_signup = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_errUser = new javax.swing.JLabel();
        lbl_errPass = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_errRePass = new javax.swing.JLabel();
        txt_repassword = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_errVaitro = new javax.swing.JLabel();
        txt_vaitro = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        chk_dieukhoan = new javax.swing.JCheckBox();
        lbl_returnDangNhap = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập hệ thống");
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(79, 37, 64));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("WELCOME TO SIGN UP FORM");

        lbl_title1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title1.setText("Vu Nguyen Huong");
        lbl_title1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_title1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_title1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(197, 89, 83));

        txt_username.setBackground(new java.awt.Color(197, 89, 83));
        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(null);
        txt_username.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usernameKeyPressed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(197, 89, 83));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(null);
        txt_password.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        btn_signup.setBackground(new java.awt.Color(197, 89, 83));
        btn_signup.setForeground(new java.awt.Color(255, 255, 255));
        btn_signup.setText("Sign up");
        btn_signup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_signup.setFocusPainted(false);
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_24px_1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_24px_1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SIGN UP");

        lbl_errUser.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_errUser.setForeground(new java.awt.Color(255, 255, 255));
        lbl_errUser.setText(" ");

        lbl_errPass.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_errPass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_errPass.setText(" ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_reset_24px.png"))); // NOI18N

        lbl_errRePass.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_errRePass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_errRePass.setText(" ");

        txt_repassword.setBackground(new java.awt.Color(197, 89, 83));
        txt_repassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_repassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_repassword.setBorder(null);
        txt_repassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_repassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_repasswordActionPerformed(evt);
            }
        });
        txt_repassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_repasswordKeyPressed(evt);
            }
        });

        lbl_errVaitro.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_errVaitro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_errVaitro.setText(" ");

        txt_vaitro.setBackground(new java.awt.Color(197, 89, 83));
        txt_vaitro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_vaitro.setForeground(new java.awt.Color(255, 255, 255));
        txt_vaitro.setBorder(null);
        txt_vaitro.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_vaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vaitroActionPerformed(evt);
            }
        });
        txt_vaitro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vaitroKeyPressed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_people_24px.png"))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên đăng nhập");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Vai trò");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Xác nhận mật khẩu");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mật khẩu");

        chk_dieukhoan.setBackground(new java.awt.Color(197, 89, 83));
        chk_dieukhoan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        chk_dieukhoan.setForeground(new java.awt.Color(255, 255, 255));
        chk_dieukhoan.setText("Đồng ý điều khoản sử dụng");
        chk_dieukhoan.setBorder(null);
        chk_dieukhoan.setFocusPainted(false);

        lbl_returnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbl_returnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbl_returnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_return_24px.png"))); // NOI18N
        lbl_returnDangNhap.setText("Bạn đã có tài khoản ? Đăng nhập tại đây");
        lbl_returnDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_returnDangNhapMouseClicked(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(197, 89, 83));
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancel");
        btn_cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_cancel.setFocusPainted(false);
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_errUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_errVaitro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_vaitro, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_errPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_returnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chk_dieukhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_repassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lbl_errRePass, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_errUser))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_vaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbl_errVaitro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_errPass))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txt_repassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_errRePass)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_dieukhoan)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_returnDangNhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_username.getAccessibleContext().setAccessibleName("");
        txt_username.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed

    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed

    }//GEN-LAST:event_txt_passwordActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        signUpMethod();
    }//GEN-LAST:event_btn_signupActionPerformed

    private void lbl_title1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_title1MouseClicked
        contactHelper.contact("https://facebook.com/VuNguyenHuong.Official");
    }//GEN-LAST:event_lbl_title1MouseClicked

    private void txt_usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyPressed
        pressKey(evt);
    }//GEN-LAST:event_txt_usernameKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        pressKey(evt);
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_repasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_repasswordActionPerformed

    }//GEN-LAST:event_txt_repasswordActionPerformed

    private void txt_repasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_repasswordKeyPressed
        pressKey(evt);
    }//GEN-LAST:event_txt_repasswordKeyPressed

    private void lbl_returnDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_returnDangNhapMouseClicked
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_returnDangNhapMouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void txt_vaitroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vaitroKeyPressed
        pressKey(evt);
    }//GEN-LAST:event_txt_vaitroKeyPressed

    private void txt_vaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vaitroActionPerformed

    }//GEN-LAST:event_txt_vaitroActionPerformed

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_signup;
    private javax.swing.JCheckBox chk_dieukhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_errPass;
    private javax.swing.JLabel lbl_errRePass;
    private javax.swing.JLabel lbl_errUser;
    private javax.swing.JLabel lbl_errVaitro;
    private javax.swing.JLabel lbl_returnDangNhap;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_title1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JPasswordField txt_repassword;
    private javax.swing.JTextField txt_username;
    private javax.swing.JTextField txt_vaitro;
    // End of variables declaration//GEN-END:variables
}
