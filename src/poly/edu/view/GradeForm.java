package poly.edu.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poly.edu.model.Grade;
import poly.edu.model.Student;
import poly.edu.model.User;
import poly.edu.service.impl.GradeService;
import poly.edu.service.impl.StudentService;
import poly.edu.utility.DialogHelper;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class GradeForm extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    GradeService gradeService = new GradeService();
    StudentService studentService = new StudentService();
    DialogHelper dialogHelper = new DialogHelper();
    private Integer index = 0;
    private Integer checkSearch = 0;

    private String getRole(int role){
        if(role == 0){
            return "Đào tạo";
        }else{
            return "Giảng viên";
        }
    }
    
    public GradeForm(User u) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý điểm - FPoly");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        loadData(gradeService.getTop3());
        getSelectionInterval(0);
        lbl_info.setText("User: " + u.getUsername() + " | Role: " + getRole(u.getVaitro()));
    }

    private void loadData(List<Grade> list) {
        defaultTableModel = (DefaultTableModel) tb_topsv.getModel();
        defaultTableModel.setRowCount(0);
        for (Grade x : list) {
            defaultTableModel.addRow(new Object[]{
                x.getMaSv(), x.getStudent(), x.getTiengAnh(), x.getTinHoc(), x.getGdtc(), (double) Math.round(((x.getTiengAnh() + x.getTinHoc() + x.getGdtc()) / 3) * 10) / 10
            });
        }
        lbl_total.setText("Total: " + gradeService.getAll().size());
    }

    private void showDetail() {
        int row = tb_topsv.getSelectedRow();
        txt_masv.setText((String) tb_topsv.getValueAt(row, 0));
        Student s = (Student) tb_topsv.getValueAt(row, 1);
        lbl_hoten.setText(s.toString());
        txt_tienganh.setText(String.valueOf(tb_topsv.getValueAt(row, 2)));
        txt_tinhoc.setText(String.valueOf(tb_topsv.getValueAt(row, 3)));
        txt_giaoductc.setText(String.valueOf(tb_topsv.getValueAt(row, 4)));
        lbl_diemtb.setText(String.valueOf(tb_topsv.getValueAt(row, 5)));
        tb_topsv.setRowSelectionInterval(row, row);
        tb_topsv.setRowSelectionAllowed(true);
        txt_masv.disable();
    }

    private void getSelectionInterval(int index){
        if (tb_topsv.getRowCount() > 0) {
            tb_topsv.setRowSelectionInterval(index, index);
            showDetail();
        }
    }

    private void clearForm() {
        lbl_hoten.setText(" ");
        lbl_diemtb.setText("0.0");
        txt_masv.setText("");
        txt_tienganh.setText("");
        txt_tinhoc.setText("");
        txt_giaoductc.setText("");
        tb_topsv.setRowSelectionAllowed(false);
        tb_topsv.clearSelection();
        txt_masv.enable();
        txt_search.setText("");
    }

    private boolean checkNullSave() {
        if (txt_masv.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Mã sinh viên");
        } else if (txt_tienganh.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Điểm tiếng anh");
        } else if (txt_tinhoc.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Điểm tin học");
        } else if (txt_giaoductc.getText().isEmpty()) {
            dialogHelper.errorNull(this, "Điểm GDTC");
        } else {
            return true;
        }
        return false;
    }

    private boolean updateMark(Grade g) {
        try {
            float tiengAnh = Float.parseFloat(txt_tienganh.getText());
            float tinHoc = Float.parseFloat(txt_tinhoc.getText());
            float gdtc = Float.parseFloat(txt_giaoductc.getText());
            if (tiengAnh < 0 || tiengAnh > 10 || tinHoc < 0 || tinHoc > 10 || gdtc < 0 || gdtc > 10) {
                dialogHelper.error(this, "Vui lòng nhập đúng điểm!");
            } else {
                g.setTiengAnh(tiengAnh);
                g.setTinHoc(tinHoc);
                g.setGdtc(gdtc);
                loadData(gradeService.getTop3());
            }
            return true;
        } catch (Exception e) {
            dialogHelper.error(this, "Vui lòng nhập đúng điểm!");
            return false;
        }
    }

    private void last(List<Grade> list) {
        if (list.size() == 0) {
            dialogHelper.error(this, "Danh sách trống!");
        } else {
            index = list.size() - 1;
            tb_topsv.setRowSelectionInterval(index, index);
            showDetail();
        }
    }

    private void prev(List<Grade> list) {
        if (list.size() == 0) {
            dialogHelper.error(this, "Danh sách trống!");
        } else {
            if (index == 0) {
                index = list.size();
            }
            index--;
            tb_topsv.setRowSelectionInterval(index, index);
            showDetail();
        }
    }

    private void next(List<Grade> list) {
        if (list.size() == 0) {
            dialogHelper.error(this, "Danh sách trống!");
        } else {
            if (index == list.size() - 1) {
                index = -1;
            }
            index++;
            tb_topsv.setRowSelectionInterval(index, index);
            showDetail();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlb_search = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlb_hoten = new javax.swing.JLabel();
        jlb_masv = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        txt_tienganh = new javax.swing.JTextField();
        jlb_tienganh = new javax.swing.JLabel();
        txt_tinhoc = new javax.swing.JTextField();
        jlb_tinhoc = new javax.swing.JLabel();
        txt_giaoductc = new javax.swing.JTextField();
        jlb_gdtc = new javax.swing.JLabel();
        jlb_dtb = new javax.swing.JLabel();
        lbl_diemtb = new javax.swing.JLabel();
        lbl_hoten = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_topsv = new javax.swing.JTable();
        jtg_darkmode = new javax.swing.JToggleButton();
        btn_logOut = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        lbl_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), java.awt.Color.red)); // NOI18N

        jlb_search.setText("Mã sinh viên:");

        txt_search.setMinimumSize(new java.awt.Dimension(1, 16));
        txt_search.setPreferredSize(new java.awt.Dimension(1, 16));

        btn_search.setBackground(new java.awt.Color(204, 204, 204));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.setBorderPainted(false);
        btn_search.setFocusPainted(false);
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_search)
                .addGap(18, 18, 18)
                .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_search)
                        .addComponent(jlb_search))
                    .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), java.awt.Color.red)); // NOI18N

        jlb_hoten.setText("Họ tên sinh viên:");

        jlb_masv.setText("Mã sinh viên:");

        txt_masv.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_masv.setPreferredSize(new java.awt.Dimension(10, 22));

        txt_tienganh.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_tienganh.setPreferredSize(new java.awt.Dimension(10, 22));

        jlb_tienganh.setText("Tiếng anh:");

        txt_tinhoc.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_tinhoc.setPreferredSize(new java.awt.Dimension(10, 22));

        jlb_tinhoc.setText("Tin học:");

        txt_giaoductc.setMinimumSize(new java.awt.Dimension(10, 22));
        txt_giaoductc.setPreferredSize(new java.awt.Dimension(10, 22));

        jlb_gdtc.setText("Giáo dục TC:");

        jlb_dtb.setText("Điểm trung bình");

        lbl_diemtb.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_diemtb.setForeground(new java.awt.Color(0, 0, 255));
        lbl_diemtb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_diemtb.setText("0.0");

        lbl_hoten.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_hoten.setForeground(java.awt.Color.blue);
        lbl_hoten.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlb_hoten)
                    .addComponent(jlb_masv)
                    .addComponent(jlb_tienganh)
                    .addComponent(jlb_tinhoc)
                    .addComponent(jlb_gdtc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tinhoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tienganh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_giaoductc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_masv, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(lbl_hoten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbl_diemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_dtb)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_hoten, txt_masv});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb_hoten)
                    .addComponent(lbl_hoten))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_masv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_tienganh)
                            .addComponent(txt_tienganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlb_tinhoc)
                            .addComponent(txt_tinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaoductc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_gdtc))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlb_dtb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_diemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_hoten, txt_giaoductc, txt_masv, txt_tienganh, txt_tinhoc});

        btn_new.setBackground(new java.awt.Color(204, 204, 204));
        btn_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_new.setText("New");
        btn_new.setBorderPainted(false);
        btn_new.setFocusPainted(false);
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(204, 204, 204));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.setBorderPainted(false);
        btn_save.setFocusPainted(false);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(204, 204, 204));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorderPainted(false);
        btn_delete.setFocusPainted(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(204, 204, 204));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorderPainted(false);
        btn_update.setFocusPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_first.setBackground(new java.awt.Color(204, 204, 204));
        btn_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        btn_first.setText("First");
        btn_first.setBorderPainted(false);
        btn_first.setFocusPainted(false);
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_last.setBackground(new java.awt.Color(204, 204, 204));
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Right.png"))); // NOI18N
        btn_last.setText("Last");
        btn_last.setBorderPainted(false);
        btn_last.setFocusPainted(false);
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_prev.setBackground(new java.awt.Color(204, 204, 204));
        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Down.png"))); // NOI18N
        btn_prev.setText("Prev");
        btn_prev.setBorderPainted(false);
        btn_prev.setFocusPainted(false);
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        btn_next.setBackground(new java.awt.Color(204, 204, 204));
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Up.png"))); // NOI18N
        btn_next.setText("Next");
        btn_next.setBorderPainted(false);
        btn_next.setFocusPainted(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("3 sinh viên có điểm cao nhất:");

        tb_topsv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Tiếng anh", "Tin học", "GDTC", "Điểm TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_topsv.setShowGrid(true);
        tb_topsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_topsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_topsv);

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jtg_darkmode))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_first)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_prev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_next)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_last))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_logOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(47, 47, 47))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_first, btn_last, btn_next, btn_prev});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtg_darkmode)
                    .addComponent(lbl_info))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_last, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_first, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_prev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lbl_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_first, btn_last, btn_next, btn_prev});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        Grade g = new Grade();
        try {
            float tiengAnh = Float.parseFloat(txt_tienganh.getText());
            float tinHoc = Float.parseFloat(txt_tinhoc.getText());
            float gdtc = Float.parseFloat(txt_giaoductc.getText());
            if (tiengAnh < 0 || tiengAnh > 10 || tinHoc < 0 || tinHoc > 10 || gdtc < 0 || gdtc > 10) {
                dialogHelper.error(this, "Vui lòng nhập đúng điểm!");
            } else {
                if (studentService.getAll().size() == 0) {
                    dialogHelper.error(this, "Danh sách sinh viên trống! Vui lòng liên hệ đào tạo để biết thêm chi tiết!");
                } else {
                    if (gradeService.getOne(txt_masv.getText()) == null) {
                        dialogHelper.error(this, "Mã sinh viên không tồn tại!");
                        return;
                    } else {
                        g.setMaSv(txt_masv.getText().toUpperCase());
                    }
                    g.setTiengAnh(tiengAnh);
                    g.setTinHoc(tinHoc);
                    g.setGdtc(gdtc);
                    gradeService.add(g);
                    loadData(gradeService.getTop3());
                    dialogHelper.alert(this, "Thêm thành công!");
                }
            }
        } catch (Exception e) {
            dialogHelper.error(this, "Vui lòng nhập đúng điểm!");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_topsv.getSelectedRow();
        Grade g;
        if (row == -1) {
            dialogHelper.error(this, "Vui lòng chọn 1 dòng rồi xóa!");
        } else {
            if (dialogHelper.question(this, "Bạn có chắc muốn xóa " + tb_topsv.getValueAt(row, 1) + " ra khỏi danh sách ?")) {
                if (checkSearch == 1) {
                    g = gradeService.search(txt_search.getText()).get(row);
                    gradeService.delete(g.getId());
                    checkSearch = 0;
                } else if (checkSearch == 2) {
                    g = gradeService.getAll().get(row);
                    gradeService.delete(g.getId());
                    checkSearch = 0;
                } else {
                    g = gradeService.getTop3().get(row);
                    gradeService.delete(g.getId());
                }
                loadData(gradeService.getTop3());
                clearForm();
                dialogHelper.alert(this, "Xóa thành công!");
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_topsv.getSelectedRow();
        Grade g;
        if (row == -1) {
            dialogHelper.error(this, "Vui lòng chọn dòng cần cập nhật!");
        } else {
            if (checkSearch == 1) {
                g = gradeService.search(txt_masv.getText()).get(row);
                updateMark(g);
                gradeService.update(g, g.getId());
                checkSearch = 0;
            } else if (checkSearch == 2) {
                g = gradeService.getAll().get(row);
                updateMark(g);
                gradeService.update(g, g.getId());
                checkSearch = 0;
            } else {
                g = gradeService.getTop3().get(row);
                updateMark(g);
                gradeService.update(g, g.getId());
            }
            clearForm();
            loadData(gradeService.getTop3());
            dialogHelper.alert(this, "Cập nhật thành công!");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        loadData(gradeService.search(txt_search.getText()));
        txt_search.setText(txt_search.getText().toUpperCase());
        if (txt_search.getText().isEmpty()) {
            checkSearch = 2;
        } else if (gradeService.search(txt_search.getText()).size() == 0) {
            clearForm();
            loadData(gradeService.getTop3());
            dialogHelper.alert(this, "Mã sinh viên không tồn tại!");
            checkSearch = 0;
        } else {
            checkSearch = 1;
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        if (gradeService.search(txt_search.getText()).size() == 0 || gradeService.getTop3().size() == 0) {
            dialogHelper.error(this, "Danh sách trống!");
        } else {
            index = 0;
            tb_topsv.setRowSelectionInterval(index, index);
            showDetail();
        }
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        if (checkSearch == 1) {
            last(gradeService.search(txt_search.getText()));
        } else if (checkSearch == 2) {
            last(gradeService.getAll());
        } else {
            last(gradeService.getTop3());
        }
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        if (checkSearch == 1) {
            prev(gradeService.search(txt_search.getText()));
        } else if (checkSearch == 2) {
            prev(gradeService.getAll());
        } else {
            prev(gradeService.getTop3());
        }
    }//GEN-LAST:event_btn_prevActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if (checkSearch == 1) {
            next(gradeService.search(txt_search.getText()));
        } else if (checkSearch == 2) {
            next(gradeService.getAll());
        }
        else {
            next(gradeService.getTop3());
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void jtg_darkmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtg_darkmodeActionPerformed
        if (jtg_darkmode.isSelected()) {
            jPanel1.setBackground(Color.black);
            jPanel2.setBackground(Color.black);
            jPanel3.setBackground(Color.black);
            jtg_darkmode.setText("DarkMode: On");
            jlb_search.setForeground(Color.white);
            jlb_masv.setForeground(Color.white);
            jlb_hoten.setForeground(Color.white);
            jlb_tienganh.setForeground(Color.white);
            jlb_tinhoc.setForeground(Color.white);
            jlb_gdtc.setForeground(Color.white);
            jlb_dtb.setForeground(Color.white);
        } else {
            jPanel1.setBackground(Color.white);
            jPanel2.setBackground(Color.white);
            jPanel3.setBackground(Color.white);
            jtg_darkmode.setText("DarkMode: OFF");
            jlb_search.setForeground(Color.black);
            jlb_masv.setForeground(Color.black);
            jlb_hoten.setForeground(Color.black);
            jlb_tienganh.setForeground(Color.black);
            jlb_tinhoc.setForeground(Color.black);
            jlb_gdtc.setForeground(Color.black);
            jlb_dtb.setForeground(Color.black);
        }
    }//GEN-LAST:event_jtg_darkmodeActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed
        if (dialogHelper.question(this, "Bạn có chắc muốn đăng xuất ?")) {
            this.dispose();
            new SplashScreen().setVisible(true);
        }
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void tb_topsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_topsvMouseClicked
        showDetail();
    }//GEN-LAST:event_tb_topsvMouseClicked

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GradeForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_dtb;
    private javax.swing.JLabel jlb_gdtc;
    private javax.swing.JLabel jlb_hoten;
    private javax.swing.JLabel jlb_masv;
    private javax.swing.JLabel jlb_search;
    private javax.swing.JLabel jlb_tienganh;
    private javax.swing.JLabel jlb_tinhoc;
    private javax.swing.JToggleButton jtg_darkmode;
    private javax.swing.JLabel lbl_diemtb;
    private javax.swing.JLabel lbl_hoten;
    private javax.swing.JLabel lbl_info;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tb_topsv;
    private javax.swing.JTextField txt_giaoductc;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tienganh;
    private javax.swing.JTextField txt_tinhoc;
    // End of variables declaration//GEN-END:variables
}
