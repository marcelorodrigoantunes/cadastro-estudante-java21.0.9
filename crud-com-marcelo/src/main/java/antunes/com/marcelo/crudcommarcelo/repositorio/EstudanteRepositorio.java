package antunes.com.marcelo.crudcommarcelo.repositorio;

import antunes.com.marcelo.crudcommarcelo.model.Estudante;

import java.util.List;

public interface EstudanteRepositorio {
    public Estudante porId(Long id);
    public List<Estudante> buscarTodos();
    public void inserir(Estudante estudante);
    public void apagar(long id);

    public void editar(Estudante estudante, long id);


}
