package antunes.com.marcelo.crudcommarcelo.controller;

import antunes.com.marcelo.crudcommarcelo.dao.EstudanteDao;
import antunes.com.marcelo.crudcommarcelo.model.Estudante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class EstudanteController implements Initializable {


    @FXML
    private Button bt_deletar;

    @FXML
    private Button bt_editar;

    @FXML
    private Button bt_salvar;

    @FXML
    private RadioButton rb_f;

    @FXML
    private RadioButton rb_m;

    @FXML
    private ToggleGroup sexo;

    @FXML
    private TableView<Estudante> tc_estudante;

    @FXML
    private TableColumn tc_id;

    @FXML
    private TableColumn tc_idade;

    @FXML
    private TableColumn tc_nome;

    @FXML
    private TableColumn tc_sexo;

    @FXML
    private TextField tf_idade;

    @FXML
    private TextField tf_nome;

    Estudante estudante = new Estudante();

    EstudanteDao estudanteDao = new EstudanteDao();

    private List<Estudante> todosEstudantes;

    private ObservableList<Estudante> estudanteObservableList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prepararListaTabela();

        ocultarBotoes();
    }
    void ocultarBotoes (){
        this.bt_editar.setVisible(false);
        this.bt_deletar.setVisible(false);
    }


    @FXML
    public void salvar(ActionEvent event){

        if (validador()) {
            estudante.setNome(tf_nome.getText().toString());
            estudante.setIdade(Integer.valueOf(tf_idade.getText().toString()));

            if (rb_m.isSelected()) {
                estudante.setSexo("Masculino");
            }
            if (rb_f.isSelected()) {
                estudante.setSexo("Feminino");
            }
            estudanteDao.inserir(estudante);
            prepararListaTabela();
            limpar();

            System.out.println("Estudante Salvo com sucesso");
        }

    }
    void prepararListaTabela(){

        tc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tc_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tc_idade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        todosEstudantes = estudanteDao.buscarTodos();

        estudanteObservableList = FXCollections.observableList(todosEstudantes);

        tc_estudante.setItems(estudanteObservableList);

    }

    void limpar(){
        tf_nome.setText("");
        tf_idade.setText("");
    }

    public boolean validador(){
        StringBuffer mensagem = new StringBuffer();

        if (tf_nome.getText().equals("")){
            mensagem.append("O campo nome é obrigatorio \n");
        }
        if (tf_idade.getText().equals("")){
            mensagem.append("O campo idade é obrigatorio \n");
        }

        if (mensagem.length() > 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ERRO");
            alert.setContentText(mensagem.toString());
            alert.show();

            return false;
        } else {
            return true;
        }
    }
    @FXML
    void preencherCampos(MouseEvent event) {

        estudante = (Estudante) tc_estudante.getSelectionModel().getSelectedItem();

        if (estudante !=null){

            bt_salvar.setVisible(false);
            bt_editar.setVisible(true);
            bt_deletar.setVisible(true);

            tf_nome.setText(estudante.getNome());
            tf_idade.setText(String.valueOf(estudante.getIdade()));

            if (estudante.getSexo().equals("Masculino")){
                rb_m.setSelected(true);
            } else if (estudante.getSexo().equals("Feminino")) {
                rb_f.setSelected(true);
            }
        }

    }
    @FXML
    void editar(){
        if (validador()){
            estudante.setNome(tf_nome.getText().toString());
            estudante.setIdade(Integer.valueOf(tf_idade.getText().toString()));

            if (rb_m.isSelected()) {
                estudante.setSexo("Masculino");
            }
            if (rb_f.isSelected()) {
                estudante.setSexo("Feminino");
            }
            estudanteDao.editar(estudante, estudante.getId());
            prepararListaTabela();
            limpar();

            bt_salvar.setVisible(true);
            bt_editar.setVisible(false);

        }
    }
    @FXML
    void deletar(){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação dialogo");
        alert.setHeaderText("Confirme se quer deletar?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){

            estudanteDao.apagar(estudante.getId());
            prepararListaTabela();
            limpar();

        } else {

        }

    }
}
