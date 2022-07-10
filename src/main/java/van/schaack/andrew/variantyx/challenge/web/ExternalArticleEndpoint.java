package van.schaack.andrew.variantyx.challenge.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import van.schaack.andrew.variantyx.challenge.model.AbstractResponse;
import van.schaack.andrew.variantyx.challenge.model.ExternalArticle;
import van.schaack.andrew.variantyx.challenge.service.ExternalArticleService;

@RestController
public class ExternalArticleEndpoint {

	@Autowired
	private ExternalArticleService externalArticleService;
	
	@GetMapping("/api/external-articles")
	public Collection<ExternalArticle> getExternalArticles() {
		return externalArticleService.findAll();
	}
	
	@GetMapping("/api/external-articles/{id}/abstract")
	public AbstractResponse getExternalArticleAbstract(@PathVariable("id") String id) {
		return externalArticleService.getAbstract(id);
	}
	
}
