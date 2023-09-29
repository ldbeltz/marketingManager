package com.api.marketingManager.api.infrastructure.persistence.jdbc;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper.PessoaRowMapper;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery.PESSOA_INSERT_QUERY;

@Repository
public class JdbcPessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public PessoaPersistence save (PessoaPersistence pessoaPersistence){
         String query = "";

         pessoaPersistence.setPessoaId(jdbcTemplate.query("SELECT nextval('pessoa_id_pessoa_seq')",
                 rs -> {
                    if (rs.next()){
                        return rs.getLong(1);
                    } else {
                        throw new SQLException("Não foi possivel efetuar o registro, erro de banco de dados.");
                    }
                 }));

         if (pessoaPersistence.getNumCpf() != null){
             query = " INSERT INTO pessoa_fisica (id_pessoa, cpf, dta_nascimento) VALUES (?, ?, ?)";
             jdbcTemplate.update(PESSOA_INSERT_QUERY + query,
                     pessoaPersistence.getPessoaId(),
                     pessoaPersistence.getNome(),
                     pessoaPersistence.getEndereco(),
                     pessoaPersistence.getNumEndereco(),
                     pessoaPersistence.getCep(),
                     pessoaPersistence.getEmail(),
                     pessoaPersistence.getDddTelefone(),
                     pessoaPersistence.getNumTelefone(),
                     pessoaPersistence.getDtaCadastro(),
                     pessoaPersistence.getPessoaId(),
                     pessoaPersistence.getNumCpf(),
                     pessoaPersistence.getDtaNascimento()
                     );
             return findByCPF(pessoaPersistence.getNumCpf());
         } else {
             query = " INSERT INTO pessoa_juridica (id_pessoa, cnpj, dta_cadastro, cpf_responsavel) VALUES (?, ?, ?, ?)";
             jdbcTemplate.update(PESSOA_INSERT_QUERY + query,
                     pessoaPersistence.getPessoaId(),
                     pessoaPersistence.getNome(),
                     pessoaPersistence.getEndereco(),
                     pessoaPersistence.getNumEndereco(),
                     pessoaPersistence.getCep(),
                     pessoaPersistence.getEmail(),
                     pessoaPersistence.getDddTelefone(),
                     pessoaPersistence.getNumTelefone(),
                     pessoaPersistence.getDtaCadastro(),
                     pessoaPersistence.getPessoaId(),
                     pessoaPersistence.getCnpj(),
                     pessoaPersistence.getDtaCadastro(),
                     pessoaPersistence.getCpfResponsavel()
                     );
             return findByCNPJ(pessoaPersistence.getCnpj());
         }
    }
    public List<PessoaPersistence> findAll(){
        return jdbcTemplate.query(PessoaQuery.PESSOA_SELECT_QUERY, new PessoaRowMapper());
    }

    public PessoaPersistence findByCPF(String CPF){
        try {
            return jdbcTemplate.queryForObject(PessoaQuery.PESSOA_SELECT_QUERY + " WHERE CPF = ?", new PessoaRowMapper(), CPF);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public PessoaPersistence findByCNPJ(String CNPJ){
        try {
            return jdbcTemplate.queryForObject(PessoaQuery.PESSOA_SELECT_QUERY + " WHERE CNPJ = ?", new PessoaRowMapper(), CNPJ);
        } catch (EmptyResultDataAccessException e){
           return null;
        }

    }
}
