package com.mycompany.app;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller {

    public TextField T_ID;
    public TextField T_Nombre;
    public TextField T_Apellido;
    public TextField T_Correo;
    public TextField T_Tel;
    public Button B_Regresa;
    public TextField T_PID;
    public TextField T_PTipo;
    public TextField T_PUsuario;
    public TextField T_PFecha;
    public TextField T_PRetardo;

    public TableColumn<Prestamo,String> C_PID= new TableColumn<>();
    public TableView<Prestamo> Tbl_Prestamo= new TableView<>();
    public TableColumn<Prestamo,String> C_PID_Biblio= new TableColumn<>();
    public TableColumn<Prestamo,String> C_PID_Usuario= new TableColumn<>();
    public TableColumn<Prestamo,String> C_PFecha= new TableColumn<>();
    public TableColumn<Prestamo,String> C_PRetardo= new TableColumn<>();

    @FXML public void initialize()throws Exception{
        ini_TablaLibro();
        final ObservableList<Libro> tablaPersonaSel = Tbl_Libros.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);

        ini_TablaRev();
        final ObservableList<Revista> tablaRevistaSel = Tbl_Revista.getSelectionModel().getSelectedItems();
        tablaRevistaSel.addListener(selectorTablaRevista);

        ini_TablaTesis();
        final ObservableList<Tesis> tablaTesisSel = Tbl_Tesis.getSelectionModel().getSelectedItems();
        tablaTesisSel.addListener(selectorTablaTesis);
        Ini_TablaUsuario();
        final ObservableList<Usuario> tablaUSerSel = Tabla_Usuario.getSelectionModel().getSelectedItems();
        tablaUSerSel.addListener(selectorTablaUsuario);
        Ini_TablaPrestamo();
        final ObservableList<Prestamo> tablaPrestamoSel = Tbl_Prestamo.getSelectionModel().getSelectedItems();
        tablaPrestamoSel.addListener(selectorTablaPrestamo);

    }
    static ObservableList<Usuario> L_Usuario=Excel.excelUsuario();
    static ObservableList<Libro> L_Libro=Excel.excelLibro();
    static ObservableList<Tesis> L_Tesis=Excel.excelTesis();
    static ObservableList<Revista> L_Rev=Excel.excelRev();
    static ObservableList<Prestamo> L_Prestamo=Excel.excelPrestamo();
     static Biblioteca BX= new Biblioteca();
    // V_LogIn
    @FXML private TextField T_Usuario;
    @FXML private PasswordField T_Pass;
    @FXML private Button B_logIn;

    @FXML
    void B_LogIn() {
        if(1== BX.validarAdmin(T_Usuario.getText(),T_Pass.getText())){
            Stage stage = (Stage) B_logIn.getScene().getWindow();
            stage.close();
        }
    }

    //V_Usuario
    @FXML public  TableView<Usuario> Tabla_Usuario = new TableView<>();
    @FXML public  TableColumn<Usuario,String> C_ID= new TableColumn<>();
    @FXML public  TableColumn<Usuario,String> C_Nombre= new TableColumn<>();
    @FXML public  TableColumn<Usuario,String> C_Apellidos= new TableColumn<>();
    @FXML public  TableColumn<Usuario,String> C_Correo= new TableColumn<>();
    @FXML public  TableColumn<Usuario,String> C_Tel= new TableColumn<>();

    @FXML void B_Agregar(){
    Lista_Usuario.add(getsTextUser());
    limpiarTXUser();
    }

    @FXML void B_Eliminar(){
        Lista_Usuario.remove(posicion);
        limpiarTXUser();
    }

    @FXML void B_Modificar(){
        Lista_Usuario.set(posicion,getsTextUser());
        limpiarTXUser();
    }
    public int posicion=0;

    private final ListChangeListener<Usuario> selectorTablaUsuario = new ListChangeListener<Usuario>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Usuario> c) { ponerUsuarioSelec(); }  };

    public Usuario getTablaUsuarioSeleccionada() {
        if (Tabla_Usuario != null) {
            List<Usuario> tabla = Tabla_Usuario.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Usuario competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerUsuarioSelec() {
        final Usuario user = getTablaUsuarioSeleccionada();
        posicion = Lista_Usuario.indexOf(user);

        if (user != null) {
            T_ID.setText(user.getUID());
            T_Nombre.setText(user.getUNombre());
            T_Apellido.setText(user.getUApellido());
            T_Correo.setText(user.getUCorreo());
            T_Tel.setText(user.getUTel());
        }
    }
    void limpiarTXUser(){
        T_ID.setText("");
        T_Nombre.setText("");
        T_Apellido.setText("");
        T_Correo.setText("");
        T_Tel.setText("");
    }
    public Usuario getsTextUser(){
        Usuario rev = new Usuario();
        rev.UID.set(T_ID.getText());
        rev.UNombre.set(T_Nombre.getText());
        rev.UApellido.set(T_Apellido.getText());
        rev.UCorreo.set(T_Correo.getText());
        rev.UTel.set(T_Tel.getText());
        return rev;
    }

     void Ini_TablaUsuario(){
        C_ID.setCellValueFactory(new PropertyValueFactory<Usuario, String>("UID"));
        C_Nombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("UNombre"));
        C_Apellidos.setCellValueFactory(new PropertyValueFactory<Usuario, String>("UApellido"));
        C_Correo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("UCorreo"));
        C_Tel.setCellValueFactory(new PropertyValueFactory<Usuario, String>("UTel"));
        Lista_Usuario=L_Usuario;
        // Lista_Usuario.add(new Usuario("03","Netinho","Ramírez","ernezto8600@gmail.com","8110200388"));
        Tabla_Usuario.setItems(Lista_Usuario);
    }
    ObservableList<Usuario> Lista_Usuario= FXCollections.observableArrayList();


    public void B_Back() throws IOException {
        Stage op = FXMLLoader.load(getClass().getResource("/V_Bibliografia.fxml"));
        op.setTitle("Servicios");
        op.show();
        Stage stage = (Stage) B_Regresa.getScene().getWindow();
        stage.close();
    }

    private final ListChangeListener<Prestamo> selectorTablaPrestamo = new ListChangeListener<Prestamo>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Prestamo> c) { ponerPrestamoSelec(); }  };

    public Prestamo getTablaPrestamoSeleccionada() {
        if (Tbl_Prestamo != null) {
            List<Prestamo> tabla = Tbl_Prestamo.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Prestamo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerPrestamoSelec() {
        final Prestamo user = getTablaPrestamoSeleccionada();
        posicion = Lista_Prestamo.indexOf(user);

        if (user != null) {
            T_PID.setText(user.getPID());
            T_PTipo.setText(user.getPTipo());
            T_PUsuario.setText(user.getPUsuario());
            T_PFecha.setText(user.getPFecha());
            T_PRetardo.setText(user.getPRetardo());
        }
    }
    void limpiarTXTPrestamo(){
        T_PID.setText("");
        T_PTipo.setText("");
        T_PUsuario.setText("");
        T_PFecha.setText("");
        T_PRetardo.setText("");
    }
    public Prestamo getsTextPrestamo(){
        Prestamo rev = new Prestamo();
        rev.PID.set(T_PID.getText());
        rev.PTipo.set(T_PTipo.getText());
        rev.PUsuario.set(T_PUsuario.getText());
        rev.PFecha.set(T_PFecha.getText());
        rev.PRetardo.set(T_PRetardo.getText());
        return rev;
    }

    void Ini_TablaPrestamo(){
        C_PID.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("PID"));
        C_PID_Biblio.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("PTipo"));
        C_PID_Usuario.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("PUsuario"));
        C_PFecha.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("PFecha"));
        C_PRetardo.setCellValueFactory(new PropertyValueFactory<Prestamo, String>("PRetardo"));
        Lista_Prestamo=L_Prestamo;
        //Lista_Prestamo.add(new Prestamo("1","Libro","Ernesto","01/02/2020","No"));
        Tbl_Prestamo.setItems(Lista_Prestamo);
    }
    ObservableList<Prestamo> Lista_Prestamo= FXCollections.observableArrayList();

    public void BP_Agregar(ActionEvent actionEvent) {
    Lista_Prestamo.add(getsTextPrestamo());
    limpiarTXTPrestamo();
    }

    public void BP_Eliminar(ActionEvent actionEvent) {
        Lista_Prestamo.remove(posicion);
        limpiarTXTPrestamo();
    }

    public void BP_Modificar(ActionEvent actionEvent) {
        Lista_Prestamo.set(posicion,getsTextPrestamo());
        limpiarTXTPrestamo();
    }

    public TableColumn<Libro,String> C_ISBN= new TableColumn();
    public TableColumn<Libro,String> C_Titulo= new TableColumn();
    public TableColumn<Libro,String> C_Autor= new TableColumn();
    public TableColumn<Libro,String> C_Anio= new TableColumn();
    public TableColumn<Libro,String> C_Edit= new TableColumn();
    public TableColumn<Libro,String> C_Pais= new TableColumn();

    public TextField T_ISBN;
    public TextField T_Titulo;
    public TextField T_Autor;
    public TextField T_Año;
    public TextField T_Editorial;
    public TextField T_Pais;
    public TableView<Libro> Tbl_Libros= new TableView<>();

    public TableView<Revista> Tbl_Revista= new TableView<>();;
    public TableColumn<Revista,String> C_RID= new TableColumn();
    public TableColumn<Revista,String> C_RTitulo= new TableColumn();
    public TableColumn<Revista,String> C_Revista= new TableColumn();
    public TableColumn<Revista,String> C_RFecha= new TableColumn();
    public TableColumn<Revista,String> C_REdicion= new TableColumn();
    public TableColumn<Revista,String> C_RPag= new TableColumn();
    public TextField T_RID;
    public TextField T_RTitulo;
    public TextField T_Revista;
    public TextField T_RFecha;
    public TextField T_REdicion;
    public TextField T_RPag;

    public TableView<Tesis> Tbl_Tesis= new TableView<>();;
    public TableColumn<Tesis,String> CT_IDTesis= new TableColumn();
    public TableColumn<Tesis,String> CT_Titulo= new TableColumn();
    public TableColumn<Tesis,String> CT_Autor= new TableColumn();
    public TableColumn<Tesis,String> CT_Anio= new TableColumn();
    public TableColumn<Tesis,String> CT_Instituto= new TableColumn();
    public TableColumn<Tesis,String> CT_Lugar= new TableColumn();
    public TextField T_TID;
    public TextField T_TTitulo;
    public TextField T_TAutor;
    public TextField T_TAño;
    public TextField T_TInstituto;
    public TextField T_TLugar;


    @FXML private Button B_Libros;
    @FXML private Button B_Tesis;
    @FXML private Button B_Revista;
    @FXML private Button B_Prestamo;
    @FXML private Button B_AdminUsuario;

    public void BL_Agregar() {
        Lista_Libro.add(getsText());
        limpiarTXT();

    }

    void limpiarTXT(){
        T_Editorial.setText("");
        T_Autor.setText("");
        T_Año.setText("");
        T_Titulo.setText("");
        T_Pais.setText("");
        T_ISBN.setText("");
    }
    public Libro getsText(){
        Libro libro = new Libro();
        libro.LISBN.set(T_ISBN.getText());
        libro.LEditorial.set(T_Editorial.getText());
        libro.LTitulo.set(T_Titulo.getText());
        libro.LAutor.set(T_Autor.getText());
        libro.LAnio.set(T_Año.getText());
        libro.LPais.set(T_Pais.getText());
        return libro;
    }

    public void BL_Eliminar() {
        Lista_Libro.remove(posicion);
        limpiarTXT();
    }

    public void BL_Modificar() {
        Lista_Libro.set(posicion,getsText());
        limpiarTXT();
    }

    public Libro getTablaPersonasSeleccionada() {
        if (Tbl_Libros != null) {
            List<Libro> tabla = Tbl_Libros.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Libro competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerLibroSelec() {
        final Libro libro = getTablaPersonasSeleccionada();
        posicion = Lista_Libro.indexOf(libro);

        if (libro != null) {
            T_ISBN.setText(libro.getLISBN());
            T_Titulo.setText(libro.getLTitulo());
            T_Año.setText(libro.getLAnio());
            T_Autor.setText(libro.getLAutor());
            T_Editorial.setText(libro.getLEditorial());
            T_Pais.setText(libro.getLPais());

        }
    }
    private final ListChangeListener<Libro> selectorTablaPersonas = new ListChangeListener<Libro>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Libro> c) { ponerLibroSelec(); }  };

    private void ini_TablaLibro(){
        C_ISBN.setCellValueFactory(new PropertyValueFactory<Libro,String>("LISBN"));
        C_Titulo.setCellValueFactory(new PropertyValueFactory<Libro,String>("LTitulo"));
        C_Anio.setCellValueFactory(new PropertyValueFactory<Libro,String>("LAnio"));
        C_Autor.setCellValueFactory(new PropertyValueFactory<Libro,String>("LAutor"));
        C_Edit.setCellValueFactory(new PropertyValueFactory<Libro,String>("LEditorial"));
        C_Pais.setCellValueFactory(new PropertyValueFactory<Libro,String>("LPais"));
        Lista_Libro=L_Libro;
        //Lista_Libro.add(new Libro("123-456","Romeo y Julieta","Shakespare","1960","Editorial","Europa"));
        Tbl_Libros.setItems(Lista_Libro);
    }


    ObservableList<Libro> Lista_Libro= FXCollections.observableArrayList();
    ObservableList<Revista> Lista_Revista= FXCollections.observableArrayList();
    ObservableList<Tesis> Lista_Tesis= FXCollections.observableArrayList();

    private final ListChangeListener<Revista> selectorTablaRevista = new ListChangeListener<Revista>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Revista> c) { ponerRevistaSelec(); }  };
    //RID,RTitulo,RRevista,RFecha,REdic,RPag;
    private void ini_TablaRev(){
        C_REdicion.setCellValueFactory(new PropertyValueFactory<Revista,String>("REdic"));
        C_Revista.setCellValueFactory(new PropertyValueFactory<Revista,String>("RRevista"));
        C_RFecha.setCellValueFactory(new PropertyValueFactory<Revista,String>("RFecha"));
        C_RID.setCellValueFactory(new PropertyValueFactory<Revista,String>("RID"));
        C_RPag.setCellValueFactory(new PropertyValueFactory<Revista,String>("RPag"));
        C_RTitulo.setCellValueFactory(new PropertyValueFactory<Revista,String>("RTitulo"));
        Lista_Revista=L_Rev;
       // Lista_Revista.add(new Revista("123-456","Romeo y Julieta","Shakespare","1960","Editorial","Europa"));
        Tbl_Revista.setItems(Lista_Revista);
    }

    public Revista getTablaRevistaSeleccionada() {
        if (Tbl_Revista != null) {
            List<Revista> tabla = Tbl_Revista.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Revista competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerRevistaSelec() {
        final Revista rev = getTablaRevistaSeleccionada();
        posicion = Lista_Revista.indexOf(rev);

        if (rev != null) {
            T_RID.setText(rev.getRID());
            T_RTitulo.setText(rev.getRTitulo());
            T_RFecha.setText(rev.getRFecha());
            T_Revista.setText(rev.getRRevista());
            T_REdicion.setText(rev.getREdic());
            T_RPag.setText(rev.getRPag());

        }
    }
    void limpiarTXTRev(){
        T_RPag.setText("");
        T_REdicion.setText("");
        T_Revista.setText("");
        T_RFecha.setText("");
        T_RID.setText("");
        T_RTitulo.setText("");
    }
    public void BR_Agregar() {
        Lista_Revista.add(getsTextRev());
        limpiarTXTRev();
    }
    public Revista getsTextRev(){
        Revista rev = new Revista();
        rev.RID.set(T_RID.getText());
        rev.RTitulo.set(T_RTitulo.getText());
        rev.RRevista.set(T_Revista.getText());
        rev.REdic.set(T_REdicion.getText());
        rev.RFecha.set(T_RFecha.getText());
        rev.RPag.set(T_RPag.getText());
        return rev;
    }

    public void BR_Eliminar() {
        Lista_Revista.remove(posicion);
        limpiarTXTRev();
    }

    public void BR_Modificar() {
        Lista_Revista.set(posicion,getsTextRev());
        limpiarTXT();
    }
    private final ListChangeListener<Tesis> selectorTablaTesis = new ListChangeListener<Tesis>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Tesis> c) { ponerTesisSelec(); }  };

    public Tesis getTablaTesisSeleccionada() {
        if (Tbl_Revista != null) {
            List<Tesis> tabla = Tbl_Tesis.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Tesis competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    private void ponerTesisSelec() {
        final Tesis tesis = getTablaTesisSeleccionada();
        posicion = Lista_Tesis.indexOf(tesis);

        if (tesis != null) {
            T_TID.setText(tesis.getTID());
            T_TTitulo.setText(tesis.getTTitulo());
            T_TAño.setText(tesis.getTAño());
            T_TAutor.setText(tesis.getTAutor());
            T_TInstituto.setText(tesis.getTInst());
            T_TLugar.setText(tesis.getTLugar());
        }
    }
    void limpiarTXTes(){
        T_TID.setText("");
        T_TTitulo.setText("");
        T_TAutor.setText("");
        T_TAño.setText("");
        T_TInstituto.setText("");
        T_TLugar.setText("");
    }
    public Tesis getsTextTesis(){
        Tesis rev = new Tesis();
        rev.TID.set(T_TID.getText());
        rev.TLugar.set(T_TLugar.getText());
        rev.TInst.set(T_TInstituto.getText());
        rev.TAño.set(T_TAño.getText());
        rev.TAutor.set(T_TAutor.getText());
        rev.TTitulo.set(T_TTitulo.getText());
        return rev;
    }
    //TID,TTitulo,TAutor,TAño,TInst,TLugar;
    private void ini_TablaTesis(){
        CT_Anio.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TAño"));
        CT_Autor.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TAutor"));
        CT_IDTesis.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TID"));
        CT_Instituto.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TInst"));
        CT_Lugar.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TLugar"));
        CT_Titulo.setCellValueFactory(new PropertyValueFactory<Tesis,String>("TTitulo"));
        Lista_Tesis=L_Tesis;
        //Lista_Tesis.add(new Tesis("123-456","Romeo y Julieta","Shakespare","1960","Editorial","Europa"));
        Tbl_Tesis.setItems(Lista_Tesis);
    }

    public void BT_Agregar() {
        Lista_Tesis.add(getsTextTesis());
        limpiarTXTes();
    }

    public void BT_Eliminar() {
        Lista_Tesis.remove(posicion);
        limpiarTXTes();
    }

    public void BT_Modificar() {
        Lista_Tesis.set(posicion,getsTextTesis());
        limpiarTXTes();
    }
}

