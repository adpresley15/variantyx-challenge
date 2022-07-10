package van.schaack.andrew.variantyx.challenge.service;

import java.io.IOException;
import java.util.Collection;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import van.schaack.andrew.variantyx.challenge.data.ExternalArticleRepository;
import van.schaack.andrew.variantyx.challenge.model.AbstractResponse;
import van.schaack.andrew.variantyx.challenge.model.ArticleType;
import van.schaack.andrew.variantyx.challenge.model.ExternalArticle;

@Service
public class ExternalArticleServiceImpl implements ExternalArticleService {
	
	@Value("${variantyx.challenge.pubmed-base-url}")
	private String pubmedBaseUrl;
	
	@Value("${variantyx.challenge.omim-base-url}")
	private String omimBaseUrl;
	
	@Value("${variantyx.challenge.hgmd-base-url}")
	private String hgmdBaseUrl;
	
	@Autowired
	private ExternalArticleRepository externalArticleRepo;

	@Override
	public Collection<ExternalArticle> findAll() {
		return externalArticleRepo.findAll();
	}

	@Override
	public AbstractResponse getAbstract(String externalArticleId) {
		AbstractResponse abstractRes = new AbstractResponse();
		abstractRes.setExternalArticleId(externalArticleId);
		
		try {
			ExternalArticle article = getExternalArticle(externalArticleId);
			String baseUrl = (article.getType() == ArticleType.pubmed) ? pubmedBaseUrl : (article.getType() == ArticleType.pubmed) ? omimBaseUrl : hgmdBaseUrl;
			
			Document doc = Jsoup.connect(baseUrl + externalArticleId).get();
			Elements abstractEle = doc.select("#enc-abstract");
			
			String abstractText = abstractEle.isEmpty() ? "No abstract available" : abstractEle.text();
			abstractRes.setAbstractText(abstractText);
			
			return abstractRes;
		} catch(HttpStatusException e) {
			String errText = (e.getStatusCode() == 404) ? "This article could not be found." : "An unknown error has occured";
			abstractRes.setAbstractText(errText);
			return abstractRes;
		} catch (IOException e) {
			abstractRes.setAbstractText("An unknown error has occured");
			return abstractRes;
		}
	}

	@Override
	public ExternalArticle getExternalArticle(String externalArticleId) throws HttpStatusException {
		return externalArticleRepo.findById(externalArticleId).orElseThrow(() -> new HttpStatusException("This article could not be found.", 404, ""));
	}

}
