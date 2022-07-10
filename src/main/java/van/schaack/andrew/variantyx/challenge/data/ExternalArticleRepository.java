package van.schaack.andrew.variantyx.challenge.data;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import van.schaack.andrew.variantyx.challenge.model.ExternalArticle;

public interface ExternalArticleRepository extends CrudRepository<ExternalArticle, String> {

	Collection<ExternalArticle> findAll();
	
}
