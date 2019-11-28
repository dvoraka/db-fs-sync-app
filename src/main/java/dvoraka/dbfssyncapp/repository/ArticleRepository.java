package dvoraka.dbfssyncapp.repository;

import dvoraka.dbfssyncapp.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
