package antunes.com.marcelo.crudcommarcelo.util;

import antunes.com.marcelo.crudcommarcelo.dao.EstudanteDao;
import antunes.com.marcelo.crudcommarcelo.model.Estudante;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws SQLException {

/*       Estudante estudante = new Estudante();
        estudante.setNome("Marcelo");
        estudante.setSexo("Masculino");
        estudante.setIdade(37);

        EstudanteDao estudanteDao = new EstudanteDao();

        estudanteDao.inserir(estudante);

        EstudanteDao estudanteDao = new EstudanteDao();
        List<Estudante> estudantes = new ArrayList<>();

        estudantes = estudanteDao.buscarTodos();

        for (int i = 0; i < estudantes.size(); i ++){

            System.out.println("ID: " + estudantes.get(i).getId());
            System.out.println("Nome: " + estudantes.get(i).getNome());
            System.out.println("Sexo: " + estudantes.get(i).getSexo());
            System.out.println("Idade: " + estudantes.get(i).getIdade());

        }


        EstudanteDao estudanteDao = new EstudanteDao();
        Estudante estudante = new Estudante();
        estudante.setNome("Miguel");
        estudante.setSexo("Masculino");
        estudante.setIdade(60);

        estudanteDao.editar(estudante, 2);


        EstudanteDao estudanteDao = new EstudanteDao();
        Estudante estudante = new Estudante();
        estudante = estudanteDao.porId(1L);
        System.out.println("Nome: " + estudante.getNome());
        System.out.println("Sexo: " + estudante.getSexo());
 */

        EstudanteDao estudanteDao = new EstudanteDao();
        estudanteDao.apagar(2);

    }

}
