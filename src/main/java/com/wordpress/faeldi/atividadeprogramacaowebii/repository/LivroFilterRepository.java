package com.wordpress.faeldi.atividadeprogramacaowebii.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.dto.LivroDTO;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Categoria;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.Livro;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.QLivro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import com.wordpress.faeldi.atividadeprogramacaowebii.model.entity.QCategoria;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroFilterRepository  extends QuerydslRepositorySupport {
    public LivroFilterRepository() {
        super(Livro.class);
    }

    @PersistenceContext
    private EntityManager em;

    public List<Livro> filtrar(Long filter){
        QCategoria categoria = QCategoria.categoria;
        QLivro livro = QLivro.livro;
        List<Predicate> predicates = new ArrayList<>();
        if(filter > 0 && !(filter < 0) ) {
            predicates.add(categoria.id.eq(filter));
        }

        return new JPAQueryFactory(em).selectFrom(livro).where(
                predicates.toArray(new Predicate[0])
        ).fetch();
    }
    public List<Livro> buscarPorNome(String filter){
        QLivro produto = QLivro.livro;

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(produto.nome.likeIgnoreCase("%"+filter+"%"));

        return new JPAQueryFactory(em).selectFrom(produto).where(
                predicates.toArray(new Predicate[0])
        ).fetch();
    }

    public List<Livro> buscarPorIsbn(String filter){
        QLivro produto = QLivro.livro;

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(produto.isbn.likeIgnoreCase("%"+filter+"%"));

        return new JPAQueryFactory(em).selectFrom(produto).where(
                predicates.toArray(new Predicate[0])
        ).fetch();
    }

}
