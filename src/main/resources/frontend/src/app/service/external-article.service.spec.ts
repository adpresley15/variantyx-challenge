import { TestBed } from '@angular/core/testing';

import { ExternalArticleService } from './external-article.service';

describe('ExternalArticleService', () => {
  let service: ExternalArticleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExternalArticleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
