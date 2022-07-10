package van.schaack.andrew.variantyx.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class ExternalArticle {

	@Id
	private String id;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private ArticleType type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArticleType getType() {
		return type;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

}
