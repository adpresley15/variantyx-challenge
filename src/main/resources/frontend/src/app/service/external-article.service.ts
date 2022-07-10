import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExternalArticle } from '../model/external-article';
import { AbstractResponse } from '../model/abstract-response';
import { Observable } from 'rxjs-compat/Observable';

@Injectable()
export class ExternalArticleService {

  private apiBaseUrl: string;
  
  constructor(private http: HttpClient) { 
	this.apiBaseUrl = 'http://localhost:8080/api';
  }
  
  public findAll(): Observable<ExternalArticle[]> {
	return this.http.get<ExternalArticle[]>(`${this.apiBaseUrl}/external-articles`);	
  }
  
  public getAbstract(id: string): Observable<AbstractResponse> {
	return this.http.get<AbstractResponse>(`${this.apiBaseUrl}/external-articles/${id}/abstract`);
  }
  
}
