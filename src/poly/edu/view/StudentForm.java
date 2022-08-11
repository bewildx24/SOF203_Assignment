package poly.edu.view;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.Student;
import poly.edu.model.User;
import poly.edu.service.impl.StudentService;
import poly.edu.utility.DialogHelper;
import poly.edu.utility.ImageHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class StudentForm extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    StudentService studentService = new StudentService();
    DialogHelper dialogHelper = new DialogHelper();
    private Integer checkSave = 0;
    private String fileName = "";

    private String getRole(int role){
        if(role == 0){
            return "Đào tạo";
        }else{
            return "Giảng viên";
        }
    }
    
    public StudentForm(User u) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý sinh viên - FPoly");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        loadData();
        getSelectionInterval(0);
        lbl_info.setText("User: " + u.getUsername() + " | Role: " + getRole(u.getVaitro()));
    }
    
    private void getSelectionInterval(int index){
        if (tb_sinhvien.getRowCount() > 0) {
            tb_sinhvien.setRowSelectionInterval(index, index);
            showDetail();
        }
    }

    private String getSex(int gioiTinh) {
        if (gioiTinh == 0) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }

    private void loadData() {
        defaultTableModel = (DefaultTableModel) tb_sinhvien.getModel();
        defaultTableModel.setRowCount(0);

        for (Student x : studentService.getAll()) {
            defaultTableModel.addRow(new Object[]{
                x.getMaSV(), x.getHoTen(), x.getEmail(), x.getSdt(), getSex(x.getGioiTinh()), x.getDiaChi(), x.getHinh()
            });
        }
        lbl_total.setText("Total: " + studentService.getAll().size());
        checkSave = 0;
    }

    private void showDetail() {
        int row = tb_sinhvien.getSelectedRow();
        txt_masv.setText((String) tb_sinhvien.getValueAt(row, 0));
        txt_hoten.setText((String) tb_sinhvien.getValueAt(row, 1));
        txt_email.setText((String) tb_sinhvien.getValueAt(row, 2));
        txt_sdt.setText((String) tb_sinhvien.getValueAt(row, 3));
        if (tb_sinhvien.getValueAt(row, 4).equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        txt_diachi.setText((String) tb_sinhvien.getValueAt(row, 5));

        tb_sinhvien.setRowSelectionAllowed(true);
        txt_masv.disable();

        fileName = (String) tb_sinhvien.getValueAt(row, 6);
        
        File file = new File("src/images/" + tb_sinhvien.getValueAt(row, 6));
        if (file.exists()) {
            ImageIcon icon = new ImageIcon("src/images/" + tb_sinhvien.getValueAt(row, 6));
            Image image = icon.getImage();
            Image imageResize = ImageHelper.resize(image, 150, 187);
            icon = new ImageIcon(imageResize);
            lbl_image.setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon("src/images/addUser.png");
            Image image = icon.getImage();
            Image imageResize = ImageHelper.resize(image, 150, 187);
            icon = new ImageIcon(imageResize);
            lbl_image.setIcon(icon);
        }
    }

    private void clearForm() {
        txt_masv.setText("PH");
        txt_hoten.setText("");
        txt_email.setText("@fpt.edu.vn");
        txt_sdt.setText("0");
        txt_diachi.setText("");
        buttonGroup1.clearSelection();
        ImageIcon icon = new ImageIcon("src/images/addUser.png");
        lbl_image.setIcon(icon);
        tb_sinhvien.setRowSelectionAllowed(false);
        tb_sinhvien.clearSelection();
        txt_masv.enable();
        checkSave = 1;
        fileName = "";
    }

    private boolean checkNullSave() {
        if (txt_masv.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Mã sinh viên");
        } else if (txt_hoten.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Họ tên");
        } else if (txt_email.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Email");
        } else if (txt_sdt.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Số điện thoại");
        } else if (!rd_nam.isSelected() && !rd_nu.isSelected()) {
            dialogHelper.errorNull(this, "Giới tính");
        } else if (txt_diachi.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Địa chỉ");
        } else if (fileName.isEmpty()) {
            dialogHelper.errorNull(this, "Hình ảnh");
        } else {
            return true;
        }
        return false;
    }

    private void addStudent() {
        Student s = new Student();
        if (txt_masv.getText().matches("^PH[0-9]{4,5}$")) {
            s.setMaSV(txt_masv.getText().toUpperCase());
        } else {
            dialogHelper.error(this, "Vui lòng nhập đúng mã SV! Ex: PH27229");
            return;
        }
        s.setHoTen(txt_hoten.getText());
        if (txt_email.getText().matches("^(.+)@(.+)\\.(.+)$")) {
            s.setEmail(txt_email.getText());
        } else {
            dialogHelper.error(this, "Email không đúng định dạng!");
            return;
        }
        if (txt_sdt.getText().matches("^0[0-9]{9,10}$")) {
            s.setSdt(txt_sdt.getText());
        } else {
            dialogHelper.error(this, "Số điện thoại không đúng định dạng!");
            return;
        }
        if (rd_nam.isSelected()) {
            s.setGioiTinh(0);
        } else {
            s.setGioiTinh(1);
        }
        s.setDiaChi(txt_diachi.getText());
        s.setHinh(fileName);
        studentService.add(s);
        loadData();
        clearForm();
        dialogHelper.alert(this, "Thêm thành công!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_sinhvien = new javax.swing.JTable();
        jtg_darkmode = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_sdt = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        btn_logOut = new javax.swing.JButton();
        txt_masv = new javax.swing.JTextField();
        lbl_gioitinh = new javax.swing.JLabel();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        lbl_masv = new javax.swing.JLabel();
        lbl_diachi = new javax.swing.JLabel();
        lbl_hoten = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        txt_hoten = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_total = new javax.swing.JLabel();
        lbl_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(693, 546));
        jPanel1.setPreferredSize(new java.awt.Dimension(693, 546));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        tb_sinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sinhvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_sinhvien);

        jtg_darkmode.setBackground(new java.awt.Color(0, 0, 0));
        jtg_darkmode.setForeground(new java.awt.Color(255, 255, 255));
        jtg_darkmode.setText("DarkMode: OFF");
        jtg_darkmode.setBorderPainted(false);
        jtg_darkmode.setFocusPainted(false);
        jtg_darkmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtg_darkmodeActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), java.awt.Color.red)); // NOI18N

        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addUser.png"))); // NOI18N
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 3, 3));

        btn_new.setBackground(new java.awt.Color(204, 204, 204));
        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_new.setText("New");
        btn_new.setBorderPainted(false);
        btn_new.setDefaultCapable(false);
        btn_new.setFocusPainted(false);
        btn_new.setMaximumSize(new java.awt.Dimension(100, 33));
        btn_new.setMinimumSize(new java.awt.Dimension(100, 33));
        btn_new.setPreferredSize(new java.awt.Dimension(100, 33));
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });
        jPanel2.add(btn_new);

        btn_save.setBackground(new java.awt.Color(204, 204, 204));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.setBorderPainted(false);
        btn_save.setDefaultCapable(false);
        btn_save.setFocusPainted(false);
        btn_save.setMaximumSize(new java.awt.Dimension(100, 33));
        btn_save.setMinimumSize(new java.awt.Dimension(100, 33));
        btn_save.setPreferredSize(new java.awt.Dimension(100, 33));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save);

        btn_update.setBackground(new java.awt.Color(204, 204, 204));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorderPainted(false);
        btn_update.setDefaultCapable(false);
        btn_update.setFocusPainted(false);
        btn_update.setMaximumSize(new java.awt.Dimension(100, 33));
        btn_update.setMinimumSize(new java.awt.Dimension(100, 33));
        btn_update.setPreferredSize(new java.awt.Dimension(100, 33));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update);

        btn_delete.setBackground(new java.awt.Color(204, 204, 204));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorderPainted(false);
        btn_delete.setDefaultCapable(false);
        btn_delete.setFocusPainted(false);
        btn_delete.setMaximumSize(new java.awt.Dimension(100, 33));
        btn_delete.setMinimumSize(new java.awt.Dimension(100, 33));
        btn_delete.setPreferredSize(new java.awt.Dimension(100, 33));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_image)
                        .addGap(79, 79, 79)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), java.awt.Color.red)); // NOI18N

        lbl_sdt.setText("Số điện thoại");

        txt_sdt.setText("0");
        txt_sdt.setMaximumSize(new java.awt.Dimension(10, 22));
        txt_sdt.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_sdt.setPreferredSize(new java.awt.Dimension(10, 22));

        btn_logOut.setBackground(java.awt.Color.red);
        btn_logOut.setForeground(new java.awt.Color(255, 255, 255));
        btn_logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_logout_20px.png"))); // NOI18N
        btn_logOut.setText("LogOut");
        btn_logOut.setBorderPainted(false);
        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });

        txt_masv.setText("PH");
        txt_masv.setMaximumSize(new java.awt.Dimension(10, 22));
        txt_masv.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_masv.setPreferredSize(new java.awt.Dimension(10, 22));

        lbl_gioitinh.setText("Giới tính");

        rd_nam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_nam);
        rd_nam.setText("Nam");
        rd_nam.setFocusPainted(false);

        rd_nu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nữ");
        rd_nu.setFocusPainted(false);

        lbl_masv.setText("Mã SV");

        lbl_diachi.setText("Địa chỉ");

        lbl_hoten.setText("Họ tên");

        txt_diachi.setColumns(20);
        txt_diachi.setLineWrap(true);
        txt_diachi.setRows(5);
        txt_diachi.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_diachi);

        txt_hoten.setMaximumSize(new java.awt.Dimension(10, 22));
        txt_hoten.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_hoten.setPreferredSize(new java.awt.Dimension(10, 22));

        lbl_email.setText("Email");

        txt_email.setText("@gmail.com");
        txt_email.setMaximumSize(new java.awt.Dimension(10, 22));
        txt_email.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_email.setPreferredSize(new java.awt.Dimension(10, 22));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_gioitinh)
                    .addComponent(lbl_diachi)
                    .addComponent(lbl_masv)
                    .addComponent(lbl_hoten)
                    .addComponent(lbl_email)
                    .addComponent(lbl_sdt)
                    .addComponent(btn_logOut))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_masv, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rd_nam)
                        .addGap(18, 18, 18)
                        .addComponent(rd_nu))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_email, txt_hoten, txt_masv, txt_sdt});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_masv)
                        .addGap(13, 13, 13)
                        .addComponent(lbl_hoten)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_email)
                        .addGap(16, 16, 16)
                        .addComponent(lbl_sdt)
                        .addGap(16, 16, 16)
                        .addComponent(lbl_gioitinh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nu)
                            .addComponent(rd_nam))))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_diachi)
                        .addGap(18, 18, 18)
                        .addComponent(btn_logOut))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_email, txt_hoten, txt_masv, txt_sdt});

        lbl_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_total.setForeground(java.awt.Color.red);
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total: 0");

        lbl_info.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_info.setForeground(java.awt.Color.blue);
        lbl_info.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jtg_darkmode))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_info, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_total)))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jtg_darkmode)
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_total)
                            .addComponent(lbl_info))))
                .addGap(687, 687, 687))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (checkSave == 0) {
            dialogHelper.alert(this, "Vui lòng chọn nút New khi muốn thêm mới!");
        } else {
            if (checkNullSave()) {
                if (studentService.getAll().size() == 0) {
                    addStudent();
                } else {
                    if (studentService.getOne(txt_masv.getText()) != null) {
                        dialogHelper.error(this, "Mã sinh viên đã tồn tại!");
                        return;
                    } else {
                        addStudent();
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_sinhvien.getSelectedRow();
        if (row == -1) {
            dialogHelper.error(this, "Vui lòng chọn 1 dòng rồi xóa!");
        } else {
            if (dialogHelper.question(this, "Bạn có chắc muốn xóa " + tb_sinhvien.getValueAt(row, 1) + " ra khỏi danh sách ?")) {
                studentService.delete((String) tb_sinhvien.getValueAt(row, 0));
                loadData();
                clearForm();
                getSelectionInterval(0);
                dialogHelper.alert(this, "Xóa thành công!");
            }
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_sinhvien.getSelectedRow();
        if (row == -1) {
            dialogHelper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            Student s = studentService.getAll().get(row);
            if (checkNullSave()) {
                s.setHoTen(txt_hoten.getText());
                if (txt_email.getText().matches("^(.+)@(.+)\\.(.+)$")) {
                    s.setEmail(txt_email.getText());
                } else {
                    dialogHelper.error(this, "Email không đúng định dạng!");
                    return;
                }
                if (txt_sdt.getText().matches("^0[0-9]{9,10}$")) {
                    s.setSdt(txt_sdt.getText());
                } else {
                    dialogHelper.error(this, "Số điện thoại không đúng định dạng!");
                    return;
                }
                if (rd_nam.isSelected()) {
                    s.setGioiTinh(0);
                } else {
                    s.setGioiTinh(1);
                }
                s.setDiaChi(txt_diachi.getText());
                s.setHinh(fileName);
                studentService.update(s, txt_masv.getText());
                loadData();
                getSelectionInterval(row);
                dialogHelper.alert(this, "Cập nhật thành công!");
                checkSave = 0;
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void jtg_darkmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtg_darkmodeActionPerformed
        if (jtg_darkmode.isSelected()) {
            jPanel1.setBackground(Color.black);
            rd_nam.setBackground(Color.black);
            rd_nu.setBackground(Color.black);
            jtg_darkmode.setText("DarkMode: On");
            lbl_masv.setForeground(Color.white);
            lbl_hoten.setForeground(Color.white);
            lbl_email.setForeground(Color.white);
            lbl_gioitinh.setForeground(Color.white);
            lbl_diachi.setForeground(Color.white);
            lbl_sdt.setForeground(Color.white);
            rd_nam.setForeground(Color.white);
            rd_nu.setForeground(Color.white);
            jPanel3.setBackground(Color.black);
            jPanel2.setBackground(Color.black);
            jPanel4.setBackground(Color.black);
        } else {
            jPanel1.setBackground(Color.white);
            rd_nam.setBackground(Color.white);
            rd_nu.setBackground(Color.white);
            jtg_darkmode.setText("DarkMode: OFF");
            lbl_masv.setForeground(Color.black);
            lbl_hoten.setForeground(Color.black);
            lbl_email.setForeground(Color.black);
            lbl_gioitinh.setForeground(Color.black);
            lbl_diachi.setForeground(Color.black);
            lbl_sdt.setForeground(Color.black);
            rd_nam.setForeground(Color.black);
            rd_nu.setForeground(Color.black);
            jPanel3.setBackground(Color.white);
            jPanel2.setBackground(Color.white);
            jPanel4.setBackground(Color.white);
        }
    }//GEN-LAST:event_jtg_darkmodeActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        if (dialogHelper.question(this, "Bạn có chắc muốn đăng xuất ?")) {
            this.dispose();
            SplashScreen splashScreen = new SplashScreen();
            splashScreen.setVisible(true);
        }
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void tb_sinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sinhvienMouseClicked
        showDetail();
    }//GEN-LAST:event_tb_sinhvienMouseClicked

    private void lbl_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageMouseClicked
        JFileChooser fileChooser = new JFileChooser("src/images");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*jpg", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                fileName = fileChooser.getSelectedFile().getPath();
                ImageIcon icon = new ImageIcon(fileName);
                Image image = icon.getImage();
                Image imageResize = ImageHelper.resize(image, 150, 187);
                icon = new ImageIcon(imageResize);
                lbl_image.setIcon(icon);
                File file = new File(fileName);
                file.renameTo(new File("src\\images\\" + file.getName()));
                fileName = file.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lbl_imageMouseClicked

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jtg_darkmode;
    private javax.swing.JLabel lbl_diachi;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_gioitinh;
    private javax.swing.JLabel lbl_hoten;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_info;
    private javax.swing.JLabel lbl_masv;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_sinhvien;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
