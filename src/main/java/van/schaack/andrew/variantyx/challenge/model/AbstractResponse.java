package van.schaack.andrew.variantyx.challenge.model;

public class AbstractResponse {

	private String externalArticleId;

	private String abstractText;

	public String getExternalArticleId() {
		return externalArticleId;
	}

	public void setExternalArticleId(String externalArticleId) {
		this.externalArticleId = externalArticleId;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

}
