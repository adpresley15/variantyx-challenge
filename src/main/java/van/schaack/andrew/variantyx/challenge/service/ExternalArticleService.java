package van.schaack.andrew.variantyx.challenge.service;

import java.util.Collection;

import org.jsoup.HttpStatusException;

import van.schaack.andrew.variantyx.challenge.model.AbstractResponse;
import van.schaack.andrew.variantyx.challenge.model.ExternalArticle;

public interface ExternalArticleService {

	Collection<ExternalArticle> findAll();

	AbstractResponse getAbstract(String externalArticleId);
	
	ExternalArticle getExternalArticle(String externalArticleId) throws HttpStatusException;
	
}
