import { TestBed } from '@angular/core/testing';

import { TokenInterceptorServiceTsService } from './token-interceptor-service.ts.service';

describe('TokenInterceptorServiceTsService', () => {
  let service: TokenInterceptorServiceTsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TokenInterceptorServiceTsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
