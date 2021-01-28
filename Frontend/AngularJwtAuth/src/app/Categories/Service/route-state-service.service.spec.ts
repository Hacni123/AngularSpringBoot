import { TestBed } from '@angular/core/testing';

import { RouteStateServiceService } from './route-state-service.service';

describe('RouteStateServiceService', () => {
  let service: RouteStateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteStateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
