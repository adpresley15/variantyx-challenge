import { Component, OnInit } from '@angular/core';
import { ExternalArticle } from '../../model/external-article';
import { AbstractResponse } from '../../model/abstract-response';
import { ExternalArticleService } from '../../service/external-article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  articles: ExternalArticle[] = [];
  selectedAbstract: AbstractResponse = new AbstractResponse;
  
  constructor(private externalArticleService: ExternalArticleService) { }

  ngOnInit() {
	this.externalArticleService.findAll().subscribe(data => {
		this.articles = data;
	});
  }
  
  getAbstract(event: any) {
	this.externalArticleService.getAbstract(event.target.id).subscribe(data => {
		this.selectedAbstract = data;
	});
  }

}
